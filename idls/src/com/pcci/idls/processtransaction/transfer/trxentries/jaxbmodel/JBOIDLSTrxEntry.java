//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.19 at 03:28:45 PM SGT 
//


package com.pcci.idls.processtransaction.transfer.trxentries.jaxbmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for IDLSTrxEntry element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="IDLSTrxEntry">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{}transaction"/>
 *           &lt;element ref="{}TrxCredit"/>
 *           &lt;element ref="{}TrxDate"/>
 *           &lt;element ref="{}TrxDebit"/>
 *           &lt;element ref="{}TrxDesc"/>
 *           &lt;element ref="{}TrxIMA_AcctCode"/>
 *           &lt;element ref="{}TrxIMA_AcctNormalBal"/>
 *           &lt;element ref="{}TrxIMA_XAcctCode"/>
 *           &lt;element ref="{}TrxIMA_XAcctNormalBal"/>
 *           &lt;element ref="{}TrxJournal"/>
 *           &lt;element ref="{}TrxRefNo"/>
 *           &lt;element ref="{}TrxTotal"/>
 *           &lt;element ref="{}TrxFrom"/>
 *           &lt;element ref="{}TrxType"/>
 *           &lt;element ref="{}rn"/>
 *           &lt;element ref="{}TrxStartDate"/>
 *           &lt;element ref="{}TrxEndDate"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transaction",
    "trxCredit",
    "trxDate",
    "trxDebit",
    "trxDesc",
    "trxIMAAcctCode",
    "trxIMAAcctNormalBal",
    "trxIMAXAcctCode",
    "trxIMAXAcctNormalBal",
    "trxJournal",
    "trxRefNo",
    "trxTotal",
    "trxFrom",
    "trxType",
    "rn",
    "trxStartDate",
    "trxEndDate",
    "trxLastUserCode",
    "trxLastUpdate"
})
@XmlRootElement(name = "IDLSTrxEntry")
public class JBOIDLSTrxEntry {

    @XmlElement(required = true)
    protected Transaction transaction;
    @XmlElement(name = "TrxCredit", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxCredit;
    @XmlElement(name = "TrxDate", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxDate;
    @XmlElement(name = "TrxDebit", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxDebit;
    @XmlElement(name = "TrxDesc", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxDesc;
    @XmlElement(name = "TrxIMA_AcctCode", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxIMAAcctCode;
    @XmlElement(name = "TrxIMA_AcctNormalBal", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxIMAAcctNormalBal;
    @XmlElement(name = "TrxIMA_XAcctCode", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxIMAXAcctCode;
    @XmlElement(name = "TrxIMA_XAcctNormalBal", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxIMAXAcctNormalBal;
    @XmlElement(name = "TrxJournal", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxJournal;
    @XmlElement(name = "TrxRefNo", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxRefNo;
    @XmlElement(name = "TrxTotal", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxTotal;
    @XmlElement(name = "TrxFrom", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxFrom;
    @XmlElement(name = "TrxType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxType;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String rn;
    @XmlElement(name = "TrxStartDate", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxStartDate;
    @XmlElement(name = "TrxEndDate", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxEndDate;
    @XmlElement(name = "LastUserCode", required = false)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxLastUserCode;
    @XmlElement(name = "LastUpdate", required = false)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String trxLastUpdate;
    
    /**
     * Gets the value of the transaction property.
     * 
     * @return
     *     possible object is
     *     {@link Transaction }
     *     
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Sets the value of the transaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Transaction }
     *     
     */
    public void setTransaction(Transaction value) {
        this.transaction = value;
    }

    /**
     * Gets the value of the trxCredit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxCredit() {
        return trxCredit;
    }

    /**
     * Sets the value of the trxCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxCredit(String value) {
        this.trxCredit = value;
    }

    /**
     * Gets the value of the trxDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxDate() {
        return trxDate;
    }

    /**
     * Sets the value of the trxDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxDate(String value) {
        this.trxDate = value;
    }

    /**
     * Gets the value of the trxDebit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxDebit() {
        return trxDebit;
    }

    /**
     * Sets the value of the trxDebit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxDebit(String value) {
        this.trxDebit = value;
    }

    /**
     * Gets the value of the trxDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxDesc() {
        return trxDesc;
    }

    /**
     * Sets the value of the trxDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxDesc(String value) {
        this.trxDesc = value;
    }

    /**
     * Gets the value of the trxIMAAcctCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxIMAAcctCode() {
        return trxIMAAcctCode;
    }

    /**
     * Sets the value of the trxIMAAcctCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxIMAAcctCode(String value) {
        this.trxIMAAcctCode = value;
    }

    /**
     * Gets the value of the trxIMAAcctNormalBal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxIMAAcctNormalBal() {
        return trxIMAAcctNormalBal;
    }

    /**
     * Sets the value of the trxIMAAcctNormalBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxIMAAcctNormalBal(String value) {
        this.trxIMAAcctNormalBal = value;
    }

    /**
     * Gets the value of the trxIMAXAcctCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxIMAXAcctCode() {
        return trxIMAXAcctCode;
    }

    /**
     * Sets the value of the trxIMAXAcctCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxIMAXAcctCode(String value) {
        this.trxIMAXAcctCode = value;
    }

    /**
     * Gets the value of the trxIMAXAcctNormalBal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxIMAXAcctNormalBal() {
        return trxIMAXAcctNormalBal;
    }

    /**
     * Sets the value of the trxIMAXAcctNormalBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxIMAXAcctNormalBal(String value) {
        this.trxIMAXAcctNormalBal = value;
    }

    /**
     * Gets the value of the trxJournal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxJournal() {
        return trxJournal;
    }

    /**
     * Sets the value of the trxJournal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxJournal(String value) {
        this.trxJournal = value;
    }

    /**
     * Gets the value of the trxRefNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxRefNo() {
        return trxRefNo;
    }

    /**
     * Sets the value of the trxRefNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxRefNo(String value) {
        this.trxRefNo = value;
    }

    /**
     * Gets the value of the trxTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxTotal() {
        return trxTotal;
    }

    /**
     * Sets the value of the trxTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxTotal(String value) {
        this.trxTotal = value;
    }

    /**
     * Gets the value of the trxFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxFrom() {
        return trxFrom;
    }

    /**
     * Sets the value of the trxFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxFrom(String value) {
        this.trxFrom = value;
    }

    /**
     * Gets the value of the trxType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxType() {
        return trxType;
    }

    /**
     * Sets the value of the trxType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxType(String value) {
        this.trxType = value;
    }

    /**
     * Gets the value of the rn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRn() {
        return rn;
    }

    /**
     * Sets the value of the rn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRn(String value) {
        this.rn = value;
    }

    /**
     * Gets the value of the trxStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxStartDate() {
        return trxStartDate;
    }

    /**
     * Sets the value of the trxStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxStartDate(String value) {
        this.trxStartDate = value;
    }

    /**
     * Gets the value of the trxEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxEndDate() {
        return trxEndDate;
    }

    /**
     * Sets the value of the trxEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxEndDate(String value) {
        this.trxEndDate = value;
    }

	public String getTrxLastUserCode() {
		return trxLastUserCode;
	}

	public void setTrxLastUserCode(String trxLastUserCode) {
		this.trxLastUserCode = trxLastUserCode;
	}

	public String getTrxLastUpdate() {
		return trxLastUpdate;
	}

	public void setTrxLastUpdate(String trxLastUpdate) {
		this.trxLastUpdate = trxLastUpdate;
	}


	/**
	 * Sets the value of the trxInvtType property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	/*public void setTrxInvtType(String value) {
	    this.trxInvtType = value;
	}*/
}