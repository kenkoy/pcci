package com.pcci.idlsweb.reports.service;

import java.util.Date;
import java.util.List;

import com.pcci.idlsweb.reports.model.IMAAccounts;

public interface BalanceService {
	public List<IMAAccounts> getListIMAAccounts(Date startDate, Date endDate);
}
