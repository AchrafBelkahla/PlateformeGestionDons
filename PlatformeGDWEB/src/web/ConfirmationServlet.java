package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;
import service.emailManagement;

@WebServlet(urlPatterns = { "/confirmUser" })
public class ConfirmationServlet extends HttpServlet {
	
	@EJB
	private PlatformGDLocal metier;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userId= request.getParameter("userId");
		String confirmId= request.getParameter("confirmId");
		Utilisateur user = metier.getUtilisateurById(userId);
		
		
		if(confirmId.equals(user.getConfirmId()))
		{
			user.setConfirmed(true);
			request.setAttribute("errur1", "Votre compte a été vérifié avec succés !");
			request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("errur1", "Lien de confirmation non valide !");
			request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		}
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
}
