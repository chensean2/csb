//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.27 at 11:04:47 PM CST 
//


package com.csb.common.manifest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.csb.common.manifest package. 
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

    private final static QName _Manifest_QNAME = new QName("http://www.compatibleone.fr/schemes/manifest.xsd", "manifest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.csb.common.manifest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CordsManifest }
     * 
     */
    public CordsManifest createCordsManifest() {
        return new CordsManifest();
    }

    /**
     * Create an instance of {@link CordsSecurity }
     * 
     */
    public CordsSecurity createCordsSecurity() {
        return new CordsSecurity();
    }

    /**
     * Create an instance of {@link CordsAccount }
     * 
     */
    public CordsAccount createCordsAccount() {
        return new CordsAccount();
    }

    /**
     * Create an instance of {@link CordsUser }
     * 
     */
    public CordsUser createCordsUser() {
        return new CordsUser();
    }

    /**
     * Create an instance of {@link CordsConfiguration }
     * 
     */
    public CordsConfiguration createCordsConfiguration() {
        return new CordsConfiguration();
    }

    /**
     * Create an instance of {@link CordsRelease }
     * 
     */
    public CordsRelease createCordsRelease() {
        return new CordsRelease();
    }

    /**
     * Create an instance of {@link CordsInterface }
     * 
     */
    public CordsInterface createCordsInterface() {
        return new CordsInterface();
    }

    /**
     * Create an instance of {@link CordsAction }
     * 
     */
    public CordsAction createCordsAction() {
        return new CordsAction();
    }

    /**
     * Create an instance of {@link CordsNode }
     * 
     */
    public CordsNode createCordsNode() {
        return new CordsNode();
    }

    /**
     * Create an instance of {@link CordsInfrastructure }
     * 
     */
    public CordsInfrastructure createCordsInfrastructure() {
        return new CordsInfrastructure();
    }

    /**
     * Create an instance of {@link CordsCompute }
     * 
     */
    public CordsCompute createCordsCompute() {
        return new CordsCompute();
    }

    /**
     * Create an instance of {@link CordsNetwork }
     * 
     */
    public CordsNetwork createCordsNetwork() {
        return new CordsNetwork();
    }

    /**
     * Create an instance of {@link CordsStorage }
     * 
     */
    public CordsStorage createCordsStorage() {
        return new CordsStorage();
    }

    /**
     * Create an instance of {@link CordsImage }
     * 
     */
    public CordsImage createCordsImage() {
        return new CordsImage();
    }

    /**
     * Create an instance of {@link CordsSystem }
     * 
     */
    public CordsSystem createCordsSystem() {
        return new CordsSystem();
    }

    /**
     * Create an instance of {@link CordsPackage }
     * 
     */
    public CordsPackage createCordsPackage() {
        return new CordsPackage();
    }

    /**
     * Create an instance of {@link CordsFirewall }
     * 
     */
    public CordsFirewall createCordsFirewall() {
        return new CordsFirewall();
    }

    /**
     * Create an instance of {@link CordsPort }
     * 
     */
    public CordsPort createCordsPort() {
        return new CordsPort();
    }

    /**
     * Create an instance of {@link CordsError }
     * 
     */
    public CordsError createCordsError() {
        return new CordsError();
    }

    /**
     * Create an instance of {@link CordsWarning }
     * 
     */
    public CordsWarning createCordsWarning() {
        return new CordsWarning();
    }

    /**
     * Create an instance of {@link CordsChoice }
     * 
     */
    public CordsChoice createCordsChoice() {
        return new CordsChoice();
    }

    /**
     * Create an instance of {@link CordsMetric }
     * 
     */
    public CordsMetric createCordsMetric() {
        return new CordsMetric();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CordsManifest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.compatibleone.fr/schemes/manifest.xsd", name = "manifest")
    public JAXBElement<CordsManifest> createManifest(CordsManifest value) {
        return new JAXBElement<CordsManifest>(_Manifest_QNAME, CordsManifest.class, null, value);
    }

}