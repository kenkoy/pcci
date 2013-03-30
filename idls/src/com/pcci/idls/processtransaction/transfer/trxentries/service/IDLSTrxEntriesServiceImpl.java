package com.pcci.idls.processtransaction.transfer.trxentries.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntriesPK;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IFMSTrxEntries;

public class IDLSTrxEntriesServiceImpl implements IDLSTrxEntriesService {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;
	
    @Transactional
	public void delete(String rowid) {
    	int rn = Integer.parseInt(rowid);
    	IDLSTrxEntries idlsTrxEntries = entityManager.find(IDLSTrxEntries.class, rn);
    	entityManager.remove(idlsTrxEntries);
	}
    
    @Transactional
    public void deleteByTrxRefNo(String trxRefNo){
    	StringBuilder sql = new StringBuilder("DELETE from IMA_TrxEntries  where TrxRefNo='"+trxRefNo+"'");
		
		Query query = entityManager.createNativeQuery(sql.toString(), IDLSTrxEntries.class);
		query.executeUpdate();
    }
    
    @Transactional
	public List<IDLSTrxEntries> findAll() {
    	Query query = entityManager.createQuery("from IMA_TrxEntries");
        return query.getResultList();
    }

    @Transactional
	public IDLSTrxEntries findById(String rowid) {
    	int rn = Integer.parseInt(rowid);
		return entityManager.find(IDLSTrxEntries.class, rn);
	}

    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void store(IDLSTrxEntries idlsTrxEntries) {
		entityManager.merge(idlsTrxEntries);
	}

	@Transactional
	public List<IDLSTrxEntries> findByDateRange(String from, String to) {
		//Query query = entityManager.createQuery("from IFMSTrxEntries where TrxDate between '"+from+"' and '"+to+"'");
		Query query = entityManager.createNativeQuery("SELECT * from IMA_TrxEntries where trxDate between '"+from+"' and '"+to+"'", IDLSTrxEntries.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<IDLSTrxEntries> findByDateRangeTrxType(String from, String to, String trxType, String transType) {
		//Query query = entityManager.createQuery("from IFMSTrxEntries where TrxDate between '"+from+"' and '"+to+"'");
		Query query = entityManager.createNativeQuery("SELECT * from IMA_TrxEntries where TrxRefNo like '"+transType+"%' "
				+" and trxDate between '"
				+from+"' and '"+to
				+"' and TrxType ='"+trxType
				+"' and Converted <> 1", 
				IDLSTrxEntries.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<IDLSTrxEntries> findByTrxFrom_TrxType_DateRange(String trxFrom, String trxType, String from, String to, String trxRefNo) {
		if(from.equalsIgnoreCase("ALL") 
			&& to.equalsIgnoreCase("ALL")){
			from = "01/01/1900";
			to = "01/01/2050";
		}
		
		StringBuilder sql = new StringBuilder("SELECT * from IMA_TrxEntries where trxDate between '"+from+"' and '"+to+"'");
		
		if(!trxFrom.equalsIgnoreCase("ALL")){
			sql.append(" and TrxFrom like '"+trxFrom+"%'");
		}
		if(!trxType.equalsIgnoreCase("ALL")){
			sql.append(" and TrxType like '"+trxType+"%'");
		}
		if(!trxRefNo.equalsIgnoreCase("ALL")){
			sql.append(" and TrxRefNo = '"+trxRefNo+"'");
		}
		sql.append(" order by TrxRefNo, RN");
		
		Query query = entityManager.createNativeQuery(sql.toString(), IDLSTrxEntries.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<IDLSTrxEntries> findByTrxRefNo(String trxRefNo) {
		StringBuilder sql = new StringBuilder("SELECT * from IMA_TrxEntries where TrxRefNo='"+trxRefNo+"'");
		sql.append(" order by TrxRefNo, RN");
		
		Query query = entityManager.createNativeQuery(sql.toString(), IDLSTrxEntries.class);
		return query.getResultList();
	}
}
