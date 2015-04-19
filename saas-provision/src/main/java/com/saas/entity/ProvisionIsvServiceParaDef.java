package com.saas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.saas.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_provision_isv_service_para_def database table.
 * 
 */
@Entity
@Table(name="tbl_ss_provision_isv_service_para_def")
public class ProvisionIsvServiceParaDef extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name="ISV_SERVICE_PARA_DEF_ID")
	private String isvServiceParaDefId;

	@ManyToOne
	@JoinColumn(name="ISV_SERVICE_DEF_ID",referencedColumnName="ISV_SERVICE_DEF_ID")
	private ProvisionIsvServiceDef provisionIsvServiceDef;

	@Column(name="ISV_SERVICE_PARA_NAME")
	private String isvServiceParaName;

	@Column(name="ISV_SERVICE_PARA_SEQ")
	private int isvServiceParaSeq;


	public ProvisionIsvServiceParaDef() {
	}


	public String getIsvServiceParaDefId() {
		return isvServiceParaDefId;
	}


	public void setIsvServiceParaDefId(String isvServiceParaDefId) {
		this.isvServiceParaDefId = isvServiceParaDefId;
	}



	public ProvisionIsvServiceDef getProvisionIsvServiceDef() {
		return provisionIsvServiceDef;
	}


	public void setProvisionIsvServiceDef(
			ProvisionIsvServiceDef provisionIsvServiceDef) {
		this.provisionIsvServiceDef = provisionIsvServiceDef;
	}


	public String getIsvServiceParaName() {
		return isvServiceParaName;
	}


	public void setIsvServiceParaName(String isvServiceParaName) {
		this.isvServiceParaName = isvServiceParaName;
	}


	public int getIsvServiceParaSeq() {
		return isvServiceParaSeq;
	}


	public void setIsvServiceParaSeq(int isvServiceParaSeq) {
		this.isvServiceParaSeq = isvServiceParaSeq;
	}


}