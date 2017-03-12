package backend.servlet.game;

import backend.core.AbstractGameServlet;
import backend.rapi.GameRO;
import backend.rapi.PlayerRO;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class RemoveGames
 */
@WebServlet("/RemoveGames")
public class RemoveGames extends AbstractGameServlet {
	private static final long serialVersionUID = 1L;

   
	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
			ObjectMapper mapper = new ObjectMapper();
			
			String[] games = mapper.readValue(request.getInputStream(), String[].class);
			
			Stream.of(games).forEach(g -> {
				GameRO del = new GameRO();
				PlayerRO plDel = new PlayerRO();
				
				del.setGameId(g);
				plDel.setGameId(gameId);
				getPlayerHelper().removeObject(plDel);
				getGameHelper().removeObject(del);
			});
			
			this.putObjectToResponse(response, getGameHelper().getGames());
		
	}
	
	@Override
	public Authentication getRequiredAuthenticationMethod() {
		return Authentication.Admin;
	}

}
