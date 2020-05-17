package web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.session.PlatformGDLocal;


@WebServlet(urlPatterns = { "/acceuil" })
public class ServletIndexPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private PlatformGDLocal metier;
    

    public ServletIndexPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nb_utilisateurs", metier.getUtilisateur().size());
		request.setAttribute("nb_etablissements", metier.getAllEtablissement().size());
		request.setAttribute("nb_donateurs", metier.getAllDonnateurs().size());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
