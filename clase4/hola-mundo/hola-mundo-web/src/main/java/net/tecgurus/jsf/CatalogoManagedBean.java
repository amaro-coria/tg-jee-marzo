package net.tecgurus.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import net.tecgurus.dao.CatalogoGeneralDAOLocal;
import net.tecgurus.entities.Catalogo_General;

@ManagedBean
public class CatalogoManagedBean implements Serializable{

	@EJB
	private CatalogoGeneralDAOLocal dao;
	
	private List<Catalogo_General> list;
	
	@PostConstruct
	private void init() {
		list = dao.findAll();
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
	
	


}