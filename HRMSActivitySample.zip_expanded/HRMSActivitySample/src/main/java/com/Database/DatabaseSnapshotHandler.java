package com.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.CommonMethodParse.OwnYitCommon;
import com.CommonMethodParse.OwnyitConstants;
import com.OwnyitWS.OwnYitData;

@Transactional
@Repository
public class DatabaseSnapshotHandler {

	@Autowired
    private JdbcTemplate jdbcTemplate1;
	
	private final int ROWS_FETCH_COUNT = 500;
	
	public String CountJsonResponse(int count) {
		String response = null;
		
		StringBuilder builder = new StringBuilder();
		builder.append("{\"timestamp\":\"");
		builder.append(System.currentTimeMillis());
		builder.append("\",\"result\":");
		if(count == 0) {
			builder.append("{\"status\":\"0\",\"msg\":\"Data Not Available\"}");
		}else {
			builder.append("{\"status\":\"1\",\"msg\":\"Data Get Successfully\"}");
		}
		
		response = builder.toString();
	return response;
	}
	
	public String LastCountResponse(int count) {
		String response = null;
		
		StringBuilder builder = new StringBuilder();
		builder.append("{\"timestamp\":\"");
		builder.append(System.currentTimeMillis());
		builder.append("\",\"result\":");
//		if(count != 0) {
			builder.append("{\"status\":\"1\",\"msg\":\"Data already Exists\"}}");
//		}else {
//			builder.append("{\"status\":\"1\",\"msg\":\"Data Get Successfully\"}");
//		}
		
		response = builder.toString();
		System.out.println("Last response ::" + response);
	return response;
	}

	public String getReponseString(String data_response) {
		
		int length = (data_response != null) ? data_response.length() : 0;
		
		String response = null;
		
		StringBuilder builder = new StringBuilder();

		builder.append("{\"timestamp\":\"");
		builder.append(System.currentTimeMillis());
		builder.append("\",\"result\":");
		
		if(length == 0) {
			builder.append("{\"status\":\"0\",\"msg\":\"Data Not Available\"}");
		}else {
			builder.append("{\"status\":\"1\",\"msg\":\"Data Get Successfully\"}");
		}
		builder.append(",\"data\":[");
		
		if(length == 0) {
//			builder.append("{}");
			
		}else {
			builder.append(data_response);
		}
		builder.append("]}");
		response = builder.toString();
		
		System.out.println("Response Json ::" + response);
		return response;
	
	}
	
	
	public int getResponseDB(String sql_query) {
		int count = 0;//
//		 DefaultTransactionDefinition paramTransactionDefinition = new    DefaultTransactionDefinition();
//			TransactionStatus status=platformTransactionManager.getTransaction(paramTransactionDefinition );
		try {
		
			jdbcTemplate1.execute(sql_query);
		
//			System.out.println(status);
//			platformTransactionManager.commit(status);
			count = 1;
		}
		catch(Exception e) {
//			log.write("DBHandlerSnapshot.java", "getResponseDB()", "Error Query :: "+sql_query + "   "+e, 1);
			System.out.println("Error Query :: "+sql_query + "   "+e);

			count = -1;
		}
		return count;
	}
	
	public String Insertresponse(int data_response) {
		String response = null;
		System.out.println(data_response);
		StringBuilder builder = new StringBuilder();

		builder.append("{\"timestamp\":\"");
		builder.append(System.currentTimeMillis());
		builder.append("\"");
		builder.append(",\"result\":{");
		if(data_response == 0) {
		builder.append("\"status\":\"0\",");
		builder.append(" \"message\": \"Record Not Inserted Successfully\"");
		builder.append("}");
//		builder.append("\",\"data\":[");
//			builder.append("{}");
			
		} else if (data_response > 0){
			
			builder.append("\"status\": \"1\",");
			builder.append("\"message\": \"Record Inserted Successfully\"}");
//			builder.append("\"data\":[");
//			builder.append(data_response);
		}else if(data_response == -1){
			builder.append("\"status\": \"-1\",");
			builder.append("\"message\": \"Query Exception\"}");
		}
		builder.append("}");
		response = builder.toString();
		
		System.out.println("insertData response ::" + response);
		
		return response;
		
	}
	
	public String Deleteresponse(int count) {
//		System.out.println(data_response);
		String response = null;
		StringBuilder builder = new StringBuilder();

		builder.append("{\"timestamp\":\"");
		builder.append(System.currentTimeMillis());
		builder.append("\"");
		builder.append(",\"result\":{");
		if(count == 0) {
		
			builder.append("\"status\":\"0\",");
			builder.append("\"message\": \"Record Not Deleted\"}");
			
			
		} else if(count > 0){
			builder.append("\"status\": \"1\",");
			builder.append("\"message\": \"Record Deleted\"}");
	
		} else if(count == -1){
			builder.append("\"status\": \"-1\",");
			builder.append("\"message\": \"Query Exception\"},");
		}

		builder.append("}");
		response = builder.toString();
		System.out.println("delete response ::" + response);
		
		return response;
		
	}
	
	
	@Transactional(readOnly = true)
	public int getResponseDataCount(String str_query) {
		int count = 0;
		try {
			 
			count = jdbcTemplate1.queryForObject(str_query, Integer.class);
		}catch(Exception e) {
//			log.write("DBHandlerSnapshot.java", "getResponseDataCount()", "Error Query :: "+str_query + "   "+e, 1);
			System.out.println("Error Query :: "+str_query + "   "+e);

		}
		return count;
	}
	
