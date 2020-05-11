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

@WebServlet("/editProfil")
public class ServletEditProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	

	
	
	public ServletEditProfil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		request.setAttribute("user",user);
		request.setAttribute("telephone", user.getTelephone().get(0));
		request.getRequestDispatcher("Dashboard_donateur/editProfil.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");

		
		String prenom = request.getParameter("prenom");
		user.setPrenom(prenom);
		
		String nom = request.getParameter("nom");
		user.setNom(nom);
		
		String tel =request.getParameter("telephone");
		Telephone telephone = user.getTelephone().get(0);
		telephone.setNumero(tel);
		dao.updateTelephone(telephone);
		
		String adresse =request.getParameter("adresse");
		String gouvernorat =request.getParameter("gouvernorat");
		int codePostal =Integer.parseInt(request.getParameter("codePostal"));
		Adresse adr = new Adresse(gouvernorat, adresse, codePostal);
		dao.updateAdresse(adr);
		user.setAdresse(adr);
		
		String email =request.getParameter("email");
		user.setEmail(email);

		
		dao.updateUtilisateur(user);
		session.setAttribute("user", user);
		
		request.getRequestDispatcher("Dashboard_donateur/dashboard.jsp").forward(request,response);
			


		
	}
}
