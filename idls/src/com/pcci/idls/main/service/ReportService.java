package com.pcci.idls.main.service;

import java.util.List;

import javax.xml.rpc.ServiceException;
import javax.xml.rpc.server.ServiceLifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;
import com.pcci.idls.processtransaction.transfer.trxentries.service.IDLSTrxEntriesService;
import com.pcci.idls.report.ReportGenerator;

public class ReportService implements ServiceLifecycle {
	private IDLSTrxEntriesService idlsService = null;
	private ApplicationContext context = null;
	private ReportGenerator generator = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(Object arg0) throws ServiceException {
		// TODO Auto-generated method stub
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		idlsService = (IDLSTrxEntriesService)context.getBean("IDLSTrxEntriesService");
		generator = new ReportGenerator();
	}

	public String generateReport(String reportName, String startDate, String endDate){
		String response = "";
		
		if(reportName.equalsIgnoreCase("ProcessedConvertedEntriesReport")){
			List<IDLSTrxEntries> lstIDLSTrxEntries = findByDateRange(startDate, endDate);
			try {
				generator.generateProcessedConvertedEntries(lstIDLSTrxEntries);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return response;
	}
	
	public static void main(String[] args){
		new ReportService().generateReport("", "05/11/2012", "05/12/2012");
	}
	
	private  List<IDLSTrxEntries> findByDateRange(String from, String to) {
		return idlsService.findByDateRange(from, to);
	}
}
