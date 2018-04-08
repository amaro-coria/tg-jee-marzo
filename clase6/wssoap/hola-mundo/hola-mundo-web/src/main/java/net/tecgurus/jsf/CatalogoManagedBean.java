package net.tecgurus.jsf;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.xml.crypto.Data;

import net.tecgurus.dao.CatalogoGeneralDAOLocal;
import net.tecgurus.entities.Catalogo_General;

@ManagedBean
public class CatalogoManagedBean implements Serializable{

	@EJB
	private CatalogoGeneralDAOLocal dao;
	private Catalogo_General elemento = new Catalogo_General();
	private Date fechaCreacion;
	private List<Catalogo_General> list;
	//Propiedades para nuevo catalogo
	private String codigo;
	private String descripcion;
	
	@PostConstruct
	private void init() {
		list = dao.findAll();
	}
	
	public String onDelete() {
		dao.delete(Catalogo_General.class, elemento.getIdCat());
		return "";
	}
	
	public String onEdit() {
		elemento.setFchMod(new Date());
		dao.update(elemento);
		addMessageToFront("El elemento se ha actualizado");
		updateElements();
		return "";
	}
	
	public String onSave() {
		Catalogo_General nuevoElemento = new Catalogo_General();
		nuevoElemento.setDscCorCat(codigo);
		nuevoElemento.setDscComCat(descripcion);
		nuevoElemento.setFchCre(new Date());
		Catalogo_General elementoGuardado = dao.create(nuevoElemento);
		codigo = "";
		descripcion = "";
		addMessageToFront("Se ha guardado el elemento!");
		addElements(elementoGuardado);
		return "";
	}
	
	private void addElements(Catalogo_General newElement) {
		//Primera forma
		list.add(newElement);
		//Segunda forma
		//list = dao.findAll();
	}
	
	private void updateElements() {
		list = dao.findAll();
	}
	
	private void addMessageToFront(String mensaje) {
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(mensaje));
	}
	
	public String onCancel() {
		codigo = "";
		descripcion = "";
		addMessageToFront("Se ha cancelado la accion");
		return "";
	}
	
	
	/////////////////////////////  Getters & Setters //////////////////////////

	public CatalogoGeneralDAOLocal getDao() {
		return dao;
	}

	public void setDao(CatalogoGeneralDAOLocal dao) {
		this.dao = dao;
	}

	public List<Catalogo_General> getList() {
		return list;
	}

	public void setList(List<Catalogo_General> list) {
		this.list = list;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Catalogo_General getElemento() {
		return elemento;
	}

	public void setElemento(Catalogo_General elemento) {
		this.elemento = elemento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	


}