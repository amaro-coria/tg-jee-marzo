package net.tecgurus.dao;

import java.util.List;

import javax.ejb.Local;

import net.tecgurus.entities.Catalogo_General;

@Local
public interface 
CatalogoGeneralDAOLocal 
	extends 
	GenericDAOLocal
	<Catalogo_General>{
		
		List<Catalogo_General> findCatalogosCuenta();

}
