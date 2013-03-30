package com.pcci.idls.main.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.xml.rpc.ServiceException;
import javax.xml.rpc.server.ServiceLifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pcci.idls.exception.StatusBean;
import com.pcci.idls.maintenance.rolemodule.domain.RoleModule;
import com.pcci.idls.maintenance.rolemodule.service.RoleModuleService;
import com.pcci.idls.maintenance.users.domain.Users;
import com.pcci.idls.maintenance.users.service.UsersService;
import com.pcci.idls.security.login.jaxbmodel.JBOUserLogin;
import com.pcci.idls.util.PWUtil;
import com.pcci.idls.util.RequestUnmarshaller;

public class LoginService implements ServiceLifecycle {
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
	
	//authenticate
	public String authenticateUser(String request){
		UsersService service = (UsersService)context.getBean("UsersService");
		String response = "";
		
		//unmarshall request
		RequestUnmarshaller rum = new RequestUnmarshaller("com.pcci.idls.security.login.jaxbmodel");
		InputStream istrm = toInputStream(request);
		JBOUserLogin jboUserLogin = rum.unmarshallUserLoginRequest(istrm);
		StatusBean status = null;
		
		//perform initial validation
		if(jboUserLogin.getUserid()==null
				||jboUserLogin.getUserid().length()<1
				||jboUserLogin.getPassword()==null
				||jboUserLogin.getPassword().length()<1){
			status = new StatusBean("ERROR","Please enter your Username and Password to access the site.","LOG-01");
			System.out.println("Login failed, user does not exist");
			response = createXMLResponse(null, "no session id", "Login", status);
			return response;
		}
		
		
		//query user by userid
		Users user = service.findById(jboUserLogin.getUserid());
		Boolean isAuthenticated = false;
		if(user==null){
			status = new StatusBean("ERROR","Login failed, invalid user credentials","LOG-02");
			System.out.println("Login failed, user does not exist");
			response = createXMLResponse(null, "no session id", "Login", status);
			return response;
		}
		else{
			isAuthenticated = PWUtil.isPasswordValid(user.getPassword(), jboUserLogin.getPassword());
		}
		
		if(isAuthenticated){
			status = new StatusBean("SUCCESS","Successful login.","");
			System.out.println("Successful login.");
			response = createXMLResponse(user, "no session id", "Login", status);
		}else{
			status = new StatusBean("ERROR","Login failed, invalid user credentials","LOG-02");
			System.out.println("Login failed, invalid user credentials");
			response = createXMLResponse(null, "no session id", "Login", status);
		}
		
		
		return response;
	}
	
	private String createXMLResponse(Users user, String sessionId, String transactionType, StatusBean status){
		StringBuffer response = new StringBuffer();
		response.append("<serviceresponse>");
		if(status.getType().equalsIgnoreCase("ERROR") && user==null){
			response.append("<status>");
				response.append("<type>"+status.getType()+"</type>");
				response.append("<message>"+status.getDescription()+"</message>");
				response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
		}
		else{
			
			String roleId = user.getRoleId();
			response.append("<status>");
			response.append("<type>"+status.getType()+"</type>");
			response.append("<message>"+status.getDescription()+"</message>");
			response.append("<code>"+status.getCode()+"</code>");
			response.append("</status>");
			
			response.append("<transaction>");
			response.append("<type>"+transactionType+"</type>");
			response.append("<sessionid>"+sessionId+"</sessionid>");
			response.append("</transaction>");

			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
			response.append("<user>");
			response.append("<userid>"+user.getId()+"</userid>");
			response.append("<roleid>"+roleId+"</roleid>");
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
			//get role module based on role id
			RoleModuleService roleModuleService = (RoleModuleService)context.getBean("RoleModuleService");
			List <RoleModule> lstRoles = roleModuleService.findRoles(roleId.toUpperCase());
			
			response.append("<modules>");
			for (RoleModule roleModule : lstRoles) {
				response.append("<module>"); 
				response.append("<moduleId>"+roleModule.getModuleId()+"</moduleId> ");
				response.append("<accessCreate>"+roleModule.getAccessCreate()+"</accessCreate> ");
				response.append("<accessRead>"+roleModule.getAccessRead()+"</accessRead> ");
				response.append("<accessUpdate>"+roleModule.getAccessUpdate()+"</accessUpdate> ");
				response.append("<accessDelete>"+roleModule.getAccessDelete()+"</accessDelete> ");
				response.append("</module>");
			}
			response.append("</modules>");
			
			
		}
		
		response.append("</serviceresponse>");
		return response.toString();
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
}
