/*
 * =========================================================================
 *Program Name:com.saas.sso.service.SSOService
 *
 *Copyright 2010 saas Pte. Ltd. All Rights Reserved
 *
 *This software is confidential and proprietary to saas Pte. Ltd. You shall
 *use this software only in accordance with the terms of the license
 *agreement you entered into with saas.  No aspect or part or all of this
 *software may be reproduced, modified or disclosed without full and
 *direct written authorisation from saas.
 *
 *saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 *REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 *SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 *FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 *MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 *Change Revision
 *----------------------------------------------------------------------------
 *Version    Remarks	              Author	    Editor          Date
 *v1.0     - Initial Release	     xiaowei	                   Apr 1, 2010
 *=====================================================================================
 */
package com.saas.sso.service;

import java.util.Map;

import com.csb.common.exception.SCException;

public interface SSOService {
    public String generateSamlResponse(String username, String domainName, String acsUrl, String requestId)
            throws SCException;
    
    public String generateSamlResponseXMLStr4CommonTemplate(String userName, String acsUrl, String email, boolean isEncoded) throws SCException ;
    
    public String signResponse(String response) throws SCException;


    
    
    /**
     * This method is used to generate, encode saml response, this response will direct to service provider.
     * @param subjectType
     * @param certFilePath: e.g. C:/saasconnect/SSO/keys/OfficeAppsKeyStore/officeappssso.crt
     * @param privateKeyFilePath: e.g C:/saasconnect/SSO/keys/OfficeAppsKeyStore/officeappssso.pem
     * @param acsUrl : e.g. http://optussmb.qa.steek.com/simplesaml/module.php/saml/sp/saml2-acs.php/default-sp
     * @param issuer the issuer
     * @param loginId
     * @param customAttributes: define custom attributes
     * @return
     */
    public String generateOpenSamlResponse(String subjectType, String certFilePath, String privateKeyFilePath, String acsUrl, String issuer, String loginId, Map<String, String> customAttributes);
}
