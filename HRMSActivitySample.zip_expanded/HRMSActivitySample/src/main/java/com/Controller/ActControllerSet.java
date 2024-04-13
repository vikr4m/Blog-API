package com.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CommonMethodParse.CommonMethods;
import com.Database.DBTransaction;

import ownyit.utility.OwnYitJSON;

@Service
public class ActControllerSet {
	
	@Autowired 
	DBTransaction dbTransaction;
	
	@Autowired 
	CommonMethods cdMethods;

	public String SetProjectNameData(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		String decode_data =  cdMethods.decodeBase64(user_json);
		HashMap<String, String> decode_map = parse_data.parse(decode_data);
		System.out.println("decode data ::" + decode_map);
		
		if(decode_map != null) {
			
			if(decode_map.get("action").equals("1")) {
				strData = dbTransaction.setProjectNameDetailsData(decode_map);
			}else {
				strData = dbTransaction.DeleteProjectNameDetailsData(decode_map);
			}
		}
		
		return strData;
	}

	public String getL1_TypeData(String data) {
		String strdata = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		
			String decode_data = cdMethods.decodeBase64(user_json);
			HashMap<String, String> decode_map = parse_data.parse(decode_data);
			System.out.println("decode_map : "+decode_map);
			
			if(decode_map.get("action").equals("1")) {
				strdata = dbTransaction.getL1Type();
			}else if(decode_map.get("action").equals("2")) {
				strdata = dbTransaction.getActivityL1Data(decode_map);
			}else if(decode_map.get("action").equals("3")) {
				strdata = dbTransaction.getActivityL2Data(decode_map);
			}else if(decode_map.get("action").equals("4")) {
				strdata = dbTransaction.getWITypeData();
			}
		
		return strdata;
	}
	
	public String setSkillMatrixDetails(String data) {

		String str_data  = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		String user_json = map_data.get("user_json");
			
			String decode_data = cdMethods.decodeBase64(user_json);
			HashMap<String, String> decode_map = parse_data.parse(decode_data);	
			System.out.println(decode_map);
			
			if(decode_map.get("action").equals("1")) {
				 str_data = dbTransaction.InsertSkillMatrixData(decode_map);
			}else if(decode_map.get("action").equals("2")) {
				str_data = dbTransaction.GetSkillMatrixData();
			}else if(decode_map.get("action").equals("3")) {
				 str_data =  dbTransaction.DeleteSkillMatrixData(decode_map);
			}
		
		return str_data;
	}



	public String SetPMDetails(String data) {
		String strdata = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		
			String decode_data = cdMethods.decodeBase64(user_json);
			HashMap<String, String> decode_map = parse_data.parse(decode_data);
			System.out.println("decode_map : "+decode_map);
			
			if(decode_map.get("action").equals("1")) {
				strdata = dbTransaction.setProjectManagerDetails(decode_map);
			}else if(decode_map.get("action").equals("2")) {
				strdata = dbTransaction.DeleteManagerDetails(decode_map);
			}else {
				strdata = dbTransaction.ExtendedProjectDate(decode_map);
			}
		
		return strdata;
	}
	
	public String getProjectData(String data) {
		
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		
			String decode_data = cdMethods.decodeBase64(user_json);
			HashMap<String, String> decode_map = parse_data.parse(decode_data);
			System.out.println("decode_map : "+decode_map);
			
			if(decode_map.get("action").equals("1")) {
				strData = dbTransaction.getProject_Data();
			}else if(decode_map.get("action").equals("2")){
				strData = dbTransaction.getManager_Data(decode_map);
//			}else if(decode_map.get("action").equals("3")) {
//				strData = dbTransaction.getProjectDetails(decode_map);
			}
		return strData;
	}
	
