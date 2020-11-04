package web.dashboard_ministere;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Etablisement;
import metier.entities.Telephone;
import metier.entities.Utilisateur;
import metier.session.PlatformGDImpl;
import metier.session.PlatformGDLocal;
import service.DaoManagement;
import service.emailManagement;


/**
 * Servlet implementation for changer responsable
 */

@WebServlet("/changerResponsable")
public class ServletChangerResponsable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal metier;

	public ServletChangerResponsable() {
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
			DaoManagement daoManagement = new DaoManagement();
			int type = Integer.parseInt(request.getParameter("type"));
			String id_etablissement = request.getParameter("id_etablissement");
			Etablisement etablissement = metier.findetablissement(id_etablissement);
			String nom = request.getParameter("input1");
			String prenom = request.getParameter("input2");
			String email = request.getParameter("input3");
			String password = request.getParameter("input4");
			Utilisateur utilisateur;

			//create
			if(type == 1) 
			{
				System.out.println("ok1");
				utilisateur = new Utilisateur();
			}
			//edit
			else 
			{
				utilisateur = etablissement.getUtilisateurs().get(0);
			}

			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setMdp(password);
			utilisateur.setEtatDecompte(true);
			utilisateur.setAccepted(true);
			utilisateur.setRole("responsable");

			
//////////////////////////////////////////////////////////////////////
			List<Telephone> collection_tel = new ArrayList<Telephone>();
//			collection_tel.addAll(etablissement.getTelephones());
			
			String Tel = request.getParameter("input6");
			Telephone telephone = new Telephone();
			telephone.setNumero(Tel);
			collection_tel.add(telephone);
			
			String FAX = request.getParameter("input10");
			Telephone fax = new Telephone();
			fax.setNumero(FAX);
			collection_tel.add(fax);
///////////////////////////////////////////////////////////////////////	
			List<Utilisateur> collection_utilisateur = new ArrayList<Utilisateur>();
//			collection_utilisateur.addAll(etablissement.getUtilisateurs());
			
			collection_utilisateur.add(utilisateur);
		

				if (metier.veriff(email) == null) {
					System.out.println("ok2");
					metier.ajoutetelephone(telephone);
					metier.ajoutetelephone(fax);

					utilisateur.setTelephone(collection_tel);
					String confirmId = UUID.randomUUID().toString();
					utilisateur.setConfirmId(confirmId);
					utilisateur.setConfirmed(false);
					//create
					if(type == 1) 
					{
						etablissement.setUtilisateurs(collection_utilisateur);
						utilisateur.setEtablissement(etablissement);
						daoManagement.ajouteUtilisateur(utilisateur);
						metier.updateEtablisement(etablissement);
					}
					//edit
					else 
					{
						utilisateur.setMdp(daoManagement.hashPassword(password));
						metier.updateUtilisateur(utilisateur);
					}

					System.out.println("ok3");
					
					
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
							"Merci de vous etre inscrit/e a la platforme SanteDonTn. Veullez cliquer sur le lien suivant pour terminer votre inscription " + 
							"<a href="+"http://197.14.56.37:8080/PlatformeGDWEB/confirmUser?"+"userId="+utilisateur.getIdut()+"&confirmId="+confirmId+">Confirmer mon inscription</a>"+
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
					request.setAttribute("message", "un email de confirmation a été envoyé au responsable !");
					
				} else {
					request.setAttribute("message", "Vous avez introduit une adresse email existante !");
//				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		request.getRequestDispatcher("Dashboard_ministere/changerResponsable.jsp").forward(request, response);
//		response.sendRedirect("Ministere?currentPage=1");
	}

}
