package com.pcci.idls.processtransaction.transfer.trxentries.service;

import java.sql.SQLException;
import java.util.List;

import com.pcci.idls.processtransaction.transfer.trxentries.domain.IFMSTrxEntries;

public interface IFMSTrxEntriesService {
	//public void store(IFMSTrxEntries idlsTrxEntries);
    //public void delete(IFMSTrxEntriesPK pk);
    //public IDLSTrxEntries findById(IFMSTrxEntriesPK pk);
    public List<IFMSTrxEntries> findAll();
    public List<IFMSTrxEntries> findByDateRange(String from, String to) throws SQLException;
}
