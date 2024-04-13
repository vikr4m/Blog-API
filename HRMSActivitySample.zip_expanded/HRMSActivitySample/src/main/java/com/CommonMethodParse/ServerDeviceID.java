package com.CommonMethodParse;


import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class ServerDeviceID {

	private static Long intValue = new Long(0);
	
	private static Long seed = new Long(0);
	
	public ServerDeviceID(){}
	
	public long getTransactionID(long location_prefix){
        
		long TransactionID = 0;
		
        long i = getcounter();
        
        if (i == 0 || i >= 999999999){
            seed = getSeed();
            System.out.println(seed);
            long location_id = location_prefix * 1000000;
            System.out.println(location_id);
            seed = (location_id + seed) * 10000;
                    
        }
        TransactionID = seed + i;
        
        return TransactionID;
    }
	
	
	private long getcounter(){

        long value = -1;
        
        synchronized(intValue){
        	
        	value = intValue;
        	
        	intValue = value + 1;
        	
        	if(intValue >= 99999999){
        		intValue = (long)1;
        	}
        }
        return value;
    }
	
	private long getSeed(){
		
		Date date = new Date();
		
        long secondsSinceEpoch = date.getTime();
        
        long div103 = secondsSinceEpoch / 1000;
        
        long div106 = div103 / 1000000;
        
        date = null;
        
        return (div103 - (div106 * 1000000));
    }
	
	public static void main(String[] args){
		
		ServerDeviceID id = new ServerDeviceID();
	
		String serverLocationID = "1643026802720";
		long location_prefix =(Long.parseLong(serverLocationID)/10000000000L)*1000 +4;
		System.out.println(location_prefix);
		long epochtime = (System.currentTimeMillis()/10000000000L)*1000+4;
		System.out.println(" Epochtime :: "+epochtime);
		System.out.println("Device ID =" + id.getTransactionID(location_prefix));
		System.out.println("Device ID =" + id.getTransactionID(location_prefix));
		System.out.println("Device ID =" + id.getTransactionID(location_prefix));
	}
}
