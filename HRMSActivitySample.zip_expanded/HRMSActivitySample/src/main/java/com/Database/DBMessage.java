package com.Database;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ownyitv4.log.LogWriter;

@Service
public class DBMessage {
	
	@Autowired
	LogWriter log;

	public String setProjectDetails(HashMap<String, String> decode_map,long rNumber) {
		
		String query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_PROJECT_NAME_QUERY);
		builder.append("0");
		builder.append(",'");
		builder.append("L1Type");
		builder.append("','");
		builder.append(decode_map.get("l1type"));
		builder.append("',");
		builder.append(rNumber);
		builder.append(",'");
		builder.append(decode_map.get("ProjectName"));
		builder.append("','");
		builder.append(decode_map.get("startdate"));
		builder.append("',date '");
		builder.append(decode_map.get("startdate"));
		builder.append("' + 182,1)");
		
		query = builder.toString();
		System.out.println("setProjectNameQuery :: "+query);
		log.write("DBMessage.java", "setProjectDetails()", "Set Project Details Query :: "+query, 9);
		return query;
	}
	
	public String getLastCountI453(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.LAST_COUNT_I453_QUERY);
		builder.append(decode_map.get("ProjectName"));
		builder.append("' and l1type = '");
		builder.append(decode_map.get("l1type"));
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("Last count I453 Query :: "+str_query);
		log.write("DBMessage.java", "getLastCountI453()", " Last Count I453 Query :: "+str_query, 9);

		return str_query;
	}
	
	public String createSequence() {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_SEQUENCE_QUERY);
		str_query = builder.toString();
		System.out.println("create sequence Query :: "+str_query);
		log.write("DBMessage.java", "createSequence()", " Get Sequence Query :: "+str_query, 9);

		return str_query;
	}
	
	public String getL1TypeData() {

		String str_query = null;
		
		StringBuilder builder = new StringBuilder(DBQuery.GET_L1_TYPE_QUERY);
		
		str_query = builder.toString();
		System.out.println("get L1Type Query:: "+str_query);
		log.write("DBMessage.java", "getL1TypeData()", " Get L1 Type  Query :: "+str_query, 9);

		return str_query;
	}

	public String setPMDetails(HashMap<String, String> map_data) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_MANAGER_NAME_QUERY);
		builder.append(map_data.get("wbsid"));
		builder.append(",'");
		builder.append("L1PM");
		builder.append("','");
		builder.append(map_data.get("pmid"));
		builder.append("','");
		builder.append(map_data.get("pmname"));
		builder.append("','");
		builder.append(map_data.get("startdate"));
		builder.append("','");
		builder.append(map_data.get("enddate"));
		builder.append("',1)");
		
		str_query = builder.toString();
		System.out.println("Set Manager Name Details query ::"+str_query);
		log.write("DBMessage.java", "setPMDetails()", " Set Manager Name  Query :: "+str_query, 9);

		return str_query;
	}

	

	public String getLastcount454Data(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_LASTCOUNT_454_QUERY);
		builder.append(decode_map.get("wbsid"));
		builder.append(" and typeofentry = 'L1PM'");
		builder.append(" and pmpamid = '");
		builder.append(decode_map.get("pmid"));
		builder.append("' and pmpamname = '");
		builder.append(decode_map.get("pmname"));
		builder.append("' and '");
		builder.append(decode_map.get("startdate"));
		builder.append("' between startdate and enddate");
		builder.append(" and active = 1");
		
		str_query = builder.toString();
		System.out.println("last count i454 check query ::"+str_query);
		log.write("DBMessage.java", "getLastcount454Data()", " Get lastCount 454 Query :: "+str_query, 9);

		return str_query;
		
	}

	public String DeleteI453Data(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.DELETE_I453_QUERY);
		builder.append(decode_map.get("l1id"));
		
		str_query = builder.toString();
		System.out.println("delete i453 data query ::"+str_query);
		log.write("DBMessage.java", "DeleteI453Data()", " Delete i453 Data Query :: "+str_query, 9);

		return str_query;
	}

	public String DeleteI454Data(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.DELETE_I454_QUERY);
		builder.append(decode_map.get("wbsid"));
		
		str_query = builder.toString();
		System.out.println("delete i454 data query ::"+str_query);
		log.write("DBMessage.java", "DeleteI454Data()", " Delete i454 Query :: "+str_query, 9);

		return str_query;
	}

	public String DeleteManagerData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.MANAGER_REMOVE_QUERY);
		builder.append(decode_map.get("wbsid"));
		builder.append(" and active = 1");
		builder.append(" and pmpamid = '");
		builder.append(decode_map.get("pmid"));
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("delete Manager data query ::"+str_query);
		log.write("DBMessage.java", "DeleteManagerData()", " Manager Remove Query :: "+str_query, 9);

		return str_query;
		
	}
	
	public String getProjectDetails_Data() {

		String str_query = null;
		
		StringBuilder builder = new StringBuilder(DBQuery.GET_PROJECT_DETAILS_QUERY);
		
		str_query = builder.toString();
		System.out.println("getProjectDetailsQuery : "+str_query);
		log.write("DBMessage.java", "getProjectDetails_Data()", " Get Project Details Query :: "+str_query, 9);

		return str_query;
	}

	public String ExtendedProjectDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_EXTENDED_PROJECTDATE_QUERY);
		builder.append(decode_map.get("enddate"));
		builder.append("' where wbsid  = ");
		builder.append(decode_map.get("wbsid"));
		builder.append(" and active = 1 ");
		
		str_query = builder.toString();
		System.out.println("Extend project date query :: "+str_query);
		log.write("DBMessage.java", "ExtendedProjectDetails()", " Set Extended ProjectDate Query :: "+str_query, 9);

		return str_query;
	}
	
	public String ExtendedProjectAuthDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_EXTENDED_PROJECTAUTHDATE_QUERY);
		builder.append(decode_map.get("enddate"));
		builder.append("' where wbsid  = ");
		builder.append(decode_map.get("wbsid"));
		builder.append(" and active = 1 ");
		
		str_query = builder.toString();
		System.out.println("Extend project auth date query :: "+str_query);
		log.write("DBMessage.java", "ExtendedProjectAuthDetails()", " Set Extended Project auth Date Query :: "+str_query, 9);

		return str_query;
	}

	public String getManagerData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_MANAGER_DETAILS_QUERY);
		builder.append(decode_map.get("wbsid"));
		
		str_query = builder.toString();
		System.out.println("get Manager data query :: "+str_query);
		log.write("DBMessage.java", "getManagerData()", "get Manager data query :: "+str_query, 9);

		return str_query;
	}

	public String getActivityL1Details() {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_ACTIVITYL1_DATA_QUERY);
		
		str_query = builder.toString();
		System.out.println("get activityL1 data query :: "+str_query);
		log.write("DBMessage.java", "getManagerData()", "get activityL1 data query :: "+str_query, 9);

		return str_query;
	}

	public String getActivityL2Details(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_ACTIVITYL2_DATA_QUERY);
		builder.append(decode_map.get("actl1id"));
		
		str_query = builder.toString();
		System.out.println("get ActivityL2 data query :: "+str_query);
		log.write("DBMessage.java", "getActivityL2Details()", "get ActivityL2 data query :: "+str_query, 9);

		return str_query;

	}

	public String getLastCountI455(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.LAST_COUNT_I455_QUERY);
		builder.append(decode_map.get("empid"));
		builder.append("' and emptype = '");
		builder.append(decode_map.get("emptype"));
		builder.append("' and '");
		builder.append(decode_map.get("startdate"));
		builder.append("' between startdate and enddate  and active = 1 and actl1 = '");
		builder.append(decode_map.get("actL1"));
		builder.append("' and actl2 = '");
		builder.append(decode_map.get("actL2"));
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("last count i455 data query :: "+str_query);
		log.write("DBMessage.java", "getLastCountI455()", "last count i455 data query :: "+str_query, 9);

		return str_query;
	}

	public String SetSkillMatrixDetails(HashMap<String, String> decode_map) {
		
			String str_query = null;
			
			StringBuilder builder = new StringBuilder(DBQuery.INSERT_SKILLMATRIX_QUERY);
			builder.append(decode_map.get("empid"));
			builder.append("','");
			builder.append(decode_map.get("empname"));
			builder.append("','");
			builder.append(decode_map.get("emptype"));
			builder.append("','");
			builder.append(decode_map.get("actL1"));
			builder.append("','");
			builder.append(decode_map.get("actL2"));
			builder.append("',");
			builder.append(decode_map.get("skilllevel"));
			builder.append(",'");
			builder.append(decode_map.get("costcurrency"));
			builder.append("','");
			builder.append(decode_map.get("costunit"));
			builder.append("',");
			builder.append(decode_map.get("costvalue"));
			builder.append(",'");
			builder.append(decode_map.get("startdate"));
			builder.append("','");
			builder.append(decode_map.get("enddate"));
			builder.append("',1)");
			
			
			 str_query = builder.toString();
			System.out.println("Set Skill Matrix Query : "+str_query);
			log.write("DBMessage.java", "SetSkillMatrixDetails()", " Set SetSkillMatrixDetails Query :: "+str_query, 9);

			return str_query;
		}

	public String DeleteSkillMatrixDetails(HashMap<String, String> decode_map) {
		
			String str_query = null;
			StringBuilder builder = new StringBuilder(DBQuery.DELETE_SKILLMATRIX_QUERY);
			builder.append(decode_map.get("sn"));
			
			str_query = builder.toString();
			System.out.println("Delete Skill Matrix Query : "+str_query);
			log.write("DBMessage.java", "DeleteSkillMatrixDetails()", " Set DeleteSkillMatrixDetails Query :: "+str_query, 9);

			return str_query;
		}

	public String GetSkillMatrixDetails() {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_SKILLMATRIX_QUERY);
		
		
		 str_query= builder.toString();
		 System.out.println("Get Skill Matrix Query : "+str_query);
			log.write("DBMessage.java", "GetSkillMatrixDetails()", "  GetSkillMatrixDetails Query :: "+str_query, 9);

		return str_query;
	}
	

	public String getL2LastCountQuery(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_L2L3_LAST_COUNT_QUERY);
		builder.append(" wbstype ='");
		builder.append("L2Type");
		builder.append("' and l1type ='");
		builder.append(decode_map.get("l1type"));
		builder.append("' and l1id =");
		builder.append(decode_map.get("l1id"));
		builder.append(" and l1name ='");
		builder.append(decode_map.get("l1name"));
