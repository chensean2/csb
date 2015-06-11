package com.csb.core.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_provision_isv_service_history database table.
 * 
 */
@Entity
@Table(name="tbl_ss_provision_isv_service_history")
public class ProvisionIsvServiceHistory extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name="HISTORY_ID")
	private String historyId;

	@Column(name="ISV_SERVICE_DEF_ID")
	private String isvServiceDefId;

	@Column(name="ISV_SERVICE_ID")
	private String isvServiceId;

	@Column(name="PROVISION_SERVICE_STATUS")
	private String provisionServiceStatus;

	@Column(name="REQ_ID")
	private String reqId;

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
	private BigDecimal serviceSeq;

	@Column(name="TRANSACTION_ID")
	private String transactionId;


	public ProvisionIsvServiceHistory() {
	}


	public String getHistoryId() {
		return historyId;
	}


	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}


	public String getIsvServiceDefId() {
		return isvServiceDefId;
	}


	public void setIsvServiceDefId(String isvServiceDefId) {
		this.isvServiceDefId = isvServiceDefId;
	}


	public String getIsvServiceId() {
		return isvServiceId;
	}


	public void setIsvServiceId(String isvServiceId) {
		this.isvServiceId = isvServiceId;
	}


	public String getProvisionServiceStatus() {
		return provisionServiceStatus;
	}


	public void setProvisionServiceStatus(String provisionServiceStatus) {
		this.provisionServiceStatus = provisionServiceStatus;
	}


	public String getReqId() {
		return reqId;
	}


	public void setReqId(String reqId) {
		this.reqId = reqId;
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


	public BigDecimal getServiceSeq() {
		return serviceSeq;
	}


	public void setServiceSeq(BigDecimal serviceSeq) {
		this.serviceSeq = serviceSeq;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


}