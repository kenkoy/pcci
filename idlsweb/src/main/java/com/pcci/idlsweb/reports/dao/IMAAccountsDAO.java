package com.pcci.idlsweb.reports.dao;

import java.util.Date;
import java.util.List;

import com.pcci.idlsweb.reports.model.IMAAccounts;

public interface IMAAccountsDAO {
	public List<IMAAccounts> getIMAAccounts(Date startDate, Date endDate);
}
