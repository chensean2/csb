package com.saas.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.csb.common.entity.BaseEntity;

/**
 * The persistent class for the tbl_ss_app_package database table.
 * 
 */
@Entity
@Table(name = "tbl_ss_app_package")
public class AppPackage extends BaseEntity<Long> {

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "tbl_ss_app_package_product",
	joinColumns = { @JoinColumn(name = "package_id",referencedColumnName="package_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "product_id",referencedColumnName="product_id") })
//	// Fecth策略定义
	@Fetch(FetchMode.JOIN)
	private List<AppProduct> appProductList;

	@ManyToOne
	@JoinColumn(name="PACKAGE_GROUP_ID",referencedColumnName="group_id")
	private AppGroup appGroup;
	
	@Column(name = "ADD_ON_INDICATOR")
	private String addOnIndicator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "AVAILABLE_END_DT")
	private Date availableEndDt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "AVAILABLE_START_DT")
	private Date availableStartDt;

	@Lob
	@Column(name = "MAIL_CONTENT_EXT")
	private byte[] mailContentExt;

	@Lob
	@Column(name = "MAIL_PACKAGE_NAME_EXT")
	private byte[] mailPackageNameExt;

	@Column(name = "MAIN_SERVICE_ID")
	private String mainServiceId;

	@Column(name = "MAX_QUANTITY")
	private int maxQuantity;

	@Column(name = "MIN_QUANTITY")
	private int minQuantity;

	@Column(name = "PACKAGE_DESC")
	private String packageDesc;

	@Lob
	@Column(name = "PACKAGE_HOWTO_TOOLTIP")
	private byte[] packageHowtoTooltip;

	@Column(name = "PACKAGE_ID")
	private String packageId;

	@Column(name = "PACKAGE_NAME")
	private String packageName;

	@Column(name = "PACKAGE_SEQ")
	private int packageSeq;

	@Column(name = "PACKAGE_STATUS")
	private String packageStatus;

	@Column(name = "PUBLISHED_BY")
	private String publishedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PUBLISHED_DT")
	private Date publishedDt;

	private String stackable;

	@Column(name = "TRIAL_DAYS")
	private int trialDays;

	@Column(name = "TRIAL_INDICATOR")
	private String trialIndicator;

	@Column(name = "TRIAL_SELECTION_DEFAULT")
	private String trialSelectionDefault;

	@Column(name = "TRIAL_SELECTION_INDICATOR")
	private String trialSelectionIndicator;

	@Column(name = "TRIAL_SELECTION_OPTION")
	private String trialSelectionOption;

	@Column(name = "UNLIMIT_INDICATOR")
	private String unlimitIndicator;

	@Column(name = "UNPUBLISHED_BY")
	private String unpublishedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UNPUBLISHED_DT")
	private Date unpublishedDt;


	public AppPackage() {
	}

	public String getAddOnIndicator() {
		return this.addOnIndicator;
	}

	public void setAddOnIndicator(String addOnIndicator) {
		this.addOnIndicator = addOnIndicator;
	}

	public Date getAvailableEndDt() {
		return this.availableEndDt;
	}

	public void setAvailableEndDt(Date availableEndDt) {
		this.availableEndDt = availableEndDt;
	}

	public Date getAvailableStartDt() {
		return this.availableStartDt;
	}

	public void setAvailableStartDt(Date availableStartDt) {
		this.availableStartDt = availableStartDt;
	}

	public byte[] getMailContentExt() {
		return this.mailContentExt;
	}

	public void setMailContentExt(byte[] mailContentExt) {
		this.mailContentExt = mailContentExt;
	}

	public byte[] getMailPackageNameExt() {
		return this.mailPackageNameExt;
	}

	public void setMailPackageNameExt(byte[] mailPackageNameExt) {
		this.mailPackageNameExt = mailPackageNameExt;
	}

	public String getMainServiceId() {
		return this.mainServiceId;
	}

	public void setMainServiceId(String mainServiceId) {
		this.mainServiceId = mainServiceId;
	}

	public int getMaxQuantity() {
		return this.maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public int getMinQuantity() {
		return this.minQuantity;
	}

	public void setMinQuantity(int minQuantity) {
		this.minQuantity = minQuantity;
	}

	public String getPackageDesc() {
		return this.packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}


	public AppGroup getAppGroup() {
		return appGroup;
	}

	public void setAppGroup(AppGroup appGroup) {
		this.appGroup = appGroup;
	}

	public byte[] getPackageHowtoTooltip() {
		return this.packageHowtoTooltip;
	}

	public void setPackageHowtoTooltip(byte[] packageHowtoTooltip) {
		this.packageHowtoTooltip = packageHowtoTooltip;
	}

	public String getPackageId() {
		return this.packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public int getPackageSeq() {
		return this.packageSeq;
	}

	public void setPackageSeq(int packageSeq) {
		this.packageSeq = packageSeq;
	}

	public String getPackageStatus() {
		return this.packageStatus;
	}

	public void setPackageStatus(String packageStatus) {
		this.packageStatus = packageStatus;
	}

	public String getPublishedBy() {
		return this.publishedBy;
	}

	public void setPublishedBy(String publishedBy) {
		this.publishedBy = publishedBy;
	}

	public Date getPublishedDt() {
		return this.publishedDt;
	}

	public void setPublishedDt(Date publishedDt) {
		this.publishedDt = publishedDt;
	}

	public String getStackable() {
		return this.stackable;
	}

	public void setStackable(String stackable) {
		this.stackable = stackable;
	}

	public int getTrialDays() {
		return this.trialDays;
	}

	public void setTrialDays(int trialDays) {
		this.trialDays = trialDays;
	}

	public String getTrialIndicator() {
		return this.trialIndicator;
	}

	public void setTrialIndicator(String trialIndicator) {
		this.trialIndicator = trialIndicator;
	}

	public String getTrialSelectionDefault() {
		return this.trialSelectionDefault;
	}

	public void setTrialSelectionDefault(String trialSelectionDefault) {
		this.trialSelectionDefault = trialSelectionDefault;
	}

	public String getTrialSelectionIndicator() {
		return this.trialSelectionIndicator;
	}

	public void setTrialSelectionIndicator(String trialSelectionIndicator) {
		this.trialSelectionIndicator = trialSelectionIndicator;
	}

	public String getTrialSelectionOption() {
		return this.trialSelectionOption;
	}

	public void setTrialSelectionOption(String trialSelectionOption) {
		this.trialSelectionOption = trialSelectionOption;
	}

	public String getUnlimitIndicator() {
		return this.unlimitIndicator;
	}

	public void setUnlimitIndicator(String unlimitIndicator) {
		this.unlimitIndicator = unlimitIndicator;
	}

	public String getUnpublishedBy() {
		return this.unpublishedBy;
	}

	public void setUnpublishedBy(String unpublishedBy) {
		this.unpublishedBy = unpublishedBy;
	}

	public Date getUnpublishedDt() {
		return this.unpublishedDt;
	}

	public void setUnpublishedDt(Date unpublishedDt) {
		this.unpublishedDt = unpublishedDt;
	}

	public List<AppProduct> getAppProductList() {
		return appProductList;
	}

	public void setAppProductList(List<AppProduct> appProductList) {
		this.appProductList = appProductList;
	}

}