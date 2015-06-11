/*
 *  =========================================================================
 * Program Name: package com.saas.product.to.ProductTO
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
package com.saas.product.to;

import com.saas.common.to.SCBaseTO;

public class ProductTO extends SCBaseTO {
    private static final long serialVersionUID = -4780320279340038867L;

    private String productId;
    private String serviceId;
    private String productName;
    private String productDesc;
    private String usageType;
    private Integer usageQuantity;
    private String unlimitIndicator;
    private String usageUnit;
    private String multiLicenseIndicator;
    private String autoAssiginIndicator;
    
    private String ext1;
    private String ext2;
    private String ext3;
    
    

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public Integer getUsageQuantity() {
        return usageQuantity;
    }

    public void setUsageQuantity(Integer usageQuantity) {
        this.usageQuantity = usageQuantity;
    }

    public String getUnlimitIndicator() {
        return unlimitIndicator;
    }

    public void setUnlimitIndicator(String unlimitIndicator) {
        this.unlimitIndicator = unlimitIndicator;
    }

    public String getUsageUnit() {
        return usageUnit;
    }

    public void setUsageUnit(String usageUnit) {
        this.usageUnit = usageUnit;
    }

    public String getMultiLicenseIndicator() {
        return multiLicenseIndicator;
    }

    public void setMultiLicenseIndicator(String multiLicenseIndicator) {
        this.multiLicenseIndicator = multiLicenseIndicator;
    }

    public String getAutoAssiginIndicator() {
        return autoAssiginIndicator;
    }

    public void setAutoAssiginIndicator(String autoAssiginIndicator) {
        this.autoAssiginIndicator = autoAssiginIndicator;
    }
}