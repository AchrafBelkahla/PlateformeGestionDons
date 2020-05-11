package web.dashboard_donateur;

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

@WebServlet("/editPassword")
public class ServletEditPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	

	
	
	public ServletEditPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("Dashboard_donateur/editPassword.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		DaoManagement daoManagement = new DaoManagement();

		
		String previousPwd = request.getParameter("previous_password");
		String newPwd = request.getParameter("password");
		String confirmPwd = request.getParameter("confirm_password");
		if((daoManagement.checkUser(user.getEmail(), previousPwd)!=null)&&(newPwd.equals(confirmPwd)))
		{
			String newPwdHashed = daoManagement.hashPassword(newPwd);
			user.setMdp(newPwdHashed);
			dao.updateUtilisateur(user);
			session.setAttribute("user", user);
			request.setAttribute("errorMsg",false);
			request.getRequestDispatcher("Dashboard_donateur/editPassword.jsp").forward(request,response);
		}
		else
		{
			request.setAttribute("errorMsg",true);
			request.getRequestDispatcher("Dashboard_donateur/editPassword.jsp").forward(request, response);
		}
		
		
		

		
		
		
		
		
			


		
	}
}
