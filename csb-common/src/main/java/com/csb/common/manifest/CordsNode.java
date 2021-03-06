//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.27 at 11:04:47 PM CST 
//


package com.csb.common.manifest;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cordsNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cordsNode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infrastructure" type="{http://www.compatibleone.fr/schemes/manifest.xsd}cordsInfrastructure" minOccurs="0"/&gt;
 *         &lt;element name="image" type="{http://www.compatibleone.fr/schemes/manifest.xsd}cordsImage" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="infrastructure" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="image" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="provider" type="{http://www.w3.org/2001/XMLSchema}string" default="any" /&gt;
 *       &lt;attribute name="profile" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="access" type="{http://www.w3.org/2001/XMLSchema}string" default="private" /&gt;
 *       &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" default="manifest" /&gt;
 *       &lt;attribute name="scope" type="{http://www.w3.org/2001/XMLSchema}string" default="normal" /&gt;
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" default="simple" /&gt;
 *       &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="cordscript" type="{http://www.w3.org/2001/XMLSchema}string" default="type.resolve(plan.name,type.value);" /&gt;
 *       &lt;attribute name="firewall" type="{http://www.w3.org/2001/XMLSchema}string" default="cordscript: firewall.new(id.value); firewall.build();" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cordsNode", propOrder = {
    "infrastructure",
    "image"
})
public class CordsNode {

    protected CordsInfrastructure infrastructure;
    protected CordsImage image;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "infrastructure")
    protected String infrastructureAtt;
    @XmlAttribute(name = "image")
    protected String imageAtt;
    @XmlAttribute(name = "provider")
    protected String provider;
    @XmlAttribute(name = "profile")
    protected String profile;
    @XmlAttribute(name = "access")
    protected String access;
    @XmlAttribute(name = "category")
    protected String category;
    @XmlAttribute(name = "scope")
    protected String scope;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "state")
    protected BigInteger state;
    @XmlAttribute(name = "cordscript")
    protected String cordscript;
    @XmlAttribute(name = "firewall")
    protected String firewall;

    /**
     * Gets the value of the infrastructure property.
     * 
     * @return
     *     possible object is
     *     {@link CordsInfrastructure }
     *     
     */
    public CordsInfrastructure getInfrastructure() {
        return infrastructure;
    }

    /**
     * Sets the value of the infrastructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link CordsInfrastructure }
     *     
     */
    public void setInfrastructure(CordsInfrastructure value) {
        this.infrastructure = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link CordsImage }
     *     
     */
    public CordsImage getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link CordsImage }
     *     
     */
    public void setImage(CordsImage value) {
        this.image = value;
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
     * Gets the value of the infrastructureAtt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfrastructureAtt() {
        return infrastructureAtt;
    }

    /**
     * Sets the value of the infrastructureAtt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfrastructureAtt(String value) {
        this.infrastructureAtt = value;
    }

    /**
     * Gets the value of the imageAtt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageAtt() {
        return imageAtt;
    }

    /**
     * Sets the value of the imageAtt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageAtt(String value) {
        this.imageAtt = value;
    }

    /**
     * Gets the value of the provider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvider() {
        if (provider == null) {
            return "any";
        } else {
            return provider;
        }
    }

    /**
     * Sets the value of the provider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvider(String value) {
        this.provider = value;
    }

    /**
     * Gets the value of the profile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfile(String value) {
        this.profile = value;
    }

    /**
     * Gets the value of the access property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccess() {
        if (access == null) {
            return "private";
        } else {
            return access;
        }
    }

    /**
     * Sets the value of the access property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccess(String value) {
        this.access = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        if (category == null) {
            return "manifest";
        } else {
            return category;
        }
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScope() {
        if (scope == null) {
            return "normal";
        } else {
            return scope;
        }
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScope(String value) {
        this.scope = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        if (type == null) {
            return "simple";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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

    /**
     * Gets the value of the cordscript property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCordscript() {
        if (cordscript == null) {
            return "type.resolve(plan.name,type.value);";
        } else {
            return cordscript;
        }
    }

    /**
     * Sets the value of the cordscript property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCordscript(String value) {
        this.cordscript = value;
    }

    /**
     * Gets the value of the firewall property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirewall() {
        if (firewall == null) {
            return "cordscript: firewall.new(id.value); firewall.build();";
        } else {
            return firewall;
        }
    }

    /**
     * Sets the value of the firewall property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirewall(String value) {
        this.firewall = value;
    }

}
