package frontend.servlet.gamehandling;

import backend.core.TieServlet;
import backend.mgr.SessionMgr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends TieServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Logout() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		SessionMgr.logoutSession(request);
		this.resp.setSuccess(Boolean.TRUE);
		
		this.putObjectToResponse(response, resp);		
		
	}
	
	
}
