package com.saas.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.saas.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_app_product database table.
 * 
 */
@Entity
@Table(name="tbl_ss_app_product")
public class AppProduct extends BaseEntity<Long>  {
	
	@ManyToMany(mappedBy="appProductList")
	private List<AppPackage> appPackageList;
	
	@ManyToOne
	@JoinColumn(name="service_id", referencedColumnName="service_id")
	private AppService appService;
	
	@Column(name="AUTO_ASSIGN_INDICATOR")
	private String autoAssignIndicator;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DT")
	private Date createdDt;

	private String ext1;

	private String ext2;

	private String ext3;

	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATED_DT")
	private Date lastUpdatedDt;

	@Column(name="MULTI_LICENSE_INDICATOR")
	private String multiLicenseIndicator;

	@Column(name="PRODUCT_DESC")
	private String productDesc;

	@Column(name="PRODUCT_ID")
	private String productId;

	@Column(name="PRODUCT_NAME")
	private String productName;

	

	@Column(name="UNLIMIT_INDICATOR")
	private String unlimitIndicator;

	@Column(name="USAGE_QUANTITY")
	private int usageQuantity;

	@Column(name="USAGE_TYPE")
	private String usageType;

	@Column(name="USAGE_UNIT")
	private String usageUnit;

	private int version;

	public AppProduct() {
	}

	public String getAutoAssignIndicator() {
		return this.autoAssignIndicator;
	}

	public void setAutoAssignIndicator(String autoAssignIndicator) {
		this.autoAssignIndicator = autoAssignIndicator;
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

	public String getExt1() {
		return this.ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return this.ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return this.ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
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

	public String getMultiLicenseIndicator() {
		return this.multiLicenseIndicator;
	}

	public void setMultiLicenseIndicator(String multiLicenseIndicator) {
		this.multiLicenseIndicator = multiLicenseIndicator;
	}

	public String getProductDesc() {
		return this.productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}


	public String getUnlimitIndicator() {
		return this.unlimitIndicator;
	}

	public void setUnlimitIndicator(String unlimitIndicator) {
		this.unlimitIndicator = unlimitIndicator;
	}

	public int getUsageQuantity() {
		return this.usageQuantity;
	}

	public void setUsageQuantity(int usageQuantity) {
		this.usageQuantity = usageQuantity;
	}

	public String getUsageType() {
		return this.usageType;
	}

	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}

	public String getUsageUnit() {
		return this.usageUnit;
	}

	public void setUsageUnit(String usageUnit) {
		this.usageUnit = usageUnit;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<AppPackage> getAppPackageList() {
		return appPackageList;
	}

	public void setAppPackageList(List<AppPackage> appPackageList) {
		this.appPackageList = appPackageList;
	}


}