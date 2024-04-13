package com.Database;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CommonMethodParse.CommonMethods;
import com.ownyitv4.log.LogWriter;

@Service
public class DBTransaction {
	
	@Autowired
	DBMessage dbMessage;
	
	@Autowired
	DatabaseSnapshotHandler dbhandler;
	
	@Autowired
	LogWriter log;
	
	@Autowired
	CommonMethods cDMethods;

		public String setProjectNameDetailsData(HashMap<String, String> decode_map) {
		
		String response = null;
		
		String last_count_query = dbMessage.getLastCountI453(decode_map);
		int last_count = dbhandler.getResponseDataCount(last_count_query);
		
		if(last_count == 0) {
	
		long recordNumber = getsequence();
		
			String strQuery = dbMessage.setProjectDetails(decode_map,recordNumber);
			int count = dbhandler.getResponseDB(strQuery);
			
			response= dbhandler.Insertresponse(count); 
		}else {
			response = dbhandler.CountJsonResponse(last_count);
		}
		log.write("DBTransaction.java", "setProjectNameDetailsData()"," DBT setProjectNameDetailsData Response :: "+response , 9);
		return response;
	}

		public String getL1Type() {
			
			String response = null;
			
			String query = dbMessage.getL1TypeData();
			if(query != null) {
				 String data_response = dbhandler.getResponseJsonData(query);
				  response = dbhandler.getReponseString(data_response);
			}
			log.write("DBTransaction.java", "getL1Type()"," DBT getL1Type Response :: "+response , 9);

			return response;
			
		}
		
		public long getsequence() {
			long ret = 0;
			String str_query = dbMessage.createSequence();
			ret = dbhandler.getResponseLongData(str_query);
			
			System.out.println(ret);
			log.write("DBTransaction.java", "getsequence()"," DBT getsequence Response :: "+ret , 9);

			return ret;
		}

		public String setProjectManagerDetails(HashMap<String, String> decode_map) {
			
			String response = null;
			
				String last_count_query = dbMessage.getLastcount454Data(decode_map);
				int last_count = dbhandler.getResponseDataCount(last_count_query);
			
				if(last_count == 0) {
					String query = dbMessage.setPMDetails(decode_map);
			
				 int count =  dbhandler.getResponseDB(query);
				  	response = dbhandler.Insertresponse(count);
				}else {
					response = dbhandler.LastCountResponse(last_count);
				}
				
				
				log.write("DBTransaction.java", "setProjectManagerDetails()"," DBT setProjectManagerDetails Response :: "+response , 9);
			return response;
			
		}

		public String DeleteProjectNameDetailsData(HashMap<String, String> decode_map) {
			String response = null;
			
			String str_i453_delete = dbMessage.DeleteI453Data(decode_map);
			int count_i453 = dbhandler.getResponseDB(str_i453_delete);
			
			String str_i454_delete = dbMessage.DeleteI454Data(decode_map);
			int count_i454 = dbhandler.getResponseDB(str_i454_delete);
			
			if(count_i453 != 0 && count_i454 != 0) {
				response = dbhandler.Deleteresponse(count_i454);
			}
			
			log.write("DBTransaction.java", "DeleteProjectNameDetailsData()"," DBT DeleteProjectNameDetailsData Response :: "+response , 9);

			return response;
		}

		public String DeleteManagerDetails(HashMap<String, String> decode_map) {
			String response = null;
			String str_query = dbMessage.DeleteManagerData(decode_map);
			int count = dbhandler.getResponseDB(str_query);
			
			response = dbhandler.Deleteresponse(count);
			log.write("DBTransaction.java", "DeleteManagerDetails()"," DBT DeleteManagerDetails Response :: "+response , 9);

			return response;
		}

		public String getProject_Data() {

			String response =null;
			
			String query = dbMessage.getProjectDetails_Data();
			if(query!= null) {
				 String data_response = dbhandler.getResponseJsonData(query);
				  response = dbhandler.getReponseString(data_response);
			}
			log.write("DBTransaction.java", "getProject_Data()"," DBT getProject_Data Response :: "+response , 9);

			return response;
		}

