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


/**
 * <p>Java class for servicerequest element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="servicerequest">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{}IDLSTrxEntries"/>
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
    "idlsTrxEntries"
})
@XmlRootElement(name = "servicerequest")
public class IDLSTrxServicerequest {

    @XmlElement(name = "IDLSTrxEntries", required = true)
    protected JBOIDLSTrxEntries idlsTrxEntries;

    /**
     * Gets the value of the idlsTrxEntries property.
     * 
     * @return
     *     possible object is
     *     {@link JBOIDLSTrxEntries }
     *     
     */
    public JBOIDLSTrxEntries getIDLSTrxEntries() {
        return idlsTrxEntries;
    }

    /**
     * Sets the value of the idlsTrxEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link JBOIDLSTrxEntries }
     *     
     */
    public void setIDLSTrxEntries(JBOIDLSTrxEntries value) {
        this.idlsTrxEntries = value;
    }

}