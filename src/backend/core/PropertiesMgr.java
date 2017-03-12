package backend.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class PropertiesMgr {

	public final static String QualifiedName = "PropertiesMgr";
	
	Map<String,String> propMap = new HashMap<String, String>();
	public PropertiesMgr(String propertiesFile, String path){
		final String PROPERTIES_PATH = path + "/../../conf/properties/" + propertiesFile + ".properties";
		
		String temp = "";
		String[] contentArray = null;
		
		BufferedReader in = null;

		try {System.out.println(in = new BufferedReader(new FileReader(PROPERTIES_PATH)));
			while((temp = in.readLine()) != null){
				if(!temp.contains("#")){
					contentArray = temp.split("=");
					if(contentArray.length  != 0 && contentArray != null){
						propMap.put(contentArray[0], contentArray[1]);			
					}
				}
			}
		}catch(Exception e){
			System.out.println("ERROR PROPETIESMGR: " + e.getMessage());
		}
	}
	
	public String getKey(String key) {
	
		return propMap.get(key);
	}
}
