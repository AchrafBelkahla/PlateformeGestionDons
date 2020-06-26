package web.dashboard_ministere;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
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
import metier.entities.Utilisateur;
import metier.session.PlatformGDImpl;
import metier.session.PlatformGDLocal;
import service.DaoManagement;


@WebServlet("/Importer_Donateurs")
@MultipartConfig
public class Importer_Donateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "uploads\\files";

	private static final CellType CELL_TYPE_STRING = null;

	@EJB
	private PlatformGDLocal metier;
	
	
	public Importer_Donateurs() {
		metier = new PlatformGDImpl();
	}
	
	protected Boolean find_Donateurs(List<Utilisateur> liste, String mail) {
		for (Utilisateur user : liste) {


			if(user.getEmail().equals(mail)){
				return true;
			}
		}
		return false;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("Dashboard_ministere/Upload_Donateurs.jsp").forward(request, response);

	}

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DaoManagement daoManagement = new DaoManagement();
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
				fileName = part.getSubmittedFileName();
				fileName = fileName+ "-" +UUID.randomUUID().toString();
				part.write(uploadPath + File.separator +fileName);
				System.out.println(uploadPath + File.separator + fileName);
			}
		}
		

		File initialFile = new File(uploadPath + File.separator + fileName);
		String message ="";
		
		
		if(initialFile!=null)
		{
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(initialFile));
		int sheetIndex = 0;
		XSSFSheet datatypeSheet = workbook.getSheetAt(sheetIndex);
		System.out.println("\n++++++++++++++++++ Donateurs ++++++++++++++++++++++++++");
		int clean =0;
		int notClean = 0;
		Iterator<Row> iterator = datatypeSheet.iterator();
		Row currentRow = iterator.next();
		try {
			int numLigne = 1;
			while (iterator.hasNext()) {

				numLigne++;
				currentRow = iterator.next();
				int nbCells = currentRow.getLastCellNum();
				if(clean>1) {
					message = message + "Donateurs ajoutés";
					break;
				}
				if (nbCells <2 && clean ==0 && notClean==0) {
					System.out.println("Donateurs not OK");
					message = message + "Verifier le nombre de colonnes des donateurs";
					break;
				} else {
					Iterator<Cell> cellIterator = currentRow.cellIterator();
					String nomDon = "";
					String mailDon = "";
					Cell currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						nomDon = currentCell.getStringCellValue();
						notClean++;
						clean=0;
					} else {
						clean++;
						continue;
					}
					currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						mailDon = currentCell.getStringCellValue();
					}
					if (!nomDon.equals(null) && !find_Donateurs(metier.getAllDonnateurs(), nomDon)) {
						///////////////////////////////////////////////////////////////////////
						
						System.out.println(" ************ nom don ");
						System.out.println(nomDon);
						System.out.println(mailDon);
						
						
						Utilisateur donateur = new Utilisateur();
						donateur.setPrenom(nomDon);
						donateur.setNom(nomDon);
						donateur.setEmail(mailDon);
						donateur.setAccepted(true);
						donateur.setEtatDecompte(true);
						donateur.setConfirmed(true);
						donateur.setRole("donateur");
						donateur.setMdp("user");
						daoManagement.ajouteUtilisateur(donateur);
					}
				}

			}


		} finally {
			workbook.close();

		}
	}
		else message = message + "veuillez ajouter un fichier";

		request.setAttribute("msg", message);
		request.getRequestDispatcher("Dashboard_ministere/Upload_Donateurs.jsp").forward(request, response);
	}

}