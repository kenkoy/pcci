package com.pcci.idls.maintenance.roletype.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pcci.idls.maintenance.roletype.domain.Role;

public class RoleServiceImpl implements RoleService {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

	@Transactional
	public void delete(Long roleId) {
		Role role = entityManager.find(Role.class, roleId);
		entityManager.remove(role);
		
	}

	@Transactional(readOnly = true)
	public List<Role> findAll() {
		Query query = entityManager.createQuery("from Role");
		return query.getResultList();
	}

	@Transactional(readOnly = true)
	public Role findById(Long roleId) {
		return entityManager.find(Role.class, roleId);
	}

	@Transactional
	public void store(Role role) {
		entityManager.merge(role);
	}
    
    
}
