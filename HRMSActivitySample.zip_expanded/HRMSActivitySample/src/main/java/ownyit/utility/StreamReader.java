package ownyit.utility;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamReader {

	private int buffer_Size = 2048;
	
	public StreamReader(){}
	
	public void setBufferSize(int size){
		this.buffer_Size = size;
	}
	
	public byte[] read(InputStream in){
	
		byte[] result = null;
		
		byte[] tmp_buffer = new byte[this.buffer_Size];
		
		BufferedInputStream reader = null;
		
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		
		try {		
			reader = new BufferedInputStream(in);
			
			int counter = 0;
			
			while((counter = reader.read(tmp_buffer)) != -1){
				buffer.write(tmp_buffer, 0, counter);				
			}
			
			buffer.flush();
			
			result = buffer.toByteArray();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			
			if(buffer != null){
				try {
					buffer.close();
					
				} catch (Exception e2) {}
				
				buffer = null;
			}
			
			if(reader != null){
				try {
					reader.close();
				} catch (Exception e2) {}
				
				reader = null;
			}
		}
		
		/**
		 * Close Reader Connection
		 */
				
		return result;
	}
	
	public List<String> readLines(byte[] data){
		
		int len = (data != null) ? data.length : 0;
		
		if(len == 0){
			return null;
		}
		
		List<String> list = new ArrayList<String>();
		
		InputStream is = null;
		
		BufferedReader bfReader = null;
		
		try {
            is = new ByteArrayInputStream(data);
            
            bfReader = new BufferedReader(new InputStreamReader(is));
            
            String line = null;
            
            while((line = bfReader.readLine()) != null){
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            try{
                if(is != null) is.close();
            } catch (Exception ex){
                 
            }
        }		
		return list;
	}	
}
