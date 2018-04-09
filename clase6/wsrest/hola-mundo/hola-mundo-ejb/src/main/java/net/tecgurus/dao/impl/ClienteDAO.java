package net.tecgurus.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import net.tecgurus.dao.ClienteDAOLocal;
import net.tecgurus.entities.Cliente;

@Stateless
public class ClienteDAO extends GenericDAO<Cliente> implements ClienteDAOLocal {

	@Override
	public List<Cliente> getFiltered(Integer idCat) {
		Query query =  super.em.createNamedQuery("Cliente.findFiltered");
		query.setParameter("idCat", idCat);
		return query.getResultList();
	}
}
