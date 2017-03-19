package backend.rapi;


import com.fasterxml.jackson.databind.ObjectMapper;
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
	private RaceRO abillitys;
	
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
	public RaceRO getAbillitys() {
		if(this.abillitys == null) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				this.abillitys = mapper.readValue(this.getString("abillitiys"),RaceRO.class);
			}catch (Exception e) {
				this.abillitys = null;
				System.out.println(e.getMessage());
			}
		}
		return abillitys;
	}
	public void setAbillitys(RaceRO abillitys) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			this.put("abillitys",mapper.writeValueAsString(abillitys));
		}catch (Exception e) {
			System.out.println(e.getMessage());
			this.abillitys = null;
		}
		this.abillitys = abillitys;
	}
	
}
