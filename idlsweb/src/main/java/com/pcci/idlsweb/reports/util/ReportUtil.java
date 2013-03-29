package com.pcci.idlsweb.reports.util;

import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportUtil {
	//private JasperPrint jasperPrint;  
    public static JasperPrint createJasperPrint(String reportName, String reportType, List data) throws JRException{  
//    		if(!reportName.equalsIgnoreCase("balance")){
//    			reportType="";
//    		}
	        JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(data);  
	        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/jasper/"+reportName+reportType+".jasper");
	        //String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/jasper/"+reportName+".jasper");
	        JasperPrint jasperPrint=JasperFillManager.fillReport(reportPath, new HashMap(),beanCollectionDataSource);  
	        return jasperPrint;
	}
}
