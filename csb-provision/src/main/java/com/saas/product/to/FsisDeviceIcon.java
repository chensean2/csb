package com.saas.product.to;

public class FsisDeviceIcon extends DeviceIcon{
    
    private String serviceId;
    
    private String userProductId;
    
    private String virusDefDate;
    
    private String osVersion;
    
    private String applicationVersion;
    
    private String imei;
    
    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getVirusDefDate() {
        return virusDefDate;
    }

    public void setVirusDefDate(String virusDefDate) {
        this.virusDefDate = virusDefDate;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUserProductId() {
        return userProductId;
    }

    public void setUserProductId(String userProductId) {
        this.userProductId = userProductId;
    }

}
