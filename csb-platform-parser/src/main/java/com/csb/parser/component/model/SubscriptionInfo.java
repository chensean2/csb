package com.csb.parser.component.model;

public class SubscriptionInfo {

    // For platform trace the request, e.g. you can use orderPlanId
    private String traceId;

    // the app provider id
    private String appProviderId;

    // IAAS,PAAS,SAAS
    private String category;

    // CREATE,UPDATE,CANCEL,NOTICE
    private String action;

    // For IAAS type
    private IaaSInfo iaasInfo;

    // For PAAS type
    private PaaSInfo paasInfo;

    // For SAAS type
    private SaaSInfo saasInfo;


}
