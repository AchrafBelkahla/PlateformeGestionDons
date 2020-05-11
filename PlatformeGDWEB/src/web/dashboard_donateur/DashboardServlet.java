package web.dashboard_donateur;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.entities.Don;
import metier.entities.Produit;
import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;

@WebServlet(urlPatterns = { "/profilDonateur" })
public class DashboardServlet extends HttpServlet {

	@EJB
	private PlatformGDLocal metier;
	
	//@EJB
	//private GestBesoinLocal dao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		req.setAttribute("user",user);
		req.setAttribute("telephone", user.getTelephone().get(0));
		req.setAttribute("donsEnNature", metier.getDonEnNatureByDonnateur(user.getIdut()));
		req.setAttribute("reglements", metier.getReglementByDonnateur(user.getIdut()));

		req.getRequestDispatcher("Dashboard_donateur/dashboard.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{

		String idDon = request.getParameter("id");
		String type = request.getParameter("type");
		Don don;
		if(type == "n")
			don = metier.getDonEnReglementById(idDon);
		else
			don = metier.getDonEnNatureById(idDon);
		metier.deleteDon(idDon);
		response.getWriter().println(true);
	}
}
