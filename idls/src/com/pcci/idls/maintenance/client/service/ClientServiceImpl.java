package com.pcci.idls.maintenance.client.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pcci.idls.maintenance.client.domain.Client;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;

public class ClientServiceImpl implements ClientService{

	@PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
	public void delete(String ClientId) {
		Client Client = entityManager.find(Client.class, ClientId);
		entityManager.remove(Client);		
	}

    @Transactional(readOnly = true)
	public List<Client> findAll() {
    	Query query = entityManager.createQuery("from Client");
        return query.getResultList();
	}

    @Transactional(readOnly = true)
	public Client findById(String ClientId) {
		return entityManager.find(Client.class, ClientId);
	}

    @Transactional
	public void store(Client Client) {
		entityManager.merge(Client);
	}

    @Transactional
	public List<Client> findByClientName(String clientName) {
		String sql = "SELECT * from IMA_Clients where " +
				" IMA_ClientName like '"+clientName+"%'";
		
		Query query = entityManager.createNativeQuery(sql, Client.class);
		return query.getResultList();
	}
	
}
