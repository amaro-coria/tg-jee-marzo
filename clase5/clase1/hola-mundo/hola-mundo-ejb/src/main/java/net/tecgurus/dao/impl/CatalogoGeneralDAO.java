package net.tecgurus.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import net.tecgurus.dao.CatalogoGeneralDAOLocal;
import net.tecgurus.entities.Catalogo_General;
import static net.tecgurus.util.QueryParameter.*;

/**
 * Session Bean implementation class CatalogoGeneralDAO
 */
@Stateless
public class CatalogoGeneralDAO extends GenericDAO<Catalogo_General> implements CatalogoGeneralDAOLocal {

	@Override
	public List<Catalogo_General> findCatalogosCuenta() {
		return findWithNamedQuery("Catalogo_General.findAccountTypes");
	}

}
