package web.dashboard_ministere;

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

import metier.entities.Photo;
import metier.entities.Produit;

import metier.session.PlatformGDLocal;


@WebServlet("/editBesoinMinistere")
public class ServletEditBesoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	

	
	
	public ServletEditBesoin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String idBesoin = request.getParameter("idBesoin");
		    List<Produit> produits = dao.getAllProduit();
		    Besoin besoin = dao.getBesoinById(idBesoin);
			request.setAttribute("produits", produits);
			request.setAttribute("besoin", besoin);
			request.getRequestDispatcher("Dashboard_ministere/editBesoin_ministere.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idBesoin = request.getParameter("idBesoin");
//		String idProduit = request.getParameter("produit");
//		Produit produit = dao.getProduitById(idProduit);
		Besoin b = dao.getBesoinById(idBesoin);
		
		int quantiteDiff= b.getQuantiteInitiale()-b.getQuantiteRestante();
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		b.setQuantiteInitiale(quantite);
		b.setQuantiteRestante(quantite-quantiteDiff);
		
		String priorite =  request.getParameter("priorite");	
		b.setPriorite(priorite);
		
		String motif =  request.getParameter("motif");		
		b.setMotif(motif);
		
//		b.setProduit(produit);
		dao.updateBesoin(b);

		request.setAttribute("besoin",b);
		List<Photo> photos = b.getPhotoBesoin().getPhotos();
		request.setAttribute("photos",photos);
		request.getRequestDispatcher("Dashboard_ministere/besoinMinistere.jsp").forward(request, response);
			


		
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
