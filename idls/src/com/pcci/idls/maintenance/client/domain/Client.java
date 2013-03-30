package com.pcci.idls.maintenance.client.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "IMA_Clients")
public class Client {
	@Id
    @Column(name = "IMA_ClientID", nullable = false)
    private String clientId;

    @Column(name = "IMA_ClientName", nullable = false)
    private String clientName;

    @Column(name = "IMA_ClientCode", nullable = false)
    private String clientCode;

    @Column(name = "LastUserCode", nullable = false)
    private String lastUserCode;

    @Column(name = "LastUpdate")
    private Date lastUpdate;

	public Client(String clientId, String clientName, String clientCode,
			String lastUserCode, Date lastUpdate) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientCode = clientCode;
		this.lastUserCode = lastUserCode;
		this.lastUpdate = lastUpdate;
	}
	
    public Client() {
		// TODO Auto-generated constructor stub
	}
	
    public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getLastUserCode() {
		return lastUserCode;
	}

	public void setLastUserCode(String lastUserCode) {
		this.lastUserCode = lastUserCode;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
    
}
