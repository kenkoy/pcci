package com.pcci.idls.maintenance.investmenttype.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IMA_Trust_Investments")
public class InvestmentType {
	@Id
    @Column(name = "InvestmentType", nullable = false)
    private String investmentType;

    @Column(name = "InvestmentDesc", nullable = false)
    private String investmentDesc;

    @Column(name = "InvestmentCode", nullable = false)
    private String investmentCode;

    @Column(name = "lastUserCode", nullable = false)
    private String lastUserCode;

    @Column(name = "LastUpdate", nullable = false)
    private Date lastUpdate;

    public InvestmentType() {
		// TODO Auto-generated constructor stub
	}

	public InvestmentType(String investmentType, String investmentDesc,
			String investmentCode, String lastUserCode, Date lastUpdate) {
		super();
		this.investmentType = investmentType;
		this.investmentDesc = investmentDesc;
		this.investmentCode = investmentCode;
		this.lastUserCode = lastUserCode;
		this.lastUpdate = lastUpdate;
	}

	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}

	public String getInvestmentDesc() {
		return investmentDesc;
	}

	public void setInvestmentDesc(String investmentDesc) {
		this.investmentDesc = investmentDesc;
	}

	public String getInvestmentCode() {
		return investmentCode;
	}

	public void setInvestmentCode(String investmentCode) {
		this.investmentCode = investmentCode;
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
