package web.dashboard_ministere;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Besoin;
import metier.entities.DonEnNature;
import metier.entities.Reglement;
import metier.session.PlatformGDLocal;

@WebServlet(urlPatterns = { "/accepter_don" })
public class AccepterDonServlet extends HttpServlet {

	@EJB
	private PlatformGDLocal metier;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code_accept_don_nature = (String) req.getParameter("code_don_en_nature");

		if (!code_accept_don_nature.equals(null)) {
			DonEnNature don = metier.getDonEnNatureById(code_accept_don_nature);

			if (don.isEstAccepte()) {
				req.getRequestDispatcher("Dashboard_ministere/ListesDons.jsp").forward(req, resp);
			} else {
				don.setEstAccepte(true);
				String id_besoin = don.getBesoin().getIdBesoin();
				Besoin besoin = metier.getBesoinById(id_besoin);
				String id = besoin.getIdBesoin();
				System.out.println(id);
				besoin.setEtat("en cours");
				besoin.setQuantiteRestante(besoin.getQuantiteInitiale() - don.getQuantite());
				metier.updateBesoin(besoin);
				metier.updateDonEnNature(don);
				req.getRequestDispatcher("Dashboard_ministere/ListesDons.jsp").forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
