package backend.db;

import backend.core.Dictonary;
import backend.core.PropertiesMgr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public abstract class AbstractDBHelper {
	private Dictonary dic;
	private DB cdb;
	private DBCollection col;
	private ObjectMapper mapper;
	private String collectionName;
	
	public AbstractDBHelper(String collection, Dictonary dic) {
		this.collectionName = collection;
		this.dic = dic;
	}
	
	public Dictonary getDictonary() {
		return this.dic;
	}
	
	public DB getCurrentDB() {
		if(this.cdb == null) {
			this.cdb = (DB) dic.get("currentDB");
		}
		
		return cdb;
	}
	
	public ObjectMapper getMapper() {
		if(this.mapper == null) {
			this.mapper = new ObjectMapper();
		}
		
		return this.mapper;
	}
	
	public DBCollection getCollection() {
		if(this.col == null) {
			this.col = getCurrentDB().getCollection(getDBProp().getKey(collectionName));
		}
		
		return this.col;
	}
	
	private PropertiesMgr getDBProp() {
		return (PropertiesMgr) dic.get("dbProp");
	}
}
