package com.saas.provision.util;

import java.util.Map;

public interface IsvSvc {
    
    public static final String SERVICE_DEF_NAME_GOOGLE = "GOOGLE";
    public static final String SERVICE_DEF_NAME_FSMOBILE= "FSMOBILE";
    public static final String SERVICE_DEF_NAME_COMMON = "COMMON";
    
    public static final String SERVICE_DEF_CATEGORY_USER = "USER";
    public static final String SERVICE_DEF_CATEGORY_COMPANY = "COMPANY";
    public static final String SERVICE_DEF_CATEGORY_SERVICE = "SERVICE";
    public static final String SERVICE_DEF_CATEGORY_PROVISION = "PROVISION";
    public static final String SERVICE_DEF_CATEGORY_ASSIGN = "ASSIGN";
    
    public static final String SERVICE_DEF_OPERATION_USERAPPS = "USERAPPS";
    public static final String SERVICE_DEF_OPERATION_CREATE = "CREATE";
    public static final String SERVICE_DEF_OPERATION_UPDATE = "UPDATE";
    public static final String SERVICE_DEF_OPERATION_DELETE = "DELETE";
    public static final String SERVICE_DEF_OPERATION_VALIDATE = "VALIDATE";
    public static final String SERVICE_DEF_OPERATION_DATATRANSFER = "DATATRANSFER";
    public static final String SERVICE_DEF_OPERATION_UPDATEDATATRANSFER = "UPDATEDATATRANSFER";
    public static final String SERVICE_DEF_OPERATION_REFIDVALIDATE = "REFIDVALIDATE";
    public static final String SERVICE_DEF_OPERATION_UPDATEVALIDATE = "UPDATEVALIDATE";
    public static final String SERVICE_DEF_OPERATION_UPDATEPACKAGENAME = "UPDATEPACKAGENAME";
    public static final String SERVICE_DEF_OPERATION_GETCUSTOMERID = "GETCUSTOMERID";
    public static final String SERVICE_DEF_OPERATION_AUTO_ASSIGN = "AUTOASSIGN";
    public static final String SERVICE_DEF_OPERATION_SUSPEND = "SUSPEND";
    public static final String SERVICE_DEF_OPERATION_REINSTATE = "REINSTATE";
    
    
    
    public Map<String, String> getNewParamterMap();
    public Map<String, String> getOldParamterMap();
    public String getServiceName();
    public String getServiceCategory();
    public String getServiceOperation();
    public String getSvcDefVersion();
}
