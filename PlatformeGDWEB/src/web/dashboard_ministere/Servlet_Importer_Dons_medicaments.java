package web.dashboard_ministere;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import metier.entities.Besoin;
import metier.entities.DonEnNature;
import metier.entities.Etablisement;
import metier.entities.Produit;
import metier.entities.Utilisateur;
import metier.session.PlatformGDImpl;
import metier.session.PlatformGDLocal;
import service.DaoManagement;

@WebServlet("/Importer_Dons")
@MultipartConfig
public class Servlet_Importer_Dons_medicaments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "uploads\\files";

	@EJB
	private PlatformGDLocal metier;

	public Servlet_Importer_Dons_medicaments() {
		metier = new PlatformGDImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("Dashboard_ministere/Upload_Dons.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();
		String fileName = null;
		List<Part> fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName()))
				.collect(Collectors.toList());


		if (fileParts.get(0).getSubmittedFileName().length() > 0) {
			for (Part part : fileParts) {
				fileName = part.getSubmittedFileName();
				fileName =  UUID.randomUUID().toString() +  "-" +fileName;
				part.write(uploadPath + File.separator +fileName);
				System.out.println(uploadPath + File.separator + fileName);

			}

		}

		int numLigne = 1;
		List<String> msgs = new ArrayList<String>();

		File initialFile = new File(uploadPath + File.separator + fileName);

		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(initialFile));
		int sheetIndex = 0;
		XSSFSheet datatypeSheet = workbook.getSheetAt(sheetIndex);
		System.out.println("************************************** Start *************************************");

		Iterator<Row> iterator = datatypeSheet.iterator();
		Row currentRow = iterator.next();
		try {
			while (iterator.hasNext()) {
//			while (numLigne<=10) {
				numLigne++;
				currentRow = iterator.next();
				int nbCells = currentRow.getLastCellNum();
				if (nbCells < 7) {

					request.setAttribute("msg", "verifier les nomres de colonnes");
				} else {
					System.out.println(numLigne);
					Iterator<Cell> cellIterator = currentRow.cellIterator();
					String Libellé = "";
					String Donateur = "";
					String Mail_Donateur = "";
					String Bénéficiaire = "";
					int Quantité =0 ;
					Date date_reglement = new Date(0);

					Cell currentCell = cellIterator.next();
					System.out.println("++++++++++++++++++++++++++++1 "+numLigne+"-------------------------");
					if (currentCell.getCellType() != CellType.BLANK) {
						
						Libellé = currentCell.getStringCellValue();
						System.out.println(Libellé);
					} else {
						continue;
					}
					currentCell = cellIterator.next();
					currentCell = cellIterator.next();
					System.out.println("++++++++++++++++++++++++++++2"+numLigne+"-------------------------");
					if (currentCell.getCellType() != CellType.BLANK) {
						Donateur = currentCell.getStringCellValue();
						System.out.println(Donateur);

					} else {
						continue;
					}
					currentCell = cellIterator.next();
					System.out.println("++++++++++++++++++++++++++++3 "+numLigne+"-------------------------");

					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK) {
						Mail_Donateur = currentCell.getStringCellValue();
						System.out.println(Mail_Donateur);
					} else {
						continue;
					}

					currentCell = cellIterator.next();
					System.out.println("++++++++++++++++++++++++++++4 "+numLigne+"-------------------------");

					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK) {
						Bénéficiaire = currentCell.getStringCellValue();
						System.out.println(Bénéficiaire);
					}

					currentCell = cellIterator.next();
					System.out.println("++++++++++++++++++++++++++++5.1 "+numLigne+"-------------------------");
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.NUMERIC ) {
						System.out.println("++++++++++++++++++++++++++++5.2 "+numLigne+"-------------------------");
					double	Quantité1 = currentCell.getNumericCellValue();
					System.out.println("++++++++++++++++++++++++++++5.3  "+numLigne+"-------------------------");
					Quantité=(int) Quantité1;
					System.out.println(Quantité);
					}
					currentCell = cellIterator.next();
					
					System.out.println("++++++++++++++++++++++++++++6 "+numLigne+"-------------------------");
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
//						Date_reglement = currentCell.getStringCellValue();
						
						try {
							date_reglement = new SimpleDateFormat("yyyy-MM-dd").parse(currentCell.getStringCellValue());
							System.out.println(date_reglement);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							date_reglement = null;
							System.out.println("**************************  date not parsed *****************************************************");
						}
					}
					////////////////////////////////////////////////////////////////////////////

					
					System.out.println("++++++++++++++++++++++++++ ajout au BD ------------------------");
					DonEnNature donEnNature = new DonEnNature();
					
					
					// creation d'un etablissement
					Etablisement etablisement = new Etablisement();
					etablisement = metier.authentification_Etablissement(Bénéficiaire);
					donEnNature.setEtablissement(etablisement);
					
					// creation d'un produit 
					Besoin besoin = new Besoin();
					Produit produit = new Produit();
					produit.setLibelle(Libellé);
					besoin.setEtablisement(etablisement);
					metier.ajoutProduit(produit);
					besoin.setProduit(produit);
					metier.ajoutBesoin(besoin);
					donEnNature.setBesoin(besoin);
					
					Utilisateur utilisateur;
					if (metier.veriff(Mail_Donateur) == null) {
						utilisateur = new Utilisateur();
						utilisateur.setNom(Donateur);
						utilisateur.setPrenom("");
						utilisateur.setEmail(Mail_Donateur);
						utilisateur.setMdp(Mail_Donateur);
						utilisateur.setEtatDecompte(true);
						utilisateur.setAccepted(true);
						utilisateur.setRole("donateur");
						DaoManagement daoManagement = new DaoManagement();						
						daoManagement.ajouteUtilisateur(utilisateur);
						
					} else {
						utilisateur = metier.veriff(Mail_Donateur);
					}

					
					 
					donEnNature.setUtilisateur(utilisateur);
					donEnNature.setQuantite(Quantité);
					donEnNature.setVu(true);
					donEnNature.setVisibilite("true");
					donEnNature.setEstAccepte(true);
					donEnNature.setEstSupprime(false);
					donEnNature.setDatePlanifiee(date_reglement);
					metier.ajouterDonEnNature(donEnNature);
					
					
					System.out.println("+++++++++++" + numLigne + "+++++++++++++++++");

				}
			}

			workbook.close();
		} finally {
			workbook.close();

		}

		request.getRequestDispatcher("Dashboard_ministere/Upload_Dons.jsp").forward(request, response);
	}

}