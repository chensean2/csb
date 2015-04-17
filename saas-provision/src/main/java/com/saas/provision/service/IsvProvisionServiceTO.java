package com.saas.provision.service;

import com.saas.pckge.to.Domain2ProductTO;

public class IsvProvisionServiceTO {

    private static final long serialVersionUID = 2579685039259064610L;
    protected String validateAdaptorBean;
    protected String dataTransferAdaptorBean;
    protected String adaptorBean;
    protected String[] JspArray;
    protected String referenceId;
    protected String serviceId;
    protected String serviceDefName;
    protected String SvcDerfOperation;
    protected String serviceDefCategory;
    protected String serviceDefVersion;

    protected String product2OrderId;
    protected String packageOrderId;
    protected String user2ProductId;
    protected Domain2ProductTO domain2ProductTO;

    protected String isvServiceId;
    protected boolean downgradeService;
    
    protected String updateValidateAdaptorBean;

    public String getProduct2OrderId() {
        return product2OrderId;
    }

    public void setProduct2OrderId(String product2OrderId) {
        this.product2OrderId = product2OrderId;
    }

    public String getUser2ProductId() {
        return user2ProductId;
    }

    public void setUser2ProductId(String user2ProductId) {
        this.user2ProductId = user2ProductId;
    }

    public String getAdaptorBean() {
        return adaptorBean;
    }

    public void setAdaptorBean(String adaptorBean) {
        this.adaptorBean = adaptorBean;
    }

    public String[] getJspArray() {
        return JspArray;
    }

    public void setJspArray(String[] jspArray) {
        JspArray = jspArray;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getSvcDerfOperation() {
        return SvcDerfOperation;
    }

    public void setSvcDerfOperation(String svcDerfOperation) {
        SvcDerfOperation = svcDerfOperation;
    }

    public String getValidateAdaptorBean() {
        return validateAdaptorBean;
    }

    public void setValidateAdaptorBean(String validateAdaptorBean) {
        this.validateAdaptorBean = validateAdaptorBean;
    }

    public String getDataTransferAdaptorBean() {
        return dataTransferAdaptorBean;
    }

    public void setDataTransferAdaptorBean(String dataTransferAdaptorBean) {
        this.dataTransferAdaptorBean = dataTransferAdaptorBean;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceDefName() {
        return serviceDefName;
    }

    public void setServiceDefName(String serviceDefName) {
        this.serviceDefName = serviceDefName;
    }

    public String getServiceDefCategory() {
        return serviceDefCategory;
    }

    public void setServiceDefCategory(String serviceDefCategory) {
        this.serviceDefCategory = serviceDefCategory;
    }

    public String getServiceDefVersion() {
        return serviceDefVersion;
    }

    public void setServiceDefVersion(String serviceDefVersion) {
        this.serviceDefVersion = serviceDefVersion;
    }

    public String getIsvServiceId() {
        return isvServiceId;
    }

    public void setIsvServiceId(String isvServiceId) {
        this.isvServiceId = isvServiceId;
    }

    public Domain2ProductTO getDomain2ProductTO() {
        return domain2ProductTO;
    }

    public void setDomain2ProductTO(Domain2ProductTO domain2ProductTO) {
        this.domain2ProductTO = domain2ProductTO;
    }

    public String getPackageOrderId() {
        return packageOrderId;
    }

    public void setPackageOrderId(String packageOrderId) {
        this.packageOrderId = packageOrderId;
    }

    public boolean isDowngradeService() {
        return downgradeService;
    }

    public void setDowngradeService(boolean downgradeService) {
        this.downgradeService = downgradeService;
    }

    public String getUpdateValidateAdaptorBean() {
        return updateValidateAdaptorBean;
    }

    public void setUpdateValidateAdaptorBean(String updateValidateAdaptorBean) {
        this.updateValidateAdaptorBean = updateValidateAdaptorBean;
    }
    
    
}
