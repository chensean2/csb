/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.to.Domain2PackageTO
 *
 * Copyright 2009 saas Pte. Ltd. All Rights Reserved
 *
 * This software is confidential and proprietary to saas Pte. Ltd. You shall
 * use this software only in accordance with the terms of the license
 * agreement you entered into with saas.  No aspect or part or all of this
 * software may be reproduced, modified or disclosed without full and
 * direct written authorisation from saas.
 *
 * saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 * REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 * SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 * FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * Change Revision
 * ----------------------------------------------------------------------------
 * Version    Remarks                  Author        Editor          Date
 * v1.0     - Initial Release         samyang                  Mar 4, 2011
 * =====================================================================================
 */
package com.saas.pckge.to;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.csb.common.IAppsConstants;
import com.saas.common.to.SCBaseTO;

public class Domain2PackageTO extends SCBaseTO {
    private static final long serialVersionUID = -3530837558452387635L;

    private String domainPackageId;
    private String domainPackageStatus;
    private Integer quantityPurchased;
    private String domainId;
    private String orderId;
    private String packageId;
    private String provisionedBy;
    private Timestamp provisionedDt;
    private Timestamp trialStartDt;
    private Timestamp trialEndDt;
    private Timestamp contractStartDt;
    private Timestamp contractEndDt;
    private String packageName;
    private String packageDesc;
    private String packageGroupId;
    private String packageStatus;
    private String addOnIndicator;
    private Integer minQuantity;
    private Integer maxQuantity;
    private String unlimitIndicator;
    private String trialIndicator;
    private Integer trialDays;
    private Timestamp availableStartDt;
    private Timestamp availableEndDt;
    private Timestamp publishedDt;
    private String publishedBy;
    private Timestamp unpublishedDt;
    private String unpublishedBy;
    private int domainProductListNum;
    private List<Domain2ProductTO> domainProductList;
    private Integer maxLicenseAssigned; // max listen asign number
    private List<PackageTO> sameGroupPackageList;
    private Timestamp requestedDt;
    private String requestedBy;
    private Integer quantity;
    private Integer licenseAssigned;
    private String orderRefNum;
    private Timestamp orderProcessDt;
    private String orderProcessBy;
    private String stackable;// STACKABLE
    private String transferRefId;// TRANSFER_REF_ID
    private String orderSequence;// ORDER_SEQUENCE
    private String contractStartDtAsStr;
    private String requestedDtAsStr;
    private String orderProcessDtAsStr;

    private String totalLicenseAssigned;
    private String totalLicenseLeft;
    private String totalLicensePurchased;
    private String oldDomainPackageId;
    private Timestamp lastSendTrialRemainderDt; 
    private String mainProductServiceId;
    private String packageHowtoTooltip;
    
    private String previousPackageName;
    private boolean combineIndicator = false; 
    
    private String provisionStatus;
    private String provisionType;
    
    //For group package
    private boolean groupSkipIndicator = false;
    private List<Integer> groupPackageIndexList = new ArrayList<Integer>();
    private Integer groupSize;
    
    //Domain2product EXT1 Status:Supspend, to be suspend ,active, null
    private String domain2productStatus;
    
    private String licenceQuota;
    private String licencePlan;
    
    public String getDomain2productStatus() {
        return domain2productStatus;
    }

    public void setDomain2productStatus(String domain2productStatus) {
        this.domain2productStatus = domain2productStatus;
    }

    public Integer getGroupSize() {
        return groupPackageIndexList.size();
    }

    public void setGroupSize(Integer groupSize) {
        this.groupSize = groupSize;
    }

    public List<Integer> getGroupPackageIndexList() {
        return groupPackageIndexList;
    }

    public void setGroupPackageIndexList(List<Integer> groupPackageIndexList) {
        this.groupPackageIndexList = groupPackageIndexList;
    }

    public boolean isGroupSkipIndicator() {
        return groupSkipIndicator;
    }

    public void setGroupSkipIndicator(boolean groupSkipIndicator) {
        this.groupSkipIndicator = groupSkipIndicator;
    }

    public String getOldDomainPackageId() {
        return oldDomainPackageId;
    }

    public void setOldDomainPackageId(String oldDomainPackageId) {
        this.oldDomainPackageId = oldDomainPackageId;
    }

    public String getProvisionStatus() {
        return provisionStatus;
    }

    public void setProvisionStatus(String provisionStatus) {
        this.provisionStatus = provisionStatus;
    }

    public String getProvisionType() {
        return provisionType;
    }

    public void setProvisionType(String provisionType) {
        this.provisionType = provisionType;
    }

    public String getTotalLicenseLeft() {
        return totalLicenseLeft;
    }

    public void setTotalLicenseLeft(String totalLicenseLeft) {
        this.totalLicenseLeft = totalLicenseLeft;
    }

    public String getTotalLicenseAssigned() {
        return totalLicenseAssigned;
    }

