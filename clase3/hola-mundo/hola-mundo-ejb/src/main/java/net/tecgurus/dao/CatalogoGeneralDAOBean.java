package net.tecgurus.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.tecgurus.entities.Catalogo_General;

/**
 * Session Bean implementation class CatalogoGeneralDAOBean
 */
@Stateless
@LocalBean
public class CatalogoGeneralDAOBean {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public CatalogoGeneralDAOBean() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Catalogo_General> findAll(){
    	//Query queryNativo = em.createNativeQuery("SELECT * FROM Catalogo_General");
    	//List<Catalogo_General> listaNativa = (List<Catalogo_General>) queryNativo.getResultList();
    	//Query queryJPA = em.createQuery("FROM Catalogo_General");
    	Query queryNombrado = em.createNamedQuery("Catalogo_General.findAll");
    	return queryNombrado.getResultList();
    }
    
    public void saveCatalogoGeneral(Catalogo_General entidad) {
    	em.persist(entidad);
    }
    
    public void updateCatalogo(Catalogo_General entidad) {
    	em.merge(entidad);
    }
    
    public void deleteCatalogo(Integer idCatalogoGeneral) {
    	Catalogo_General aBorrar = em.find(Catalogo_General.class, idCatalogoGeneral);
    	em.remove(aBorrar);
    }
    

}
