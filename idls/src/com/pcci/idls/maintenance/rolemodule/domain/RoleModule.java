package com.pcci.idls.maintenance.rolemodule.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE_MODULE")
public class RoleModule {
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", length = 10, nullable = false)
    private String roleId;

	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODULE_ID", length = 20, nullable = false)
    private String moduleId;
	
    @Column(name = "EFFECTIVE_DATE", nullable = false)
    private Date effDate;

    @Column(name = "EXPIRY_DATE", nullable = false)
    private Date expDate;

    @Column(name = "ACCESS_CREATE", length = 1, nullable = false)
    private String accessCreate;

    @Column(name = "ACCESS_READ", length = 1, nullable = false)
    private String accessRead;
    
    @Column(name = "ACCESS_UPDATE", length = 1, nullable = false)
    private String accessUpdate;

    @Column(name = "ACCESS_DELETE", length = 1, nullable = false)
    private String accessDelete;
    
    @Column(name = "LAST_UPDATE", nullable = false)
    private Date lastUpdate;

    @Column(name = "MODIFIED_BY", length = 20, nullable = false)
    private String modifiedBy;
    
    public RoleModule() {}

	public RoleModule(String roleId, String moduleId, Date effDate,
			Date expDate, String accessCreate, String accessRead,
			String accessUpdate, String accessDelete, Date lastUpdate,
			String modifiedBy) {
		super();
		this.roleId = roleId;
		this.moduleId = moduleId;
		this.effDate = effDate;
		this.expDate = expDate;
		this.accessCreate = accessCreate;
		this.accessRead = accessRead;
		this.accessUpdate = accessUpdate;
		this.accessDelete = accessDelete;
		this.lastUpdate = lastUpdate;
		this.modifiedBy = modifiedBy;
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

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getAccessCreate() {
		return accessCreate;
	}

	public void setAccessCreate(String accessCreate) {
		this.accessCreate = accessCreate;
	}

	public String getAccessRead() {
		return accessRead;
	}

	public void setAccessRead(String accessRead) {
		this.accessRead = accessRead;
	}

	public String getAccessUpdate() {
		return accessUpdate;
	}

	public void setAccessUpdate(String accessUpdate) {
		this.accessUpdate = accessUpdate;
	}

	public String getAccessDelete() {
		return accessDelete;
	}

	public void setAccessDelete(String accessDelete) {
		this.accessDelete = accessDelete;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
