package com.pcci.idlsweb.reports;

import java.awt.Color;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.pcci.idlsweb.reports.constant.PasswordConst;
import com.pcci.idlsweb.reports.constant.ReportTypeEnum;
import com.pcci.idlsweb.reports.model.AuditTrail;
import com.pcci.idlsweb.reports.model.IMAAccounts;
import com.pcci.idlsweb.reports.model.IMAAccountsGrp;
import com.pcci.idlsweb.reports.model.IMATrxEntries;
import com.pcci.idlsweb.reports.service.AuditTrailService;
import com.pcci.idlsweb.reports.service.BalanceService;
import com.pcci.idlsweb.reports.service.IMATrxEntriesService;
import com.pcci.idlsweb.reports.util.DisplayUtil;
import com.pcci.idlsweb.reports.util.ReportUtil;

import org.springframework.context.annotation.Scope;
@Scope("session")
@Component
public class ReportBean {
	protected ReportTypeEnum reportTitle;
	protected Date startDate;
	protected Date endDate;
	protected List<AuditTrail> lstAuditTrail;
	protected List<IMATrxEntries> lstIMATrxEntries;
	protected List<IMAAccounts> lstIMAAccounts;
	protected List<IMAAccountsGrp> lstAccountGrp;
	protected IMATrxEntries selectedAccount;

	protected String userId;
	protected String module;
	protected String accountCode;

	protected String converted;
	protected BigDecimal totalDebit;
	protected BigDecimal totalCredit;
	protected BigDecimal netMovement;

	@Autowired
	protected AuditTrailService auditTrailService;
	@Autowired
	protected IMATrxEntriesService imaTrxEntriesService;
	@Autowired
	protected BalanceService balanceService;

	private List reportData;
	public ReportBean() {

	}

	@Transactional
	public String executeReport() {
		if (reportTitle.equals(ReportTypeEnum.AUDITTRAIL)) {
			this.reportData = getLstAuditTrail();
			return "audittrail";
		}
		if (reportTitle.equals(ReportTypeEnum.BALANCE)) {
			setConverted(null);
			this.reportData = getLstAccountGrp();
			return "balance";
		}
		if (reportTitle.equals(ReportTypeEnum.ENTRIESCONVERTED)) {
			setConverted("1");
			this.reportData = getLstIMATrxEntries();
			return "entriesconverted";
		}
		if (reportTitle.equals(ReportTypeEnum.ENTRIESPROCESSED)) {
			setConverted("0");
			this.reportData = getLstIMATrxEntries();
			return "entriesprocessed";
		}
		return "undefined";
	}

	@Transactional
	public String getBalanceReportPerAccount() {
		setAccountCode(getSelectedAccount().getTrxIMAAcctCode());
		getLstIMATrxEntries();
		return "balancePerAccount";
	}

	@Transactional
	public List<AuditTrail> getLstAuditTrail() {
		return auditTrailService.getListIMATrxEntries(getUserId(), getModule(),
				getStartDate(), getEndDate());
	}

	@Transactional
	public void setLstAuditTrail(List<AuditTrail> lstAuditTrail) {
		this.lstAuditTrail = lstAuditTrail;
	}

	@Transactional
	public List<IMATrxEntries> getLstIMATrxEntries() {
		totalCredit = new BigDecimal(0);
		totalDebit = new BigDecimal(0);
		netMovement = new BigDecimal(0);
		List<IMATrxEntries> lst = imaTrxEntriesService.getListIMATrxEntries(
				getConverted(), getStartDate(), getEndDate(), getAccountCode());
		for (IMATrxEntries entry : lst) {
			if (entry != null && entry.getTrxDebit() != null
					&& (entry.getTrxDebit().compareTo(BigDecimal.ZERO)) > 0) {
				totalDebit = totalDebit.add(entry.getTrxDebit());
			} else {
				totalCredit = totalCredit.add(entry.getTrxCredit());
			}
		}
		return lst;
	}

	@Transactional
	public List<IMAAccountsGrp> getLstAccountGrp() {
		totalCredit = new BigDecimal(0);
		totalDebit = new BigDecimal(0);
		netMovement = new BigDecimal(0);
		List<IMAAccountsGrp> lstAccountGrp = imaTrxEntriesService
				.getListIMAAccounts(getConverted(), getStartDate(),
						getEndDate(), getAccountCode());
		return lstAccountGrp;
	}

	public void setLstAccountGrp(List<IMAAccountsGrp> lstAccountGrp) {
		this.lstAccountGrp = lstAccountGrp;
	}

