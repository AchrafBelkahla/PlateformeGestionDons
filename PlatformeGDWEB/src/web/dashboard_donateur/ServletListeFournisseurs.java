package web.dashboard_donateur;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Fournisseur;
import metier.session.PlatformGDLocal;
import web.GlobalConfig;
@WebServlet("/Liste_Fournisseurs_donateur")
public class ServletListeFournisseurs extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	
	public ServletListeFournisseurs() {
		super();
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int currentPage = Integer.valueOf(req.getParameter("currentPage"));
		List<Fournisseur> fournisseurs = dao.getAllFournisseur(currentPage,GlobalConfig.recordsPerPage);
        int rows = (int) dao.getNumberOfRows("Fournisseur");
        int nOfPages = rows / GlobalConfig.recordsPerPage;
        
        if (nOfPages % GlobalConfig.recordsPerPage > 0) {
            nOfPages++;
        }
        
        req.setAttribute("noOfPages", nOfPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("recordsPerPage", GlobalConfig.recordsPerPage);
		req.setAttribute("fournisseurs", fournisseurs);
		req.getRequestDispatcher("Dashboard_donateur/ListeFournisseurs.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
