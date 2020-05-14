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

@WebServlet("/Liste_Donnateurs_Drs")
public class ServletListeDonnateurs extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		String gouvernorat = user.getEtablissement().getAdresse().getGouvernorat();
		
		req.setAttribute("don_en_nature", dao.getAllDonsEnNatureByGouvernorat(gouvernorat));
		req.setAttribute("reglement", dao.getAllDonsReglementsByGouvernorat(gouvernorat));
		req.getRequestDispatcher("Dashboard_drs/ListeDonnateurs_drs.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
