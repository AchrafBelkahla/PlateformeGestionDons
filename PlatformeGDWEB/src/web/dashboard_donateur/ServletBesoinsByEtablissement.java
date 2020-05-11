package web.dashboard_donateur;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Etablisement;
import metier.session.PlatformGDLocal;

@WebServlet(urlPatterns = { "/besoinsByEtablissement" })
public class ServletBesoinsByEtablissement extends HttpServlet{
	
	@EJB
	private PlatformGDLocal metier;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Etablisement> etablissements = metier.getAllEtablissement();
		req.setAttribute("etablissements", metier.getAllEtablissement());

		req.getRequestDispatcher("Dashboard_donateur/besoinsByEtablissement.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}