//		builder.append("' and l2type ='");
//		builder.append(decode_map.get("l2type"));
		builder.append("' and l2name ='");
		builder.append(decode_map.get("l2name"));
		builder.append("' and '");
		builder.append(decode_map.get("startdate"));
		builder.append("' between startdate and enddate  and active = 1 ");
		str_query =builder.toString();
		System.out.println(" L2 last Count Query : "+str_query);
		log.write("DBMessage.java", "getL2LastCountQuery()", "  getL2LastCountQuery Query :: "+str_query, 9);

		return str_query;
	}

	public String getL2Data(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_L2_DATA_QUERY);
		builder.append(decode_map.get("l1id"));
		builder.append(" and wbstype='L2Type' and l2id in (select l2id from i453wbsmaster where l1id = ");
		builder.append(decode_map.get("l1id"));
		builder.append(") order by wbsid desc ");
		
		str_query = builder.toString();
		System.out.println("get L2 Data Query : "+str_query);
		log.write("DBMessage.java", "getL2Data()", "  getL2Data Query :: "+str_query, 9);

		return str_query;
	}
	
	public String getL3LastCountQuery(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_L2L3_LAST_COUNT_QUERY);
		builder.append(" wbstype ='");
		builder.append("L3Type");
		builder.append("' and l1type ='");
		builder.append(decode_map.get("l1type"));
		builder.append("' and l1id =");
		builder.append(decode_map.get("l1id"));
		builder.append(" and l1name ='");
		builder.append(decode_map.get("l1name"));
		builder.append("' and l2type ='");
		builder.append(decode_map.get("l2type"));
		builder.append("' and l2name ='");
		builder.append(decode_map.get("l2name"));
		builder.append("' and l3type ='");
		builder.append(decode_map.get("l3type"));
		builder.append("' and l3name ='");
		builder.append(decode_map.get("l3name"));
		builder.append("' and '");
		builder.append(decode_map.get("startdate"));
		builder.append("' between startdate and enddate  and active = 1 ");
		str_query =builder.toString();
		System.out.println(" L3 last Count Query : "+str_query);
		log.write("DBMessage.java", "getL3LastCountQuery()", "  getL3LastCountQuery Query :: "+str_query, 9);

		return str_query;
	}

	public String getL3Data(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_L3_DATA_QUERY);
		builder.append(decode_map.get("l1name"));
		builder.append("' and l2name = '");
		builder.append(decode_map.get("l2name"));
		builder.append("' and typeofentry = 'L2PAM' limit 1 )from i453wbsmaster A left join i456delimaster B ON A.wbsid = B.wbsid and A.wbstype = 'L3Type' ");
		builder.append(" and active = 1 where A.l3id is not null and A.l1name = '");
		builder.append(decode_map.get("l1name"));
		builder.append("' and l2name = '");
		builder.append(decode_map.get("l2name"));
		builder.append("'");
		str_query = builder.toString();
		 
		 System.out.println("Get L3 Data Query : "+str_query);
		 log.write("DBMessage.java", "getL3Data()", "  getL3Data Query :: "+str_query, 9);
	 
		return str_query;
	}
	
	public String setL2Data(HashMap<String, String> decode_map, long recordNumber) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_L2_DATA_Query);
		builder.append("0");
		builder.append(",'");
		builder.append("L2Type");
		builder.append("','");
		builder.append(decode_map.get("l1type"));
		builder.append("',");
		builder.append(decode_map.get("l1id"));
		builder.append(",'");
		builder.append(decode_map.get("l1name"));
		builder.append("','");
		builder.append(decode_map.get("l2type"));
		builder.append("',");
		builder.append(recordNumber);
		builder.append(",'");
		builder.append(decode_map.get("l2name"));
		builder.append("','");
		builder.append(decode_map.get("startdate"));
		builder.append("','");
		builder.append(decode_map.get("enddate"));
		builder.append("',1");
		builder.append(")");

		str_query = builder.toString();
		System.out.println("Set L2 Data Query : "+str_query);
		log.write("DBMessage.java", "setL2Data()", "  setL2Data Query :: "+str_query, 9);

		return str_query;
	}

	public String setL3Data(HashMap<String, String> decode_map,long recordNumber,long recordNumber2) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_L3_DATA_QUERY);
		builder.append("0");
		builder.append(",'");
		builder.append("L3Type");
		builder.append("','");
		builder.append(decode_map.get("l1type"));
		builder.append("',");
		builder.append(decode_map.get("l1id"));
		builder.append(",'");
		builder.append(decode_map.get("l1name"));
		builder.append("','");
		builder.append(decode_map.get("l2type"));
		builder.append("',");
		
		if(recordNumber == 0) {
			builder.append(decode_map.get("l2id"));
		}else {
			builder.append(recordNumber);
		}
		builder.append(",'");
		builder.append(decode_map.get("l2name"));
		builder.append("','");
		builder.append(decode_map.get("l3type"));
		builder.append("',");
		builder.append(recordNumber2);
		builder.append(",'");
		builder.append(decode_map.get("l3name"));
		builder.append("','");
		builder.append(decode_map.get("startdate"));
		builder.append("','");
		builder.append(decode_map.get("enddate"));
		builder.append("',1");
		builder.append(")");
		str_query = builder.toString();
		System.out.println("Set L3 Data Query : "+str_query);
		log.write("DBMessage.java", "setL3Data()", "  setL3Data Query :: "+str_query, 9);

		return str_query;
	
	}

	public String getLastCountI454Auth(HashMap<String, String> decode_map) {

		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_LAST_COUNT_WBSAUTH_QUERY);
		builder.append("  wbsid=");
		builder.append(decode_map.get("wbsid"));
		builder.append(" and typeofentry ='L2PM'");
		builder.append(" and pmpamid = '");
		builder.append(decode_map.get("pmpamid"));
		builder.append("' and pmpamname = '");
		builder.append(decode_map.get("pmpamname"));
		builder.append("' and '");
		builder.append(decode_map.get("startdate"));
		builder.append("' between startdate and enddate  and active = 1 ");
		str_query = builder.toString();
		System.out.println(" get getLastCountI454Auth Query : "+str_query);
		log.write("DBMessage.java", "getLastCountI454Auth()", "  getLastCountI454Auth Query :: "+str_query, 9);

		return str_query;
	}

	public String setWBSAuthData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_MANAGER_NAME_QUERY);
		builder.append(decode_map.get("wbsid"));
		builder.append(",'");
		builder.append("L2PM");
		builder.append("','");
		builder.append(decode_map.get("pmpamid"));		
		builder.append("','");
		builder.append(decode_map.get("pmpamname"));
		builder.append("','");
		builder.append(decode_map.get("startdate"));
		builder.append("','");
		builder.append(decode_map.get("enddate"));
		builder.append("',1)");
		str_query = builder.toString();
		System.out.println(" setWBSAuthData Query : "+str_query);
		log.write("DBMessage.java", "setWBSAuthData()", "  setWBSAuthData Query :: "+str_query, 9);

		return str_query;
	}

	
	public String getPMGridDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PMGRID_QUERY);
		builder.append(decode_map.get("pmpamid"));
		builder.append("' and wbstype = 'L1Type' and l2id is null and l3id is null and A.wbsid = B.wbsid and B.typeofentry = 'L1PM'");
		
		if(!decode_map.get("status").equals("null")) {
			builder.append(" and A.active = ");
			builder.append(decode_map.get("status"));
			builder.append(" and B.active = ");
			builder.append(decode_map.get("status"));
		}
		
		if(!decode_map.get("end_date").equals("null")) {
			builder.append(" and '");
			builder.append(decode_map.get("end_date"));
			builder.append("' between B.startdate and B.enddate ");
		}
		
