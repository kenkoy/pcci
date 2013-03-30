package com.pcci.idls.util;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.pcci.idls.maintenance.account.jaxbmodel.AccountServiceModel;
import com.pcci.idls.maintenance.account.jaxbmodel.AccountServicerequest;
import com.pcci.idls.maintenance.client.jaxbmodel.ClientServiceModel;
import com.pcci.idls.maintenance.client.jaxbmodel.ClientServicerequest;
import com.pcci.idls.maintenance.investmenttype.jaxbmodel.InvestmentTypeServiceModel;
import com.pcci.idls.maintenance.investmenttype.jaxbmodel.InvestmentTypeServicerequest;
import com.pcci.idls.maintenance.module.jaxbmodel.JBOModule;
import com.pcci.idls.maintenance.module.jaxbmodel.ModuleServicerequest;
import com.pcci.idls.maintenance.rolemodule.jaxbmodel.RoleModuleServiceModel;
import com.pcci.idls.maintenance.rolemodule.jaxbmodel.RoleModuleServicerequest;
import com.pcci.idls.maintenance.securitytype.jaxbmodel.SecurityTypeServiceModel;
import com.pcci.idls.maintenance.securitytype.jaxbmodel.SecurityTypeServicerequest;
import com.pcci.idls.maintenance.users.jaxbmodel.JBOUser;
import com.pcci.idls.maintenance.users.jaxbmodel.UserServicerequest;
import com.pcci.idls.processtransaction.transfer.trxentries.jaxbmodel.IDLSTrxServicerequest;
import com.pcci.idls.processtransaction.transfer.trxentries.jaxbmodel.JBOIDLSTrxEntries;
import com.pcci.idls.security.login.jaxbmodel.JBOUserLogin;
import com.pcci.idls.security.login.jaxbmodel.UserLoginServicerequest;
import com.sun.xml.internal.ws.developer.SchemaValidation;

@SchemaValidation 
public class RequestUnmarshaller {
    private JAXBContext jaxbContext = null;
    private Unmarshaller unmarshaller = null;
    
	public RequestUnmarshaller(String packageName) {
        try {
            jaxbContext = JAXBContext.newInstance(packageName);
            unmarshaller = jaxbContext.createUnmarshaller();
            //unmarshaller.setValidating(true);
        } catch (JAXBException e) {
        }
    }
 
	@SuppressWarnings("unchecked")
    public JBOModule unmarshallModuleRequest(InputStream istrm) {
        try {
            ModuleServicerequest request = (ModuleServicerequest)unmarshaller.unmarshal(istrm);
            if(request!=null){
            	return request.getModule();
            }
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
    public RoleModuleServiceModel unmarshallRoleModuleRequest(InputStream istrm) {
        try {
            RoleModuleServicerequest request = (RoleModuleServicerequest)unmarshaller.unmarshal(istrm);
            if(request!=null){
            	return request.getRoles();
            }
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
    public JBOUser unmarshallUserRequest(InputStream istrm) {
        try {
            UserServicerequest request = (UserServicerequest)unmarshaller.unmarshal(istrm);
            if(request!=null){
            	return request.getUser();
            }
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
    public JBOUserLogin unmarshallUserLoginRequest(InputStream istrm) {
        try {
            UserLoginServicerequest request = (UserLoginServicerequest)unmarshaller.unmarshal(istrm);
            if(request!=null){
            	return request.getUser();
            }
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
    public JBOIDLSTrxEntries unmarshallIDLSTrxRequest(InputStream istrm) {
        try {
        	IDLSTrxServicerequest request = (IDLSTrxServicerequest)unmarshaller.unmarshal(istrm);
            if(request!=null){
            	return request.getIDLSTrxEntries();
            }
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
    public ClientServiceModel unmarshallClientRequest(InputStream istrm) {
        try {
        	ClientServicerequest request = (ClientServicerequest)unmarshaller.unmarshal(istrm);
            if(request!=null){
            	return request.getClientService();
            }
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
    public AccountServiceModel unmarshallAccountRequest(InputStream istrm) {
        try {
        	AccountServicerequest request = (AccountServicerequest)unmarshaller.unmarshal(istrm);
            if(request!=null){
            	return request.getAccountService();
            }
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
    public SecurityTypeServiceModel unmarshallSecurityTypeRequest(InputStream istrm) {
        try {
        	SecurityTypeServicerequest request = (SecurityTypeServicerequest)unmarshaller.unmarshal(istrm);
            if(request!=null){
            	return request.getSecurityTypeService();
            }
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
    public InvestmentTypeServiceModel unmarshallInvestmentTypeRequest(InputStream istrm) {
        try {
        	InvestmentTypeServicerequest request = (InvestmentTypeServicerequest)unmarshaller.unmarshal(istrm);
            if(request!=null){
            	return request.getInvestmentTypeService();
            }
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
