package backend.rapi;

import com.mongodb.BasicDBObject;

public class PlayerRO extends BasicDBObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6430137482383904559L;
	private String playerName;
	private String raceId;
	private String gameId;
	private String playerId;
	
	public String getPlayerName() 
	{	
		if(playerName == null) {
			playerName = this.getString("playerName");
		}
		
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
		this.put("playerName", playerName);
	}
	public String getRaceId() {
		if(raceId == null) {
			this.raceId = this.getString("raceId");
		}
		return raceId;
		
	}
	public void setRaceId(String raceId) {
		this.raceId = raceId;
		this.put("raceId", raceId);
	}
	public String getGameId() {
		if(gameId == null) {
			gameId = this.getString("gameId");
		}
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
		this.put("gameId", gameId);
	}
	public String getPlayerId() {
		if(playerId == null) {
			playerId = this.getString("playerId");
		}
		
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
		this.put("playerId", playerId);
	}
	
}
