package backend.core;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class BackendServlet
 */
@WebServlet("/BackendServlet")
public abstract class BackendServlet extends TieServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public Authentication getRequiredAuthenticationMethod() {
		return Authentication.Admin;
	}

}
