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
import metier.session.PlatformGDLocal;
import web.GlobalConfig;

@WebServlet("/Liste_Donnateurs")
public class ServletListeDonnateurs extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("don_en_nature", dao.getAllDonsEnNature());
		req.setAttribute("reglement", dao.getAllDonsReglement());
		req.getRequestDispatcher("Dashboard_ministere/ListeDonnateurs.jsp").forward(req,resp);
		
		

		int currentPage = Integer.valueOf(req.getParameter("currentPage"));
		List<Besoin> besoins = dao.getAllBesoin(currentPage,GlobalConfig.recordsPerPage);
        int rows = (int) dao.getNumberOfRows("Besoin");
        int nOfPages = rows / GlobalConfig.recordsPerPage;
        
        if (nOfPages % GlobalConfig.recordsPerPage > 0) {
            nOfPages++;
        }
        
        req.setAttribute("noOfPages", nOfPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("recordsPerPage", GlobalConfig.recordsPerPage);
		req.setAttribute("besoins", besoins);
		req.getRequestDispatcher("Dashboard_ministere/ListeDonnateurs.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
