/*
 *  =========================================================================
 * Program Name: package com.saas.provision.service
 *
 * Copyright 2009 saas Pte. Ltd. All Rights Reserved
 *
 * This software is confidential and proprietary to saas Pte. Ltd. You shall
 * use this software only in accordance with the terms of the license
 * agreement you entered into with saas.  No aspect or part or all of this
 * software may be reproduced, modified or disclosed without full and
 * direct written authorisation from saas.
 *
 * saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 * REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 * SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 * FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * Change Revision
 * ----------------------------------------------------------------------------
 * Version    Remarks                  Author        Editor          Date
 * v1.0     - Initial Release         gengjun                  Mar 25, 2011
 * =====================================================================================
 */
package com.saas.provision.service;

public class IsvConstants {
    public static final String ISV_DOMAIN_SERVICE_REF_ID = "ISV_DOMAIN_SERVICE_REF_ID";
    public static final String ISV_DOMAIN_SERVICE_REF_KEY = "ISV_DOMAIN_SERVICE_REF_KEY";
    public static final String ISV_USER_SERVICE_REF_ID = "ISV_USER_SERVICE_REF_ID";
    public static final String ISV_USER_SERVICE_REF_KEY = "ISV_USER_SERVICE_REF_KEY";
    public static final String ISV_ADAP_GOOGLE_UPDATE_DOMAIN = "GGL-DOMAIN-U";
    public static final String ISV_ADAP_GOOGLE_SUSPEND_DOMAIN = "GGL-DOMAIN-U-S";
    public static final String ISV_ADAP_GOOGLE_UPDATE_USER_PASSWORD = "GGL-USER-U-P";
    public static final String ISV_ADAP_GOOGLE_UPDATE_USER = "GGL-USER-U";
    public static final String ISV_ADAP_GOOGLE_UPDATE_LOGINID = "GGL-USER-U-L";
    public static final String ISV_ADAP_GOOGLE_CREATE_ALIAS = "GGL-ALIAS-C";
    public static final String ISV_ADAP_GOOGLE_DELETE_ALIAS = "GGL-ALIAS-D";
    public static final String ISV_ADAP_GOOGLE_SEARCH_ALIAS = "GGL-ALIAS-S";

    // for adaptor message
    public static final String ISV_ADAP_CODE_TYPE_ID = "SS_ADAP_STATUS";
    public static final String ISV_ADAP_SUCCESS = "10000";
    public static final String ISV_ADAP_ERROR_TIMEOUT = "10001";
    public static final String ISV_ADAP_ERROR = "10002";

    public static final String ISV_ADAP_ERROR_EXIST_COMPANY = "11001";
    public static final String ISV_ADAP_ERROR_EXIST_PRODUCT = "11002";
    public static final String ISV_ADAP_ERROR_EXIST_USER = "11003";
    public static final String ISV_ADAP_ERROR_INVALID_COMPANY = "11004";
    public static final String ISV_ADAP_ERROR_INVALID_PRODUCT = "11005";
    public static final String ISV_ADAP_ERROR_INVALID_USER = "11006";
    public static final String ISV_ADAP_ERROR_INVALID_DOMAIN_NAME = "11007";
    
    public static final String ISV_ADAP_ERROR_NOT_COMPLETED_ORDER = "11008";
    public static final String ISV_ADAP_ERROR_NOT_INPROCESS_ORDER = "11009";
    public static final String ISV_ADAP_ERROR_SAAS_ID_EXISTS = "11010";
    public static final String ISV_ADAP_ERROR_MSISDN_EXISTS = "11011";
    
    public static final String ISV_ADAP_ERROR_WEBFAX_INVALID = "12001";
    public static final String ISV_ADAP_ERROR_WEBFAX_INCOMPLETE = "12002";
    public static final String ISV_ADAP_ERROR_WEBFAX_DUPLICATE = "12003";
    public static final String ISV_ADAP_ERROR_WEBFAX_AUTHENTICATION  = "12004";
    public static final String ISV_ADAP_ERROR_WEBFAX_MSISDN  = "12005";
    public static final String ISV_ADAP_ERROR_WEBFAX_ANNIVERSARYDAY  = "12006";

    public static final String ISV_ADAP_ERROR_GOOGLE_UNABLE_REGISTER_DOMAIN  = "12007";
    public static final String ISV_ADAP_ERROR_GOOGLE_INVALID_DOMAIN_TYPE  = "12008";
    public static final String ISV_ADAP_ERROR_GOOGLE_DOMAIN_NAME_NOT_UNDER_RESELLER  = "12009";
    
    public static final String ISV_ADAP_ERROR_DEPROVISION_AUTO_UNASSIGN  = "13001";
        
    public static final String ISV_ADAP_ERROR_UNKNOWN = "19999";
    
    public static final String ISV_RETURN_CODE_PS_0000 = "PS_0000";
    public static final String ISV_RETURN_CODE_PS_1100 = "PS_1100";
    public static final String ISV_RETURN_CODE_PS_1101 = "PS_1101";
    
    //Adaptor common extra parameters
    public static final String ISV_PARAMTER_PARAMETER1 = "parameter1";
    public static final String ISV_PARAMTER_PARAMETER2 = "parameter2";
    public static final String ISV_PARAMTER_PARAMETER3 = "parameter3";
    public static final String ISV_PARAMTER_PARAMETER4 = "parameter4";
    
    public static final String SERVICE_MAP_USER_ID = "userId";
    public static final String SERVICE_MAP_DOMAIN_ID = "domainId";
    public static final String SERVICE_MAP_SERVICE_LISTS = "servicesList";
    public static final String SERVICE_MAP_ASSIGNED_PRODUCT_NAMES = "assignedProductNames";
    public static final String SERVICE_MAP_JSP_LIST = "jspList";
    public static final String SERVICE_MAP_DOMAIN_PRODUCT_LIST = "domainProductList";

}
