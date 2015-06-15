/*
 * =========================================================================
 * Program Name: com.saas.product.to.InterestTO.java
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
 * v1.0     - Initial Release          Wu Ming Shan               Mar 9, 2011
 * =====================================================================================
 */
package com.saas.product.to;

import com.saas.common.to.SCBaseTO;

public class InterestTO extends SCBaseTO {
    private static final long serialVersionUID = -5158311823246949134L;

    private String interestId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNum;
    private String collectConsent;
    private String businessCustomer;
    private String businessRefNum;
    private String remarks;
    private byte[] rawRequest;
    private byte[] rawResponse;

    public String getInterestId() {
        return interestId;
    }

    public void setInterestId(String interestId) {
        this.interestId = interestId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getCollectConsent() {
        return collectConsent;
    }

    public void setCollectConsent(String collectConsent) {
        this.collectConsent = collectConsent;
    }

    public String getBusinessCustomer() {
        return businessCustomer;
    }

    public void setBusinessCustomer(String businessCustomer) {
        this.businessCustomer = businessCustomer;
    }

    public String getBusinessRefNum() {
        return businessRefNum;
    }

    public void setBusinessRefNum(String businessRefNum) {
        this.businessRefNum = businessRefNum;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public byte[] getRawRequest() {
        return rawRequest;
    }

    public void setRawRequest(byte[] rawRequest) {
        this.rawRequest = rawRequest;
    }

    public byte[] getRawResponse() {
        return rawResponse;
    }

    public void setRawResponse(byte[] rawResponse) {
        this.rawResponse = rawResponse;
    }

}
