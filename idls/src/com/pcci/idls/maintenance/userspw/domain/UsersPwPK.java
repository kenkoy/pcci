package com.pcci.idls.maintenance.userspw.domain;

import java.util.Date;

public class UsersPwPK {

	private String id;
	private String password;
	private Date lastUpdate;

	public UsersPwPK() {
		// TODO Auto-generated constructor stub
	}

	public UsersPwPK(String id, String password, Date lastUpdate) {
		super();
		this.id = id;
		this.password = password;
		this.lastUpdate = lastUpdate;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof UsersPwPK)) {
			UsersPwPK pk = (UsersPwPK) obj;

			if (!pk.getId().equals(id)) {
				return false;
			}

			if (!pk.getPassword().equals(password)) {
				return false;
			}

			if (!pk.getLastUpdate().equals(lastUpdate)) {
				return false;
			}

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode() + password.hashCode() + lastUpdate.hashCode();
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
