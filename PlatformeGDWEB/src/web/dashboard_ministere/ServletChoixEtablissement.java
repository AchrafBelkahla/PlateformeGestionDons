package web.dashboard_ministere;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Etablisement;
import metier.entities.Utilisateur;
import metier.session.PlatformGDImpl;
import metier.session.PlatformGDLocal;

/**
 * Servlet implementation for choix Etablissement 
 */
@WebServlet("/choixEtablissement")
public class ServletChoixEtablissement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal metier;

	public ServletChoixEtablissement() {
		metier = new PlatformGDImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("etablissements", metier.getAllEtablissement());
		request.getRequestDispatcher("Dashboard_ministere/choixEtablissment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id_etablissement = request.getParameter("nom_etab");
			Etablisement etablissement = metier.findetablissement(id_etablissement);
			List<Utilisateur> collection_utilisateur = new ArrayList<Utilisateur>();
			if(!etablissement.getUtilisateurs().isEmpty())
			{
				collection_utilisateur = etablissement.getUtilisateurs();
				request.setAttribute("utilisateur", collection_utilisateur.get(0));
				request.setAttribute("tel", collection_utilisateur.get(0).getTelephone().get(0));
				request.setAttribute("fax", collection_utilisateur.get(0).getTelephone().get(1));
			}
			else
			{
				request.setAttribute("utilisateur", null);
			}
			request.setAttribute("etablissement", etablissement);
			request.getRequestDispatcher("Dashboard_ministere/changerResponsable.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
