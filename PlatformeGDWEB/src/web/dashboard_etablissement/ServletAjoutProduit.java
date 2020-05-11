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
import metier.entities.UniteDeMesure;
import metier.session.PlatformGDLocal;


@WebServlet("/ajoutProduit")
public class ServletAjoutProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	

	
	
	public ServletAjoutProduit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		    List<Fournisseur> fournisseurs = dao.getAllFournisseur();
//			request.setAttribute("fournisseurs", fournisseurs);
		    List<UniteDeMesure> udms = dao.getAllUniteDeMesure();
			request.setAttribute("udms", udms);
		    List<Categorie> categories = dao.getAllCategorie();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("Dashboard_etablissement/ajoutProduit.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
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
