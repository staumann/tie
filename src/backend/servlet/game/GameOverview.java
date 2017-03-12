package backend.servlet.game;

import java.io.IOException;

import backend.core.AbstractGameServlet;
import backend.core.TieServlet;
import backend.mgr.SessionMgr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GameOverview
 */
@WebServlet("/Overview")
public class GameOverview extends AbstractGameServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GameOverview() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("players", this.getGameHelper().getPlayers((String) SessionMgr.getSessionAttribute(TieServlet.gameId, request)));
		request.setAttribute("races", this.getRaceHelper().getRaces());
		this.setTemplate("overview", request);
		this.setDispatcher(request, response);
		
	}
	
	@Override
	public Authentication getRequiredAuthenticationMethod() {
		return Authentication.Game;
	}

}
