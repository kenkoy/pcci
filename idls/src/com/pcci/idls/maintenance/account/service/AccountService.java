package com.pcci.idls.maintenance.account.service;

import java.util.List;

import com.pcci.idls.maintenance.account.domain.Account;

public interface AccountService {
	public void store(Account Account);
    public void delete(String AccountId);
    public Account findById(String AccountId);
    public List<Account> findAll();
    public List<Account> findByAccountDesc(String accountDesc);
}
