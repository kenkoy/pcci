package com.pcci.idls.maintenance.userspw.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class UsersPw {

	@Id
	@Column(name = "USER_ID", length = 20, nullable = false)
    private String id;

	@Id
    @Column(name = "PWORD", length = 256, nullable = false)
    private String password;

	@Id
    @Column(name = "LAST_UPDATE", nullable = false)
    private Date lastUpdate;

	public UsersPw() {}
		
	public UsersPw(String id, String password, Date lastUpdate) {
		super();
		this.id = id;
		this.password = password;
		this.lastUpdate = lastUpdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	
	
	
}
