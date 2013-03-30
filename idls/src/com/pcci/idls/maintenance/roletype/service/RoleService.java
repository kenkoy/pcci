package com.pcci.idls.maintenance.roletype.service;

import java.util.List;

import com.pcci.idls.maintenance.roletype.domain.Role;

public interface RoleService {
	public void store(Role role);
    public void delete(Long roleId);
    public Role findById(Long roleId);
    public List<Role> findAll();
}
