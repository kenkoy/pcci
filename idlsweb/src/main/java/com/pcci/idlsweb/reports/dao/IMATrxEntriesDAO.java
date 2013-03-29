package com.pcci.idlsweb.reports.dao;

import java.util.Date;
import java.util.List;

import com.pcci.idlsweb.reports.model.IMAAccountsGrp;
import com.pcci.idlsweb.reports.model.IMATrxEntries;

public interface IMATrxEntriesDAO {
	public List<IMATrxEntries> getIMATrxEntries(String converted, Date startDate, Date endDate, String accountCode);
	public List<IMAAccountsGrp> getIMAAccounts(String converted, Date startDate, Date endDate, String accountCode);
}
