package ownyit.utility;

public class OwnYitProcess {
	
	public OwnYitProcess(){}
	
	public long execute(String command){
		
		long status = 0;
		
		Process proc = null;		
		Runtime run = null;
		
		try {
			run = Runtime.getRuntime();
			
			long start = OwnYitCommon.getTime();
			
			proc = run.exec(command);
				
			proc.waitFor();
		
			long end = OwnYitCommon.getTime();
			
			status = end - start;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			status = -1;
			
		}finally{
			
			if(proc != null){
				proc.destroy();
				proc = null;
			}
			run = null;
		}
		return status;
	}
}
