package web.dashboard_etablissement;
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


@WebServlet("/fournisseurs")
public class ServletFournisseurs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	
	public ServletFournisseurs() {
		super();
		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
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
			req.getRequestDispatcher("Dashboard_etablissement/fournisseurs.jsp").forward(req,response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{

		String idFournisseur = request.getParameter("id");
		Fournisseur fournisseur = dao.getFournisseurById(idFournisseur);
		dao.deleteFournisseur(fournisseur);
		response.getWriter().println(true);
	}

}
