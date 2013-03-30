package com.pcci.idls.processtransaction.transfer.trxentries.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

public class IFMSTrxEntriesPK implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date TrxDate;
    private String TrxRefNo;
    private String TrxDesc;
    private BigDecimal TrxDebit;
    private BigDecimal TrxCredit;
    private String TrxIMA_AcctCode;
    private String TrxIMA_AcctNormalBal;
    
	public IFMSTrxEntriesPK() {
		// TODO Auto-generated constructor stub
	}

    
    @Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IFMSTrxEntriesPK)) {
			IFMSTrxEntriesPK pk = (IFMSTrxEntriesPK) obj;

			if (!pk.getTrxDate().equals(TrxDate)) {
				return false;
			}
			if (!pk.getTrxRefNo().equals(TrxRefNo)) {
				return false;
			}
			if (!pk.getTrxDesc().equals(TrxDesc)) {
				return false;
			}
			if (!pk.getTrxDebit().equals(TrxDebit)) {
				return false;
			}
			if (!pk.getTrxCredit().equals(TrxCredit)) {
				return false;
			}
			if (!pk.getTrxIMA_AcctCode().equals(TrxIMA_AcctCode)) {
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
		+ TrxDebit.hashCode()
		+ TrxCredit.hashCode()
		+ TrxIMA_AcctCode.hashCode()
		+ TrxIMA_AcctNormalBal.hashCode();
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


	public String getTrxIMA_AcctCode() {
		return TrxIMA_AcctCode;
	}


	public void setTrxIMA_AcctCode(String trxIMAAcctCode) {
		TrxIMA_AcctCode = trxIMAAcctCode;
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
	

    public String getTrxIMA_AcctNormalBal() {
		return TrxIMA_AcctNormalBal;
	}


	public void setTrxIMA_AcctNormalBal(String trxIMAAcctNormalBal) {
		TrxIMA_AcctNormalBal = trxIMAAcctNormalBal;
	}

	
}
