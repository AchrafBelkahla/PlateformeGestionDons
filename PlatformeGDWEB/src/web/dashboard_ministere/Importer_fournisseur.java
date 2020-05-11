 package web.dashboard_ministere;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import metier.entities.Fournisseur;
import metier.session.PlatformGDLocal;

@WebServlet("/Importer_fournisseur")
@MultipartConfig
public class Importer_fournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "uploads\\files";

	@EJB
	private PlatformGDLocal dao;

	public Importer_fournisseur() {
		super();

	}
	protected Boolean find_fournisseur_in_liste(List<Fournisseur> liste, String name) {
		for (Fournisseur four : liste) {
			if(four.getLibelle().equals(name)){
				return true;
			}
		}
		return false;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("Dashboard_ministere/Upload_for.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Handle photos
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();
		String fileName = null;
		String extension;
		int photoIndex = 1;
		List<Part> fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName()))
				.collect(Collectors.toList());

		if (fileParts.get(0).getSubmittedFileName().length() > 0) {
			for (Part part : fileParts) {
				System.out.println(part);
				fileName = part.getSubmittedFileName();
//					extension = fileName.substring(fileName.lastIndexOf(".") + 1);
//				    fileName = fileName.substring(0,fileName.lastIndexOf("."));
//				    fileName = fileName + "__" + Integer.toString(photoIndex) + "." +extension;
//				    photoIndex++;
//				    Photo photo = new Photo();
//				    photo.setIdP(fileName);    // Id photo = filename in directory
//				    dao.ajoutPhoto(photo);
//				    photos.add(photo);
				System.out.println("\n" + fileName);
				part.write(uploadPath + File.separator + fileName);
				System.out.println("////////////////////");
				System.out.println(uploadPath + File.separator + fileName);

			}

		}
		//File file = new File(uploadPath + File.separator + fileName);
		int numLigne = 0;
		int numCol = 0;
		List<Fournisseur> liste_fournisseurs = new ArrayList<Fournisseur>();
		liste_fournisseurs = dao.getAllFournisseur();
	    File initialFile = new File(uploadPath + File.separator + fileName);
	    try {
			
		
	    FileInputStream targetStream = new FileInputStream(initialFile);
	    System.out.println("\n////////////////////");
	    XSSFWorkbook workbook = new XSSFWorkbook(targetStream);
		System.out.println("\n+++++++++++////////////////////");
		XSSFSheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();
		while (iterator.hasNext()) {
			numLigne++;
			Row currentRow = iterator.next();
			int nbCells = currentRow.getLastCellNum();
			if (nbCells < 1) {
				// throw new Exception("Nombre de cellules ligne " + numLigne + " incorrect car
				// < 3 ");
			} else {
				Iterator<Cell> cellIterator = currentRow.iterator();

				Cell currentCell = cellIterator.next();
				String fullName = currentCell.getStringCellValue();
//				
				if(!find_fournisseur_in_liste(liste_fournisseurs, fullName)) {
					Fournisseur F = new Fournisseur();
					F.setLibelle(fullName);
					dao.ajoutFournisseur(F);
				}

			}
		}
		
	    } finally {
	    	//targetStream.
		}

		request.getRequestDispatcher("Dashboard_ministere/Upload_for.jsp").forward(request, response);
	}

}