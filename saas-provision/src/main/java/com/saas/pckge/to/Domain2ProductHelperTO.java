/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.to.Domain2ProductTO
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
 * v1.0     - Initial Release         samyang                  Mar 4, 2011
 * =====================================================================================
 */
package com.saas.pckge.to;

import java.util.ArrayList;
import java.util.List;

public class Domain2ProductHelperTO {
	private List<Domain2ProductTO> domain2productList;

	public List<Domain2ProductTO> getDomain2productList() {
		return domain2productList;
	}

	public void setDomain2productList(List<Domain2ProductTO> domain2productList) {
		this.domain2productList = domain2productList;
	}
	
	public void setDomain2productListTO(int i, Domain2ProductTO domain2ProductTO) {
        while (i >= domain2productList.size()) {
        	domain2productList.add(null);
        }
        domain2productList.set(i, domain2ProductTO);
    }

    public Domain2ProductTO getDomain2productListTO(int i) {
        if (domain2productList == null) {
        	domain2productList = new ArrayList<Domain2ProductTO>();
        }
        
        while (i >= domain2productList.size()) {
        	domain2productList.add(new Domain2ProductTO());
        }
        
        return domain2productList.get(i);
    }
	
}
