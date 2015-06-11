/*
 * =========================================================================
 *  Program Name: com.saas.common.exception.SCException
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
package com.csb.core.common.exception;

import com.csb.core.common.ConfigProperties;
import com.csb.core.common.IAppsConstants;

/**
 * 
 * @author hendras
 */
public class SCException extends Exception {

    private static final long serialVersionUID = -6550715570292505782L;
    private int errCode;

    public SCException() {

    }

    public SCException(String message) {
        super(message);
    }

    public SCException(Throwable cause) {
        super(cause);
    }

    public SCException(String message, Throwable cause) {
        super(message, cause);
    }
//
//    public SCException(int errCode) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""))));
//        this.errCode = errCode;
//    }
//
//    public SCException(int errCode, String arg) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""), arg)));
//        this.errCode = errCode;
//    }
//
//    public SCException(int errCode, String arg0, String arg1) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""), arg0, arg1)));
//        this.errCode = errCode;
//    }
//
//    public SCException(int errCode, Throwable cause) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""), cause)));
//        this.errCode = errCode;
//    }
//
//    public SCException(int errCode, String arg, Throwable cause) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""), arg)), cause);
//        this.errCode = errCode;
//    }
//
//    public SCException(int errCode, String arg0, String arg1, Throwable cause) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""), arg0, arg1)), cause);
//        this.errCode = errCode;
//    }

    public int getErrCode() {
        return errCode;
    }
}
