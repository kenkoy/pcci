package com.pcci.idlsweb.reports.dao;

import java.util.Date;
import java.util.List;

import com.pcci.idlsweb.reports.model.AuditTrail;

public interface AuditTrailDAO {
	public List<AuditTrail> getAuditTrail(String userId, String module, Date startDate, Date endDate);
}
