package backend.core.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Sascha Taumann
 *
 */
public interface ExtendedServlet {
	
	public enum Authentication {
		Admin,
		Game,
		None
	}
	/**
	 * This Function handles the Request of the Servlet
	 * 
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * 
	 * Returns the Required AuthenticationState for this Servlet
	 * 
	 * @return Authentication
	 */
	default Authentication getRequiredAuthenticationMethod() {
		return Authentication.None;
	}
	
	default void setDefaultParameter(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
