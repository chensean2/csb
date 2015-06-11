package com.saas.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csb.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_order_package database table.
 * 
 */
@Entity
@Table(name="tbl_ss_order_package")
@NamedQuery(name="OrderPackage.findAll", query="SELECT o FROM OrderPackage o")
public class OrderPackage extends BaseEntity<Long>  {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CONTRACT_END_DT")
	private Date contractEndDt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CONTRACT_START_DT")
	private Date contractStartDt;

	@Column(name="OLD_DOMAIN_PACKAGE_ID")
	private String oldDomainPackageId;

	@OneToOne
	@JoinColumn(name="PACKAGE_ID", referencedColumnName="PACKAGE_ID")
	private AppPackage appPackage;

	@Column(name="PACKAGE_ORDER_STATUS")
	private String packageOrderStatus;

	@Column(name="PROVISIONED_BY")
	private String provisionedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PROVISIONED_DT")
	private Date provisionedDt;

	@Column(name="QUANTITY_PURCHASED")
	private int quantityPurchased;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TRIAL_END_DT")
	private Date trialEndDt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TRIAL_START_DT")
	private Date trialStartDt;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private Order order;

	//bi-directional many-to-one association to OrderProduct
	@OneToMany(mappedBy="orderPackage")
	private List<OrderProduct> orderProductList;

	public OrderPackage() {
	}

	public Date getContractEndDt() {
		return contractEndDt;
	}

	public void setContractEndDt(Date contractEndDt) {
		this.contractEndDt = contractEndDt;
	}

	public Date getContractStartDt() {
		return contractStartDt;
	}

	public void setContractStartDt(Date contractStartDt) {
		this.contractStartDt = contractStartDt;
	}

	public String getOldDomainPackageId() {
		return oldDomainPackageId;
	}

	public void setOldDomainPackageId(String oldDomainPackageId) {
		this.oldDomainPackageId = oldDomainPackageId;
	}

	public AppPackage getAppPackage() {
		return appPackage;
	}

	public void setAppPackage(AppPackage appPackage) {
		this.appPackage = appPackage;
	}

	public String getPackageOrderStatus() {
		return packageOrderStatus;
	}

	public void setPackageOrderStatus(String packageOrderStatus) {
		this.packageOrderStatus = packageOrderStatus;
	}

	public String getProvisionedBy() {
		return provisionedBy;
	}

	public void setProvisionedBy(String provisionedBy) {
		this.provisionedBy = provisionedBy;
	}

	public Date getProvisionedDt() {
		return provisionedDt;
	}

	public void setProvisionedDt(Date provisionedDt) {
		this.provisionedDt = provisionedDt;
	}

	public int getQuantityPurchased() {
		return quantityPurchased;
	}

	public void setQuantityPurchased(int quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}

	public Date getTrialEndDt() {
		return trialEndDt;
	}

	public void setTrialEndDt(Date trialEndDt) {
		this.trialEndDt = trialEndDt;
	}

	public Date getTrialStartDt() {
		return trialStartDt;
	}

	public void setTrialStartDt(Date trialStartDt) {
		this.trialStartDt = trialStartDt;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}


}