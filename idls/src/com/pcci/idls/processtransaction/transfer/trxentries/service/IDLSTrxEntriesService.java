package com.pcci.idls.processtransaction.transfer.trxentries.service;

import java.util.List;

import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntriesPK;

public interface IDLSTrxEntriesService {
	public void store(IDLSTrxEntries idlsTrxEntries);
    public void delete(String rn);
    public void deleteByTrxRefNo(String trxRefNo);
    public IDLSTrxEntries findById(String rn);
    public List<IDLSTrxEntries> findAll();
    public List<IDLSTrxEntries> findByDateRange(String from, String to);
    public List<IDLSTrxEntries> findByDateRangeTrxType(String from, String to, String trxType, String transType);
    public List<IDLSTrxEntries> findByTrxRefNo(String trxRefNo);
    public List<IDLSTrxEntries> findByTrxFrom_TrxType_DateRange(String trxFrom, String trxType, String from, String to, String trxRefNo);
}
