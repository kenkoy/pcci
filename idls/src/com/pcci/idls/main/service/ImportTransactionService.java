package com.pcci.idls.main.service;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.server.ServiceLifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pcci.idls.exception.StatusBean;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntriesPK;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IFMSTrxEntries;
import com.pcci.idls.processtransaction.transfer.trxentries.service.IDLSTrxEntriesService;
import com.pcci.idls.processtransaction.transfer.trxentries.service.IFMSTrxEntriesService;
import com.pcci.idls.processtransaction.transfer.trxentries.service.TransactionApprovalsHistoryService;
import com.pcci.idls.processtransaction.transfer.trxentries.service.TransactionWorkDetailService;
import com.pcci.idls.util.DateUtil;

public class ImportTransactionService implements ServiceLifecycle {
	private ApplicationContext context = null;
	private ApplicationContext pccitmscontext = null;
	private static final String timezone= "Asia/Manila";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(Object arg0) throws ServiceException {
		try {
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
			pccitmscontext = new ClassPathXmlApplicationContext("pccitmsContext.xml");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	public String importIFMSData(String startDate, String endDate){
		StatusBean status = null;
		String response = "";
		int recordInsertedCtr = 0;
		Date dateFrom = DateUtil.strToDate(null,startDate);
		int days = DateUtil.getNumDays(startDate, endDate);
		//TODO: loop in each date from the date range and call importIFMSData 
		
		try{
			for(int i = 0; i < days; i++){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dateFrom);
				calendar.add(Calendar.DAY_OF_MONTH, i);
				Date transactionBeginDate = calendar.getTime();
				System.out.println("begin date: "+transactionBeginDate);
				String strDate = DateUtil.dateToString(transactionBeginDate); 
				recordInsertedCtr = recordInsertedCtr + importIFMSData(strDate, strDate, null);
			}
		}
		catch(PersistenceException pex){
			status = new StatusBean("ERROR",pex.getCause().toString(),"IT-00");
			response = createXMLResponse("no session id", "IMPORT", status);
			return response;
		}
		catch(Exception ex){
			status = new StatusBean("ERROR",ex.getCause().toString(),"IT-00");
			response = createXMLResponse("no session id", "IMPORT", status);
			ex.printStackTrace();
			return response;
		}
		
		if(recordInsertedCtr<1){
			status = new StatusBean("ERROR","No record found for date range "+startDate+" and "+endDate+".","IT-02");
			System.out.println("No record found for date range "+startDate+" and "+endDate);
			response = createXMLResponse("no session id", "IMPORT", status);
		}
		else{
			status = new StatusBean("SUCCESS","The IFMS data was imported successfully.\n"+"Total of "+recordInsertedCtr+" records.","IT-01");
			response = createXMLResponse("no session id", "IMPORT", status);
			System.out.println("Total of "+recordInsertedCtr+" IFMS data was imported successfully.");	
		}
		
		
		return response;
	}
	/*public static void main(String[] args){
		Calendar now = new GregorianCalendar();
		Date dt = now.getTime();
		String strTrxDate = DateUtil.dateToString(dt,"yyyyMMdd");
		System.out.println(strTrxDate);
	}*/
	private int importIFMSData(String from, String to, Object obj) throws SQLException{
		//Object obj = context.getBean("IDLSTrxEntriesService");
		IDLSTrxEntriesService idlsService = (IDLSTrxEntriesService)context.getBean("IDLSTrxEntriesService");
		TransactionApprovalsHistoryService tahsService = (TransactionApprovalsHistoryService)pccitmscontext.getBean("TransactionApprovalsHistoryService");
		TransactionWorkDetailService twdService = (TransactionWorkDetailService)pccitmscontext.getBean("TransactionWorkDetailService");
		
		IDLSTrxEntries idlsTrxEntries = null;
		IDLSTrxEntriesPK idlsTrxEntriesPK = null;
		StatusBean status = null;
		
		String strToday = DateUtil.getToday(timezone,"yyyyMMdd");
		
		int recordInsertedCtr = 0;
		int recordFailedCtr = 0;
		List<IFMSTrxEntries> lstIFMSTrxEntries = findByDateRange(from, to);
		System.out.println(lstIFMSTrxEntries.size());
		if(lstIFMSTrxEntries!=null && lstIFMSTrxEntries.size()>0){
			for (IFMSTrxEntries ifmsTrxEntries : lstIFMSTrxEntries) {
				if(ifmsTrxEntries!=null){
					idlsTrxEntries = new IDLSTrxEntries();
					idlsTrxEntries.setTrxCredit(ifmsTrxEntries.getTrxCredit());
					idlsTrxEntries.setTrxDate(ifmsTrxEntries.getTrxDate());
					idlsTrxEntries.setTrxDebit(ifmsTrxEntries.getTrxDebit());
					idlsTrxEntries.setTrxDesc(ifmsTrxEntries.getTrxDesc());
					idlsTrxEntries.setTrxIMA_AcctCode(ifmsTrxEntries.getTrxIMA_AcctCode());
					idlsTrxEntries.setTrxIMA_AcctNormalBal(ifmsTrxEntries.getTrxIMA_AcctNormalBal());
					idlsTrxEntries.setTrxIMA_XAcctCode(ifmsTrxEntries.getTrxType()+ifmsTrxEntries.getTrxDate());
					idlsTrxEntries.setTrxIMA_XAcctNormalBal("Debit");
					String strTrxDate = DateUtil.dateToString(ifmsTrxEntries.getTrxDate(),"yyyyMMdd");
					idlsTrxEntries.setTrxJournal(ifmsTrxEntries.getTrxType()+strTrxDate);
					idlsTrxEntries.setTrxRefNo(ifmsTrxEntries.getTrxRefNo());
					idlsTrxEntries.setTrxTotal(null);
					idlsTrxEntries.setConverted("0");
					idlsTrxEntries.setTrxFrom("IFMS");
					idlsTrxEntries.setTrxType(ifmsTrxEntries.getTrxType());			
					idlsTrxEntries.setTrxInvtType(ifmsTrxEntries.getTrxInvtType());
					
					idlsService.store(idlsTrxEntries);
					tahsService.updateXIDLS(ifmsTrxEntries.getTrxRefNo(), ifmsTrxEntries.getTrxDate());
					twdService.updateAccrualDate(from, ifmsTrxEntries.getTrxRefNo());
					
					recordInsertedCtr++;
				}
				else{
					//failed import counter
					recordFailedCtr++;
				}
			
			}
			System.out.println("Total of "+recordInsertedCtr+" IFMS data was imported successfully. "+recordFailedCtr+" failed import(s). ");
		}
		
		return recordInsertedCtr;
	}
	
	private  List<IFMSTrxEntries> findByDateRange(String from, String to) throws SQLException{
		//ApplicationContext ifmsContext = new ClassPathXmlApplicationContext("ifmsContext.xml");
		IFMSTrxEntriesService ifmsService = (IFMSTrxEntriesService)context.getBean("IFMSTrxEntriesService");
		return ifmsService.findByDateRange(from, to);
	}
	
	
	private String createXMLResponse(String sessionId, String transactionType, StatusBean status){
		StringBuffer response = new StringBuffer();
		response.append("<serviceresponse>");
			response.append("\n");
			response.append("<status>");
			response.append("\n");
			response.append("<type>"+status.getType()+"</type>");
			response.append("\n");
			response.append("<message>"+status.getDescription()+"</message>");
			response.append("\n");
			response.append("<code>"+status.getCode()+"</code>");
			response.append("\n");
			response.append("</status>");
			response.append("\n");
			response.append("<transaction>");
			response.append("\n");
			response.append("<type>"+transactionType+"</type>");
			response.append("\n");
			response.append("<sessionid>"+sessionId+"</sessionid>");
			response.append("\n");
			response.append("</transaction>");
			response.append("\n");
		response.append("</serviceresponse>");
		return response.toString();
	}	
}
