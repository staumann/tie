package backend.servlet.race;

import backend.core.BackendServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetRaces
 */
@WebServlet("/GetRaces")
public class GetRaces extends BackendServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String raceId = request.getParameter("raceId");
		if(raceId == null) {
			this.putObjectToResponse(response, getRaceHelper().getRaces());
		}else {
			this.putObjectToResponse(response, getRaceHelper().getRace(raceId));
		}
		
	}
	
	@Override
	public Authentication getRequiredAuthenticationMethod() {
		return Authentication.Admin;
	}

}
