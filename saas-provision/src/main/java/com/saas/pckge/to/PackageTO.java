/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.to.PackageTO
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
 * v1.3.0     - Initial Release         jixiaowei                  Mar 2, 2011
 * =====================================================================================
 */
package com.saas.pckge.to;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import com.saas.common.IAppsConstants;
import com.saas.common.to.SCBaseTO;
import com.saas.product.to.ProductPackageTO;

public class PackageTO extends SCBaseTO {
    private static final long serialVersionUID = -2689781282282543023L;

    private String packageId;
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

    private String productName;
    private String productDesc;
    private String totalPackageQuantity;
    private List<ProductPackageTO> productPackageList = new ArrayList<ProductPackageTO>();
    private String stackable;//STACKABLE
    private String mailPackageNameExt;//MAIL_PACKAGE_NAME_EXT
    private String mailContentExt;//MAIL_CONTENT_EXT
    private String mainServiceId;
    private String trialSelectionIndicator;
    private String trialSelectionOption;
    private String trialSelectionDefault;
    private String[] selectionOptionVales;
    private String[] selectionOptionLables;
    private String packageHowtoTooltip;
    
    private Integer packageSeq;
    
    private String licenceQuota;
    private String licencePlan;

    public Integer getPackageSeq() {
		return packageSeq;
	}

	public void setPackageSeq(Integer packageSeq) {
		this.packageSeq = packageSeq;
	}

	public String getMailPackageNameExt() {
		return mailPackageNameExt;
	}

	public void setMailPackageNameExt(String mailPackageNameExt) {
		this.mailPackageNameExt = mailPackageNameExt;
	}

	public String getMailContentExt() {
		return mailContentExt;
	}

	public void setMailContentExt(String mailContentExt) {
		this.mailContentExt = mailContentExt;
	}

    
    public String getLengthOfProductPackageList() {
        if(null == productPackageList || productPackageList.isEmpty()) {
            return "0";
        }
        
        return String.valueOf(productPackageList.size());
    }

    public List<ProductPackageTO> getProductPackageList() {
        return productPackageList;
    }

    public void setProductPackageList(List<ProductPackageTO> productList) {
        this.productPackageList = productList;
    }
    
    public void setProductPackageListTO(int i, ProductPackageTO productPackageTO) {
        while (i >= productPackageList.size()) {
            productPackageList.add(null);
        }
        productPackageList.set(i, productPackageTO);
    }

    public ProductPackageTO getProductPackageListTO(int i) {
        if (productPackageList == null) {
            productPackageList = new ArrayList<ProductPackageTO>();
        }
        while (i >= productPackageList.size()) {
            productPackageList.add(new ProductPackageTO());
        }
        return productPackageList.get(i);
    }
    
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getTotalPackageQuantity() {
        return totalPackageQuantity;
    }

    public void setTotalPackageQuantity(String totalPackageQuantity) {
        this.totalPackageQuantity = totalPackageQuantity;
    }

	public String getStackable() {
		return stackable;
	}

	public void setStackable(String stackable) {
		this.stackable = stackable;
	}

    public String getMainServiceId() {
        return mainServiceId;
    }

    public void setMainServiceId(String mainServiceId) {
        this.mainServiceId = mainServiceId;
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

    public String getPackageHowtoTooltip() {
        return packageHowtoTooltip;
    }

    public void setPackageHowtoTooltip(String packageHowtoTooltip) {
        this.packageHowtoTooltip = packageHowtoTooltip;
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
