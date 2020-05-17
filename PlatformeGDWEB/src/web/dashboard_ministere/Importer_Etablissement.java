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
	
	protected Boolean find_etablissement(String name) {
		List<Etablisement> liste = metier.getAllEtablissement();
		for (Etablisement etab : liste) {
			if(etab.getLibelle().equals(name)){
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
		// File file = new File(uploadPath + File.separator + fileName);
		String direc= uploadPath + File.separator + s+fileName;
		
		
		int numLigne = 1;
//		int numCol = 0;
//		List<String> msgs = new ArrayList<String>();

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
				if (nbCells < 8) {

					request.setAttribute("msg", "verifier les nomres de colonnes");
				} else {
					System.out.println(numLigne);
					Iterator<Cell> cellIterator = currentRow.cellIterator();
					String Email_responsable_don = "";
					String Nom_établissement = "";
					String Nom_responsable_don = "";
					String Prénom_responsable_don = "";
					String Gouvernorat = "";
					String Adresse = "";
					String Tel_responsable_don = "";
					String Tel = "";
					Cell currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						// System.out.println(currentCell.getCellType());
						Nom_établissement = currentCell.getStringCellValue();
					} else {
						continue;
					}
					currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						// System.out.println(currentCell.getCellType());
						Gouvernorat = currentCell.getStringCellValue();
					}
					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Adresse = currentCell.getStringCellValue();
					}
					currentCell = cellIterator.next();

					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Tel = currentCell.getStringCellValue();
					} else if (currentCell.getCellType() != CellType.BLANK
							&& currentCell.getCellType() == CellType.NUMERIC) {
						int Tel1 = (int) currentCell.getNumericCellValue();
						Tel = String.valueOf(Tel1);
					}
					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Nom_responsable_don = currentCell.getStringCellValue();
					}

					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Prénom_responsable_don = currentCell.getStringCellValue();
					}
					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Tel_responsable_don = currentCell.getStringCellValue();
					} else if (currentCell.getCellType() != CellType.BLANK
							&& currentCell.getCellType() == CellType.NUMERIC) {
						int Tel_responsable_don1 = (int) currentCell.getNumericCellValue();
						Tel_responsable_don = String.valueOf(Tel_responsable_don1);

					}
					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK) {
						Email_responsable_don = currentCell.getStringCellValue();
					} else {
						continue;
					}
					if (metier.veriff(Email_responsable_don) == null
							&& metier.veriff_nom_etablissement(Nom_établissement) == false && Nom_établissement != null
							&& Email_responsable_don != null) {
						Utilisateur utilisateur = new Utilisateur();

						utilisateur.setNom(Nom_responsable_don);
						utilisateur.setPrenom(Prénom_responsable_don);
						utilisateur.setEmail(Email_responsable_don);
						utilisateur.setMdp(Email_responsable_don);
						utilisateur.setEtatDecompte(true);
						utilisateur.setAccepted(true);
						utilisateur.setRole("responsable");
						DaoManagement daoManagement = new DaoManagement();
						//////////////////////////////////////////////////////////////////////
						List<Telephone> collection_tel_adm = new ArrayList<Telephone>();
						Telephone telephone = new Telephone();
						if (Tel_responsable_don.indexOf("/") != -1) {

							telephone.setNumero(Tel_responsable_don.substring(0, Tel_responsable_don.indexOf("/")));

							Telephone fax = new Telephone();
							fax.setNumero(Tel_responsable_don.substring(Tel_responsable_don.indexOf("/") + 1));

							metier.ajoutetelephone(telephone);
							metier.ajoutetelephone(fax);
							collection_tel_adm.add(fax);
							collection_tel_adm.add(telephone);
						} else {
							telephone.setNumero(Tel_responsable_don);
							metier.ajoutetelephone(telephone);
							collection_tel_adm.add(telephone);
						}
						utilisateur.setTelephone(collection_tel_adm);
						///////////////////////////////////////////////////////////////////////
						Etablisement etablisement = new Etablisement();
						etablisement.setNomEtablissement(Nom_établissement);
						etablisement.setIntermediaire(false);
						etablisement.setHospital(true);
						etablisement.setMinistraire(false);
						etablisement.setDrs(false);
						etablisement.setLibelle("HR");
						////////////////////////////////////////////

						List<Telephone> Tels = new ArrayList<Telephone>();
						Telephone tele_et = new Telephone();
						if (Tel.indexOf("/") != -1) {

							tele_et.setNumero(Tel.substring(0, Tel.indexOf("/")));

							Telephone fax2 = new Telephone();
							fax2.setNumero(Tel.substring(Tel.indexOf("/") + 1));

							metier.ajoutetelephone(tele_et);
							metier.ajoutetelephone(fax2);

							Tels.add(fax2);
							Tels.add(tele_et);

						} else {
							tele_et.setNumero(Tel);
							metier.ajoutetelephone(tele_et);
							Tels.add(tele_et);

						}
						etablisement.setTelephones(Tels);

						//////////////////////////////////////////////////////////////////////////////
						Adresse adresse = new Adresse();
						adresse.setGouvernorat(Gouvernorat);
						// adresse.setCodePostale(Integer.parseInt(c3));
						adresse.setAdresse(Adresse);
						metier.ajouteadresse(adresse);
						////////////////////////////////////////////////////////////////////////////////////////
						etablisement.setAdresse(adresse);
//						List<Utilisateur> collection_utilisateur = new ArrayList<Utilisateur>();
//
//						collection_utilisateur.add(utilisateur);
//						etablisement.setUtilisateurs(collection_utilisateur);
						metier.ajouteetablissement(etablisement);
						utilisateur.setEtablissement(etablisement);
						daoManagement.ajouteUtilisateur(utilisateur);
						System.out.println("+++++++++++" + numLigne + "+++++++++++++++++");

					}
				}

			}

			//////////////////////////////////////////// DRS//////////////////////////////////////////////
			numLigne = 0;
			XSSFSheet datatypeSheet1 = workbook.getSheetAt(1);
			System.out.println("\n+++++++++++////////////////////");

			Iterator<Row> iterator1 = datatypeSheet1.iterator();
			currentRow = iterator1.next();
			System.out.println("+++++++++++DRS+++++++++++++++++");

			while (iterator1.hasNext()) {

				numLigne++;
				currentRow = iterator1.next();
				int nbCells = currentRow.getLastCellNum();
				if (nbCells < 7) {

					request.setAttribute("msg", "verifier les nomres de colonnes");
				} else {
					System.out.println(numLigne);
					Iterator<Cell> cellIterator = currentRow.cellIterator();
					String Email_responsable_don = "";
					String Nom_établissement = "";
					String Nom_responsable_don = "";
					String Prénom_responsable_don = "";
					String Gouvernorat = "";
					String Adresse = "";
					String Tel_responsable_don = "";
					String Tel = "";
					
					Cell currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						// System.out.println(currentCell.getCellType());
						Nom_établissement = currentCell.getStringCellValue();
					} else {
						continue;
					}
					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Nom_responsable_don = currentCell.getStringCellValue();
					}

					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Prénom_responsable_don = currentCell.getStringCellValue();
					}
					
					 currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Tel_responsable_don = currentCell.getStringCellValue();
					} else if (currentCell.getCellType() != CellType.BLANK
							&& currentCell.getCellType() == CellType.NUMERIC) {
						int Tel_responsable_don1 = (int) currentCell.getNumericCellValue();
						Tel_responsable_don = String.valueOf(Tel_responsable_don1);

					}
					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK) {
						Email_responsable_don = currentCell.getStringCellValue();
					} else {
						continue;
					}

				
					currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK) {
						// System.out.println(currentCell.getCellType());
						Gouvernorat = currentCell.getStringCellValue();
					}
				
					currentCell = cellIterator.next();

					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Tel = currentCell.getStringCellValue();
					} else if (currentCell.getCellType() != CellType.BLANK
							&& currentCell.getCellType() == CellType.NUMERIC) {
						int Tel1 = (int) currentCell.getNumericCellValue();
						Tel = String.valueOf(Tel1);
					}

					
					
					if (metier.veriff(Email_responsable_don) == null
							&& metier.veriff_nom_etablissement(Nom_établissement) == false && Nom_établissement != null
							&& Email_responsable_don != null) {
						Utilisateur utilisateur = new Utilisateur();

						utilisateur.setNom(Nom_responsable_don);
						utilisateur.setPrenom(Prénom_responsable_don);
						utilisateur.setEmail(Email_responsable_don);
						utilisateur.setMdp(Email_responsable_don);
						utilisateur.setEtatDecompte(true);
						utilisateur.setAccepted(true);
						utilisateur.setRole("responsable");
						DaoManagement daoManagement = new DaoManagement();
						//////////////////////////////////////////////////////////////////////
						List<Telephone> collection_tel_adm = new ArrayList<Telephone>();
						Telephone telephone = new Telephone();
						if (Tel_responsable_don.indexOf("/") != -1) {

							telephone.setNumero(Tel_responsable_don.substring(0, Tel_responsable_don.indexOf("/")));

							Telephone fax = new Telephone();
							fax.setNumero(Tel_responsable_don.substring(Tel_responsable_don.indexOf("/") + 1));

							metier.ajoutetelephone(telephone);
							metier.ajoutetelephone(fax);
							collection_tel_adm.add(fax);
							collection_tel_adm.add(telephone);
						} else {
							telephone.setNumero(Tel_responsable_don);
							metier.ajoutetelephone(telephone);
							collection_tel_adm.add(telephone);
						}
						utilisateur.setTelephone(collection_tel_adm);
						///////////////////////////////////////////////////////////////////////
						Etablisement etablisement = new Etablisement();
						etablisement.setNomEtablissement(Nom_établissement);
						etablisement.setIntermediaire(false);
						etablisement.setHospital(false);
						etablisement.setMinistraire(false);
						etablisement.setDrs(true);
						etablisement.setLibelle("HR");
						////////////////////////////////////////////

						List<Telephone> Tels = new ArrayList<Telephone>();
						Telephone tele_et = new Telephone();
						if (Tel.indexOf("/") != -1) {

							tele_et.setNumero(Tel.substring(0, Tel.indexOf("/")));

							Telephone fax2 = new Telephone();
							fax2.setNumero(Tel.substring(Tel.indexOf("/") + 1));

							metier.ajoutetelephone(tele_et);
							metier.ajoutetelephone(fax2);

							Tels.add(fax2);
							Tels.add(tele_et);

						} else {
							tele_et.setNumero(Tel);
							metier.ajoutetelephone(tele_et);
							Tels.add(tele_et);

						}
						etablisement.setTelephones(Tels);

						//////////////////////////////////////////////////////////////////////////////
						Adresse adresse = new Adresse();
						adresse.setGouvernorat(Gouvernorat);
						// adresse.setCodePostale(Integer.parseInt(c3));
						adresse.setAdresse(Adresse);
						metier.ajouteadresse(adresse);
						////////////////////////////////////////////////////////////////////////////////////////
						etablisement.setAdresse(adresse);
//							List<Utilisateur> collection_utilisateur = new ArrayList<Utilisateur>();
						//
//							collection_utilisateur.add(utilisateur);
//							etablisement.setUtilisateurs(collection_utilisateur);
						metier.ajouteetablissement(etablisement);
						utilisateur.setEtablissement(etablisement);
						daoManagement.ajouteUtilisateur(utilisateur);
						System.out.println("+++++++++++" + numLigne + "+++++++++++++++++");

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
					String Email_responsable_don = "";
					String Nom_établissement = "";
					String Nom_responsable_don = "";
					String Prénom_responsable_don = "";
					String Gouvernorat = "";
					String Adresse = "";
					String Tel_responsable_don = "";
					String Tel = "";

					Cell currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						// System.out.println(currentCell.getCellType());
						Nom_établissement = currentCell.getStringCellValue();
					} else {
						continue;
					}
					currentCell = cellIterator.next();
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						// System.out.println(currentCell.getCellType());
						Gouvernorat = currentCell.getStringCellValue();
					}
					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Adresse = currentCell.getStringCellValue();
					}
					currentCell = cellIterator.next();

					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Tel = currentCell.getStringCellValue();
					} else if (currentCell.getCellType() != CellType.BLANK
							&& currentCell.getCellType() == CellType.NUMERIC) {
						System.out.println("0000000000heloooo");

						int Tel1 = (int) currentCell.getNumericCellValue();
						Tel = String.valueOf(Tel1);
					}
										
					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Nom_responsable_don = currentCell.getStringCellValue();
					}

					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Prénom_responsable_don = currentCell.getStringCellValue();
					}
					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK && currentCell.getCellType() == CellType.STRING) {
						Tel_responsable_don = currentCell.getStringCellValue();
					} else if (currentCell.getCellType() != CellType.BLANK
							&& currentCell.getCellType() == CellType.NUMERIC) {
						System.out.println("heloooo");
						int Tel_responsable_don1 = (int) currentCell.getNumericCellValue();
						Tel_responsable_don = String.valueOf(Tel_responsable_don1);

					}
					currentCell = cellIterator.next();
					// System.out.println(currentCell.getCellType());
					if (currentCell.getCellType() != CellType.BLANK) {
						Email_responsable_don = currentCell.getStringCellValue();
					} else {
						continue;
					}

					if (metier.veriff(Email_responsable_don) == null
							&& metier.veriff_nom_etablissement(Nom_établissement) == false && Nom_établissement != null
							&& Email_responsable_don != null) {
						Utilisateur utilisateur = new Utilisateur();

						utilisateur.setNom(Nom_responsable_don);
						utilisateur.setPrenom(Prénom_responsable_don);
						utilisateur.setEmail(Email_responsable_don);
						utilisateur.setMdp(Email_responsable_don);
						utilisateur.setEtatDecompte(true);
						utilisateur.setAccepted(true);
						utilisateur.setRole("responsable");
						DaoManagement daoManagement = new DaoManagement();
						//////////////////////////////////////////////////////////////////////
						List<Telephone> collection_tel_adm = new ArrayList<Telephone>();
						Telephone telephone = new Telephone();
						if (Tel_responsable_don.indexOf("/") != -1) {

							telephone.setNumero(Tel_responsable_don.substring(0, Tel_responsable_don.indexOf("/")));

							Telephone fax = new Telephone();
							fax.setNumero(Tel_responsable_don.substring(Tel_responsable_don.indexOf("/") + 1));

							metier.ajoutetelephone(telephone);
							metier.ajoutetelephone(fax);
							collection_tel_adm.add(fax);
							collection_tel_adm.add(telephone);
						} else {
							telephone.setNumero(Tel_responsable_don);
							metier.ajoutetelephone(telephone);
							collection_tel_adm.add(telephone);
						}
						utilisateur.setTelephone(collection_tel_adm);
						///////////////////////////////////////////////////////////////////////
						Etablisement etablisement = new Etablisement();
						etablisement.setNomEtablissement(Nom_établissement);
						etablisement.setIntermediaire(true);
						etablisement.setHospital(false);
						etablisement.setMinistraire(false);
						etablisement.setDrs(false);
						etablisement.setLibelle("HR");
						////////////////////////////////////////////

						List<Telephone> Tels = new ArrayList<Telephone>();
						Telephone tele_et = new Telephone();
						if (Tel.indexOf("/") != -1) {

							tele_et.setNumero(Tel.substring(0, Tel.indexOf("/")));

							Telephone fax2 = new Telephone();
							fax2.setNumero(Tel.substring(Tel.indexOf("/") + 1));

							metier.ajoutetelephone(tele_et);
							metier.ajoutetelephone(fax2);

							Tels.add(fax2);
							Tels.add(tele_et);

						} else {
							tele_et.setNumero(Tel);
							metier.ajoutetelephone(tele_et);
							Tels.add(tele_et);

						}
						etablisement.setTelephones(Tels);

						//////////////////////////////////////////////////////////////////////////////
						Adresse adresse = new Adresse();
						adresse.setGouvernorat(Gouvernorat);
						adresse.setAdresse(Adresse);
						metier.ajouteadresse(adresse);
						////////////////////////////////////////////////////////////////////////////////////////
						etablisement.setAdresse(adresse);

						metier.ajouteetablissement(etablisement);
						utilisateur.setEtablissement(etablisement);
						daoManagement.ajouteUtilisateur(utilisateur);
						System.out.println("+++++++++++" + numLigne + "+++++++++++++++++");

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