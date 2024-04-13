package ownyit.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;

public class FileReader {

	private File file = null;
	
	public FileReader(String file_name) throws Exception{
		loadFile(file_name);
	}
	
	private void loadFile(String file_name) throws Exception{
		
		this.file = new File(file_name);
		
		if(!this.file.exists()){
			throw new FileNotFoundException("File Not Found = " + file_name);
		}
	}
	
	public byte[] read() throws Exception{
		
		if(file == null){
			return null;
		}		
		return Files.readAllBytes(file.toPath()); 
	}
	
	public long length(){
		
		if(this.file == null){
			return 0;
		}		
		return this.file.length();
	}
	
	public void clear(){
		this.file = null;
	}
}
