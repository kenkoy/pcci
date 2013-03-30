package com.pcci.idls.maintenance.module.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pcci.idls.maintenance.module.domain.Module;

public class ModuleServiceImpl implements ModuleService{

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;
	
    @Transactional
	public void delete(String moduleId) {
		Module module = entityManager.find(Module.class, moduleId);
		entityManager.remove(module);		
	}

    @Transactional(readOnly = true)
	public List<Module> findAll() {
    	Query query = entityManager.createQuery("from Module");
        return query.getResultList();
	}

    @Transactional(readOnly = true)
	public Module findById(String moduleId) {
		return entityManager.find(Module.class, moduleId);
	}

    @Transactional
	public void store(Module module) {
		entityManager.merge(module);
	}

}
