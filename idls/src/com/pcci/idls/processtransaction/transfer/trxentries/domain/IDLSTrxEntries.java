package com.pcci.idls.processtransaction.transfer.trxentries.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "IMA_TrxEntries")
public class IDLSTrxEntries {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RN", length=4, nullable = false)
    private int rn;

	@Column(name = "TrxDate")
    private Date TrxDate;

	@Column(name = "TrxRefNo")
    private String TrxRefNo;
	
	@Column(name = "TrxDesc")
    private String TrxDesc;

	@Column(name = "TrxDebit")
	private BigDecimal TrxDebit;

	@Column(name = "TrxCredit")
	private BigDecimal TrxCredit;

	@Column(name = "TrxIMA_XAcctCode")
    private String TrxIMA_XAcctCode;

	@Column(name = "TrxIMA_XAcctNormalBal")
    private String TrxIMA_XAcctNormalBal;
	
	@Column(name = "TrxIMA_AcctCode")
    private String TrxIMA_AcctCode;
	
	@Column(name = "TrxIMA_AcctNormalBal")
    private String TrxIMA_AcctNormalBal;
	
	@Column(name = "TrxJournal")
    private String TrxJournal;

	@Column(name = "TrxTotal")
	private BigDecimal TrxTotal;

	@Column(name = "TrxFrom")
    private String TrxFrom;
	
	@Column(name = "TrxType")
	private String TrxType;

	@Column(name = "Converted")
	private String Converted;
	
	@Column(name = "LastUserCode")
	private String LastUserCode;

	@Column(name = "LastUpdate")
	private Date LastUpdate;
	
	@Column(name = "TrxInvtType")
	private String TrxInvtType;
	
	public IDLSTrxEntries() {
		// TODO Auto-generated constructor stub
	}

	public IDLSTrxEntries(int rn, Date trxDate, String trxRefNo,
			String trxDesc, BigDecimal trxDebit, BigDecimal trxCredit,
			String trxIMAXAcctCode, String trxIMAXAcctNormalBal,
			String trxIMAAcctCode, String trxIMAAcctNormalBal, 
			String trxJournal, BigDecimal trxTotal, String trxFrom, String trxType, String converted,
			String lastUserCode, Date lastUpdate, String trxInvtType) {
		super();
		this.rn = rn;
		TrxDate = trxDate;
		TrxRefNo = trxRefNo;
		TrxDesc = trxDesc;
		TrxDebit = trxDebit;
		TrxCredit = trxCredit;
		TrxIMA_XAcctCode = trxIMAXAcctCode;
		TrxIMA_XAcctNormalBal = trxIMAXAcctNormalBal;
		TrxIMA_AcctCode = trxIMAAcctCode;
		TrxIMA_AcctNormalBal = trxIMAAcctNormalBal;
		TrxJournal = trxJournal;
		TrxTotal = trxTotal;
		TrxFrom = trxFrom;
		TrxType = trxType;
		Converted = converted;
		LastUserCode = lastUserCode;
		LastUpdate = lastUpdate;
		TrxInvtType = trxInvtType;
	}

	public int getRn() {
		return rn;
	}


	public void setRn(int rn) {
		this.rn = rn;
	}

	public Date getTrxDate() {
		return TrxDate;
	}


	public void setTrxDate(Date trxDate) {
		TrxDate = trxDate;
	}


	public String getTrxRefNo() {
		return TrxRefNo;
	}


	public void setTrxRefNo(String trxRefNo) {
		TrxRefNo = trxRefNo;
	}


	public String getTrxDesc() {
		return TrxDesc;
	}


	public void setTrxDesc(String trxDesc) {
		TrxDesc = trxDesc;
	}


	public BigDecimal getTrxDebit() {
		return TrxDebit;
	}


	public void setTrxDebit(BigDecimal trxDebit) {
		TrxDebit = trxDebit;
	}


	public BigDecimal getTrxCredit() {
		return TrxCredit;
	}


	public void setTrxCredit(BigDecimal trxCredit) {
		TrxCredit = trxCredit;
	}


	public String getTrxIMA_XAcctCode() {
		return TrxIMA_XAcctCode;
	}


	public void setTrxIMA_XAcctCode(String trxIMAXAcctCode) {
		TrxIMA_XAcctCode = trxIMAXAcctCode;
	}


	public String getTrxIMA_XAcctNormalBal() {
		return TrxIMA_XAcctNormalBal;
	}


	public void setTrxIMA_XAcctNormalBal(String trxIMAXAcctNormalBal) {
		TrxIMA_XAcctNormalBal = trxIMAXAcctNormalBal;
	}


	public String getTrxIMA_AcctCode() {
		return TrxIMA_AcctCode;
	}


	public void setTrxIMA_AcctCode(String trxIMAAcctCode) {
		TrxIMA_AcctCode = trxIMAAcctCode;
	}


	public String getTrxIMA_AcctNormalBal() {
		return TrxIMA_AcctNormalBal;
	}


	public void setTrxIMA_AcctNormalBal(String trxIMAAcctNormalBal) {
		TrxIMA_AcctNormalBal = trxIMAAcctNormalBal;
	}


	public String getTrxJournal() {
		return TrxJournal;
	}


	public void setTrxJournal(String trxJournal) {
		TrxJournal = trxJournal;
	}


	public BigDecimal getTrxTotal() {
		return TrxTotal;
	}


	public void setTrxTotal(BigDecimal trxTotal) {
		TrxTotal = trxTotal;
	}

	public String getTrxFrom() {
		return TrxFrom;
	}

	public void setTrxFrom(String trxFrom) {
		TrxFrom = trxFrom;
	}
	
	public String getTrxType() {
		return TrxType;
	}

	public void setTrxType(String trxType) {
		TrxType = trxType;
	}

	public void setConverted(String converted) {
		Converted = converted;
	}

	public String getConverted() {
		return Converted;
	}

	public String getLastUserCode() {
		return LastUserCode;
	}

	public void setLastUserCode(String lastUserCode) {
		LastUserCode = lastUserCode;
	}

	public Date getLastUpdate() {
		return LastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		LastUpdate = lastUpdate;
	}

	public String getTrxInvtType() {
		return TrxInvtType;
	}

	public void setTrxInvtType(String trxInvtType) {
		TrxInvtType = trxInvtType;
	}	
	@Override
	public String toString() {
		return "IDLSTrxEntries [Converted=" + Converted + ", TrxCredit="
				+ TrxCredit + ", TrxDate=" + TrxDate + ", TrxDebit=" + TrxDebit
				+ ", TrxDesc=" + TrxDesc + ", TrxFrom=" + TrxFrom
				+ ", TrxIMA_AcctCode=" + TrxIMA_AcctCode
				+ ", TrxIMA_AcctNormalBal=" + TrxIMA_AcctNormalBal
				+ ", TrxIMA_XAcctCode=" + TrxIMA_XAcctCode
				+ ", TrxIMA_XAcctNormalBal=" + TrxIMA_XAcctNormalBal
				+ ", TrxJournal=" + TrxJournal + ", TrxRefNo=" + TrxRefNo
				+ ", TrxTotal=" + TrxTotal + ", TrxType=" + TrxType 
				+ ", rn="+ rn 
				+ ", TrxInvtType=" + TrxInvtType + "]";
	}
	
}
