package backend.core;

import java.util.HashMap;
import java.util.Map;

public class Dictonary {

	private Map<String,Object> dic;
	public final static String QualifiedName = "Dictonary";
	public Dictonary(){
		dic = new HashMap<String,Object>();
	}
	
	public void put(String key, Object value){
		dic.put(key, value);
	}
	
	public Object get(String key){
		return dic.get(key);
	}
	
	public String getString(String key) {
		Object returnValue = dic.get(key);
		
		if(returnValue instanceof String) {
			return (String) returnValue;
		}else {
			return "";
		}
	}
	
	public Integer getInteger(String key) {
		Object returnValue = dic.get(key);
		
		if(returnValue instanceof Integer) {
			return (Integer) returnValue;
		}else {
			return new Integer(0);
		}
	}
	
	public Boolean getBoolean(String key) {
		Object returnValue = dic.get(key);
		
		if(returnValue instanceof Boolean) {
			return (Boolean) returnValue;
		}else {
			return Boolean.FALSE;
		}
	}
	
	public Boolean contains(String key) {
		return Boolean.valueOf(dic.containsKey(key));
	}
}
