package backend.db;

import java.util.List;
import java.util.stream.Collectors;

import com.mongodb.DBObject;

import backend.core.Dictonary;
import backend.rapi.TechnologieRO;

public class TechHelper extends AbstractDBHelper{

	public static String QualifiedName = "TechHelper";
	
	public TechHelper(Dictonary dic) {
		super("db.techCollection", dic);
	}
	
	
	public List<TechnologieRO> getTechs() {
		
		List<TechnologieRO> techs = null;
		
		List<DBObject> objListe = this.getCollection().find().toArray();
		
		techs = objListe.stream().parallel().map(o -> this.mapObject(o)).collect(Collectors.toList());
		
		return techs;
	}
	
	public TechnologieRO getTechnologie(String techId) {
		TechnologieRO searchObj = new TechnologieRO();
		
		searchObj.setTechId(techId);
		
		List<DBObject> objListe = getCollection().find(searchObj).toArray();
		
		if(objListe.size() > 0) {
			return this.mapObject(objListe.get(0));
		}else {
			return null;
		}
	}
	
	private TechnologieRO mapObject(DBObject o) {
		try {
			return this.getMapper().readValue(o.toString(), TechnologieRO.class);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
