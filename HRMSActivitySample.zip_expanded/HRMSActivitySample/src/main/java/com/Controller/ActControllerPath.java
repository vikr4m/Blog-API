package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActControllerPath {

	@Autowired
	ActControllerSet handleData;
	
	@PostMapping(ActControllerConstant.ADD_PROJECT_CLASS_PATH)
	public String SetProjectdetails(@RequestBody String data) {
		System.out.println("Encode String ::" + data);
		return handleData.SetProjectNameData(data);
	}
	
	@PostMapping(ActControllerConstant.GET_L1_TYPE_CLASS_PATH)
	public String getL1Data(@RequestBody String data) {
		System.out.println("Encode JSON String ::"+data);
		return handleData.getL1_TypeData(data);
	}
	
	@PostMapping(ActControllerConstant.SET_PROJECTDETAILS_CLASS_PATH)
	public String SetProjectManagerData(@RequestBody String data) {
		System.out.println("Encode JSON String ::"+data);
		return handleData.SetPMDetails(data);
	}
	
	@PostMapping(ActControllerConstant.GET_PROJECT_DETAILS)
	public String getProjectDetails(@RequestBody String data) {
		System.out.println("Encode JSON String :"+data);
		return handleData.getProjectData(data);
	}
	
	@PostMapping(ActControllerConstant.SET_SKILLMATRIX_DETAILS)
	public String SetSkillMatrix(@RequestBody String data) {
		System.out.println("Encode SkillMatrix json ::"+data);
		return handleData.setSkillMatrixDetails(data);
	}
	
	@PostMapping(ActControllerConstant.SET_L2L3_DETAILS)
	public String setL2L3Details(@RequestBody String data) {
		System.out.println("Encode L2L3 json ::"+data);
		return handleData.setL2L3Data(data);
	}
	
	@PostMapping(ActControllerConstant.SET_WBS_AUTH_DETAILS)
	public String setWBSAuthData(@RequestBody String data) {
		System.out.println("Encode WBS Auth json ::"+data);
		return handleData.setWBSAuthDetails(data);
	}
	
	
	@PostMapping(ActControllerConstant.GET_FILTERDATA_DETAILS)
	public String getFilterData(@RequestBody String data) {
		System.out.println("Encode filter json ::"+data);
		return handleData.getFilterDetails(data);
	}
	
	@PostMapping(ActControllerConstant.SET_DELIVERABLE_DETAILS)
	public String setDeliverableData(@RequestBody String data) {
		System.out.println("Encode delivearble json ::"+data);
		return handleData.setDeliverableDetails(data);
	}
	
	
	@PostMapping(ActControllerConstant.SET_PDU_DETAILS)
	public String setPDUData(@RequestBody String data) {
		System.out.println("Encode PDU json ::"+data);
		return handleData.setPDUDetails(data);
	}
	
	
	@PostMapping(ActControllerConstant.SET_BUG_DETAILS)
	public String setBugData(@RequestBody String data) {
		System.out.println("Encode Bug json ::"+data);
		return handleData.setBugDetails(data);
	}
	
	@PostMapping(ActControllerConstant.SET_BUGREPORT_DETAILS)
	public String setBugReportData(@RequestBody String data) {
		System.out.println("Encode Bugreport json ::"+data);
		return handleData.setBugReportDetails(data);
	}
	
	
	@PostMapping(ActControllerConstant.SET_UNPLANNED_DETAILS)
	public String setUnplannedData(@RequestBody String data) {
		System.out.println("Encode unplanned json ::"+data);
		return handleData.setUnplannedDetails(data);
	}
	
	
	@PostMapping(ActControllerConstant.SET_COMEPLETED_DELIVERABLE_DETAILS)
	public String setCompleteDeliverableData(@RequestBody String data) {
		System.out.println("Encode complete deleverable json ::"+data);
		return handleData.setCompletedeliverableDetails(data);
	}
	
	@PostMapping(ActControllerConstant.GET_PAM_GRID_DATA)
	public String getPAMGridData(@RequestBody String data) {
		System.out.println("Encoded PAM Grid Data JSON : "+data);
		return handleData.getPAMGridDetails(data);
	}
	
	@PostMapping(ActControllerConstant.PAM_APPROVE_REJECT_ACTION)
	public String PAMApproveRejectAction(@RequestBody String data) {
		System.out.println("Encoded PAM Approve Reject Action : "+data);
		return handleData.PAMApproveRejectAction(data);
	}
	


}
