package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Adresse;
import metier.entities.Telephone;
import metier.entities.Utilisateur;
import metier.session.PlatformGDImpl;
import metier.session.PlatformGDLocal;
import service.DaoManagement;

/**
 * Servlet implementation class AjoutEtudiant
 */
@WebServlet("/InscriptionUtilisateur")
public class InscriptionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal metier;

	public InscriptionUtilisateur() {
		metier = new PlatformGDImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("InscriptionUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String nom = request.getParameter("input11");
			String prenom = request.getParameter("input21");
			String email = request.getParameter("input31");
			String password = request.getParameter("input41");

			Utilisateur utilisateur = new Utilisateur();

			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setMdp(password);
			utilisateur.setRole("donateur");
			utilisateur.setEtatDecompte(true);
			DaoManagement daoManagement = new DaoManagement();

			System.out.print("************************************************************************");
			
			List<Telephone> liste_telephone = new ArrayList<Telephone>();
			String Tel = request.getParameter("input61");
			Telephone telephone = new Telephone();
			telephone.setNumero(Tel);
			liste_telephone.add(telephone);
			System.out.println("********************************************************************");

			String c1 = request.getParameter("input71");
			String c2 = request.getParameter("input81");
			String c3 = request.getParameter("input91");

			Adresse adresse = new Adresse();
			adresse.setGouvernorat(c1);
			adresse.setCodePostale(Integer.parseInt(c3));
			adresse.setAdresse(c2);
			
			System.out.println("**********************************************************************");
//			if (Pattern.matches("[7]{1}[0-9]{7}", Tel) && Pattern.matches("[a-zA-Z] ", role)
//					&& Pattern.matches("[0-9] ", c3) && Pattern.matches("[a-zA-Z] ", c2)
//
//					&& Pattern.matches("[a-zA-Z] ", nom) && Pattern.matches("[a-zA-Z]", prenom)
//					&& Pattern.matches("[a-zA-Z 0-9]", password)
//					&& email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				if (metier.veriff(email) == false) {
					metier.ajouteadresse(adresse);
					metier.ajoutetelephone(telephone);
					utilisateur.setAdresse(adresse);
					utilisateur.setTelephone(liste_telephone);
//					String l3 = daoManagement.ajouteUtilisateur(utilisateur);
//					String l1 = metier.ajoutetelephone(telephone);
//					String l2 = metier.ajouteadresse(adresse);
					//metier.ajout_ut_tel(l1, l2, l3);
					daoManagement.ajouteUtilisateur(utilisateur);
				} else {
					request.setAttribute("erreur", "adresse email existe");
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ereuuuuuuuuuuuuur");
		}

		request.getRequestDispatcher("InscriptionUtilisateur.jsp").forward(request, response);
	}

}
