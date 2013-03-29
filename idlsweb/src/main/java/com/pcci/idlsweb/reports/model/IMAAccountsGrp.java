package com.pcci.idlsweb.reports.model;

import java.math.BigDecimal;
import java.util.List;

public class IMAAccountsGrp {

	String accountName;
	String accountCode;
	String trxIMAAcctNormalBal;
	List<IMATrxEntries> lstIMATrxEntries;
	BigDecimal totalCredit;
	BigDecimal totalDebit;
	BigDecimal netMovement;
	
	
	public BigDecimal getTotalCredit() {
		return totalCredit;
	}
	public void setTotalCredit(BigDecimal totalCredit) {
		this.totalCredit = totalCredit;
	}
	public BigDecimal getTotalDebit() {
		return totalDebit;
	}
	public void setTotalDebit(BigDecimal totalDebit) {
		this.totalDebit = totalDebit;
	}
	public BigDecimal getNetMovement() {
		return netMovement;
	}
	public void setNetMovement(BigDecimal netMovement) {
		this.netMovement = netMovement;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public List<IMATrxEntries> getLstIMATrxEntries() {
		return lstIMATrxEntries;
	}
	public void setLstIMATrxEntries(List<IMATrxEntries> lstIMATrxEntries) {
		this.lstIMATrxEntries = lstIMATrxEntries;
	}
	public String getTrxIMAAcctNormalBal() {
		return trxIMAAcctNormalBal;
	}
	public void setTrxIMAAcctNormalBal(String trxIMAAcctNormalBal) {
		this.trxIMAAcctNormalBal = trxIMAAcctNormalBal;
	}
	
	
}
