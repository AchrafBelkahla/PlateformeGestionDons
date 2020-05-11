package web.dashboard_ministere;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Telephone;
import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;

@WebServlet("/supprimer_inscrit")
public class ServletSupprimerDemandeInscrit extends HttpServlet {
	@EJB
	private PlatformGDLocal metier;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id_utilisateur = (String) req.getParameter("code");
		Utilisateur utilisateur = metier.findUtilisateurById(id_utilisateur);
		Collection<Telephone> liste_telephones = utilisateur.getTelephone();
		metier.deleteUtilisateur(utilisateur);
		for(Telephone tel : liste_telephones) {
			metier.deletetelephone(tel);
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
