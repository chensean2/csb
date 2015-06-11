package com.csb.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_provision_isv_adaptor database table.
 * 
 */
@Entity
@Table(name="tbl_ss_provision_isv_adaptor")
@NamedQuery(name="ProvisionIsvAdaptor.findAll", query="SELECT p FROM ProvisionIsvAdaptor p")
public class ProvisionIsvAdaptor extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name="ISV_ADAPTOR_ID")
	private String isvAdaptorId;

	@Column(name="ISV_ADAPTOR_ADMIN_ID")
	private String isvAdaptorAdminId;

	@Column(name="ISV_ADAPTOR_ADMIN_PASS")
	private String isvAdaptorAdminPass;

	@Column(name="ISV_ADAPTOR_AUTH_METHOD")
	private String isvAdaptorAuthMethod;

	@Lob
	@Column(name="ISV_ADAPTOR_CERTIFICATE")
	private byte[] isvAdaptorCertificate;

	@Column(name="ISV_ADAPTOR_DESC")
	private String isvAdaptorDesc;

	@Column(name="ISV_ADAPTOR_ENDPOINT")
	private String isvAdaptorEndpoint;

	@Column(name="ISV_ADAPTOR_ENDPOINT_TYPE")
	private String isvAdaptorEndpointType;

	@Column(name="ISV_ADAPTOR_NAME")
	private String isvAdaptorName;

	public ProvisionIsvAdaptor() {
	}

	public String getIsvAdaptorId() {
		return isvAdaptorId;
	}

	public void setIsvAdaptorId(String isvAdaptorId) {
		this.isvAdaptorId = isvAdaptorId;
	}

	public String getIsvAdaptorAdminId() {
		return isvAdaptorAdminId;
	}

	public void setIsvAdaptorAdminId(String isvAdaptorAdminId) {
		this.isvAdaptorAdminId = isvAdaptorAdminId;
	}

	public String getIsvAdaptorAdminPass() {
		return isvAdaptorAdminPass;
	}

	public void setIsvAdaptorAdminPass(String isvAdaptorAdminPass) {
		this.isvAdaptorAdminPass = isvAdaptorAdminPass;
	}

	public String getIsvAdaptorAuthMethod() {
		return isvAdaptorAuthMethod;
	}

	public void setIsvAdaptorAuthMethod(String isvAdaptorAuthMethod) {
		this.isvAdaptorAuthMethod = isvAdaptorAuthMethod;
	}

	public byte[] getIsvAdaptorCertificate() {
		return isvAdaptorCertificate;
	}

	public void setIsvAdaptorCertificate(byte[] isvAdaptorCertificate) {
		this.isvAdaptorCertificate = isvAdaptorCertificate;
	}

	public String getIsvAdaptorDesc() {
		return isvAdaptorDesc;
	}

	public void setIsvAdaptorDesc(String isvAdaptorDesc) {
		this.isvAdaptorDesc = isvAdaptorDesc;
	}

	public String getIsvAdaptorEndpoint() {
		return isvAdaptorEndpoint;
	}

	public void setIsvAdaptorEndpoint(String isvAdaptorEndpoint) {
		this.isvAdaptorEndpoint = isvAdaptorEndpoint;
	}

	public String getIsvAdaptorEndpointType() {
		return isvAdaptorEndpointType;
	}

	public void setIsvAdaptorEndpointType(String isvAdaptorEndpointType) {
		this.isvAdaptorEndpointType = isvAdaptorEndpointType;
	}

	public String getIsvAdaptorName() {
		return isvAdaptorName;
	}

	public void setIsvAdaptorName(String isvAdaptorName) {
		this.isvAdaptorName = isvAdaptorName;
	}


}