package com.Database;

public abstract class DBQuery {
	
	public static final String LAST_COUNT_I453_QUERY = "select count(*) from i453wbsmaster where wbstype = 'L1Type' and active = 1 and l1name = '";

	public static final String SET_PROJECT_NAME_QUERY = "insert into i453wbsmaster (ownerid,wbstype,l1type,l1id,l1name,startdate,enddate,active) values (";
	
	public static final String GET_L1_TYPE_QUERY = "select sn,defntype,defnidl1,defnidl2,defnlegendl2 from i450defmaster where defnlegendl1 = 'L1Type'";

	public static final String GET_SEQUENCE_QUERY = "SELECT nextval('serial')";

	public static final String SET_MANAGER_NAME_QUERY = "insert into i454wbsauth (wbsid,typeofentry,pmpamid,pmpamname,startdate,enddate,active) values (";

	public static final String GET_LASTCOUNT_454_QUERY = "select count(*) from i454wbsauth where wbsid = ";

	public static final String DELETE_I453_QUERY = "update i453wbsmaster set active = 0 where l1id = ";

	public static final String DELETE_I454_QUERY = "update i454wbsauth set active = 0 where wbsid = ";

	public static final String MANAGER_REMOVE_QUERY = "update i454wbsauth set pmpamid = 0,pmpamname = 'null' , enddate = CURRENT_DATE where wbsid = ";

	public static final String GET_PROJECT_DETAILS_QUERY = "select wbsid,wbstype,l1type,l1id,l1name,startdate,enddate from i453wbsmaster where active = 1 and l2id is null and l3id is null";

	public static final String SET_EXTENDED_PROJECTDATE_QUERY = "update i453wbsmaster set enddate = '";

	public static final String GET_MANAGER_DETAILS_QUERY = "select wbsauthid,wbsid,typeofentry,pmpamid,pmpamname,startdate,enddate from i454wbsauth where active = 1 and pmpamid != '0' and wbsid = ";

	public static final String GET_ACTIVITYL1_DATA_QUERY = "select * from i451activitymatrix where type = 'L1'";

	public static final String GET_ACTIVITYL2_DATA_QUERY = "select * from i451activitymatrix where type = 'L2' and actl1id =";

	public static final String LAST_COUNT_I455_QUERY = "select count(*) from I455skillmatrix where empid = '";

	public static final String INSERT_SKILLMATRIX_QUERY = "insert into i455skillmatrix (empid,empname,emptype,actl1,actl2,skilllevel,costcurrency,costunit,costvalue,startdate,enddate,active) values ('";

	public static final String DELETE_SKILLMATRIX_QUERY = "update i455skillmatrix set active = 0 where sn = ";

	public static final String GET_SKILLMATRIX_QUERY = "select sn,empid,empname,emptype,actl1,actl2,skilllevel,costcurrency,costunit,costvalue,startdate,enddate from i455skillmatrix where active = 1 ";

	public static final String GET_L2_DATA_QUERY = "select l1id,l1name,l1type,l2id,l2name,wbstype,wbsid,startdate,enddate,(select count(*) from i456delimaster where wbsid in (select wbsid from i453wbsmaster where l2id=M.wbsid and wbstype='L3Type' and active = 1)) as DCount from i453wbsmaster M where l1id = ";

	public static final String GET_L3_DATA_QUERY = "select distinct A.wbsid,A.wbstype,A.l3id,A.l3name,A.l1type,B.delid,B.delname,(select wbsauthid from i454wbsauth A,i453wbsmaster B where A.wbsid = B.wbsid and B.active = 1 and B.l1name = '";

	public static final String SET_L3_DATA_QUERY = "insert into i453wbsmaster(ownerid,wbstype,l1type,l1id,l1name,l2type,l2id,l2name,l3type,l3id,l3name,startdate,enddate,active) values(";

	public static final String SET_L2_DATA_Query = "insert into i453wbsmaster(ownerid,wbstype,l1type,l1id,l1name,l2type,l2id,l2name,startdate,enddate,active) values(";

	public static final String GET_L2L3_LAST_COUNT_QUERY = "select count(*) from i453wbsmaster where " ;

	public static final String GET_LAST_COUNT_WBSAUTH_QUERY = "select count(*) from i454wbsauth where ";

	public static final String SET_WBSAUTH_DATA = "insert into i454wbsauth(wbsid,typeofentry,pmpamid,pmpamname,startdate,enddate,active) values(";

	public static final String GET_PMGRID_QUERY = "select distinct A.wbsid,A.wbstype,A.l1type,A.l1id,A.l1name,B.pmpamid,B.pmpamname,B.startdate,B.enddate,A.active from i453wbsmaster A,i454wbsauth B where B.pmpamid = '";

	public static final String LAST_COUNT_I456_QUERY = "select count(*) from i456delimaster where delname = '";

	public static final String SET_DELIVERABLE_I456_QUERY = "insert into i456delimaster (delname,delcreateid,wbsid,wbsauthid,recdate,deltype,expstartdate,expreleasedate,delstatus) values ('";
	
