package com.pcci.idls.maintenance;

import java.text.SimpleDateFormat;
import java.util.List;

import com.pcci.idls.exception.StatusBean;
import com.pcci.idls.maintenance.account.domain.Account;
import com.pcci.idls.maintenance.client.domain.Client;
import com.pcci.idls.maintenance.investmenttype.domain.InvestmentType;
import com.pcci.idls.maintenance.module.domain.Module;
import com.pcci.idls.maintenance.rolemodule.domain.RoleModule;
import com.pcci.idls.maintenance.securitytype.domain.SecurityType;
import com.pcci.idls.maintenance.users.domain.Users;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;
import com.pcci.idls.util.DateUtil;

public class MaintenanceResponseHandler {
	private static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	
	public static String createRoleModuleResponse(List<RoleModule> modules, String sessionId, String transactionType, StatusBean status){
		StringBuffer response = new StringBuffer();
		response.append("<serviceresponse>");
		if(status.getType().equalsIgnoreCase("ERROR") && modules==null){
			response.append("<status>");
				response.append("<type>"+status.getType()+"</type>");
				response.append("<message>"+status.getDescription()+"</message>");
				response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
		}
		else{
			response.append("<status>");
			response.append("<type>"+status.getType()+"</type>");
			response.append("<message>"+status.getDescription()+"</message>");
			response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
			
			response.append("<modules>");
			response.append("<transaction>");
			response.append("<type>"+transactionType+"</type>");
			response.append("<sessionid>"+sessionId+"</sessionid>");
			response.append("</transaction>");

			
			for (RoleModule module : modules) {
				response.append("<module>");
				response.append("<id>"+module.getModuleId()+"</id>");
				response.append("<description>"+module.getModuleId()+"</description>");
				
				String strEffDate = new String(sdf.format(module.getEffDate()));
				String strExpDate = new String(sdf.format(module.getExpDate()));
				String strLastUpdate = new String(sdf.format(module.getLastUpdate()));
				
				response.append("<accessCreate>"+module.getAccessCreate()+"</accessCreate>");
				response.append("<accessRead>"+module.getAccessRead()+"</accessRead>");
				response.append("<accessUpdate>"+module.getAccessUpdate()+"</accessUpdate>");
				response.append("<accessDelete>"+module.getAccessDelete()+"</accessDelete>");

				response.append("<effectivedate>"+strEffDate+"</effectivedate>");
				response.append("<expirydate>"+strExpDate+"</expirydate>");
				response.append("<lastupdate>"+strLastUpdate+"</lastupdate>");
				
				response.append("<modifiedby>"+module.getModifiedBy()+"</modifiedby>");
				response.append("</module>");
				
			}
			
			response.append("</modules>");	
		}
		
		response.append("</serviceresponse>");
		return response.toString();
	}	
	
	public static String createModuleResponse(List<Module> modules, String sessionId, String transactionType, StatusBean status){
		StringBuffer response = new StringBuffer();
		response.append("<serviceresponse>");
		if(status.getType().equalsIgnoreCase("ERROR") && modules==null){
			response.append("<status>");
				response.append("<type>"+status.getType()+"</type>");
				response.append("<message>"+status.getDescription()+"</message>");
				response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
		}
		else{
			response.append("<status>");
			response.append("<type>"+status.getType()+"</type>");
			response.append("<message>"+status.getDescription()+"</message>");
			response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
			
			response.append("<modules>");
			response.append("<transaction>");
			response.append("<type>"+transactionType+"</type>");
			response.append("<sessionid>"+sessionId+"</sessionid>");
			response.append("</transaction>");

			
			for (Module module : modules) {
				response.append("<module>");
				response.append("<id>"+module.getId()+"</id>");
				response.append("<description>"+module.getDescription()+"</description>");
				String strEffDate = new String(sdf.format(module.getEffDate()));
				String strExpDate = new String(sdf.format(module.getExpDate()));
				String strLastUpdate = new String(sdf.format(module.getLastUpdate()));
				
				response.append("<effectivedate>"+strEffDate+"</effectivedate>");
				response.append("<expirydate>"+strExpDate+"</expirydate>");
				response.append("<lastupdate>"+strLastUpdate+"</lastupdate>");
				
				response.append("<modifiedby>"+module.getModifiedBy()+"</modifiedby>");
				response.append("</module>");
				
			}
			
			response.append("</modules>");	
		}
		
		response.append("</serviceresponse>");
		return response.toString();
	}
	
