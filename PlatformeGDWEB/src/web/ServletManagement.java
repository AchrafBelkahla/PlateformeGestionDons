package web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;
import service.DaoManagement;

@WebServlet("/LoginPage")

public class ServletManagement extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private PlatformGDLocal metier;

	public ServletManagement() {}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if ((Boolean) (session.getAttribute("user") != null)) 
		{
			Utilisateur user = (Utilisateur) session.getAttribute("user");
			if(user.getRole().equals("ministere"))
			{
				request.getRequestDispatcher("/Ministere?currentPage=1").forward(request, response);
			}
			else
			{
				if(user.getRole().equals("responsable") && user.getAccepted().equals(true))
				{
					if(user.getEtablissement().getHospital())
					{
						System.out.println("**************************** hopital ******************************************");
						 request.getRequestDispatcher("/besoins?currentPage=1").forward(request, response);
					}
					else if(user.getEtablissement().getDrs())
					{
						System.out.println("**************************** drs ******************************************");
						 request.getRequestDispatcher("/Liste_Etablissements_Drs").forward(request, response);
					}
					
				}
				else {
					if(user.getRole().equals("donateur"))
					{
						request.getRequestDispatcher("/besoinsByEtablissement").forward(request, response);
					} else {
						request.setAttribute("errur1", "Votre compte n'est pas encore validé par le ministere !");
						request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
						}
					
				}
			}
			
		}
		else 
		{
			request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		}
	}
	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		//user already logged in
		if ((Boolean) (session.getAttribute("user") != null)) 
		{
			Utilisateur user = (Utilisateur) session.getAttribute("user");
			if(user.getRole().equals("ministere"))
			{
				request.getRequestDispatcher("/Ministere?currentPage=1").forward(request, response);
			}
			else
			{
				if(user.getRole().equals("responsable") && user.getAccepted().equals(true))
				{
					if(user.getEtablissement().getHospital())
					{
						System.out.println("**************************** hopital ******************************************");
						 //request.getRequestDispatcher("/besoins").forward(request, response);
						 response.sendRedirect("/PlatformeGDWEB/besoins?currentPage=1");
					}
					else if(user.getEtablissement().getDrs())
					{
						System.out.println("**************************** drs ******************************************");
						 request.getRequestDispatcher("/Liste_Etablissements_Drs").forward(request, response);
					}
				}
				else {
					if(user.getRole().equals("donateur"))
					{
						request.getRequestDispatcher("/besoinsByEtablissement").forward(request, response);
					} else {
						request.setAttribute("errur1", " Votre compte n'est pas encore validé par le ministere !");
						request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
					}
				}
			}
			
		}
		
		//user not logged in
		else 
		{
			String username = request.getParameter("username");
			String clearPassword = request.getParameter("password");
			DaoManagement daoManagement = new DaoManagement();
			Utilisateur utilisateur = daoManagement.checkUser(username, clearPassword);
			
			// User found
			if (utilisateur!=null) 
			{
				session.setAttribute("user", utilisateur);
				session.setAttribute("utilisateur", utilisateur);
				
				Utilisateur user = (Utilisateur) session.getAttribute("user");
				if(user.getRole().equals("ministere"))
				{
					request.getRequestDispatcher("/Ministere?currentPage=1").forward(request, response);
				}
				else
				{
					if(user.getRole().equals("responsable") && user.getAccepted().equals(true))
					{
						if(user.getEtablissement().getHospital())
						{
							System.out.println("**************************** hopital ******************************************");
							 //request.getRequestDispatcher("/besoins").forward(request, response);
							 response.sendRedirect("/PlatformeGDWEB/besoins?currentPage=1");
						}
						else if(user.getEtablissement().getDrs())
						{
							System.out.println("**************************** drs ******************************************");
							 request.getRequestDispatcher("/Liste_Etablissements_Drs").forward(request, response);
						}
					}
					else {
						if(user.getRole().equals("donateur"))
						{
							request.getRequestDispatcher("/besoinsByEtablissement").forward(request, response);
						} else {
						request.setAttribute("errur1", "Votre compte n'est pas encore validé par le ministere !");
						session.invalidate();
						request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
						}
					}
				}	
			}
			
			else 
			{
				request.setAttribute("errur1", "Vérifiez votre mot de passe ou votre mail !");
				request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
			}
		}
	}
}