package com.JSONParser;

import java.util.HashMap;
import org.springframework.stereotype.Repository;

import ownyit.utility.OwnYitJSON;

@Repository
public class JSONParser {
	
	public HashMap<String, String> getRawMessagesV4(String strRawMessage){
		System.out.println("getRawMessagesV4"+ strRawMessage);
		if(strRawMessage == null){
			return null;
		}
		
		HashMap<String, String> map = null;
		
		try {
			
//			System.out.println("In JSONParser : getRawMessagesV4() : Parse JSON Message = " + strRawMessage);
			
			OwnYitJSON json = new OwnYitJSON();
			
			map = json.parse(strRawMessage);
			
			json = null;
			
			if(map == null){
//				log.write("JSONParser.java", "getRawMessagesV4()", "Null Map Received ...", 1);
				System.out.println("In JSONParser : getRawMessagesV4() : Null Map Received ...");
			}
			
		} catch (Exception e) {
//			log.write("JSONParser.java", "getRawMessagesV4()", "Exception is Raised  : " + e, 9);
			System.out.println("In JSONParser : getRawMessagesV4() : Exception is Raised  : " + e);
//			log.write("JSONParser.java", "getRawMessagesV4()", "Exception in Message  : " + strRawMessage, 9);
			System.out.println("In JSONParser : getRawMessagesV4() : Exception in Message : " + strRawMessage);
//			e.printStackTrace();
		}
		return map;
	}
	
	public String[] getRawMessagesV4List(String json_string){
		return getRawMessagesV4List(json_string, "data");
	}
	
	public String[] getRawMessagesV4List(String json_string, String property){
		
		if(json_string == null || property == null){
			return null;
		}
		
		String[] values = null;
		
		try {
			OwnYitJSON json = new OwnYitJSON();
			
			values = json.toArray(json_string, property);
			
			json = null;
			
		} catch (Exception e) {
//			log.write("JSONParser.java", "getRawMessagesV4()", "Exception is Raised  : " + e, 9);
			System.out.println("In JSONParser : getRawMessagesV4() : Exception is Raised  : " + e);
//			log.write("JSONParser.java", "getRawMessagesV4()", "Exception in message  : " + json_string, 9);
			System.out.println("In JSONParser : getRawMessagesV4() : Exception in Message : " + json_string);
//			e.printStackTrace();
		}
		return values;
	}
}
