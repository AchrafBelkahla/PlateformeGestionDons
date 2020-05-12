package filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

	
    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("", "/LoginPage", "/InscriptionEtablissement", "/InscriptionUtilisateur", "/index.jsp")));
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/LoginPage";
        
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", ""); 
        
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        //boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean allowedPath = ALLOWED_PATHS.contains(path);
//        System.out.println("**************************** before test ******************************************");
        if (loggedIn || allowedPath) 
        {
            chain.doFilter(request, response);
        } 
        else 
        {
            response.sendRedirect(loginURI);
        }
		
	}
}