	public static String createUserResponse(List<Users> lstUser, String sessionId, String transactionType, StatusBean status){
		StringBuffer response = new StringBuffer();
		response.append("<serviceresponse>");
		if(status.getType().equalsIgnoreCase("ERROR")){
			response.append("<status>");
				response.append("<type>"+status.getType()+"</type>");
				response.append("<message>"+status.getDescription()+"</message>");
				response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
		}
		else{
			response.append("<status>");
			response.append("<type>"+status.getType()+"</type>");
			response.append("<message>"+status.getDescription()+"</message>");
			response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
			
			response.append("<users>");
			response.append("<transaction>");
			response.append("<type>"+transactionType+"</type>");
			response.append("<sessionid>"+sessionId+"</sessionid>");
			response.append("</transaction>");

			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
			if(lstUser!=null){
				for (Users user : lstUser) {
					response.append("<user>");
					response.append("<userid>"+user.getId()+"</userid>");
					response.append("<roleid>"+user.getRoleId()+"</roleid>");
					response.append("<lastname>"+user.getLastName()+"</lastname>");
					response.append("<firstname>"+user.getFirstName()+"</firstname>");
					response.append("<middlename>"+user.getMiddleName()+"</middlename>");
					response.append("<email>"+user.getEmail()+"</email>");
					response.append("<phone>"+user.getPhone()+"</phone>");
					
					String strEffDate = new String(sdf.format(user.getEffDate()));
					String strExpDate = new String(sdf.format(user.getExpDate()));
					String strPwExpDate = new String(sdf.format(user.getPwEffDate()));
					String strLastLogon = new String(sdf.format(user.getLastLogOn()));
					String strLastUpdate = new String(sdf.format(user.getLastUpdate()));
					
					response.append("<effectivedate>"+strEffDate+"</effectivedate>");
					response.append("<expirydate>"+strExpDate+"</expirydate>");
					response.append("<pwordeffectivedate>"+strPwExpDate+"</pwordeffectivedate>");
					response.append("<lastlogon>"+strLastLogon+"</lastlogon>");
					response.append("<lastupdate>"+strLastUpdate+"</lastupdate>");
					
					response.append("<modifiedby>"+user.getModifiedBy()+"</modifiedby>");
					response.append("<locked>"+user.getLocked()+"</locked>");
					
					response.append("</user>");
					
				}
			}
			
			
			response.append("</users>");	
		}
		
		response.append("</serviceresponse>");
		return response.toString();
	}
	
	public static String createIDLSTrxEntriesResponse(List<IDLSTrxEntries> lstIDLSTrxEntries, String sessionId, String transactionType, StatusBean status){
		StringBuffer response = new StringBuffer();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
		response.append("<serviceresponse>");
		if(status.getType().equalsIgnoreCase("ERROR")){
			response.append("<status>");
				response.append("<type>"+status.getType()+"</type>");
				response.append("<message>"+status.getDescription()+"</message>");
				response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
		}
		else{
			response.append("<status>");
			response.append("<type>"+status.getType()+"</type>");
			response.append("<message>"+status.getDescription()+"</message>");
			response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
			
			response.append("<transaction>");
			response.append("<type>"+transactionType+"</type>");
			response.append("<sessionid>"+sessionId+"</sessionid>");
			response.append("</transaction>");
			
			if(lstIDLSTrxEntries!=null){
				response.append("<TrxEntries>");
				for (IDLSTrxEntries idlsTrxEntries : lstIDLSTrxEntries) {
					response.append("<TrxEntry>");
					response.append("<rn>"+ idlsTrxEntries.getRn() +"</rn>");
					response.append("<TrxCredit>"+ idlsTrxEntries.getTrxCredit() +"</TrxCredit>");
					response.append("<TrxDate>"+ sdf.format(idlsTrxEntries.getTrxDate()) +"</TrxDate>");
					response.append("<TrxDebit>"+ idlsTrxEntries.getTrxDebit() +"</TrxDebit>");
					response.append("<TrxDesc>"+ idlsTrxEntries.getTrxDesc() +"</TrxDesc>");
					response.append("<TrxIMA_AcctCode>"+ idlsTrxEntries.getTrxIMA_AcctCode() +"</TrxIMA_AcctCode>");
					response.append("<TrxIMA_AcctNormalBal>"+ DateUtil.handleString(idlsTrxEntries.getTrxIMA_AcctNormalBal()) +"</TrxIMA_AcctNormalBal>");
					response.append("<TrxIMA_XAcctCode>"+ idlsTrxEntries.getTrxIMA_XAcctCode() +"</TrxIMA_XAcctCode>");
					response.append("<TrxIMA_XAcctNormalBal>"+ DateUtil.handleString(idlsTrxEntries.getTrxIMA_XAcctNormalBal()) +"</TrxIMA_XAcctNormalBal>");
					response.append("<TrxJournal>"+ DateUtil.handleString(idlsTrxEntries.getTrxJournal()) +"</TrxJournal>");
					response.append("<TrxRefNo>"+ idlsTrxEntries.getTrxRefNo() +"</TrxRefNo>");
					response.append("<TrxTotal>"+ idlsTrxEntries.getTrxTotal() +"</TrxTotal>");
					response.append("<TrxFrom>"+ idlsTrxEntries.getTrxFrom() +"</TrxFrom>");
					response.append("<TrxType>"+ idlsTrxEntries.getTrxType() +"</TrxType>");
					response.append("<Converted>"+ idlsTrxEntries.getConverted() +"</Converted>");
					response.append("</TrxEntry>");
				}
				response.append("</TrxEntries>");
			}

		}
		response.append("</serviceresponse>");
		return response.toString();
	}
	
