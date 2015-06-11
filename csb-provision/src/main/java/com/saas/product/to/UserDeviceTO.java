/*
 *  =========================================================================
 * Program Name: package com.saas.product.to.UserProductTO
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

import org.springframework.context.ApplicationContext;

import com.saas.common.to.SCBaseTO;

public class UserDeviceTO extends SCBaseTO {

    private static final long serialVersionUID = -7790798564116069905L;
    private ApplicationContext appContext;
    private String userDeviceId;
    private String userId;
    private String userDeviceMapId;
    private Integer deviceSeq;
    private String statusType;
    private String deviceStatus;
    private String proDescCodeId;

    private String hideIndicator;

    private String deviceRefId;
    private String deviceRefKey;
    private String deviceName;
    private String deviceDesc;
    private String deviceType;
    private String prefixNum;
    private String postfixDeviceDesc;

    private String ext1;//usage
    private String ext2;//Activation date
    private String ext3;//Activation status:S/F/NULL
    private String ext4;//Last backup date

    private Boolean isNewItem = true;

    private String deviceLogoOnPath;// LOGO_ON_PATH
    private String deviceLogoOffPath;// LOGO_OFF_PATH
    
    
    private String activationResStatus;

    private String mobileNum;
    
    public String getPrefixNum() {
        return prefixNum;
    }

    public void setPrefixNum(String prefixNum) {
        this.prefixNum = prefixNum;
    }

    public String getPostfixDeviceDesc() {
        return postfixDeviceDesc;
    }

    public void setPostfixDeviceDesc(String postfixDeviceDesc) {
        this.postfixDeviceDesc = postfixDeviceDesc;
    }

    public String getActivationResStatus() {
        return activationResStatus;
    }

    public void setActivationResStatus(String activationResStatus) {
        this.activationResStatus = activationResStatus;
    }

    public String getDeviceLogoOnPath() {
        return deviceLogoOnPath;
    }

    public void setDeviceLogoOnPath(String deviceLogoOnPath) {
        this.deviceLogoOnPath = deviceLogoOnPath;
    }

    public String getDeviceLogoOffPath() {
        return deviceLogoOffPath;
    }

    public void setDeviceLogoOffPath(String deviceLogoOffPath) {
        this.deviceLogoOffPath = deviceLogoOffPath;
    }

    public Boolean getIsNewItem() {
        return isNewItem;
    }

    public void setIsNewItem(Boolean isNewItem) {
        this.isNewItem = isNewItem;
    }

    public String getUserDeviceId() {
        return userDeviceId;
    }

    public void setUserDeviceId(String userDeviceId) {
        this.userDeviceId = userDeviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserDeviceMapId() {
        return userDeviceMapId;
    }

    public void setUserDeviceMapId(String userDeviceMapId) {
        this.userDeviceMapId = userDeviceMapId;
    }

    public Integer getDeviceSeq() {
        return deviceSeq;
    }

    public void setDeviceSeq(Integer deviceSeq) {
        this.deviceSeq = deviceSeq;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getDeviceRefId() {
        return deviceRefId;
    }

    public void setDeviceRefId(String deviceRefId) {
        this.deviceRefId = deviceRefId;
    }

    public String getDeviceRefKey() {
        return deviceRefKey;
    }

    public void setDeviceRefKey(String deviceRefKey) {
        this.deviceRefKey = deviceRefKey;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }


    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc = deviceDesc;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getProDescCodeId() {
        return proDescCodeId;
    }

    public void setProDescCodeId(String proDescCodeId) {
        this.proDescCodeId = proDescCodeId;
    }

    public String getHideIndicator() {
        return hideIndicator;
    }

    public void setHideIndicator(String hideIndicator) {
        this.hideIndicator = hideIndicator;
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

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

}
