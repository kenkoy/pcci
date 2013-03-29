package com.pcci.idlsweb.reports.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.pcci.idlsweb.reports.model.IMAAccountsGrp;
import com.pcci.idlsweb.reports.model.IMATrxEntries;

@SuppressWarnings("unchecked")
@RequestScoped
@Component
public class IMATrxEntriesDAOImpl implements IMATrxEntriesDAO{
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<IMATrxEntries> getIMATrxEntries(String converted, Date startDate, Date endDate, String accountCode) {
		 
		if(converted!=null && converted.length()>0){
			return entityManager.createQuery("FROM IMATrxEntries WHERE converted = :converted and trxDate Between :startDate and :endDate")
				.setParameter("converted", converted)
				.setParameter("startDate", startDate)
				.setParameter("endDate", endDate)
				.getResultList();
		}
		else if(accountCode!=null && accountCode.length()>0){
			return entityManager.createQuery("FROM IMATrxEntries WHERE trxIMAAcctCode = :accountCode and trxDate Between :startDate and :endDate")
					.setParameter("accountCode", accountCode)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate)
					.getResultList();
		}
		else{
			return entityManager.createQuery("FROM IMATrxEntries WHERE trxDate Between :startDate and :endDate")
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate)
					.getResultList();	
		}
		 
	}
	
	@Override
	public List<IMAAccountsGrp> getIMAAccounts(String converted, Date startDate, Date endDate, String accountCode) {
		List<IMAAccountsGrp> lstAccountGrp = new ArrayList<IMAAccountsGrp>();
		List<IMATrxEntries> lstIMATrxEntries = getIMATrxEntries(converted, startDate, endDate, accountCode);
		LinkedHashSet<String> hsAccounts = new LinkedHashSet<String>();
		for (IMATrxEntries account : lstIMATrxEntries) {
			hsAccounts.add(account.getTrxIMAAcctCode());
		}
		
		for (String account : hsAccounts) {
			IMAAccountsGrp imaAccountGroup = new IMAAccountsGrp();
			List<IMATrxEntries> lstEntries = new ArrayList<IMATrxEntries>();
			BigDecimal totalCredit = new BigDecimal(0);
			BigDecimal totalDebit = new BigDecimal(0);
			BigDecimal netMovement = new BigDecimal(0);
			for (IMATrxEntries entry : lstIMATrxEntries) {
				if(account.equalsIgnoreCase(entry.getTrxIMAAcctCode())){
					lstEntries.add(entry);
					if(entry!=null && entry.getTrxDebit()!=null && (entry.getTrxDebit().compareTo(BigDecimal.ZERO))>0){
						totalDebit = totalDebit.add(entry.getTrxDebit());
					}
					else{
						totalCredit = totalCredit.add(entry.getTrxCredit());
					}
				}
				
				
			}
			netMovement = totalDebit.subtract(totalCredit);
			imaAccountGroup.setTotalCredit(totalCredit);
			imaAccountGroup.setTotalDebit(totalDebit);
			imaAccountGroup.setNetMovement(netMovement);
			imaAccountGroup.setAccountCode(lstEntries.get(0).getTrxIMAAcctCode());
			imaAccountGroup.setAccountName(lstEntries.get(0).getTrxDesc());
			imaAccountGroup.setLstIMATrxEntries(lstEntries);
			lstAccountGrp.add(imaAccountGroup);
		}
		
		return lstAccountGrp;
	}

}
