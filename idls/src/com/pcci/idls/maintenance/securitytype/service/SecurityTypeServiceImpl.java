package com.pcci.idls.maintenance.securitytype.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pcci.idls.maintenance.securitytype.domain.SecurityType;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;

public class SecurityTypeServiceImpl implements SecurityTypeService{
	@PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
	public void delete(String securityTypeId) {
    	SecurityType securityType = entityManager.find(SecurityType.class, securityTypeId);
		entityManager.remove(securityType);		
	}

    @Transactional(readOnly = true)
	public List<SecurityType> findAll() {
    	Query query = entityManager.createQuery("from SecurityType");
        return query.getResultList();
	}

    @Transactional(readOnly = true)
	public SecurityType findById(String securityTypeId) {
		return entityManager.find(SecurityType.class, securityTypeId);
	}

    @Transactional
	public void store(SecurityType securityType) {
		entityManager.merge(securityType);
	}

    @Transactional
	public List<SecurityType> findBySecurityTypeDesc(String securityTypeDesc) {
		String sql = "SELECT * from IMA_SecurityType where " +
				" SecurityDesc like '"+securityTypeDesc+"%'";
		
		Query query = entityManager.createNativeQuery(sql, SecurityType.class);
		return query.getResultList();
	}
}
