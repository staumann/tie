package backend.rapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;

public class RaceRO extends BasicDBObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4988518096109404004L;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private String raceName;
	private String raceId;
	private String description;
	private Integer battleValueCruiser;
	private Integer battleValueDestroyer;
	private Integer battleValueDestroyerAnitFighter;
	private Integer battleValueDreadnought;
	private Integer battleValueFreighter;
	private Integer battleValueFighter;
	private Integer battleValueGroundForce;
	private Integer battleValueWarSun;
	private Integer battleValuePDS;
	private Integer battleValueMech;
	private Integer tradeContract1;
	private Integer tradeContract2;
	private String startingTechs;
	private BattleGroupRO startingUnits;
	
	public String getRaceName() {
		
		if(this.raceName == null) {
			this.raceName = this.getString("raceName");
		}
		
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
		
		this.put("raceName", this.raceName);
		
	}
	public String getRaceId() {
		
		if(this.raceId == null) {
			this.raceId = this.getString("raceId");
		}
		return raceId;
	}
	public void setRaceId(String raceId) {
		this.raceId = raceId;
		
		this.put("raceId", this.raceId);
	}
	public String getDescription() {
		
		if(this.description == null) {
			this.description = this.getString("description");
		}
		
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		this.put("description", this.description);
	}
	public Integer getBattleValueCruiser() {
		
		if(this.battleValueCruiser == null) {
			this.battleValueCruiser = new Integer(this.getInt("battleValueCruiser"));
		}
		
		return battleValueCruiser;
	}
	public void setBattleValueCruiser(Integer battleValueCruiser) {
		this.battleValueCruiser = battleValueCruiser;
		this.put("battleValueCruiser", battleValueCruiser);
	}
	public Integer getBattleValueDestroyer() {
		
		if(this.battleValueDestroyer == null) {
			this.battleValueDestroyer = new Integer(this.getInt("battleValueDestroyer"));
		}
		
		
		return battleValueDestroyer;
	}
	public void setBattleValueDestroyer(Integer battleValueDestroyer) {
		this.battleValueDestroyer = battleValueDestroyer;
		this.put("battleValueDestroyer", battleValueDestroyer);
	}
	public Integer getBattleValueDreadnought() {
		
		if(this.battleValueDreadnought == null) {
			this.battleValueDreadnought = new Integer(this.getInt("battleValueDreadnought"));
		}
		
		return battleValueDreadnought;
	}
	public void setBattleValueDreadnought(Integer battleValueDreadnought) {
		this.battleValueDreadnought = battleValueDreadnought;
		this.put("battleValueDreadnought", battleValueDreadnought);
	}
	public Integer getBattleValueFighter() {
		
		if(this.battleValueFighter == null) {
			this.battleValueFighter = new Integer(this.getInt("battleValueFighter"));
		}
		
		
		return battleValueFighter;
	}
	public void setBattleValueFighter(Integer battleValueFighter) {
		this.battleValueFighter = battleValueFighter;
		this.put("battleValueFighter", battleValueFighter);
	}
	public Integer getBattleValueGroundForce() {
		
		if(this.battleValueGroundForce == null) {
			this.battleValueGroundForce = new Integer(this.getInt("battleValueGroundForce"));
		}
		
		return battleValueGroundForce;
	}
	public void setBattleValueGroundForce(Integer battleValueGroundForce) {
		this.battleValueGroundForce = battleValueGroundForce;
		this.put("battleValueGroundForce", battleValueGroundForce);
	}
	public Integer getBattleValuePDS() {
		
		if(this.battleValuePDS == null) {
			this.battleValuePDS = new Integer(this.getInt("battleValuePDS"));
		}
		
		return battleValuePDS;
	}
	public void setBattleValuePDS(Integer battleValuePDS) {
		this.battleValuePDS = battleValuePDS;
		this.put("battleValuePDS", battleValuePDS);
	}
	public Integer getBattleValueMech() {
		
		if(this.battleValueMech == null) {
			this.battleValueMech = new Integer(this.getInt("battleValueMech"));
		}
		
		return battleValueMech;
	}
	public void setBattleValueMech(Integer battleValueMech) {
		this.battleValueMech = battleValueMech;
		this.put("battleValueMech", battleValueMech);
	}
	public Integer getTradeContract1() {
		
		if(this.tradeContract1 == null) {
			this.tradeContract1 = new Integer(this.getInt("tradeContract1"));
		}
		
		return tradeContract1;
	}
	public Integer getTradeContract2() {
		
		if(this.tradeContract2 == null) {
			this.tradeContract2 = new Integer(this.getInt("tradeContract2"));
		}
		
		return tradeContract2;
	}
	public void setTradeContract1(Integer tradeContract1) {
		this.tradeContract1 = tradeContract1;
		this.put("tradeContract1", tradeContract1);
	}
	public void setTradeContract2(Integer tradeContract2) {
		this.tradeContract2 = tradeContract2;
		this.put("tradeContract1", tradeContract2);
	}
	public Integer getBattleValueFreighter() {
		
		if(this.battleValueFreighter == null) {
			this.battleValueFreighter = new Integer(this.getInt("battleValueFreighter"));
		}
		
		return battleValueFreighter;
	}
	public void setBattleValueFreighter(Integer battleValueFreighter) {
		this.battleValueFreighter = battleValueFreighter;
		this.put("battleValueFreighter", battleValueFreighter);
	}
	public String getStartingTechs() {
		
		if(this.startingTechs == null) {
			this.startingTechs = this.getString("startingTechs");
		}
		return startingTechs;
	}
	public void setStartingTechs(String startingTechs) {
		this.startingTechs = startingTechs;
		this.put("startingTechs", startingTechs);
	}
	public BattleGroupRO getStartingUnits() {
		
		if(this.startingUnits == null) {
			
			try {
				this.startingUnits = mapper.readValue(this.getString("startingUnits"), BattleGroupRO.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return startingUnits;
	}
	public void setStartingUnits(BattleGroupRO startingUnits) {
		this.startingUnits = startingUnits;
		try {
			this.put("startingUnits", mapper.writeValueAsString(startingUnits));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Integer getBattleValueDestroyerAnitFighter() {
		
		if(this.battleValueDestroyerAnitFighter == null) {
			this.battleValueDestroyerAnitFighter = new Integer(this.getInt("battleValueDestroyerAnitFighter"));
		}
		return battleValueDestroyerAnitFighter;
	}
	public void setBattleValueDestroyerAnitFighter(
			Integer battleValueDestroyerAnitFighter) {
		this.battleValueDestroyerAnitFighter = battleValueDestroyerAnitFighter;
		this.put("battleValueDestroyerAnitFighter", battleValueDestroyerAnitFighter);
	}
	public Integer getBattleValueWarSun() {
		
		if(this.battleValueWarSun == null) {
			this.battleValueWarSun = new Integer(this.getInt("battleValueWarSun"));
		}
		
		return battleValueWarSun;
	}
	public void setBattleValueWarSun(Integer battleValueWarSun) {
		this.battleValueWarSun = battleValueWarSun;
		this.put("battleValueWarSun", battleValueWarSun);
	}
}