//		if(!decode_map.get("start_date").equals("null")) {
//			builder.append(" and '");
//			builder.append(decode_map.get("start_date"));
//			builder.append("' between B.startdate and B.enddate ");
//		}
		
		
		str_query = builder.toString();
		System.out.println("get pmgrid query ::" + str_query);
		
		log.write("DBMessage.java", "getPMGridDetails()", "get pmgrid query :: "+str_query, 9);
		return str_query;
	}

	public String getLastCountI454PAMData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_LASTCOUNT_454_QUERY);
		builder.append(decode_map.get("wbsid"));
		builder.append(" and typeofentry = 'L2PAM'");
		builder.append(" and pmpamid = '");
		builder.append(decode_map.get("pmpamid"));
		builder.append("' and pmpamname = '");
		builder.append(decode_map.get("pmpamname"));
		builder.append("' and '");
		builder.append(decode_map.get("startdate"));
		builder.append("' between startdate and enddate");
		builder.append(" and active = 1");
		
		str_query = builder.toString();
		System.out.println("lastcount i454 PAM query ::" + str_query);
		
		log.write("DBMessage.java", "getLastCountI454PAMData()", "lastcount i454 PAM query :: "+str_query, 9);
		return str_query;
		
	}

	public String setPAMDetailsData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_ACTIVITYMANAGER_NAME_QUERY);
		builder.append(decode_map.get("wbsid"));
		builder.append(",'");
		builder.append("L2PAM");
		builder.append("','");
		builder.append(decode_map.get("pmpamid"));		
		builder.append("','");
		builder.append(decode_map.get("pmpamname"));
		builder.append("',");
		builder.append(decode_map.get("actl1id"));
		builder.append(",'");
		builder.append(decode_map.get("startdate"));
		builder.append("','");
		builder.append(decode_map.get("enddate"));
		builder.append("',1)");
		str_query = builder.toString();
		System.out.println("set WBSPAM Data Query :: "+str_query);
		log.write("DBMessage.java", "setPAMDetailsData()", "set WBSPAM Data Query :: "+str_query, 9);

		return str_query;

	}

	public String getLastCountI456DeliveryData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.LAST_COUNT_I456_QUERY);
		builder.append(decode_map.get("deliverablename"));
		builder.append("' and wbsid = ");
		builder.append(decode_map.get("wbsid"));
		builder.append(" and wbsauthid = ");
		builder.append(decode_map.get("wbsauthid"));
		builder.append(" and deltype = '");
		builder.append(decode_map.get("l1type"));
		builder.append("' and delstatus = '");
		builder.append(decode_map.get("deliverablestatus"));
		builder.append("' and expstartdate = '");
		builder.append(decode_map.get("expectedstartdate"));
		builder.append("' and expreleasedate = '");
		builder.append(decode_map.get("expectedreleasedate"));
		builder.append("' ");
		
		str_query = builder.toString();
		System.out.println("lastcount i456 count Query :: "+str_query);
		log.write("DBMessage.java", "getLastCountI456DeliveryData()", "lastcount i456 count Query :: "+str_query, 9);

		return str_query;

		
	}

	public String setI456DeliveryMasterData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_DELIVERABLE_I456_QUERY);
		builder.append(decode_map.get("deliverablename"));
		builder.append("','");
		builder.append(decode_map.get("pmid"));
		builder.append("',");
		builder.append(decode_map.get("wbsid"));
		builder.append(" , ");
		builder.append(decode_map.get("wbsauthid"));
		builder.append(",");
		builder.append("CURRENT_DATE");
		builder.append(",'");
		builder.append(decode_map.get("l1type"));
		builder.append("','");
		builder.append(decode_map.get("expectedstartdate"));
		builder.append("','");
		builder.append(decode_map.get("expectedreleasedate"));
		builder.append("','");
		builder.append(decode_map.get("deliverablestatus"));
		builder.append("')");
		
		str_query = builder.toString();
		System.out.println("set i456 deliverable Query :: "+str_query);
		log.write("DBMessage.java", "setI456DeliveryMasterData()", "set i456 deliverable Query :: "+str_query, 9);

		return str_query;
	}
	
	public String setdelHistoryi457Data(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_DELIVERABLEHISTORY_I457_QUERY);
		builder.append("(select delid from i456delimaster where delname = '");
		builder.append(decode_map.get("deliverablename"));
		builder.append("' and delcreateid = '");
		builder.append(decode_map.get("pmid"));
		builder.append("'),null,'");
		builder.append(decode_map.get("deliverablestatus"));
		builder.append("','null',CURRENT_DATE)");
		
		str_query = builder.toString();
		System.out.println("set i457 deliverable history Query :: "+str_query);
		log.write("DBMessage.java", "setdelHistoryi457Data()", "set i457 deliverable history Query :: "+str_query, 9);

		return str_query;
	}
		
	
	public String getDelliverableGridData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_DELIVERABLE_GRID_QUERY);
		builder.append(decode_map.get("pmpamid"));
		builder.append("' and A.typeofentry = 'L1PM' and A.wbsid = B.wbsid and B.l1id = ");
		builder.append(decode_map.get("l1id"));
		builder.append(" ) left outer join i458delassi D ON A.delid = D.delid left outer join i451activitymatrix E ON E.actl1id = D.actl1id where C.pmpamid = '");
		builder.append(decode_map.get("pmpamid"));
		builder.append("' and C.typeofentry = 'L1PM' and B.l1id = ");
		builder.append(decode_map.get("l1id"));
		
		
		
		if(!decode_map.get("status").equals("null")) {
			if(decode_map.get("status").equals("Assigned")) {
				builder.append(" and A.delstatus in ('Assigned','WIP','Completed','Released','Stage Completion Request') ");
			}else {
				builder.append(" and A.delstatus in ('Draft','OnHold') ");
			}
		}	
		
		if(!decode_map.get("pamid").equals("null")) {
			builder.append(" and D.pamid = '");
			builder.append(decode_map.get("pamid"));
			builder.append("'");
		}
		
		if(!decode_map.get("pduid").equals("null")) {
			builder.append(" and D.pduid = '");
			builder.append(decode_map.get("pduid"));
			builder.append("'");
		}
		
		builder.append(" order by A.delid ");
		
		str_query = builder.toString();
		System.out.println("get Delliverable GridData Query :: "+str_query);
		log.write("DBMessage.java", "getDelliverableGridData()", "get Delliverable GridData Query :: "+str_query, 9);

		return str_query;
	}

	public String getModuleGridDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PMGRID_QUERY);
		builder.append(decode_map.get("pmpamid"));
		builder.append("' and wbstype = 'L2Type' and l3id is null and l1id = ");
		builder.append(decode_map.get("l1id"));
		builder.append(" and B.wbsid = ");
		builder.append(decode_map.get("wbsid"));
		
		str_query = builder.toString();
		System.out.println("get pmodulegrid query ::" + str_query);
		
		log.write("DBMessage.java", "getModuleGridDetails()", "get pmodulegrid query :: "+str_query, 9);
		return str_query;
		
		
	}

	public String getComponentGridDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PMGRID_QUERY);
		builder.append(decode_map.get("pmpamid"));
		builder.append("' and wbstype = 'L3Type' and l1id = ");
		builder.append(decode_map.get("l1id"));
		builder.append(" and l2id = ");
		builder.append(decode_map.get("l2id"));
		builder.append(" and B.wbsid = ");
		builder.append(decode_map.get("wbsid"));
		
		str_query = builder.toString();
		System.out.println("get pm component query ::" + str_query);
		
		log.write("DBMessage.java", "getComponentGridDetails()", "get pm Component grid query :: "+str_query, 9);
		return str_query;
	}

	public String getPAMPDUDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PAMPDUDATA_QUERY);
		builder.append(decode_map.get("type"));
		builder.append("' and actl1 = '");
		builder.append(decode_map.get("activityl1"));
		builder.append("'");
		
		
		str_query = builder.toString();
		System.out.println("get PAM PDU data query::" + str_query);
		
		log.write("DBMessage.java", "getComponentGridDetails()", "get PAM PDU data query:: "+str_query, 9);
		return str_query;
	}

	public String getLastCountI458DeliveryAssignData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_LASTCOUNT_I458_QUERY);
		builder.append(decode_map.get("pduid"));
		builder.append("' and actl1id = ");
		builder.append(decode_map.get("actl1id"));
		builder.append(" and wbsid = ");
		builder.append(decode_map.get("wbsid"));
		builder.append(" and CURRENT_DATE between planstartdate and planenddate ");
		
		str_query = builder.toString();
		System.out.println("get lastcount i458 data query::" + str_query);
		
		log.write("DBMessage.java", "getLastCountI458DeliveryAssignData()", "get lastcount i458 data query:: "+str_query, 9);
		return str_query;
	}

	public String setI458DeliveryAssignData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_DELIVERY_ASSIGN_I458_QUERY);
		builder.append(decode_map.get("delid"));
		builder.append(",");
		builder.append(decode_map.get("wbsid"));
		builder.append(",CURRENT_DATE,");
		builder.append(decode_map.get("l1id"));
		builder.append(",'");
		builder.append(decode_map.get("l1name"));
		builder.append("',");
		builder.append(decode_map.get("l2id"));
		builder.append(",'");
		builder.append(decode_map.get("l2name"));
		builder.append("',");
		builder.append(decode_map.get("l3id"));
		builder.append(",'");
		builder.append(decode_map.get("l3name"));
		builder.append("','");
		builder.append(decode_map.get("assignstatus"));
		builder.append("','");
		builder.append(decode_map.get("pamid"));
		builder.append("','");
		builder.append(decode_map.get("pamname"));
		builder.append("','");
		builder.append(decode_map.get("pduid"));
		builder.append("','");
		builder.append(decode_map.get("pduname"));
		builder.append("',");
		builder.append(decode_map.get("actl1id"));
		builder.append(",'");
		builder.append(decode_map.get("planstartdate"));
		builder.append("','");
		builder.append(decode_map.get("planenddate"));
		builder.append("','");
		builder.append(decode_map.get("planhours"));
		builder.append("')");
		
		str_query = builder.toString();
		System.out.println("set i458 deliverable assign data query::" + str_query);
		log.write("DBMessage.java", "setI458DeliveryAssignData()", "set i458 deliverable assign data query:: "+str_query, 9);
		return str_query;
	}
	
	public String setdelAssignHistoryi457Data(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_DELIVERABLEHISTORY_I457_QUERY);
		builder.append(decode_map.get("delid"));
		builder.append(",(select delassid from i458delassi where delid = ");
		builder.append(decode_map.get("delid"));
		builder.append(" and wbsid = ");
		builder.append(decode_map.get("wbsid"));
		builder.append("),'");
		builder.append(decode_map.get("deliverablestatus"));
		builder.append("','");
		builder.append(decode_map.get("assignstatus"));
		builder.append("',CURRENT_DATE)");
		
		str_query = builder.toString();
		System.out.println("set i457 deliverable Assign history Query :: "+str_query);
		log.write("DBMessage.java", "setdelAssignHistoryi457Data()", "set i457 deliverable Assign history Query :: "+str_query, 9);

		return str_query;
	}

	
	public String setdeliverableHistoryi457Data(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_DELIVERABLEHISTORY_I457_QUERY);
		builder.append(decode_map.get("delid"));
		builder.append(",");
		builder.append(decode_map.get("delassignid"));
		builder.append(",'");
		builder.append(decode_map.get("deliverablestatus"));
		builder.append("','");
		builder.append(decode_map.get("assignstatus"));
		builder.append("',CURRENT_DATE)");
		
		str_query = builder.toString();
		System.out.println("set i457 deliverable for PDU history Query :: "+str_query);
		log.write("DBMessage.java", "setdeliverableHistoryi457Data()", "set i457 deliverable for PDU history Query :: "+str_query, 9);

		return str_query;
	}
	
	public String setdeliverablePAMApprovedi457Data(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_DELIVERABLEHISTORY_I457_QUERY);
		builder.append(decode_map.get("delid"));
		builder.append(",");
		builder.append(decode_map.get("delassignid"));
		if(decode_map.get("approvalentrystatus").equals("Approve")) {
			builder.append(",'Activity Completed','Activity Completed'");
		}else {
			builder.append(",'Assign WIP','Activity Completed Request'");
		}
		
		
		builder.append(",CURRENT_DATE)");
		
		str_query = builder.toString();
		System.out.println("set i457 deliverable for PAM Approved Query :: "+str_query);
		log.write("DBMessage.java", "setdeliverablePAMApprovedi457Data()", "set i457 deliverable for PAM Approved Query :: "+str_query, 9);

		return str_query;
	}
	
	public String setdeliverableActivityCompleteRequesti457Data(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_DELIVERABLEHISTORY_I457_QUERY);
		builder.append(decode_map.get("delid"));
		builder.append(",");
		builder.append(decode_map.get("delassignid"));
		builder.append(",'Assign WIP','Activity Completed Request'");
		builder.append(",CURRENT_DATE)");
		
		str_query = builder.toString();
		System.out.println("set i457 deliverable Activity Complete Request Query :: "+str_query);
		log.write("DBMessage.java", "setdeliverableActivityCompleteRequesti457Data()", "set i457 deliverable Activity Complete Request Query :: "+str_query, 9);

		return str_query;
	}


	public String UpdateI456Activity(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_I456ACTIVITY_QUERY);
		builder.append(" curassignactl1id = ");
		builder.append(decode_map.get("actl1id"));
		builder.append(" , delstatus = 'Assigned'");
		builder.append(" where delid = ");
		builder.append(decode_map.get("delid"));
		
		str_query = builder.toString();
		System.out.println("update activityl1 data query::" + str_query);
		
		log.write("DBMessage.java", "UpdateI456Activity()", "update activityl1 data query:: "+str_query, 9);
		return str_query;
	}

	public String selectactivityL1data(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SELECT_ACTIVITYL1_UPDATE_QUERY);
		builder.append(decode_map.get("delid"));
		
		str_query = builder.toString();
		System.out.println("select activityl1 for update query::" + str_query);
		
		log.write("DBMessage.java", "selectactivityL1data()", "select activityl1 for update query:: "+str_query, 9);
		return str_query;
	}

	public String UpdateActivityl1id(HashMap<String, String> decode_map,int actidl1) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_ACTIVITYL1ID_QUERY);
		builder.append(actidl1);
		builder.append(" where delid = ");
		builder.append(decode_map.get("delid"));
		
		str_query = builder.toString();
		System.out.println("update activityl1id query::" + str_query);
		
		log.write("DBMessage.java", "UpdateActivityl1id()", "update activityl1id query:: "+str_query, 9);
		return str_query;
	}

	public String getPDUGridDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PDU_GRID_QUERY);
		builder.append(decode_map.get("pduid"));
		builder.append("'");
		
		if(decode_map.get("status").equals("Active")) {
			builder.append("CURRENT_DATE between planstartdate and planenddate and A.assignstatus = '");
			builder.append(decode_map.get("status"));
			builder.append("'");
		}
		
		if(decode_map.get("status").equals("Completed")) {
			builder.append(" and A.assignstatus = '");
			builder.append(decode_map.get("status"));
			builder.append("'");
		}
		
		if(!decode_map.get("l1id").equals("null")) {
			builder.append(" and A.l1id = ");
			builder.append(decode_map.get("l1id"));
		}
		
		str_query = builder.toString();
		System.out.println("get PDU Grid Details query::" + str_query);
		
		log.write("DBMessage.java", "getPDUGridDetails()", "get PDU Grid Details query:: "+str_query, 9);
		return str_query;
	}

	public String getLastCountI459PDUActivityData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.LAST_COUNT_I459_QUERY);
		builder.append(decode_map.get("pduid"));
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("get lastcount PDU query::" + str_query);
		
		log.write("DBMessage.java", "getPDUGridDetails()", "get lastcount PDU query:: "+str_query, 9);
		return str_query;
	}

	public String LastTimeCheckcount(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.LAST_TIME_I459_QUERY);
		builder.append(decode_map.get("starttime"));
		builder.append("' between starttime and endtime and pduid = '");
		builder.append(decode_map.get("pduid"));
		builder.append("' and actl1id = ");
		builder.append(decode_map.get("actl1id"));
		
		str_query = builder.toString();
		System.out.println("get last time PDU query::" + str_query);
		
		log.write("DBMessage.java", "LastTimeCheckcount()", "get last time PDU query:: "+str_query, 9);
		return str_query;
	}
	
	public String LastTimeCheckUnplannedcount(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.LAST_TIME_I459_QUERY);
		builder.append(decode_map.get("starttime"));
		builder.append("' between starttime and endtime and pduid = '");
		builder.append(decode_map.get("pduid"));
		builder.append("' ");
		
		str_query = builder.toString();
		System.out.println("get last time unplanned PDU query::" + str_query);
		
		log.write("DBMessage.java", "LastTimeCheckUnplannedcount()", "get last time unplanned PDU query:: "+str_query, 9);
		return str_query;
	}

	public String setI459PDUActivityData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.INSERT_I459_PDU_QUERY);
		builder.append(decode_map.get("delid"));
		builder.append(",");
		builder.append(decode_map.get("delassignid"));
		builder.append(",'");
		builder.append(decode_map.get("location"));
		builder.append("','");
		builder.append(decode_map.get("pamid"));
		builder.append("','");
		builder.append(decode_map.get("pamname"));
		builder.append("','");
		builder.append(decode_map.get("pduid"));
		builder.append("','");
		builder.append(decode_map.get("pduname"));
		builder.append("',");
		builder.append(decode_map.get("actl1id"));
		builder.append(",'");
		builder.append(decode_map.get("actl1name"));
		builder.append("',");
		builder.append(decode_map.get("actl2id"));
		builder.append(",'");
		builder.append(decode_map.get("actl2name"));
		builder.append("','");
		builder.append(decode_map.get("startdate"));
		builder.append("','");
		builder.append(decode_map.get("starttime"));
		builder.append("','");
		builder.append("Draft");
		builder.append("')");
		
		str_query = builder.toString();
		System.out.println("insert activity PDU query::" + str_query);
		
		log.write("DBMessage.java", "setI459PDUActivityData()", "insert activity PDU query:: "+str_query, 9);
		return str_query;
	}

	public String getActivityGridDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_ACTIVITY_GRID_QUERY);
		builder.append(decode_map.get("pduid"));
		builder.append("' and activitylocation is not null and delid = ");
		builder.append(decode_map.get("delid"));
		
		if(!decode_map.get("status").equals("null")) {
			if(decode_map.get("status").equals("Logged")) {
					builder.append(" and taskstatus = '");
					builder.append(decode_map.get("status"));
					builder.append("'");
				}else {
					builder.append(" and approvedentrystatus = '");
					builder.append(decode_map.get("status"));
					builder.append("'");
				}
		}
		
		
		str_query = builder.toString();
		System.out.println("get activity grid query::" + str_query);
		
		log.write("DBMessage.java", "getActivityGridDetails()", "get activity grid query:: "+str_query, 9);
		return str_query;
	}

	public String getLastCountI460DelWIData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.LAST_COUNT_I460_QUERY);
		builder.append(decode_map.get("pduid"));
		builder.append("' and curdate = ");
		builder.append("CURRENT_DATE");
		builder.append(" and delwitype = '");
		builder.append(decode_map.get("deltype"));
		builder.append("' and delwiaction = '");
		builder.append(decode_map.get("wiaction"));
		builder.append("' and delwiname = '");
		builder.append(decode_map.get("winame"));
		builder.append("' and delwiversion = '");
		builder.append(decode_map.get("version"));
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("last count i460 wi query::" + str_query);
		
		log.write("DBMessage.java", "getLastCountI460DelWIData()", "last count i460 wi query:: "+str_query, 9);
		return str_query;
	}

	public String setI460DelWIData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.INSERT_I460_WI_QUERY);
		builder.append(decode_map.get("pduid"));
		builder.append("', ");
		builder.append(decode_map.get("taskentryid"));
		builder.append(",");
		builder.append("CURRENT_DATE");
		builder.append(",'");
		builder.append(decode_map.get("deltype"));
		builder.append("' , '");
		builder.append(decode_map.get("wiaction"));
		builder.append("','");
		builder.append(decode_map.get("winame"));
		builder.append("' ,'");
		builder.append(decode_map.get("version"));
		builder.append("')");
		str_query = builder.toString();
		System.out.println("insert i460 work item query::" + str_query);
		
		log.write("DBMessage.java", "setI460DelWIData()", "insert i460 work item query:: "+str_query, 9);
		return str_query;
	}

	public String getWorkitemGridDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_WORKITEM_GRID_QUERY);
		builder.append(decode_map.get("pduid"));
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("get work item query::" + str_query);
		
		log.write("DBMessage.java", "getWorkitemGridDetails()", "get work item query:: "+str_query, 9);
		return str_query;
	}

	public String UpdateEndtimeData(HashMap<String, String> decode_map,int emin) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_ENDTIME_QUERY);
		builder.append(decode_map.get("endtime"));
		builder.append("' , taskstatus = '");
		builder.append(decode_map.get("taskstatus"));
		builder.append("' , minuteslogged = ");
		builder.append(emin);
		builder.append(" where pduid = '");
		builder.append(decode_map.get("pduid"));
		builder.append("' and endtime is null and taskentryid = ");
		builder.append(decode_map.get("taskentryid"));
		
		
		str_query = builder.toString();
		System.out.println("update endtime query::" + str_query);
		
		log.write("DBMessage.java", "UpdateEndtimeData()", "update endtime query:: "+str_query, 9);
		return str_query;
	}

	public String getWITypeDetails() {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_WORKITEM_TYPE_QUERY);
		
		str_query = builder.toString();
		System.out.println("get WIType Details query::" + str_query);
		
		log.write("DBMessage.java", "getWITypeDetails()", "get WIType Details query:: "+str_query, 9);
		return str_query;
	}

	public String SelectEminlogQuery(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SELECT_EMINLOG_QUERY);
		builder.append("((DATE_PART('Hour', '");
		builder.append(decode_map.get("startdate"));
		builder.append(" ");
		builder.append(decode_map.get("endtime"));
		builder.append(":00'::TIMESTAMP - '");
		builder.append(decode_map.get("startdate"));
		builder.append(" ");
		builder.append(decode_map.get("starttime"));
		builder.append("'::TIMESTAMP)) * 60 + DATE_PART('Minute', '");
		builder.append(decode_map.get("startdate"));
		builder.append(" ");
		builder.append(decode_map.get("endtime"));
		builder.append(":00'::TIMESTAMP - '");
		builder.append(decode_map.get("startdate"));
		builder.append(" ");
		builder.append(decode_map.get("starttime"));
		builder.append("'::TIMESTAMP));");
		
		str_query = builder.toString();
		System.out.println("Eminlog query ::" + str_query);
		log.write("DBMessage.java", "SelectEminlogQuery()", "Eminlog query ::"+str_query, 9);
		return str_query;
	}

	public String SelectEminlogUnplannedQuery(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SELECT_EMINLOG_QUERY);
		builder.append(" endtime - starttime AS difference FROM i459pduactivity");
		builder.append(" where taskentryid = (select taskentryid from i459pduactivity where starttime = '");
		builder.append(decode_map.get("starttime"));
		builder.append("' and endtime = '");
		builder.append(decode_map.get("endtime"));
		builder.append("' )");
