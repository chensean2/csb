package com.saas.common.to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

import com.saas.product.to.UserDeviceTO;

public class LicenseTO {

	private ApplicationContext appContext;
    protected String serviceRefId;
    protected String serviceRefKey;
    protected String email;
    protected String deviceName;
    protected String deviceType;
    protected String deviceMobileNum;
    protected String provisionStatus;
    protected String order;
    protected Boolean isNewItem = true;
    protected String userProductId;
    protected String checkedIndicator;
    protected String hideIndicator;
    protected String statusType;
    protected String serviceId;
    protected String domainProductId;
    protected String deviceRefKey;
    protected String deviceRefValue;
    protected String userDeviceMapId;// stores in user2product ext1, mapping with user2device userDeviceMapId

    private String prefixNum;
    private String postfixNum;
    
    protected int maxDevicesNum;
    protected int currentDevicesNum;
    protected int newDevicesNum;
    
    protected String ext1;
    
    protected boolean showDownloadPopup = false;


    protected List<UserDeviceTO> userDeviceList = new ArrayList<UserDeviceTO>();

    // protected List<UserDeviceTO> newDeviceList = new ArrayList<UserDeviceTO>();
    protected Map<Integer, UserDeviceTO> newDeviceMap = new HashMap<Integer, UserDeviceTO>();

    // This map stores the isv service parameters,it will be used for assign fail item in the service page.
    protected Map<String, String> isvParaMap = new HashMap<String, String>();
    // This map stores the parameters for update user adaptor
    protected Map<String, String> updateAdapterParaMap = new HashMap<String, String>();
    
    protected String[] userParameters;
    
    protected String[] oldUserParameters;

    public Boolean checkRefKeyIsUpdated() {
        // TODO this method should be override
        return false;
    }

    public String[] getPreparedParamters() {
        // TODO this method can be override
        String[] parameters = new String[4];
        parameters[0] = this.deviceType;//Device Type
        parameters[1] = this.deviceName;//Device Name
        parameters[2] = this.email;//Device Email
        //parameters[3] = this.getDeviceMobileNum();//Device Mobile Number
        
        return parameters;
        
//        String[] parameters = {};
//        return parameters;
    }

    public String getPrefixNum() {
        return prefixNum;
    }

    public void setPrefixNum(String prefixNum) {
        this.prefixNum = prefixNum;
    }

    public String getPostfixNum() {
        return postfixNum;
    }

    public void setPostfixNum(String postfixNum) {
        this.postfixNum = postfixNum;
    }

    public Map<String, String> getUpdateAdapterParaMap(UserTO userTO) {
        // TODO this method should be override
        return updateAdapterParaMap;
    }

    public LicenseAnalyseResult analyseLicenseDevices() {
        // TODO this method should be override
        LicenseAnalyseResult licenseAnalyseResult = new LicenseAnalyseResult();
        return licenseAnalyseResult;
    }
    
    public void checkShowDownloadPopup(){
        // TODO this method should be override
    }

    public void setUserDeviceTO(int i, UserDeviceTO userDeviceTO) {
        while (i >= userDeviceList.size()) {
            userDeviceList.add(new UserDeviceTO());
        }
        userDeviceList.set(i, userDeviceTO);
    }

    public UserDeviceTO getUserDeviceTO(int i) {
        if (userDeviceList == null) {
            userDeviceList = new ArrayList<UserDeviceTO>();
        }
        while (i >= userDeviceList.size()) {
            userDeviceList.add(new UserDeviceTO());
        }
        return userDeviceList.get(i);
    }

    /*
     * public void setNewUserDeviceTO(int i, UserDeviceTO userDeviceTO) { while (i >= newDeviceList.size()) {
     * newDeviceList.add(new UserDeviceTO()); } newDeviceList.set(i, userDeviceTO); }
     * 
     * public UserDeviceTO getNewUserDeviceTO(int i) { if (newDeviceList == null) { newDeviceList = new
     * ArrayList<UserDeviceTO>(); } while (i >= newDeviceList.size()) { newDeviceList.add(new UserDeviceTO()); } return
     * newDeviceList.get(i); }
     */

    /*
     * public UserDeviceTO getNewDeviceMap(int i) { if (newDeviceMap.get(String.valueOf(i))==null) {
     * newDeviceMap.put(String.valueOf(i), new UserDeviceTO()); } return newDeviceMap.get(String.valueOf(i)); }
     * 
     * public void setNewDeviceMap(int i, UserDeviceTO userDeviceTO) { newDeviceMap.put(String.valueOf(i),
     * userDeviceTO); }
     */

