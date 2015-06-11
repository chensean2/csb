/*
 *  =========================================================================
 * Program Name: package com.saas.product.dao.ProductDAOImpl
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
 * v1.3.0     - Initial Release         jixiaowei                   Mar 2, 2011
 * =====================================================================================
 */
package com.saas.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csb.common.IAppsConstants;
import com.csb.common.dao.SCBaseDAOImpl;
import com.csb.common.exception.SCServiceException;
import com.saas.product.to.ProductTO;

public class ProductDAOImpl extends SCBaseDAOImpl implements ProductDAO {
	private Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);


	public int createProduct(ProductTO product) {
		int i = create(product);

		return i;
	}

	public int deleteProduct(ProductTO product) {
		ProductTO productTO = this.getProduct(product);

		if (null == productTO) {
			throw new SCServiceException(
					IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
		}

		int i = delete(product);

		return i;
	}

	public int updateProduct(ProductTO product) {
		ProductTO oldProductTO = this.getProduct(product);
		int i = update(product);
		return i;
	}

	public ProductTO getProduct(ProductTO product) {
		return (ProductTO) queryForObject(product);
	}

	public List<ProductTO> getProductList(ProductTO product) {
		Map<String, Object> paraMap = new HashMap<String, Object>();

		// TODO
		return null;
		// return pfwClient.queryForList(ProductTO.class,
		// "/product/getProductList", paraMap);
	}

	public List<ProductTO> searchProductList(ProductTO product) {
		Map<String, Object> paraMap = new HashMap<String, Object>();

		// TODO

//		return PaginationEnabler.queryForList(ProductTO.class, pfwClient,
//				"/product/getProductList", paraMap);
		return null;
	}

}