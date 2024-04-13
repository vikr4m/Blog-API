package com.ownyitv4.log;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogWriter {
	

	@Value("${debug_type}")
	int _debug;
	
	@Value("${final.logWrite.name}")
	String _log_file;
	

	public static final int NO_OUTPUT = 0;
	
	public static final int CONSOLE_OUTPUT = 1;
	
	public static final int FILE_OUTPUT = 2;
	
	public static final int RABBITMQ_OUTPUT = 5;
	
	private static final SimpleDateFormat LOG_DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	
	private int _output_mode = CONSOLE_OUTPUT;
	
	private long _max_size = 10485760;
	
//	private String _log_file = null;
	
//	public LogWriter(int debug) {
//		setDebug(debug);
//	}
	
	public void setDebug(int debug) {
		this._debug = debug;
	}
	
//	public LogWriter(String log_file) {
//		setLogFile(log_file);
//	}
	
//	public void setLogFile(String log_file){
////		setDebug(FILE_OUTPUT);
//		this._log_file = log_file;
//	}
	
//	public void rabbitMQWriteData(String msg) {
//		 rabbitTemplate.convertAndSend(exchange, null, msg);
//	}
	public void write(String class_name, String method_name, String msg,int type){
		
	
	 msg = getLogMessge(class_name, method_name, msg,type);
		
 
	if(msg == null){
		return;
	}
//	System.out.println(this._debug);
	switch(this._debug){
	case FILE_OUTPUT:
					writeFile(msg);
					break;
					
	case CONSOLE_OUTPUT:
					System.out.println(msg);
					break;
					
//	case RABBITMQ_OUTPUT:
//					rabbitMQWriteData(msg);
//					break;
		
		}
	}
	
	private String getLogMessge(String class_name, String method_name, String msg,int type){
		
		String message = null;
		
		try {
			StringBuilder buffer = new StringBuilder();
			buffer.append("12");
			buffer.append(",");
			buffer.append(type);
			buffer.append(",");
		
			buffer.append(getLogDate());
			
			buffer.append(",");
			if(class_name != null){
				buffer.append(class_name);
			}
			buffer.append(",");
			
			if(method_name != null){
				buffer.append(method_name);
			}			
			buffer.append(",");
			
			buffer.append(msg);
//			buffer.append("\n");
			buffer.append(System. getProperty("line.separator"));
			message =  buffer.toString();
			
			
			buffer = null;
			
		} catch (Exception e) {
			System.out.println("LogWriter => getLogMessge() : Exception is Raised = " + e);
		}
		return message;
	}
	
	private void writeFile(String msg){
		
		File file = null;
		
		FileOutputStream out = null;
		
		try {
			file = new File(this._log_file);
			
			if(file.exists()){
				/**
				 * Delete Log File is File Size grater than 10 MB
				 */
				if(file.length() > this._max_size){
					file.delete();
				}
			}			
			out = new FileOutputStream(file, true);
			
			out.write(msg.getBytes());
			out.flush();
			
		} catch (Exception e) {
			System.out.println("LogWriter => writeFile() : Exception is Raised = " + e);
		}finally{
			
			if(out != null){
				try {
					out.close();
				} catch (Exception e2) {}
				
				out = null;
			}
			file = null;
		}
	}

//	private String getTimestamp(){		
//		return LOG_DATE_FORMAT;
//	}
	
	public static String getLogDate() {
		Date date = new Date();
		return LOG_DATE_FORMAT.format(date);
	}
	
	
}
