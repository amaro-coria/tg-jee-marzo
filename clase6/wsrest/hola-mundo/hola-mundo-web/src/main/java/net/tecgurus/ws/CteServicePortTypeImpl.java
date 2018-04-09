package net.tecgurus.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.tecgurus.cteservice._1.ClienteAltaRequest;
import net.tecgurus.cteservice._1.ClienteAltaResponse;
import net.tecgurus.cteservice._1.ClienteData;
import net.tecgurus.cteservice._1.ClienteRequest;
import net.tecgurus.cteservice._1.ClienteResponse;
import net.tecgurus.cteservice._1.CteServicePortType;
import net.tecgurus.cteservice._1.SalidaEstatus;
import net.tecgurus.dao.ClienteDAOLocal;
import net.tecgurus.entities.Catalogo_General;
import net.tecgurus.entities.Cliente;

@WebService(
		serviceName = "cteService", 
		endpointInterface = "net.tecgurus.cteservice._1.CteServicePortType", 
		targetNamespace = "http://www.tecgurus.net/cteService/1.0")
public class CteServicePortTypeImpl implements CteServicePortType{

	@EJB
	private ClienteDAOLocal daoCte;
	
	private static final Logger log = LoggerFactory.getLogger(CteServicePortTypeImpl.class);
	
	@Override
	public ClienteResponse listarClientesOperation(ClienteRequest cteRequest) {
		ClienteResponse response = new ClienteResponse();
		List<Cliente> listClientes = daoCte.findAll();
		listClientes.forEach
			(c -> response.getResponseData().add(transform(c)));
		return response;
	}

	public ClienteDAOLocal getDaoCte() {
		return daoCte;
	}

	public void setDaoCte(ClienteDAOLocal daoCte) {
		this.daoCte = daoCte;
	}
	
	private ClienteData transform(Cliente cliente) {
		ClienteData cteData = new ClienteData();
		cteData.setName(cliente.getNomCte());
		cteData.setSurname(cliente.getApePatCte());
		cteData.setSurnameLast(cliente.getApeMatCte());
		cteData.setId(cliente.getIdCte());
		cteData.setType(cliente.getEstadoCliente().getIdCat());
		return cteData;
	}
	
	private Cliente transform(ClienteData data) {
		Cliente cliente = new Cliente();
		cliente.setNomCte(data.getName());
		cliente.setApePatCte(data.getSurname());
		cliente.setApeMatCte(data.getSurnameLast());
		Catalogo_General estadoCliente = new Catalogo_General();
		estadoCliente.setIdCat(data.getType());
		cliente.setEstadoCliente(estadoCliente);
		return cliente;
	}
	
	private boolean addToDB(Cliente cliente) {
		try {
			daoCte.create(cliente);
			return true;
		}catch(Exception e) {
			log.error("Unable to save cte: {}", e.getMessage());
			log.error("Trace:" , e);
			return false;
		}
	}

	@Override
	public ClienteAltaResponse altaOperation(ClienteAltaRequest altaRequest) {
		ClienteAltaResponse response = new ClienteAltaResponse();
		SalidaEstatus status = new SalidaEstatus();
		List<Cliente> listClientesToAddd = altaRequest.getRequestData()
				.stream()
				.map(c -> transform(c)).collect(Collectors.toList());
		List<Boolean> resultsList = new ArrayList<>();
		listClientesToAddd.forEach(c -> resultsList.add(addToDB(c)));
		int totalErrors = resultsList.stream().mapToInt(r -> r == false ? 1 : 0).sum();
		if(totalErrors > 0) {
			status.setStatus("ERROR");
			status.setCode(String.valueOf(totalErrors));
		}else {
			status.setStatus("OK");
			status.setCode("00");
		}
		response.setResponseData(status);
		return response;
	}
	

}
