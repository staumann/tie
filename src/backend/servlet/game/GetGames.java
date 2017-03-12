package backend.servlet.game;

import backend.core.TieServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetGames
 */
@WebServlet("/GetGames")
public class GetGames extends TieServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		this.putObjectToResponse(response, this.getGameHelper().getGames());
		
	}
	
	@Override
	public Authentication getRequiredAuthenticationMethod() {
		return Authentication.Admin;
	}
}
