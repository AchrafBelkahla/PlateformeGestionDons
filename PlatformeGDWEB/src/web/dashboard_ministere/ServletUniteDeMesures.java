package web.dashboard_ministere;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Categorie;
import metier.entities.UniteDeMesure;
import metier.session.PlatformGDLocal;
import web.GlobalConfig;


@WebServlet("/Liste_unite_de_mesure")
public class ServletUniteDeMesures extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	
	public ServletUniteDeMesures() {
		super();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		
//			List<UniteDeMesure> udms = dao.getAllUniteDeMesure();
//			request.setAttribute("udms", udms);
//			request.getRequestDispatcher("Dashboard_ministere/UniteDeMesures.jsp").forward(request,response);
			
			int currentPage = Integer.valueOf(request.getParameter("currentPage"));
			List<UniteDeMesure> udms = dao.getAllUniteDeMesure(currentPage,GlobalConfig.recordsPerPage);
	        int rows = (int) dao.getNumberOfRows("UniteDeMesure");
	        int nOfPages = rows / GlobalConfig.recordsPerPage;
	        
	        if (nOfPages % GlobalConfig.recordsPerPage > 0) {
	            nOfPages++;
	        }
	        
	        request.setAttribute("noOfPages", nOfPages);
	        request.setAttribute("currentPage", currentPage);
	        request.setAttribute("recordsPerPage", GlobalConfig.recordsPerPage);
	        request.setAttribute("udms", udms);
	        request.getRequestDispatcher("Dashboard_ministere/UniteDeMesures.jsp").forward(request,response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idUnite = request.getParameter("idUnite");

		UniteDeMesure u = new UniteDeMesure(idUnite);
		dao.ajoutUniteDeMesure(u);
		
		doGet(request, response);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{

		String idUnite = request.getParameter("id");
		UniteDeMesure udm = dao.getUniteDeMesureById(idUnite);
		dao.deleteUniteDeMesure(udm);
		response.getWriter().println(true);
	}

}