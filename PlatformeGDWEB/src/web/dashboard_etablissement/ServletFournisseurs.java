package web.dashboard_etablissement;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Fournisseur;
import metier.session.PlatformGDLocal;


@WebServlet("/fournisseurs")
public class ServletFournisseurs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	
	public ServletFournisseurs() {
		super();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			List<Fournisseur> fournisseurs = dao.getAllFournisseur();
			request.setAttribute("fournisseurs", fournisseurs);
			request.getRequestDispatcher("Dashboard_etablissement/fournisseurs.jsp").forward(request,response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{

		String idFournisseur = request.getParameter("id");
		Fournisseur fournisseur = dao.getFournisseurById(idFournisseur);
		dao.deleteFournisseur(fournisseur);
		response.getWriter().println(true);
	}

}
