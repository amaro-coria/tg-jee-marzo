package net.tecgurus.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface GenericDAOLocal<T> {
	
	 T create(T t);
	 T find(Class type,Object id);
	 T update(T t);
	 void delete(Class type,Object id);
	 List<T> findWithNamedQuery(String queryName);
	 List<T> findWithNamedQuery(String queryName,int resultLimit);
	 List<T> findWithNamedQuery(String namedQueryName, Map parameters);
	 List<T> findWithNamedQuery(String namedQueryName, Map parameters,int resultLimit);
	 //Nuestro primer metodo generico
	 List<T> findAll();

}
