package ownyit.utility;

import java.util.Base64;

public abstract class Base64Encoder {

	public static String encode(String data){
		return encodeDecode(data, 0);
	}
	
	public static byte[] encode(byte[] data){
		return encodeDecode(data, 0);	
	}
	
	public static String decode(String encoded_data){
		return encodeDecode(encoded_data, 1);
	}
	
	public static byte[] decode(byte[] data){
		return encodeDecode(data, 1);
	}
	
	private static String encodeDecode(String data, int action){
		
		if(data == null){
			return null;
		}
		byte[] buffer = encodeDecode(data.getBytes(), action);
		
		if(buffer == null){
			return null;
		}
		return new String(buffer);
	}

	private static byte[] encodeDecode(byte[] data, int action){
		
		int size = (data != null) ? data.length : 0;
		
		if(size == 0){
			return null;
		}
		byte[] buffer = null;
		
		if(action == 0){
			buffer = Base64.getEncoder().encode(data);
			
		}else{
			buffer = Base64.getDecoder().decode(data);
		}
		return buffer;
	}
}
