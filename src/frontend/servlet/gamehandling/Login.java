package frontend.servlet.gamehandling;

import java.io.IOException;

import backend.core.TieServlet;
import backend.mgr.SessionMgr;
import backend.rapi.GameRO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends TieServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		GameRO game = mapper.readValue(request.getInputStream(), GameRO.class);
		
		GameRO selectedGame = getGameHelper().getGame(game.getGameName(), null);
		
		if(selectedGame == null) {
			response.setStatus(500);
		}else {			
			if(game.getPw().equals(selectedGame.getPw())) {
				SessionMgr.loginSession(selectedGame.getGameId(), request, selectedGame.getGameName().equals("admin") ? Authentication.Admin : Authentication.Game);
				resp.setSuccess(Boolean.TRUE);
				
				if(SessionMgr.isAdmin(request)) {
					resp.setTargetUrl("/tie/ShowSettings");
				}else {
					resp.setTargetUrl("/tie/Overview");
				}
			}else {
				resp.setSuccess(Boolean.FALSE);
			}
			
			this.putObjectToResponse(response, resp);
		}
		
	}

}
