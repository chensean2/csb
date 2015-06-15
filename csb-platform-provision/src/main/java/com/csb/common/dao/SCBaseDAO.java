/*
 * =========================================================================
 *  Program Name:com.saas.common.dao.SCBaseDAO
 *
 *  Copyright 2009 saas Pte. Ltd. All Rights Reserved
 *
 *  This software is confidential and proprietary to saas Pte. Ltd. You shall
 *  use this software only in accordance with the terms of the license
 *  agreement you entered into with saas.  No aspect or part or all of this
 *  software may be reproduced, modified or disclosed without full and
 *  direct written authorisation from saas.
 *
 *  saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 *  REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 *  SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 *  FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 *  MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 *  Change Revision
 * ----------------------------------------------------------------------------
 *  Version    Remarks	              Author	    Editor          Date
 *  v1.0       - Initial Release	  zhujun	                    23/11/2009
 * =====================================================================================
 */

package com.csb.common.dao;

import com.saas.common.to.SCBaseTO;

public interface SCBaseDAO {

    public int create(SCBaseTO scBaseTO);

    public int update(SCBaseTO scBaseTO);

    public int delete(SCBaseTO scBaseTO);

    public SCBaseTO queryForObject(SCBaseTO scBaseTO);
    
    public int createHistory(String transactionId, SCBaseTO destHistorySCBaseTO, SCBaseTO oriSCBaseTO);
}
