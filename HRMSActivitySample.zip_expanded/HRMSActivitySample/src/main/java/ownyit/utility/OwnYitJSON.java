package ownyit.utility;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class OwnYitJSON {

	private JSONParser parser = null;
	
	public OwnYitJSON(){
		this.parser = new JSONParser();
	}
	
	public HashMap<String, String> parse(String json_string){
		
		if(json_string == null){
			return null;
		}
		return getData(json_string);
	}
	
	private HashMap<String, String> getData(String json_string){
		
		JSONObject object = parseJsonString(json_string);
		
		
		if(object == null){
			return null;
		}
		
		List<String> list = new ArrayList<String>(object.keySet());
		
		HashMap<String, String>map = getTableMap(object, list);
		
		
		object.clear();
		object = null;
		
		list = null;
		
		return map;
	}

	private JSONObject parseJsonString(String json_string){
		
		if(json_string == null){
			return null;
		}
		
		JSONObject object = null;
		
		String s = null;
		
		try {
			s = new String(json_string.getBytes(), StandardCharsets.UTF_8);
			
			object = (JSONObject)this.parser.parse(s);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		s = null;
		
		return object;
	}
	
	private HashMap<String, String> getTableMap(JSONObject object, List<String> list){
		
		int size = (list != null) ? list.size() : 0;
		
		HashMap<String, String>map = null;
		
		if(size > 0){
			
			map = new HashMap<String, String>();
			
			for(String key : list){
			
				String value = getValue(object, key);
				
				if(value != null){
					map.put(key, value);
				}
				value = null;
			}
			list.clear();
		}
		return map;
	}
	
	private String getValue(JSONObject object, String key){
		
		String value = null;
		
		try {			
			Object obj = getObject(object, key);
			
			if(obj == null) {
				return "";
			}else if(!(obj instanceof JSONArray)){				
				value = obj.toString();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	private Object getObject(JSONObject object, String key){
		
		if(object == null || key == null){
			return null;
		}
		return object.get(key);
	}

	public String[] toArray(String json_string, String key){
		
		JSONObject object = parseJsonString(json_string);
		
		if(object == null){
			return null;
		}
		Object obj = getObject(object, key);
		
		if(obj == null){
			return null;
		}
		
		String[] values = null;
		
		if(obj instanceof JSONArray){
			values = jsontoStringArray((JSONArray)obj);
			
		}else{
			PrintLog.write("In OwnYitJSON toArray() : Object is not JSON Array ...");
		}
		object.clear();
		object = null;			
		
		obj = null;
		
		return values;
	}
	
	private String[] jsontoStringArray(JSONArray jsArray){
		
		
		int size = (jsArray != null) ? jsArray.size() : 0;
		
		if(size == 0){
			return null;
		}
		String[] values = new String[size];
			
		for(int i = 0; i < size; i++){
			
			values[i] = jsArray.get(i).toString();
		
				
			// PrintLog.write("In OwnYitJSON jsontoStringArray() : Values = " + values[i]);
		}	
		
		return values; 
	}
	
	
}
