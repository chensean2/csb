package com.saas.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.saas.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_provision_notification database table.
 * 
 */
@Entity
@Table(name="tbl_ss_provision_notification")
public class ProvisionNotification extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name="NOTIFICATION_ID")
	private String notificationId;

	@Column(name="ERROR_MESSAGE")
	private String errorMessage;


	@Column(name="NOTIFICATION_RECIPIENT")
	private String notificationRecipient;

	@Column(name="NOTIFICATION_SEND_TIMES")
	private BigDecimal notificationSendTimes;

	@Column(name="NOTIFICATION_STATUS")
	private String notificationStatus;

	@Column(name="REQ_ID")
	private String reqId;


	public ProvisionNotification() {
	}


	public String getNotificationId() {
		return notificationId;
	}


	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getNotificationRecipient() {
		return notificationRecipient;
	}


	public void setNotificationRecipient(String notificationRecipient) {
		this.notificationRecipient = notificationRecipient;
	}


	public BigDecimal getNotificationSendTimes() {
		return notificationSendTimes;
	}


	public void setNotificationSendTimes(BigDecimal notificationSendTimes) {
		this.notificationSendTimes = notificationSendTimes;
	}


	public String getNotificationStatus() {
		return notificationStatus;
	}


	public void setNotificationStatus(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}


	public String getReqId() {
		return reqId;
	}


	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

}