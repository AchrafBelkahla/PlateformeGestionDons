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

@WebServlet("/accepter_don_reglement")
public class ServletAccepterDonReglement extends HttpServlet {
	
	@EJB
	private PlatformGDLocal metier;
	private static final long serialVersionUID = 1L;
       
    public ServletAccepterDonReglement() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code_accept_don_reglement = (String) request.getParameter("code_reglement");
		if (!code_accept_don_reglement.equals(null)) {
			System.out.println("+++++------------------------++++++++");
			Reglement reglement = metier.getDonEnReglementById(code_accept_don_reglement);
			if(reglement.isEstAccepte()) {
				System.out.println("+++++++++++++++");
				request.getRequestDispatcher("Dashboard_ministere/ListesDons.jsp").forward(request, response);
				System.out.println("888888888888888");
			} else {
				System.out.println("++++++++++****************************+");
				reglement.setEstAccepte(true);
				metier.updateReglement(reglement);
				request.getRequestDispatcher("Dashboard_ministere/ListesDons.jsp").forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
