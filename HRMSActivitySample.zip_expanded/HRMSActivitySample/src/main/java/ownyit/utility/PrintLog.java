package ownyit.utility;

import java.util.Arrays;

public class PrintLog {

	public static void write(String msg){
		System.out.println(msg);
	}

	public static void write(String header, byte[] data){
		
		int length = (data != null) ? data.length : 0;
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append(header);
		
		if(length > 0){
			
			for(int i = 0; i < length; i++){
				
				 String st = String.format("%02X", data[i]);
		         
				 if(i != 0){
		        	 buffer.append(' ');
		         }
				 buffer.append(st);
			}
		}else{
			buffer.append("None");
		}
		System.out.println(buffer.toString());
		
		buffer = null;
	}
}