	@Transactional
	public List<IMAAccounts> getLstIMAAccounts() {
		return balanceService.getListIMAAccounts(getStartDate(), getEndDate());
	}

	@Transactional
	public void setLstIMAAccounts(List<IMAAccounts> lstIMAAccounts) {
		this.lstIMAAccounts = lstIMAAccounts;
	}

	public String getDecimalFormat(String pattern, double number) {
		return DisplayUtil.getDecimalFormat(pattern, number);
	}

	public void setLstIMATrxEntries(List<IMATrxEntries> lstIMATrxEntries) {
		this.lstIMATrxEntries = lstIMATrxEntries;
	}

	public BigDecimal getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(BigDecimal totalDebit) {
		this.totalDebit = totalDebit;
	}

	public BigDecimal getNetMovement() {
		return netMovement;
	}

	public void setNetMovement(BigDecimal netMovement) {
		this.netMovement = netMovement;
	}

	public BigDecimal getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(BigDecimal totalCredit) {
		this.totalCredit = totalCredit;
	}

	public ReportTypeEnum getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(ReportTypeEnum reportTitle) {
		this.reportTitle = reportTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getConverted() {
		return converted;
	}

	public void setConverted(String converted) {
		this.converted = converted;
	}

	public IMATrxEntries getSelectedAccount() {
		return selectedAccount;
	}

	public void setSelectedAccount(IMATrxEntries selectedAccount) {
		this.selectedAccount = selectedAccount;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	@Transactional
	public void PDF() throws JRException, IOException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-disposition","attachment; filename="+getReportTitle().toString().toLowerCase()+".pdf");
		ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
		JasperExportManager.exportReportToPdfStream(ReportUtil.createJasperPrint(getReportTitle().toString().toLowerCase(),"pdf", reportData), servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
	}

	@Transactional
	public void XLSX() throws JRException, IOException{  
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();  
       httpServletResponse.addHeader("Content-disposition", "attachment; filename="+getReportTitle().toString().toLowerCase()+".xls");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();  //       JRXlsxExporter docxExporter=new JRXlsxExporter();  
       //docxExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
       //docxExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
       //docxExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
       //docxExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
       //docxExporter.setParameter(JRXlsExporterParameter.PASSWORD, "test");
       //jasperPrint.setProperty("net.sf.jasperreports.export.xls.remove.empty.space.between.rows", "false");
       //jasperPrint.setProperty("net.sf.jasperreports.export.xls.remove.empty.space.between.columns", "true");
       //jasperPrint.setProperty("net.sf.jasperreports.export.xls.one.page.per.sheet", "false");
       //jasperPrint.setProperty("net.sf.jasperreports.export.xls.wrap.text", "true");

       //docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);  
       //docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);  
       //docxExporter.exportReport();  
       
       JasperPrint jasperPrint = ReportUtil.createJasperPrint(getReportTitle().toString().toLowerCase(),"xls", reportData);
       
       JExcelApiExporter jExcelApiExporter = new JExcelApiExporter();
       jExcelApiExporter.setParameter(JExcelApiExporterParameter.JASPER_PRINT, jasperPrint);
       jExcelApiExporter.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
       jExcelApiExporter.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM, servletOutputStream);
       jExcelApiExporter.setParameter(JExcelApiExporterParameter.IS_IGNORE_CELL_BORDER,Boolean.TRUE);
       jExcelApiExporter.setParameter(JExcelApiExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE);
       jExcelApiExporter.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
       jExcelApiExporter.setParameter(JExcelApiExporterParameter.OFFSET_X,0);
       jExcelApiExporter.setParameter(JExcelApiExporterParameter.OFFSET_Y,0 );
       jExcelApiExporter.setParameter(JExcelApiExporterParameter.PASSWORD, PasswordConst.PASSWORD);
       jExcelApiExporter.exportReport();
       
       FacesContext.getCurrentInstance().responseComplete();  
	}  
	
	@Transactional
	public void CSV() throws JRException, IOException{  
		HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();  
		httpServletResponse.addHeader("Content-disposition", "attachment; filename="+getReportTitle().toString().toLowerCase()+".csv");
		ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
		JRCsvExporter csvExporter = new JRCsvExporter();
		JasperPrint jasperPrint = ReportUtil.createJasperPrint(getReportTitle().toString().toLowerCase(),"xls", reportData);
		
		csvExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		csvExporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, servletOutputStream);
		csvExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, true);
		csvExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, true);
		csvExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, true);
		csvExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, true);
		csvExporter.exportReport();
		FacesContext.getCurrentInstance().responseComplete();
	}
}
