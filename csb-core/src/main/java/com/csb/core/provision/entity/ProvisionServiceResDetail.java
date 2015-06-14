package com.csb.core.provision.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_provision_service_res_detail database table.
 * 
 */
@Entity
@Table(name="tbl_ss_provision_service_res_detail")
public class ProvisionServiceResDetail extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	
	@Column(name="SERVICE_RES_FIELD_NAME")
	private String serviceResFieldName;

	@Lob
	@Column(name="SERVICE_RES_FIELD_VALUE")
	private byte[] serviceResFieldValue;

	@ManyToOne
	@JoinColumn(name="SERVICE_RES_ID")
	private ProvisionServiceRes provisionServiceRes;


	public ProvisionServiceResDetail() {
	}



	public String getServiceResFieldName() {
		return serviceResFieldName;
	}


	public void setServiceResFieldName(String serviceResFieldName) {
		this.serviceResFieldName = serviceResFieldName;
	}

	public byte[] getServiceResFieldValue() {
		return serviceResFieldValue;
	}


	public void setServiceResFieldValue(byte[] serviceResFieldValue) {
		this.serviceResFieldValue = serviceResFieldValue;
	}


	public ProvisionServiceRes getProvisionServiceRes() {
		return provisionServiceRes;
	}


	public void setProvisionServiceRes(ProvisionServiceRes provisionServiceRes) {
		this.provisionServiceRes = provisionServiceRes;
	}




}