package ownyit.utility;

import java.text.SimpleDateFormat;

public interface OwnyITConstants {

	public static final String DFEAULT_EPOCH_TIMESTAMP = "1970-01-01 00:00:00";
			
	public static final SimpleDateFormat COMMON_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static final SimpleDateFormat COMMON_DATE_FORMAT_1 = new SimpleDateFormat("yyyy-MM-dd HH");
	
	public static final SimpleDateFormat LOG_DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	
	public static final SimpleDateFormat LOG_FILE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static final String DEFAULT_DB_CONFIG_FILE = "dbsettings.xml";

    public static final String LINUX_CONFIG_PATH = "/user/local/ownyit/";

    public static final String WINDOWS_CONFIG_PATH = "\\assertyit\\Configuration\\";
	
	

}