	public static final String SET_DELIVERABLEHISTORY_I457_QUERY = "insert into i457delhistory (delid,delassid,delstatus,assignstatus,currentdate) values (" ;
	
	public static final String GET_DELIVERABLE_GRID_QUERY = "select distinct A.delid,A.delname,A.delcreateid,A.wbsid,A.wbsauthid,A.delstatus,B.l1type,B.l1id,B.l1name,B.l2id,B.l2name,B.l3id,B.l3name,C.pmpamid,C.pmpamname,C.startdate,C.enddate,E.actl1name,D.pamid,D.pamname,D.pduid,D.pduname from i456delimaster A left outer join i453wbsmaster B ON B.active = 1 and B.wbstype = 'L3Type' and A.wbsid = B.wbsid left outer join i454wbsauth C ON CURRENT_DATE between C.startdate and C.enddate and C.wbsauthid in (select wbsauthid from i454wbsauth A,i453wbsmaster B where A.pmpamid = '";

	public static final String GET_PAMPDUDATA_QUERY = "select distinct empid,empname from i455skillmatrix where active = 1 and CURRENT_DATE between startdate and enddate and emptype = '";

	public static final String GET_LASTCOUNT_I458_QUERY = "select count(*) from i458delassi where pduid = '";

	public static final String SET_DELIVERY_ASSIGN_I458_QUERY = "insert into i458delassi (delid,wbsid,recdate,l1id,l1name,l2id,l2name,l3id,l3name,assignstatus,pamid,pamname,pduid,pduname,actl1id,planstartdate,planenddate,planhours) values (";

	public static final String UPDATE_I456ACTIVITY_QUERY = "update i456delimaster set ";

	public static final String SELECT_ACTIVITYL1_UPDATE_QUERY = "select curassignactl1id from i456delimaster where delid = ";

	public static final String UPDATE_ACTIVITYL1ID_QUERY = "update i456delimaster set preassignactl1id = ";

	public static final String GET_PDU_GRID_QUERY = "select distinct A.delid,A.wbsid,A.delassid,A.l1id,A.l1name,A.l2id,A.l2name,A.l3id,A.l3name,A.assignstatus,A.pamid,A.pamname,A.actl1id,B.actl1name,C.delname,C.delstatus from i458delassi A,i451activitymatrix B,i456delimaster C where A.actl1id = B.actl1id and A.delid = C.delid and pduid = '";

	public static final String LAST_COUNT_I459_QUERY = "select count(*) from i459pduactivity where endtime is null and pduid = '";
	
	public static final String LAST_TIME_I459_QUERY = "select count(*) from i459pduactivity where dateentry = CURRENT_DATE and '";

	public static final String INSERT_I459_PDU_QUERY = "insert into i459pduactivity (delid,delassid,activitylocation,pamid,pamname,pduid,pduname,actl1id,actl1name,actl2id,actl2name,dateentry,starttime,taskstatus) values (";

	public static final String GET_ACTIVITY_GRID_QUERY = "select * from i459pduactivity where pduid = '";

	public static final String LAST_COUNT_I460_QUERY = "select count(*) from i460workitem where pduid = '";

	public static final String SET_ACTIVITYMANAGER_NAME_QUERY = "insert into i454wbsauth (wbsid,typeofentry,pmpamid,pmpamname,actidl1,startdate,enddate,active) values (";

	public static final String INSERT_I460_WI_QUERY = "insert into i460workitem (pduid,taskentryid,curdate,delwitype,delwiaction,delwiname,delwiversion) values ('";

	public static final String GET_WORKITEM_GRID_QUERY = "select * from i460workitem where pduid = '";

	public static final String UPDATE_ENDTIME_QUERY = "update i459pduactivity set endtime = '";

	public static final String GET_WORKITEM_TYPE_QUERY = "select * from i450defmaster where defntype = 10";

	public static final String SELECT_EMINLOG_QUERY = "SELECT ";

	public static final String UPDATE_I458DATA_QUERY = "update i458delassi set  ";

	public static final String ADD_BUG_REPORT_QUERY = "insert into i461wbsrecmaster(wbsrecactcount,linkagelevel,wbsid,delid,wbsreccreatedate,wbsrectypel1,wbsrectypel2,wbsrecpriority,wbsrecidjson,wbsreccurrent,currentstatus) values (";

	public static final String ADD_BUG_TRACKING_QUERY = "insert into i462wbsrectracking (wbsid,delid,reportid,currentdate,issactcount,wbsprejson,plancompdate) values (";

	public static final String LAST_COUNT_BUGREPORT_CHECK_QUERY = "select count(*) from i461wbsrecmaster where wbsid =";

	public static final String UPDATE_BUGREPORT_DATE_QUERY = "update i462wbsrectracking set receivedate = CURRENT_DATE where delid =";

	public static final String UPDATE_BUGREPORT_JOSN_QUERY = "update i462wbsrectracking set issactcount = (select count(issactcount) + 1 from i462wbsrectracking where delid =";