	public static String createClientServiceResponse(List<Client> lstClients, String sessionId, String transactionType, StatusBean status){
		StringBuffer response = new StringBuffer();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
		response.append("<serviceresponse>");
		if(status.getType().equalsIgnoreCase("ERROR")){
			response.append("<status>");
				response.append("<type>"+status.getType()+"</type>");
				response.append("<message>"+status.getDescription()+"</message>");
				response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
		}
		else{
			response.append("<status>");
			response.append("<type>"+status.getType()+"</type>");
			response.append("<message>"+status.getDescription()+"</message>");
			response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
			
			response.append("<transaction>");
			response.append("<type>"+transactionType+"</type>");
			response.append("<sessionid>"+sessionId+"</sessionid>");
			response.append("</transaction>");
			
			if(lstClients!=null){
				response.append("<clients>");
				for (Client client : lstClients) {
					response.append("<client>");
						response.append("<IMA_ClientID>"+ client.getClientId() +"</IMA_ClientID>");
						response.append("<IMA_ClientName>"+ client.getClientName() +"</IMA_ClientName>");
						response.append("<IMA_ClientCode>"+ DateUtil.handleString(client.getClientCode()) +"</IMA_ClientCode>");
						response.append("<LastUserCode>"+ DateUtil.handleString(client.getLastUserCode()) +"</LastUserCode>");
						try{
							response.append("<LastUpdate>"+ sdf.format(client.getLastUpdate()) +"</LastUpdate>");
						}
						catch(Exception e){
							response.append("<LastUpdate></LastUpdate>");
						}
					response.append("</client>");
				}
				response.append("</clients>");
			}

		}
		response.append("</serviceresponse>");
		return response.toString();
	}

	public static String createAccountServiceResponse(List<Account> lstAccounts, String sessionId, String transactionType, StatusBean status){
		StringBuffer response = new StringBuffer();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
		response.append("<serviceresponse>");
		if(status.getType().equalsIgnoreCase("ERROR")){
			response.append("<status>");
				response.append("<type>"+status.getType()+"</type>");
				response.append("<message>"+status.getDescription()+"</message>");
				response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
		}
		else{
			response.append("<status>");
			response.append("<type>"+status.getType()+"</type>");
			response.append("<message>"+status.getDescription()+"</message>");
			response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
			
			response.append("<transaction>");
			response.append("<type>"+transactionType+"</type>");
			response.append("<sessionid>"+sessionId+"</sessionid>");
			response.append("</transaction>");
			
			if(lstAccounts!=null){
				response.append("<accounts>");
				for (Account account : lstAccounts) {
					try{
						response.append("<account>");
							response.append("<IMA_AcctCode>"+ account.getAcctCode() +"</IMA_AcctCode>");
							response.append("<IMA_AcctDesc>"+ account.getAcctDesc() +"</IMA_AcctDesc>");
							response.append("<IMA_AcctNormalBal>"+ DateUtil.handleString(account.getAcctNormalBalance()) +"</IMA_AcctNormalBal>");
							response.append("<IMA_AcctReptName>"+ DateUtil.handleString(account.getAcctReptName()) +"</IMA_AcctReptName>");
							response.append("<IFMS_BasedID>"+ DateUtil.handleString(account.getIfmsBasedId()) +"</IFMS_BasedID>");
							response.append("<IFMS_BasedName>"+ DateUtil.handleString(account.getIfmsBasedName()) +"</IFMS_BasedName>");
							response.append("<LastUserCode>"+ DateUtil.handleString(account.getLastUserCode()) +"</LastUserCode>");
							try{
								response.append("<LastUpdate>"+ sdf.format(account.getLastUpdate()) +"</LastUpdate>");
							}
							catch(Exception e){
								response.append("<LastUpdate></LastUpdate>");
							}
						response.append("</account>");
					}
					catch(Exception e){
						response.append("INVALID_DATA</account>");
					}
				}
				response.append("</accounts>");
			}

		}
		response.append("</serviceresponse>");
		System.out.println("response XML: "+response);
		return response.toString();
	}

