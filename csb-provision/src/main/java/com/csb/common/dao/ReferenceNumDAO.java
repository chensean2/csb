/*
 *  =========================================================================
 * Program Name: package com.saas.common.dao.ReferenceNumDAO
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
package com.csb.common.dao;

import java.util.List;

import com.saas.common.to.ReferenceNumTO;

public interface ReferenceNumDAO {

    public int createReferenceNum(ReferenceNumTO referenceNum);

    public int updateReferenceNum(ReferenceNumTO referenceNum);

    public int deleteReferenceNum(ReferenceNumTO referenceNum);

    public ReferenceNumTO getReferenceNum(ReferenceNumTO referenceNum);

    public List<ReferenceNumTO> getReferenceNumList(ReferenceNumTO referenceNum);

    public List<ReferenceNumTO> searchReferenceNumList(ReferenceNumTO referenceNum);
    
    public String generateReferenceNum(String refId);

}