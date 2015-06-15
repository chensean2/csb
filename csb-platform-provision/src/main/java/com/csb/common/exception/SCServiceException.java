/*
 * =========================================================================
 *  Program Name:com.saas.common.exception.SCServiceException
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

package com.csb.common.exception;

public class SCServiceException extends RuntimeException {

    private static final long serialVersionUID = 7919399411632348265L;
    
    private Object parameter;
    
    public SCServiceException(){
        super();
    }
    
    public SCServiceException(String message){
        super(message);
    }
    
    public SCServiceException(Throwable cause){
        super(cause);
    }
    
    public SCServiceException(String message,Throwable cause){
        super(message,cause);
    }

    public SCServiceException(String message, Object parameter){
        super(message);
        this.parameter = parameter;
    }

    public Object getParameter(){
        return this.parameter;
    }

}
