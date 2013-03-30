package com.pcci.idls.main.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.ServiceException;
import javax.xml.rpc.server.ServiceLifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pcci.idls.exception.StatusBean;
import com.pcci.idls.maintenance.MaintenanceResponseHandler;
import com.pcci.idls.maintenance.TransactionConst;
import com.pcci.idls.maintenance.account.domain.Account;
import com.pcci.idls.maintenance.account.jaxbmodel.AccountServiceModel;
import com.pcci.idls.maintenance.account.service.AccountService;
import com.pcci.idls.maintenance.client.domain.Client;
import com.pcci.idls.maintenance.client.jaxbmodel.ClientServiceModel;
import com.pcci.idls.maintenance.client.service.ClientService;
import com.pcci.idls.maintenance.investmenttype.domain.InvestmentType;
import com.pcci.idls.maintenance.investmenttype.jaxbmodel.InvestmentTypeServiceModel;
import com.pcci.idls.maintenance.investmenttype.service.InvestmentTypeService;
import com.pcci.idls.maintenance.module.domain.Module;
import com.pcci.idls.maintenance.module.jaxbmodel.JBOModule;
import com.pcci.idls.maintenance.module.service.ModuleService;
import com.pcci.idls.maintenance.rolemodule.domain.RoleModule;
import com.pcci.idls.maintenance.rolemodule.jaxbmodel.RoleModuleServiceModel;
import com.pcci.idls.maintenance.rolemodule.service.RoleModuleService;
import com.pcci.idls.maintenance.securitytype.domain.SecurityType;
import com.pcci.idls.maintenance.securitytype.jaxbmodel.SecurityTypeServiceModel;
import com.pcci.idls.maintenance.securitytype.service.SecurityTypeService;
import com.pcci.idls.maintenance.users.domain.Users;
import com.pcci.idls.maintenance.users.jaxbmodel.JBOUser;
import com.pcci.idls.maintenance.users.service.UsersService;
import com.pcci.idls.maintenance.userspw.domain.UsersPw;
import com.pcci.idls.maintenance.userspw.service.UsersPwService;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;
import com.pcci.idls.processtransaction.transfer.trxentries.jaxbmodel.JBOIDLSTrxEntries;
import com.pcci.idls.processtransaction.transfer.trxentries.jaxbmodel.JBOIDLSTrxEntry;
import com.pcci.idls.processtransaction.transfer.trxentries.service.IDLSTrxEntriesService;
import com.pcci.idls.util.DateUtil;
import com.pcci.idls.util.PWUtil;
import com.pcci.idls.util.RequestUnmarshaller;

public class MaintenanceService implements ServiceLifecycle {
	private static final String timezone= "Asia/Manila";
	private ApplicationContext context = null;

