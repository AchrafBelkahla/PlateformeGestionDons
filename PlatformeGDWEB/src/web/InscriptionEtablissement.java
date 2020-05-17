package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.entities.Adresse;
import metier.entities.Etablisement;
import metier.entities.Telephone;
import metier.entities.Utilisateur;
import metier.session.PlatformGDImpl;
import metier.session.PlatformGDLocal;
import service.DaoManagement;
import service.emailManagement;

/**
 * Servlet implementation class AjoutEtudiant
 */
@WebServlet("/InscriptionEtablissement")
public class InscriptionEtablissement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal metier;

	public InscriptionEtablissement() {
		metier = new PlatformGDImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("etablissements", metier.getAllEtablissement());
		request.getRequestDispatcher("InscriptionEtablissement.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id_etablissement = request.getParameter("nom_etab");
			Etablisement etablissement = metier.findetablissement(id_etablissement);
			String nom = request.getParameter("input1");
			String prenom = request.getParameter("input2");
			String email = request.getParameter("input3");
			String password = request.getParameter("input4");

			Utilisateur utilisateur = new Utilisateur();

			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setMdp(password);
			utilisateur.setEtatDecompte(true);
			utilisateur.setAccepted(false);
			utilisateur.setRole("responsable");
			DaoManagement daoManagement = new DaoManagement();
			
//////////////////////////////////////////////////////////////////////
			List<Telephone> collection_tel = new ArrayList<Telephone>();
			collection_tel.addAll(etablissement.getTelephones());
			
			String Tel = request.getParameter("input6");
			Telephone telephone = new Telephone();
			telephone.setNumero(Tel);
			collection_tel.add(telephone);
			
			String FAX = request.getParameter("input10");
			Telephone fax = new Telephone();
			fax.setNumero("Fax:" + FAX);
			collection_tel.add(fax);
///////////////////////////////////////////////////////////////////////	
			List<Utilisateur> collection_utilisateur = new ArrayList<Utilisateur>();
			collection_utilisateur.addAll(etablissement.getUtilisateurs());
			
			collection_utilisateur.add(utilisateur);
			System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++");
				if (metier.veriff(email) == null) {
					metier.ajoutetelephone(telephone);
					metier.ajoutetelephone(fax);
					etablissement.setUtilisateurs(collection_utilisateur);
					utilisateur.setEtablissement(etablissement);
					utilisateur.setTelephone(collection_tel);
					String confirmId = UUID.randomUUID().toString();
					utilisateur.setConfirmId(confirmId);
					utilisateur.setConfirmed(true);
					daoManagement.ajouteUtilisateur(utilisateur);
					metier.updateEtablisement(etablissement);
					
					
					String to = utilisateur.getEmail();
					String subject = "subject";
					String body = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" + 
							"<html>\n" + 
							"    <head>\n" + 
							"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" + 
							"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" + 
							"    </head>\n" + 
							"    <body>\n" + 
							"    <p>\n" + 
							"        Chere/Cher <strong>" + utilisateur.getPrenom()+" "+utilisateur.getNom()+"</strong>,"+
							"    </p>\n" +
							"<br>"+
							"    <p>\n" + 
							"Merci de vous etre inscrit/e a la platforme X. Veullez cliquer sur le lien suivant pour terminer votre inscription " + 
							"<a href="+"http://localhost:8080/PlatformeGDWEB/confirmUser?"+"userId="+utilisateur.getIdut()+"&confirmId="+confirmId+">Confirmer mon inscription</a>"+
							"    </p>\n" +
							"<br>"+
							"    <p>\n" + 
							"  Cordialement, "+
							"    </p>\n" +
							"    </body>\n" + 
							"</html>";
					emailManagement emailManagement = new emailManagement();
					javax.mail.internet.InternetAddress ia;
					try {
						ia = new javax.mail.internet.InternetAddress(to);
					    ia.validate();
					} catch (javax.mail.internet.AddressException ae) {

					}
					emailManagement.sendEmail(to, subject, body);
					request.setAttribute("errur1", "un email de confirmation vous a été envoyé, veuillez cliquer sur le lien de confirmation !");
					request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
					
				} else {
					request.setAttribute("erreur", "adresse email existe");
//				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		request.getRequestDispatcher("InscriptionEtablissement.jsp").forward(request, response);
	}

}
