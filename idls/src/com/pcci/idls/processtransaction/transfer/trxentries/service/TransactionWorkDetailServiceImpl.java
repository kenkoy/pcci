package com.pcci.idls.processtransaction.transfer.trxentries.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

public class TransactionWorkDetailServiceImpl implements TransactionWorkDetailService{
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void updateAccrualDate(String strDate, String trxRefNo) {
		String trxType = trxRefNo.substring(0, 3);
		String refNo = trxRefNo.substring(3);
		StringBuilder sql = new StringBuilder("UPDATE [Transaction Work Detail] SET LastAccrualDate  = '"+strDate+"' where [Transaction Type]='"+trxType+"' and [Transaction Number]='"+refNo+"' and LastAccrualDate > '"+strDate+"'");
		Query query = entityManager.createNativeQuery(sql.toString());
		query.executeUpdate();
		
		//To be commented!!!
		updateHistoryAccrualDate(strDate,trxRefNo);
		
	}

	@Transactional
	private void updateHistoryAccrualDate(String strDate, String trxRefNo) {
		String trxType = trxRefNo.substring(0, 3);
		String refNo = trxRefNo.substring(3);
		StringBuilder sql = new StringBuilder("UPDATE [Transaction History Detail] SET LastAccrualDate  = '"+strDate+"' where [Transaction Type]='"+trxType+"' and [Transaction Number]='"+refNo+"' and LastAccrualDate > '"+strDate+"'");
		Query query = entityManager.createNativeQuery(sql.toString());
		query.executeUpdate();
	}
	
//	public static void main(String[] arg){
//		String x = "ima123";
//		String trxType = x.substring(0, 3);
//		String refNo = x.substring(3);
//		
//		System.out.println(trxType);
//		System.out.println(refNo);
//	}
}
