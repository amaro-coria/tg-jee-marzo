package net.tecgurus.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tecgurus.dao.CatalogoGeneralDAOBean;
import net.tecgurus.dao.DAOEjemploLocal;
import net.tecgurus.entities.Catalogo_General;

/**
 * Servlet implementation class EjemploServlet
 */
public class EjemploServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EjemploServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @EJB  //@Inject
    private DAOEjemploLocal dao;
    @EJB
    private CatalogoGeneralDAOBean daoCatalogoGeneral;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String saludoDesdeEJB = dao.saluda();
		List<Catalogo_General> listaNativa = daoCatalogoGeneral.findAll();
		StringBuilder sb = new StringBuilder();
		listaNativa.forEach(c -> sb.append(c.getDscCorCat()));
		response.getWriter().append("Saludo desde: ").append(saludoDesdeEJB).append("Valores desde la BD: ").append(sb.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