		public String ExtendedProjectDate(HashMap<String, String> decode_map) {
			String response = null;
			String str_query = dbMessage.ExtendedProjectDetails(decode_map);
			int count = dbhandler.getResponseDB(str_query);
			
			if(count == 1) {
				String str_query1 = dbMessage.ExtendedProjectAuthDetails(decode_map);
				 count = dbhandler.getResponseDB(str_query1);
			}
			
			response = dbhandler.UpdateResponse(count);
			log.write("DBTransaction.java", "ExtendedProjectDate()"," DBT ExtendedProjectDate Response :: "+response , 9);

			return response;
		}
		
		

		public String getManager_Data(HashMap<String, String> decode_map) {
			String response =null;
			
			String query = dbMessage.getManagerData(decode_map);
			if(query!= null) {
				 String data_response = dbhandler.getResponseJsonData(query);
				  response = dbhandler.getReponseString(data_response);
			}
			log.write("DBTransaction.java", "getManager_Data()"," DBT getManager Data Response :: "+response , 9);

			return response;

		}

		public String getActivityL1Data(HashMap<String, String> decode_map) {
			String response =null;
			
			String query = dbMessage.getActivityL1Details();
			if(query!= null) {
				 String data_response = dbhandler.getResponseJsonData(query);
				  response = dbhandler.getReponseString(data_response);
			}
			log.write("DBTransaction.java", "getActivityL1Data()"," DBT get activtyL1 Response :: "+response , 9);

			return response;
		}

		public String getActivityL2Data(HashMap<String, String> decode_map) {
			String response =null;
			
			String query = dbMessage.getActivityL2Details(decode_map);
			if(query!= null) {
				 String data_response = dbhandler.getResponseJsonData(query);
				  response = dbhandler.getReponseString(data_response);
			}
			log.write("DBTransaction.java", "getActivityL2Data()"," DBT get activtyL2 Response :: "+response , 9);

			return response;
		}
		
		public String InsertSkillMatrixData(HashMap<String, String> decode_map) {

			String response = null;
			
			String last_count_query = dbMessage.getLastCountI455(decode_map);
			int last_count = dbhandler.getResponseDataCount(last_count_query);
			
			if(last_count ==0) {
				String query = dbMessage.SetSkillMatrixDetails(decode_map);
			
				if(query!=null) {
					int count  = dbhandler.getResponseDB(query);
					response = dbhandler.Insertresponse(count);
				}
		}else {
			response = dbhandler.LastCountResponse(last_count);
		}
			
			log.write("DBTransaction.java", "InsertSkillMatrixData()"," DBT InsertSkillMatrixData Response :: "+response , 9);
			return response;
		}
		
		
		public String DeleteSkillMatrixData(HashMap<String, String> decode_map) {

			String response = null;
			String query = dbMessage.DeleteSkillMatrixDetails(decode_map);
			if(query!=null) {
				int count = dbhandler.getResponseDB(query);
				response = dbhandler.Deleteresponse(count);
			}
			
			log.write("DBTransaction.java", "DeleteSkillMatrixData()"," DBT DeleteSkillMatrixData Response :: "+response , 9);
			return response;
		}

		public String GetSkillMatrixData() {
			
			String response = null;
			String query = dbMessage.GetSkillMatrixDetails();
			
			if(query!=null) {
				String  data_response = dbhandler.getResponseJsonData(query);
				response = dbhandler.getReponseString(data_response);
			}
			
			log.write("DBTransaction.java", "GetSkillMatrixData()"," DBT GetSkillMatrixData Response :: "+response , 9);
			return response;
		}

		public String getL2Data(HashMap<String, String> decode_map) {
			
			String response = null;
			String query = dbMessage.getL2Data(decode_map); 
			if(query!=null) {
				String data_response = dbhandler.getResponseJsonData(query);
				response = dbhandler.getReponseString(data_response);
			}
			log.write("DBTransaction.java", "getL2Data()"," DBT getL2Data Response :: "+response , 9);

			return response;
		}

