package web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.session.PlatformGDLocal;

@WebServlet("/LogOut")

public class ServletLogout extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private PlatformGDLocal metier;

	public ServletLogout() {}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		session.invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
}