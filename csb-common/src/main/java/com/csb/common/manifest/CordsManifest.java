//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.27 at 11:04:47 PM CST 
//


package com.csb.common.manifest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cordsManifest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cordsManifest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="security" type="{http://www.compatibleone.fr/schemes/manifest.xsd}cordsSecurity" minOccurs="0"/&gt;
 *         &lt;element name="account" type="{http://www.compatibleone.fr/schemes/manifest.xsd}cordsAccount" minOccurs="0"/&gt;
 *         &lt;element name="configuration" type="{http://www.compatibleone.fr/schemes/manifest.xsd}cordsConfiguration"/&gt;
 *         &lt;element name="release" type="{http://www.compatibleone.fr/schemes/manifest.xsd}cordsRelease" minOccurs="0"/&gt;
 *         &lt;element name="interface" type="{http://www.compatibleone.fr/schemes/manifest.xsd}cordsInterface" minOccurs="0"/&gt;
 *         &lt;element name="node" type="{http://www.compatibleone.fr/schemes/manifest.xsd}cordsNode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="error" type="{http://www.compatibleone.fr/schemes/manifest.xsd}cordsError" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="warning" type="{http://www.compatibleone.fr/schemes/manifest.xsd}cordsWarning" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="choice" type="{http://www.compatibleone.fr/schemes/manifest.xsd}cordsChoice" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="configuration" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="release" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="interface" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="security" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="account" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="nodes" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="plan" type="{http://www.w3.org/2001/XMLSchema}string" default="cordscript: plan.new(id.value,name.value);" /&gt;
 *       &lt;attribute name="zone" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cordsManifest", propOrder = {
    "security",
    "account",
    "configuration",
    "release",
    "_interface",
    "node",
    "error",
    "warning",
    "choice",
    "description"
})
public class CordsManifest {

    protected CordsSecurity security;
    protected CordsAccount account;
    @XmlElement(required = true)
    protected CordsConfiguration configuration;
    protected CordsRelease release;
    @XmlElement(name = "interface")
    protected CordsInterface _interface;
    protected List<CordsNode> node;
    protected List<CordsError> error;
    protected List<CordsWarning> warning;
    protected List<CordsChoice> choice;
    protected List<String> description;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "configuration")
    protected String configurationAtt;
    @XmlAttribute(name = "release")
    protected String releaseAtt;
    @XmlAttribute(name = "interface")
    protected String interfaceAtt;
    @XmlAttribute(name = "security")
    protected String securityAtt;
    @XmlAttribute(name = "account")
    protected String accountAtt;
    @XmlAttribute(name = "description")
    protected String descriptionAtt;
    @XmlAttribute(name = "nodes")
    protected BigInteger nodes;
    @XmlAttribute(name = "plan")
    protected String plan;
    @XmlAttribute(name = "zone")
    protected String zone;
    @XmlAttribute(name = "state")
    protected BigInteger state;

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link CordsSecurity }
     *     
     */
    public CordsSecurity getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link CordsSecurity }
     *     
     */
    public void setSecurity(CordsSecurity value) {
        this.security = value;
    }

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link CordsAccount }
     *     
     */
    public CordsAccount getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link CordsAccount }
     *     
     */
    public void setAccount(CordsAccount value) {
        this.account = value;
    }

    /**
     * Gets the value of the configuration property.
     * 
     * @return
     *     possible object is
     *     {@link CordsConfiguration }
     *     
     */
    public CordsConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Sets the value of the configuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link CordsConfiguration }
     *     
     */
    public void setConfiguration(CordsConfiguration value) {
        this.configuration = value;
    }

    /**
     * Gets the value of the release property.
     * 
     * @return
     *     possible object is
     *     {@link CordsRelease }
     *     
     */
    public CordsRelease getRelease() {
        return release;
    }

    /**
     * Sets the value of the release property.
     * 
     * @param value
     *     allowed object is
     *     {@link CordsRelease }
     *     
     */
    public void setRelease(CordsRelease value) {
        this.release = value;
    }

    /**
     * Gets the value of the interface property.
     * 
     * @return
     *     possible object is
     *     {@link CordsInterface }
     *     
     */
    public CordsInterface getInterface() {
        return _interface;
    }

    /**
     * Sets the value of the interface property.
     * 
     * @param value
     *     allowed object is
     *     {@link CordsInterface }
     *     
     */
    public void setInterface(CordsInterface value) {
        this._interface = value;
    }

    /**
     * Gets the value of the node property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the node property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CordsNode }
     * 
     * 
     */
    public List<CordsNode> getNode() {
        if (node == null) {
            node = new ArrayList<CordsNode>();
        }
        return this.node;
    }

    /**
     * Gets the value of the error property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the error property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getError().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CordsError }
     * 
     * 
     */
    public List<CordsError> getError() {
        if (error == null) {
            error = new ArrayList<CordsError>();
        }
        return this.error;
    }

    /**
     * Gets the value of the warning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CordsWarning }
     * 
     * 
     */
    public List<CordsWarning> getWarning() {
        if (warning == null) {
            warning = new ArrayList<CordsWarning>();
        }
        return this.warning;
    }

    /**
     * Gets the value of the choice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the choice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChoice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CordsChoice }
     * 
     * 
     */
    public List<CordsChoice> getChoice() {
        if (choice == null) {
            choice = new ArrayList<CordsChoice>();
        }
        return this.choice;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDescription() {
        if (description == null) {
            description = new ArrayList<String>();
        }
        return this.description;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the configurationAtt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigurationAtt() {
        return configurationAtt;
    }

    /**
     * Sets the value of the configurationAtt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigurationAtt(String value) {
        this.configurationAtt = value;
    }

    /**
     * Gets the value of the releaseAtt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReleaseAtt() {
        return releaseAtt;
    }

    /**
     * Sets the value of the releaseAtt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReleaseAtt(String value) {
        this.releaseAtt = value;
    }

    /**
     * Gets the value of the interfaceAtt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterfaceAtt() {
        return interfaceAtt;
    }

    /**
     * Sets the value of the interfaceAtt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterfaceAtt(String value) {
        this.interfaceAtt = value;
    }

    /**
     * Gets the value of the securityAtt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityAtt() {
        return securityAtt;
    }

    /**
     * Sets the value of the securityAtt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityAtt(String value) {
        this.securityAtt = value;
    }

    /**
     * Gets the value of the accountAtt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountAtt() {
        return accountAtt;
    }

    /**
     * Sets the value of the accountAtt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountAtt(String value) {
        this.accountAtt = value;
    }

    /**
     * Gets the value of the descriptionAtt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptionAtt() {
        return descriptionAtt;
    }

    /**
     * Sets the value of the descriptionAtt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptionAtt(String value) {
        this.descriptionAtt = value;
    }

    /**
     * Gets the value of the nodes property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNodes() {
        return nodes;
    }

    /**
     * Sets the value of the nodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNodes(BigInteger value) {
        this.nodes = value;
    }

    /**
     * Gets the value of the plan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlan() {
        if (plan == null) {
            return "cordscript: plan.new(id.value,name.value);";
        } else {
            return plan;
        }
    }

    /**
     * Sets the value of the plan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlan(String value) {
        this.plan = value;
    }

    /**
     * Gets the value of the zone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZone() {
        return zone;
    }

    /**
     * Sets the value of the zone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZone(String value) {
        this.zone = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setState(BigInteger value) {
        this.state = value;
    }

}
