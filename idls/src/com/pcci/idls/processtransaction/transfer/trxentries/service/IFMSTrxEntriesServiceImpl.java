package com.pcci.idls.processtransaction.transfer.trxentries.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pcci.idls.processtransaction.transfer.trxentries.domain.IFMSTrxEntries;

public class IFMSTrxEntriesServiceImpl implements IFMSTrxEntriesService {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@PersistenceContext
	private EntityManager entityManager;
	
  	@Transactional
	public List<IFMSTrxEntries> findAll() {
  		Query query = entityManager.createQuery("from IMA_TrxEntries");
  		return query.getResultList();
	}
	
	@Transactional
	public List<IFMSTrxEntries> findByDateRange(String from, String to) throws SQLException{
		//Query query = entityManager.createQuery("from IFMSTrxEntries where TrxDate between '"+from+"' and '"+to+"'");
		Query query = entityManager.createNativeQuery("SELECT * from imaTrxEntries where trxDate between '"+from+"' and '"+to+"'", IFMSTrxEntries.class);
		return query.getResultList();
	}
	/*
  	@Transactional
	public void delete(IDLSTrxEntriesPK pk) {
    	IDLSTrxEntries idlsTrxEntries = entityManager.find(IFMSTrxEntries.class, pk);
    	entityManager.remove(IFMSTrxEntries);
	}
	*/
  
 	/*
  	@Transactional
	public IFMSTrxEntries findById(IFMSTrxEntriesPK pk) {
		return entityManager.find(IFMSTrxEntries.class, pk);
	}
	*/
  
  	/*
  	@Transactional
	public void store(IFMSTrxEntries IFMSTrxEntries) {
		entityManager.merge(IFMSTrxEntries);
		
	}
	*/
	
	/*
	@Override
	public void store(IFMSTrxEntries idlsTrxEntries) {
		// TODO Auto-generated method stub
		
	}
	*/
	
}
