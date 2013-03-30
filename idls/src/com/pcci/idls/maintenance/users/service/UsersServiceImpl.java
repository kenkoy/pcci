package com.pcci.idls.maintenance.users.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pcci.idls.maintenance.users.domain.Users;

public class UsersServiceImpl implements UsersService {
   
	@PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;
	
    @Transactional
	public void delete(String userId) {
		Users user = entityManager.find(Users.class, userId);
		entityManager.remove(user);		
	}

    @Transactional(readOnly = true)
	public List<Users> findAll() {
    	Query query = entityManager.createQuery("from Users");
        return query.getResultList();
	}

    @Transactional(readOnly = true)
	public Users findById(String userId) {
		return entityManager.find(Users.class, userId);
	}

    @Transactional
	public void store(Users user) {
		entityManager.merge(user);
	}
    
    //insert should use entityManager.persist(user)
    
}
