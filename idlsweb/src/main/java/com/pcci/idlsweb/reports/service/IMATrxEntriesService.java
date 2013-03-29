package com.pcci.idlsweb.reports.service;

import java.util.Date;
import java.util.List;

import com.pcci.idlsweb.reports.model.IMAAccountsGrp;
import com.pcci.idlsweb.reports.model.IMATrxEntries;

public interface IMATrxEntriesService {
	public List<IMATrxEntries> getListIMATrxEntries(String converted, Date startDate, Date endDate, String accountCode);
	public List<IMAAccountsGrp> getListIMAAccounts(String converted, Date startDate, Date endDate, String accountCode);
}
