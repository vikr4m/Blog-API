package ownyit.utility;

import java.util.Arrays;

public abstract class ArrayHandler {

	public static byte[] append(byte[] first, byte[] second){
		
		int old_data_len = (first != null) ? first.length : 0;
		
		int new_data_len = (second != null)? second.length : 0;
		
		if(old_data_len == 0){
			return second.clone();
			
		}
		byte[] new_data = Arrays.copyOf(first, old_data_len+new_data_len);
		
		System.arraycopy(second, 0, new_data, old_data_len, new_data_len);
				
		return new_data;
	}	
}
