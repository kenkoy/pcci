package com.pcci.idls.maintenance.rolemodule.domain;

import java.io.Serializable;
import java.util.Date;

public class RoleModulePK implements Serializable{
	
	private String roleId;
	private String moduleId;
	private Date effDate;
	
	public RoleModulePK(){}
	
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof RoleModulePK)){
        	RoleModulePK pk = (RoleModulePK) obj;

            if(!pk.getRoleId().equals(roleId)){
                return false;
            }

            if(!pk.getModuleId().equals(moduleId)){
                return false;
            }
            
            if(!pk.getEffDate().equals(effDate)){
                return false;
            }
            
            return true;
        }

        return false;
    }
    
    @Override
    public int hashCode() {
        return roleId.hashCode() + moduleId.hashCode() + effDate.hashCode();
    }
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
    
    
    
    
    
    
    
}