	@Transactional(readOnly = true)
	public String getResponseStringCount(String str_query) {
		String count = null;
		try {
			 
			count = jdbcTemplate1.queryForObject(str_query, String.class);
		}catch(Exception e) {
//			log.write("DBHandlerSnapshot.java", "getResponseDataCount()", "Error Query :: "+str_query + "   "+e, 1);
			System.out.println("Error Query :: "+str_query + "   "+e);

		}
		return count;
	}
	
//	@Transactional(readOnly = true)
	public long getResponseLongData(String str_query) {
		long count = 0;
		try {
			 
			count = jdbcTemplate1.queryForObject(str_query, Long.class);
		}catch(Exception e) {
//			log.write("DBHandlerSnapshot.java", "getResponseDataCount()", "Error Query :: "+str_query + "   "+e, 1);
			System.out.println("Error Query :: "+str_query + "   "+e);
//			logger.error("Exception is Raised in Database Query  = "+str_query + "   "+e);
//			e.printStackTrace();
		}
		return count;
	}
	
	
	@Transactional(readOnly = true)
	public List<String> getListResponseDB(String sql_query) {
		List<String> data_list = null;
		try {
			 data_list =jdbcTemplate1.queryForList(sql_query, String.class);

		}catch(Exception e) {
			System.out.println("Error Query :: "+sql_query + "   "+e);

			e.printStackTrace();
		}
		return data_list;
	}
	
	public String getResponseJsonData(String sql_query) {
		String response = null;
		
		if(sql_query != null) {
			OwnYitData data = getRecord(sql_query);
			
			int status = (data != null) ? data.getStatus() : OwnyitConstants.ERROR_STATUS;
			
			if(status == OwnyitConstants.OK_STATUS){
				response = data.getData();
				
				System.out.println("Response Data :: "+response);	
			}
		}
		
		return response;
	}
	
