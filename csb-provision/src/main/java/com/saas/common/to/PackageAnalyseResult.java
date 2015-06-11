package com.saas.common.to;

import java.util.ArrayList;
import java.util.List;

import com.saas.pckge.to.Domain2ProductTO;

public class PackageAnalyseResult {
	
	private String domainPackageId; 
	private String multiLicenseIndicator;
	
	
	
	private List<LicenseTO> newAssginedList = new ArrayList<LicenseTO>();//This list contains items need to assign
	private List<LicenseTO> unAssginList = new ArrayList<LicenseTO>();//This list contains items need to unassign
	private List<LicenseTO> retryAssginList = new ArrayList<LicenseTO>();//This list contains items need to retry
	private List<LicenseTO> hiddenList = new ArrayList<LicenseTO>();//This list contains items need to set hiddenIndicator to 'Y'
	private List<LicenseTO> licenseWithDevicesList = new ArrayList<LicenseTO>();//This list contains license which has devices
	private List<LicenseTO> updateRefKeyItemList = new ArrayList<LicenseTO>();//This list contains items need to update reference key directly
	
	private List<Domain2ProductTO> multiDomain2ProductList = new ArrayList<Domain2ProductTO>();
	private List<List<Domain2ProductTO>> multiAssign4OtherServiceList = new ArrayList<List<Domain2ProductTO>>();
    private List<List<Domain2ProductTO>> multiUnAssign4OtherServiceList = new ArrayList<List<Domain2ProductTO>>();
	
    public String getDomainPackageId() {
		return domainPackageId;
	}
	public void setDomainPackageId(String domainPackageId) {
		this.domainPackageId = domainPackageId;
	}
	
	public String getMultiLicenseIndicator() {
		return multiLicenseIndicator;
	}
	public void setMultiLicenseIndicator(String multiLicenseIndicator) {
		this.multiLicenseIndicator = multiLicenseIndicator;
	}
    
	public List<LicenseTO> getRetryAssginList() {
		return retryAssginList;
	}
	public void setRetryAssginList(List<LicenseTO> retryAssginList) {
		this.retryAssginList = retryAssginList;
	}
	public List<LicenseTO> getUpdateRefKeyItemList() {
		return updateRefKeyItemList;
	}
	public void setUpdateRefKeyItemList(List<LicenseTO> updateRefKeyItemList) {
		this.updateRefKeyItemList = updateRefKeyItemList;
	}
	public List<LicenseTO> getLicenseWithDevicesList() {
		return licenseWithDevicesList;
	}
	public void setLicenseWithDevicesList(List<LicenseTO> licenseWithDevicesList) {
		this.licenseWithDevicesList = licenseWithDevicesList;
	}
	public List<LicenseTO> getHiddenList() {
		return hiddenList;
	}
	public void setHiddenList(List<LicenseTO> hiddenList) {
		this.hiddenList = hiddenList;
	}
	public List<LicenseTO> getUnAssginList() {
		return unAssginList;
	}
	public void setUnAssginList(List<LicenseTO> unAssginList) {
		this.unAssginList = unAssginList;
	}
	public List<LicenseTO> getNewAssginedList() {
		return newAssginedList;
	}
	public void setNewAssginedList(List<LicenseTO> newAssginedList) {
		this.newAssginedList = newAssginedList;
	}
	public List<Domain2ProductTO> getMultiDomain2ProductList() {
		return multiDomain2ProductList;
	}
	public void setMultiDomain2ProductList(
			List<Domain2ProductTO> multiDomain2ProductList) {
		this.multiDomain2ProductList = multiDomain2ProductList;
	}
	public List<List<Domain2ProductTO>> getMultiAssign4OtherServiceList() {
		return multiAssign4OtherServiceList;
	}
	public void setMultiAssign4OtherServiceList(
			List<List<Domain2ProductTO>> multiAssign4OtherServiceList) {
		this.multiAssign4OtherServiceList = multiAssign4OtherServiceList;
	}
	public List<List<Domain2ProductTO>> getMultiUnAssign4OtherServiceList() {
		return multiUnAssign4OtherServiceList;
	}
	public void setMultiUnAssign4OtherServiceList(
			List<List<Domain2ProductTO>> multiUnAssign4OtherServiceList) {
		this.multiUnAssign4OtherServiceList = multiUnAssign4OtherServiceList;
	}
	
}
