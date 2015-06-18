package com.csb.parser.component.model;

public class AssignmentInfo {

    // For platform trace the request, e.g. you can use useAssignmentId
    private String traceId;

    // the app provider id
    private String appProviderId;

    /**
     * IAAS,PAAS,SAAS
     */
    private String type;

    /**
     * ASSIGN,UNASSIGN
     */
    private String action;

    private IaaSInfo iaasInfo;

    private PaaSInfo paasInfo;

    private SaaSInfo saasInfo;
}