	public String setL2L3Data(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		String decode_data =  cdMethods.decodeBase64(user_json);
		HashMap<String, String> decode_map = parse_data.parse(decode_data);
		System.out.println("decode data ::" + decode_map);
		
		if(decode_map != null) {
			
			if(decode_map.get("action").equals("1")) {
				strData = dbTransaction.getL2Data(decode_map);
			}else if(decode_map.get("action").equals("2")) {
				strData = dbTransaction.getL3Data(decode_map);
			}else if(decode_map.get("action").equals("3")) {
				strData = dbTransaction.setL2L3Data(decode_map);
			}else if(decode_map.get("action").equals("4")) {
				strData = dbTransaction.getPMGridData(decode_map);
			}else if(decode_map.get("action").equals("5")) {
				strData = dbTransaction.getModuleGridData(decode_map);
			}else if(decode_map.get("action").equals("6")){
				strData = dbTransaction.getComponentGridData(decode_map);
			}
		
	}
		return strData;
	}

	public String setWBSAuthDetails(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		String decode_data =  cdMethods.decodeBase64(user_json);
		HashMap<String, String> decode_map = parse_data.parse(decode_data);
		System.out.println("decode data ::" + decode_map);
		if(decode_map !=null) {
			
			if(decode_map.get("action").equals("1")) {
				strData = dbTransaction.setWBSAuthData(decode_map);
			}else if(decode_map.get("action").equals("2")) {
				strData = dbTransaction.setPAMData(decode_map);
			}
		}
		return strData;
	}

	public String setDeliverableDetails(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		String decode_data =  cdMethods.decodeBase64(user_json);
		HashMap<String, String> decode_map = parse_data.parse(decode_data);
		System.out.println("decode data ::" + decode_map);
		
			
			if(decode_map.get("action").equals("1")) {
				strData = dbTransaction.setDeliverableData(decode_map);
			}else if(decode_map.get("action").equals("2")) {
				strData = dbTransaction.getDeliverableGrid(decode_map);
			}else if(decode_map.get("action").equals("3")) {
				strData = dbTransaction.setDeliverableAssignData(decode_map);
			}else if(decode_map.get("action").equals("4")){
				strData = dbTransaction.getPAMPDUData(decode_map);
			}else if(decode_map.get("action").equals("5")){
				strData = dbTransaction.getDeliverablePAM(decode_map);
			}else if(decode_map.get("action").equals("6")){
				strData = dbTransaction.getPMDeliverableDetails(decode_map);
			}else {
				strData = dbTransaction.getDeliverablePDU(decode_map);
			}
		
			return strData;
	}

	public String setPDUDetails(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		String decode_data =  cdMethods.decodeBase64(user_json);
		HashMap<String, String> decode_map = parse_data.parse(decode_data);
		System.out.println("decode data ::" + decode_map);
		
		if(decode_map.get("action").equals("1")) {
			strData = dbTransaction.getPDUGridData(decode_map);
		}else if(decode_map.get("action").equals("2")) {
			strData = dbTransaction.SetActivityforPDU(decode_map);
		}else if(decode_map.get("action").equals("3")) {
			strData = dbTransaction.getAddedActivityDetails(decode_map);
		}else if(decode_map.get("action").equals("4")) {
			strData = dbTransaction.SetWorkitemDetails(decode_map);
		}else if(decode_map.get("action").equals("5")) {
			strData = dbTransaction.getWorkitemData(decode_map);
		}else if(decode_map.get("action").equals("6")) {
			strData = dbTransaction.UpdateEndtimeactivity(decode_map);
		}else {
			strData = dbTransaction.ProjectFilterData(decode_map);
		}
		
		return strData;
	}

	public String setBugDetails(String data) {
	String strData = null;
		
	OwnYitJSON parse_data = new OwnYitJSON();
	
	HashMap<String, String> map_data = parse_data.parse(data);
	
	String user_json = map_data.get("user_json");
	String decode_data =  cdMethods.decodeBase64(user_json);
	HashMap<String, String> decode_map = parse_data.parse(decode_data);
	System.out.println("decode data ::" + decode_map);
	
		strData = dbTransaction.AddBudDetailsData(decode_map,decode_data);

		return strData;
	}

		
		
