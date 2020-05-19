package web;

import java.io.IOException;
import java.util.ArrayList;
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
import metier.entities.Telephone;
import metier.entities.Utilisateur;
import metier.session.PlatformGDImpl;
import metier.session.PlatformGDLocal;
import service.DaoManagement;
import service.emailManagement;

/**
 * Servlet implementation class AjoutEtudiant
 */
@WebServlet("/InscriptionUtilisateur")
public class InscriptionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal metier;

	public InscriptionUtilisateur() {
		metier = new PlatformGDImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("InscriptionUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String nom = request.getParameter("input11");
			String prenom = request.getParameter("input21");
			String email = request.getParameter("input31");
			String password = request.getParameter("input41");

			Utilisateur utilisateur = new Utilisateur();

			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setMdp(password);
			utilisateur.setRole("donateur");
			utilisateur.setEtatDecompte(true);
			DaoManagement daoManagement = new DaoManagement();

			System.out.print("************************************************************************");
			
			List<Telephone> liste_telephone = new ArrayList<Telephone>();
			String Tel = request.getParameter("input61");
			Telephone telephone = new Telephone();
			telephone.setNumero(Tel);
			liste_telephone.add(telephone);
			System.out.println("********************************************************************");

			String c1 = request.getParameter("input71");
			String c2 = request.getParameter("input81");
			String c3 = request.getParameter("input91");

			Adresse adresse = new Adresse();
			adresse.setGouvernorat(c1);
			adresse.setCodePostale(Integer.parseInt(c3));
			adresse.setAdresse(c2);
			
			System.out.println("**********************************************************************");

				if (metier.veriff(email) == null) 
				{
					metier.ajouteadresse(adresse);
					metier.ajoutetelephone(telephone);
					utilisateur.setAdresse(adresse);
					utilisateur.setTelephone(liste_telephone);
					String confirmId = UUID.randomUUID().toString();
					utilisateur.setConfirmId(confirmId);
					utilisateur.setConfirmed(true);
					daoManagement.ajouteUtilisateur(utilisateur);

					
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
							"        Chere/Cher," + utilisateur.getPrenom()+
							"    </p>\n" +
							"<br>"+
							"    <p>\n" + 
							"Merci de vous etre inscrit/e a la platforme X. Veullez cliquer sur le lien suivant pour terminer votre inscription " + 
							"<a href="+"http://197.14.56.37:8080/PlatformeGDWEB/confirmUser?"+"userId="+utilisateur.getIdut()+"&confirmId="+confirmId+">Confirmer mon inscription</a>"+
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
				} 
				else 
				{
					request.setAttribute("erreur", "adresse email existe");
					request.getRequestDispatcher("InscriptionUtilisateur.jsp").forward(request, response);
				}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ereuuuuuuuuuuuuur");
		}

		request.getRequestDispatcher("InscriptionUtilisateur.jsp").forward(request, response);
	}

}
