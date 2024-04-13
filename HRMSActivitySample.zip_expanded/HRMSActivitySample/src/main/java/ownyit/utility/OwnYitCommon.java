package ownyit.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;

public final class OwnYitCommon implements OwnyITConstants{
	
	private static String numeric_value = "0123456789";
	
	private OwnYitCommon(){}
	
	public static int getRandom(){
		
		Random random = new Random();
		
		int value = random.nextInt(Integer.MAX_VALUE);
		
		random = null;
		
		return value;
	}
	
	public static long getLongRandom(){
		
		Random random = new Random();
		
		long value = (long)random.nextInt(Integer.MAX_VALUE);
		
		random = null;
		
		return value;
	}

	public static Object resizeArray(Object array, int new_size){

		int old_size = java.lang.reflect.Array.getLength(array);
		
		Class elementType = array.getClass().getComponentType();
		
		Object new_array = java.lang.reflect.Array.newInstance(elementType, new_size);
		
		int preserveLength = Math.min(old_size, new_size);
		
		if (preserveLength > 0){
			System.arraycopy(array, 0, new_array, 0, preserveLength);
		}
		return new_array;
	}
	
	public static long getTime(){
		return System.currentTimeMillis();
	}
	
	public static boolean isNumeric(char value){
		
		boolean flag = true;
		
		if(value < '0' || value > '9'){
			flag = false;
		}
		return flag;
	}

	public static boolean isNumeric(String value){
		
		int len = (value != null)?value.length() : 0;
		
		if(len == 0){
			return false;
		}
		
		boolean flag = true;
		
		for(int i = 0; i < len; i++){
			
			char ch = value.charAt(i);
			
			flag = isNumeric(ch);
			
			if(!flag){
				break;
			}
		}
		return flag;
	}
	
	public static int getIntValue(String strValue) {
		
		if(strValue == null){
			return -1;
		}
		
		int value = 0;
		
		try {
			value = Integer.parseInt(strValue);
		} catch (Exception e) {}
		return value;		
	}
	
	public static Long getLongValue(String strValue) {
		
		if(strValue == null){
			return (long)-1;
		}
		
		Long value = (long)0;
		
		try {
			value = Long.parseLong(strValue);
		} catch (Exception e) {}
		
		strValue = null;
		
		return value;		
	}
	
	public static String convertEpochToString(String strEpochTime) {
		
		long epochTime = Long.parseLong(strEpochTime);
		
		return convertEpochToString(epochTime);
	}

	public static String convertEpochToString(long epochTime) {
		
		String value = null;

		if (epochTime > 0) {
			
			Date date = new Date(epochTime);
			
			value = COMMON_DATE_FORMAT.format(date);
			
			date = null;
			
		}else{
			value = DFEAULT_EPOCH_TIMESTAMP;
		}
		return value;
	}

	public static long convertStringToEpoch(String timestamp){
	
		long epoch_time = 0;
		
		try {
			Date date = COMMON_DATE_FORMAT.parse(timestamp);
			
			epoch_time = date.getTime();
			
			date = null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return epoch_time;
	}
	
	public static String getTimestamp() {
		
		Date date = getCurrentDate();
		
		String strDate = COMMON_DATE_FORMAT.format(date);
		
		date = null;
	
		return strDate;
	}

	public static String getLogTimestamp() {
		
		Date date = getCurrentDate();
		
		String strDate = LOG_FILE_FORMAT.format(date);
		
		date = null;
	
		return strDate;
	}
	
	public static String getHostName(String strHostName) {

		if (strHostName == null) {
			return null;
		}

		String strReturn;

		strHostName = strHostName.trim();

		final int index = strHostName.indexOf(".");

		if (index == -1) {
			strReturn = strHostName;
		} else {
			strReturn = strHostName.substring(0, index);
		}
		return strReturn;
	}
	
	public static String getMACAddress(String strData) {

		if (strData == null) {
			return "";
		}

		char[] data = strData.toCharArray();

		final int length = strData.length();

		for (int index = 0; index < length; index++) {
			if (data[index] == '.' || data[index] == ':') {
				data[index] = '-';
			}
		}

		return String.valueOf(data);
	}
	
	public static Date getCurrentDate(){
		return new Date();
	}
	
	public static String getSystemDir() {
		
		String is32bit = System.getProperty("os.arch");

		StringBuilder buffer = new StringBuilder();
		
		buffer.append(System.getenv("windir"));

		if (getOSName().contains("Windows")) {
			if (is32bit.contains("86")) {
				buffer.append("\\system32");
			} else {
				buffer.append("\\SysWOW64");
			}
		}else{
			buffer.append(LINUX_CONFIG_PATH);
		}

		return buffer.toString();
	}

	public static String getOSName() {
		return System.getProperty("os.name");
	}

	public static String getApplicationPath(){	 
		return System.getProperty("user.dir");
	}
	
	public static String getFileSeparator(){
		return File.separator;
	}
	
	public static String removeEscapeChar(String strData) {

		if (strData == null) {
			return "";
		}
		
		char[] data = strData.toCharArray();

		final int length = strData.length();

		for (int index = 0; index < length; index++) {

			if (data[index] == '\'' || data[index] == '\"') {
				data[index] = '`';

			} else if (data[index] == '\\') {
				data[index] = '/';
			}
		}
		return String.valueOf(data);
	}
	
	public static String getConfigFile(String file_name) throws FileNotFoundException{
		return getConfigFile(file_name, false);
    }
	
	 public static String getSystemConfigFilePath(){

        String file_path = getSystemDir();

        if(getOSName().contains("Windows")){
            file_path += WINDOWS_CONFIG_PATH;
        }else{
            file_path += LINUX_CONFIG_PATH;
        }
        return file_path;
    }
	 
	public static String getConfigFile(String file_name, boolean isSystemPath){
        
		String config_file = null;

		if(isSystemPath){			
			config_file = getSystemConfigFilePath();
			
		}else{
			config_file = getConfigFilePath();
		}
		
		System.out.println("OwnYitCommon => getConfigFile() : Config File Path =" + config_file);

        if(config_file != null){
           
        	config_file = "." + getFileSeparator();
        	config_file += file_name;
        	
        }else{
            config_file = file_name;
        }
        System.out.println("OwnYitCommon => getConfigFile() : Config File =" + config_file);

        return config_file;
    }

    public static String getConfigFilePath(){

        String file_path = getApplicationPath();

        if(file_path == null){
            file_path = ".";
        }

        String tmp_sep = getFileSeparator();

        file_path += tmp_sep;
        file_path += "config";
        
        return file_path;
    }
}
