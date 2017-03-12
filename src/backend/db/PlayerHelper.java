package backend.db;

import java.util.List;
import java.util.stream.Collectors;

import com.mongodb.DBObject;

import backend.core.Dictonary;
import backend.rapi.PlayerRO;

public class PlayerHelper extends AbstractDBHelper {

	public static String QualifiedName = "PlayerHelper";
	
	public PlayerHelper(Dictonary dic) {
		super("db.playerCollection", dic);
	}
	
	public List<PlayerRO> getPlayerForGame(String gameId) {
		
		PlayerRO obj = new PlayerRO();
		
		obj.setGameId(gameId);
		
		List<DBObject> objListe = this.getCollection().find(obj).toArray();
		
		if(objListe != null) {
			return objListe.stream().parallel().map(o -> mapObject(o)).collect(Collectors.toList());
		}else {
			return null;
		}
	}
	
	public void saveObject(PlayerRO playerRO) {
		getCollection().insert(playerRO);
	}
	
	public void removeObject(PlayerRO playerRO) {
		getCollection().remove(playerRO);
	}

	private PlayerRO mapObject(DBObject o) {
		try {
			return getMapper().readValue(o.toString(), PlayerRO.class);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
