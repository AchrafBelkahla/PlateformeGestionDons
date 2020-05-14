package web.dashboard_drs;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.entities.Produit;
import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;


@WebServlet("/ajoutBesoinDrs")
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
		HttpSession session = request.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		String gouvernorat = user.getEtablissement().getAdresse().getGouvernorat();
		request.setAttribute("etablissements", dao.getEtablissementsByGouvernorat(gouvernorat));
			
		List<Produit> produits = dao.getAllProduit();
		request.setAttribute("produits", produits);
		request.getRequestDispatcher("Dashboard_drs/ajoutBesoin_drs.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
