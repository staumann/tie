package frontend.servlet;

import java.io.IOException;

import backend.core.TieServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends TieServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Start() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		this.setTemplate("start", request);
		this.setDispatcher(request, response);
		
	}

	@Override
	public Authentication getRequiredAuthenticationMethod() {
		// TODO Auto-generated method stub
		return Authentication.None;
	}

}
