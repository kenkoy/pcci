package com.pcci.idls.maintenance.securitytype.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IMA_SecurityType")
public class SecurityType {
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RN", length=4, nullable = false)
    private int rn;
	 */
    
	@Id
	@Column(name = "SecurityTypeID", nullable = false)
    private String securityTypeId;

    @Column(name = "SecurityDesc", nullable = false)
    private String securityDesc;

    @Column(name = "InvestmentType", nullable = false)
    private String investmentType;

    @Column(name = "LastUserCode", nullable = false)
    private String lastUserCode;

    @Column(name = "LastUpdate", nullable = false)
    private Date lastUpdate;

    public SecurityType() {
		// TODO Auto-generated constructor stub
	}

	public SecurityType(String securityTypeId, String securityDesc,
			String investmentType, String lastUserCode, Date lastUpdate) {
		super();
		this.securityTypeId = securityTypeId;
		this.securityDesc = securityDesc;
		this.investmentType = investmentType;
		this.lastUserCode = lastUserCode;
		this.lastUpdate = lastUpdate;
	}

	public String getSecurityTypeId() {
		return securityTypeId;
	}

	public void setSecurityTypeId(String securityTypeId) {
		this.securityTypeId = securityTypeId;
	}

	public String getSecurityDesc() {
		return securityDesc;
	}

	public void setSecurityDesc(String securityDesc) {
		this.securityDesc = securityDesc;
	}

	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
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