//		builder.append(decode_map.get("endtime"));
//		builder.append(":00'::TIMESTAMP - '");
//		builder.append(decode_map.get("starttime"));
//		builder.append("'::TIMESTAMP)) * 60 + DATE_PART('Minute', '");
//		builder.append(decode_map.get("endtime"));
//		builder.append(":00'::TIMESTAMP - '");
//		builder.append(decode_map.get("starttime"));
//		builder.append("'::TIMESTAMP));");
		
		str_query = builder.toString();
		System.out.println("Eminlog unplanned query ::" + str_query);
		log.write("DBMessage.java", "SelectEminlogUnplannedQuery()", "Eminlog unplanned query ::"+str_query, 9);
		return str_query;
	}
	
	public String UpdateEndDateData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_I458DATA_QUERY);
		builder.append(" recenddate = CURRENT_DATE , assignstatus = 'Activity completed Request'");
		builder.append(" where delid = ");
		builder.append(decode_map.get("delid"));
		
		str_query = builder.toString();
		System.out.println("Update EndDate Data query ::" + str_query);
		log.write("DBMessage.java", "UpdateEndDateData()", "Update EndDate Data query ::"+str_query, 9);
		return str_query;
	}
	
	public String UpdateApprovedStatusData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_I458DATA_QUERY);
		builder.append(" recenddate = CURRENT_DATE , assignstatus = 'Activity completed'");
		builder.append(" where delid = ");
		builder.append(decode_map.get("delid"));
		
		str_query = builder.toString();
		System.out.println("Update approved status Data query ::" + str_query);
		log.write("DBMessage.java", "UpdateApprovedStatusData()", "Update approved status Data query ::"+str_query, 9);
		return str_query;
	}

	public String SetAddDateQuery(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_I458DATA_QUERY);
		builder.append(" recstartdate = CURRENT_DATE");
		builder.append(" , assignstatus = 'Assign WIP'");
		builder.append(" where delid = ");
		builder.append(decode_map.get("delid"));
		
		str_query = builder.toString();
		System.out.println("Update startdate Data query ::" + str_query);
		log.write("DBMessage.java", "SetAddDateQuery()", "Update startDate Data query ::"+str_query, 9);
		return str_query;
	}

