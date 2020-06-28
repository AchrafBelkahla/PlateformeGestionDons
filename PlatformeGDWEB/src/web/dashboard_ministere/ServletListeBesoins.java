package web.dashboard_ministere;

import java.io.File;
import java.io.IOException;
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

import metier.entities.Besoin;
import metier.entities.Etablisement;
import metier.entities.Photo;
import metier.entities.PhotoBesoin;
import metier.entities.Produit;
import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;
import web.GlobalConfig;

@WebServlet("/Liste_Besoins")
@MultipartConfig
public class ServletListeBesoins extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "uploads\\images\\besoins";
	@EJB
	private PlatformGDLocal dao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int currentPage = Integer.valueOf(req.getParameter("currentPage"));
		String order = req.getParameter("order");
		String direction = req.getParameter("direction");
		List<Besoin> besoins = dao.getAllBesoin(currentPage,GlobalConfig.recordsPerPage, order, direction);
        int rows = (int) dao.getNumberOfRows("Besoin");
        int nOfPages = rows / GlobalConfig.recordsPerPage;
        
        if (nOfPages % GlobalConfig.recordsPerPage > 0) {
            nOfPages++;
        }
        
        req.setAttribute("noOfPages", nOfPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("recordsPerPage", GlobalConfig.recordsPerPage);
        req.setAttribute("order", order);
        req.setAttribute("direction", direction);
		req.setAttribute("besoins", besoins);
		req.getRequestDispatcher("Dashboard_ministere/ListeBesoins.jsp").forward(req,resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		String idEtablissement = request.getParameter("idEtab");
		Etablisement etablisement = dao.getEtablissementById(idEtablissement);
		String idProduit = request.getParameter("produit");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		String priorite =  request.getParameter("Priorite");		
		String motif =  request.getParameter("motif");
		System.out.println("hhxxxaqaazrfhhhh");
		Besoin b = new Besoin(new Date(), "Non servi", quantite, quantite, priorite, false, motif);
		Produit produit = dao.getProduitById(idProduit);
		b.setProduit(produit);
		

		
		 PhotoBesoin photoBesoin = new PhotoBesoin();
		 
		 List<Photo> photos = new ArrayList<Photo>();
		 
		// Handle photos
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		String fileName;
		String extension; 
		int photoIndex=1;
		List<Part> fileParts = request.getParts().stream().
				 filter(part->"file".equals(part.getName())).collect(Collectors.
				         toList());
		 
		 if(fileParts.get(0).getSubmittedFileName().length()>0)
		 {				 
			 for (Part part : fileParts) 
			{
				fileName = part.getSubmittedFileName();
				extension = fileName.substring(fileName.lastIndexOf(".") + 1);
			    fileName = b.getIdBesoin();
			    fileName = fileName + "__" + Integer.toString(photoIndex) + "." +extension;
			    photoIndex++;
			    Photo photo = new Photo();
			    photo.setIdP(fileName);    // Id photo = filename in directory
			    dao.ajoutPhoto(photo);
			    photos.add(photo);
			    part.write(uploadPath + File.separator + fileName);
			}
			 photoBesoin.setPhotos(photos);
			 b.setPhotoBesoin(photoBesoin);
		 }
		 dao.ajoutBesoin(b);
		 etablisement.addBesoin(b);
		dao.updateEtablisement(etablisement);
		dao.updateBesoin(b);
		 
		session.setAttribute("user", user);
		int currentPage = Integer.valueOf(request.getParameter("currentPage"));
		String order = request.getParameter("order");
		String direction = request.getParameter("direction");		
		List<Besoin> besoins = dao.getAllBesoin(currentPage,GlobalConfig.recordsPerPage,order, direction);
		int rows = (int) dao.getNumberOfRows("Categorie");
        int nOfPages = rows / GlobalConfig.recordsPerPage;
        
        if (nOfPages % GlobalConfig.recordsPerPage > 0) {
            nOfPages++;
        }
        
        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", GlobalConfig.recordsPerPage);
        request.setAttribute("order", order);
        request.setAttribute("direction", direction);
        request.setAttribute("besoins", besoins);
        request.getRequestDispatcher("Dashboard_ministere/ListeBesoins.jsp").forward(request,response);
	}
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{

		String idBesoin = request.getParameter("id");
		Besoin besoin = dao.getBesoinById(idBesoin);
		dao.deleteBesoin(besoin);
		response.getWriter().println(true);
	}
}