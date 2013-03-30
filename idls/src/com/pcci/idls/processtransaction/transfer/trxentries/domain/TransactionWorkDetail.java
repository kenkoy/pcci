package com.pcci.idls.processtransaction.transfer.trxentries.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction Work Detail")
public class TransactionWorkDetail {
	
	@Id
	@Column(name = "RN", length=4, nullable = false)
    private int rn;
	
	@Column(name = "LastAccrualDate")
    private Date LastAccrualDate;
	
	@Column(name = "Transaction Number")
    private String TransactionNumber;

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public Date getLastAccrualDate() {
		return LastAccrualDate;
	}

	public void setLastAccrualDate(Date lastAccrualDate) {
		LastAccrualDate = lastAccrualDate;
	}

	public String getTransactionNumber() {
		return TransactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		TransactionNumber = transactionNumber;
	}
	
	
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RN", length=4, nullable = false)
    private int rn;

	@Column(name = "Module ID")
    private String ModuleID;
	
	[Book Transaction Number] [varchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Module ID] [varchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Transaction Type] [varchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Cash Dir] [int] NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Transaction Number] [varchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Client ID] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Trade Date] [datetime] NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Value Date] [datetime] NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Status] [int] NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Status Date] [datetime] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[TO Type] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Brokered] [bit] NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Risk] [bit] NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Tenor] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Issuer ID] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Series ID] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Security Type ID] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Rate] [float] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Pretermination Date] [datetime] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Maturity Date] [datetime] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Maturity Value] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Certificates Assigned] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Proceeds] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Principal] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Doc Stamps] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Instructions] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Accrued Interest/Dividend] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Accrued Int/Div Tax] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Premium/Discount] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Prem/Disc Tax] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[NOUP] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[NAUV] [float] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Average Cost] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Remarks] [varchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Required Document] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Req Doc Delayed] [bit] NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[CA Number] [varchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[OT Number] [varchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[LA Number] [varchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Denominator] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[BB Back To Back] [bit] NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[BB Trx Type] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[BB Ref TO] [varchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[BB Rate] [float] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[BB Tenor] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[BB Maturity Date] [datetime] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[BB Maturity Proceeds] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[BB Gain/Loss] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Repricing Tenor] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Repricing Interest Rate] [real] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Last Repricing Date] [datetime] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Repricing Date] [datetime] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Repricing Value] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Pay Interest Sched] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Borrower Repricing Tenor] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Borrower Repricing Interest Rate] [real] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Last Borrower Repricing Date] [datetime] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Borrower Repricing Date] [datetime] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Borrower Repricing Value] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Borrower Pay Interest Sched] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Number of Payments] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Amortization Amount] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[First Pay Date] [datetime] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Frequency] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Interest Rate] [real] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Commission/Amount] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Commission Rate] [real] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Tax Rebate] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Amt CRDR/Transfer Fee] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Funder Pay Method] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Funder Delivery Method] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Funder Bank] [varchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Borrower Pay Method] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Borrower Delivery Method] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Borrower Bank] [varchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Funder Security Disposition] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Funder Sec Del Method] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Borrower Security Disposition] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Borrower Sec Del Method] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Expected Yield] [real] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Modifications] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Created By] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Date Created] [datetime] NOT NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Action] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Action By] [varchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Action Date] [datetime] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Agreement] [int] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[Rate2] [real] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[SeriesBalance] [money] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[BB YTM] [float] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[OrgBBRate] [float] NULL ,
	@Column(name = "Module ID")
    private String ModuleID;
	
	[UploadDate] [datetime] NULL
	@Column(name = "Module ID")
    private String ModuleID;
*/	
}
