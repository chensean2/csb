package com.csb.parser.component.model;

public class SubscriptionInfo {

    // For platform trace the request, e.g. you can use orderPlanId
    private String traceId;

    // the app provider id
    private String appProviderId;

    // IAAS,PAAS,SAAS
    private String type;

    // CREATE,UPDATE,CANCEL,NOTICE
    private String action;

    // For IAAS type
    private IaaSInfo iaasInfo;

    // For PAAS type
    private PaaSInfo paasInfo;

    // For SAAS type
    private SaaSInfo saasInfo;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getAppProviderId() {
        return appProviderId;
    }

    public void setAppProviderId(String appProviderId) {
        this.appProviderId = appProviderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public IaaSInfo getIaasInfo() {
        return iaasInfo;
    }

    public void setIaasInfo(IaaSInfo iaasInfo) {
        this.iaasInfo = iaasInfo;
    }

    public PaaSInfo getPaasInfo() {
        return paasInfo;
    }

    public void setPaasInfo(PaaSInfo paasInfo) {
        this.paasInfo = paasInfo;
    }

    public SaaSInfo getSaasInfo() {
        return saasInfo;
    }

    public void setSaasInfo(SaaSInfo saasInfo) {
        this.saasInfo = saasInfo;
    }

}
