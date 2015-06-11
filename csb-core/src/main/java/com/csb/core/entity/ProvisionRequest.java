package com.csb.core.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csb.core.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_provision_request database table.
 * 
 */
@Entity
@Table(name="tbl_ss_provision_request")
public class ProvisionRequest extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="provisionRequest")
	private List<ProvisionIsvService> provisionIsvServiceList;

	@Column(name="CUSTOMER_ID")
	private String customerId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PROVISION_END_TIME")
	private Date provisionEndTime;

	@Column(name="PROVISION_SEND_TIMES")
	private BigDecimal provisionSendTimes;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PROVISION_START_TIME")
	private Date provisionStartTime;

	@Column(name="PROVISION_STATUS")
	private String provisionStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="REQ_EFF_TIME")
	private Date reqEffTime;

	@Column(name="REQ_NO")
	private String reqNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="REQ_REC_TIME")
	private Date reqRecTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ROLLBACK_END_TIME")
	private Date rollbackEndTime;

	@Column(name="ROLLBACK_SEND_TIMES")
	private BigDecimal rollbackSendTimes;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ROLLBACK_START_TIME")
	private Date rollbackStartTime;

	@Column(name="ROLLBACK_STATUS")
	private String rollbackStatus;

	public ProvisionRequest() {
	}


	public List<ProvisionIsvService> getProvisionIsvServiceList() {
		return provisionIsvServiceList;
	}


	public void setProvisionIsvServiceList(
			List<ProvisionIsvService> provisionIsvServiceList) {
		this.provisionIsvServiceList = provisionIsvServiceList;
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getProvisionEndTime() {
		return provisionEndTime;
	}

	public void setProvisionEndTime(Date provisionEndTime) {
		this.provisionEndTime = provisionEndTime;
	}

	public BigDecimal getProvisionSendTimes() {
		return provisionSendTimes;
	}

	public void setProvisionSendTimes(BigDecimal provisionSendTimes) {
		this.provisionSendTimes = provisionSendTimes;
	}

	public Date getProvisionStartTime() {
		return provisionStartTime;
	}

	public void setProvisionStartTime(Date provisionStartTime) {
		this.provisionStartTime = provisionStartTime;
	}

	public String getProvisionStatus() {
		return provisionStatus;
	}

	public void setProvisionStatus(String provisionStatus) {
		this.provisionStatus = provisionStatus;
	}

	public Date getReqEffTime() {
		return reqEffTime;
	}

	public void setReqEffTime(Date reqEffTime) {
		this.reqEffTime = reqEffTime;
	}

	public String getReqNo() {
		return reqNo;
	}

	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}

	public Date getReqRecTime() {
		return reqRecTime;
	}

	public void setReqRecTime(Date reqRecTime) {
		this.reqRecTime = reqRecTime;
	}

	public Date getRollbackEndTime() {
		return rollbackEndTime;
	}

	public void setRollbackEndTime(Date rollbackEndTime) {
		this.rollbackEndTime = rollbackEndTime;
	}

	public BigDecimal getRollbackSendTimes() {
		return rollbackSendTimes;
	}

	public void setRollbackSendTimes(BigDecimal rollbackSendTimes) {
		this.rollbackSendTimes = rollbackSendTimes;
	}

	public Date getRollbackStartTime() {
		return rollbackStartTime;
	}

	public void setRollbackStartTime(Date rollbackStartTime) {
		this.rollbackStartTime = rollbackStartTime;
	}

	public String getRollbackStatus() {
		return rollbackStatus;
	}

	public void setRollbackStatus(String rollbackStatus) {
		this.rollbackStatus = rollbackStatus;
	}


}