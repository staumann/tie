package backend.db;

import java.util.List;
import java.util.stream.Collectors;

import com.mongodb.DBObject;

import backend.core.Dictonary;
import backend.rapi.RaceRO;

public class RaceHelper extends AbstractDBHelper{
	
	public static String QualifiedName = "RaceHelper";
	
	public RaceHelper(Dictonary dic) {
		super("db.raceCollection", dic);
	}
	
	public List<RaceRO> getRaces() {
		List<RaceRO> races = null;
		
		List<DBObject> objListe = getCollection().find().toArray();
		
		races = objListe.stream().parallel().map(o -> this.mapObject(o)).collect(Collectors.toList());
		
		return races;
	}
	
	public RaceRO getRace(String raceId) {
		RaceRO searchObj = new RaceRO();
		
		searchObj.setRaceId(raceId);
		
		List<DBObject> objListe = getCollection().find(searchObj).toArray();
		
		if(objListe.size() > 0) {
			return this.mapObject(objListe.get(0));
		}else {
			return null;
		}
	}
	
	private RaceRO mapObject(DBObject o) {
		try {
			return getMapper().readValue(o.toString(), RaceRO.class);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
