/*
 * =========================================================================
 *  Program Name: com.saas.common.util.EncryptManager
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
package com.csb.core.common.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.csb.core.common.exception.SCException;

public class EncryptManager {

    public static final String ENC_TYPE_SHA_1 = "SHA-1";
    public static final String ENC_TYPE_SHA_256 = "SHA-256";

    public static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static byte[] convertToBytes(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }

        return bytes;
    }

    public static String hexToString(String hex) {
        int groupLength = 2;
        StringBuilder sb = new StringBuilder(hex.length() / groupLength);

        for (int i = 0; i < hex.length() - groupLength + 1; i += groupLength) {
            String hexStr = hex.substring(i, i + groupLength);
            sb.append((char) Integer.parseInt(hexStr, 16));
        }

        return sb.toString();
    }

    public static String encryptSHA1(String text) throws SCException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] sha1Hash = new byte[40];

            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            sha1Hash = md.digest();

            return convertToHex(sha1Hash);
        } catch (NoSuchAlgorithmException e) {
            throw new SCException("Error occured while encrypting SHA-1", e);
        } catch (UnsupportedEncodingException e) {
            throw new SCException("Error occured while encrypting SHA-1", e);
        }
    }

    public static String encrypt(String text, String algorithm) throws SCException {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] sha1Hash = new byte[40];

            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            sha1Hash = md.digest();

            return convertToHex(sha1Hash);
        } catch (NoSuchAlgorithmException e) {
            throw new SCException("Error occured while encrypting " + algorithm, e);
        } catch (UnsupportedEncodingException e) {
            throw new SCException("Error occured while encrypting " + algorithm, e);
        }
    }

    public static String encryptSSHA1(String text, String salt) throws SCException {
        String sha1 = encryptSHA1(text + salt);
        String saltHex = convertToHex(salt.getBytes());

        return sha1 + saltHex;
    }
    
    /**
     * 
     * @param data
     * @param key
     * @throws SCException 
     */
    public static String encodeHmacSHA1(String data, String key) throws SCException {
        byte[] byteHMAC = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            SecretKeySpec spec = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            mac.init(spec);
            byteHMAC = mac.doFinal(data.getBytes());
        } catch (InvalidKeyException e) {
            throw new SCException("Error occured while encrypting", e);
        } catch (NoSuchAlgorithmException ignore) {
            throw new SCException("Error occured while encrypting", ignore);
        }

        return Base64.encodeBase64String(byteHMAC);
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(encryptSHA1("1234" + "salt"));
            System.out.println(convertToHex("salt".getBytes()));
            System.out.println("{SSHA}"
                    + Base64.encodeBase64String(convertToBytes("40c95464b7eacddb5572af5468ffb1cdb5b13f35" + "73616c74")));

            System.out.println(encryptSSHA1("12345678", "salt"));
            System.out.println("{SSHA}" + Base64.encodeBase64String(convertToBytes(encryptSSHA1("1234", "salt"))));
            
            System.out.println(encodeHmacSHA1("wumingshan", "SaaSConnectKey"));
        } catch (SCException e) {
            e.printStackTrace();
        }
    }
}
