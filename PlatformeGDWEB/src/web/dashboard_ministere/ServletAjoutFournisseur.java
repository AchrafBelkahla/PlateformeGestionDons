package web.dashboard_ministere;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import metier.entities.Categorie;
import metier.entities.Fournisseur;
import metier.entities.Produit;
import metier.session.PlatformGDLocal;


@WebServlet("/ajoutFournisseurMinistere")
public class ServletAjoutFournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	

	
	
	public ServletAjoutFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		    List<Produit> produits = dao.getAllProduit();
			request.setAttribute("produits", produits);
			List<Categorie> categories = dao.getAllCategorie();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("Dashboard_ministere/ajoutFournisseurMinistere.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String libelle = request.getParameter("libelle");
		String email =request.getParameter("email");
		String adresse =request.getParameter("adresse");
		String gouvernorat = request.getParameter("gouvernorat");
		String codePostal = request.getParameter("codePostal");
		long telephone= Long.parseLong(request.getParameter("telephone"));
		Fournisseur f = new Fournisseur(libelle, email, adresse, gouvernorat, codePostal, telephone);
		
		
		String[] idProduits = request.getParameterValues("produit");
		if(idProduits!=null) 
		{
			List<Produit> produits = new ArrayList<Produit>();
			for(String idProduit : idProduits)
			{
				Produit p = dao.getProduitById(idProduit);
				produits.add(p);
			}
			
			f.setProduits(produits);
		}
		dao.ajoutFournisseur(f);

	    List<Fournisseur> fournisseurs = dao.getAllFournisseur();
		request.setAttribute("fournisseurs", fournisseurs);
			request.getRequestDispatcher("Dashboard_ministere/ListeFournisseurs.jsp").forward(request, response);
			


		
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
