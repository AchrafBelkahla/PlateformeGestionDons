package web.dashboard_donateur;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import metier.entities.Categorie;
import metier.entities.DonEnNature;
import metier.entities.Etablisement;
import metier.entities.Photo;

import metier.entities.PhotoDon;
import metier.entities.Produit;
import metier.entities.UniteDeMesure;
import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;

@WebServlet(urlPatterns = { "/don_en_nature_spontanne" })
@MultipartConfig
public class FaireUnDonEnNatureSpontannee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "uploads\\images\\Don_en_nature";

	@EJB
	private PlatformGDLocal metier;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UniteDeMesure> udms = metier.getAllUniteDeMesure();
		req.setAttribute("udms", udms);
	    List<Categorie> categories = metier.getAllCategorie();
		req.setAttribute("categories", categories);
		req.getRequestDispatcher("Dashboard_donateur/faireUnDonEnNatureSpontannee.jsp").forward(req, resp);
		
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
	
		String idUnite = req.getParameter("unite_de_mesure");
		String idCategorie = req.getParameter("categorie");
		String nom_produit = req.getParameter("nom_produit");
		String descriptionTechnique = req.getParameter("descriptionTechnique");
		Date date_planifiee = new Date();
		try {
			date_planifiee = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date_planifiee"));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String visibilite = req.getParameter("visibilite");
		double prix_totale = Double.parseDouble(req.getParameter("prixTotal"));
		int quantite = Integer.parseInt(req.getParameter("quantite"));
		int prix_min = Integer.parseInt(req.getParameter("prix_min"));
		int prix_max = Integer.parseInt(req.getParameter("prix_max"));
		
		Categorie categorie = metier.getCategorieById(idCategorie);
		UniteDeMesure unite_de_mesure = metier.getUniteDeMesureById(idUnite);
		Produit produit = new Produit(nom_produit, descriptionTechnique, prix_max, prix_min);
		produit.setCategorie(categorie);
		produit.setUniteDeMesure(unite_de_mesure);
		
		DonEnNature don_en_nature = new DonEnNature(date_planifiee, false, false, visibilite, prix_totale, quantite, false);
		Etablisement beneficiaire = metier.findMinistere();
	
		
		don_en_nature.setEtablissement(beneficiaire);
		
		
		PhotoDon photoDon = new PhotoDon();
		 
		List<Photo> photos = new ArrayList<Photo>();
		
		//handle photo
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		String fileName;
		String extension; 
		int photoIndex=1;
		List<Part> fileParts = req.getParts().stream().
				 filter(part->"file".equals(part.getName())).collect(Collectors.
				         toList());
		 
		 if(fileParts.get(0).getSubmittedFileName().length()>0)
		 {				 
			 for (Part part : fileParts) 
			{
				fileName = part.getSubmittedFileName();
				extension = fileName.substring(fileName.lastIndexOf(".") + 1);
			    fileName = don_en_nature.getId_don();
			    fileName = fileName + "__" + Integer.toString(photoIndex) + "." +extension;
			    photoIndex++;
			    Photo photo = new Photo();
			    photo.setIdP(fileName);    // Id photo = filename in directory
			    metier.ajoutPhoto(photo);
			    photos.add(photo);
			    part.write(uploadPath + File.separator + fileName);
			}
			 photoDon.setPhotos(photos);
			 don_en_nature.setPhotoDon(photoDon);
		 }
		 
		 metier.ajoutUniteDeMesure(unite_de_mesure);
		 metier.ajoutCategorie(categorie);
		 metier.ajouterDonEnNature(don_en_nature);
		 user.addDon(don_en_nature);
		 metier.updateUtilisateur(user);
		 metier.updateDonEnNature(don_en_nature);
		 req.getRequestDispatcher("/besoinsByEtablissement?currentPage=1").forward(req, resp);
	}
	

}