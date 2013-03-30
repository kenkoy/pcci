package com.pcci.idls.processtransaction.transfer.trxentries.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction Approvals History")
public class TransactionApprovalsHistory {
	
	@Id
	@Column(name = "RN", length=4, nullable = false)
    private int rn;

	@Column(name = "xIdls")
    private int xIdls;
	
	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}
	
	public int getxIdls() {
		return xIdls;
	}
	
	public void setxIdls(int xIdls) {
		this.xIdls = xIdls;
	}
	
	
	/*
	@Column(name = "Module ID")
    private String ModuleID;
	
	@Column(name = "Transaction Type")
    private String TransactionType;
	
	@Column(name = "Cash Dir")
    private int CashDir;
	
	@Column(name = "Transaction Number")
    private String TransactionNumber;
	
	@Column(name = "Entry Date")
    private Date EntryDate;
	
	@Column(name = "Status")
    private int Status;
	
	@Column(name = "Amount")
    private BigDecimal Amount;
	
	@Column(name = "New Tenor")
    private int NewTenor;
	
	@Column(name = "New Rate")
    private double NewRate;
	
	@Column(name = "New Borrower Rate")
    private double NewBorrowerRate;
	
	@Column(name = "New Principal")
    private BigDecimal NewPrincipal;
	
	@Column(name = "Applicable Spread")
    private double ApplicableSpread;
	
	@Column(name = "Next Rep Date")
    private Date NextRepDate;
	
	@Column(name = "Roll Over Type")
    private int RollOverType;
	
	@Column(name = "Additional Option")
    private int AdditionalOption;
	
	@Column(name = "Withdrawal Fee Rate")
    private double WithdrawalFeeRate;
	
	@Column(name = "Withdrawal Fee")
    private BigDecimal WithdrawalFee;
	
	@Column(name = "NOUP")
    private int NOUP;
	
	@Column(name = "Expected Yield")
    private double ExpectedYield;
	
	@Column(name = "Tax Rebate")
    private BigDecimal TaxRebate;
	
	@Column(name = "CR/DR Amount")
    private BigDecimal CRDRAmount;
	
	@Column(name = "CA Number")
    private String CANumber;
	
	@Column(name = "OT Number")
    private String OTNumber;
	
	@Column(name = "LA Number")
    private String LANumber;
	
	@Column(name = "Number of Days")
    private int NumberofDays;
	
	@Column(name = "New Maturity Date")
    private Date NewMaturityDate;
	
	@Column(name = "Change Interest")
    private double ChangeInterest;
	
	@Column(name = "Funder Pay Method")
    private String FunderPayMethod;
	
	@Column(name = "Funder Pay Remarks")
    private String FunderPayRemarks;
	
	@Column(name = "Funder Delivery Method")
    private int FunderDeliveryMethod;
	
	@Column(name = "Funder Bank")
    private String FunderBank;
	
	@Column(name = "Funder Security Disposition")
    private String FunderSecurityDisposition;
	
	@Column(name = "Funder Sec Del Method")
    private int FunderSecDelMethod;
	
	@Column(name = "Borrower Pay Method")
    private String BorrowerPayMethod;
	
	@Column(name = "Borrower Pay Remarks")
    private String BorrowerPayRemarks;
	
	@Column(name = "Borrower Delivery Method")
    private int BorrowerDeliveryMethod;
	
	@Column(name = "Borrower Bank")
    private String BorrowerBank;
	
	@Column(name = "Borrower Security Disposition")
    private String BorrowerSecurityDisposition;
	
	@Column(name = "Borrower Sec Del Method")
    private int BorrowerSecDelMethod;
	
	@Column(name = "Adjustment")
    private String Adjustment;
	
	@Column(name = "Rush")
    private boolean Rush;
	
	@Column(name = "Action")
    private int Action;
	
	@Column(name = "Action Date")
    private Date ActionDate;
	
	@Column(name = "Action By")
    private String ActionBy;
	
	@Column(name = "Funder FAO Amount")
    private BigDecimal FunderFAOAmount;
	
	@Column(name = "Funder Maturity Value")
    private BigDecimal FunderMaturityValue;
	
	@Column(name = "Borrower FAO Amount")
    private BigDecimal BorrowerFAOAmount;
	
	@Column(name = "Borrower Maturity Value")
    private BigDecimal BorrowerMaturityValue;
	
	@Column(name = "Funder Proceeds")
    private BigDecimal FunderProceeds;
	
	@Column(name = "Borrower Proceeds")
    private BigDecimal BorrowerProceeds;
	
	@Column(name = "Accrued Interest/Dividend")
    private BigDecimal AccruedInterestDividend;
	
	@Column(name = "Accr Int/Div Tax")
    private BigDecimal AccrIntDivTax;
	
	@Column(name = "Repricing Value")
    private BigDecimal RepricingValue;
	
	@Column(name = "Borrower Repricing Value")
    private BigDecimal BorrowerRepricingValue;
	
	@Column(name = "Various Clients")
    private int VariousClients;
	
	@Column(name = "Per TO")
    private int PerTO;
	
	@Column(name = "Printed")
    private int Printed;
	
	
	public TransactionApprovalsHistory() {
		// TODO Auto-generated constructor stub
	}

	

	public String getModuleID() {
		return ModuleID;
	}

	public void setModuleID(String moduleID) {
		ModuleID = moduleID;
	}

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}

	public int getCashDir() {
		return CashDir;
	}

	public void setCashDir(int cashDir) {
		CashDir = cashDir;
	}

	public String getTransactionNumber() {
		return TransactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		TransactionNumber = transactionNumber;
	}

	public Date getEntryDate() {
		return EntryDate;
	}

	public void setEntryDate(Date entryDate) {
		EntryDate = entryDate;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}

	public int getNewTenor() {
		return NewTenor;
	}

	public void setNewTenor(int newTenor) {
		NewTenor = newTenor;
	}

	public double getNewRate() {
		return NewRate;
	}

	public void setNewRate(double newRate) {
		NewRate = newRate;
	}

	public double getNewBorrowerRate() {
		return NewBorrowerRate;
	}

	public void setNewBorrowerRate(double newBorrowerRate) {
		NewBorrowerRate = newBorrowerRate;
	}

	public BigDecimal getNewPrincipal() {
		return NewPrincipal;
	}

	public void setNewPrincipal(BigDecimal newPrincipal) {
		NewPrincipal = newPrincipal;
	}

	public double getApplicableSpread() {
		return ApplicableSpread;
	}

	public void setApplicableSpread(double applicableSpread) {
		ApplicableSpread = applicableSpread;
	}

	public Date getNextRepDate() {
		return NextRepDate;
	}

	public void setNextRepDate(Date nextRepDate) {
		NextRepDate = nextRepDate;
	}

	public int getRollOverType() {
		return RollOverType;
	}

	public void setRollOverType(int rollOverType) {
		RollOverType = rollOverType;
	}

	public int getAdditionalOption() {
		return AdditionalOption;
	}

	public void setAdditionalOption(int additionalOption) {
		AdditionalOption = additionalOption;
	}

	public double getWithdrawalFeeRate() {
		return WithdrawalFeeRate;
	}

	public void setWithdrawalFeeRate(double withdrawalFeeRate) {
		WithdrawalFeeRate = withdrawalFeeRate;
	}

	public BigDecimal getWithdrawalFee() {
		return WithdrawalFee;
	}

	public void setWithdrawalFee(BigDecimal withdrawalFee) {
		WithdrawalFee = withdrawalFee;
	}

	public int getNOUP() {
		return NOUP;
	}

	public void setNOUP(int nOUP) {
		NOUP = nOUP;
	}

	public double getExpectedYield() {
		return ExpectedYield;
	}

	public void setExpectedYield(double expectedYield) {
		ExpectedYield = expectedYield;
	}

	public BigDecimal getTaxRebate() {
		return TaxRebate;
	}

	public void setTaxRebate(BigDecimal taxRebate) {
		TaxRebate = taxRebate;
	}

	public BigDecimal getCRDRAmount() {
		return CRDRAmount;
	}

	public void setCRDRAmount(BigDecimal cRDRAmount) {
		CRDRAmount = cRDRAmount;
	}

	public String getCANumber() {
		return CANumber;
	}

	public void setCANumber(String cANumber) {
		CANumber = cANumber;
	}

	public String getOTNumber() {
		return OTNumber;
	}

	public void setOTNumber(String oTNumber) {
		OTNumber = oTNumber;
	}

	public String getLANumber() {
		return LANumber;
	}

	public void setLANumber(String lANumber) {
		LANumber = lANumber;
	}

	public int getNumberofDays() {
		return NumberofDays;
	}

	public void setNumberofDays(int numberofDays) {
		NumberofDays = numberofDays;
	}

	public Date getNewMaturityDate() {
		return NewMaturityDate;
	}

	public void setNewMaturityDate(Date newMaturityDate) {
		NewMaturityDate = newMaturityDate;
	}

	public double getChangeInterest() {
		return ChangeInterest;
	}

	public void setChangeInterest(double changeInterest) {
		ChangeInterest = changeInterest;
	}

	public String getFunderPayMethod() {
		return FunderPayMethod;
	}

	public void setFunderPayMethod(String funderPayMethod) {
		FunderPayMethod = funderPayMethod;
	}

	public String getFunderPayRemarks() {
		return FunderPayRemarks;
	}

	public void setFunderPayRemarks(String funderPayRemarks) {
		FunderPayRemarks = funderPayRemarks;
	}

	public int getFunderDeliveryMethod() {
		return FunderDeliveryMethod;
	}

	public void setFunderDeliveryMethod(int funderDeliveryMethod) {
		FunderDeliveryMethod = funderDeliveryMethod;
	}

	public String getFunderBank() {
		return FunderBank;
	}

	public void setFunderBank(String funderBank) {
		FunderBank = funderBank;
	}

	public String getFunderSecurityDisposition() {
		return FunderSecurityDisposition;
	}

	public void setFunderSecurityDisposition(String funderSecurityDisposition) {
		FunderSecurityDisposition = funderSecurityDisposition;
	}

	public int getFunderSecDelMethod() {
		return FunderSecDelMethod;
	}

	public void setFunderSecDelMethod(int funderSecDelMethod) {
		FunderSecDelMethod = funderSecDelMethod;
	}

	public String getBorrowerPayMethod() {
		return BorrowerPayMethod;
	}

	public void setBorrowerPayMethod(String borrowerPayMethod) {
		BorrowerPayMethod = borrowerPayMethod;
	}

	public String getBorrowerPayRemarks() {
		return BorrowerPayRemarks;
	}

	public void setBorrowerPayRemarks(String borrowerPayRemarks) {
		BorrowerPayRemarks = borrowerPayRemarks;
	}

	public int getBorrowerDeliveryMethod() {
		return BorrowerDeliveryMethod;
	}

	public void setBorrowerDeliveryMethod(int borrowerDeliveryMethod) {
		BorrowerDeliveryMethod = borrowerDeliveryMethod;
	}

	public String getBorrowerBank() {
		return BorrowerBank;
	}

	public void setBorrowerBank(String borrowerBank) {
		BorrowerBank = borrowerBank;
	}

	public String getBorrowerSecurityDisposition() {
		return BorrowerSecurityDisposition;
	}

	public void setBorrowerSecurityDisposition(String borrowerSecurityDisposition) {
		BorrowerSecurityDisposition = borrowerSecurityDisposition;
	}

	public int getBorrowerSecDelMethod() {
		return BorrowerSecDelMethod;
	}

	public void setBorrowerSecDelMethod(int borrowerSecDelMethod) {
		BorrowerSecDelMethod = borrowerSecDelMethod;
	}

	public String getAdjustment() {
		return Adjustment;
	}

	public void setAdjustment(String adjustment) {
		Adjustment = adjustment;
	}

	public boolean isRush() {
		return Rush;
	}

	public void setRush(boolean rush) {
		Rush = rush;
	}

	public int getAction() {
		return Action;
	}

	public void setAction(int action) {
		Action = action;
	}

	public Date getActionDate() {
		return ActionDate;
	}

	public void setActionDate(Date actionDate) {
		ActionDate = actionDate;
	}

	public String getActionBy() {
		return ActionBy;
	}

	public void setActionBy(String actionBy) {
		ActionBy = actionBy;
	}

	public BigDecimal getFunderFAOAmount() {
		return FunderFAOAmount;
	}

	public void setFunderFAOAmount(BigDecimal funderFAOAmount) {
		FunderFAOAmount = funderFAOAmount;
	}

	public BigDecimal getFunderMaturityValue() {
		return FunderMaturityValue;
	}

	public void setFunderMaturityValue(BigDecimal funderMaturityValue) {
		FunderMaturityValue = funderMaturityValue;
	}

	public BigDecimal getBorrowerFAOAmount() {
		return BorrowerFAOAmount;
	}

	public void setBorrowerFAOAmount(BigDecimal borrowerFAOAmount) {
		BorrowerFAOAmount = borrowerFAOAmount;
	}

	public BigDecimal getBorrowerMaturityValue() {
		return BorrowerMaturityValue;
	}

	public void setBorrowerMaturityValue(BigDecimal borrowerMaturityValue) {
		BorrowerMaturityValue = borrowerMaturityValue;
	}

	public BigDecimal getFunderProceeds() {
		return FunderProceeds;
	}

	public void setFunderProceeds(BigDecimal funderProceeds) {
		FunderProceeds = funderProceeds;
	}

	public BigDecimal getBorrowerProceeds() {
		return BorrowerProceeds;
	}

	public void setBorrowerProceeds(BigDecimal borrowerProceeds) {
		BorrowerProceeds = borrowerProceeds;
	}

	public BigDecimal getAccruedInterestDividend() {
		return AccruedInterestDividend;
	}

	public void setAccruedInterestDividend(BigDecimal accruedInterestDividend) {
		AccruedInterestDividend = accruedInterestDividend;
	}

	public BigDecimal getAccrIntDivTax() {
		return AccrIntDivTax;
	}

	public void setAccrIntDivTax(BigDecimal accrIntDivTax) {
		AccrIntDivTax = accrIntDivTax;
	}

	public BigDecimal getRepricingValue() {
		return RepricingValue;
	}

	public void setRepricingValue(BigDecimal repricingValue) {
		RepricingValue = repricingValue;
	}

	public BigDecimal getBorrowerRepricingValue() {
		return BorrowerRepricingValue;
	}

	public void setBorrowerRepricingValue(BigDecimal borrowerRepricingValue) {
		BorrowerRepricingValue = borrowerRepricingValue;
	}

	public int getVariousClients() {
		return VariousClients;
	}

	public void setVariousClients(int variousClients) {
		VariousClients = variousClients;
	}

	public int getPerTO() {
		return PerTO;
	}

	public void setPerTO(int perTO) {
		PerTO = perTO;
	}

	public int getPrinted() {
		return Printed;
	}

	public void setPrinted(int printed) {
		Printed = printed;
	}
*/
	
	
	
}
