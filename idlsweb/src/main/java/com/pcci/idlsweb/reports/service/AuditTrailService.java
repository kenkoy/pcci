package com.pcci.idlsweb.reports.service;

import java.util.Date;
import java.util.List;

import com.pcci.idlsweb.reports.model.AuditTrail;

public interface AuditTrailService {
	public List<AuditTrail> getListIMATrxEntries(String userId, String module, Date startDate, Date endDate);
}
