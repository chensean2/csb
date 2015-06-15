/*
 * =========================================================================
 *  Program Name: com.saas.common.util.PasswordGenerator
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

/**
 * Utility class for generating default passwords
 */
public class PasswordGenerator {

    /**
     * Utility to generate the default google password given the user ID.
     * 
     * @param userId
     *                The user ID
     * @return The generated default google password
     */
    public static String generateDefaultGooglePassword(String userId) {
        
        // Generation algorithm given by DMSBT
        
        // Note: Mapping between alphabet and values:
        // An array consisting of 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ' is used to map alphabets to a 
        // number. So 'a' will be 0, 'b' will be 1 so on and so forth.

        // Validation
        // Rules: 1. userId not null
        // 2. userId's length more than 3
        if (userId == null || userId.length() < 3) {
            throw new IllegalArgumentException("userId is illegal - " + userId);
        }

        // Step 1 - Calculate base constant {baseConst}
        // Description:
        // Add the unicode value of the 1st, 2nd and 3rd characters
        int baseConst = userId.charAt(0) + userId.charAt(1) + userId.charAt(2);

        // Step 2 - Generate the numeric string {numString}
        // Description: 
        //    Go through the NRIC character by character starting from the 2nd character
        //    If it is a alphabet, convert it to a number and add the value of {baseConstant} to it.
        //    If it is a digit, add the value of (3) to it. 
        //    The results are appended to a string made up of the results of adding (3) to each character in the NRIC 
        //    from left to right.
        String numString = "";
        for (int i = 1; i < userId.length(); i++) {
            char currChar = userId.charAt(i);
            int currValue = 0;
            if (currChar >= 'a' && currChar <= 'z') {
                currValue = currChar - 'a';
            }
            else if (currChar >= 'A' && currChar <= 'Z') {
                currValue = currChar - 'A' + 26;
            }
            else if (currChar >= '0' && currChar >= '0') {
                currValue = currChar - '0';
            }
            currValue = currValue + baseConst;
            numString = numString + currValue;
        }
        
        // Step 3 - Compute interval {interval}
        // Description:
        //    {interval} is computed by {interval} = ((numString[0] + numString[1] + numString[2]) / 3) + 1
        //    where numString[n] is the value of the nth digit in {numString}
        int interval = (((numString.charAt(0) - '0') + (numString.charAt(1) - '0') + (numString.charAt(2) - '0')) / 3) + 1;
        
        // Step 4 - Obtain final result {result}
        // Description:
        //    Go through {numString}, and starting from 0 with an interval based on {interval}), 
        //    map the number to an alphabet. 
        String result = "";
        for (int i = 0; i < numString.length(); i++) {
            if (i % interval == 0) {
                // at interval
                char alphabet = (char) ('a' + (numString.charAt(i) - '0'));
                result = result + alphabet;
            }
            else {
                // not at interval
                result  = result + numString.charAt(i);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws Exception {
        String userId = "chs";
        String password = PasswordGenerator.generateDefaultGooglePassword(userId);
        
        System.out.println("userId = " + userId);
        System.out.println("password = " + password);
    }

}