		public String getL3Data(HashMap<String, String> decode_map) {
			
			String response = null;
			String query = dbMessage.getL3Data(decode_map);
			
			if(query!= null) {
				String data_response = dbhandler.getResponseJsonData(query);
				response = dbhandler.getReponseString(data_response);
			}
			log.write("DBTransaction.java", "getL3Data()"," DBT getL3Data Response :: "+response , 9);

			return response;
		}

		public String setL2L3Data(HashMap<String, String> decode_map) {
			
			String response = null;
			
			long recordNumber = 0;
			if(!(decode_map.get("l2name").equals("null")) && decode_map.get("l3name").equals("null")) {
				
				String last_count_query = dbMessage.getL2LastCountQuery(decode_map);
				int last_count = dbhandler.getResponseDataCount(last_count_query);
				
				if(last_count == 0) {
					 recordNumber = getsequence();
					String query = dbMessage.setL2Data(decode_map,recordNumber);
					
					int data_Response = dbhandler.getResponseDB(query);
					response = dbhandler.Insertresponse(data_Response);
				}else {
					response = dbhandler.LastCountResponse(last_count);
				}
			
			}
			
			if(!decode_map.get("l3name").equals("null")) {
					
					String last_count_query2 = dbMessage.getL3LastCountQuery(decode_map);
					int last_count2 = dbhandler.getResponseDataCount(last_count_query2);
					
					if(last_count2 ==0) {
						
						long recordNumber2 = getsequence();
						String  query2 = dbMessage.setL3Data(decode_map, recordNumber, recordNumber2);
						int data_Response2 = dbhandler.getResponseDB(query2);
						 response = dbhandler.Insertresponse(data_Response2);
					}else {
						response = dbhandler.LastCountResponse(last_count2);
					}
			}
			
			log.write("DBTransaction.java", "setL2L3Data()"," DBT setL2L3Data Response :: "+response , 9);

			return response;
		}

		public String setWBSAuthData(HashMap<String, String> decode_map) {
			
			String response =null;
			
			String Last_count_query = dbMessage.getLastCountI454Auth(decode_map);
			int last_count = dbhandler.getResponseDataCount(Last_count_query);
			
			if(last_count==0) {
				
				String query = dbMessage.setWBSAuthData(decode_map);
				int data_response = dbhandler.getResponseDB(query);
				response = dbhandler.Insertresponse(data_response);
				
			}else {
				response = dbhandler.LastCountResponse(last_count);
			}
			log.write("DBTransaction.java", "setWBSAuthData()"," DBT setWBSAuthData Response :: "+response , 9);

			return response;
		}

		
		
		public String getPMGridData(HashMap<String, String> decode_map) {
			String response = null;
			
			String query = dbMessage.getPMGridDetails(decode_map);
			
			String data_response = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(data_response);
			
			log.write("DBTransaction.java", "getPMGridData()"," DBT getPM Grid Data Response :: "+response , 9);

			return response;

		}

		public String setPAMData(HashMap<String, String> decode_map) {
			String response =null;
			
			String Last_count_query = dbMessage.getLastCountI454PAMData(decode_map);
			int last_count = dbhandler.getResponseDataCount(Last_count_query);
			
			if(last_count==0) {
				
				String query = dbMessage.setPAMDetailsData(decode_map);
				int data_response = dbhandler.getResponseDB(query);
				response = dbhandler.Insertresponse(data_response);
				
			}else {
				response = dbhandler.LastCountResponse(last_count);
			}
			log.write("DBTransaction.java", "setWBSAuthData()"," DBT setWBSAuthData Response :: "+response , 9);

			return response;
		}

