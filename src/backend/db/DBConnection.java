package backend.db;

import java.util.Set;

import com.mongodb.DBObject;
import org.json.JSONObject;
public interface DBConnection {

	
	/**
	 * Setzt den Datenbanknamen
	 * 
	 * @param dbName
	 */
	public void setDBName(String dbName);
	
	/**
	 * Holt den Datenbanknamen
	 * 
	 * @return Datenbanknamen
	 */
	public String getDBName();
	
	/**
	 * Setzt den Hostname / IP-Adresse
	 * 
	 * @param hostName
	 */
	public void setHostName(String hostName);
	
	/**
	 * Holt den Hostnamen
	 * 
	 * @return Hostname / IP-Adresse
	 */
	public String getHostName();
	
	/**
	 * Setzt den Port
	 * 
	 * @param port
	 */
	public void setPort(int port);
	
	/**
	 * Holt die Portnummmer
	 * 
	 * @return port
	 */
	public int getPort();
	
	/**
	 * 
	 * Setzt den Kollektionsnamen
	 * 
	 * @param CollectionName
	 */
	public void setCollectionName(String collectionName);
	
	/**
	 * 
	 * Holt den aktuellen Kollektionsnamen;
	 * 
	 * @return CollectionName
	 */
	public String getCollectionName();
	
	
	/**
	 * Speichert das �bergeben Objekt in der Datenbank
	 * 
	 * 
	 * @param obj
	 */	
	public void saveObject(DBObject obj);
	
	/**
	 * Findet Objekte die auf den �bergebenen Key passen
	 * 
	 * @param key
	 * @return
	 */
	public com.mongodb.DBCursor getObjects(DBObject key);
	
	/**
	 * �ffnet eine Datenbankverbindung
	 * 
	 */
	public void openDBConnection();
	
	/**
	 * 
	 * schlie�t die Datenbankverbindung
	 * 
	 */
	public void closeDBConnection();
	
	/**
	 * 
	 * If there is an connection error this Method will return the Error
	 * Message
	 * 
	 * @return error
	 */
	public String getErrors();
	
	public void openDB();
	
	/**
	 * 
	 * gibt alle Aktuellen Collections in der DB zur�ck
	 */
	public Set<String> getCollectionNames();
	
	/**
	 * 
	 * @param CollectionName
	 * @return Infos for the given Collection
	 */
	public JSONObject getCollectionInfos(String CollectionName);
	
	public void dropCollection(String CollectionName);
}
