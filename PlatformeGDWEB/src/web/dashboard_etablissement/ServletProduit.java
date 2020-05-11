package web.dashboard_etablissement;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Categorie;
import metier.entities.Fournisseur;
import metier.entities.Produit;
import metier.entities.UniteDeMesure;
import metier.session.PlatformGDLocal;



@WebServlet("/produit")
public class ServletProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	
	public ServletProduit() {
		super();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idProduit = request.getParameter("idProduit");
		
		
		Produit produit = dao.getProduitById(idProduit);
		
		if(produit != null) 
		{
		request.setAttribute("produit",produit);
		List<Fournisseur> fournisseurs = dao.getFournisseurByProduit(produit.getIdProduit());
		
//		System.out.println("***********************");
//		System.out.println("***********************");
//		System.out.println("***********************");
//		System.out.println(fournisseurs.toString());
//		System.out.println(fournisseurs.size());
//		System.out.println("***********************");
//		System.out.println("***********************");
//		System.out.println("***********************");
		
		
		request.setAttribute("fournisseurs",fournisseurs);
		request.getRequestDispatcher("Dashboard_etablissement/produit.jsp").forward(request,response);
		}
		else {
			request.getRequestDispatcher("Dashboard_etablissement/404Produit.jsp").forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}
	
	
}