		public String setDeliverableData(HashMap<String, String> decode_map) {
			String response =null;
			
			String Last_count_query = dbMessage.getLastCountI456DeliveryData(decode_map);
			int last_count = dbhandler.getResponseDataCount(Last_count_query);
			
			if(last_count==0) {
				
				String query = dbMessage.setI456DeliveryMasterData(decode_map);
				int data_response = dbhandler.getResponseDB(query);
				
				String query1 = dbMessage.setdelHistoryi457Data(decode_map);
				 data_response = dbhandler.getResponseDB(query1);
				 
				 response = dbhandler.Insertresponse(data_response);
				
			}else {
				response = dbhandler.LastCountResponse(last_count);
			}
			log.write("DBTransaction.java", "setWBSAuthData()"," DBT setWBSAuthData Response :: "+response , 9);

			return response;

		}

		public String getDeliverableGrid(HashMap<String, String> decode_map) {
			String response = null;
			
			String str_query = dbMessage.getDelliverableGridData(decode_map);

			String data_response = dbhandler.getResponseJsonData(str_query);
			response = dbhandler.getReponseString(data_response);
			
			log.write("DBTransaction.java", "getDeliverableGrid()"," DBT get Deliverable Grid Response :: "+response , 9);

			return response;
		}

		public String getModuleGridData(HashMap<String, String> decode_map) {
			String response = null;
			
			String query = dbMessage.getModuleGridDetails(decode_map);
			
			String data_response = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(data_response);
			
			log.write("DBTransaction.java", "getModuleGridData()"," DBT get Module Grid Data Response :: "+response , 9);

			return response;
		}

		public String getComponentGridData(HashMap<String, String> decode_map) {
			String response = null;
			
			String query = dbMessage.getComponentGridDetails(decode_map);
			String data_response = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(data_response);
			
			log.write("DBTransaction.java", "getModuleGridData()"," DBT get Component Grid Data Response :: "+response , 9);

			return response;
		}

		public String setDeliverableAssignData(HashMap<String, String> decode_map) {
			String response =null;
			
			String Last_count_query = dbMessage.getLastCountI458DeliveryAssignData(decode_map);
			int last_count = dbhandler.getResponseDataCount(Last_count_query);
			
			if(last_count==0) {
				
				String query = dbMessage.setI458DeliveryAssignData(decode_map);
				int data_response = dbhandler.getResponseDB(query);
				
				String query1 = dbMessage.setdelAssignHistoryi457Data(decode_map);
				 data_response = dbhandler.getResponseDB(query1);
				
				response = dbhandler.Insertresponse(data_response);
				
				if(data_response > 0) {
					String update_query = dbMessage.UpdateI456Activity(decode_map);
					 data_response = dbhandler.getResponseDB(update_query);
				}
				
				int update_l1 = UpdateActivityData(decode_map);
			}else {
				response = dbhandler.LastCountResponse(last_count);
			}
			log.write("DBTransaction.java", "setDeliverableAssignData()"," DBT set Deliverable Assign Data Response :: "+response , 9);

			return response;

		}

		private int UpdateActivityData(HashMap<String, String> decode_map) {
			int count = 0;
			String str_query = dbMessage.selectactivityL1data(decode_map);
			int actl1id = dbhandler.getResponseDataCount(str_query);
			
			String str_update_query = dbMessage.UpdateActivityl1id(decode_map,actl1id);
			count = dbhandler.getResponseDB(str_update_query);
			
			return count;
		}

		public String getPAMPDUData(HashMap<String, String> decode_map) {
			String response = null;
			
			String query = dbMessage.getPAMPDUDetails(decode_map);
			String data_response = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(data_response);
			
			log.write("DBTransaction.java", "getPAMPDUData()"," DBT get PAM PDU Data Response :: "+response , 9);

			return response;
		}

		public String getPDUGridData(HashMap<String, String> decode_map) {
			String response = null;
			
			String query = dbMessage.getPDUGridDetails(decode_map);
			String data_response = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(data_response);
			
			log.write("DBTransaction.java", "getPDUGridData()"," DBT get PDU Grid Data Response :: "+response , 9);

			return response;
		}

