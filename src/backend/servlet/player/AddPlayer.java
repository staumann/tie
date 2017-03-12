package backend.servlet.player;

import java.io.IOException;
import java.util.UUID;

import backend.core.AbstractGameServlet;
import backend.rapi.PlayerRO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AddPlayer
 */
@WebServlet("/AddPlayer")
public class AddPlayer extends AbstractGameServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		PlayerRO pRO = mapper.readValue(request.getInputStream(), PlayerRO.class);
		
		pRO.setPlayerId(UUID.randomUUID().toString());
		pRO.setGameId(this.getCurrentGameId(request));
		getPlayerHelper().saveObject(pRO);
		
		resp.setSuccess(Boolean.TRUE);
		
		putObjectToResponse(response, resp);
		
	}

}
