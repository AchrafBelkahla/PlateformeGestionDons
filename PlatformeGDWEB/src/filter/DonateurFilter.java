package filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.entities.Utilisateur;

@WebFilter(urlPatterns = {"/don_en_nature", "/don_reglement", "/faire_un_don", "/besoinsByEtablissement", "/faire_un_don_step1",
     		"/profilDonateur", "/editProfil", "/editPassword"})
public class DonateurFilter implements Filter {

    
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/";

        
        
        
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        Utilisateur user;
		System.out.println("**************************** before test ******************************************");
        if (loggedIn)
        {
        	user = (Utilisateur) session.getAttribute("user");
        	if(user.getRole().equals("donateur")) 
        	{
    			System.out.println("**************************** donateur ******************************************");
    			System.out.println(session.getAttribute("user"));
        		chain.doFilter(request, response);
        	}
        }

        
        	else 
	        {
    			System.out.println("**************************** No user ******************************************");
	            response.sendRedirect(loginURI);
	        }
        
		
	}
}