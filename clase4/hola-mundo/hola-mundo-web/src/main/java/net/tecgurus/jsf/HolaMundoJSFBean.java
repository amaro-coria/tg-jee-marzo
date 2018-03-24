package net.tecgurus.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import net.tecgurus.dao.CatalogoGeneralDAOBean;
import net.tecgurus.entities.Catalogo_General;

@ManagedBean
public class HolaMundoJSFBean {
	
	@EJB
    private CatalogoGeneralDAOBean daoCatalogoGeneral;

	private String saludo = "Hola mundo JSF!";
	private String saludo2;
	private List<Catalogo_General> list;
	
	@PostConstruct
	private void metodoPostconstruccion() {
		try{
			list = daoCatalogoGeneral.findAll();
		}catch(Exception e) {
			//TODO hacer algo al respecto
			list = new ArrayList<>();
		}
	}

	//Metodos de negocio
	
	public String irHaciaCatalogos() {
		return "catalogos";
	}
	
	
	// Getters & Setters 
	
	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public CatalogoGeneralDAOBean getDaoCatalogoGeneral() {
		return daoCatalogoGeneral;
	}

	public void setDaoCatalogoGeneral(CatalogoGeneralDAOBean daoCatalogoGeneral) {
		this.daoCatalogoGeneral = daoCatalogoGeneral;
	}

	public String getSaludo2() {
		List<Catalogo_General> listaNativa = daoCatalogoGeneral.findAll();
		StringBuilder sb = new StringBuilder();
		listaNativa.forEach(c -> sb.append(c.getDscCorCat()));
		return sb.toString();
	}

	public void setSaludo2(String saludo2) {
		this.saludo2 = saludo2;
	}

	public List<Catalogo_General> getList() {
		return list;
	}

	public void setList(List<Catalogo_General> list) {
		this.list = list;
	}
	
	
	
	
}
