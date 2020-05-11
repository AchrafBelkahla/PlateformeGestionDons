package web.dashboard_ministere;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Reglement;
import metier.session.PlatformGDLocal;


@WebServlet("/supprimer_don_reglement")
public class ServletSupprimerDonReglement extends HttpServlet {

	@EJB
	private PlatformGDLocal metier;
	private static final long serialVersionUID = 1L;
     
    public ServletSupprimerDonReglement() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code_suppression_don_reglement = (String) request.getParameter("code_reglement");
		if (!code_suppression_don_reglement.equals(null)) {
        	Reglement reglement = metier.getDonEnReglementById(code_suppression_don_reglement);
        	reglement.setEstSupprime(true);
        	metier.updateReglement(reglement);
        	////////////////notifier l'utilisateur que son don est supprimé
        	request.getRequestDispatcher("Dashboard_ministere/ListesDons.jsp").forward(request, response);
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
