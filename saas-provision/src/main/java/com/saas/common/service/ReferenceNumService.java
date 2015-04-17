/*
 *  =========================================================================
 * Program Name: package com.saas.common.service.ReferenceNumService
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
 * v1.0     - Initial Release         jixiaowei                  Mar 17, 2011
 * =====================================================================================
 */
package com.saas.common.service;

import java.util.List;

import com.saas.common.to.ReferenceNumTO;

public interface ReferenceNumService {

    /**
     * this method is used to create ReferenceNum
     * version: 1.3.0
     */
    public void createReferenceNum(ReferenceNumTO referenceNum);

    /**
     * this method is used to update ReferenceNum
     * version: 1.3.0
     */
    public void updateReferenceNum(ReferenceNumTO referenceNum);

    /**
     * this method is used to delete ReferenceNum
     * version: 1.3.0
     */
    public void deleteReferenceNum(ReferenceNumTO referenceNum);

    /**
     * this method is used to search ReferenceNum
     * version: 1.3.0
     */
    public ReferenceNumTO getReferenceNum(ReferenceNumTO referenceNum);

    /**
     * this method is used to get ReferenceNum List
     * version: 1.3.0
     */
    public List<ReferenceNumTO> getReferenceNumList(ReferenceNumTO referenceNum);

    /**
     * this method is used to search ReferenceNum
     * version: 1.3.0
     */
    public List<ReferenceNumTO> searchReferenceNumList(ReferenceNumTO referenceNum);
    
    /**
     * this method is used to generate ReferenceNum
     * 
     */
    public String generateReferenceNum(String refId);

}