		public String SetActivityforPDU(HashMap<String, String> decode_map) {
			String response =null;
			
			String Last_count_query = dbMessage.getLastCountI459PDUActivityData(decode_map);
			int last_count = dbhandler.getResponseDataCount(Last_count_query);
			
			if(last_count==0) {
				
				String last_time_query = dbMessage.LastTimeCheckcount(decode_map);
				int last_time = dbhandler.getResponseDataCount(last_time_query);
				
				if(last_time == 0) {
					String query = dbMessage.setI459PDUActivityData(decode_map);
					int data_response = dbhandler.getResponseDB(query);
					
					if(data_response == 1) {
						
						String str_add_history_query = dbMessage.setdeliverableHistoryi457Data(decode_map);
						data_response = dbhandler.getResponseDB(str_add_history_query);
						
						String str_add_date_query = dbMessage.SetAddDateQuery(decode_map);
						data_response = dbhandler.getResponseDB(str_add_date_query);
						
						String str_update_status =  dbMessage.UpdateStatusQuery(decode_map);
						data_response = dbhandler.getResponseDB(str_update_status);
						
						String str_update_bug = dbMessage.UpdateBugReportQuery(decode_map);
						data_response = dbhandler.getResponseDB(str_update_bug);
					}
					response = dbhandler.Insertresponse(data_response);
				}
			}else {
				response = dbhandler.LastCountResponse(last_count);
		}
			log.write("DBTransaction.java", "SetActivityforPDU()"," DBT Set Activity for PDU Response :: "+response , 9);

			return response;
		}
		
		public String getAddedActivityDetails(HashMap<String, String> decode_map) {
			String response = null;
			
			String query = dbMessage.getActivityGridDetails(decode_map);
			String data_response = dbhandler.getResponseJsonData(query);
			//System.out.println("Data Response : "+data_response);
			response = dbhandler.getReponseString(data_response);
		//	System.out.println("Response : "+response );
			log.write("DBTransaction.java", "getAddedActivityDetails()"," DBT get Added Activity Grid Data Response :: "+response , 9);

			return response;
			
		}

		public String SetWorkitemDetails(HashMap<String, String> decode_map) {
			String response =null;
			
			String Last_count_query = dbMessage.getLastCountI460DelWIData(decode_map);
			int last_count = dbhandler.getResponseDataCount(Last_count_query);
			
			if(last_count==0) {
				
				String query = dbMessage.setI460DelWIData(decode_map);
				int data_response = dbhandler.getResponseDB(query);
				response = dbhandler.Insertresponse(data_response);
				
			}else {
				response = dbhandler.LastCountResponse(last_count);
			}
			log.write("DBTransaction.java", "SetWorkitemDetails()"," DBT Set Workitem Details Response :: "+response , 9);

			return response;
		}

		public String getWorkitemData(HashMap<String, String> decode_map) {
			String response = null;
			
			String query = dbMessage.getWorkitemGridDetails(decode_map);
			String data_response = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(data_response);
			
			log.write("DBTransaction.java", "getWorkitemData()"," DBT get Workitem  Grid Data Response :: "+response , 9);

			return response;	
		}

		public String UpdateEndtimeactivity(HashMap<String, String> decode_map) {
			String response = null;
			
			String str_update = dbMessage.UpdateEndtimeUnplanned(decode_map);
			int count = dbhandler.getResponseDB(str_update);
			
			String str_eminlog_query = dbMessage.SelectEminlogUnplannedQuery(decode_map);
			String emin = dbhandler.getResponseStringCount(str_eminlog_query);
			

			System.out.println(" e minutes :: (UpdateEndtimeactivity) " + emin);
			
			String str_update1 = dbMessage.UpdateEminData(decode_map,emin);
			 count = dbhandler.getResponseDB(str_update1);
			
			if(count == 1 && (decode_map.get("taskstatus").equals("Completed"))) {
				String str_update_end_date = dbMessage.UpdateEndDateData(decode_map);
				 count = dbhandler.getResponseDB(str_update_end_date);
				 
				 String str_add_history_query = dbMessage.setdeliverableHistoryi457Data(decode_map);
				count = dbhandler.getResponseDB(str_add_history_query);
					
				 		
			}
			
			
			if(count > 0) {
				response = dbhandler.UpdateResponse(count);
			}
			
			log.write("DBTransaction.java", "UpdateEndtimeactivity()"," DBT update endtime Response :: "+response , 9);

			return response;	
		}

