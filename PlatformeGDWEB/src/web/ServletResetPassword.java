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

@WebServlet("/resetPwd")
public class ServletResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	

	
	
	public ServletResetPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("userId");
		HttpSession session = request.getSession();
		session.setAttribute("userId", email);
		request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String userId = session.getAttribute("userId").toString();

		
		String newPwd = request.getParameter("password");
		String confirmPwd = request.getParameter("confirm_password");
		DaoManagement daoManagement = new DaoManagement();
		
		if(newPwd.equals(confirmPwd))
		{
			Utilisateur user = dao.getUtilisateurById(userId);
			String newPwdHashed = daoManagement.hashPassword(newPwd);
			user.setMdp(newPwdHashed);
			dao.updateUtilisateur(user);
			session.invalidate();
			request.setAttribute("errorMsg",false);
			request.getRequestDispatcher("resetPassword.jsp").forward(request,response);
		}
		else
		{
			request.setAttribute("errorMsg",true);
			request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
		}
		
		
		

		
		
		
		
		
			


		
	}
}
