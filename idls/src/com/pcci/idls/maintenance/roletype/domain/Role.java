package com.pcci.idls.maintenance.roletype.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class Role {
	
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", length = 10, nullable = false)
    private String id;

    @Column(name = "ROLE_DESCRIPTION", length = 50, nullable = false)
    private String description;

    @Column(name = "EFFECTIVE_DATE", nullable = false)
    private Date effDate;

    @Column(name = "EXPIRY_DATE", nullable = false)
    private Date expDate;

    @Column(name = "LAST_UPDATE", nullable = false)
    private Date lastUpdate;

    @Column(name = "MODIFIED_BY", length = 20, nullable = false)
    private String modifiedBy;
	
	public Role() {}

	public Role(String id, String description, Date effDate, Date expDate,
			Date lastUpdate, String modifiedBy) {
		super();
		this.id = id;
		this.description = description;
		this.effDate = effDate;
		this.expDate = expDate;
		this.lastUpdate = lastUpdate;
		this.modifiedBy = modifiedBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