		public String getWITypeData() {
			String response = null;
			
			String str_query = dbMessage.getWITypeDetails();
			String data_response = dbhandler.getResponseJsonData(str_query);
			response = dbhandler.getReponseString(data_response);
			
			log.write("DBTransaction.java", "getWITypeData()"," DBT get WI TypeData Response :: "+response , 9);

			return response;	
		}

		public String AddBudDetailsData(HashMap<String, String> decode_map,String decode_data) {
			String response = null;
			int count = 0;
			
			String typeL1Data = cDMethods.RecTypeL1Json(decode_map);
			String ObservationData = cDMethods.ObservationJson(decode_map);
			
			String str_lastcount_check = dbMessage.LastcountBugReport(decode_map,typeL1Data);
			int last_count = dbhandler.getResponseDataCount(str_lastcount_check);
			
			if(last_count == 0) { 
			
				String str_query = dbMessage.AddedBugReportData(decode_map,typeL1Data,ObservationData);
				count = dbhandler.getResponseDB(str_query);	
			}
			
				String rec_tracking_query = dbMessage.AddRecordTrackingDetails(decode_map,decode_data);
				count = dbhandler.getResponseDB(rec_tracking_query);
			
				if(last_count == 1) {
					String update_count = dbMessage.UpdateBugReportJson(decode_map);
					count = dbhandler.getResponseDB(update_count);
				}
				
			response = dbhandler.Insertresponse(count);
				
			
		log.write("DBTransaction.java", "AddBudReportData()"," DBT AddBudReportData Response :: "+response , 9);

		return response;	

		}

		public String getBugReportScreenData(HashMap<String, String> decode_map) {
			String response = null;
			
			String str_query = dbMessage.getBugReportData(decode_map);
			String data_response = dbhandler.getResponseJsonData(str_query);
			response = dbhandler.getReponseString(data_response);
			
			log.write("DBTransaction.java", "getWITypeData()"," DBT get WI TypeData Response :: "+response , 9);

			return response;		
		}

		public String SetBugReportUserData(HashMap<String, String> decode_map) {
			String response =null;
			
			
				String query = dbMessage.setBugReportUserComments(decode_map);
				int data_response = dbhandler.getResponseDB(query);
				
				String query1 = dbMessage.setBugstatusi461(decode_map);
				int data_response1 = dbhandler.getResponseDB(query1);
				
				if(data_response > 0 && data_response1 > 0) {
					response = dbhandler.UpdateResponse(data_response1);
				}
				
			log.write("DBTransaction.java", "SetBugReportUserData()"," DBT Set BugReport UserData Response :: "+response , 9);

			return response;
		}

		public String setUnplannedDetails(HashMap<String, String> decode_map) {
			String response = null;
			
			String Last_count_query = dbMessage.getLastCountI459PDUActivityData(decode_map);
			int last_count = dbhandler.getResponseDataCount(Last_count_query);
			
			if(last_count==0) {
				
				String last_time_query = dbMessage.LastTimeCheckUnplannedcount(decode_map);
				int last_time = dbhandler.getResponseDataCount(last_time_query);
				
				if(last_time == 0) {
				
					String query = dbMessage.setI459PDUActivityUnplannedData(decode_map);
					int data_response = dbhandler.getResponseDB(query);
					
					String str_eminlog_query = dbMessage.SelectEminlogUnplannedQuery(decode_map);
					String emin = dbhandler.getResponseStringCount(str_eminlog_query);
					
					System.out.println(" emin :: " + emin);
					
					String str_update1 = dbMessage.UpdateEminUnplannedData(decode_map,emin);
					int count = dbhandler.getResponseDB(str_update1);
						
					response = dbhandler.Insertresponse(data_response);
				}	
			}else {
				response = dbhandler.LastCountResponse(last_count);
			}
			log.write("DBTransaction.java", "setUnplannedDetails()"," DBT set Unplanned Details Response :: "+response , 9);

			return response;
		}

