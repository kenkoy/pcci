package com.pcci.idls.maintenance.module.service;

import java.util.List;

import com.pcci.idls.maintenance.module.domain.Module;

public interface ModuleService {
    public void store(Module module);
    public void delete(String moduleId);
    public Module findById(String moduleId);
    public List<Module> findAll();
}
