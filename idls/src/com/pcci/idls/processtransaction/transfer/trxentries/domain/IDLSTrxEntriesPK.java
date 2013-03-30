package com.pcci.idls.processtransaction.transfer.trxentries.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import com.pcci.idls.maintenance.userspw.domain.UsersPwPK;

public class IDLSTrxEntriesPK implements Serializable{

    private Date TrxDate;

    private String TrxRefNo;
	
    private String TrxDesc;

    //private String TrxIMA_XAcctCode;

	private String TrxIMA_AcctCode;
	
	private BigDecimal TrxDebit;

	private BigDecimal TrxCredit;

	private String TrxIMA_AcctNormalBal;
	
	public IDLSTrxEntriesPK() {
		// TODO Auto-generated constructor stub
	}

	public IDLSTrxEntriesPK(Date trxDate, String trxRefNo, String trxDesc,
			String trxIMAAcctCode, BigDecimal trxDebit, BigDecimal trxCredit, String trxIMA_AcctNormalBal) {
		super();
		TrxDate = trxDate;
		TrxRefNo = trxRefNo;
		TrxDesc = trxDesc;
		TrxIMA_AcctCode = trxIMAAcctCode;
		TrxDebit = trxDebit;
		TrxCredit = trxCredit;
		TrxIMA_AcctNormalBal = trxIMA_AcctNormalBal;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IDLSTrxEntriesPK)) {
			IDLSTrxEntriesPK pk = (IDLSTrxEntriesPK) obj;

			if (!pk.getTrxDate().equals(TrxDate)) {
				return false;
			}

			if (!pk.getTrxRefNo().equals(TrxRefNo)) {
				return false;
			}

			if (!pk.getTrxDesc().equals(TrxDesc)) {
				return false;
			}
			
			/*if (!pk.getTrxIMA_XAcctCode().equals(TrxIMA_XAcctCode)) {
				return false;
			}*/
			
			if (!pk.getTrxIMA_AcctCode().equals(TrxIMA_AcctCode)) {
				return false;
			}
			
			if (!pk.getTrxDebit().equals(TrxDebit)) {
				return false;
			}
			
			if (!pk.getTrxCredit().equals(TrxCredit)) {
				return false;
			}
			
			if (!pk.getTrxIMA_AcctNormalBal().equals(TrxIMA_AcctNormalBal)) {
				return false;
			}
			
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return TrxDate.hashCode() 
		+ TrxRefNo.hashCode() 
		+ TrxDesc.hashCode() 
		+ TrxIMA_AcctCode.hashCode()
		+ TrxDebit.hashCode()
		+ TrxCredit.hashCode()
		+ TrxIMA_AcctNormalBal.hashCode();
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
/*
	public String getTrxIMA_XAcctCode() {
		return TrxIMA_XAcctCode;
	}

	public void setTrxIMA_XAcctCode(String trxIMAXAcctCode) {
		TrxIMA_XAcctCode = trxIMAXAcctCode;
	}
*/
	public String getTrxIMA_AcctCode() {
		return TrxIMA_AcctCode;
	}

	public void setTrxIMA_AcctCode(String trxIMAAcctCode) {
		TrxIMA_AcctCode = trxIMAAcctCode;
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
	
	public String getTrxIMA_AcctNormalBal() {
		return TrxIMA_AcctNormalBal;
	}

	public void setTrxIMA_AcctNormalBal(String trxIMAAcctNormalBal) {
		TrxIMA_AcctNormalBal = trxIMAAcctNormalBal;
	}
	
}
