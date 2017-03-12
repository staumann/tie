package backend.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.db.PlayerHelper;
import backend.mgr.SessionMgr;
import backend.rapi.GameRO;

public abstract class AbstractGameServlet extends TieServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7146195458210832166L;
	private PlayerHelper playerHelper = null;
	public static final String gameName = "gameName";
	
	public String getCurrentGameId(HttpServletRequest request) {
		return (String) SessionMgr.getSessionAttribute(TieServlet.gameId, request);
	}

	public GameRO getCurrentGameRO(HttpServletRequest request) {
		return this.getGameHelper().getGame(null, this.getCurrentGameId(request));
	}

	public PlayerHelper getPlayerHelper() {
		if(playerHelper == null) {
			playerHelper = (PlayerHelper) this.getDictonary().get(PlayerHelper.QualifiedName);
		}
		
		return playerHelper;
	}
	
	@Override 
	public void setDefaultParameter(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute(AbstractGameServlet.gameName, this.getCurrentGameRO(request).getGameName());
	}
}