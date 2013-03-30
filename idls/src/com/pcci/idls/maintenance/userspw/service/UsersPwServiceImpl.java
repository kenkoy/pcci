package com.pcci.idls.maintenance.userspw.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pcci.idls.maintenance.userspw.domain.UsersPw;
import com.pcci.idls.maintenance.userspw.domain.UsersPwPK;

public class UsersPwServiceImpl implements UsersPwService{

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;
	
    @Transactional
	public void delete(UsersPwPK pk) {
    	UsersPwPK usersPwPK = entityManager.find(UsersPwPK.class, pk);
		entityManager.remove(usersPwPK);		
	}

    @Transactional(readOnly = true)
	public List<UsersPw> findAll() {
    	Query query = entityManager.createQuery("from UsersPw");
        return query.getResultList();
	}

    @Transactional(readOnly = true)
	public UsersPw findById(UsersPwPK pk) {
		return entityManager.find(UsersPw.class, pk);
	}

    @Transactional
	public void store(UsersPw usersPw) {
		entityManager.merge(usersPw);
	}


}
