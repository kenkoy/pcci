//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.02 at 04:53:11 PM SGT 
//


package com.pcci.idls.maintenance.rolemodule.jaxbmodel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pcci.idls.maintenance.rolemodule.jaxbmodel package. 
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

    private final static QName _Id_QNAME = new QName("", "id");
    private final static QName _Lastupdate_QNAME = new QName("", "lastupdate");
    private final static QName _Deleteaccess_QNAME = new QName("", "deleteaccess");
    private final static QName _Description_QNAME = new QName("", "description");
    private final static QName _Readaccess_QNAME = new QName("", "readaccess");
    private final static QName _Createaccess_QNAME = new QName("", "createaccess");
    private final static QName _Expirydate_QNAME = new QName("", "expirydate");
    private final static QName _Type_QNAME = new QName("", "type");
    private final static QName _Modifiedby_QNAME = new QName("", "modifiedby");
    private final static QName _Effectivedate_QNAME = new QName("", "effectivedate");
    private final static QName _Updateaccess_QNAME = new QName("", "updateaccess");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pcci.idls.maintenance.rolemodule.jaxbmodel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Role }
     * 
     */
    public Role createRole() {
        return new Role();
    }

    /**
     * Create an instance of {@link RoleModuleServicerequest }
     * 
     */
    public RoleModuleServicerequest createServicerequest() {
        return new RoleModuleServicerequest();
    }

    /**
     * Create an instance of {@link Sessionid }
     * 
     */
    public Sessionid createSessionid() {
        return new Sessionid();
    }

    /**
     * Create an instance of {@link Modules }
     * 
     */
    public Modules createModules() {
        return new Modules();
    }

    /**
     * Create an instance of {@link RoleModuleServiceModel }
     * 
     */
    public RoleModuleServiceModel createRoles() {
        return new RoleModuleServiceModel();
    }

    /**
     * Create an instance of {@link Module }
     * 
     */
    public Module createModule() {
        return new Module();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "lastupdate")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createLastupdate(String value) {
        return new JAXBElement<String>(_Lastupdate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "deleteaccess")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createDeleteaccess(String value) {
        return new JAXBElement<String>(_Deleteaccess_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "readaccess")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createReadaccess(String value) {
        return new JAXBElement<String>(_Readaccess_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "createaccess")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createCreateaccess(String value) {
        return new JAXBElement<String>(_Createaccess_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "expirydate")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createExpirydate(String value) {
        return new JAXBElement<String>(_Expirydate_QNAME, String.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "modifiedby")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createModifiedby(String value) {
        return new JAXBElement<String>(_Modifiedby_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "effectivedate")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createEffectivedate(String value) {
        return new JAXBElement<String>(_Effectivedate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "updateaccess")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createUpdateaccess(String value) {
        return new JAXBElement<String>(_Updateaccess_QNAME, String.class, null, value);
    }

}
