package web.dashboard_etablissement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Besoin;

import metier.entities.Photo;

import metier.session.PlatformGDLocal;



@WebServlet("/besoin")
public class ServletBesoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlatformGDLocal dao;
	
	public ServletBesoin() {
		super();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idBesoin = request.getParameter("idBesoin");
		
		
		Besoin besoin = dao.getBesoinById(idBesoin);
		List<Photo> photos = new ArrayList<Photo>();
		
		if(besoin != null) 
		{
		request.setAttribute("besoin",besoin);
		if( besoin.getPhotoBesoin()!=null)
		{
			photos = besoin.getPhotoBesoin().getPhotos();
		}
		
		
//		System.out.println("***********************");
//		System.out.println("***********************");
//		System.out.println("***********************");
//		System.out.println(fournisseurs.toString());
//		System.out.println(fournisseurs.size());
//		System.out.println("***********************");
//		System.out.println("***********************");
//		System.out.println("***********************");
		
		
		request.setAttribute("photos",photos);
		request.getRequestDispatcher("Dashboard_etablissement/besoin.jsp").forward(request,response);
		}
		else {
			request.getRequestDispatcher("Dashboard_etablissement/404Produit.jsp").forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
