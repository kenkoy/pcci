package com.pcci.idls.processtransaction.transfer.trxentries.service;

import java.util.Date;

public interface TransactionApprovalsHistoryService {
    public void updateXIDLS(String transNumber, Date entryDate);
}
