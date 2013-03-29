package com.pcci.idlsweb.reports.dao;

import java.util.Date;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.pcci.idlsweb.reports.model.IMAAccounts;

@SuppressWarnings("unchecked")
@RequestScoped
@Component
public class IMAAccountsDAOImpl implements IMAAccountsDAO{
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<IMAAccounts> getIMAAccounts(Date startDate, Date endDate){
		//REPORT PARAMETER IS NOT APPLICABLE WITH IMA ACCOUNTS, START AND END DATE IS MISSING.
//		return entityManager.createQuery("FROM IMAAccounts WHERE trxDate Between :startDate and :endDate")
//				.setParameter("startDate", startDate)
//				.setParameter("endDate", endDate)
//				.getResultList();
//		
		//return (List<IMAAccounts>) entityManager.createNativeQuery("SELECT * FROM test.ima_accounts WHERE test.ima_accounts.IMA_AcctCode in (SELECT test.IMA_TrxEntries.TrxIMA_AcctCode FROM test.IMA_TrxEntries)");
		return entityManager.createQuery("FROM IMAAccounts").getResultList();
		
	}
}
