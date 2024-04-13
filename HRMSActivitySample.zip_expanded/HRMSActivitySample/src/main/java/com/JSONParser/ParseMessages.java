package com.JSONParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.CommonMethodParse.CommonMethods;


@Service
public class ParseMessages {

	@Autowired
	JSONParser jsonParser;
	
	@Autowired
	CommonMethods cDMethods;
	
	private String strRawMessage = null;
	
	public String getRawMessage() {
		return strRawMessage;
	}

	public void setRawMessage(String strRawMessage) {
		this.strRawMessage = strRawMessage;
	}
	
	
	
	public void parse(){
		
		if(this.strRawMessage == null){
			return;
		}
		
		String strTempMessages = this.strRawMessage;
		parseMessage(strTempMessages);
		
		
	}

	public void parseMessage(String message){
		
		HashMap<String, String> map = null;
		
		
		try {
			
			if(message == null) {
				return ;
			}
			String tmp_message = message;
			
			if(!message.endsWith("\"}]}")){			
				tmp_message += "\"}]}"; 
			}
			
			System.out.println(tmp_message);
			map = jsonParser.getRawMessagesV4(tmp_message);
			
			int count = (map != null) ? map.size() : 0;
//			log.write("ParseMessages.java", "parseJSONMessage()", "Total Fields Found In JSON String = " + count, 1);
//			System.out.println("In MessageParser parseJSONMessage() : Total Fields Found In JSON String = " + count);
			
			if(count >= 3){
				handleMaessages(map);
			}
			
			String[] raw_messages_list =jsonParser.getRawMessagesV4List(tmp_message);
			System.out.println(raw_messages_list);
			
			int total_msg_records = (raw_messages_list != null) ? raw_messages_list.length : 0;
					
			if(total_msg_records > 0){
				
				List<String> data_list = processJson(raw_messages_list);
				
				int size = (data_list != null) ? data_list.size() : 0;
				
//				System.out.println(data_list.toString());
				System.out.println(data_list.size());
//				
				if(size > 0) {
					for(int j=0;j<size;j++) {
						System.out.println(data_list.get(j));
//						this.msg.setData_msg(data_list.get(j));
					}
				}
//				this.msg.setDataSet(data_list);
			}
			for(int i = 0; i < total_msg_records; i++){
				raw_messages_list[i] = null;
			}
			raw_messages_list = null;
		
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally{
		
			if(map != null){
				map.clear();
				map = null;
			}
		}	
	}
	
	public List<String> processJson(String[] message_list){
		List<String> sList = new ArrayList<String>();
		
		try {
			int count = (message_list != null) ? message_list.length : 0;
			
			for(int index = 0; index < count; index++){
				String sData = message_list[index];
				System.out.println("s data :: "+sData);
				System.out.println(sData.split(","));
				String[] arr = sData.split(",");
				for(String str : arr) {
				System.out.println("array ::" + Arrays.toString(arr));
				System.out.println(str);
				System.out.println(str.replace("{",""));
				System.out.println("array size ::" + arr.length + "  " + arr[0] + " " + arr[1] + " " + arr[2]);
				
				for(int i = 0; i<arr.length ; i++) {
					String[] str_arr = str.split("\":");
					System.out.println("array with : ::" + str_arr);
					System.out.println("str ::" + str_arr[0] + " " + str_arr[1]);
				}
				}
				sList.add(sData);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sList;
	}
	private List<HashMap<String,String>> processJsonMessage(String[] message_list){
		
		HashMap<String, String> message_map = null;
		
		List<HashMap<String,String>> dataList = new ArrayList<HashMap<String,String>>();
		
		int msg_no = 0;
		
		try {
			int count = (message_list != null) ? message_list.length : 0;
			
			for(int index = 0; index < count; index++){
				
				message_map = jsonParser.getRawMessagesV4(message_list[index]);
				
				int count1 = (message_map != null) ? message_map.size() : 0;
				
				if(count1 > 0){
					
					String strMsgNo = message_map.get("msgnum");
					
					msg_no = cDMethods.ParseInt(strMsgNo);
					
					System.out.println(msg_no);
					
					if(msg_no > 0){
						
						dataList.add(message_map);
						
						System.out.println(dataList.toString());
						
//						if(this.msg != null) {
//							this.msg.setDataMessages(dataList);
//							System.out.println("Set Messages");
//						}
						
					}else {
						// Pribnt Message Here
					}
				}else {
					// Print Message Here
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			
			if(message_map != null){
				message_map.clear();
				message_map = null;
			}
		}
		System.out.println("Data Set ");
		return dataList;
	}
	
	private void handleMaessages(HashMap<String,String> map) {
		try {
		if(map != null) {
			
//			if(this.msg == null){
////				log.write("ParseMessages.java", "handleMaessages()", "msg Object is Null ...", 1);
////				System.out.println("In Message handleMessage3() : msg Object is Null ...");
//			}
//			
//			this.msg.setDeviceid(cDMethods.ParseLong(map.get("deviceid")));
//			this.msg.setScanid(cDMethods.ParseLong(map.get("scanid")));
//			this.msg.setSchedularid(cDMethods.ParseLong(map.get("schedularid")));
//			this.msg.setEpochtime(cDMethods.ParseLong(map.get("epochtime")));

		}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
