package com.pcci.idls.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;
import com.pcci.idls.processtransaction.transfer.trxentries.service.IDLSTrxEntriesService;

public class FileWriterUtil {
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IDLSTrxEntriesService idlsService = (IDLSTrxEntriesService)context.getBean("IDLSTrxEntriesService");
	
	public static boolean writeToFile(java.util.List<IDLSTrxEntries> lstIDLSData, String path, IDLSTrxEntriesService idlsService, String trxType) {
		BufferedWriter out = null;
		boolean isConverted = false;
		try {
			File file = new File(path);
			out = new BufferedWriter(new FileWriter(file, true));
			SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
			SimpleDateFormat sdfYearMonth = new SimpleDateFormat("MM");
			SimpleDateFormat sdfMonthDayYear = new SimpleDateFormat("MMddyyyy");
			SimpleDateFormat sdfDayMonthYear = new SimpleDateFormat("ddMMyyyy");
			out.write(createFlatFileHeader().toString());
			out.newLine();
			String strPrefix = "/"+trxType+"_";
			for (IDLSTrxEntries idlsData : lstIDLSData) {
				StringBuffer sb = new StringBuffer();
				String q = "\"";
				sb.append(q+"/JOURNAL/GENERAL"
						+strPrefix+sdfYear.format(idlsData.getTrxDate())
						+strPrefix+sdfYear.format(idlsData.getTrxDate())
						+sdfYearMonth.format(idlsData.getTrxDate())+q);
				//sb.append("/"+idlsData.getTrxIMA_AcctCode());
				
				sb.append(","+q+idlsData.getTrxIMA_AcctCode()+q);
				
				//sb.append(","+sdfMonthDayYear.format(idlsData.getTrxDate()));
				sb.append(","+sdfDayMonthYear.format(idlsData.getTrxDate()));
				
				sb.append(","+q+idlsData.getTrxRefNo().substring(3)+q);
				sb.append(","+q+idlsData.getTrxDesc()+q);
				
				//sb.append(","+idlsData.getTrxIMA_AcctNormalBal());
				if(idlsData.getTrxDebit().doubleValue() > 0.00){
					sb.append(","+idlsData.getTrxDebit());
				}
				else{
					sb.append(","+idlsData.getTrxCredit());
				}
				
				String strTrxIMA_XAcctCode = idlsData.getTrxIMA_XAcctCode().substring(0, 9).replaceAll("-", "");
				sb.append(","+q+strTrxIMA_XAcctCode+"_BAL"+q);
				sb.append(","+0);
				out.write(sb.toString());
				out.newLine();
				
				//update IMA_TrxEntries set Converted to 1
				IDLSTrxEntries idlsTrxEntries = idlsService.findById(String.valueOf(idlsData.getRn())); 
				idlsTrxEntries.setConverted("1");
				idlsService.store(idlsTrxEntries);
			}
			out.flush();
			out.close();
			isConverted = true;
		} catch (IOException e) {
			isConverted = false;
		}
		return isConverted;
		
	}
	public static void main(String[] arg){
		String s = "JV2011-05-05 00:00:00.0";
		System.out.println(s.substring(0, 9).replaceAll("-", "")+"_BAL");
	}
	private static StringBuilder createFlatFileHeader(){
		StringBuilder sb = new StringBuilder();
		sb.append("@ACCTLEDG(ASCII):JOURNAL,");
		//sb.append("JOURNAL,");
		sb.append("ACCT,");
		sb.append("DATE(-1),");
		sb.append("REF,");
		sb.append("DESC,");
		sb.append("AMT,");
		sb.append("XACCT,");
		sb.append("KEY");
		return sb;
		
	}
	
}
