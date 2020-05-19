package web.dashboard_ministere;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Produit;
import metier.session.PlatformGDLocal;


@WebServlet("/ajoutBesoinMinistere")
public class ServletAjoutBesoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	

	
	
	public ServletAjoutBesoin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{		
		request.setAttribute("etablissements", dao.getAllEtablissement());
			
		List<Produit> produits = dao.getAllProduit();
		request.setAttribute("produits", produits);
		request.getRequestDispatcher("Dashboard_ministere/ajoutBesoin_ministere.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
