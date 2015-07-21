package com.csb.parser.component.model;

public class SubscriptionInfo {

    // For platform trace the request, e.g. you can use orderPlanId
    private String traceId;

   /* // the app provider id
    private String appProviderId;*/
    
    // the app plan id
    private String appPlanId;

    // IAAS,PAAS,SAAS
    private String category;

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

	public String getAppPlanId() {
		return appPlanId;
	}

	public void setAppPlanId(String appPlanId) {
		this.appPlanId = appPlanId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
