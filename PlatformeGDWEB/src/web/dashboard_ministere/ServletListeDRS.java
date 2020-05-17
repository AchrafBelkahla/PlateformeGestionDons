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
import metier.entities.Etablisement;
import metier.session.PlatformGDLocal;
import web.GlobalConfig;

@WebServlet("/Liste_DRS")
public class ServletListeDRS extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setAttribute("etablissements", dao.getAllDrs());
		//req.getRequestDispatcher("Dashboard_ministere/ListeDRS.jsp").forward(req,resp);
		
		int currentPage = Integer.valueOf(req.getParameter("currentPage"));
		List<Etablisement> etablissements = dao.getAllDrs(currentPage,GlobalConfig.recordsPerPage);
		int rows = (int) dao.getNumberOfRows("Etablisement");
        int nOfPages = rows / GlobalConfig.recordsPerPage;
        
        if (nOfPages % GlobalConfig.recordsPerPage > 0) {
            nOfPages++;
        }
        
        req.setAttribute("noOfPages", nOfPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("recordsPerPage", GlobalConfig.recordsPerPage);
		req.setAttribute("etablissements", etablissements);
		req.getRequestDispatcher("Dashboard_ministere/ListeDRS.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
