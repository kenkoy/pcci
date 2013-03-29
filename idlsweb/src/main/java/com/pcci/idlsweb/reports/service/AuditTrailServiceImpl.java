package com.pcci.idlsweb.reports.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pcci.idlsweb.reports.dao.AuditTrailDAO;
import com.pcci.idlsweb.reports.model.AuditTrail;

@Component
public class AuditTrailServiceImpl implements AuditTrailService{
	
	@Autowired
	protected AuditTrailDAO auditTrailDAO;
	
	@Override
	public List<AuditTrail> getListIMATrxEntries(String userId, String module, Date startDate, Date endDate) {
		List<AuditTrail> lstAuditTrail = auditTrailDAO.getAuditTrail(userId, module, startDate, endDate);
		System.out.println("AuditTrail Size: "+lstAuditTrail.size());
		return lstAuditTrail;
	}
}