//	public String getProjectDetails(HashMap<String, String> decode_map) {
//		String str_query = null;
//		StringBuilder builder = new StringBuilder(DBQuery.GET_PROJECT_DATA_QUERY);
//		builder.append(decode_map.get("pmid"));
//		builder.append("'");
//		
//		str_query = builder.toString();
//		System.out.println("get Project Details query ::" + str_query);
//		log.write("DBMessage.java", "getProjectDetails()", "get Project Details query ::"+str_query, 9);
//		return str_query;
//	}

	public String UpdateStatusQuery(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_I456ACTIVITY_QUERY);
		builder.append(" delstatus = 'Assign WIP' where delid = ");
		builder.append(decode_map.get("delid"));
		
		str_query = builder.toString();
		System.out.println("update i456 status query ::" + str_query);
		log.write("DBMessage.java", "UpdateStatusQuery()", "Update i456 Status Query ::"+str_query, 9);
		return str_query;
		
	}

	public String UpdateStatusI456Query(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_I456ACTIVITY_QUERY);
		builder.append(" delstatus = ");
		
		if(decode_map.get("approvalentrystatus").equals("Approve")) {
			builder.append(" 'Activity Completd'");
		}else {
			builder.append(" 'Assign WIP'");
		}
		
		builder.append("  where delid = ");
		builder.append(decode_map.get("delid"));
		builder.append(" and wbsid = ");
		builder.append(decode_map.get("wbsid"));
		
		str_query = builder.toString();
		System.out.println("update i456(Stage completion request) status query ::" + str_query);
		log.write("DBMessage.java", "UpdateStatusI456Query()", "Update i456(Stage completion request) Status Query ::"+str_query, 9);
		return str_query;
	}

	public String AddedBugReportData(HashMap<String, String> decode_map, String typeL1Data,String observation_data) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.ADD_BUG_REPORT_QUERY);
		builder.append("1,");
		builder.append("'WBS L3',");
		builder.append(decode_map.get("wbsid"));
		builder.append(",");
		builder.append(decode_map.get("delid"));
		builder.append(",");
		builder.append("CURRENT_DATE");
		builder.append(",'Bug Report','");
		builder.append(decode_map.get("suggestionerror"));
		builder.append("','");
		builder.append(decode_map.get("priority"));
		builder.append("','");
		builder.append(typeL1Data);
		builder.append("','");
		builder.append(observation_data);
		builder.append("','");
		builder.append(decode_map.get("status"));
		builder.append("')");
		
		str_query = builder.toString();
		System.out.println("Add bug report data query ::" + str_query);
		log.write("DBMessage.java", "AddedBugReportData()", "Add bug report data Query ::"+str_query, 9);
		return str_query;
		
	}

	public String AddRecordTrackingDetails(HashMap<String, String> decode_map,String decode_data) {
	System.out.println("decode map ::" + decode_data);
		
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.ADD_BUG_TRACKING_QUERY);
		builder.append(decode_map.get("wbsid"));
		builder.append(",");
		builder.append(decode_map.get("delid"));
		builder.append(",'");
		builder.append(decode_map.get("pamid"));
		builder.append("',");
		builder.append("CURRENT_DATE");
		builder.append(",1,'");
		builder.append(decode_data);
		builder.append("','");
		builder.append(decode_map.get("plannedcomplitiondate"));
		builder.append("')");
		
		str_query = builder.toString();
		System.out.println("Add bug tracking data query ::" + str_query);
		log.write("DBMessage.java", "AddRecordTrackingDetails()", "Add bug tracking data Query ::"+str_query, 9);
		return str_query;
		
		
	}

	public String LastcountBugReport(HashMap<String, String> decode_map, String typeL1Data) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.LAST_COUNT_BUGREPORT_CHECK_QUERY);
		builder.append(decode_map.get("wbsid"));
		builder.append(" and delid = ");
		builder.append(decode_map.get("delid"));
		builder.append(" and wbsrecidjson = '");
		builder.append(typeL1Data);
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("last check bug report data query ::" + str_query);
		log.write("DBMessage.java", "LastcountBugReport()", "last check bug report data Query ::"+str_query, 9);
		return str_query;
	}

	public String UpdateBugReportQuery(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_BUGREPORT_DATE_QUERY);
		builder.append(decode_map.get("delid"));
		builder.append(" and wbsid = ");
		builder.append(decode_map.get("wbsid"));
		
		str_query = builder.toString();
		System.out.println("update receive date for bugreport query ::" + str_query);
		log.write("DBMessage.java", "UpdateBugReportQuery()", "update receive date for bugreport query::"+str_query, 9);
		return str_query;
	}

	public String UpdateBugReportJson(HashMap<String, String> decodeMap) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_BUGREPORT_JOSN_QUERY);
		builder.append(decodeMap.get("delid"));
		builder.append(" and wbsid = ");
		builder.append(decodeMap.get("wbsid"));
		builder.append("),wbspostjson = (select wbsprejson from i462wbsrectracking where delid = ");
		builder.append(decodeMap.get("delid"));
		builder.append(" and wbsid = ");
		builder.append(decodeMap.get("wbsid"));
		builder.append("and reportid = '");
		builder.append(decodeMap.get("pamid"));
		builder.append("'), wbsprejson = '");
		builder.append(decodeMap.replace("\"", "\\\""));
		builder.append("' where delid = ");
		builder.append(decodeMap.get("delid"));
		builder.append(" and wbsid = ");
		builder.append(decodeMap.get("wbsid"));
		
		str_query = builder.toString();
		System.out.println("update BugReportJson query ::" + str_query);
		log.write("DBMessage.java", "UpdateBugReportJson()", "update BugReportJson query::"+str_query, 9);
		return str_query;
		
	}

	public String getBugReportData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_BUGREPORTDATA_QUERY);
		builder.append(decode_map.get("delid"));
		
		str_query = builder.toString();
		System.out.println("get BugReport Data query ::" + str_query);
		log.write("DBMessage.java", "getBugReportData()", "get BugReport Data query::"+str_query, 9);
		return str_query;
	}

	public String setBugReportUserComments(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_BUG_USERCOMMENTS_QUERY);
		builder.append(decode_map.get("usercomment"));
		builder.append("',issuestatus = '");
		builder.append(decode_map.get("status"));
		builder.append("',plancompdate = CURRENT_DATE,reportdate = CURRENT_DATE where delid = ");
		builder.append(decode_map.get("delid"));
		builder.append(" and wbsid = ");
		builder.append(decode_map.get("wbsid"));
		builder.append(" and reportid = '");
		builder.append(decode_map.get("pamid"));
		builder.append("' and usercomments is null and issuestatus is null ");
		
		str_query = builder.toString();
		System.out.println("set BugReport UserComments query ::" + str_query);
		log.write("DBMessage.java", "setBugReportUserComments()", "set BugReport UserComments query::"+str_query, 9);
		return str_query;
	}

		
		public String UpdateEndtimeUnplanned(HashMap<String, String> decode_map) {
			String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_ENDTIME_QUERY);
		builder.append(decode_map.get("endtime"));
		builder.append("' , taskstatus = '");
		builder.append(decode_map.get("taskstatus"));
