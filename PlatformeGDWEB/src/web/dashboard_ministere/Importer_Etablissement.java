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
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import metier.entities.Adresse;
import metier.entities.Etablisement;
import metier.entities.Fournisseur;
import metier.entities.Telephone;
import metier.entities.Utilisateur;
import metier.session.PlatformGDImpl;
import metier.session.PlatformGDLocal;
import service.DaoManagement;

@WebServlet("/Importer_Etablissement")
@MultipartConfig
public class Importer_Etablissement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "uploads\\files";

	private static final CellType CELL_TYPE_STRING = null;

	@EJB
	private PlatformGDLocal metier;

	public Importer_Etablissement() {
		metier = new PlatformGDImpl();
	}
	
	protected Boolean find_etablissement(List<Etablisement> liste, String name) {
		for (Etablisement etab : liste) {
			if(etab.getNomEtablissement().toLowerCase().equals(name.toLowerCase())){
				return true;
			}
		}
		return false;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("Dashboard_ministere/Upload_Etablissement.jsp").forward(request, response);

	}

	@SuppressWarnings("deprecation")
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
		/////////////////////////////////
		 String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                 + "abcdefghijklmnopqrstuvxyz"; 

     StringBuilder s = new StringBuilder(); 

     for (int i = 0; i < 5; i++) { 
         int index = (int)(str.length() * Math.random()); 
         s.append(str.charAt(index)); 
     } 
     ///////////////////////////////////////////
		if (fileParts.get(0).getSubmittedFileName().length() > 0) {
			for (Part part : fileParts) {
				System.out.println(part);
				fileName = part.getSubmittedFileName();
				System.out.println("\n" + fileName);
				part.write(uploadPath + File.separator + s+fileName);
				System.out.println("////////////////////");
				System.out.println(uploadPath + File.separator + fileName);

			}

		}
		int numLigne = 1;

		File initialFile = new File(uploadPath + File.separator +s+ fileName);

		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(initialFile));
		int sheetIndex = 0;
		XSSFSheet datatypeSheet = workbook.getSheetAt(sheetIndex);
		System.out.println("\n+++++++++++////////////////////");

		Iterator<Row> iterator = datatypeSheet.iterator();
		Row currentRow = iterator.next();
		try {
			while (iterator.hasNext()) {

				numLigne++;
				currentRow = iterator.next();
				int nbCells = currentRow.getLastCellNum();
				if (nbCells < 3) {

					request.setAttribute("msg", "verifier les nomres de colonnes");
				} else {
					Iterator<Cell> cellIterator = currentRow.cellIterator();
					String Nom_établissement = "";
					String Gouvernorat = "";
					String Adresse = "";
					Cell currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Nom_établissement = currentCell.getStringCellValue();
					} else {
						continue;
					}
					currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Gouvernorat = currentCell.getStringCellValue();
					}
					currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Adresse = currentCell.getStringCellValue();
					}
					if (!Nom_établissement.equals(null) && find_etablissement(metier.getAllHospital(), Nom_établissement)) {
						
						///////////////////////////////////////////////////////////////////////
						Etablisement etablisement = new Etablisement();
						etablisement.setNomEtablissement(Nom_établissement);
						etablisement.setIntermediaire(false);
						etablisement.setHospital(true);
						etablisement.setMinistraire(false);
						etablisement.setDrs(false);
						etablisement.setLibelle("HR");

						//////////////////////////////////////////////////////////////////////////////
						Adresse adresse = new Adresse();
						adresse.setGouvernorat(Gouvernorat);
						adresse.setAdresse(Adresse);
						metier.ajouteadresse(adresse);
						////////////////////////////////////////////////////////////////////////////////////////
						etablisement.setAdresse(adresse);
						metier.ajouteetablissement(etablisement);
					}
				}

			}

			//////////////////////////////////////////// DRS//////////////////////////////////////////////
			numLigne = 0;
			XSSFSheet datatypeSheet1 = workbook.getSheetAt(1);

			Iterator<Row> iterator1 = datatypeSheet1.iterator();
			currentRow = iterator1.next();

			while (iterator1.hasNext()) {

				numLigne++;
				currentRow = iterator1.next();
				int nbCells = currentRow.getLastCellNum();
				if (nbCells < 2) {
					request.setAttribute("msg", "verifier les nomres de colonnes");
				} else {
					Iterator<Cell> cellIterator = currentRow.cellIterator();
					String Nom_établissement = "";
					String Gouvernorat = "";
					
					Cell currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Nom_établissement = currentCell.getStringCellValue();
					} else {
						continue;
					}
					currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Gouvernorat = currentCell.getStringCellValue();
					}
					if(!Nom_établissement.equals(null) && !find_etablissement(metier.getAllDrs(), Nom_établissement)) {
						///////////////////////////////////////////////////////////////////////
						Etablisement etablisement = new Etablisement();
						etablisement.setNomEtablissement(Nom_établissement);
						etablisement.setIntermediaire(false);
						etablisement.setHospital(false);
						etablisement.setMinistraire(false);
						etablisement.setDrs(true);
						etablisement.setLibelle("HR");

						//////////////////////////////////////////////////////////////////////////////
						Adresse adresse = new Adresse();
						adresse.setGouvernorat(Gouvernorat);
						metier.ajouteadresse(adresse);
						////////////////////////////////////////////////////////////////////////////////////////
						etablisement.setAdresse(adresse);

						metier.ajouteetablissement(etablisement);
						System.out.println(etablisement.toString());

					}
				}

			}

			//////////////////////////////////////////// INTERMEDIAIRE//////////////////////////////////////////////
			numLigne = 0;
			XSSFSheet datatypeSheet2 = workbook.getSheetAt(2);
			System.out.println("\n+++++++++++////////////////////");

			Iterator<Row> iterator2 = datatypeSheet2.iterator();
			currentRow = iterator2.next();
			currentRow = iterator2.next();

			System.out.println("+++++++++++INTERMEDIAIRE+++++++++++++++++");

			while (iterator2.hasNext()) {
				try {
				numLigne++;
				currentRow = iterator2.next();
				int nbCells = currentRow.getLastCellNum();
				if (nbCells < 8) {

					request.setAttribute("msg", "verifier les nomres de colonnes");
				} else {
					System.out.println(numLigne);
					Iterator<Cell> cellIterator = currentRow.cellIterator();
					String Nom_établissement = "";
					String Gouvernorat = "";
					String Adresse = "";

					Cell currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Nom_établissement = currentCell.getStringCellValue();
					} else {
						continue;
					}
					currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Gouvernorat = currentCell.getStringCellValue();
					}
					currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Adresse = currentCell.getStringCellValue();
					}
					

					if (!Nom_établissement.equals(null) && find_etablissement(metier.getAllIntermediaire(), Nom_établissement)) {
						
						///////////////////////////////////////////////////////////////////////
						Etablisement etablisement = new Etablisement();
						etablisement.setNomEtablissement(Nom_établissement);
						etablisement.setIntermediaire(true);
						etablisement.setHospital(false);
						etablisement.setMinistraire(false);
						etablisement.setDrs(false);
						etablisement.setLibelle("HR");
						////////////////////////////////////////////


						//////////////////////////////////////////////////////////////////////////////
						Adresse adresse = new Adresse();
						adresse.setGouvernorat(Gouvernorat);
						adresse.setAdresse(Adresse);
						metier.ajouteadresse(adresse);
						////////////////////////////////////////////////////////////////////////////////////////
						etablisement.setAdresse(adresse);

						metier.ajouteetablissement(etablisement);

					}
				}

			
				
			} catch (Exception e) {
				continue;
				
			}}
		

			workbook.close();
		} finally {
			workbook.close();

		}

		request.getRequestDispatcher("Dashboard_ministere/Upload_Etablissement.jsp").forward(request, response);
	}

}