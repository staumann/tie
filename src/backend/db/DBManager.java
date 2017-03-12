package backend.db;

import java.net.UnknownHostException;
import java.util.Set;

import javax.servlet.ServletContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import org.json.JSONObject;

public class DBManager implements DBConnection {

	private String dbName;
	private String hostName;
	private int port;
	private Mongo instance;
	private DB db;
	private String collectionName;
	private String error;
	
	public DBManager(){
		
	}
	
	public DBManager(ServletContext context){
		this.hostName = (String) context.getAttribute("dbHost");
		this.port = (int) context.getAttribute("dbPort");
		this.dbName = (String) context.getAttribute("dbName");
		
		openDBConnection();
		openDB();
	}
	
	@Override
	public void setDBName(String dbName) {
		// set this dbName
		if(dbName != null){
			if(!dbName.equals("")){
				this.dbName = dbName;
			}
		}
	}

	@Override
	public String getDBName() {
		// Return this.dbName;
		if(this.dbName != null){
			return this.dbName;
		}else{
			return "notSet";
		}
	}

	@Override
	public void setHostName(String hostName) {
		// set this hostName
		if(hostName != null){
			if(!hostName.equals("")){
				this.hostName = hostName;
			}
		}
	}

	@Override
	public String getHostName() {
		// return this.hostName
		if(this.hostName != null){
			return this.hostName;
		}else{
			System.out.println("Hostname was not set!");
			return "notSet";
		}
	}

	@Override
	public void setPort(int port) {
		// set this.Port
		if(port > 1024){
			this.port = port;
		}else{
			System.out.println("The Portnumber is not within normal Parameters");
		}
	}

	@Override
	public int getPort() {
		// return this.port
		return this.port;
	}

	@Override
	public void setCollectionName(String collectionName) {
		// set this.CollectionsName
		
		if(collectionName != null){
			if(!collectionName.equals("")){
				this.collectionName = collectionName;
			}
		}
	}

	@Override
	public String getCollectionName() {
		// return this.collectionName
		if(this.collectionName != null){
			return this.collectionName;
		}else{
			System.out.println("Collectionname was not set!");
			return "notSet";
		}
	}
	
	@Override
	public void saveObject(DBObject obj) {
		// Speichert das Object in der Collection
					
		if(!this.getCollectionName().equals("notSet")){
			if(this.instance != null){
				this.db.getCollection(this.getCollectionName()).insert(obj);
			}
		}
	}

	@Override
	public com.mongodb.DBCursor getObjects(DBObject key) {
		// returns objects with fit the given Arguments
		
		if(key != null){
			if(this.instance == null){
				this.openDBConnection();
			}
			if(this.db == null){
				this.openDB();
			}
			if(!this.getCollectionName().equals("notSet")){
				return this.db.getCollection(this.getCollectionName()).find(key);
			}
		}
		return null;
	}

	@Override
	public void openDBConnection() {
		System.out.println( "HostName: " + this.getHostName() + " | PORT: " + this.getPort());
		// TODO Auto-generated method stub
		try{
			this.instance = new Mongo(this.hostName, this.port);
			this.error = "";
		}catch(UnknownHostException e){
			this.error = "No Connection to Database!!!";
			System.out.println(error);
			System.out.println("ErrorMeldung" + e.getMessage());
		}
	}

	@Override
	public void closeDBConnection() {
		// TODO Auto-generated method stub
		if(this.instance != null){
			this.instance.close();
			instance = null;
		}
		
	}

	@Override
	public String getErrors() {
		// TODO Auto-generated method stub
		return this.error;
	}
	public void openDB(){
		this.db = instance.getDB(this.dbName);
	}

	@Override
	public Set<String> getCollectionNames() {
		// TODO Auto-generated method stub
		
		Set<String> temp =  this.db.getCollectionNames();
		
		return  temp;
	}

	@Override
	public JSONObject getCollectionInfos(String CollectionName) {
		
		JSONObject currentJSON = new JSONObject();
		
		
		try{
			currentJSON.put("size", db.getCollection(CollectionName).getCount());
			currentJSON.put("DB", db.getCollection(CollectionName).getDB());
			currentJSON.put("ColName", CollectionName);
		}catch (Exception e){
			System.out.println("Error Creating th JSON Object");
		}
		
		return currentJSON;
	}
	
	public void dropCollection(String CollectionName){
		
		db.getCollection(CollectionName).drop();
	}
	public void setCollection(String collectionName) {
		db.createCollection(collectionName, new BasicDBObject());
	}
}
		