		public String setBugReportDetails(String data) {
			String strData = null;
		OwnYitJSON parse_data = new OwnYitJSON();
		
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		String decode_data =  cdMethods.decodeBase64(user_json);
		HashMap<String, String> decode_map = parse_data.parse(decode_data);
		System.out.println("decode data ::" + decode_map);
		
		if(decode_map.get("action").equals("1")) {
			strData = dbTransaction.getBugReportScreenData(decode_map);
		}else if(decode_map.get("action").equals("2")) {
			strData = dbTransaction.SetBugReportUserData(decode_map);
		}else {
			strData = dbTransaction.getBugDataPMside(decode_map);
		}
		
		return strData;
	}

	public String setUnplannedDetails(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		String decode_data =  cdMethods.decodeBase64(user_json);
		HashMap<String, String> decode_map = parse_data.parse(decode_data);
		System.out.println("decode data ::" + decode_map);
		
		if(decode_map.get("action").equals("1")) {
			strData = dbTransaction.setUnplannedDetails(decode_map);
		}else {
			strData = dbTransaction.GetUnplannedData(decode_map);
		}
		return strData;
	}

	public String setCompletedeliverableDetails(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		String decode_data =  cdMethods.decodeBase64(user_json);
		HashMap<String, String> decode_map = parse_data.parse(decode_data);
		System.out.println("decode data ::" + decode_map);
		
		if(decode_map.get("action").equals("1")) {
			strData = dbTransaction.setCompleteDeliDetails(decode_map);
		}else {
			strData = dbTransaction.setOnholdDetails(decode_map);
		}
		return strData;
	}
	
	public String getPAMGridDetails(String data) {

		String strData = null;
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		String user_json = map_data.get("user_json");
		String decode_data = cdMethods.decodeBase64(user_json);
		HashMap<String, String> decode_map = parse_data.parse(decode_data);
		System.out.println("Decode Data : "+decode_map);
		
		if(decode_map.get("action").equals("1")) {
			strData = dbTransaction.getPAMGridDetails(decode_map);
		}else if(decode_map.get("action").equals("2")){
			strData = dbTransaction.getPDUWorkDetailsData(decode_map);
		}else if(decode_map.get("action").equals("3")) {
			strData = dbTransaction.getPAMApprovedData(decode_map);
		}else if(decode_map.get("action").equals("4")){
			strData = dbTransaction.getPAMRejectData(decode_map);
		}else if(decode_map.get("action").equals("5")) {
			strData = dbTransaction.getDeliverableTrackingGrid(decode_map);
		}else {
			strData = dbTransaction.UpdateAppRejDelStatus(decode_map);
		}
		return strData;
	}

	public String PAMApproveRejectAction(String data) {
		
		String strData = null;
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		String user_json = map_data.get("user_json");
		String decode_data = cdMethods.decodeBase64(user_json);
		HashMap<String, String> decode_map = parse_data.parse(decode_data);
		System.out.println("Decode Data : "+decode_map);
		
		if(decode_map.get("action").equals("1")) {
			
			strData = dbTransaction.PAMApproveRejectActionDetails(decode_map);
		}
		
		return strData;
	}

	public String getFilterDetails(String data) {

		String strData = null;
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		String user_json = map_data.get("user_json");
		String decode_data = cdMethods.decodeBase64(user_json);
		HashMap<String, String> decode_map = parse_data.parse(decode_data);
		System.out.println("Decode Data : "+decode_map);
		
		if(decode_map.get("action").equals("1")) {
			strData = dbTransaction.getPAMProjectDetails(decode_map);
		}else if(decode_map.get("action").equals("2")) {
			strData = dbTransaction.getPAMModuleDetails(decode_map);
		}else if(decode_map.get("action").equals("3")) {
			strData = dbTransaction.getPAMComponentDetails(decode_map);
		}else if(decode_map.get("action").equals("4")){
			strData = dbTransaction.getPAMDeliverableDetails(decode_map);
		}else {
			strData = dbTransaction.getPDUNameData(decode_map);
		}
	
	
	return strData;
	}

	
}