	public static final String GET_BUGREPORTDATA_QUERY = "select A.wbsid,A.delid,A.wbsrectypel1,A.wbsrecpriority,A.wbsreccurrent,A.wbsrecidjson,B.wbsprejson from i461wbsrecmaster A,i462wbsrectracking B where A.wbsid = B.wbsid and A.delid = B.delid and A.currentstatus = 'Open' and B.issuestatus is null and A.delid = ";

	public static final String UPDATE_BUG_USERCOMMENTS_QUERY = "update i462wbsrectracking set usercomments = '";

	public static final String GET_PAM_DATA_QUERY = "select distinct A.delid,A.delname,A.delcreateid,A.delstatus,B.l1id,B.l1name,B.l2id,B.l2name,B.l3id,B.l3name,C.taskentryid,C.actl1name,C.starttime,C.endtime,C.taskstatus,C.approvedentrystatus,C.pduid,C.pduname,B.wbsid from i456delimaster A,i458delassi B,i459pduactivity C where A.delid = B.delid and B.delid = C.delid and B.pamid = C.pamid ";
	
	public static final String PAM_APPROVE_REJECT_ACTION_QUERY = "update i459pduactivity set approvedby = '";

	public static final String SET_I459_UNPLANNEDACTIVITY_QUERY = "insert into i459pduactivity (delid,delassid,pamid,pamname,pduid,pduname,actl1name,dateentry,starttime,endtime,taskstatus) values (";

	public static final String GET_UNPLANNEDDATA_QUERY = "select distinct A.delid,A.delassid,A.actl1name,A.taskstatus,A.pamid,A.pamname,A.pduid,A.pduname,A.dateentry,A.starttime,A.endtime,B.delname,B.delid,C.l1id,C.l1name,C.l2id,C.l2name,C.l3id,C.l3name from i459pduactivity A,i456delimaster B,i458delassi C where A.activitylocation is null and A.delid = B.delid and A.pduid = C.pduid and B.delid = C.delid and A.pduid = '";

	public static final String GET_PDUWORK_DETAILS_QUERY = "select * from i459pduactivity where taskentryid = ";

	public static final String UPDATE_EMIN_DATA_QUERY = "update i459pduactivity set minuteslogged = '";
	
	public static final String GET_WORKITM_DATA_QUERY = "select distinct A.pduid,A.workid,A.taskentryid,A.delwitype,A.delwiaction,A.delwiname,A.delwiversion,B.defnlegendl1 from i460workitem A,i450defmaster B where B.defntype = 10 and A.delwitype = B.defnidl1 and A.taskentryid = ";

	public static final String GET_PAM_PROJECT_DATA_QUERY = "select distinct A.wbsid,A.wbstype,A.l1id,A.l1name,A.l2id,A.l2name,A.l3id,A.l3name from i453wbsmaster A,i454wbsauth B where A.active = 1 and B.typeofentry = 'L2PAM' and CURRENT_DATE between B.startdate and B.enddate and ";

	public static final String GET_PAM_DELIVERABLE_DATA_QUERY = "select distinct A.delid,A.delname,A.delcreateid from i456delimaster A,i458delassi B where A.delid = B.delid and B.pamid = '";

	public static final String SET_EXTENDED_PROJECTAUTHDATE_QUERY = "update i454wbsauth set enddate = '";

	public static final String GET_PROJECTFILTER_QUERY = "select distinct A.l1id,A.l1name from i453wbsmaster A,i458delassi B where A.wbsid = B.wbsid and B.pduid = '";

	public static final String GET_PDU_NAME_QUERY = "select distinct pduid,pduname from i458delassi where pamid = '";

	public static final String GET_DELTRACK_GRID_QUERY = "select distinct A.delid,A.delname,A.delstatus,B.l1id,B.l1name,B.assignstatus,B.pamid,B.pamname,B.pduid,B.pduname,C.actl1name,C.actl1id from i456delimaster A,i458delassi B,i451activitymatrix C where A.delid = B.delid and B.actl1id = C.actl1id and B.pamid = '";

	public static final String GET_DELI_PAM_QUERY = "select distinct pamid,pamname from i458delassi A,i453wbsmaster B where B.wbstype = 'L3Type' and B.l1name = '";

	public static final String GET_PM_DEL_DETAILS_QUERY = "select distinct A.delid,A.delassid,A.l1id,A.l1name,A.l2id,A.l2name,A.l3id,A.l3name,A.assignstatus,A.pamid,A.pamname,A.pduid,A.pduname,A.planhours,A.recstartdate,A.recenddate,B.actl1name from i458delassi A,i451activitymatrix B where A.actl1id=B.actl1id and B.type = 'L1' and delid = ";

	public static final String UPDATE_BUG_STATUS_QUERY = "update i461wbsrecmaster set currentstatus = '";

	public static final String GET_BUG_DETAILS_PM_QUERY = "select * from i461wbsrecmaster where wbsrectypel1 = 'Bug Report' and delid =";

	public static final String GET_DELI_PDU_QUERY = "select distinct pduid,pduname from i458delassi A,i453wbsmaster B where B.wbstype = 'L3Type' and B.l1name = '";

//	public static final String UPDATE_DELIVERABLE_STATUS_QUERY="update i456delimaster set delstatus = 'Close' where delid = ";

}
