package web.dashboard_ministere;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Besoin;
import metier.entities.DonEnNature;
import metier.session.PlatformGDLocal;
import web.GlobalConfig;

@WebServlet(urlPatterns = {"/Liste_Dons_En_Nature"})
public class ServletListeDonEnNature extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@EJB
	private PlatformGDLocal metier;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int currentPage = Integer.valueOf(req.getParameter("currentPage"));
		String order = req.getParameter("order");
		String direction = req.getParameter("direction");
		List<DonEnNature> donEnNatures = metier.getAllDonsEnNature(currentPage,GlobalConfig.recordsPerPage, order, direction);
        int rows = (int) metier.getNumberOfRows("DonEnNature");
        int nOfPages = rows / GlobalConfig.recordsPerPage;
        
        if (nOfPages % GlobalConfig.recordsPerPage > 0) {
            nOfPages++;
        }
        
        req.setAttribute("noOfPages", nOfPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("recordsPerPage", GlobalConfig.recordsPerPage);
        req.setAttribute("order", order);
        req.setAttribute("direction", direction);
		req.setAttribute("don_en_nature", donEnNatures);
		req.getRequestDispatcher("Dashboard_ministere/ListeDonEnNature.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			int currentPage = Integer.valueOf(req.getParameter("currentPage"));
//			String order = req.getParameter("order");
//			String direction = req.getParameter("direction");
//			List<DonEnNature> donEnNatures = metier.getAllDonsEnNature(currentPage,GlobalConfig.recordsPerPage, order, direction);
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
//	        req.setAttribute("order", order);
//	        req.setAttribute("direction", direction);
//			req.setAttribute("don_en_nature", donEnNatures);
//			req.getRequestDispatcher("Dashboard_ministere/ListeDonEnNature.jsp").forward(req, resp);
		doGet(req, resp);
	}
}
