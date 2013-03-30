package com.pcci.idls.maintenance.investmenttype.service;

import java.util.List;

import com.pcci.idls.maintenance.investmenttype.domain.InvestmentType;

public interface InvestmentTypeService {
	 public void store(InvestmentType InvestmentType);
	    public void delete(String InvestmentTypeId);
	    public InvestmentType findById(String InvestmentTypeId);
	    public List<InvestmentType> findAll();
	    public List<InvestmentType> findByInvestmentTypeDesc(String investmentTypeDesc);
}
