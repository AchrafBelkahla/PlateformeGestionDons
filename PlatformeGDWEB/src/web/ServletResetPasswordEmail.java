package web;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.entities.Adresse;
import metier.entities.Telephone;
import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;
import service.DaoManagement;
import service.emailManagement;

@WebServlet("/resetPwdEmail")
public class ServletResetPasswordEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	

	
	
	public ServletResetPasswordEmail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("resetPasswordEmail.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		
		String email = request.getParameter("email");
		if(dao.veriff(email)!=null)
		{

			Utilisateur utilisateur = dao.veriff(email);
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
					"        Chere/Cher," +
					"    </p>\n" +
					"<br>"+
					"    <p>\n" + 
					"Veullez cliquer sur le lien suivant pour réinitialiser votre mot de passe " + 
					"<a href="+"http://197.14.56.37:8080/PlatformeGDWEB/resetPwd?"+"userId="+utilisateur.getIdut()+">réinitialiser mon mot de passe</a>"+
					"    </p>\n" +
					"    </body>\n" + 
					"</html>";
			emailManagement emailManagement = new emailManagement();
			javax.mail.internet.InternetAddress ia;
			try {
				ia = new javax.mail.internet.InternetAddress(email);
			    ia.validate();
			} catch (javax.mail.internet.AddressException ae) {

			}
			emailManagement.sendEmail(email, subject, body);
			request.setAttribute("message","Un lien de reinitialisation de mot de passe vous a été envoyé !");
			request.getRequestDispatcher("resetPasswordEmail.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("message","Aucun compte n'est assoicé a cette adresse email !");
			request.getRequestDispatcher("resetPasswordEmail.jsp").forward(request, response);
		}
		
		
		

		
		
		
		
		
			


		
	}
}
