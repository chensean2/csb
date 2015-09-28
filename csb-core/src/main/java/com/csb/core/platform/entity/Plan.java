package com.csb.core.platform.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_platform_plan")
public class Plan extends BaseEntity<Long> {

	// for the client/ provider query subscription/assignment information
	@Column(name = "event_id", unique = true)
	private String eventId;

	// @Column(name = "APP_PROVIDER_ID")
	// private String appProviderId;

	@Column(name = "app_plan_id")
	private String appPlanId;

	// IAAS,PAAS,SAAS
	@Column(name = "category")
	private String category;

	@Column(name = "trace_id")
	private String traceId;

	// status of the provision,PENDING INPROGRESS,SUCCESS,FAILED
	@Column(name = "status")
	private String status;

	@Column(name = "message")
	private String message;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "saas_plan_id")
	private SaaSPlan saasPlan;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "iaas_plan_id")
	private IaaSPlan iaasPlan;

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

	public SaaSPlan getSaasPlan() {
		return saasPlan;
	}

	public void setSaasPlan(SaaSPlan saasPlan) {
		this.saasPlan = saasPlan;
	}

	public IaaSPlan getIaasPlan() {
		return iaasPlan;
	}

	public void setIaasPlan(IaaSPlan iaasPlan) {
		this.iaasPlan = iaasPlan;
	}

}