package web.dashboard_donateur;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Besoin;
import metier.entities.Etablisement;
import metier.session.PlatformGDLocal;
import web.GlobalConfig;

@WebServlet(urlPatterns = { "/besoinsByEtablissement" })
public class ServletBesoinsByEtablissement extends HttpServlet{
	
	@EJB
	private PlatformGDLocal metier;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//List<Etablisement> etablissements = metier.getAllEtablissement();
		//req.setAttribute("etablissements", metier.getAllEtablissement());

		//req.getRequestDispatcher("Dashboard_donateur/besoinsByEtablissement.jsp").forward(req, resp);
		
		int currentPage = Integer.valueOf(req.getParameter("currentPage"));
		List<Etablisement> etablissements = metier.getAllEtablissement(currentPage,GlobalConfig.recordsPerPage);
        int rows = (int) etablissements.size();
        int nOfPages = rows / GlobalConfig.recordsPerPage;
        
        if (nOfPages % GlobalConfig.recordsPerPage > 0) {
            nOfPages++;
        }
        
        req.setAttribute("noOfPages", nOfPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("recordsPerPage", GlobalConfig.recordsPerPage);
		req.setAttribute("etablissements", etablissements);
		req.getRequestDispatcher("Dashboard_donateur/besoinsByEtablissement.jsp").forward(req,resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}