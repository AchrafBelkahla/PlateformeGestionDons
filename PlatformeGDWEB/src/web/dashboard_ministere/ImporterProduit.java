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

import jdk.nashorn.internal.runtime.FindProperty;
import metier.entities.Fournisseur;
import metier.entities.Produit;
import metier.session.PlatformGDLocal;

@WebServlet("/Importer_produit")
@MultipartConfig
public class ImporterProduit extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "uploads\\files\\produits";

	@EJB
	private PlatformGDLocal dao;


	protected String find_fournisseur_in_liste(List<Fournisseur> liste, String name) {
		for (Fournisseur four : liste) {
			if(four.getLibelle().toLowerCase().equals(name.toLowerCase())){
				return four.getIdF();
			}
		}
		return "-1";
	}
	protected String find_produit_in_liste(List<Produit> liste, String libelle) {
		for (Produit produit : liste) {
			if(produit.getLibelle().toLowerCase().equals(libelle.toLowerCase())){
				return produit.getIdProduit();
			}
		}
		return "-1";
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("Dashboard_ministere/Upload_produit.jsp").forward(request, response);

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
				System.out.println("\n" + fileName);
				part.write(uploadPath + File.separator + fileName);
				System.out.println("////////////////////");
				System.out.println(uploadPath + File.separator + fileName);

			}

		}
		//File file = new File(uploadPath + File.separator + fileName);
		int numLigne = 0;
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
			if (nbCells < 3) {
				// throw new Exception("Nombre de cellules ligne " + numLigne + " incorrect car
				// < 3 ");
			} else {
				Iterator<Cell> cellIterator = currentRow.iterator();

				Cell currentCell = cellIterator.next();
				String libelle = currentCell.getStringCellValue();
//				
				currentCell = cellIterator.next();
				String description = currentCell.getStringCellValue();
				
				currentCell = cellIterator.next();
				String fournisseur = currentCell.getStringCellValue();
				
				if(find_fournisseur_in_liste(dao.getAllFournisseur(), fournisseur) == "-1") {
					//System.out.println("debut if loula");
					Fournisseur F = new Fournisseur();
					F.setLibelle(fournisseur);
					if(find_produit_in_liste(dao.getAllProduit(), libelle) == "-1") {
						//System.out.println("debut if thenia");
						Produit produit = new Produit();
						produit.setLibelle(libelle);
						produit.setDescriptionTechnique(description);
						List<Fournisseur> list_fournisseurs = new ArrayList<Fournisseur>();
						list_fournisseurs.add(F);
						List<Produit> list_produits = new ArrayList<Produit>();
						list_produits.add(produit);
						produit.setFournisseurs(list_fournisseurs);
						F.setProduits(list_produits);
						dao.ajoutProduit(produit);
						dao.ajoutFournisseur(F);
						System.out.println(F.getLibelle());
						//System.out.println("fin if thenia");
					} else {
						//System.out.println("debut else thenia");
						String id_produit = find_produit_in_liste(dao.getAllProduit(), libelle);
						Produit p = dao.getProduitById(id_produit);
						List<Fournisseur> L = p.getFournisseurs();
						L.add(F);
						p.setFournisseurs(L);
						List<Produit> list_produits = new ArrayList<Produit>();
						list_produits.add(p);
						F.setProduits(list_produits);
						dao.ajoutFournisseur(F);
						dao.updateProduit(p);
						System.out.println(F.getLibelle());
						//System.out.println("fin else thenia");
					}
					//System.out.println("fin if loula");
				} else {
					//System.out.println("debut else loula");
					String id_fournisseur = find_fournisseur_in_liste(dao.getAllFournisseur(), fournisseur);
					Fournisseur F =dao.getFournisseurById(id_fournisseur);
					List<Produit> produits = dao.getAllProduit();
					if(find_produit_in_liste(produits, libelle) == "-1") {
						//System.out.println("debut if theltha");
						Produit p = new Produit();
						p.setLibelle(libelle);
						p.setDescriptionTechnique(description);
						List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
						fournisseurs.add(F);
						p.setFournisseurs(fournisseurs);
						List<Produit> produits_fournisseur = dao.getProduitByFounisseur(id_fournisseur);
						produits_fournisseur.add(p);
						F.setProduits(produits_fournisseur);
						dao.ajoutProduit(p);
						dao.updateFournisseur(F);
						//System.out.println("fin if theltha");
					} else {
						//System.out.println("debut else theltha");
						if(find_produit_in_liste(dao.getProduitByFounisseur(id_fournisseur), libelle) == "-1") {
							List<Produit> liste_produit_fournisseur = dao.getProduitByFounisseur(id_fournisseur);
							Produit p = dao.getProduitById(find_produit_in_liste(produits, libelle));
							List<Fournisseur> liste_fournisseur_par_produit = dao.getFournisseurByProduit(p.getIdProduit());
							liste_produit_fournisseur.add(p);
							F.setProduits(liste_produit_fournisseur);
							
							liste_fournisseur_par_produit.add(F);
							p.setFournisseurs(liste_fournisseur_par_produit);
							dao.updateProduit(p);
							dao.updateFournisseur(F);
						}
						//System.out.println("fin else theltha");
					}
					//System.out.println("fin else loula");
				}
				

			}
		}
		
	    } finally {
	    	//targetStream.
		}

		request.getRequestDispatcher("Dashboard_ministere/Upload_produit.jsp").forward(request, response);
	}
}