	@Override
	public void init(Object arg0) throws ServiceException {
		// TODO Auto-generated method stub
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	public String getModuleService(String request){
		
		ModuleService service = (ModuleService)context.getBean("ModuleService");
		Module module = new Module();
		
		String response = "";
		
		//unmarshall request
		RequestUnmarshaller rum = new RequestUnmarshaller("com.pcci.idls.maintenance.module.jaxbmodel");
		InputStream istrm = toInputStream(request);
		JBOModule jboModule = rum.unmarshallModuleRequest(istrm);
		
		//identify, validate and process transaction type (create/retrieve/update/delete)
		String transactionType = jboModule.getTransaction().getType();
		if(transactionType.equalsIgnoreCase(TransactionConst.CREATE)){
			
			if(service.findById(jboModule.getId())!=null){
				StatusBean status = new StatusBean("ERROR","Primary key violation","");
				System.out.println("Record already exist");
				response = MaintenanceResponseHandler.createModuleResponse(null, "no session id", transactionType, status);
			}
			else{
				module.setId(jboModule.getId());
				module.setDescription(jboModule.getDescription());
				module.setEffDate(DateUtil.strToDate(null, jboModule.getEffectivedate()));
				module.setExpDate(DateUtil.strToDate(null, jboModule.getExpirydate()));
				module.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				module.setModifiedBy(jboModule.getModifiedby());
				service.store(module);
				StatusBean status = new StatusBean("SUCCESS","CREATE","");
				System.out.println("Record inserted");
				
				List<Module> modules = service.findAll();
				response = MaintenanceResponseHandler.createModuleResponse(modules, "no session id", transactionType, status);
			}
				
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ)){
			List<Module> modules = service.findAll();
			if(modules.size()<1){
				StatusBean status = new StatusBean("ERROR","Record not found","");
				System.out.println("No record found");
				response = MaintenanceResponseHandler.createModuleResponse(null, "no session id", transactionType, status);	
			}
			else{
				StatusBean status = new StatusBean("SUCCESS", modules.size()+" record(s) retrieved","");
				System.out.println(modules.size()+" record(s) retrieved");
				response = MaintenanceResponseHandler.createModuleResponse(modules, "no session id", transactionType, status);	
			}
			
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.DELETE)){
		
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.UPDATE)){
			
		}
		
		return response;
		
	}	
	
	
	public String getRoleModuleService(String request){
		
		RoleModuleService service = (RoleModuleService)context.getBean("RoleModuleService");
		RoleModule roleModule = new RoleModule();
		
		String response = "";
		
		//unmarshall request
		RequestUnmarshaller rum = new RequestUnmarshaller("com.pcci.idls.maintenance.rolemodule.jaxbmodel");
		InputStream istrm = toInputStream(request);
		RoleModuleServiceModel roleModuleModel = rum.unmarshallRoleModuleRequest(istrm);
		
		//identify, validate and process transaction type (create/retrieve/update/delete)
		String transactionType = roleModuleModel.getTransaction().getType();
		if(transactionType.equalsIgnoreCase(TransactionConst.CREATE)){
/*			
			if(service.findById(jboModule.getId())!=null){
				StatusBean status = new StatusBean("ERROR","Primary key violation","");
				System.out.println("Record already exist");
				response = MaintenanceResponseHandler.createRoleModuleResponse(null, "no session id", transactionType, status);
			}
			else{
				module.setRoleId(jboModule.getId());
				//module.setDescription(jboModule.getDescription());
				module.setEffDate(DateUtil.strToDate(null, jboModule.getEffectivedate()));
				module.setExpDate(DateUtil.strToDate(null, jboModule.getExpirydate()));
				module.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				module.setModifiedBy(jboModule.getModifiedby());
				service.store(module);
				StatusBean status = new StatusBean("SUCCESS","CREATE","");
				System.out.println("Record inserted");
				
				List<RoleModule> modules = service.findAll();
				response = MaintenanceResponseHandler.createRoleModuleResponse(modules, "no session id", transactionType, status);
			}
*/				
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ_ALL)){
			List<RoleModule> modules = service.findAll();
			if(modules.size()<1){
				StatusBean status = new StatusBean("ERROR","Record not found","");
				System.out.println("No record found");
				response = MaintenanceResponseHandler.createRoleModuleResponse(null, "no session id", transactionType, status);	
			}
			else{
				StatusBean status = new StatusBean("SUCCESS", modules.size()+" record(s) retrieved","");
				System.out.println(modules.size()+" record(s) retrieved");
				response = MaintenanceResponseHandler.createRoleModuleResponse(modules, "no session id", transactionType, status);	
			}
			
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ)){
			List<RoleModule> modules = service.findRoles(roleModuleModel.getRole().get(0).getId());
			if(modules.size()<1){
				StatusBean status = new StatusBean("ERROR","Record not found","");
				System.out.println("No record found");
				response = MaintenanceResponseHandler.createRoleModuleResponse(null, "no session id", transactionType, status);	
			}
			else{
				StatusBean status = new StatusBean("SUCCESS", modules.size()+" record(s) retrieved","");
				System.out.println(modules.size()+" record(s) retrieved");
				response = MaintenanceResponseHandler.createRoleModuleResponse(modules, "no session id", transactionType, status);	
			}
			
		}

		if(transactionType.equalsIgnoreCase(TransactionConst.DELETE)){
		
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.UPDATE)){
			
		}
		
		return response;
		
	}
	
	public String getUsersService(String request){
		UsersService service = (UsersService)context.getBean("UsersService");
		UsersPwService userPWService = (UsersPwService)context.getBean("UsersPwService");
		String response = "";
	
		//unmarshall request
		RequestUnmarshaller rum = new RequestUnmarshaller("com.pcci.idls.maintenance.users.jaxbmodel");
		InputStream istrm = toInputStream(request);
		JBOUser jboUser = rum.unmarshallUserRequest(istrm);
		
		//identify, validate and process transaction type (create/retrieve/update/delete)
		String transactionType = jboUser.getTransaction().getType();
		if(transactionType.equalsIgnoreCase(TransactionConst.CREATE)){
			Users user = new Users();
			
			//initial validation
			if(jboUser.getUserid()==null
					||jboUser.getUserid().length()<8){
				StatusBean status = new StatusBean("ERROR","The User ID is incorrect.","AU-01");
				System.out.println("AU-01:The User ID is incorrect.");
				response = MaintenanceResponseHandler.createUserResponse(null, "no session id", transactionType, status);
				return response;
			}
			
			//AU-04:The Password is incorrect.
			
			//AU-05:Password and Confirmation didnÕt match.
			
			if(jboUser.getFirstname()==null
					||jboUser.getFirstname().length()<1){
				StatusBean status = new StatusBean("ERROR","First Name must not be blank.","AU-07");
				System.out.println("AU-07:First Name must not be blank.");
				response = MaintenanceResponseHandler.createUserResponse(null, "no session id", transactionType, status);
				return response;
			}
			
			if(jboUser.getLastname()==null
					||jboUser.getLastname().length()<1){
				StatusBean status = new StatusBean("ERROR","Last Name must not be blank.","AU-08");
				System.out.println("AU-08:Last Name must not be blank.");
				response = MaintenanceResponseHandler.createUserResponse(null, "no session id", transactionType, status);
				return response;
			}
			
			if(service.findById(jboUser.getUserid())!=null){
				StatusBean status = new StatusBean("ERROR","The User ID already exists in the system.","AU-02");
				System.out.println("AU-02:The User ID already exists in the system.");
				response = MaintenanceResponseHandler.createUserResponse(null, "no session id", transactionType, status);
				return response;
			}
			
			
			else{
				StatusBean status = new StatusBean("SUCCESS","You have successfully added a user into the system","AU-06");
				System.out.println("AU-06:You have successfully added a user into the system");
				user.setId(jboUser.getUserid());
				
				String encryptedPword = PWUtil.encryptPassword(jboUser.getPword());
				user.setPassword(encryptedPword);
				
				user.setRoleId(jboUser.getRoleid());
				user.setLastName(jboUser.getLastname());
				user.setFirstName(jboUser.getFirstname());
				
				user.setMiddleName(jboUser.getMiddlename());
				user.setEmail(jboUser.getEmail());
				user.setPhone(jboUser.getPhone());
				
				user.setEffDate(DateUtil.strToDate(null, jboUser.getEffectivedate()));
				user.setExpDate(DateUtil.strToDate(null, jboUser.getExpirydate()));
				user.setPwEffDate(DateUtil.strToDate(null, jboUser.getPwordeffectivedate()));
				user.setLastLogOn(DateUtil.strToDate(null, jboUser.getLastlogon()));
				user.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				
				user.setModifiedBy(jboUser.getModifiedby());
				user.setLocked(jboUser.getLocked());
				service.store(user);
				
				//add userpw data
								
				
				List<Users> lstUser = service.findAll();
				response = MaintenanceResponseHandler.createUserResponse(lstUser, "no session id", transactionType, status);
			}
			
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ)){
			String id = jboUser.getUserid();
			Users user = service.findById(id);
			
			if(user == null){
				StatusBean status = new StatusBean("ERROR","Record not found.","");
				System.out.println("Record not found.");
				response = MaintenanceResponseHandler.createUserResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				List<Users> lstUser = new ArrayList();
				lstUser.add(user);
				StatusBean status = new StatusBean("SUCCESS", lstUser.size()+" record(s) retrieved.","");
				System.out.println(lstUser.size()+" record(s) retrieved.");
				response = MaintenanceResponseHandler.createUserResponse(lstUser, "no session id", transactionType, status);
				return response;
			}
			
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ_ALL)){
			List<Users> lstUser = service.findAll();
			if(lstUser.size()<1){
				StatusBean status = new StatusBean("ERROR","Record not found.","");
				System.out.println("Record not found.");
				response = MaintenanceResponseHandler.createUserResponse(lstUser, "no session id", transactionType, status);
				return response;
			}
			else{
				StatusBean status = new StatusBean("SUCCESS", lstUser.size()+" record(s) retrieved.","");
				System.out.println(lstUser.size()+" record(s) retrieved.");
				response = MaintenanceResponseHandler.createUserResponse(lstUser, "no session id", transactionType, status);	
				return response;
			}
			
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.UPDATE)){
			Users userData = service.findById(jboUser.getUserid());
			if(userData==null){
				StatusBean status = new StatusBean("ERROR","User record doesn't exist","");
				System.out.println("User record doesn't exist");
				response = MaintenanceResponseHandler.createUserResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				if(jboUser.getPword()!= null && jboUser.getPword().length()>0 && (jboUser.getPword().equals("********")==false)){
					String encryptedPword = PWUtil.encryptPassword(jboUser.getPword());
					userData.setPassword(encryptedPword);
				}
				
				if(jboUser.getRoleid()!= null && jboUser.getRoleid().length()>0)  
					userData.setRoleId(jboUser.getRoleid());
				
				if(jboUser.getLastname()!= null && jboUser.getLastname().length()>0)  
					userData.setLastName(jboUser.getLastname());
				
				if(jboUser.getFirstname()!= null && jboUser.getFirstname().length()>0)  
					userData.setFirstName(jboUser.getFirstname());
				
				if(jboUser.getMiddlename()!= null && jboUser.getMiddlename().length()>0)  
					userData.setMiddleName(jboUser.getMiddlename());
				
				if(jboUser.getEmail()!= null && jboUser.getEmail().length()>0)  
					userData.setEmail(jboUser.getEmail());
				
				if(jboUser.getPhone()!= null && jboUser.getPhone().length()>0)  
					userData.setPhone(jboUser.getPhone());
				
				if(jboUser.getEffectivedate()!= null && jboUser.getEffectivedate().length()>0)  
					userData.setEffDate(DateUtil.strToDate(null, jboUser.getEffectivedate()));
				
				if(jboUser.getExpirydate()!= null && jboUser.getExpirydate().length()>0)  
					userData.setExpDate(DateUtil.strToDate(null, jboUser.getExpirydate()));
				
				if(jboUser.getPwordeffectivedate()!= null && jboUser.getPwordeffectivedate().length()>0)  
					userData.setPwEffDate(DateUtil.strToDate(null, jboUser.getPwordeffectivedate()));

				userData.setLastLogOn(DateUtil.strToDate(null, jboUser.getLastlogon()));
				userData.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				
				if(jboUser.getModifiedby()!= null && jboUser.getModifiedby().length()>0)  
					userData.setModifiedBy(jboUser.getModifiedby());
				
				userData.setLocked(jboUser.getLocked());
				
				service.store(userData);
				
				//update userpw data
//				UsersPw userpw = new UsersPw();
//				userpw.setId(userData.getId());
//				userpw.setPassword(userData.getPassword());
//				userpw.setLastUpdate(userData.getLastUpdate());
//				userPWService.store(userpw);
				
				
				StatusBean status = new StatusBean("SUCCESS","User record updated","");
				System.out.println("User record updated");
				response = MaintenanceResponseHandler.createUserResponse(null, "no session id", transactionType, status);
				return response;
			}
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.DELETE)){
			Users userData = service.findById(jboUser.getUserid());
			if(userData==null){
				StatusBean status = new StatusBean("ERROR","User record doesn't exist","");
				System.out.println("User record doesn't exist");
				response = MaintenanceResponseHandler.createUserResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				StatusBean status = new StatusBean("SUCCESS","User record deleted","");
				System.out.println("User record deleted");
				service.delete(jboUser.getUserid());
				
				//delete userpw data
				response = MaintenanceResponseHandler.createUserResponse(null, "no session id", transactionType, status);
				return response;
			}
		}
		
		return response;
	}	
	
	public String getIDLSTrxService(String request){
		String response = "";
		IDLSTrxEntriesService idlsService = (IDLSTrxEntriesService)context.getBean("IDLSTrxEntriesService");
		IDLSTrxEntries idlsTrxEntries = null;
		
		//unmarshall request
		RequestUnmarshaller rum = new RequestUnmarshaller("com.pcci.idls.processtransaction.transfer.trxentries.jaxbmodel");
		InputStream istrm = toInputStream(request);
		JBOIDLSTrxEntries jboIDLS = rum.unmarshallIDLSTrxRequest(istrm);
		
		//handle all transaction
		List<JBOIDLSTrxEntry> lstIDLSTrxEntry = jboIDLS.getIDLSTrxEntry();
		System.out.println(lstIDLSTrxEntry.size());
		int recordCreated = 0;
		int recordUpdated = 0;
		int recordDeleted = 0;
		int recordUpdateFailed = 0;
		int recordDeleteFailed = 0;
		
		for(JBOIDLSTrxEntry trxEntry :lstIDLSTrxEntry){
			String transactionType = trxEntry.getTransaction().getType();
			if(transactionType.equalsIgnoreCase(TransactionConst.CREATE)
					||transactionType.equalsIgnoreCase("")){
				idlsTrxEntries = new IDLSTrxEntries();
				idlsTrxEntries.setTrxCredit(strToBigDecimal(trxEntry.getTrxCredit()));
				idlsTrxEntries.setTrxDate(DateUtil.strToDate(null, trxEntry.getTrxDate()));
				idlsTrxEntries.setTrxDebit(strToBigDecimal(trxEntry.getTrxDebit()));
				idlsTrxEntries.setTrxDesc(trxEntry.getTrxDesc());
				idlsTrxEntries.setTrxIMA_AcctCode(trxEntry.getTrxIMAAcctCode());
				idlsTrxEntries.setTrxIMA_AcctNormalBal(trxEntry.getTrxIMAAcctNormalBal());
				idlsTrxEntries.setTrxIMA_XAcctCode(trxEntry.getTrxIMAXAcctCode());
				idlsTrxEntries.setTrxIMA_XAcctNormalBal(trxEntry.getTrxIMAXAcctNormalBal());
				idlsTrxEntries.setTrxJournal(trxEntry.getTrxJournal());
				idlsTrxEntries.setTrxRefNo(trxEntry.getTrxRefNo());
				idlsTrxEntries.setTrxTotal(strToBigDecimal(trxEntry.getTrxTotal()));
				idlsTrxEntries.setTrxFrom(trxEntry.getTrxFrom());
				idlsTrxEntries.setTrxType(trxEntry.getTrxType());
				idlsTrxEntries.setLastUserCode(trxEntry.getTrxLastUserCode());
				idlsTrxEntries.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				idlsTrxEntries.setConverted("0");
				idlsService.store(idlsTrxEntries);
				System.out.println("Record Inserted: "+trxEntry.toString());
				recordCreated++;
			}
			if(transactionType.equalsIgnoreCase(TransactionConst.UPDATE)){
				idlsTrxEntries = idlsService.findById(trxEntry.getRn());
				if(idlsTrxEntries==null){
					StatusBean status = new StatusBean("ERROR","Record doesn't exist","");
					System.out.println("Update failed record doesn't exist: "+trxEntry.toString());
					recordUpdateFailed++;
				}
				else{
					idlsTrxEntries.setTrxCredit(strToBigDecimal(trxEntry.getTrxCredit()));
					idlsTrxEntries.setTrxDate(DateUtil.strToDate(null, trxEntry.getTrxDate()));
					idlsTrxEntries.setTrxDebit(strToBigDecimal(trxEntry.getTrxDebit()));
					idlsTrxEntries.setTrxDesc(trxEntry.getTrxDesc());
					idlsTrxEntries.setTrxIMA_AcctCode(trxEntry.getTrxIMAAcctCode());
					idlsTrxEntries.setTrxIMA_AcctNormalBal(trxEntry.getTrxIMAAcctNormalBal());
					idlsTrxEntries.setTrxIMA_XAcctCode(trxEntry.getTrxIMAXAcctCode());
					idlsTrxEntries.setTrxIMA_XAcctNormalBal(trxEntry.getTrxIMAXAcctNormalBal());
					idlsTrxEntries.setTrxJournal(trxEntry.getTrxJournal());
					idlsTrxEntries.setTrxRefNo(trxEntry.getTrxRefNo());
					idlsTrxEntries.setTrxTotal(strToBigDecimal(trxEntry.getTrxTotal()));
					idlsTrxEntries.setTrxFrom(trxEntry.getTrxFrom());
					idlsTrxEntries.setTrxType(trxEntry.getTrxType());
					idlsTrxEntries.setLastUserCode(trxEntry.getTrxLastUserCode());
					idlsTrxEntries.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
					idlsService.store(idlsTrxEntries);
					System.out.println("Record Updated: "+trxEntry.toString());
					recordUpdated++;
				}
				
			}
			if(transactionType.equalsIgnoreCase(TransactionConst.DELETE)){
				String id = trxEntry.getRn();
				if(idlsService.findById(id)==null){
					StatusBean status = new StatusBean("ERROR","Record not found","");
					System.out.println("Delete failed record doesn't exist: "+trxEntry.toString());
					recordDeleteFailed++;
				}
				else{
					idlsService.delete(id);
					StatusBean status = new StatusBean("SUCCESS","Record deleted","");
					System.out.println("Record Deleted: "+trxEntry.toString());
					recordDeleted++;
				}
			}
			if(transactionType.equalsIgnoreCase(TransactionConst.DELETE_ALL)){
				List<IDLSTrxEntries> lstIdlsTrxEntries = idlsService.findByTrxRefNo(trxEntry.getTrxRefNo());
				if(lstIdlsTrxEntries==null || lstIdlsTrxEntries.size()<1){
					StatusBean status = new StatusBean("ERROR","Record not found","");
					System.out.println("Record not found");
					response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
				}
				else{
					idlsService.deleteByTrxRefNo(trxEntry.getTrxRefNo());
					StatusBean status = new StatusBean("SUCCESS","Record deleted","");
					System.out.println("Record deleted");
					response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
				}
				
				
			}
			if(transactionType.equalsIgnoreCase(TransactionConst.READ)){
				idlsTrxEntries = new IDLSTrxEntries();
				idlsTrxEntries = idlsService.findById(trxEntry.getRn());
				if(idlsTrxEntries == null){
					StatusBean status = new StatusBean("ERROR","Record not found","");
					System.out.println("Record not found");
					response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
					return response;
				}
				else{
					StatusBean status = new StatusBean("SUCCESS","Record found","");
					System.out.println("Record found");
					List<IDLSTrxEntries> lstIdlsTrxEntries = new ArrayList();
					lstIdlsTrxEntries.add(idlsTrxEntries);
					response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(lstIdlsTrxEntries, "no session id", transactionType, status);
					return response;
				}
			}
			if(transactionType.equalsIgnoreCase(TransactionConst.READ_ALL)){
				List<IDLSTrxEntries> lstIdlsTrxEntries = idlsService.findByTrxFrom_TrxType_DateRange(trxEntry.getTrxFrom(), trxEntry.getTrxType(), trxEntry.getTrxStartDate(), trxEntry.getTrxEndDate(), trxEntry.getTrxRefNo());
				if(lstIdlsTrxEntries == null 
						|| lstIdlsTrxEntries.size()<1){
					StatusBean status = new StatusBean("ERROR","Record not found","");
					System.out.println("Record not found");
					response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
					return response;
				}
				else{
					StatusBean status = new StatusBean("SUCCESS","Record found","");
					System.out.println("Record found");
					response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(lstIdlsTrxEntries, "no session id", transactionType, status);
					return response;
				}
			}
		}
		//create response XML for batch delete update create
		String transactionReport = recordCreated+ "record(s) inserted, " +
		recordUpdated+ "record(s) updated, " +
		recordDeleted+ "record(s) deleted, " +
		"failed to update "+recordUpdateFailed+" record(s), "+
		"failed to delete "+recordDeleteFailed+" record(s).";
		
		StatusBean status = new StatusBean("SUCCESS", transactionReport, "TE-01");
		response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", "", status);
		
		//identify, validate and process transaction type (create/retrieve/update/delete)
		/*String transactionType = jboIDLS.getTransaction().getType();
		if(transactionType.equalsIgnoreCase(TransactionConst.CREATE)){
			idlsTrxEntries = new IDLSTrxEntries();
			idlsTrxEntries.setTrxCredit(strToBigDecimal(jboIDLS.getTrxCredit()));
			idlsTrxEntries.setTrxDate(DateUtil.strToDate(null, jboIDLS.getTrxDate()));
			idlsTrxEntries.setTrxDebit(strToBigDecimal(jboIDLS.getTrxDebit()));
			idlsTrxEntries.setTrxDesc(jboIDLS.getTrxDesc());
			idlsTrxEntries.setTrxIMA_AcctCode(jboIDLS.getTrxIMAAcctCode());
			idlsTrxEntries.setTrxIMA_AcctNormalBal(jboIDLS.getTrxIMAAcctNormalBal());
			idlsTrxEntries.setTrxIMA_XAcctCode(jboIDLS.getTrxIMAXAcctCode());
			idlsTrxEntries.setTrxIMA_XAcctNormalBal(jboIDLS.getTrxIMAXAcctNormalBal());
			idlsTrxEntries.setTrxJournal(jboIDLS.getTrxJournal());
			idlsTrxEntries.setTrxRefNo(jboIDLS.getTrxRefNo());
			idlsTrxEntries.setTrxTotal(strToBigDecimal(jboIDLS.getTrxTotal()));
			idlsTrxEntries.setTrxFrom(jboIDLS.getTrxFrom());
			idlsTrxEntries.setTrxType(jboIDLS.getTrxType());
			idlsService.store(idlsTrxEntries);
			
			StatusBean status = new StatusBean("SUCCESS","The transaction was saved successfully","TE-01");
			System.out.println("TE-01:The transaction was saved successfully");
			response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.UPDATE)){
			idlsTrxEntries = idlsService.findById(jboIDLS.getRN());
			if(idlsTrxEntries==null){
				StatusBean status = new StatusBean("ERROR","Record doesn't exist","");
				System.out.println("Record doesn't exist");
				response = MaintenanceResponseHandler.createUserResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				idlsTrxEntries.setTrxCredit(strToBigDecimal(jboIDLS.getTrxCredit()));
				idlsTrxEntries.setTrxDate(DateUtil.strToDate(null, jboIDLS.getTrxDate()));
				idlsTrxEntries.setTrxDebit(strToBigDecimal(jboIDLS.getTrxDebit()));
				idlsTrxEntries.setTrxDesc(jboIDLS.getTrxDesc());
				idlsTrxEntries.setTrxIMA_AcctCode(jboIDLS.getTrxIMAAcctCode());
				idlsTrxEntries.setTrxIMA_AcctNormalBal(jboIDLS.getTrxIMAAcctNormalBal());
				idlsTrxEntries.setTrxIMA_XAcctCode(jboIDLS.getTrxIMAXAcctCode());
				idlsTrxEntries.setTrxIMA_XAcctNormalBal(jboIDLS.getTrxIMAXAcctNormalBal());
				idlsTrxEntries.setTrxJournal(jboIDLS.getTrxJournal());
				idlsTrxEntries.setTrxRefNo(jboIDLS.getTrxRefNo());
				idlsTrxEntries.setTrxTotal(strToBigDecimal(jboIDLS.getTrxTotal()));
				idlsTrxEntries.setTrxFrom(jboIDLS.getTrxFrom());
				idlsTrxEntries.setTrxType(jboIDLS.getTrxType());
				idlsService.store(idlsTrxEntries);
				
				StatusBean status = new StatusBean("SUCCESS","The transaction was saved successfully","TE-01");
				System.out.println("TE-01:The transaction was saved successfully");
				response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
			}
			
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ)){
			idlsTrxEntries = new IDLSTrxEntries();
			idlsTrxEntries = idlsService.findById(jboIDLS.getRN());
			if(idlsTrxEntries == null){
				StatusBean status = new StatusBean("ERROR","Record not found","");
				System.out.println("Record not found");
				response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
			}
			else{
				StatusBean status = new StatusBean("SUCCESS","Record found","");
				System.out.println("Record found");
				List<IDLSTrxEntries> lstIdlsTrxEntries = new ArrayList();
				lstIdlsTrxEntries.add(idlsTrxEntries);
				response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(lstIdlsTrxEntries, "no session id", transactionType, status);
			}
		}
		if(transactionType.equalsIgnoreCase(TransactionConst.READ_ALL)){
			List<IDLSTrxEntries> lstIdlsTrxEntries = idlsService.findByTrxFrom_TrxType_DateRange(jboIDLS.getTrxFrom(), jboIDLS.getTrxType(), jboIDLS.getTrxStartDate(), jboIDLS.getTrxEndDate(), jboIDLS.getTrxRefNo());
			if(lstIdlsTrxEntries == null 
					|| lstIdlsTrxEntries.size()<1){
				StatusBean status = new StatusBean("ERROR","Record not found","");
				System.out.println("Record not found");
				response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
			}
			else{
				StatusBean status = new StatusBean("SUCCESS","Record found","");
				System.out.println("Record found");
				response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(lstIdlsTrxEntries, "no session id", transactionType, status);
			}
		}				
		if(transactionType.equalsIgnoreCase(TransactionConst.DELETE)){
			String id = jboIDLS.getRN();
			if(idlsService.findById(id)==null){
				StatusBean status = new StatusBean("ERROR","Record not found","");
				System.out.println("Record not found");
				response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
			}
			else{
				idlsService.delete(id);
				StatusBean status = new StatusBean("SUCCESS","Record deleted","");
				System.out.println("Record deleted");
				response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
			}
		}
		if(transactionType.equalsIgnoreCase(TransactionConst.DELETE_ALL)){
			List<IDLSTrxEntries> lstIdlsTrxEntries = idlsService.findByTrxRefNo(jboIDLS.getTrxRefNo());
			if(lstIdlsTrxEntries==null || lstIdlsTrxEntries.size()<1){
				StatusBean status = new StatusBean("ERROR","Record not found","");
				System.out.println("Record not found");
				response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
			}
			else{
				idlsService.deleteByTrxRefNo(jboIDLS.getTrxRefNo());
				StatusBean status = new StatusBean("SUCCESS","Record deleted","");
				System.out.println("Record deleted");
				response = MaintenanceResponseHandler.createIDLSTrxEntriesResponse(null, "no session id", transactionType, status);
			}
			
			
		}*/
		
		return response;
	}
	
	public String getClientService(String request){
		ClientService clientService = (ClientService)context.getBean("ClientService");
		String response = "";
		Client client = null;
		
		//unmarshall request
		RequestUnmarshaller rum = new RequestUnmarshaller("com.pcci.idls.maintenance.client.jaxbmodel");
		InputStream istrm = toInputStream(request);
		ClientServiceModel jboClient = rum.unmarshallClientRequest(istrm);
		
		//identify, validate and process transaction type (create/retrieve/update/delete)
		String transactionType = jboClient.getTransaction().getType();
		if(transactionType.equalsIgnoreCase(TransactionConst.CREATE)){
			//initial validation
			if(clientService.findById(jboClient.getIMAClientID())!=null){
				StatusBean status = new StatusBean("ERROR","The Client ID already exists in the system.","AC-02");
				System.out.println("AC-02:The Client ID already exists in the system.");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				client = new Client();
				
				client.setClientId(jboClient.getIMAClientID());
				client.setClientName(jboClient.getIMAClientName());
				client.setClientCode(jboClient.getIMAClientCode());
				client.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				client.setLastUserCode(jboClient.getLastUserCode());
				clientService.store(client);
			
				StatusBean status = new StatusBean("SUCCESS","The new client was successfully added into the system","AC-04");
				System.out.println("AC-04:The transaction was saved successfully");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			
				
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ_ALL)){
			List<Client> lstClients = clientService.findAll();
			if(lstClients==null||lstClients.size()<1){
				StatusBean status = new StatusBean("ERROR","The Client ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Client ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				StatusBean status = new StatusBean("SUCCESS","Record found.","AC-07");
				System.out.println("AC-07:Record found.");
				response = MaintenanceResponseHandler.createClientServiceResponse(lstClients, "no session id", transactionType, status);
				return response;
			}
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ)){
			String clientName = jboClient.getIMAClientName();
			List<Client> lstClients = clientService.findByClientName(clientName);
			if(lstClients==null||lstClients.size()<1){
				StatusBean status = new StatusBean("ERROR","The Client ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Client ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				StatusBean status = new StatusBean("SUCCESS","Record found.","AC-07");
				System.out.println("AC-07:Record found.");
				response = MaintenanceResponseHandler.createClientServiceResponse(lstClients, "no session id", transactionType, status);
				return response;
			}
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.UPDATE)){
			client = clientService.findById(jboClient.getIMAClientID());
			if(client==null){
				StatusBean status = new StatusBean("ERROR","The Client ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Client ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				client.setClientId(jboClient.getIMAClientID());
				client.setClientName(jboClient.getIMAClientName());
				client.setClientCode(jboClient.getIMAClientCode());
				client.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				client.setLastUserCode(jboClient.getLastUserCode());
				clientService.store(client);
			
				StatusBean status = new StatusBean("SUCCESS","The client was successfully updated","AC-08");
				System.out.println("AC-08:The client was successfully updated");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
		}

		if(transactionType.equalsIgnoreCase(TransactionConst.DELETE)){
			String clientId = jboClient.getIMAClientID();
			client = clientService.findById(clientId);
			if(client==null){
				StatusBean status = new StatusBean("ERROR","The Client ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Client ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				clientService.delete(clientId);
				StatusBean status = new StatusBean("SUCCESS","The client was successfully deleted","AC-09");
				System.out.println("AC-09:The client was successfully deleted");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
		}
		
		return response;
	}

	public String getAccountService(String request){
		AccountService accountService = (AccountService)context.getBean("AccountService");
		String response = "";
		Account account = null;
		
		//unmarshall request
		RequestUnmarshaller rum = new RequestUnmarshaller("com.pcci.idls.maintenance.account.jaxbmodel");
		InputStream istrm = toInputStream(request);
		AccountServiceModel jboAccount = rum.unmarshallAccountRequest(istrm);
		
		//identify, validate and process transaction type (create/retrieve/update/delete)
		String transactionType = jboAccount.getTransaction().getType();
		if(transactionType.equalsIgnoreCase(TransactionConst.CREATE)){
			//initial validation
			if(accountService.findById(jboAccount.getIMAAcctCode())!=null){
				StatusBean status = new StatusBean("ERROR","The Account Code already exists in the system.","AC-02");
				System.out.println("AC-02:The Account Code already exists in the system.");
				response = MaintenanceResponseHandler.createAccountServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				account = new Account();
				
				account.setAcctCode(jboAccount.getIMAAcctCode());
				account.setAcctDesc(jboAccount.getIMAAcctDesc());
				account.setAcctNormalBalance(jboAccount.getIMAAcctNormalBal());
				account.setAcctReptName(jboAccount.getIMAAcctReptName());
				account.setIfmsBasedId(jboAccount.getIFMSBasedID());
				account.setIfmsBasedName(jboAccount.getIFMSBasedName());
				account.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				account.setLastUserCode(jboAccount.getLastUserCode());
				accountService.store(account);
			
				StatusBean status = new StatusBean("SUCCESS","The new account was successfully added into the system","AC-04");
				System.out.println("AC-04:The transaction was saved successfully");
				response = MaintenanceResponseHandler.createAccountServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			
				
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ_ALL)){
			List<Account> lstAccounts = accountService.findAll();
			if(lstAccounts==null||lstAccounts.size()<1){
				StatusBean status = new StatusBean("ERROR","The Account Code doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Account Code doesn't exists in the system.");
				response = MaintenanceResponseHandler.createAccountServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				StatusBean status = new StatusBean("SUCCESS","Record found.","AC-07");
				System.out.println("AC-07:Record found.");
				response = MaintenanceResponseHandler.createAccountServiceResponse(lstAccounts, "no session id", transactionType, status);
				return response;
			}
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ)){
			String accountDesc = jboAccount.getIMAAcctDesc();
			List<Account> lstAccounts = accountService.findByAccountDesc(accountDesc);
			if(lstAccounts==null||lstAccounts.size()<1){
				StatusBean status = new StatusBean("ERROR","The Account Code doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Account Code doesn't exists in the system.");
				response = MaintenanceResponseHandler.createAccountServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				StatusBean status = new StatusBean("SUCCESS","Record found.","AC-07");
				System.out.println("AC-07:Record found.");
				response = MaintenanceResponseHandler.createAccountServiceResponse(lstAccounts, "no session id", transactionType, status);
				return response;
			}
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.UPDATE)){
			account = accountService.findById(jboAccount.getIMAAcctCode());
			if(account==null){
				StatusBean status = new StatusBean("ERROR","The Account Code doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Account Code doesn't exists in the system.");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				account.setAcctCode(jboAccount.getIMAAcctCode());
				account.setAcctDesc(jboAccount.getIMAAcctDesc());
				account.setAcctNormalBalance(jboAccount.getIMAAcctNormalBal());
				account.setAcctReptName(jboAccount.getIMAAcctReptName());
				account.setIfmsBasedId(jboAccount.getIFMSBasedID());
				account.setIfmsBasedName(jboAccount.getIFMSBasedName());
				account.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				account.setLastUserCode(jboAccount.getLastUserCode());
				accountService.store(account);
			
				StatusBean status = new StatusBean("SUCCESS","The account was successfully updated","AC-08");
				System.out.println("AC-08:The account was successfully updated");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
		}

		if(transactionType.equalsIgnoreCase(TransactionConst.DELETE)){
			String accountCode = jboAccount.getIMAAcctCode();
			account = accountService.findById(accountCode);
			if(account==null){
				StatusBean status = new StatusBean("ERROR","The Account Code doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Account Code doesn't exists in the system.");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				accountService.delete(accountCode);
				StatusBean status = new StatusBean("SUCCESS","The account was successfully deleted","AC-09");
				System.out.println("AC-09:The account was successfully deleted");
				response = MaintenanceResponseHandler.createClientServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
		}
		
		return response;
	}
	
	public String getSecurityTypeService(String request){
		SecurityTypeService securityTypeService = (SecurityTypeService)context.getBean("SecurityTypeService");
		String response = "";
		SecurityType securityType = null;
		
		//unmarshall request
		RequestUnmarshaller rum = new RequestUnmarshaller("com.pcci.idls.maintenance.securitytype.jaxbmodel");
		InputStream istrm = toInputStream(request);
		SecurityTypeServiceModel jboSecurityType = rum.unmarshallSecurityTypeRequest(istrm);
		
		//identify, validate and process transaction type (create/retrieve/update/delete)
		String transactionType = jboSecurityType.getTransaction().getType();
		if(transactionType.equalsIgnoreCase(TransactionConst.CREATE)){
			//initial validation
			if(securityTypeService.findById(jboSecurityType.getSecurityTypeID())!=null){
				StatusBean status = new StatusBean("ERROR","The Security Type ID already exists in the system.","AC-02");
				System.out.println("AC-02:The Security Type ID already exists in the system.");
				response = MaintenanceResponseHandler.createSecurityTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				securityType = new SecurityType();
				
				securityType.setSecurityTypeId(jboSecurityType.getSecurityTypeID());
				securityType.setSecurityDesc(jboSecurityType.getSecurityDesc());
				securityType.setInvestmentType(jboSecurityType.getInvestmentType());
				securityType.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				securityType.setLastUserCode(jboSecurityType.getLastUserCode());
				
				securityTypeService.store(securityType);
			
				StatusBean status = new StatusBean("SUCCESS","The new security type was successfully added into the system","AC-04");
				System.out.println("AC-04:The new security type was saved successfully");
				response = MaintenanceResponseHandler.createSecurityTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			
				
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ_ALL)){
			List<SecurityType> lstSecurityType = securityTypeService.findAll();
			if(lstSecurityType==null||lstSecurityType.size()<1){
				StatusBean status = new StatusBean("ERROR","The Security Type ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Security Type ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createSecurityTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				StatusBean status = new StatusBean("SUCCESS","Record found.","AC-07");
				System.out.println("AC-07:Record found.");
				response = MaintenanceResponseHandler.createSecurityTypeServiceResponse(lstSecurityType, "no session id", transactionType, status);
				return response;
			}
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ)){
			String securityDesc = jboSecurityType.getSecurityDesc();
			List<SecurityType> lstSecurityType = securityTypeService.findBySecurityTypeDesc(securityDesc);
			if(lstSecurityType==null||lstSecurityType.size()<1){
				StatusBean status = new StatusBean("ERROR","The Security Type ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Security Type ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createSecurityTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				StatusBean status = new StatusBean("SUCCESS","Record found.","AC-07");
				System.out.println("AC-07:Record found.");
				response = MaintenanceResponseHandler.createSecurityTypeServiceResponse(lstSecurityType, "no session id", transactionType, status);
				return response;
			}
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.UPDATE)){
			securityType = securityTypeService.findById(jboSecurityType.getSecurityTypeID());
			if(securityType==null){
				StatusBean status = new StatusBean("ERROR","The Security Type ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Security Type ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createSecurityTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				securityType.setSecurityTypeId(jboSecurityType.getSecurityTypeID());
				securityType.setSecurityDesc(jboSecurityType.getSecurityDesc());
				securityType.setInvestmentType(jboSecurityType.getInvestmentType());
				securityType.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				securityType.setLastUserCode(jboSecurityType.getLastUserCode());
				securityTypeService.store(securityType);
			
				StatusBean status = new StatusBean("SUCCESS","The security type was successfully updated","AC-08");
				System.out.println("AC-08:The security type was successfully updated");
				response = MaintenanceResponseHandler.createSecurityTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
		}

		if(transactionType.equalsIgnoreCase(TransactionConst.DELETE)){
			String securityTypeId = jboSecurityType.getSecurityTypeID();
			securityType = securityTypeService.findById(securityTypeId);
			if(securityType==null){
				StatusBean status = new StatusBean("ERROR","The Security Type ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Security Type ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createSecurityTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				securityTypeService.delete(securityTypeId);
				StatusBean status = new StatusBean("SUCCESS","The Security Type ID was successfully deleted","AC-09");
				System.out.println("AC-09:The security type was successfully deleted");
				response = MaintenanceResponseHandler.createSecurityTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
		}
		
		return response;
	}
	
	public String getInvestmentTypeService(String request){
		InvestmentTypeService investmentTypeService = (InvestmentTypeService)context.getBean("InvestmentTypeService");
		//SecurityTypeService securityTypeService = (SecurityTypeService)context.getBean("SecurityTypeService");
		String response = "";
		InvestmentType investmentType = null;
		
		//unmarshall request
		RequestUnmarshaller rum = new RequestUnmarshaller("com.pcci.idls.maintenance.investmenttype.jaxbmodel");
		InputStream istrm = toInputStream(request);
		InvestmentTypeServiceModel jboInvestmentType = rum.unmarshallInvestmentTypeRequest(istrm);
		
		//identify, validate and process transaction type (create/retrieve/update/delete)
		String transactionType = jboInvestmentType.getTransaction().getType();
		if(transactionType.equalsIgnoreCase(TransactionConst.CREATE)){
			//initial validation
			if(investmentTypeService.findById(jboInvestmentType.getInvestmentType())!=null){
				StatusBean status = new StatusBean("ERROR","The Investment Type ID already exists in the system.","AC-02");
				System.out.println("AC-02:The Investment Type ID already exists in the system.");
				response = MaintenanceResponseHandler.createInvestmentTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				investmentType = new InvestmentType();
				investmentType.setInvestmentType(jboInvestmentType.getInvestmentType());
				investmentType.setInvestmentDesc(jboInvestmentType.getInvestmentDesc());
				investmentType.setInvestmentCode(jboInvestmentType.getInvestmentCode());
				investmentType.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				investmentType.setLastUserCode(jboInvestmentType.getLastUserCode());
				investmentTypeService.store(investmentType);
			
				StatusBean status = new StatusBean("SUCCESS","The new investment type was successfully added into the system","AC-04");
				System.out.println("AC-04:The new investment type was saved successfully");
				response = MaintenanceResponseHandler.createInvestmentTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
				
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ_ALL)){
			List<InvestmentType> lstInvestmentType = investmentTypeService.findAll();
			if(lstInvestmentType==null||lstInvestmentType.size()<1){
				StatusBean status = new StatusBean("ERROR","The Investment Type ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Investment Type ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createInvestmentTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				StatusBean status = new StatusBean("SUCCESS","Record found.","AC-07");
				System.out.println("AC-07:Record found.");
				response = MaintenanceResponseHandler.createInvestmentTypeServiceResponse(lstInvestmentType, "no session id", transactionType, status);
				return response;
			}
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.READ)){
			String investmentTypeDesc = jboInvestmentType.getInvestmentDesc();
			List<InvestmentType> lstInvestmentType = investmentTypeService.findByInvestmentTypeDesc(investmentTypeDesc);
			if(lstInvestmentType==null||lstInvestmentType.size()<1){
				StatusBean status = new StatusBean("ERROR","The Investment Type ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Investment Type ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createInvestmentTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				StatusBean status = new StatusBean("SUCCESS","Record found.","AC-07");
				System.out.println("AC-07:Record found.");
				response = MaintenanceResponseHandler.createInvestmentTypeServiceResponse(lstInvestmentType, "no session id", transactionType, status);
				return response;
			}
		}
		
		if(transactionType.equalsIgnoreCase(TransactionConst.UPDATE)){
			investmentType = investmentTypeService.findById(jboInvestmentType.getInvestmentType());
			if(investmentType==null){
				StatusBean status = new StatusBean("ERROR","The Investment Type ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Investment Type ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createInvestmentTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				investmentType.setInvestmentType(jboInvestmentType.getInvestmentType());
				investmentType.setInvestmentDesc(jboInvestmentType.getInvestmentDesc());
				investmentType.setInvestmentCode(jboInvestmentType.getInvestmentCode());
				investmentType.setLastUpdate(DateUtil.strToDate(null, DateUtil.getToday(timezone)));
				investmentType.setLastUserCode(jboInvestmentType.getLastUserCode());
				investmentTypeService.store(investmentType);
			
				StatusBean status = new StatusBean("SUCCESS","The investment type was successfully updated","AC-08");
				System.out.println("AC-08:The investment type was successfully updated");
				response = MaintenanceResponseHandler.createInvestmentTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
		}

		if(transactionType.equalsIgnoreCase(TransactionConst.DELETE)){
			String investmentTypeId = jboInvestmentType.getInvestmentType();
			investmentType = investmentTypeService.findById(investmentTypeId);
			if(investmentType==null){
				StatusBean status = new StatusBean("ERROR","The Investment Type ID doesn't exists in the system.","AC-06");
				System.out.println("AC-06:The Investment Type ID doesn't exists in the system.");
				response = MaintenanceResponseHandler.createInvestmentTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
			else{
				investmentTypeService.delete(investmentTypeId);
				StatusBean status = new StatusBean("SUCCESS","The Investment Type ID was successfully deleted","AC-09");
				System.out.println("AC-09:The investment type was successfully deleted");
				response = MaintenanceResponseHandler.createInvestmentTypeServiceResponse(null, "no session id", transactionType, status);
				return response;
			}
		}
		
		return response;
	}
	
	private InputStream toInputStream(String str){
    	byte[] bytes = null;
    	try{
    		bytes = str.getBytes("UTF8");
    	}catch(Exception exc){
    		exc.printStackTrace();
    	}    	
    	return new ByteArrayInputStream(bytes);
    }
	
	private BigDecimal strToBigDecimal(String str){
		try{
			if(str!=null && !str.equalsIgnoreCase("NULL")){
				return new BigDecimal(str);
			}
			else{
				return new BigDecimal("0.0000");
			}
		}
		catch(Exception ex){
			//handle exception here...
			return new BigDecimal("0.0000");
		}
	}

}
