package web.dashboard_ministere;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.DonEnNature;
import metier.entities.Reglement;
import metier.session.PlatformGDLocal;

@WebServlet(urlPatterns = { "/supprimer_don" })
public class SupprimerDonServlet extends HttpServlet{

	@EJB
	private PlatformGDLocal metier;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code_suppression_don_nature = (String) req.getParameter("code_don_en_nature");
        
        if(!code_suppression_don_nature.equals(null)) {
        	DonEnNature don = metier.getDonEnNatureById(code_suppression_don_nature);
        	don.setEstSupprime(true);
        	metier.updateDonEnNature(don);
        	////////////////notifier l'utilisateur que son don est supprimé
        	req.getRequestDispatcher("Dashboard_ministere/ListesDons.jsp").forward(req, resp);
        }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