    public void setTotalLicenseAssigned(String totalLicenseAssigned) {
        this.totalLicenseAssigned = totalLicenseAssigned;
    }

    public String getTotalLicensePurchased() {
        return totalLicensePurchased;
    }

    public void setTotalLicensePurchased(String totalLicensePurchased) {
        this.totalLicensePurchased = totalLicensePurchased;
    }

    public String getDomainPackageId() {
        return domainPackageId;
    }

    public void setDomainPackageId(String domainPackageId) {
        this.domainPackageId = domainPackageId;
    }

    public String getDomainPackageStatus() {
        return domainPackageStatus;
    }

    public void setDomainPackageStatus(String domainPackageStatus) {
        this.domainPackageStatus = domainPackageStatus;
    }

    public Integer getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(Integer quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getProvisionedBy() {
        return provisionedBy;
    }

    public void setProvisionedBy(String provisionedBy) {
        this.provisionedBy = provisionedBy;
    }

    public Timestamp getProvisionedDt() {
        return provisionedDt;
    }

    public void setProvisionedDt(Timestamp provisionedDt) {
        this.provisionedDt = provisionedDt;
    }

    public Timestamp getTrialStartDt() {
        return trialStartDt;
    }

    public void setTrialStartDt(Timestamp trialStartDt) {
        this.trialStartDt = trialStartDt;
    }

    public Timestamp getTrialEndDt() {
        return trialEndDt;
    }

    public void setTrialEndDt(Timestamp trialEndDt) {
        this.trialEndDt = trialEndDt;
    }

    public Timestamp getContractStartDt() {
        return contractStartDt;
    }

    public void setContractStartDt(Timestamp contractStartDt) {
        this.contractStartDt = contractStartDt;
    }

    public Timestamp getContractEndDt() {
        return contractEndDt;
    }

    public void setContractEndDt(Timestamp contractEndDt) {
        this.contractEndDt = contractEndDt;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageDesc() {
        return packageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }

    public String getPackageGroupId() {
        return packageGroupId;
    }

    public void setPackageGroupId(String packageGroupId) {
        this.packageGroupId = packageGroupId;
    }

    public String getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(String packageStatus) {
        this.packageStatus = packageStatus;
    }

    public String getAddOnIndicator() {
        return addOnIndicator;
    }

    public void setAddOnIndicator(String addOnIndicator) {
        this.addOnIndicator = addOnIndicator;
    }

    public Integer getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Integer minQuantity) {
        this.minQuantity = minQuantity;
    }

    public Integer getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(Integer maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public String getProvisionedDtAsStr() {
        return DateFormatUtils.format(this.provisionedDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

    public String getTrialStartDtAsStr() {
        return DateFormatUtils.format(this.trialStartDt, IAppsConstants.DATEFORMAT_D_M_Y);
    }

    public String getTrialEndDtAsStr() {
        return DateFormatUtils.format(this.trialEndDt, IAppsConstants.DATEFORMAT_D_M_Y);
    }

    public String getContractStartDtAsStr() {
        return DateFormatUtils.format(this.contractStartDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

    public String getContractEndDtAsStr() {
        return DateFormatUtils.format(this.contractEndDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

    public String getUnlimitIndicator() {
        return unlimitIndicator;
    }

    public void setUnlimitIndicator(String unlimitIndicator) {
        this.unlimitIndicator = unlimitIndicator;
    }

    public String getTrialIndicator() {
        return trialIndicator;
    }

    public void setTrialIndicator(String trialIndicator) {
        this.trialIndicator = trialIndicator;
    }

    public Integer getTrialDays() {
        return trialDays;
    }

    public void setTrialDays(Integer trialDays) {
        this.trialDays = trialDays;
    }

    public Timestamp getAvailableStartDt() {
        return availableStartDt;
    }

    public void setAvailableStartDt(Timestamp availableStartDt) {
        this.availableStartDt = availableStartDt;
    }

    public Timestamp getAvailableEndDt() {
        return availableEndDt;
    }

    public void setAvailableEndDt(Timestamp availableEndDt) {
        this.availableEndDt = availableEndDt;
    }

    public Timestamp getPublishedDt() {
        return publishedDt;
    }

    public void setPublishedDt(Timestamp publishedDt) {
        this.publishedDt = publishedDt;
    }

    public String getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(String publishedBy) {
        this.publishedBy = publishedBy;
    }

    public Timestamp getUnpublishedDt() {
        return unpublishedDt;
    }

    public void setUnpublishedDt(Timestamp unpublishedDt) {
        this.unpublishedDt = unpublishedDt;
    }

    public String getUnpublishedBy() {
        return unpublishedBy;
    }

    public void setUnpublishedBy(String unpublishedBy) {
        this.unpublishedBy = unpublishedBy;
    }

    public Timestamp getRequestedDt() {
        return requestedDt;
    }

    public void setRequestedDt(Timestamp requestedDt) {
        this.requestedDt = requestedDt;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getLicenseAssigned() {
        return licenseAssigned;
    }

    public void setLicenseAssigned(Integer licenseAssigned) {
        this.licenseAssigned = licenseAssigned;
    }

    public String getOrderRefNum() {
        return orderRefNum;
    }

    public void setOrderRefNum(String orderRefNum) {
        this.orderRefNum = orderRefNum;
    }

    public Timestamp getOrderProcessDt() {
        return orderProcessDt;
    }

    public void setOrderProcessDt(Timestamp orderProcessDt) {
        this.orderProcessDt = orderProcessDt;
    }

    public String getOrderProcessBy() {
        return orderProcessBy;
    }

    public void setOrderProcessBy(String orderProcessBy) {
        this.orderProcessBy = orderProcessBy;
    }

    public String getAvailableStartDtAsStr() {
        return DateFormatUtils.format(this.availableStartDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

    public String getAvailableEndDtAsStr() {
        return DateFormatUtils.format(this.availableEndDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

    public String getPublishedDtAsStr() {
        return DateFormatUtils.format(this.publishedDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

    public String getUnpublishedDtAsStr() {
        return DateFormatUtils.format(this.unpublishedDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

    public int getDomainProductListNum() {
        return domainProductListNum;
    }

    public void setDomainProductListNum(int domainProductListNum) {
        this.domainProductListNum = domainProductListNum;
    }

    public String getRequestedDtAsStr() {
        return DateFormatUtils.format(this.requestedDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

    public String getOrderProcessDtAsStr() {
        return DateFormatUtils.format(this.orderProcessDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

    public List<Domain2ProductTO> getDomainProductList() {
        return domainProductList;
    }

    public void setDomainProductList(List<Domain2ProductTO> domainProductList) {
        this.domainProductList = domainProductList;
    }

    public List<PackageTO> getSameGroupPackageList() {
        return sameGroupPackageList;
    }

    public void setSameGroupPackageList(List<PackageTO> sameGroupPackageList) {
        this.sameGroupPackageList = sameGroupPackageList;
    }

    public String getLengthOfDomain2ProductList() {
        if (null == domainProductList || domainProductList.isEmpty()) {
            return "0";
        }

        return String.valueOf(domainProductList.size());
    }

    public String getStackable() {
        return stackable;
    }

    public void setStackable(String stackable) {
        this.stackable = stackable;
    }

    public String getTransferRefId() {
        return transferRefId;
    }

    public void setTransferRefId(String transferRefId) {
        this.transferRefId = transferRefId;
    }

    public String getOrderSequence() {
        return orderSequence;
    }

    public void setOrderSequence(String orderSequence) {
        this.orderSequence = orderSequence;
    }

    public Timestamp getLastSendTrialRemainderDt() {
		return lastSendTrialRemainderDt;
	}

	public void setLastSendTrialRemainderDt(Timestamp lastSendTrialRemainderDt) {
		this.lastSendTrialRemainderDt = lastSendTrialRemainderDt;
	}

	public void setContractStartDtAsStr(String contractStartDtAsStr) {
        this.contractStartDtAsStr = contractStartDtAsStr;
    }

    public void setRequestedDtAsStr(String requestedDtAsStr) {
        this.requestedDtAsStr = requestedDtAsStr;
    }

    public void setOrderProcessDtAsStr(String orderProcessDtAsStr) {
        this.orderProcessDtAsStr = orderProcessDtAsStr;
    }

    public String getMainProductServiceId() {
        return mainProductServiceId;
    }

    public void setMainProductServiceId(String mainProductServiceId) {
        this.mainProductServiceId = mainProductServiceId;
    }

    public Integer getMaxLicenseAssigned() {
        if (null != domainProductList) {
            int max = Integer.parseInt(domainProductList.get(0).getTotalLicenseAssigned());
            for (int i = 0; i < domainProductList.size(); i++) {
                if (max < Integer.parseInt(domainProductList.get(i).getTotalLicenseAssigned())) {
                    max = Integer.parseInt(domainProductList.get(i).getTotalLicenseAssigned());
                }
            }
            return max;
        } else {
            return -1;
        }

    }

    public String getPackageHowtoTooltip() {
        return packageHowtoTooltip;
    }

    public void setPackageHowtoTooltip(String packageHowtoTooltip) {
        this.packageHowtoTooltip = packageHowtoTooltip;
    }

	public void setPreviousPackageName(String previousPackageName) {
		this.previousPackageName = previousPackageName;
	}

	public String getPreviousPackageName() {
		return previousPackageName;
	}

	public void setCombineIndicator(boolean combineIndicator) {
		this.combineIndicator = combineIndicator;
	}

	public boolean isCombineIndicator() {
		return combineIndicator;
	}

	public String getLicenceQuota() {
		return licenceQuota;
	}

	public void setLicenceQuota(String licenceQuota) {
		this.licenceQuota = licenceQuota;
	}

	public String getLicencePlan() {
		return licencePlan;
	}

	public void setLicencePlan(String licencePlan) {
		this.licencePlan = licencePlan;
	}

}
