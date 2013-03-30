package com.pcci.idls.main.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.rpc.ServiceException;
import javax.xml.rpc.server.ServiceLifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pcci.idls.exception.StatusBean;
import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;
import com.pcci.idls.processtransaction.transfer.trxentries.service.IDLSTrxEntriesService;
import com.pcci.idls.util.FileWriterUtil;

public class ConvertTransactionService implements ServiceLifecycle {
	private ApplicationContext context = null;
	private IDLSTrxEntriesService idlsService = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(Object arg0) throws ServiceException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		idlsService = (IDLSTrxEntriesService)context.getBean("IDLSTrxEntriesService");
	}
	
	private  List<IDLSTrxEntries> getTOFTransType(List<IDLSTrxEntries> lstIDLSTrxEntries) {
		List<IDLSTrxEntries> lstTOFTransType = new ArrayList<IDLSTrxEntries>();
		for(IDLSTrxEntries idlsTrxEntries : lstIDLSTrxEntries) {
			if(idlsTrxEntries.getTrxRefNo().startsWith("IMA")){
				lstTOFTransType.add(idlsTrxEntries);
			}
		}
		return lstTOFTransType;
	}
	private List<IDLSTrxEntries> getIMATransType(List<IDLSTrxEntries> lstIDLSTrxEntries) {
		List<IDLSTrxEntries> lstIMATransType = new ArrayList<IDLSTrxEntries>();
		for(IDLSTrxEntries idlsTrxEntries : lstIDLSTrxEntries) {
			if(idlsTrxEntries.getTrxRefNo().startsWith("IMA")){
				lstIMATransType.add(idlsTrxEntries);
			}
		}
		return lstIMATransType;
	}
	
	public String convertDataToNV2(String startDate, String endDate){
		String[] trxTypes = {"JV","CV","CR"}; 
		String response = "";
		boolean isConverted = false;
		SimpleDateFormat sdfYearMonthDay = new SimpleDateFormat("yyyyMMdd");
		//List<IDLSTrxEntries> lstIDLSTrxEntries = findByDateRange(startDate, endDate);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		String reportCreationTimestamp = dateFormat.format(cal.getTime());
		
		for (String trxType : trxTypes) {
			List<IDLSTrxEntries> lstTOFTrxEntries = findByDateRangeTrxType(startDate, endDate, trxType, "TOF");
			StatusBean status = null;
			if(lstTOFTrxEntries.size()>0){
				int lastIndex = lstTOFTrxEntries.size() - 1;
				String recordRetrievedStartDate = sdfYearMonthDay.format(lstTOFTrxEntries.get(0).getTrxDate());
				String recordRetrievedEndDate = sdfYearMonthDay.format(lstTOFTrxEntries.get(lastIndex).getTrxDate());
				
				String flatFileName = "TOF_"+trxType+"_"+recordRetrievedStartDate+"_"+recordRetrievedEndDate+"_"+reportCreationTimestamp+".txt";
				isConverted = FileWriterUtil.writeToFile(lstTOFTrxEntries,"C:\\src\\"+flatFileName, idlsService, trxType);
			}
			
			List<IDLSTrxEntries> lstIMATrxEntries = findByDateRangeTrxType(startDate, endDate, trxType, "IMA");
			if(lstIMATrxEntries.size()>0){
				int lastIndex = lstIMATrxEntries.size() - 1;
				String recordRetrievedStartDate = sdfYearMonthDay.format(lstIMATrxEntries.get(0).getTrxDate());
				String recordRetrievedEndDate = sdfYearMonthDay.format(lstIMATrxEntries.get(lastIndex).getTrxDate());
				
				String flatFileName = "IMA_"+trxType+"_"+recordRetrievedStartDate+"_"+recordRetrievedEndDate+"_"+reportCreationTimestamp+".txt";
				isConverted = FileWriterUtil.writeToFile(lstIMATrxEntries,"C:\\src\\"+flatFileName, idlsService, trxType);
			}
			
			else{
				status = new StatusBean("ERROR","No record found for date range "+startDate+" and "+endDate+".","");
				System.out.println("No record found for date range "+startDate+" and "+endDate);
				response = createXMLResponse("no session id", "CONVERT", status);
			}
			
			if(isConverted){
				status = new StatusBean("SUCCESS","The IDLS data was converted successfully.\n","CT-01");
				response = createXMLResponse("no session id", "CONVERT", status);
				//System.out.println("Total of "+lstIDLSTrxEntries.size()+" data was converted successfully.");
			}
			else{
				status = new StatusBean("ERROR","There was an error upon processing your transaction.\n"+"Failed to convert records for date range "+startDate+" and "+endDate,"CT-02");
				System.out.println("Failed to convert records for date range "+startDate+" and "+endDate);
				response = createXMLResponse("no session id", "CONVERT", status);
			}
		}
		
		
		return response;
	}
	
	private  List<IDLSTrxEntries> findByDateRange(String from, String to) {
		return idlsService.findByDateRange(from, to);
	}
	
	private  List<IDLSTrxEntries> findByDateRangeTrxType(String from, String to, String trxType, String transType) {
		return idlsService.findByDateRangeTrxType(from, to, trxType, transType);
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
