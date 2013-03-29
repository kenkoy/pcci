package com.pcci.idlsweb.reports.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.pcci.idlsweb.reports.model.AuditTrail;

@SuppressWarnings("unchecked")
@RequestScoped
@Component
public class AuditTrailDAOImpl implements AuditTrailDAO{
	
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<AuditTrail> getAuditTrail(String userId, String module, Date startDate, Date endDate){
		if(module!=null && module.length()>0){
			return entityManager.createQuery("FROM AuditTrail WHERE userId = :userId and module = :module and date Between :startDate and :endDate")
					.setParameter("userId", userId)
					.setParameter("module", module)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate)
					.getResultList();	
		}
		else{
			return entityManager.createQuery("FROM AuditTrail WHERE userId = :userId and date Between :startDate and :endDate")
					.setParameter("userId", userId)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate)
					.getResultList();
		}
		
	}
}
