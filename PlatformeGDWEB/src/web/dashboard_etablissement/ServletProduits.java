package web.dashboard_etablissement;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Categorie;
import metier.entities.Produit;
import metier.entities.UniteDeMesure;
import metier.session.PlatformGDLocal;
import web.GlobalConfig;


@WebServlet("/produits")
public class ServletProduits extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	
	public ServletProduits() {
		super();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int currentPage = Integer.valueOf(request.getParameter("currentPage"));
		List<Produit> produits = dao.getAllProduit(currentPage,GlobalConfig.recordsPerPage);
        int rows = (int) dao.getNumberOfRows("Produit");

        int nOfPages = rows / GlobalConfig.recordsPerPage;
        if (nOfPages % GlobalConfig.recordsPerPage > 0) {
            nOfPages++;
        }
        
        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", GlobalConfig.recordsPerPage);
		
		
		request.setAttribute("ListProduits", produits);
		request.getRequestDispatcher("Dashboard_etablissement/produits.jsp").forward(request,response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
			
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{

		String idProduit = request.getParameter("id");
		Produit produit = dao.getProduitById(idProduit);
		dao.deleteProduit(produit);
		response.getWriter().println(true);
	}

}
