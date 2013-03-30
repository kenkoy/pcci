package com.pcci.idls.report;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRJdtCompiler;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.pcci.idls.processtransaction.transfer.trxentries.domain.IDLSTrxEntries;

public class ReportGenerator {
	List<IDLSTrxEntries> lstIDLSTrxEntries = new ArrayList<IDLSTrxEntries>();
	
	//print to pdf
	public String generateProcessedConvertedEntries(List<IDLSTrxEntries> lstIDLSTrxEntries) throws Exception {
		String response = "";
		
		InputStream inputStream = new FileInputStream ("/config/processed_transaction_entries.jrxml");
		 
		JRBeanCollectionDataSource beanColDataSource = new
		JRBeanCollectionDataSource(lstIDLSTrxEntries);
		 
		Map parameters = new HashMap();
		
		JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
		JRJdtCompiler compiler = new JRJdtCompiler();
		JasperReport jasperReport = compiler.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Documents and Settings\\mjmc.PCCI\\My Documents\\IDLS\\test_jasper.pdf"); 
		
		return response;
	}
	
	public String generateBalanceReport(String startDate, String endDate){
		String response = "";
		return response;
	}
	public String generateAuditTrail(String startDate, String endDate){
		String response = "";
		return response;
	}
}
