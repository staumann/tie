package backend.rapi;

import com.mongodb.BasicDBObject;

public class TechnologieRO extends BasicDBObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2703315445986802701L;
	
	
	private String preconditions;
	private String description;
	private String techName;
	private String techId;
	
	public String getTechId() {
		if(this.techId == null) {
			this.techId = this.getString("techId");
		}
		
		return techId;
	}
	public void setTechId(String uuid) {
		this.techId = uuid;
		
		this.put("techId", this.techId);
	}
	public String getTechName() {
		
		if(this.techName == null) {
			this.techName = this.getString("techName");
		}
		
		return this.techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
		
		this.put("techName", this.techName);
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
	public String getPreconditions() {
		
		if(this.preconditions == null) {
			this.preconditions = this.getString("preconditions").toString();
		}
		
		return preconditions;
		
	}
	public void setPreconditions(String preconditions) {
		
		
		this.preconditions = preconditions;
		this.put("preconditions", this.preconditions);
	}
}
