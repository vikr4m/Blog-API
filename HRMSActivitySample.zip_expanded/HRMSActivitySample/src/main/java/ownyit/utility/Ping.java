package ownyit.utility;

import java.io.DataInputStream;

public class Ping{
	
	private int ping_retry = 3;
	
	private int ping_timeout = 750;
	
	private String ip_address = null;
	
	private Process proc = null;
    
    public Ping(String ip_address){
    	this.ip_address = ip_address;
    }
	
    public void setPingRetry(int retry){
    	this.ping_retry = retry;
    }
    
    public void setPingTimeout(int timeout){
    	this.ping_timeout = timeout;
    }
    
    public int getResponseTime(){
    	return execute();
    }
    
    public boolean isReachable(){
    	
    	if(getResponseTime() != -1){    		
    		return true;
    	}else{
    		return false;
    	}
    }
    
    private String getCommand(){
    	
    	if(this.ip_address == null){
    		return null;
    	}
    	
    	StringBuilder buffer = new StringBuilder("ping -n ");
    	
    	buffer.append(this.ping_retry);
    	
    	buffer.append(" -w ");
    	buffer.append(this.ping_timeout);
    	
    	buffer.append(" ");
    	buffer.append(this.ip_address);
    	
    	String command = buffer.toString();
    	
    	buffer = null;
    	
    	return command;
    }
    
    private int getReponseTime(String line){
    
    	int response_time = 0;
    	
    	line = line.toLowerCase();
		
		if((line.indexOf("unreachable") != -1) || (line.indexOf("timed out") != -1)){
			
			response_time = -1;
			
		}else{
			
			int index = line.indexOf("average = ");
			
			if(index != -1){
				
				String strTemp = line.substring(index+10);
				
				strTemp = strTemp.substring(0, strTemp.length()-2);
				
				response_time = OwnYitCommon.getIntValue(strTemp);
				
				strTemp = null;
			}
		}
		return response_time;
    }
    
    private void destroy(){
    	
    	if(this.proc != null){
    		try {
    			this.proc.destroy();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		this.proc = null;
    	}
    }
    
    private int execute(){
    	
    	int response = -1;
    
    	DataInputStream in = null;
    	
    	try {
			String command = getCommand();
			
			if(command == null){
				return -1;
			}
			
			this.proc = Runtime.getRuntime().exec(command);
			
			in = new DataInputStream(this.proc.getInputStream());
			
			String line = null;
			
			while((line = in.readLine()) != null){
				
				if(line.length() == 0){
					continue;
				}
				
				line = line.toLowerCase();
				
				response = getReponseTime(line);
				
				if(response != 0){
					break;
				}
			}
			command = null;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			
			if(in != null){
				try {
					in.close();
				} catch (Exception e2) {}
				in = null;
			}
			destroy();
		}
    	return response;
    }
    
    public static void main(String[] args){
		
    	int length = (args != null) ? args.length : 0;
    	
    	if(length == 0){
    		
    		 PrintLog.write("Uage: java Ping <ip_address>");
    		 System.exit(0);
    	}
    	
    	Ping ping = new Ping(args[0]);
    	
    	int response_time = ping.getResponseTime();
    	
    	PrintLog.write("Ping Response Time (ip_address = " + args[0] + ") = " + response_time);
    	
    	ping = null;
	}
}
