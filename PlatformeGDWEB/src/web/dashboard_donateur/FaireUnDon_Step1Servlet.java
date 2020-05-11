package web.dashboard_donateur;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Besoin;
import metier.entities.Etablisement;
import metier.session.PlatformGDLocal;

@WebServlet(urlPatterns = { "/faire_un_don_step1" })
public class FaireUnDon_Step1Servlet extends HttpServlet {

	@EJB
	private PlatformGDLocal metier;
	
	//@EJB
	//private GestBesoinLocal dao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code_etablissement = (String) req.getParameter("id_etablissement");
		req.setAttribute("beneficiaire", metier.getEtablissementById(code_etablissement));
		req.setAttribute("besoin_etab", metier.getBesoinsByEtablissement(code_etablissement));
		req.getRequestDispatcher("Dashboard_donateur/faireUnDonEnNatureStep1.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idEtablissement = req.getParameter("nom_etablissement");
		String idBesoin = req.getParameter("nom_besoin");
		Besoin besoin = metier.getBesoinById(idBesoin);
		Etablisement etablisement = metier.getEtablissementById(idEtablissement);
		double prixMoy =  (besoin.getProduit().getPrixMax() + besoin.getProduit().getPrixMin() )/2;
		req.setAttribute("etablisement", etablisement);
		req.setAttribute("besoin", besoin);
		req.setAttribute("prixMoy", prixMoy);
		req.getRequestDispatcher("Dashboard_donateur/faireUnDonEnNature.jsp").forward(req, resp);
		
	}
}