package com.pcci.idls.maintenance.account.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pcci.idls.maintenance.account.domain.Account;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;

public class AccountServiceImpl implements AccountService{
	@PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
	public void delete(String accountCode) {
    	Account account = entityManager.find(Account.class, accountCode);
		entityManager.remove(account);		
	}

    @Transactional(readOnly = true)
	public List<Account> findAll() {
    	Query query = entityManager.createQuery("from Account order by acctDesc");
        return query.getResultList();
	}

    @Transactional(readOnly = true)
	public Account findById(String accountCode) {
		return entityManager.find(Account.class, accountCode);
	}

    @Transactional
	public void store(Account Account) {
		entityManager.merge(Account);
	}

    @Transactional
	public List<Account> findByAccountDesc(String accountDesc) {
		String sql = "SELECT * from IMA_Accounts where " +
				" IMA_AcctDesc like '"+accountDesc+"%'";
		
		Query query = entityManager.createNativeQuery(sql, Account.class);
		return query.getResultList();
	}
}
