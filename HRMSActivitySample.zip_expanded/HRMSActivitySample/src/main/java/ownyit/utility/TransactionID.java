package ownyit.utility;

import java.util.Date;

public class TransactionID {

	private static Long intValue = new Long(0);
	
	private static Long seed = new Long(0);
	
	public TransactionID(){}
	
	public long getTransactionID(){
        
		long TransactionID = 0;
		
        long i = getcounter();
        
        if (i == 0 || i >= 999999999){
            seed = getSeed();
            seed = (11000000 + seed) * 10000000;
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
}
