package web.dashboard_drs;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;

@WebServlet(urlPatterns = {"/Liste_Dons_Drs"})
public class ServletListeDons extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@EJB
	private PlatformGDLocal metier;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Dashboard_drs/ListesDons_drs.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		String gouvernorat = user.getEtablissement().getAdresse().getGouvernorat();
		String action = req.getParameter("action");
		
		if (action.equals("Voir tous les dons en nature")) {
			req.setAttribute("don_en_nature", metier.getAllDonsEnNatureByGouvernorat(gouvernorat));
			doGet(req, resp);
		} else if (action.equals("Voir tous les reglements")){
			req.setAttribute("reglement", metier.getAllDonsReglementsByGouvernorat(gouvernorat));
			doGet(req, resp);
		} 
	}
}
