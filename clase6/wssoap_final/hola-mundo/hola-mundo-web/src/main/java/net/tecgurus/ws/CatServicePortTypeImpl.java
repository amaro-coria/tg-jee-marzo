package net.tecgurus.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.tecgurus.catservice._1.BajaDatosResponseDummy;
import net.tecgurus.catservice._1.CatGralAltaRequest;
import net.tecgurus.catservice._1.CatGralAltaResponse;
import net.tecgurus.catservice._1.CatGralBajaRequest;
import net.tecgurus.catservice._1.CatGralBajaResponse;
import net.tecgurus.catservice._1.CatGralData;
import net.tecgurus.catservice._1.CatGralModiRequest;
import net.tecgurus.catservice._1.CatGralModiResponse;
import net.tecgurus.catservice._1.CatGralRequest;
import net.tecgurus.catservice._1.CatGralResponse;
import net.tecgurus.catservice._1.CatServicePortType;
import net.tecgurus.catservice._1.StatusResponse;
import net.tecgurus.dao.CatalogoGeneralDAOLocal;
import net.tecgurus.entities.Catalogo_General;

@WebService(
	serviceName = "catService", 
	endpointInterface = "net.tecgurus.catservice._1.CatServicePortType", 
	targetNamespace = "http://www.tecgurus.net/catService/1.0")
public class CatServicePortTypeImpl implements CatServicePortType{

	@EJB
	private CatalogoGeneralDAOLocal daoCatGral;
	private static final Logger log = LoggerFactory.getLogger(CatServicePortTypeImpl.class);
	
	@Override
	public CatGralResponse listarCatalogoOperation(CatGralRequest catGralRequest) {
		//0 Declarar objeto de respuesta
		CatGralResponse response = new CatGralResponse();
		//1 Obtener listado de la base de datos
		List<Catalogo_General> list = daoCatGral.findAll();
		//2 Transformar y agregar a tipos de salida
		for(Catalogo_General catalogo : list) {
			CatGralData innerXMLType = new CatGralData();
			innerXMLType.setDescComp(catalogo.getDscComCat());
			innerXMLType.setDescCort(catalogo.getDscCorCat());
			innerXMLType.setIdCat(catalogo.getIdCat());
			innerXMLType.setIdEstCat(1);
			response.getCatGralInfo().add(innerXMLType);
		}
		//3 Agregar un statusResponse
		StatusResponse statusResponse = new StatusResponse();
		statusResponse.setStatus("OK");
		response.setStatus(statusResponse);
		return response;
	}

	@Override
	public CatGralAltaResponse altaCatalogoOperation(CatGralAltaRequest catGralAltaRequest) {
		//Declarar objeto de respuesta
		CatGralAltaResponse response = new CatGralAltaResponse();
		StatusResponse response2 = new StatusResponse();
		// Obtener referencia a objeto interno
		CatGralData dataXML = catGralAltaRequest.getCataData();
		//Transformarlo a objeto entidad JPA
		Catalogo_General catalogo = new Catalogo_General();
		catalogo.setDscComCat(dataXML.getDescComp());
		catalogo.setDscCorCat(dataXML.getDescCort());
		catalogo.setIdEstCat(1);
		try{
			daoCatGral.create(catalogo);
			response2.setStatus("OK");
		}catch(Exception e) {
			log.error("Error in creating from ws: {}", e.getMessage());
			log.error("Trace: ",e);
			response2.setStatus("ERROR");
		}
		response.setStatus(response2);
		return response;
	}

	@Override
	public CatGralModiResponse modificacionCatalogoOperation(CatGralModiRequest catGralModiRequest) {
		// Declarar objeto de respuesta
		CatGralModiResponse response = new CatGralModiResponse();
		StatusResponse statusResponse = new StatusResponse();
		//Obtener data XML
		CatGralData dataXML = catGralModiRequest.getCataData();
		//Obtener referencia objeto entidad JPA
		Catalogo_General catalogo = 
				daoCatGral.find(Catalogo_General.class, dataXML.getIdCat());
		//Modificar propiedades
		catalogo.setDscComCat(dataXML.getDescComp());
		catalogo.setDscCorCat(dataXML.getDescCort());
		//Enviar actualizacion a BD
		try {
			daoCatGral.update(catalogo);
			statusResponse.setStatus("OK");
		}catch(Exception e) {
			log.error("Error updating from ws: {}", e.getMessage());
			log.error("Trace:" , e);
			statusResponse.setStatus("ERROR");
		}
		response.setStatus(statusResponse);
		return response;
	}

	@Override
	public CatGralBajaResponse bajaCatalogoOperatioon(CatGralBajaRequest catGralBajaRequest) {
		// Declarar objeto respuesta
		CatGralBajaResponse response = new CatGralBajaResponse();
		BajaDatosResponseDummy dummy = new BajaDatosResponseDummy();
		//Obtener referencia
		Integer idToDelete = catGralBajaRequest.getDataDummy().getIdDummy().intValue();
		String reason = catGralBajaRequest.getDataDummy().getReason();
		if(reason.trim().toUpperCase().equals("TECGURUS")) {
			try{
				daoCatGral.delete(Catalogo_General.class, idToDelete);
				dummy.setOutput("OK");
			}catch(Exception e) {
				log.error("Error deleting: {}", e.getMessage());
				log.error("Trace: ", e);
				dummy.setOutput("ERROR");
			}
		}else {
			dummy.setOutput("NO VALID REASON");
		}
		response.setResponseDummy(dummy);
		return response;
	}

	public CatalogoGeneralDAOLocal getDaoCatGral() {
		return daoCatGral;
	}

	public void setDaoCatGral(CatalogoGeneralDAOLocal daoCatGral) {
		this.daoCatGral = daoCatGral;
	}

}
