package com.pcci.idls.processtransaction.transfer.trxentries.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

public class TransactionApprovalsHistoryServiceImpl implements TransactionApprovalsHistoryService{
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void updateXIDLS(String transNumber, Date entryDate){
		//Fix for imaTrxEntries trxRefNo and Transaction Approvals History Transaction Number mismatch
		String newTransNumber = transNumber.replaceAll("[^\\d]", "");
		StringBuilder sql = new StringBuilder("UPDATE [Transaction Approvals History] SET xIdls = 1 where [Transaction Number]='"+newTransNumber+"' and [Entry Date] = '"+entryDate+"'");
		Query query = entityManager.createNativeQuery(sql.toString());
		query.executeUpdate();
	}
	public static void main(String[] args){
		String x = "abcd123";
		String y = x.replaceAll("[^\\d]", "");
		System.out.println(y);
		int xy = Integer.parseInt(y);
		System.out.println(xy);
		
	}
}
