package com.saas.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.csb.common.entity.BaseEntity;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_ss_order database table.
 * 
 */
@Entity
@Table(name="tbl_ss_order")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order extends BaseEntity<Long>  {
	private static final long serialVersionUID = 1L;

	@Column(name="DOMAIN_ID")
	private String domainId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_EMAIL_NOTIFICATION_DT")
	private Date lastEmailNotificationDt;

	@Lob
	@Column(name="LAST_EMAIL_NOTIFICATION_TO")
	private byte[] lastEmailNotificationTo;


	@Column(name="ORDER_REF_NUM")
	private String orderRefNum;

	@Column(name="ORDER_STATUS")
	private String orderStatus;

	@Column(name="ORDER_TYPE")
	private String orderType;

	private String remarks;

	@Column(name="REQUESTED_BY")
	private String requestedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="REQUESTED_DT")
	private Date requestedDt;


	//bi-directional many-to-one association to OrderPackage
	@OneToMany(mappedBy="order")
	private List<OrderPackage> orderPackageList;

	//bi-directional many-to-one association to OrderProduct
	@OneToMany(mappedBy="order")
	private List<OrderProduct> orderProductList;

	public Order() {
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public Date getLastEmailNotificationDt() {
		return lastEmailNotificationDt;
	}

	public void setLastEmailNotificationDt(Date lastEmailNotificationDt) {
		this.lastEmailNotificationDt = lastEmailNotificationDt;
	}

	public byte[] getLastEmailNotificationTo() {
		return lastEmailNotificationTo;
	}

	public void setLastEmailNotificationTo(byte[] lastEmailNotificationTo) {
		this.lastEmailNotificationTo = lastEmailNotificationTo;
	}

	public String getOrderRefNum() {
		return orderRefNum;
	}

	public void setOrderRefNum(String orderRefNum) {
		this.orderRefNum = orderRefNum;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public Date getRequestedDt() {
		return requestedDt;
	}

	public void setRequestedDt(Date requestedDt) {
		this.requestedDt = requestedDt;
	}

	public List<OrderPackage> getOrderPackageList() {
		return orderPackageList;
	}

	public void setOrderPackageList(List<OrderPackage> orderPackageList) {
		this.orderPackageList = orderPackageList;
	}

	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}

}