//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.20 at 04:38:44 PM SGT 
//


package com.pcci.idls.maintenance.account.jaxbmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for AccountService element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="AccountService">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{}transaction"/>
 *           &lt;element ref="{}IMA_AcctCode"/>
 *           &lt;element ref="{}IMA_AcctDesc"/>
 *           &lt;element ref="{}IMA_AcctNormalBal"/>
 *           &lt;element ref="{}IMA_AcctReptName"/>
 *           &lt;element ref="{}IFMS_BasedID"/>
 *           &lt;element ref="{}IFMS_BasedName"/>
 *           &lt;element ref="{}LastUserCode"/>
 *           &lt;element ref="{}LastUpdate"/>
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
    "imaAcctCode",
    "imaAcctDesc",
    "imaAcctNormalBal",
    "imaAcctReptName",
    "ifmsBasedID",
    "ifmsBasedName",
    "lastUserCode",
    "lastUpdate"
})
@XmlRootElement(name = "AccountService")
public class AccountServiceModel {

    @XmlElement(required = true)
    protected Transaction transaction;
    @XmlElement(name = "IMA_AcctCode", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String imaAcctCode;
    @XmlElement(name = "IMA_AcctDesc", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String imaAcctDesc;
    @XmlElement(name = "IMA_AcctNormalBal", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String imaAcctNormalBal;
    @XmlElement(name = "IMA_AcctReptName", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String imaAcctReptName;
    @XmlElement(name = "IFMS_BasedID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ifmsBasedID;
    @XmlElement(name = "IFMS_BasedName", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ifmsBasedName;
    @XmlElement(name = "LastUserCode", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String lastUserCode;
    @XmlElement(name = "LastUpdate", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String lastUpdate;

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
     * Gets the value of the imaAcctCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMAAcctCode() {
        return imaAcctCode;
    }

    /**
     * Sets the value of the imaAcctCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMAAcctCode(String value) {
        this.imaAcctCode = value;
    }

    /**
     * Gets the value of the imaAcctDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMAAcctDesc() {
        return imaAcctDesc;
    }

    /**
     * Sets the value of the imaAcctDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMAAcctDesc(String value) {
        this.imaAcctDesc = value;
    }

    /**
     * Gets the value of the imaAcctNormalBal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMAAcctNormalBal() {
        return imaAcctNormalBal;
    }

    /**
     * Sets the value of the imaAcctNormalBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMAAcctNormalBal(String value) {
        this.imaAcctNormalBal = value;
    }

    /**
     * Gets the value of the imaAcctReptName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMAAcctReptName() {
        return imaAcctReptName;
    }

    /**
     * Sets the value of the imaAcctReptName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMAAcctReptName(String value) {
        this.imaAcctReptName = value;
    }

    /**
     * Gets the value of the ifmsBasedID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIFMSBasedID() {
        return ifmsBasedID;
    }

    /**
     * Sets the value of the ifmsBasedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIFMSBasedID(String value) {
        this.ifmsBasedID = value;
    }

    /**
     * Gets the value of the ifmsBasedName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIFMSBasedName() {
        return ifmsBasedName;
    }

    /**
     * Sets the value of the ifmsBasedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIFMSBasedName(String value) {
        this.ifmsBasedName = value;
    }

    /**
     * Gets the value of the lastUserCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUserCode() {
        return lastUserCode;
    }

    /**
     * Sets the value of the lastUserCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUserCode(String value) {
        this.lastUserCode = value;
    }

    /**
     * Gets the value of the lastUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Sets the value of the lastUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdate(String value) {
        this.lastUpdate = value;
    }

}
