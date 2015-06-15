package com.saas.common.to;

public class User2DashboardTO extends SCBaseTO {

	private static final long serialVersionUID = 366082255714569306L;
	private String userDashboardId;
	private String userId;
	private String categoryId;
	private String userProductId;
	private String serviceId;
	private String subServiceId;
	private String positionSeqRow;
	private String positionSeqColumn;
	private String dashboardMode;
	private String positionSeq;

	public String getUserDashboardId() {
		return userDashboardId;
	}

	public void setUserDashboardId(String userDashboardId) {
		this.userDashboardId = userDashboardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getUserProductId() {
		return userProductId;
	}

	public void setUserProductId(String userProductId) {
		this.userProductId = userProductId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getSubServiceId() {
		return subServiceId;
	}

	public void setSubServiceId(String subServiceId) {
		this.subServiceId = subServiceId;
	}

	public String getPositionSeqRow() {
		return positionSeqRow;
	}

	public void setPositionSeqRow(String positionSeqRow) {
		this.positionSeqRow = positionSeqRow;
	}

	public String getPositionSeqColumn() {
		return positionSeqColumn;
	}

	public void setPositionSeqColumn(String positionSeqColumn) {
		this.positionSeqColumn = positionSeqColumn;
	}

	public String getDashboardMode() {
		return dashboardMode;
	}

	public void setDashboardMode(String dashboardMode) {
		this.dashboardMode = dashboardMode;
	}

	public String getPositionSeq() {
		return positionSeq;
	}

	public void setPositionSeq(String positionSeq) {
		this.positionSeq = positionSeq;
	}

}
