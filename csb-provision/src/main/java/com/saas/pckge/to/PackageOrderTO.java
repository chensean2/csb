/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.to.PackageOrderTO
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
 * v1.0     - Initial Release         jixiaowei                  Mar 4, 2011
 * =====================================================================================
 */
package com.saas.pckge.to;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.csb.common.IAppsConstants;
import com.saas.common.to.SCBaseTO;
import com.saas.product.to.ProductOrderTO;

public class PackageOrderTO extends SCBaseTO {
	private static final long serialVersionUID = -2850132693849517253L;

	private String packageOrderId;
	private String orderId;
	private String packageId;
	private Integer quantityPurchased;
	private String quantityPurchasedAsStr;
	private String packageOrderStatus;
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
	private List<ProductOrderTO> productOrderList;
	private String stackable;// STACKABLE
	private String oldDomainPackageId;// OLD_DOMAIN_PACKAGE_ID
	private String oldDomainPackageName;
	private String oldPackageId;

	private String productDetails;
	private int productOrderListNum;
	private String reason;
	private String tag;
	private String trialSelectionIndicator;
	private String trialSelectionOption;
	private String trialSelectionDefault;
	private String[] selectionOptionVales;
	private String[] selectionOptionLables;
	
	private String previousPackageName;
	private boolean combineIndicator;

	
	public String getPreviousPackageName() {
		return previousPackageName;
	}

	public void setPreviousPackageName(String previousPackageName) {
		this.previousPackageName = previousPackageName;
	}
	
	public boolean isCombineIndicator() {
		return combineIndicator;
	}

	public void setCombineIndicator(boolean combineIndicator) {
		this.combineIndicator = combineIndicator;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getOldDomainPackageName() {
		return oldDomainPackageName;
	}

	public void setOldDomainPackageName(String oldDomainPackageName) {
		this.oldDomainPackageName = oldDomainPackageName;
	}

	public void setProductOrderListNum(int productOrderListNum) {
		this.productOrderListNum = productOrderListNum;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getProductOrderListNum() {
		if (null == productOrderList || productOrderList.isEmpty()) {
			return 0;
		}
		return productOrderList.size();
	}

	public List<ProductOrderTO> getProductOrderList() {
		return productOrderList;
	}

	public void setProductOrderList(List<ProductOrderTO> productOrderList) {
		this.productOrderList = productOrderList;
	}

	public void setProductOrderListTO(int i, ProductOrderTO productOrderTO) {
		while (i >= productOrderList.size()) {
			productOrderList.add(null);
		}
		productOrderList.set(i, productOrderTO);
	}

	public ProductOrderTO getProductOrderListTO(int i) {
		if (productOrderList == null) {
			productOrderList = new ArrayList<ProductOrderTO>();
		}
		while (i >= productOrderList.size()) {
			productOrderList.add(new ProductOrderTO());
		}
		return productOrderList.get(i);
	}

	public String getPackageOrderId() {
		return packageOrderId;
	}

	public void setPackageOrderId(String packageOrderId) {
		this.packageOrderId = packageOrderId;
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

	public Integer getQuantityPurchased() {
		return quantityPurchased;
	}

	public void setQuantityPurchased(Integer quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
		this.quantityPurchasedAsStr = quantityPurchased.toString();
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

	public String getProvisionedDtAsStr() {
		return DateFormatUtils.format(this.provisionedDt,
				IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
	}

	public String getTrialStartDtAsStr() {
		return DateFormatUtils.format(this.trialStartDt,
				IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
	}

	public String getTrialEndDtAsStr() {
		return DateFormatUtils.format(this.trialEndDt,
				IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
	}

	public String getContractStartDtAsStr() {
		return DateFormatUtils.format(this.contractStartDt,
				IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
	}

	public String getContractEndDtAsStr() {
		return DateFormatUtils.format(this.contractEndDt,
				IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
	}

	public String getAvailableStartDtAsStr() {
		return DateFormatUtils.format(this.availableStartDt,
				IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
	}

	public String getAvailableEndDtAsStr() {
		return DateFormatUtils.format(this.availableEndDt,
				IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
	}

	public String getPublishedDtAsStr() {
		return DateFormatUtils.format(this.publishedDt,
				IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
	}

	public String getUnpublishedDtAsStr() {
		return DateFormatUtils.format(this.unpublishedDt,
				IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
	}

	public String getQuantityPurchasedAsStr() {
		return quantityPurchasedAsStr;
	}

	public void setQuantityPurchasedAsStr(String quantityPurchasedAsStr) {
		this.quantityPurchasedAsStr = quantityPurchasedAsStr;
		try {
			this.quantityPurchased = Integer
					.valueOf((quantityPurchasedAsStr == null || quantityPurchasedAsStr
							.length() == 0) ? "0" : quantityPurchasedAsStr);
		} catch (Exception e) {

		}
	}

	public String getStackable() {
		return stackable;
	}

	public void setStackable(String stackable) {
		this.stackable = stackable;
	}

	public String getOldDomainPackageId() {
		return oldDomainPackageId;
	}

	public void setOldDomainPackageId(String oldDomainPackageId) {
		this.oldDomainPackageId = oldDomainPackageId;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

        public String getOldPackageId() {
            return oldPackageId;
        }

        public void setOldPackageId(String oldPackageId) {
            this.oldPackageId = oldPackageId;
        }

        public String getTrialSelectionIndicator() {
            return trialSelectionIndicator;
        }

        public void setTrialSelectionIndicator(String trialSelectionIndicator) {
            this.trialSelectionIndicator = trialSelectionIndicator;
        }

        public String getTrialSelectionOption() {
            return trialSelectionOption;
        }

        public void setTrialSelectionOption(String trialSelectionOption) {
            this.trialSelectionOption = trialSelectionOption;
        }

        public String getTrialSelectionDefault() {
            return trialSelectionDefault;
        }

        public void setTrialSelectionDefault(String trialSelectionDefault) {
            this.trialSelectionDefault = trialSelectionDefault;
        }

        public String[] getSelectionOptionVales() {
            return selectionOptionVales;
        }

        public void setSelectionOptionVales(String[] selectionOptionVales) {
            this.selectionOptionVales = selectionOptionVales;
        }

        public String[] getSelectionOptionLables() {
            return selectionOptionLables;
        }

        public void setSelectionOptionLables(String[] selectionOptionLables) {
            this.selectionOptionLables = selectionOptionLables;
        }

}
