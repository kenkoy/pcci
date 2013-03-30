package com.pcci.idls.maintenance.securitytype.service;

import java.util.List;
import com.pcci.idls.maintenance.securitytype.domain.SecurityType;

public interface SecurityTypeService {
	public void store(SecurityType SecurityType);
    public void delete(String SecurityTypeId);
    public SecurityType findById(String SecurityTypeId);
    public List<SecurityType> findAll();
    public List<SecurityType> findBySecurityTypeDesc(String securityTypeDesc);
}
