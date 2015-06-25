package com.csb.core.platform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "tbl_csb_platform_plan")
public class Plan extends BaseEntity<Long> {

	// for the client/ provider query subscription/assignment information
	@Column(name = "EVENT_ID", unique = true)
	private String eventId;

	// @Column(name = "APP_PROVIDER_ID")
	// private String appProviderId;

	@Column(name = "APP_PLAN_ID")
	private String appPlanId;

	// IAAS,PAAS,SAAS
	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "TRACE_ID")
	private String traceId;

	// status of the provision,PENDING INPROGRESS,SUCCESS,FAILED
	@Column(name = "STATUS")
	private String status;

	@Column(name = "MESSAGE")
	private String message;

	@OneToOne
	@JoinColumn(name = "SAAS_PLAN_ID")
	private SaaSPlan saaSPlan;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getAppPlanId() {
		return appPlanId;
	}

	public void setAppPlanId(String appPlanId) {
		this.appPlanId = appPlanId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SaaSPlan getSaaSPlan() {
		return saaSPlan;
	}

	public void setSaaSPlan(SaaSPlan saaSPlan) {
		this.saaSPlan = saaSPlan;
	}

}