package net.tecgurus.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.tecgurus.dao.GenericDAOLocal;


/**
 * Session Bean implementation class GenericDAO
 */
@Stateless
public class GenericDAO<T> implements GenericDAOLocal<T> {

    @PersistenceContext
    EntityManager em;
    
    public  T create(T t) {
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }

    @SuppressWarnings("unchecked")
    public  T find(Class type,Object id) {
       return (T) this.em.find(type, id);
    }

    public void delete(Class type,Object id) {
       Object ref = this.em.getReference(type, id);
       this.em.remove(ref);
    }

    public  T update(T t) {
        return (T)this.em.merge(t);
    }

    public List findWithNamedQuery(String namedQueryName){
        return this.em.createNamedQuery(namedQueryName).getResultList();
    }
    
    public List findWithNamedQuery(String namedQueryName, Map parameters){
        return findWithNamedQuery(namedQueryName, parameters, 0);
    }

    public List findWithNamedQuery(String queryName, int resultLimit) {
        return this.em.createNamedQuery(queryName).
                setMaxResults(resultLimit).
                getResultList();    
    }

    public List findByNativeQuery(String sql, Class type) {
        return this.em.createNativeQuery(sql, type).getResultList();
    }
    
   public List findWithNamedQuery(String namedQueryName, Map parameters,int resultLimit){
        Set rawParameters = parameters.entrySet();
        Query query = this.em.createNamedQuery(namedQueryName);
        if(resultLimit > 0)
            query.setMaxResults(resultLimit);
        for (Object entry : rawParameters) {
            query.setParameter((String) entry, parameters.get(entry));
        }
        return query.getResultList();
    }

   @Override
	public List<T> findAll() {
	// TODO Auto-generated method stub
	   String nombreDelQueryNombrado = getClassName() + ".findAll";
	   return findWithNamedQuery(nombreDelQueryNombrado);
	}
   
   public String getClassName() {
	   Class clazz = (Class<T>) ((ParameterizedType) getClass()
               .getGenericSuperclass()).getActualTypeArguments()[0];
	   return clazz.getSimpleName();
   }
   
}