	public static String createSecurityTypeServiceResponse(List<SecurityType> lstSecurityTypes, String sessionId, String transactionType, StatusBean status){
		StringBuffer response = new StringBuffer();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
		response.append("<serviceresponse>");
		if(status.getType().equalsIgnoreCase("ERROR")){
			response.append("<status>");
				response.append("<type>"+status.getType()+"</type>");
				response.append("<message>"+status.getDescription()+"</message>");
				response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
		}
		else{
			response.append("<status>");
			response.append("<type>"+status.getType()+"</type>");
			response.append("<message>"+status.getDescription()+"</message>");
			response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
			
			response.append("<transaction>");
			response.append("<type>"+transactionType+"</type>");
			response.append("<sessionid>"+sessionId+"</sessionid>");
			response.append("</transaction>");
			
			if(lstSecurityTypes!=null){
				response.append("<securitytypes>");
				for (SecurityType securityType : lstSecurityTypes) {
					response.append("<securitytype>");
						response.append("<SecurityTypeID>"+ securityType.getSecurityTypeId() +"</SecurityTypeID>");
						response.append("<SecurityDesc>"+ DateUtil.handleString(securityType.getSecurityDesc()) +"</SecurityDesc>");
						response.append("<InvestmentType>"+ DateUtil.handleString(securityType.getInvestmentType()) +"</InvestmentType>");
						response.append("<LastUserCode>"+ DateUtil.handleString(securityType.getLastUserCode()) +"</LastUserCode>");
						try{
							response.append("<LastUpdate>"+ sdf.format(securityType.getLastUpdate()) +"</LastUpdate>");
						}
						catch(Exception e){
							response.append("<LastUpdate></LastUpdate>");
						}
					response.append("</securitytype>");
				}
				response.append("</securitytypes>");
			}

		}
		response.append("</serviceresponse>");
		return response.toString();
	}

	public static String createInvestmentTypeServiceResponse(List<InvestmentType> lstInvestmentType, String sessionId, String transactionType, StatusBean status){
		StringBuffer response = new StringBuffer();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
		response.append("<serviceresponse>");
		if(status.getType().equalsIgnoreCase("ERROR")){
			response.append("<status>");
				response.append("<type>"+status.getType()+"</type>");
				response.append("<message>"+status.getDescription()+"</message>");
				response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
		}
		else{
			response.append("<status>");
			response.append("<type>"+status.getType()+"</type>");
			response.append("<message>"+status.getDescription()+"</message>");
			response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
			
			response.append("<transaction>");
			response.append("<type>"+transactionType+"</type>");
			response.append("<sessionid>"+sessionId+"</sessionid>");
			response.append("</transaction>");
			
			if(lstInvestmentType!=null){
				response.append("<investmenttypes>");
				for (InvestmentType investmentType : lstInvestmentType) {
					response.append("<investmenttype>");
						response.append("<InvestmentType>"+ investmentType.getInvestmentType() +"</InvestmentType>");
						response.append("<InvestmentDesc>"+ investmentType.getInvestmentDesc() +"</InvestmentDesc>");
						response.append("<InvestmentCode>"+ investmentType.getInvestmentCode() +"</InvestmentCode>");
						response.append("<LastUserCode>"+ DateUtil.handleString(investmentType.getLastUserCode()) +"</LastUserCode>");
						try{
							response.append("<LastUpdate>"+ sdf.format(investmentType.getLastUpdate()) +"</LastUpdate>");
						}
						catch(Exception e){
							response.append("<LastUpdate></LastUpdate>");
						}
					response.append("</investmenttype>");
				}
				response.append("</investmenttypes>");
			}

		}
		response.append("</serviceresponse>");
		return response.toString();
	}

}