    public UserDeviceTO getNewDeviceMap(int i) {
        if (newDeviceMap.get(i) == null) {
            newDeviceMap.put(i, new UserDeviceTO());
        }
        return newDeviceMap.get(i);
    }

    public void setNewDeviceMap(int i, UserDeviceTO userDeviceTO) {
        newDeviceMap.put(i, userDeviceTO);
    }

    public Map<String, String> getIsvParaMap() {
        return isvParaMap;
    }

    public void setIsvParaMap(Map<String, String> isvParaMap) {
        this.isvParaMap = isvParaMap;
    }

    public int getMaxDevicesNum() {
        return maxDevicesNum;
    }

    public void setMaxDevicesNum(int maxDevicesNum) {
        this.maxDevicesNum = maxDevicesNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getNewDevicesNum() {
        return this.getNewDeviceMap().size();
    }

    public void setNewDevicesNum(int newDevicesNum) {
        this.newDevicesNum = newDevicesNum;
    }

    public int getCurrentDevicesNum() {
        return this.getUserDeviceList().size();
    }

    public void setCurrentDevicesNum(int currentDevicesNum) {
        this.currentDevicesNum = currentDevicesNum;
    }

    public String getDomainProductId() {
        return domainProductId;
    }

    public void setDomainProductId(String domainProductId) {
        this.domainProductId = domainProductId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getCheckedIndicator() {
        return checkedIndicator;
    }

    public void setCheckedIndicator(String checkedIndicator) {
        this.checkedIndicator = checkedIndicator;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getUserProductId() {
        return userProductId;
    }

    public void setUserProductId(String userProductId) {
        this.userProductId = userProductId;
    }

    public Boolean getIsNewItem() {
        return isNewItem;
    }

    public void setIsNewItem(Boolean isNewItem) {
        this.isNewItem = isNewItem;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getProvisionStatus() {
        return provisionStatus;
    }

    public void setProvisionStatus(String provisionStatus) {
        this.provisionStatus = provisionStatus;
    }

    public String getServiceRefId() {
        return serviceRefId;
    }

    public void setServiceRefId(String serviceRefId) {
        this.serviceRefId = serviceRefId;
    }

    public String getServiceRefKey() {
        return serviceRefKey;
    }

    public void setServiceRefKey(String serviceRefKey) {
        this.serviceRefKey = serviceRefKey;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        if(!StringUtils.isEmpty(deviceName)){
            deviceName = deviceName.trim();
        }
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    

    public void setDeviceMobileNum(String deviceMobileNum) {
        this.deviceMobileNum = deviceMobileNum;
    }

    public String getHideIndicator() {
        return hideIndicator;
    }

    public void setHideIndicator(String hideIndicator) {
        this.hideIndicator = hideIndicator;
    }

    public String getUserDeviceMapId() {
        return userDeviceMapId;
    }

    public void setUserDeviceMapId(String userDeviceMapId) {
        this.userDeviceMapId = userDeviceMapId;
    }

    public String getDeviceRefKey() {
        return deviceRefKey;
    }

    public void setDeviceRefKey(String deviceRefKey) {
        this.deviceRefKey = deviceRefKey;
    }

    public String getDeviceRefValue() {
        return deviceRefValue;
    }

    public void setDeviceRefValue(String deviceRefValue) {
        this.deviceRefValue = deviceRefValue;
    }

    public List<UserDeviceTO> getUserDeviceList() {
        return userDeviceList;
    }

    public void setUserDeviceList(List<UserDeviceTO> userDeviceList) {
        this.userDeviceList = userDeviceList;
    }

    public Map<Integer, UserDeviceTO> getNewDeviceMap() {
        return newDeviceMap;
    }

    public void setNewDeviceMap(Map<Integer, UserDeviceTO> newDeviceMap) {
        this.newDeviceMap = newDeviceMap;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }
    
    public boolean isShowDownloadPopup() {
        return showDownloadPopup;
    }

    public void setShowDownloadPopup(boolean showDownloadPopup) {
        this.showDownloadPopup = showDownloadPopup;
    }
    
    /*
     * public List<UserDeviceTO> getNewDeviceList() { return newDeviceList; }
     * 
     * public void setNewDeviceList(List<UserDeviceTO> newDeviceList) { this.newDeviceList = newDeviceList; }
     */

    public String[] getUserParameters() {
        return userParameters;
    }

    public void setUserParameters(String[] userParameters) {
        this.userParameters = userParameters;
    }

    public String[] getOldUserParameters() {
        return oldUserParameters;
    }

    public void setOldUserParameters(String[] oldUserParameters) {
        this.oldUserParameters = oldUserParameters;
    }

}
