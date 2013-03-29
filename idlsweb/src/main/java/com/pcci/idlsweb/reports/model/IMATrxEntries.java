package com.pcci.idlsweb.reports.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "vIMA_TrxEntries")
@Proxy(lazy = true)
public class IMATrxEntries {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RN", length=4, nullable = false)
    private int rn;

	@Column(name = "TrxDate")
    private Date trxDate;

	@Column(name = "TrxRefNo")
    private String trxRefNo;
	
	@Column(name = "TrxDesc")
    private String trxDesc;

	@Column(name = "TrxDebit")
	private BigDecimal trxDebit;

	@Column(name = "TrxCredit")
	private BigDecimal trxCredit;

	@Column(name = "TrxIMA_XAcctCode")
    private String trxIMAXAcctCode;

	@Column(name = "TrxIMA_XAcctNormalBal")
    private String trxIMAXAcctNormalBal;
	
	@Column(name = "TrxIMA_AcctCode")
    private String trxIMAAcctCode;
	
	@Column(name = "TrxIMA_AcctNormalBal")
    private String trxIMAAcctNormalBal;
	
	@Column(name = "TrxJournal")
    private String trxJournal;

	@Column(name = "TrxTotal")
	private BigDecimal trxTotal;

	@Column(name = "TrxFrom")
    private String trxFrom;
	
	@Column(name = "TrxType")
	private String trxType;

	@Column(name = "Converted")
	private String converted;
	
	@Column(name = "LastUserCode")
	private String lastUserCode;

	@Column(name = "LastUpdate")
	private Date lastUpdate;
	
//	@ManyToOne(optional = false, fetch = FetchType.LAZY)
//	@JoinColumn(name = "IMA_AcctCode")
//	private IMAAccounts imaAccounts;
//	
//	public IMAAccounts getImaAccounts() {
//		return imaAccounts;
//	}
//
//	public void setImaAccounts(IMAAccounts imaAccounts) {
//		this.imaAccounts = imaAccounts;
//	}

	public IMATrxEntries() {
		// TODO Auto-generated constructor stub
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public Date getTrxDate() {
		return trxDate;
	}

	public void setTrxDate(Date trxDate) {
		this.trxDate = trxDate;
	}

	public String getTrxRefNo() {
		return trxRefNo;
	}

	public void setTrxRefNo(String trxRefNo) {
		this.trxRefNo = trxRefNo;
	}

	public String getTrxDesc() {
		return trxDesc;
	}

	public void setTrxDesc(String trxDesc) {
		this.trxDesc = trxDesc;
	}

	public BigDecimal getTrxDebit() {
		return trxDebit;
	}

	public void setTrxDebit(BigDecimal trxDebit) {
		this.trxDebit = trxDebit;
	}

	public BigDecimal getTrxCredit() {
		return trxCredit;
	}

	public void setTrxCredit(BigDecimal trxCredit) {
		this.trxCredit = trxCredit;
	}

	public String getTrxIMAXAcctCode() {
		return trxIMAXAcctCode;
	}

	public void setTrxIMAXAcctCode(String trxIMAXAcctCode) {
		this.trxIMAXAcctCode = trxIMAXAcctCode;
	}

	public String getTrxIMAXAcctNormalBal() {
		return trxIMAXAcctNormalBal;
	}

	public void setTrxIMAXAcctNormalBal(String trxIMAXAcctNormalBal) {
		this.trxIMAXAcctNormalBal = trxIMAXAcctNormalBal;
	}

	public String getTrxIMAAcctCode() {
		return trxIMAAcctCode;
	}

	public void setTrxIMAAcctCode(String trxIMAAcctCode) {
		this.trxIMAAcctCode = trxIMAAcctCode;
	}

	public String getTrxIMAAcctNormalBal() {
		return trxIMAAcctNormalBal;
	}

	public void setTrxIMAAcctNormalBal(String trxIMAAcctNormalBal) {
		this.trxIMAAcctNormalBal = trxIMAAcctNormalBal;
	}

	public String getTrxJournal() {
		return trxJournal;
	}

	public void setTrxJournal(String trxJournal) {
		this.trxJournal = trxJournal;
	}

	public BigDecimal getTrxTotal() {
		return trxTotal;
	}

	public void setTrxTotal(BigDecimal trxTotal) {
		this.trxTotal = trxTotal;
	}

	public String getTrxFrom() {
		return trxFrom;
	}

	public void setTrxFrom(String trxFrom) {
		this.trxFrom = trxFrom;
	}

	public String getTrxType() {
		return trxType;
	}

	public void setTrxType(String trxType) {
		this.trxType = trxType;
	}

	public String getConverted() {
		return converted;
	}

	public void setConverted(String converted) {
		this.converted = converted;
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
		return "IMATrxEntries [rn=" + rn + ", TrxDate=" + trxDate
				+ ", TrxRefNo=" + trxRefNo + ", TrxDesc=" + trxDesc
				+ ", TrxDebit=" + trxDebit + ", TrxCredit=" + trxCredit
				+ ", TrxIMA_XAcctCode=" + trxIMAXAcctCode
				+ ", TrxIMA_XAcctNormalBal=" + trxIMAXAcctNormalBal
				+ ", TrxIMA_AcctCode=" + trxIMAAcctCode
				+ ", TrxIMA_AcctNormalBal=" + trxIMAAcctNormalBal
				+ ", TrxJournal=" + trxJournal + ", TrxTotal=" + trxTotal
				+ ", TrxFrom=" + trxFrom + ", TrxType=" + trxType
				+ ", Converted=" + converted + ", LastUserCode=" + lastUserCode
				+ ", LastUpdate=" + lastUpdate + "]";
	}
	
	
}
