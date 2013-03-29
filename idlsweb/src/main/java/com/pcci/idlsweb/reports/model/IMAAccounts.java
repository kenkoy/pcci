package com.pcci.idlsweb.reports.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "IMA_Accounts")
@Proxy(lazy = true)
public class IMAAccounts {
	@Id
    @Column(name = "IMA_AcctCode", nullable = false)
    private String acctCode;

    @Column(name = "IMA_AcctDesc", nullable = false)
    private String acctDesc;

    @Column(name = "IMA_AcctNormalBal", nullable = false)
    private String acctNormalBalance;

    @Column(name = "IMA_AcctReptName", nullable = false)
    private String acctReptName;

    @Column(name = "IFMS_BasedID", nullable = false)
    private String ifmsBasedId;
    
    @Column(name = "IFMS_BasedName", nullable = false)
    private String ifmsBasedName;
    
    @Column(name = "LastUserCode", nullable = false)
    private String lastUserCode;

    @Column(name = "LastUpdate", nullable = false)
    private Date lastUpdate;
	
//    @OneToMany(mappedBy = "imaAccounts", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<IMATrxEntries> imaTrxEntries = new ArrayList<IMATrxEntries>();
//    
//	public List<IMATrxEntries> getImaTrxEntries() {
//		return imaTrxEntries;
//	}
//
//	public void setImaTrxEntries(List<IMATrxEntries> imaTrxEntries) {
//		this.imaTrxEntries = imaTrxEntries;
//	}

	public IMAAccounts() {
		// TODO Auto-generated constructor stub
	}

	public String getAcctCode() {
		return acctCode;
	}

	public void setAcctCode(String acctCode) {
		this.acctCode = acctCode;
	}

	public String getAcctDesc() {
		return acctDesc;
	}

	public void setAcctDesc(String acctDesc) {
		this.acctDesc = acctDesc;
	}

	public String getAcctNormalBalance() {
		return acctNormalBalance;
	}

	public void setAcctNormalBalance(String acctNormalBalance) {
		this.acctNormalBalance = acctNormalBalance;
	}

	public String getAcctReptName() {
		return acctReptName;
	}

	public void setAcctReptName(String acctReptName) {
		this.acctReptName = acctReptName;
	}

	public String getIfmsBasedId() {
		return ifmsBasedId;
	}

	public void setIfmsBasedId(String ifmsBasedId) {
		this.ifmsBasedId = ifmsBasedId;
	}

	public String getIfmsBasedName() {
		return ifmsBasedName;
	}

	public void setIfmsBasedName(String ifmsBasedName) {
		this.ifmsBasedName = ifmsBasedName;
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

	@Override
	public String toString() {
		return "IMAAccounts [acctCode=" + acctCode + ", acctDesc=" + acctDesc
				+ ", acctNormalBalance=" + acctNormalBalance
				+ ", acctReptName=" + acctReptName + ", ifmsBasedId="
				+ ifmsBasedId + ", ifmsBasedName=" + ifmsBasedName
				+ ", lastUserCode=" + lastUserCode + ", lastUpdate="
				+ lastUpdate + "]";
	}
	
	
}
