package backend.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.core.BackendServlet;

/**
 * Servlet implementation class ShowSettings
 */
@WebServlet({ "/ShowSettings", "/settings" })
public class ShowSettings extends BackendServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSettings() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		this.setTemplate("settings", request);
		this.setDispatcher(request, response);
		
	}

}
