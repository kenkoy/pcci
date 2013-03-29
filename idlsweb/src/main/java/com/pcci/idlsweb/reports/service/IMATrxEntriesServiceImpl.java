package com.pcci.idlsweb.reports.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pcci.idlsweb.reports.dao.IMATrxEntriesDAO;
import com.pcci.idlsweb.reports.model.IMAAccountsGrp;
import com.pcci.idlsweb.reports.model.IMATrxEntries;

@Component
public class IMATrxEntriesServiceImpl implements IMATrxEntriesService{
	@Autowired
	IMATrxEntriesDAO imaTrxEntriesDAO;
	
	@Override
	public List<IMATrxEntries> getListIMATrxEntries(String converted, Date startDate, Date endDate, String accountCode) {
		List<IMATrxEntries> lst = imaTrxEntriesDAO.getIMATrxEntries(converted, startDate, endDate, accountCode);
		System.out.println(lst.size());
		return lst;
	}
	
	@Override
	public List<IMAAccountsGrp> getListIMAAccounts(String converted, Date startDate, Date endDate, String accountCode) {
		List<IMAAccountsGrp> lst = imaTrxEntriesDAO.getIMAAccounts(converted, startDate, endDate, accountCode);
		System.out.println(lst.size());
		return lst;
	}
}
