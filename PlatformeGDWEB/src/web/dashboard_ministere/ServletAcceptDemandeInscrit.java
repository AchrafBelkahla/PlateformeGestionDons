package web.dashboard_ministere;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;

@WebServlet("/accepter_inscrit")
public class ServletAcceptDemandeInscrit extends HttpServlet {
	@EJB
	private PlatformGDLocal metier;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id_utilisateur = (String) req.getParameter("code");
			Utilisateur utilisateur = metier.findUtilisateurById(id_utilisateur);
			utilisateur.setAccepted(true);
			metier.updateUtilisateur(utilisateur);
		} catch (Exception e) {
			// TODO: handle exception
		}
		req.setAttribute("etablissements", metier.getAllEtablissement());
		req.getRequestDispatcher("Dashboard_ministere/Listes_demandes_inscrit.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("etablissements", metier.getAllEtablissement());
		req.getRequestDispatcher("Dashboard_ministere/Listes_demandes_inscrit.jsp").forward(req, resp);
	}
}
