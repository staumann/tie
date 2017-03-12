package frontend.servlet.gamehandling;

import backend.core.TieServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewGame
 */
@WebServlet("/NewGame")
public class NewGame extends TieServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		this.setTemplate("newgame", request);
		this.setDispatcher(request, response);
		
	}

	@Override
	public Authentication getRequiredAuthenticationMethod() {
		// TODO Auto-generated method stub
		return Authentication.None;
	}

}
