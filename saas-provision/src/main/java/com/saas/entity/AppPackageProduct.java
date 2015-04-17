package com.saas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.saas.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_app_package_product database table.
 * 
 */
@Entity
@Table(name="tbl_ss_app_package_product")
@NamedQuery(name="AppPackageProduct.findAll", query="SELECT a FROM AppPackageProduct a")
public class AppPackageProduct extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DT")
	private Date createdDt;

	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATED_DT")
	private Date lastUpdatedDt;

	@Column(name="PACKAGE_ID")
	private String packageId;

	@Column(name="PRODUCT_ID")
	private String productId;

	@Column(name="USAGE_QUANTITY")
	private int usageQuantity;

	private int version;

	public AppPackageProduct() {
	}


	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return this.createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDt() {
		return this.lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

	public String getPackageId() {
		return this.packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getUsageQuantity() {
		return this.usageQuantity;
	}

	public void setUsageQuantity(int usageQuantity) {
		this.usageQuantity = usageQuantity;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}