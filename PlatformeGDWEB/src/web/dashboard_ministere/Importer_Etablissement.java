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

import jdk.nashorn.internal.codegen.types.NumericType;
import metier.entities.Adresse;
import metier.entities.Etablisement;
import metier.entities.Fournisseur;
import metier.entities.Produit;
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

		if (fileParts.get(0).getSubmittedFileName().length() > 0) {
			for (Part part : fileParts) {
				System.out.println(part);
				fileName = part.getSubmittedFileName();
				System.out.println("\n" + fileName);
				part.write(uploadPath + File.separator + fileName);
				System.out.println("////////////////////");
				System.out.println(uploadPath + File.separator + fileName);

			}

		}
		//File file = new File(uploadPath + File.separator + fileName);
				int numLigne = 1;
				int numCol = 0;
				
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
					String tel = "";
					if (nbCells != 8) {
						request.setAttribute("msg", "verifier les nombres de colonnes");
					}else{
						Iterator<Cell> cellIterator = currentRow.iterator();

						Cell currentCell = cellIterator.next();
						String nom_etablissement = currentCell.getStringCellValue();
						if(nom_etablissement != "") {
							currentCell = cellIterator.next();
							String Gouvernorat = currentCell.getStringCellValue();
							
							currentCell = cellIterator.next();
							String adresse = currentCell.getStringCellValue();
							
							currentCell = cellIterator.next();
							CellType celltype = currentCell.getCellTypeEnum();
							if(celltype == CellType.NUMERIC) {
								System.out.println("99999999999");
								currentCell.setCellType(CellType.STRING);
								tel = currentCell.getStringCellValue();
								System.out.println("8877777777");
							}
							
							
							System.out.println(nom_etablissement + "/" + Gouvernorat + "/" + adresse + "/" + tel);
//		
//							currentCell = cellIterator.next();
//							String Nom_responsable_don = currentCell.getStringCellValue();
//		
//							currentCell = cellIterator.next();
//							String Prénom_responsable_don = currentCell.getStringCellValue();
//		
//							currentCell = cellIterator.next();
//							String Tel_responsable_don = currentCell.getStringCellValue();
//		
//							currentCell = cellIterator.next();
//							String Email_responsable_don = currentCell.getStringCellValue();
//							System.out.println(nom_etablissement + " " + Gouvernorat + " " +  Adresse + " " + Tel + " " 
//							+ Nom_responsable_don + " " + Prénom_responsable_don + " " + Tel_responsable_don +  " " + Email_responsable_don);
						}
						
					}
				}
				
			    } finally {
			    	//targetStream.
				}

			    request.getRequestDispatcher("Dashboard_ministere/Upload_Etablissement.jsp").forward(request, response);
	}

}