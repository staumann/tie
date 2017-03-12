package frontend.servlet.gamehandling;

import java.io.IOException;
import java.util.UUID;

import backend.core.TieServlet;
import backend.rapi.GameRO;
import backend.rapi.ResponseObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class CreateGame
 */
@WebServlet("/CreateGame")
public class CreateGame extends TieServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateGame() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		GameRO game = mapper.readValue(request.getInputStream(), GameRO.class);
		
		game.setGameId(UUID.randomUUID().toString());
		
		getGameHelper().saveObject(game);
		
		ResponseObject resp = new ResponseObject();
		
		resp.setSuccess(Boolean.TRUE);
		resp.setTargetUrl("/tie/Start");
		this.putObjectToResponse(response, resp);
		
	}

	@Override
	public Authentication getRequiredAuthenticationMethod() {
		// TODO Auto-generated method stub
		return Authentication.None;
	}

}
