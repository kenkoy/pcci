package com.pcci.idls.maintenance.rolemodule.service;

import java.util.List;

import com.pcci.idls.maintenance.module.domain.Module;
import com.pcci.idls.maintenance.rolemodule.domain.RoleModule;
import com.pcci.idls.maintenance.rolemodule.domain.RoleModulePK;

public interface RoleModuleService {
    public void store(RoleModule roleModule);
    public void delete(String id);
    public RoleModule findById(String id);
    public List<RoleModule> findRoles(String roleId);
    public List<RoleModule> findAll();
}
