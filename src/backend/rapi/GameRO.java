package backend.rapi;

import com.mongodb.BasicDBObject;

public class GameRO extends BasicDBObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String gameId;
	private String gameName;
	private String pw;
	public String getGameId() {
		
		if(this.gameId == null) {
			this.gameId = this.getString("gameId");
		}
		
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
		this.put("gameId", gameId);
	}
	public String getGameName() {
		
		if(this.gameName == null) {
			this.gameName = this.getString("gameName");
		}
		
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
		this.put("gameName", gameName);
	}
	public String getPw() {
		
		if(this.pw == null) {
			this.pw = this.getString("pw");
		}
		
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
		this.put("pw", pw);
	}
}
