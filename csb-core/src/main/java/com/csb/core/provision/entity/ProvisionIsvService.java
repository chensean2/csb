package com.csb.core.provision.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_provision_isv_service database table.
 * 
 */
@Entity
@Table(name="tbl_ss_provision_isv_service")
public class ProvisionIsvService extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="REQ_ID")
	private ProvisionRequest provisionRequest;
	
	@OneToOne(mappedBy="provisionIsvService")
	private ProvisionServiceRes provisionServiceRes;
	
	@Column(name="ISV_SERVICE_DEF_ID")
	private String isvServiceDefId;

	@Column(name="PROVISION_SERVICE_STATUS")
	private String provisionServiceStatus;


	@Column(name="REQUEST_NUM")
	private String requestNum;

	@Column(name="ROLLBACK_SERVICE_STATUS")
	private String rollbackServiceStatus;

	@Column(name="SERVICE_CATEGORY")
	private String serviceCategory;

	@Column(name="SERVICE_DEF_VERSION")
	private String serviceDefVersion;

	@Column(name="SERVICE_NAME")
	private String serviceName;

	@Column(name="SERVICE_OPERATION")
	private String serviceOperation;

	@Column(name="SERVICE_SEQ")
	private int serviceSeq;


	public ProvisionIsvService() {
	}


	public String getIsvServiceDefId() {
		return isvServiceDefId;
	}


	public void setIsvServiceDefId(String isvServiceDefId) {
		this.isvServiceDefId = isvServiceDefId;
	}


	public String getProvisionServiceStatus() {
		return provisionServiceStatus;
	}


	public void setProvisionServiceStatus(String provisionServiceStatus) {
		this.provisionServiceStatus = provisionServiceStatus;
	}



	public String getRequestNum() {
		return requestNum;
	}


	public void setRequestNum(String requestNum) {
		this.requestNum = requestNum;
	}


	public String getRollbackServiceStatus() {
		return rollbackServiceStatus;
	}


	public void setRollbackServiceStatus(String rollbackServiceStatus) {
		this.rollbackServiceStatus = rollbackServiceStatus;
	}


	public String getServiceCategory() {
		return serviceCategory;
	}


	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}


	public String getServiceDefVersion() {
		return serviceDefVersion;
	}


	public void setServiceDefVersion(String serviceDefVersion) {
		this.serviceDefVersion = serviceDefVersion;
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public String getServiceOperation() {
		return serviceOperation;
	}


	public void setServiceOperation(String serviceOperation) {
		this.serviceOperation = serviceOperation;
	}


	public int getServiceSeq() {
		return serviceSeq;
	}


	public void setServiceSeq(int serviceSeq) {
		this.serviceSeq = serviceSeq;
	}


	public ProvisionRequest getProvisionRequest() {
		return provisionRequest;
	}


	public void setProvisionRequest(ProvisionRequest provisionRequest) {
		this.provisionRequest = provisionRequest;
	}


	public ProvisionServiceRes getProvisionServiceRes() {
		return provisionServiceRes;
	}


	public void setProvisionServiceRes(ProvisionServiceRes provisionServiceRes) {
		this.provisionServiceRes = provisionServiceRes;
	}


}