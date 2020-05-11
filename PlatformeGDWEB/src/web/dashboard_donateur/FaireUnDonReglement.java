package web.dashboard_donateur;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
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

import metier.entities.DonEnNature;
import metier.entities.Etablisement;
import metier.entities.Photo;
import metier.entities.PhotoDon;
import metier.entities.Reglement;
import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;



@WebServlet(urlPatterns = { "/don_reglement" })
@MultipartConfig
public class FaireUnDonReglement extends HttpServlet{
	@EJB
	private PlatformGDLocal metier;
	
	private static final String UPLOAD_DIRECTORY = "uploads\\images\\Reglement";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code_etablissement = (String) req.getParameter("id_etablissement");
		req.setAttribute("etablisement", metier.getEtablissementById(code_etablissement));
		req.getRequestDispatcher("Dashboard_donateur/faireUnReglement.jsp").forward(req, resp);
		//req.getRequestDispatcher("Dashboard_donateur/faireUnReglement.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
//		
			
			String id_beneficiaie = req.getParameter("nom_etablissement");
			
			Date date_planifiee = new Date();
			try {
				date_planifiee = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date_planifiee"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			String visibilite = req.getParameter("visibilite");
			
			Date date_reglement = new Date();
			try {
				date_reglement = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date_reglement"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String mode_reglement = req.getParameter("mode_reglement");
			double montant = Double.parseDouble((req.getParameter("montant")));
			//String id_beneficiaie = req.getParameter("nom_bene");
			Reglement reglement = new Reglement(date_planifiee, false, false, visibilite, montant, 
					date_reglement, mode_reglement, false);
			Etablisement beneficiaire = metier.findetablissement(id_beneficiaie);
			reglement.setEtablissement(beneficiaire);
			
			
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
				    fileName = reglement.getId_don();
				    fileName = fileName + "__" + Integer.toString(photoIndex) + "." +extension;
				    photoIndex++;
				    Photo photo = new Photo();
				    photo.setIdP(fileName);    // Id photo = filename in directory
				    metier.ajoutPhoto(photo);
				    photos.add(photo);
				    part.write(uploadPath + File.separator + fileName);
				}
				 photoDon.setPhotos(photos);
				 reglement.setPhotoDon(photoDon);
			 }
			 
			 metier.ajouterDonReglement(reglement);
			 user.addDon(reglement);
			 metier.updateUtilisateur(user);
			 metier.updateReglement(reglement);
			
			req.getRequestDispatcher("Dashboard_donateur/besoinsByEtablissement.jsp").forward(req, resp);
		}
	
}