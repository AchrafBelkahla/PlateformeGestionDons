package web.dashboard_ministere;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Don;
import metier.entities.DonEnNature;
import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;
import web.GlobalConfig;

@WebServlet(urlPatterns = {"/Liste_Dons"})
public class ServletListeDons extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@EJB
	private PlatformGDLocal metier;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Dashboard_ministere/ListesDons.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if (action.equals("Voir tous les dons en nature")) 
		{
			
//			int currentPage = Integer.valueOf(req.getParameter("currentPage"));
//			List<DonEnNature> donEnNatures = metier.getAllDonsEnNature(currentPage,GlobalConfig.recordsPerPage);
//	        int rows = (int) metier.getNumberOfRows("DonEnNature");
//	        int nOfPages = rows / GlobalConfig.recordsPerPage;
//	        
//	        if (nOfPages % GlobalConfig.recordsPerPage > 0) {
//	            nOfPages++;
//	        }
//	        
//	        req.setAttribute("noOfPages", nOfPages);
//	        req.setAttribute("currentPage", currentPage);
//	        req.setAttribute("recordsPerPage", GlobalConfig.recordsPerPage);
			List<DonEnNature> donEnNatures = metier.getAllDonsEnNature();
			req.setAttribute("don_en_nature", donEnNatures);
			req.getRequestDispatcher("Dashboard_ministere/ListesDons.jsp").forward(req, resp);
			
		} else if (action.equals("Voir tous les reglements")){
			req.setAttribute("reglement", metier.getAllDonsReglement());
			doGet(req, resp);
		} 
	}
}
