package backend.servlet.race;

import backend.core.BackendServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRace
 */
@WebServlet("/AddRace")
public class AddRace extends BackendServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("techlist", getTechHelper().getTechs());
		this.setTemplate("newrace", request);
		this.setDispatcher(request, response);
		
	}

}
