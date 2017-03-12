package backend.db;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import backend.core.Dictonary;
import backend.rapi.GameRO;
import backend.rapi.PlayerRO;

import com.mongodb.DBObject;

public class GameHelper extends AbstractDBHelper{
public static String QualifiedName = "GameHelper";
	
	private PlayerHelper playerHelper;
	
	public GameHelper(Dictonary dic) {
		super("db.gameCollection", dic);
	}
	
	public PlayerHelper getPlayerHelper() {
		if(playerHelper == null) {
			playerHelper = (PlayerHelper) this.getDictonary().get(PlayerHelper.QualifiedName);
		}
		
		return playerHelper;
	}
	
	public List<GameRO> getGames() {
		
		List<GameRO> games = null;
		
		List<DBObject> objListe = getCollection().find().toArray();
		
		games = objListe.stream().parallel().map(o -> this.mapObject(o)).collect(Collectors.toList());
		
		return games;
	}
	
	public GameRO getGame(String gameName, String gameId) {
		
		GameRO searchObj = new GameRO();
		
		if(gameName != null) {
			searchObj.setGameName(gameName);
		}
		
		if(gameId != null) {
			searchObj.setGameId(gameId);
		}
		
		List<DBObject> objListe = getCollection().find(searchObj).toArray();
		
		if(objListe.size() > 0) {
			return this.mapObject(objListe.get(0));
		}else {
			return null;
		}
	}
	
	public void saveObject(GameRO game) {
		getCollection().insert(game);
	}
	
	public void removeObject(GameRO game) {
		GameRO g = mapObject(getCollection().find(game).next());
		
		if(!g.getGameName().equals("admin")) {
			getCollection().remove(game);
		}
	}
	
	public Collection<PlayerRO> getPlayers(String gameId) {
		return this.getPlayerHelper().getPlayerForGame(gameId);
	}
	
	private GameRO mapObject(DBObject o) {
		try {
			return getMapper().readValue(o.toString(), GameRO.class);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
