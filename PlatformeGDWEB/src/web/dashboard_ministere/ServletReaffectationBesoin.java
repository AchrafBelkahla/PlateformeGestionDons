package web.dashboard_ministere;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Besoin;
import metier.session.PlatformGDLocal;

@WebServlet(urlPatterns = "/Reaffecte_un_besoin")
public class ServletReaffectationBesoin extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	
	public ServletReaffectationBesoin() {
		super();	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id_besoin = (String) req.getParameter("id_besoin");
		Besoin besoin = dao.getBesoinById(id_besoin);
		String nom_etab = (String) req.getParameter("nometablissement");
		String motif = (String) req.getParameter("motif");
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		System.out.println(id_besoin);
		System.out.println(nom_etab);
		System.out.println(motif);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id_besoin = (String) req.getParameter("id_besoin");
		Besoin besoin = dao.getBesoinById(id_besoin);
		String nom_etab = (String) req.getParameter("nometablissement");
		String motif = (String) req.getParameter("motif");
		System.out.println(id_besoin);
		System.out.println(nom_etab);
		System.out.println(motif);
	}
}
