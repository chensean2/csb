/*
 * =========================================================================
 *  Program Name: com.saas.common.util.SimpleErrorHandler
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
package com.saas.common.util;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler {
    public boolean Anyerror = false;

    public void error(SAXParseException exception) {
        System.out.println("error: " + exception.getMessage());
        Anyerror = true;
    }

    public void fatalError(SAXParseException exception) {
        System.out.println("fatalError: " + exception.getMessage());
        Anyerror = true;
    }

    public void warning(SAXParseException exception) {
        System.out.println("warning: " + exception.getMessage());
        Anyerror = true;
    }
}
