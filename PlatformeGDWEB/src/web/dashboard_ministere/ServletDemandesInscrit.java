package web.dashboard_ministere;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Etablisement;
import metier.session.PlatformGDLocal;


@WebServlet("/Demandes_inscrit")
public class ServletDemandesInscrit extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PlatformGDLocal metier;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("etablissements", metier.getAllEtablissement());
		req.getRequestDispatcher("Dashboard_ministere/Listes_demandes_inscrit.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
