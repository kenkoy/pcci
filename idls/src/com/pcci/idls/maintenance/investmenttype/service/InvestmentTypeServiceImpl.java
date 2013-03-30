package com.pcci.idls.maintenance.investmenttype.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pcci.idls.maintenance.investmenttype.domain.InvestmentType;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;

public class InvestmentTypeServiceImpl implements InvestmentTypeService{
	@PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
	public void delete(String type) {
    	InvestmentType investmentType = entityManager.find(InvestmentType.class, type);
		entityManager.remove(investmentType);		
	}

    @Transactional(readOnly = true)
	public List<InvestmentType> findAll() {
    	Query query = entityManager.createQuery("from InvestmentType");
        return query.getResultList();
	}

    @Transactional(readOnly = true)
	public InvestmentType findById(String type) {
		return entityManager.find(InvestmentType.class, type);
	}

    @Transactional
	public void store(InvestmentType investmentType) {
		entityManager.merge(investmentType);
	}

    @Transactional
	public List<InvestmentType> findByInvestmentTypeDesc(String investmentTypeDesc) {
		String sql = "SELECT * from IMA_Trust_Investments where " +
				" InvestmentDesc like '"+investmentTypeDesc+"%'";
		
		Query query = entityManager.createNativeQuery(sql, InvestmentType.class);
		return query.getResultList();
	}
}
