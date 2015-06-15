package com.saas.product.to;

public class UserDeviceIconTO {

    private String userDeviceId;
    private String userId;
    private String userDeviceMapId;
    private String statusType;
    private String deviceStatus;
    private String proDescCodeId;
    private String deviceName;
    private String deviceDesc;
    private String deviceType;
    private String ext1;
    private Boolean isNewItem = true;
    private String deviceLogoOnPath;// LOGO_ON_PATH
    private String deviceLogoOffPath;// LOGO_OFF_PATH

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

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceDesc() {
        return deviceDesc;
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

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public Boolean getIsNewItem() {
        return isNewItem;
    }

    public void setIsNewItem(Boolean isNewItem) {
        this.isNewItem = isNewItem;
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

}
