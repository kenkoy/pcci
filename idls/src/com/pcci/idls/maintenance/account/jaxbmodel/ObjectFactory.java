//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.20 at 04:38:44 PM SGT 
//


package com.pcci.idls.maintenance.account.jaxbmodel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pcci.idls.maintenance.account.jaxbmodel package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IMAAcctReptName_QNAME = new QName("", "IMA_AcctReptName");
    private final static QName _IFMSBasedID_QNAME = new QName("", "IFMS_BasedID");
    private final static QName _LastUpdate_QNAME = new QName("", "LastUpdate");
    private final static QName _IMAAcctDesc_QNAME = new QName("", "IMA_AcctDesc");
    private final static QName _IMAAcctCode_QNAME = new QName("", "IMA_AcctCode");
    private final static QName _LastUserCode_QNAME = new QName("", "LastUserCode");
    private final static QName _IMAAcctNormalBal_QNAME = new QName("", "IMA_AcctNormalBal");
    private final static QName _IFMSBasedName_QNAME = new QName("", "IFMS_BasedName");
    private final static QName _Sessionid_QNAME = new QName("", "sessionid");
    private final static QName _Type_QNAME = new QName("", "type");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pcci.idls.maintenance.account.jaxbmodel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccountServiceModel }
     * 
     */
    public AccountServiceModel createAccountService() {
        return new AccountServiceModel();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link AccountServicerequest }
     * 
     */
    public AccountServicerequest createServicerequest() {
        return new AccountServicerequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IMA_AcctReptName")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createIMAAcctReptName(String value) {
        return new JAXBElement<String>(_IMAAcctReptName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IFMS_BasedID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createIFMSBasedID(String value) {
        return new JAXBElement<String>(_IFMSBasedID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LastUpdate")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createLastUpdate(String value) {
        return new JAXBElement<String>(_LastUpdate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IMA_AcctDesc")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createIMAAcctDesc(String value) {
        return new JAXBElement<String>(_IMAAcctDesc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IMA_AcctCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createIMAAcctCode(String value) {
        return new JAXBElement<String>(_IMAAcctCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LastUserCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createLastUserCode(String value) {
        return new JAXBElement<String>(_LastUserCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IMA_AcctNormalBal")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createIMAAcctNormalBal(String value) {
        return new JAXBElement<String>(_IMAAcctNormalBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IFMS_BasedName")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createIFMSBasedName(String value) {
        return new JAXBElement<String>(_IFMSBasedName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sessionid")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createSessionid(String value) {
        return new JAXBElement<String>(_Sessionid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

}
