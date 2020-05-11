package web.dashboard_etablissement;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Besoin;
import metier.entities.Categorie;
import metier.entities.Produit;
import metier.entities.UniteDeMesure;
import metier.session.PlatformGDLocal;

@WebServlet("/editProduit")
public class ServletEditProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	

	
	
	public ServletEditProduit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String idProduit = request.getParameter("idProduit");
//		    List<Categorie> categories = dao.getAllCategorie();
//		    List<UniteDeMesure> udms = dao.getAllUniteDeMesure();
		    
		    Produit produit = dao.getProduitById(idProduit);
//			request.setAttribute("categories", categories);
//			request.setAttribute("udms", udms);
			request.setAttribute("produit", produit);
			request.getRequestDispatcher("Dashboard_etablissement/editProduit.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idProduit = request.getParameter("idProduit");
		Produit p = dao.getProduitById(idProduit);
		
		String libelle = request.getParameter("libelle");
		p.setLibelle(libelle);
		
		String description =request.getParameter("description");
		p.setDescriptionTechnique(description);

		double prixMin =Double.parseDouble(request.getParameter("prixMin"));
		p.setPrixMin(prixMin);

		double prixMax= Double.parseDouble(request.getParameter("prixMax"));		
		p.setPrixMax(prixMax);
		
		dao.updateProduit(p);

		List<Produit> produits = dao.getAllProduit();
		request.setAttribute("ListProduits", produits);
		request.getRequestDispatcher("produits.jsp").forward(request,response);
			


		
	}

//	@Override
//	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession(true);
//		boolean auth = (Boolean) session.getAttribute("logged");
//		if (auth) {
//			DaoManagement daoManagement = new DaoManagement();
//			String operation = req.getParameter("operation");
//			if(operation.equalsIgnoreCase("savecategorie")){
//				String nom = req.getParameter("nom");
//				Categorie c = new Categorie();
//				c.setNom(nom);
//				daoManagement.addCategorie(c);
//				resp.getWriter().println(true);
//			}else
//			if(operation.equalsIgnoreCase("saveproduct")) {
//				String libelle = req.getParameter("libelle");
//				String description= req.getParameter("description");
//				BigDecimal prix = new BigDecimal(req.getParameter("prix"));
//				int idcategorie = Integer.parseInt(req.getParameter("categorie"));
//				Produit p = new Produit();
//				p.setNom(libelle);p.setDescription(description);p.setPrix(prix);p.setCategorie(daoManagement.getCategorieById(idcategorie));
//				daoManagement.addProduit(p);
//				resp.getWriter().println(true);
//			}
//		}
//	}
//
//	@Override
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession(true);
//		boolean auth = (Boolean) session.getAttribute("logged");
//		if (auth) {
//			int id = Integer.parseInt(req.getParameter("id"));
//			String operation = req.getParameter("operation");
//			DaoManagement daoManagement = new DaoManagement();
//			if (operation.equalsIgnoreCase("deletecategorie")) {
//				Categorie c = daoManagement.getCategorieById(id);
//				daoManagement.removeCategorie(c);
//				resp.getWriter().println(true);
//			}
//			if (operation.equalsIgnoreCase("deleteproduit")) {
//				Produit p = daoManagement.getProduitById(id);
//				daoManagement.removeProduit(p);
//				resp.getWriter().println(true);
//			}
//		}
//	}

}
