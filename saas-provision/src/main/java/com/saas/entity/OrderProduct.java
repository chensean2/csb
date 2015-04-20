package com.saas.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.saas.common.entity.BaseEntity;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the tbl_ss_order_product database table.
 * 
 */
@Entity
@Table(name="tbl_ss_order_product")
public class OrderProduct extends BaseEntity<Long>  {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name="PACKAGE_ID", referencedColumnName="PACKAGE_ID")
	private AppPackage appPackage;
	
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private Order order;

	@ManyToOne
	@JoinColumn(name="PACKAGE_ORDER_ID")
	private OrderPackage orderPackage;

	@OneToOne
	@JoinColumn(name="PRODUCT_ID", referencedColumnName="PRODUCT_ID")
	private AppProduct appProduct;
	
	@Column(name="PRO_RETRY_COUNT")
	private Integer proRetryCount;

	@Column(name="PRO_TX_ID")
	private String proTxId;


	@Column(name="PRODUCT_ORDER_STATUS")
	private String productOrderStatus;

	@Column(name="PROVISIONED_BY")
	private String provisionedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PROVISIONED_DT")
	private Date provisionedDt;

	private String reason;

	private String ext1;

	private String ext2;

	private String ext3;

	private String ext4;

	private String ext5;
	
	public OrderProduct() {
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	public String getExt5() {
		return ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}

	public AppPackage getAppPackage() {
		return appPackage;
	}

	public void setAppPackage(AppPackage appPackage) {
		this.appPackage = appPackage;
	}

	public Integer getProRetryCount() {
		return proRetryCount;
	}

	public void setProRetryCount(Integer proRetryCount) {
		this.proRetryCount = proRetryCount;
	}

	public String getProTxId() {
		return proTxId;
	}

	public void setProTxId(String proTxId) {
		this.proTxId = proTxId;
	}

	public AppProduct getAppProduct() {
		return appProduct;
	}

	public void setAppProduct(AppProduct appProduct) {
		this.appProduct = appProduct;
	}

	public String getProductOrderStatus() {
		return productOrderStatus;
	}

	public void setProductOrderStatus(String productOrderStatus) {
		this.productOrderStatus = productOrderStatus;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderPackage getOrderPackage() {
		return orderPackage;
	}

	public void setOrderPackage(OrderPackage orderPackage) {
		this.orderPackage = orderPackage;
	}
}