	public OwnYitData getRecord(String sql_query){
		ResultSet rs = null;
		OwnYitData data = new OwnYitData();
		
		String[] column_list = null;
		
		long start = System.currentTimeMillis();
		
		long end = 0;

		data = getData(sql_query);

		
		return data;

	}
	private String[] getColumnList(ResultSetMetaData meta_data){
		
		String[] column_list = null;
		
		try {
			if(meta_data == null){
				return null;
			}
			
			int column_count = meta_data.getColumnCount();
			
			if(column_count > 0){
				column_list = new String[column_count];
			}
			
			OwnYitCommon common = new OwnYitCommon();
			
			for(int i = 0; i < column_count; i++){
				
				String strName = meta_data.getColumnName(i+1);
				
				if(!common.isValidColumn(strName)){
					strName = null;
				}
				
				if(strName == null){
					strName = "column_" + i;
				}
				column_list[i] = strName;
				
				strName = null;
			}
			common = null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return column_list;
	}

	
	

	
	
	public OwnYitData getData(String str_query) {
		ResultSet rs= null;
		
		OwnYitData data = new OwnYitData();
		
		String[] column_list = null;
		
		long start = System.currentTimeMillis();
		
		long end = 0;
		try(
			Connection con = jdbcTemplate1.getDataSource().getConnection();
			
			Statement st = con.createStatement();) {
			
			con.setReadOnly(true);
			
//			jdbcTemplate1.setFetchSize(ROWS_FETCH_COUNT);
			rs= st.executeQuery(str_query);
			ResultSetMetaData meta_data = rs.getMetaData();
			
			column_list = getColumnList(meta_data);
			
			int column_count = (column_list != null) ? column_list.length : 0;
			
			meta_data = null;
			
			StringBuilder buffer = new StringBuilder();
			
			boolean bFlag = false;
			
			while(rs.next()){
				
				if(bFlag){
					buffer.append(",");
				}
				
				buffer.append("{");
				
				for(int i = 0; i < column_count; i++){
					
					if(i > 0){
						buffer.append(",");
					}
					buffer.append("\"");
					buffer.append(column_list[i]);
//					buffer.append("\":\"");
					buffer.append("\":");
					if(column_list[i].equals("json") || column_list[i].equals("wbsreccurrent") || column_list[i].equals("wbsrecidjson") || column_list[i].equals("wbsprejson")) {
						buffer.append(rs.getString(i+1));
						
					}else if(rs.getString(i+1) == null) {
//						buffer.append("");
						buffer.append("\"\"");
					}else {
						buffer.append("\"");
//						buffer.append(rs.getString(i+1).replace("\"", ""));
						buffer.append(rs.getString(i+1));
						buffer.append("\"");
					}
				}
				buffer.append("}");
				bFlag = true;
					
			}
			String value = buffer.toString();
			
			data.setStatus(OwnyitConstants.OK_STATUS);
			data.setData(value);
			
			buffer = null;
			
			value = null;
			column_list = null;
			
		
			end = System.currentTimeMillis();
			
		} catch (SQLException e) {
			
			int code = e.getErrorCode();
			
			if(code == 0){
				code =OwnyitConstants.ERROR_STATUS;
			}
			
			end = System.currentTimeMillis();
			
			data.setStatus(OwnyitConstants.ERROR_STATUS);
			data.setErrorCode(code);
			data.setErrorMsg(e.getMessage());
			
			e.printStackTrace();
		
		} catch (Exception e) {
			
			end = System.currentTimeMillis();
			
			data.setStatus(OwnyitConstants.ERROR_STATUS);
			data.setErrorCode(OwnyitConstants.ERROR_STATUS);
			data.setErrorMsg(e.getMessage());
			
			e.printStackTrace();
			
		}finally{
			
			if(rs != null){
				try {
					rs.close();
				} catch (Exception e2) {}
				rs = null;
			}
		}
		long diff = end-start;
		
		data.setResponseTime(diff);
		
		return data;
	}

	public String UpdateResponse(int data_response) {
		String response = null;
		StringBuilder builder = new StringBuilder();

		builder.append("{\"timestamp\":\"");
		builder.append(System.currentTimeMillis());
		builder.append("\"");
		builder.append(",\"result\":{");
		if(data_response == 0) {
		builder.append("\"status\":\"0\",");
		builder.append(" \"message\": \"Record Not Updated Successfully\"");
		builder.append("}");
//		builder.append("\",\"data\":[");
//			builder.append("{}");
			
		} else if (data_response > 0){
			
			builder.append("\"status\": \"1\",");
			builder.append("\"message\": \"Record Updated Successfully\"}");
//			builder.append("\"data\":[");
//			builder.append(data_response);
		}else if(data_response == -1) {
			builder.append("\"status\": \"-1\",");
			builder.append("\"message\": \"Query Exception\"}");
		}
		builder.append("}");
		response = builder.toString();
		
		System.out.println("Update response ::" + response);
		
		return response;
		
	
	}
	
	
	public String response(HashMap<String, String> decode_map,int data_response) {
		String response=null;
		StringBuilder builder=new StringBuilder();
		System.out.println("_____________");
		System.out.println(decode_map);
		
		builder.append("{\"timestamp\":\"");
		builder.append(System.currentTimeMillis());
		builder.append("\"");
		builder.append(",\"result\":{");
		if(data_response==0) {
			builder.append("\"status\":\"0\",");
    	builder.append("\"action\":\"");
    	builder.append(decode_map.get("action"));
    	builder.append("\",");
    	builder.append("\"ProjectName\":\"");
    	builder.append(decode_map.get("ProjectName"));
    	builder.append("\",");
    	builder.append("\"StartDate\":\"");
    	builder.append(decode_map.get("StartDate"));
    	builder.append("\",");
    	builder.append("\"EndDate\":\"");
    	builder.append(decode_map.get("EndDate"));
    	builder.append("\"}}");
    	
		}
    	else if(data_response!=0) {
			builder.append("\"status\":\"1\",");
    	builder.append("{\"action\":\"");
    	builder.append(decode_map.get("action"));
    	builder.append("\",");
    	builder.append("\"ProjectName\":\"");
    	builder.append(decode_map.get("ProjectName"));
    	builder.append("\",");
    	builder.append("\"StartDate\":\"");
    	builder.append(decode_map.get("StartDate"));
    	builder.append("\",");
    	builder.append("\"EndDate\":\"");
    	builder.append(decode_map.get("EndDate"));
    	builder.append("\"}}");
    	}
		response=builder.toString();
		System.out.println(response);
		
		return response;

	}
	
	public String getReponsePDUString(String pdu_data,String workitem ) {
		String response = null;
		StringBuilder builder = new StringBuilder();

		builder.append("{\"timestamp\":\"");
		builder.append(System.currentTimeMillis());
		builder.append("\",\"result\":");
		if(pdu_data.length() == 0 && workitem.length() == 0) {
			builder.append("{\"status\":\"0\",\"msg\":\"Data Not Available\"}");
		}else {
			builder.append("{\"status\":\"1\",\"msg\":\"Data Get Successfully\"}");
		}
		builder.append(",\"PDU\":[");
		if(pdu_data.length() == 0) {
			builder.append("{\"status\":\"0\",\"msg\":\"Data Not Available\"}");
//			builder.append("{}");
			
		}else {
			builder.append(pdu_data);
		}
			builder.append("]");
		builder.append(",\"WORKITEM\":[");
		if(workitem.length() == 0) {
//			builder.append("{}");	
//			builder.append("{\"status\":\"0\",\"msg\":\"Data Not Available\"}");
			builder.append("{\"msg\":\"Data Not Available\"}");
		}else {
			builder.append(workitem);
		}
		builder.append("]}");
		response = builder.toString();
		
		System.out.println("Response ::" + response);
		return response;
	
	}
	
	
	}

	