//		builder.append("' , minuteslogged = '");
//		builder.append(emin);
		builder.append("' where pduid = '");
		builder.append(decode_map.get("pduid"));
		builder.append("' and pamid = '");
		builder.append(decode_map.get("pamid"));
		builder.append("' and approvedby is null and taskentryid = ");
		builder.append(decode_map.get("taskentryid"));
		
		str_query = builder.toString();
		System.out.println("update EndtimeUnplanned query::" + str_query);
		
		log.write("DBMessage.java", "UpdateEndtimeUnplanned()", "update EndtimeUnplanned query:: "+str_query, 9);
		return str_query;
	}
	
	public String getPAMGridData(HashMap<String, String> decode_map) {

		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PAM_DATA_QUERY);
//		builder.append(" and C.approvedby is null and approvedentrystatus is null and endtime is not null and B.pamid = '");
		builder.append(" and B.pamid = '");
		builder.append(decode_map.get("pamid"));
		builder.append("' and B.assignstatus != 'Onhold request' ");
		
		if(!decode_map.get("l1id").equals("null")) {
			builder.append("and B.l1id = ");
			builder.append(decode_map.get("l1id"));
		}

		if(!decode_map.get("delid").equals("null")) {
			builder.append(" and B.delid = ");
			builder.append(decode_map.get("delid"));
		}
		
		if(!decode_map.get("pduid").equals("null")) {
			builder.append(" and B.pduid = '");
			builder.append(decode_map.get("pduid"));
			builder.append("'");
		}
		
		if(!decode_map.get("date").equals("null")) {
			builder.append(" and C.dateentry = '");
			builder.append(decode_map.get("date"));
			builder.append("'");
		}
		
		if(!decode_map.get("status").equals("null")) {
			if(decode_map.get("status").equals("Pending")) {
			builder.append(" and C.approvedentrystatus is null");
			
			}else {
				builder.append(" and C.approvedentrystatus = '");
				builder.append(decode_map.get("status"));
				builder.append("'");
			}
		}	
		
		builder.append(" and C.endtime is not null ");
		
		str_query = builder.toString();
		System.out.println("Get PAM Grid Data Query : "+str_query);
		log.write("DBMessage.java", "getPAMGridData()", "Get PAM Grid Data query::"+str_query, 9);
		return str_query;
	}

	public String pamApproveRejectActionData(HashMap<String, String> decode_map) {
	
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.PAM_APPROVE_REJECT_ACTION_QUERY);
		builder.append(decode_map.get("approvedby"));
		builder.append("', approveddatetime = ");
		builder.append("CURRENT_DATE");
		builder.append(", approvedtime = ");
		builder.append("CURRENT_TIMESTAMP ");
		builder.append(", approvedentrystatus = '");
		builder.append(decode_map.get("approvalentrystatus"));
		builder.append("'  where delid =");
		builder.append(decode_map.get("delid"));
		builder.append(" and taskentryid = ");
		builder.append(decode_map.get("taskentryid"));
		builder.append(" and pamid = '");
		builder.append(decode_map.get("pamid"));
		builder.append("' and pduid = '");
		builder.append(decode_map.get("pduid"));
		builder.append("'");
		str_query = builder.toString();
		System.out.println("Pam Approve Action Data Query : "+str_query);
		
		log.write("DBMessage.java", "pamApproveActionData()", "PAM Approve Action Data query::"+str_query, 9);
		return str_query;
	}

	public String setI459PDUActivityUnplannedData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_I459_UNPLANNEDACTIVITY_QUERY);
		builder.append(decode_map.get("delid"));
		builder.append(",");
		builder.append(decode_map.get("delassignid"));
		builder.append(",'");
		builder.append(decode_map.get("pamid"));
		builder.append("','");
		builder.append(decode_map.get("pamname"));
		builder.append("','");
		builder.append(decode_map.get("pduid"));
		builder.append("','");
		builder.append(decode_map.get("pduname"));
		builder.append("','");
		builder.append(decode_map.get("actl1name"));
		builder.append("',");
		builder.append("CURRENT_DATE");
		builder.append(",'");
		builder.append(decode_map.get("starttime"));
		builder.append("','");
		builder.append(decode_map.get("endtime"));
