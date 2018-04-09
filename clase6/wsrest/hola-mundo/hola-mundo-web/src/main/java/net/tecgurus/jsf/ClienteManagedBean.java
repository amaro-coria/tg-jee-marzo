package net.tecgurus.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.tecgurus.UtilMsgs;
import net.tecgurus.dao.CatalogoGeneralDAOLocal;
import net.tecgurus.dao.ClienteDAOLocal;
import net.tecgurus.entities.Catalogo_General;
import net.tecgurus.entities.Cliente;

@ManagedBean
@ViewScoped
public class ClienteManagedBean extends GenericMB {

	private List<Cliente> list;
	private Cliente currentItem;
	@EJB
	private ClienteDAOLocal daoCliente;
	@EJB
	private CatalogoGeneralDAOLocal daoCatalogo;
	private List<Catalogo_General> listCatalogo;
	private static final Logger log = LoggerFactory.getLogger(ClienteManagedBean.class);
	private String input_new_name;
	private String input_new_surname;
	private String input_new_surnameLast;
	private String input_new_address;
	private String input_new_tel;
	private Integer input_new_status;
	private Integer input_current_filter;

	@PostConstruct
	private void init() {
		initClientes();
		initListCatalogo();
	}

	public void syncDataFromWS() {
		try {
			List<Cliente> remoteList = daoCliente.findAll();
			int remoteSize = remoteList.size();
			int actualSize = list.size();
			if (remoteSize != actualSize) {
				list = remoteList;
				super.addInfoMessage(UtilMsgs.SUCESS_REMOTE_UPDATE);
			}
		} catch (Exception e) {
			log.error("Error updating from back : {}", e.getMessage());
			log.error("Trace: ", e);
			super.addErrorMessage(UtilMsgs.ERROR_REMOTE_UPDATE);
		}
	}

	private void initListCatalogo() {
		try {
			listCatalogo = daoCatalogo.findCatalogosCuenta();
		} catch (Exception e) {
			log.error("Error getting account types, trace:", e);
			super.addInfoMessage(UtilMsgs.ERROR_INIT_LIST);
		}
	}

	private void initClientes() {
		try {
			list = daoCliente.findAll();
		} catch (Exception e) {
			log.error("Unable to retireve customers list: {}", e.getMessage());
			log.error("Trace: {}", e);
			super.addErrorMessage(UtilMsgs.ERROR_INIT_LIST);
		}
	}

	public String onSave() {
		Cliente cliente = new Cliente();
		cliente.setApeMatCte(input_new_surnameLast);
		cliente.setApePatCte(input_new_surname);
		cliente.setNomCte(input_new_name);
		cliente.setDirCte(input_new_address);
		cliente.setTelCte(input_new_tel);
		Catalogo_General estadoCliente = new Catalogo_General();
		estadoCliente.setIdCat(input_new_status);
		cliente.setEstadoCliente(estadoCliente);
		try {
			daoCliente.create(cliente);
			super.addInfoMessage(UtilMsgs.SUCCESS_SAVE);
		} catch (Exception e) {
			log.error("Unable to save element: {}", cliente);
			log.error("Trace: ", e);
			super.addErrorMessage(UtilMsgs.ERROR_SAVE);
		}
		cleanInputs();
		syncList();
		return "";
	}

	public void filter() {
		try {
			if (input_current_filter == null || input_current_filter.equals(0)) {
				list = daoCliente.findAll();
			} else {
				list = daoCliente.getFiltered(input_current_filter);
			}
		} catch (Exception e) {
			log.error("Unable to retrieve elements: {}", input_current_filter);
			log.error("Trace: ", e);
			super.addErrorMessage(UtilMsgs.ERROR_INIT_LIST);
		}
	}

	public String onEdit() {
		try {
			daoCliente.update(currentItem);
			super.addInfoMessage(UtilMsgs.SUCCESS_UPDATE);
		} catch (Exception e) {
			log.error("Error updating element: {}", currentItem);
			log.error("Trace : ", e);
			super.addErrorMessage(UtilMsgs.ERROR_UPDATE);
		}
		cleanInputs();
		syncList();
		return "";
	}

	public String onDelete() {
		try {
			daoCliente.delete(Cliente.class, currentItem.getIdCte());
			super.addInfoMessage(UtilMsgs.SUCCESS_DELETE);
		} catch (Exception e) {
			log.error("Unable to delete: {}", currentItem);
			log.error("Trace: ", e);
			super.addErrorMessage(UtilMsgs.ERROR_DELETE);
		}
		cleanInputs();
		syncList();
		return "";
	}

	public String onCancel() {
		cleanInputs();
		super.addInfoMessage(UtilMsgs.ACTION_CANCEL);
		return "";
	}

	private void syncList() {
		initClientes();
	}

	private void cleanInputs() {
		input_new_name = "";
		input_new_surname = "";
		input_new_surnameLast = "";
		input_new_address = "";
		input_new_tel = "";
		input_new_status = 1;
	}

	// Getters & Setters

	public List<Cliente> getList() {
		return list;
	}

	public void setList(List<Cliente> list) {
		this.list = list;
	}

	public Cliente getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(Cliente currentItem) {
		this.currentItem = currentItem;
	}

	public ClienteDAOLocal getDaoCliente() {
		return daoCliente;
	}

	public void setDaoCliente(ClienteDAOLocal daoCliente) {
		this.daoCliente = daoCliente;
	}

	public String getInput_new_name() {
		return input_new_name;
	}

	public void setInput_new_name(String input_new_name) {
		this.input_new_name = input_new_name;
	}

	public String getInput_new_surname() {
		return input_new_surname;
	}

	public void setInput_new_surname(String input_new_surname) {
		this.input_new_surname = input_new_surname;
	}

	public String getInput_new_surnameLast() {
		return input_new_surnameLast;
	}

	public void setInput_new_surnameLast(String input_new_surnameLast) {
		this.input_new_surnameLast = input_new_surnameLast;
	}

	public String getInput_new_address() {
		return input_new_address;
	}

	public void setInput_new_address(String input_new_address) {
		this.input_new_address = input_new_address;
	}

	public String getInput_new_tel() {
		return input_new_tel;
	}

	public void setInput_new_tel(String input_new_tel) {
		this.input_new_tel = input_new_tel;
	}

	public Integer getInput_new_status() {
		return input_new_status;
	}

	public void setInput_new_status(Integer input_new_status) {
		this.input_new_status = input_new_status;
	}

	public CatalogoGeneralDAOLocal getDaoCatalogo() {
		return daoCatalogo;
	}

	public void setDaoCatalogo(CatalogoGeneralDAOLocal daoCatalogo) {
		this.daoCatalogo = daoCatalogo;
	}

	public List<Catalogo_General> getListCatalogo() {
		return listCatalogo;
	}

	public void setListCatalogo(List<Catalogo_General> listCatalogo) {
		this.listCatalogo = listCatalogo;
	}

	public Integer getInput_current_filter() {
		return input_current_filter;
	}

	public void setInput_current_filter(Integer input_current_filter) {
		this.input_current_filter = input_current_filter;
	}

}