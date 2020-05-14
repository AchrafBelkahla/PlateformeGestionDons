package web.dashboard_drs;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Fournisseur;
import metier.session.PlatformGDLocal;

@WebServlet("/Liste_Fournisseurs_Drs")
public class ServletListeFournisseurs extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	
	public ServletListeFournisseurs() {
		super();
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("fournisseurs", dao.getAllFournisseur());
		req.getRequestDispatcher("Dashboard_drs/ListeFournisseurs_drs.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
//	@Override
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String idFournisseur = req.getParameter("id");
//		Fournisseur fournisseur = dao.getFournisseurById(idFournisseur);
//		dao.deleteFournisseur(fournisseur);
//		resp.getWriter().println(true);
//	}
}
