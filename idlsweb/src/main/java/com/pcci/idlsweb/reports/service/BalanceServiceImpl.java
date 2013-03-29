package com.pcci.idlsweb.reports.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pcci.idlsweb.reports.dao.IMAAccountsDAO;
import com.pcci.idlsweb.reports.model.IMAAccounts;
@Component
public class BalanceServiceImpl implements BalanceService{
	@Autowired
	protected IMAAccountsDAO imaAccountsDAO;
	
	
	@Override
	@Transactional
	public List<IMAAccounts> getListIMAAccounts(Date startDate, Date endDate) {
//		List<IMAAccounts> lstImaAccounts = imaAccountsDAO.getIMAAccounts(startDate, endDate);
//		for (IMAAccounts imaAccounts : lstImaAccounts) {
//			System.out.println("NO. OF IMA TRX ENTRIES INSIDE IMA ACCOUNTS: "+imaAccounts.getImaTrxEntries().size());
//		}
//		System.out.println("lstImaAccounts Size: "+lstImaAccounts.size());
		return null;
	}
}
