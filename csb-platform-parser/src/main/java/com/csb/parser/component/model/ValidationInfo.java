package com.csb.parser.component.model;

import java.util.Map;

public class ValidationInfo {

    // the app provider id
    private String appProviderId;

    // IAAS,PAAS,SAAS
    private String type;

    private Map<String, String> validateParameterMap;

}
