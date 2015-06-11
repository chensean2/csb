/*
 * =========================================================================
 *  Program Name: com.saas.common.to.UserExtTO
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
 * -------------------------------------------------------------------------
 *  Version    Remarks
 *  v1.0       - Initial Release
 * =========================================================================
 */
package com.saas.common.to;


public class UserExtTO extends SCBaseTO {

	private static final long serialVersionUID = 6734017210746424550L;
	private String userExtId;// USER_EXT_ID
	private String userId;// USER_ID
	private byte[] userLogo;// USER_LOGO

	public String getUserExtId() {
		return userExtId;
	}

	public void setUserExtId(String userExtId) {
		this.userExtId = userExtId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public byte[] getUserLogo() {
		return userLogo;
	}

	public void setUserLogo(byte[] userLogo) {
		this.userLogo = userLogo;
	}

}
