package net.tecgurus.dao;

import java.util.List;

import javax.ejb.Local;

import net.tecgurus.entities.Cliente;

@Local
public interface ClienteDAOLocal extends GenericDAOLocal<Cliente> {

	List<Cliente> getFiltered(Integer idCat);

}