		public String setCompleteDeliDetails(HashMap<String, String> decode_map) {
			String response = null;
			
			String str_update_i456 = dbMessage.UpdateEndDateData(decode_map);
			 int count = dbhandler.getResponseDB(str_update_i456);
			 
			 String str_add_history_query = dbMessage.setdeliverableActivityCompleteRequesti457Data(decode_map);
			 count = dbhandler.getResponseDB(str_add_history_query);
		
			 if(count > 0) {
				 response = dbhandler.UpdateResponse(count);
			 }
		
		log.write("DBTransaction.java", "setCompleteDeliDetails()"," DBT set CompleteDeli Details Response :: "+response , 9);

		return response;	
		}

		
		public String getPAMGridDetails(HashMap<String, String> decode_map) {
			
			String response = null;
			String query = dbMessage.getPAMGridData(decode_map);
			
			if(query != null) {
				
				String response_data = dbhandler.getResponseJsonData(query);
				response = dbhandler.getReponseString(response_data);
			}
			
			log.write("DBTransaction.java", "getPAMGridDetails()"," DBT get PAMGrid Details Response :: "+response , 9);
			return response;
		}

		public String PAMApproveRejectActionDetails(HashMap<String, String> decode_map) {
			
			String response = null;
			String query = dbMessage.pamApproveRejectActionData(decode_map);
			
			if(query != null) {
				
				int response_count = dbhandler.getResponseDB(query);
				response = dbhandler.UpdateResponse(response_count);
			}
			
				
//				if(response_count == 1 && decode_map.get("approvalentrystatus").equals("Approved")) {
//					String str_PAM_Approved_Delassi = dbMessage.UpdateApprovedStatusData(decode_map);
//					 response_count = dbhandler.getResponseDB(str_PAM_Approved_Delassi);		
//					 
//					 String str_Approved_DelMaster = dbMessage.UpdateStatusI456Query(decode_map);
//					 response_count = dbhandler.getResponseDB(str_Approved_DelMaster);
//					 
//					 String str_add_history_query = dbMessage.setdeliverablePAMApprovedi457Data(decode_map);
//					 response_count = dbhandler.getResponseDB(str_add_history_query);
//						
//				}
				
				
			log.write("DBTransaction.java", "PAMApproveRejectActionDetails()"," DBT PAM Approve Reject Action Details Response :: "+response , 9);
			return response;
		}


