package backend.servlet.tech;

import backend.core.BackendServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTech
 */
@WebServlet("/AddTech")
public class AddTech extends BackendServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddTech() {
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("techlist", getTechHelper().getTechs());
		this.setTemplate("newtech", request);
		this.setDispatcher(request, response);
	}

}
