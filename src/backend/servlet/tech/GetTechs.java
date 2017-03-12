package backend.servlet.tech;

import java.io.IOException;

import backend.core.BackendServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTechs
 */
@WebServlet("/GetTechs")
public class GetTechs extends BackendServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetTechs() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		this.putObjectToResponse(response, getTechHelper().getTechs());
		
	}

}
