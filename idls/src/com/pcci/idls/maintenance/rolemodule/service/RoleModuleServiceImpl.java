package com.pcci.idls.maintenance.rolemodule.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pcci.idls.maintenance.rolemodule.domain.RoleModule;
import com.pcci.idls.maintenance.rolemodule.domain.RoleModulePK;

public class RoleModuleServiceImpl implements RoleModuleService{
	
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;
	
    @Transactional
	public void delete(String id) {
    	RoleModulePK roleModulePk = entityManager.find(RoleModulePK.class, id);
		entityManager.remove(roleModulePk);		
	}

    @Transactional(readOnly = true)
	public List<RoleModule> findAll() {
    	Query query = entityManager.createQuery("from RoleModule");
        return query.getResultList();
	}

    @Transactional(readOnly = true)
	public RoleModule findById(String id) {
		return entityManager.find(RoleModule.class, id);
	}

    @Transactional(readOnly = true)
	public java.util.List<RoleModule> findRoles(String roleId) {
    	Query query = entityManager.createQuery("from RoleModule where ROLE_ID = '"+roleId+"'");
        return query.getResultList();
    }
    
    @Transactional
	public void store(RoleModule roleModule) {
		entityManager.merge(roleModule);
	}

}
