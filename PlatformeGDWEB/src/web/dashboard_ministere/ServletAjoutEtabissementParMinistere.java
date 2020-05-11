package web.dashboard_ministere;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Adresse;
import metier.entities.Etablisement;
import metier.session.PlatformGDLocal;

@WebServlet("/AjoutEtablissement")
public class ServletAjoutEtabissementParMinistere extends HttpServlet{
	@EJB
	private PlatformGDLocal metier;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Dashboard_ministere/AjoutEtablissementParMinister.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String NomEtab = req.getParameter("input11");
			String type = req.getParameter("input12");
			String labellee = req.getParameter("input13");

			Etablisement etablisement = new Etablisement();
			etablisement.setNomEtablissement(NomEtab);
			etablisement.setIntermediaire(type.equals("intermediaire"));
			etablisement.setHospital(type.equals("Hospital"));
			etablisement.setMinistraire(type.equals("ministere"));
			etablisement.setDrs(type.equals("drs"));
			etablisement.setLibelle(labellee);
////////////////////////////////////////////////////////////////////////////////////////
			
			String c1 = req.getParameter("input7");
			String c2 = req.getParameter("input8");
			String c3 = req.getParameter("input9");

			Adresse adresse = new Adresse();
			adresse.setGouvernorat(c1);
			adresse.setCodePostale(Integer.parseInt(c3));
			adresse.setAdresse(c2);
////////////////////////////////////////////////////////////////////////////////////////
			etablisement.setAdresse(adresse);
			metier.ajouteadresse(adresse);
			metier.ajouteetablissement(etablisement);
		} catch (Exception e) {
			// TODO: handle exception
		}
		req.getRequestDispatcher("Dashboard_ministere/AjoutEtablissementParMinister.jsp").forward(req, resp);
	}
}
