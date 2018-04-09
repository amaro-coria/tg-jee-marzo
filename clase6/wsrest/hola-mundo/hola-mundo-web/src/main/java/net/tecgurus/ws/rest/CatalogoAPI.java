package net.tecgurus.ws.rest;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import net.tecgurus.dao.CatalogoGeneralDAOLocal;
import net.tecgurus.entities.Catalogo_General;

@Stateless
@LocalBean
@Path("/catalogo")
public class CatalogoAPI {
	
	@EJB
	private CatalogoGeneralDAOLocal daoCatalogo;
	
	@GET
	@Path("/hello")
	public String helloWorld() {
		return "Hola mundo";
	}
	
	@GET
	@Path("/catalogo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Integer id) {
		Catalogo_General catalogo = daoCatalogo.find(Catalogo_General.class, id);
		if(catalogo == null) {
			return Response.status(Status.NOT_FOUND).build();
		}else {
			JSONObject c = new JSONObject();
			c.put("id", catalogo.getIdCat());
			c.put("codigo", catalogo.getDscCorCat());
			c.put("descripcion", catalogo.getDscComCat());
			return Response.ok(c.toString()).build();
		}
	}
	

	
}