//		builder.append("','");
//		builder.append(emin);
		builder.append("','");
		builder.append("Stage Completion Request");
		builder.append("')");
		
		str_query = builder.toString();
		System.out.println("i459 unplanned activity Data Query : "+str_query);
		
		log.write("DBMessage.java", "setI459PDUActivityUnplannedData()", "i459 unplanned activity Data query::"+str_query, 9);
		return str_query;
	}

	public String getUnplannedDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_UNPLANNEDDATA_QUERY);
		builder.append(decode_map.get("pduid"));
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("get unplanned data query ::" + str_query);
		log.write("DBMessage.java", "getUnplannedDetails()", "get unplanned data query::"+str_query, 9);
		return str_query;
		
	}

	public String getPDUDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PDUWORK_DETAILS_QUERY);
		builder.append(decode_map.get("taskentryid"));
		builder.append(" and pduid = '");
		builder.append(decode_map.get("pduid"));
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("get pdu data query ::" + str_query);
		log.write("DBMessage.java", "getPDUDetails()", "get pdu data query::"+str_query, 9);
		return str_query;
	}

	public String getWorkitemDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_WORKITM_DATA_QUERY);
		builder.append(decode_map.get("taskentryid"));
		builder.append(" and pduid = '");
		builder.append(decode_map.get("pduid"));
		builder.append("'");
		
		
		str_query = builder.toString();
		System.out.println("get workitem data query ::" + str_query);
		log.write("DBMessage.java", "getWorkitemDetails()", "get workitem data query::"+str_query, 9);
		return str_query;
	}

	public String UpdateEminData(HashMap<String, String> decode_map, String emin) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_EMIN_DATA_QUERY);
		builder.append(emin);
		builder.append("' where minuteslogged is null and endtime is not null and pduid = '");
		builder.append(decode_map.get("pduid"));
		builder.append("' and taskentryid = ");
		builder.append(decode_map.get("taskentryid"));
		
		str_query = builder.toString();
		System.out.println("Update EminData query ::" + str_query);
		log.write("DBMessage.java", "UpdateEminData()", "Update EminData query::"+str_query, 9);
		return str_query;
	}

	public String getPAMApprovedData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PAM_DATA_QUERY);
		builder.append("and C.approvedentrystatus = 'Approve' and B.pamid = '");
		builder.append(decode_map.get("pamid"));
		builder.append("' ");
		
		if(!decode_map.get("l1id").equals("null")) {
			builder.append("and B.l1id = ");
			builder.append(decode_map.get("l1id"));
		}
		if(!decode_map.get("l2id").equals("null")) {
			builder.append(" and B.l2id = ");
			builder.append(decode_map.get("l2id"));
		}
		if(!decode_map.get("l3id").equals("null")) {
			builder.append(" and B.l3id = ");
			builder.append(decode_map.get("l3id"));
		}
		if(!decode_map.get("delid").equals("null")) {
			builder.append(" and B.delid = ");
			builder.append(decode_map.get("delid"));
		}
		
		str_query = builder.toString();
		System.out.println("get PAMApproved Data query ::" + str_query);
		log.write("DBMessage.java", "getPAMApprovedData()", "get PAMApproved Data query::"+str_query, 9);
		return str_query;
	}

	public String getPAMRejectedData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PAM_DATA_QUERY);
		builder.append("and C.approvedentrystatus = 'Reject' and B.pamid = '");
		builder.append(decode_map.get("pamid"));
		builder.append("' ");
		
		if(!decode_map.get("l1id").equals("null")) {
			builder.append("and B.l1id = ");
			builder.append(decode_map.get("l1id"));
		}
		if(!decode_map.get("l2id").equals("null")) {
			builder.append(" and B.l2id = ");
			builder.append(decode_map.get("l2id"));
		}
		if(!decode_map.get("l3id").equals("null")) {
			builder.append(" and B.l3id = ");
			builder.append(decode_map.get("l3id"));
		}
		if(!decode_map.get("delid").equals("null")) {
			builder.append(" and B.delid = ");
			builder.append(decode_map.get("delid"));
		}
		
		
		str_query = builder.toString();
		System.out.println("get PAMReject Data query ::" + str_query);
		log.write("DBMessage.java", "getPAMRejectedData()", "get PAMReject Data query::"+str_query, 9);
		return str_query;
	}

	public String getPAMProjectData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PAM_PROJECT_DATA_QUERY);
		builder.append("A.wbstype = 'L1Type' and B.active = 1 and B.pmpamid = '");
		builder.append(decode_map.get("pamid"));
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("get PAMProject Data query ::" + str_query);
		log.write("DBMessage.java", "getPAMProjectData()", "get PAMProject Data query::"+str_query, 9);
		return str_query;
	}

	public String getPAMModuleData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PAM_PROJECT_DATA_QUERY);
		builder.append("A.wbstype = 'L2Type' and B.active = 1 and B.pmpamid = '");
		builder.append(decode_map.get("pamid"));
		builder.append("' and A.l1id = ");
		builder.append(decode_map.get("l1id"));
		
		str_query = builder.toString();
		System.out.println("get PAMModule Data query ::" + str_query);
		log.write("DBMessage.java", "getPAMModuleData()", "get PAMModule Data query::"+str_query, 9);
		return str_query;
	}

	public String getPAMComponentData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PAM_PROJECT_DATA_QUERY);
		builder.append("A.wbstype = 'L3Type' and B.active = 1 and B.pmpamid = '");
		builder.append(decode_map.get("pamid"));
		builder.append("' and A.l1id = ");
		builder.append(decode_map.get("l1id"));
		builder.append(" and l2id = ");
		builder.append(decode_map.get("l2id"));
		
		str_query = builder.toString();
		System.out.println("get PAMComponent Data query ::" + str_query);
		log.write("DBMessage.java", "getPAMComponentData()", "get PAMComponent Data query::"+str_query, 9);
		return str_query;
	}

	public String getPAMDeliverableData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PAM_DELIVERABLE_DATA_QUERY);
		builder.append(decode_map.get("pamid"));
