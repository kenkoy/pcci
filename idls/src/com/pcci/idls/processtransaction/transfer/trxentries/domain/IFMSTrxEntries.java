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
@Table(name = "imaTrxEntries")
@IdClass(value=IFMSTrxEntriesPK.class)
public class IFMSTrxEntries {
	/*
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RN")
    private Float rn;
	 */
	
	@Id
	@Column(name = "trxDate")
    private Date TrxDate;
	
	@Id
	@Column(name = "trxRefNo")
    private String TrxRefNo;
	
	@Id
	@Column(name = "trxDesc")
    private String TrxDesc;

	@Id
	@Column(name = "trxType")
    private String TrxType;

	@Id
	@Column(name = "trxDebit")
	private BigDecimal TrxDebit;

	@Id
	@Column(name = "trxCredit")
	private BigDecimal TrxCredit;
	
	/*
	@Column(name = "TrxIMA_XAcctCode", length = 255, nullable = true)
    private String TrxIMA_XAcctCode;

	@Column(name = "TrxIMA_XAcctNormalBal", length = 50, nullable = true)
    private String TrxIMA_XAcctNormalBal;
	 */	
	
	@Column(name = "trxIma_AcctCode")
    private String TrxIMA_AcctCode;
	
	@Column(name = "trxIma_AcctNormalBal")
    private String TrxIMA_AcctNormalBal;
	
	@Column(name = "trxInvtType")
    private String TrxInvtType;
    
	/*
	@Column(name = "TrxJournal", length = 255, nullable = true)
    private String TrxJournal;

	@Column(name = "TrxTotal", nullable = false)
	private BigDecimal TrxTotal;
	 */
	
	/* Commented May 18 2012
	@Column(name = "tableTag")
    private String TableTag;
	*/
	
	


	public IFMSTrxEntries() {
		// TODO Auto-generated constructor stub
	}


	public IFMSTrxEntries(BigDecimal rn, Date trxDate, String trxRefNo,
			String trxDesc, BigDecimal trxDebit, BigDecimal trxCredit,
			String trxIMAXAcctCode, String trxIMAXAcctNormalBal,
			String trxIMAAcctCode, String trxIMAAcctNormalBal,
			String trxJournal, BigDecimal trxTotal, String tableTag, String trxInvtType) {
		super();
		//this.rn = rn;
		TrxDate = trxDate;
		TrxRefNo = trxRefNo;
		TrxDesc = trxDesc;
		TrxDebit = trxDebit;
		TrxCredit = trxCredit;
		//TrxIMA_XAcctCode = trxIMAXAcctCode;
		//TrxIMA_XAcctNormalBal = trxIMAXAcctNormalBal;
		TrxIMA_AcctCode = trxIMAAcctCode;
		TrxIMA_AcctNormalBal = trxIMAAcctNormalBal;
		//TrxJournal = trxJournal;
		//TrxTotal = trxTotal;
		//TableTag = tableTag;
		TrxInvtType = trxInvtType;
	}

/*
	public BigDecimal getRn() {
		return rn;
	}


	public void setRn(BigDecimal rn) {
		this.rn = rn;
	}
*/

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

	public String getTrxType() {
		return TrxType;
	}

	public void setTrxType(String trxType) {
		TrxType = trxType;
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

/*
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
*/

	public String getTrxIMA_AcctCode() {
		System.out.println("TrxIMA_AcctCode: "+TrxIMA_AcctCode);
		return TrxIMA_AcctCode;
	}


	public void setTrxIMA_AcctCode(String trxIMAAcctCode) {
		if(trxIMAAcctCode!=null){
			TrxIMA_AcctCode = trxIMAAcctCode;
		}
		else{
			TrxIMA_AcctCode = "NULL";
		}
	}


	public String getTrxIMA_AcctNormalBal() {
		System.out.println("TrxIMA_AcctNormalBal: "+TrxIMA_AcctNormalBal);
		return TrxIMA_AcctNormalBal;
	}


	public void setTrxIMA_AcctNormalBal(String trxIMAAcctNormalBal) {
		if(trxIMAAcctNormalBal!=null){
			TrxIMA_AcctNormalBal = trxIMAAcctNormalBal;
		}
		else{
			TrxIMA_AcctNormalBal = "NULL";
		}
		
	}

	

	
	/* Commented May 12
	public void setTableTag(String tableTag) {
		TableTag = tableTag;
	}
	 

	public String getTableTag() {
		return TableTag;
	}
*/
/*
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
*/
	
	public String getTrxInvtType() {
		return TrxInvtType;
	}


	public void setTrxInvtType(String trxInvtType) {
		TrxInvtType = trxInvtType;
	}
}