		public String GetUnplannedData(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getUnplannedDetails(decode_map);
			
				String response_data = dbhandler.getResponseJsonData(query);
				response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "GetUnplannedData()"," DBT Get Unplanned Data Response :: "+response , 9);
			return response;
		}

		public String getPDUWorkDetailsData(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getPDUDetails(decode_map);
				String response_data = dbhandler.getResponseJsonData(query);
				
			String query_1 = dbMessage.getWorkitemDetails(decode_map);
			String response_data_1 = dbhandler.getResponseJsonData(query_1);
			
				response = dbhandler.getReponsePDUString(response_data,response_data_1);
			
			log.write("DBTransaction.java", "getPDUWorkDetailsData()"," DBT get PDUWork Details Data Response :: "+response , 9);
			return response;
		}

		public String getPAMApprovedData(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getPAMApprovedData(decode_map);
			
				String response_data = dbhandler.getResponseJsonData(query);
				response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getPAMApprovedData()"," DBT get PAM Approved Details Response :: "+response , 9);
			return response;
		}

		public String getPAMRejectData(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getPAMRejectedData(decode_map);
			
				String response_data = dbhandler.getResponseJsonData(query);
				response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getPAMRejectData()"," DBT get PAM Reject Details Response :: "+response , 9);
			return response;
		}

		public String getPAMProjectDetails(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getPAMProjectData(decode_map);
			
			String response_data = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getPAMProjectDetails()"," DBT get PAMProject Details Response :: "+response , 9);
			return response;
		}

		public String getPAMModuleDetails(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getPAMModuleData(decode_map);
			
			String response_data = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getPAMModuleDetails()"," DBT get PAMModule Details Response :: "+response , 9);
			return response;
		}

		public String getPAMComponentDetails(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getPAMComponentData(decode_map);
			
			String response_data = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getPAMComponentDetails()"," DBT get PAMComponent Details Response :: "+response , 9);
			return response;
		}

		public String getPAMDeliverableDetails(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getPAMDeliverableData(decode_map);
			
			String response_data = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getPAMDeliverableDetails()"," DBT getPAMDeliverable Details Response :: "+response , 9);
			return response;
		}

		public String ProjectFilterData(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getProjectFilterDataQuery(decode_map);
			
			String response_data = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "ProjectFilterData()"," DBT Project Filter Data Response :: "+response , 9);
			return response;
		}

		public String setOnholdDetails(HashMap<String, String> decode_map) {
			String response = null;
			
			String str_update_i456 = dbMessage.UpdateStatusI456OnholdQuery(decode_map);
			 int count = dbhandler.getResponseDB(str_update_i456);		
		
			String str_del_i458 = dbMessage.UpdateOnholdstatusData(decode_map);
			count = dbhandler.getResponseDB(str_del_i458);
			 response = dbhandler.UpdateResponse(count);
		
			 log.write("DBTransaction.java", "setOnholdDetails()"," DBT set onhold Details Response :: "+response , 9);

			 return response;	
		}

		public String getPDUNameData(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getPDUNameData(decode_map);
			
			String response_data = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getPDUNameData()"," DBT getPDU Name Details Response :: "+response , 9);
			return response;
		}

		public String getDeliverableTrackingGrid(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getDeliverableTrackingGrid(decode_map);
			
			String response_data = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getDeliverableTrackingGrid()"," DBT get DeliverableTracking Grid Response :: "+response , 9);
			return response;
		}

		public String UpdateAppRejDelStatus(HashMap<String, String> decode_map) {
			String response = null;
			
			String query = dbMessage.UpdateAppRejDelData(decode_map);
			int count = dbhandler.getResponseDB(query);
			
			
			String query1 = dbMessage.UpdateStatusI456Query(decode_map);
			count = dbhandler.getResponseDB(query1);
			
			
			String query2 = dbMessage.setdeliverablePAMApprovedi457Data(decode_map);
			count = dbhandler.getResponseDB(query2);
			
			
			if(count > 0) {
				response = dbhandler.UpdateResponse(count);
			}
			
			log.write("DBTransaction.java", "UpdateAppRejDelStatus()"," DBT Update AppRej DelStatus Response :: "+response , 9);
			return response;
		}

		public String getDeliverablePAM(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getDeliverablePAMListdata(decode_map);
			
			String response_data = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getDeliverablePAM()"," DBT get Deliverable PAM Response :: "+response , 9);
			return response;
		}

		public String getPMDeliverableDetails(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getPMDeldetails(decode_map);
			
			String response_data = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getPMDeliverableDetails()"," DBT get PM Deliverabl Details Response :: "+response , 9);
			return response;
		}

		public String getBugDataPMside(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getPMBugDetails(decode_map);
			
			String response_data = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getBugDataPMside()"," DBT get BugData PM side Response :: "+response , 9);
			return response;
	
		}

		public String getDeliverablePDU(HashMap<String, String> decode_map) {
			String response = null;
			String query = dbMessage.getDeliverablePUDListdata(decode_map);
			
			String response_data = dbhandler.getResponseJsonData(query);
			response = dbhandler.getReponseString(response_data);
			
			log.write("DBTransaction.java", "getDeliverablePDU()"," DBT get Deliverable PDU Response :: "+response , 9);
			return response;
		}

		
}
