package com.csb.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_provision_isv_service_para database table.
 * 
 */
@Entity
@Table(name="tbl_ss_provision_isv_service_para")
public class ProvisionIsvServicePara extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name="ISV_SERVICE_PARA_ID")
	private String isvServiceParaId;

	@Column(name="ISV_SERVICE_ID")
	private String isvServiceId;

	@Column(name="SERVICE_PARA_NAME")
	private String serviceParaName;

	@Lob
	@Column(name="SERVICE_PARA_NEW_VALUE")
	private byte[] serviceParaNewValue;

	@Lob
	@Column(name="SERVICE_PARA_OLD_VALUE")
	private byte[] serviceParaOldValue;


	public ProvisionIsvServicePara() {
	}


	public String getIsvServiceParaId() {
		return isvServiceParaId;
	}


	public void setIsvServiceParaId(String isvServiceParaId) {
		this.isvServiceParaId = isvServiceParaId;
	}


	public String getIsvServiceId() {
		return isvServiceId;
	}


	public void setIsvServiceId(String isvServiceId) {
		this.isvServiceId = isvServiceId;
	}


	public String getServiceParaName() {
		return serviceParaName;
	}


	public void setServiceParaName(String serviceParaName) {
		this.serviceParaName = serviceParaName;
	}


	public byte[] getServiceParaNewValue() {
		return serviceParaNewValue;
	}


	public void setServiceParaNewValue(byte[] serviceParaNewValue) {
		this.serviceParaNewValue = serviceParaNewValue;
	}


	public byte[] getServiceParaOldValue() {
		return serviceParaOldValue;
	}


	public void setServiceParaOldValue(byte[] serviceParaOldValue) {
		this.serviceParaOldValue = serviceParaOldValue;
	}


}