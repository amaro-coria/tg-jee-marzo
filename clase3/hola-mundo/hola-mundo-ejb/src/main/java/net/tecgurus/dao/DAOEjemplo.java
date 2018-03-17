package net.tecgurus.dao;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class DAOEjemplo
 */
@Stateless
public class DAOEjemplo implements DAOEjemploLocal {

	@Override
    public String saluda(){
    	return "Hola mundo desde EJB";
    }

}
