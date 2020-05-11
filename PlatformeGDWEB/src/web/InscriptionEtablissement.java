package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.entities.Adresse;
import metier.entities.Etablisement;
import metier.entities.Telephone;
import metier.entities.Utilisateur;
import metier.session.PlatformGDImpl;
import metier.session.PlatformGDLocal;
import service.DaoManagement;

/**
 * Servlet implementation class AjoutEtudiant
 */
@WebServlet("/InscriptionEtablissement")
public class InscriptionEtablissement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal metier;

	public InscriptionEtablissement() {
		metier = new PlatformGDImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("etablissements", metier.getAllEtablissement());
		request.getRequestDispatcher("InscriptionEtablissement.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id_etablissement = request.getParameter("nom_etab");
			Etablisement etablissement = metier.findetablissement(id_etablissement);
			String nom = request.getParameter("input1");
			String prenom = request.getParameter("input2");
			String email = request.getParameter("input3");
			String password = request.getParameter("input4");

			Utilisateur utilisateur = new Utilisateur();

			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setMdp(password);
			utilisateur.setEtatDecompte(true);
			utilisateur.setAccepted(false);
			utilisateur.setRole("responsable");
			DaoManagement daoManagement = new DaoManagement();
			
//////////////////////////////////////////////////////////////////////
			List<Telephone> collection_tel = new ArrayList<Telephone>();
			collection_tel.addAll(etablissement.getTelephones());
			
			String Tel = request.getParameter("input6");
			Telephone telephone = new Telephone();
			telephone.setNumero(Tel);
			collection_tel.add(telephone);
			
			String FAX = request.getParameter("input10");
			Telephone fax = new Telephone();
			fax.setNumero("Fax:" + FAX);
			collection_tel.add(fax);
///////////////////////////////////////////////////////////////////////	
			List<Utilisateur> collection_utilisateur = new ArrayList<Utilisateur>();
			collection_utilisateur.addAll(etablissement.getUtilisateurs());
			
			collection_utilisateur.add(utilisateur);
			System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++");
				if (metier.veriff(email) == false) {
					metier.ajoutetelephone(telephone);
					metier.ajoutetelephone(fax);
					etablissement.setUtilisateurs(collection_utilisateur);
					utilisateur.setEtablissement(etablissement);
					utilisateur.setTelephone(collection_tel);
					daoManagement.ajouteUtilisateur(utilisateur);
					metier.updateEtablisement(etablissement);
				} else {
					request.setAttribute("erreur", "adresse email existe");
//				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		request.getRequestDispatcher("InscriptionEtablissement.jsp").forward(request, response);
	}

}