//		builder.append("' and B.l1id = ");
//		builder.append(decode_map.get("l1id"));
//		builder.append(" and l2id = ");
//		builder.append(decode_map.get("l2id"));
//		builder.append(" and l3id = ");
//		builder.append(decode_map.get("l3id"));
		builder.append("' and CURRENT_DATE between planstartdate and planenddate and assignstatus != 'Onhold request'");
		
		str_query = builder.toString();
		System.out.println("get PAMDeliverable Data query ::" + str_query);
		log.write("DBMessage.java", "getPAMDeliverableData()", "get PAMDeliverable Data query::"+str_query, 9);
		return str_query;

	}

	public String getProjectFilterDataQuery(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PROJECTFILTER_QUERY);
		builder.append(decode_map.get("pduid"));
		builder.append("' ");
		
		str_query = builder.toString();
		System.out.println("get Project Filter Data Query ::" + str_query);
		log.write("DBMessage.java", "getProjectFilterDataQuery()", "get Project Filter Data Query ::"+str_query, 9);
		return str_query;

	}

	public String UpdateStatusI456OnholdQuery(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_I456ACTIVITY_QUERY);
		builder.append(" delstatus = 'Onhold request' where delid = ");
		builder.append(decode_map.get("delid"));
		builder.append(" and wbsid = ");
		builder.append(decode_map.get("wbsid"));
		
		str_query = builder.toString();
		System.out.println("update i456(onhold request) status query ::" + str_query);
		log.write("DBMessage.java", "UpdateStatusI456OnholdQuery()", "Update i456(onhold request) Status Query ::"+str_query, 9);
		return str_query;
	}


	public String UpdateOnholdstatusData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_I458DATA_QUERY);
		builder.append(" recenddate = CURRENT_DATE , assignstatus = 'Onhold request'");
		builder.append(" where delid = ");
		builder.append(decode_map.get("delid"));
		
		str_query = builder.toString();
		System.out.println("Update onhold delassign Data query ::" + str_query);
		log.write("DBMessage.java", "UpdateOnholdstatusData()", "Update onhold delassign Data query ::"+str_query, 9);
		return str_query;
	}

	public String getPDUNameData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PDU_NAME_QUERY);
		builder.append(decode_map.get("pamid"));
		builder.append("' and CURRENT_DATE between planstartdate and planenddate ");
		
		str_query = builder.toString();
		System.out.println("get PDU Name Data query ::" + str_query);
		log.write("DBMessage.java", "getPDUNameData()", "get PDU Name Data query ::"+str_query, 9);
		return str_query;
	}

	public String getDeliverableTrackingGrid(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_DELTRACK_GRID_QUERY);
		builder.append(decode_map.get("pamid"));
		builder.append("' and A.delstatus != 'Onhold request' ");
		
		if(!decode_map.get("l1id").equals("null")) {
			builder.append(" and B.l1id = ");
			builder.append(decode_map.get("l1id"));
		}
		if(!decode_map.get("date").equals("null")) {
			builder.append(" and B.recdate = '");
			builder.append(decode_map.get("date"));
			builder.append("'");
		}
		if(!decode_map.get("delid").equals("null")) {
			builder.append(" and A.delid = ");
			builder.append(decode_map.get("delid"));
		}
		
		str_query = builder.toString();
		System.out.println("get DeliverableTracking Grid query ::" + str_query);
		log.write("DBMessage.java", "getDeliverableTrackingGrid()", "get DeliverableTracking Grid query ::"+str_query, 9);
		return str_query;
	}

	public String UpdateAppRejDelData(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_I458DATA_QUERY);
		builder.append(" assignstatus = ");
		
		if(decode_map.get("approvalentrystatus").equals("Approve")) {
			builder.append("  'Activity Completd'");
		}else {
			builder.append(" 'Assign WIP'");
		}
		builder.append(" where delid =");
		builder.append(decode_map.get("delid"));
		builder.append(" and l1id = ");
		builder.append(decode_map.get("l1id"));
		
		str_query = builder.toString();
		System.out.println("Update AppRejDeliberable Data query ::" + str_query);
		log.write("DBMessage.java", "UpdateAppRejDelData()", "Update AppRejDeliberable Data query ::"+str_query, 9);
		return str_query;
	}

	public String getDeliverablePAMListdata(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_DELI_PAM_QUERY);
		builder.append(decode_map.get("l1name"));
		builder.append("' and active = 1 ");
		
		str_query = builder.toString();
		System.out.println("get Deliverable PAMList data query ::" + str_query);
		log.write("DBMessage.java", "getDeliverablePAMListdata()", "get Deliverable PAMList data query ::"+str_query, 9);
		return str_query;
	}

	public String getPMDeldetails(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_PM_DEL_DETAILS_QUERY);
		builder.append(decode_map.get("delid"));
		
		if(!decode_map.get("status").equals("null")) {
			builder.append(" and A.assignstatus = '");
			builder.append(decode_map.get("status"));
			builder.append("'");
		}
		
		if(!decode_map.get("pduid").equals("null")) {
			builder.append(" and A.pduid = '");
			builder.append(decode_map.get("pduid"));
			builder.append("'");
		}
		
		if(!decode_map.get("pamid").equals("null")) {
			builder.append(" and A.pamid = '");
			builder.append(decode_map.get("pamid"));
			builder.append("'");
		}
		
		if(!decode_map.get("start_date").equals("null")) {
			builder.append(" and '");
			builder.append(decode_map.get("start_date"));
			builder.append("' between A.recstartdate and A.recenddate");
		}
		
		if(!decode_map.get("end_date").equals("null")) {
			builder.append(" and '");
			builder.append(decode_map.get("end_date"));
			builder.append("' between A.recstartdate and A.recenddate");
		}
		
		str_query = builder.toString();
		System.out.println("get PM Deliverable details data query ::" + str_query);
		log.write("DBMessage.java", "getPMDeldetails()", "get PM Deliverable details data query ::"+str_query, 9);
		return str_query;
		
	}

	public String UpdateEminUnplannedData(HashMap<String, String> decode_map, String emin) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_EMIN_DATA_QUERY);
		builder.append(emin);
		builder.append("' where minuteslogged is null and endtime is not null and pduid = '");
		builder.append(decode_map.get("pduid"));
		builder.append("' and starttime = '");
		builder.append(decode_map.get("starttime"));
		builder.append("' and endtime = '");
		builder.append(decode_map.get("endtime"));
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("Update Emin unplanned data query ::" + str_query);
		log.write("DBMessage.java", "UpdateEminUnplannedData()", "Update Emin unplanned data query::"+str_query, 9);
		return str_query;
	}

	public String setBugstatusi461(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.UPDATE_BUG_STATUS_QUERY);
		builder.append(decode_map.get("status"));
		builder.append("' where wbsid = ");
		builder.append(decode_map.get("wbsid"));
		builder.append(" and delid = ");
		builder.append(decode_map.get("delid"));
		
		str_query = builder.toString();
		System.out.println("set Bugstatus i461 data query ::" + str_query);
		log.write("DBMessage.java", "setBugstatusi461()", "set Bugstatus i461 data query::"+str_query, 9);
		return str_query;
	}

	public String getPMBugDetails(HashMap<String, String> decode_map) {

		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_BUG_DETAILS_PM_QUERY);
		builder.append(decode_map.get("delid"));
		
		if(!decode_map.get("bugtype").equals("null")) {
			builder.append(" and wbsrectypel2 =  '");
			builder.append(decode_map.get("bugtype"));
			builder.append("'");
		}
		
		if(!decode_map.get("priority").equals("null")) {
			builder.append(" and wbsrecpriority =  '");
			builder.append(decode_map.get("priority"));
			builder.append("'");
		}
		
		if(!decode_map.get("status").equals("null")) {
			builder.append(" and currentstatus =  '");
			builder.append(decode_map.get("status"));
			builder.append("'");
		}
		
		str_query = builder.toString();
		System.out.println("get PM Bug Details query ::" + str_query);
		log.write("DBMessage.java", "getPMBugDetails()", "get PM Bug Details query::"+str_query, 9);
		return str_query;
	}

	public String getDeliverablePUDListdata(HashMap<String, String> decode_map) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.GET_DELI_PDU_QUERY);
		builder.append(decode_map.get("l1name"));
		builder.append("' and active = 1 ");
		
		str_query = builder.toString();
		System.out.println("get Deliverable PDUList data query ::" + str_query);
		log.write("DBMessage.java", "getDeliverablePDUListdata()", "get Deliverable PDUList data query ::"+str_query, 9);
		return str_query;
	}

	}

	


	
	

