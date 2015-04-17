/*
 * =========================================================================
 *Program Name:com.saas.sso.service.SSOServiceImpl
 *
 *Copyright 2010 saas Pte. Ltd. All Rights Reserved
 *
 *This software is confidential and proprietary to saas Pte. Ltd. You shall
 *use this software only in accordance with the terms of the license
 *agreement you entered into with saas.  No aspect or part or all of this
 *software may be reproduced, modified or disclosed without full and
 *direct written authorisation from saas.
 *
 *saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 *REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 *SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 *FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 *MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 *Change Revision
 *----------------------------------------------------------------------------
 *Version    Remarks	              Author	    Editor          Date
 *v1.0     - Initial Release	     xiaowei	                   Apr 1, 2010
 *=====================================================================================
 */
package com.saas.sso.service;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import org.joda.time.DateTime;
import org.opensaml.Configuration;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.AuthnContext;
import org.opensaml.saml2.core.AuthnContextClassRef;
import org.opensaml.saml2.core.AuthnStatement;
import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.Subject;
import org.opensaml.saml2.core.SubjectConfirmationData;
import org.opensaml.saml2.core.impl.AssertionMarshaller;
import org.opensaml.saml2.core.impl.ResponseMarshaller;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.security.SecurityConfiguration;
import org.opensaml.xml.security.SecurityHelper;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.security.x509.X509Util;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.signature.SignatureException;
import org.opensaml.xml.signature.Signer;
import org.opensaml.xml.util.XMLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import sun.misc.BASE64Encoder;

import com.saas.common.ConfigProperties;
import com.saas.common.IAppsConstants;
import com.saas.common.SequenceUUID;
import com.saas.common.exception.SCException;
import com.saas.common.util.Binary_Converter;
import com.saas.common.util.SsoUtil;
import com.saas.common.util.XmlDigitalSigner;
import com.saas.sso.saml.util.SAML;

public class SSOServiceImpl implements SSOService {
    private Logger log = LoggerFactory.getLogger(SSOServiceImpl.class);
    ConfigProperties config = ConfigProperties.getInstance();

    public String generateSamlResponse(String username, String domainName, String acsUrl, String requestId)
            throws SCException {
        ConfigProperties conf = ConfigProperties.getInstance();

        String storeRootPath = conf.getPropertyAsString(IAppsConstants.SAAS_CONFIG,
                IAppsConstants.COMMON_STORE_ROOT_PATH, "");
        String storeKeyPath = conf.getPropertyAsString(IAppsConstants.SAAS_CONFIG,
                IAppsConstants.COMMON_KEY_STORE_KEY_PATH, "");
        String keyRsaPublicFileName = conf.getPropertyAsString(IAppsConstants.SAAS_CONFIG,
                IAppsConstants.COMMON_KEY_RSA_PUBLIC_FILE_NAME, "");
        String keyRsaPrivateFileName = conf.getPropertyAsString(IAppsConstants.SAAS_CONFIG,
                IAppsConstants.COMMON_KEY_RSA_PRIVATE_FILE_NAME, "");
        String keyType = conf.getPropertyAsString(IAppsConstants.SAAS_CONFIG, IAppsConstants.COMMON_KEY_TYPE_RSA, "");
        String publicKeyFilePath = String.format("%s%s%s%s%s", storeRootPath, storeKeyPath, domainName, "/",
                keyRsaPublicFileName);
        String privateKeyFilePath = String.format("%s%s%s%s%s", storeRootPath, storeKeyPath, domainName, "/",
                keyRsaPrivateFileName);

        PublicKey publicKey = (RSAPublicKey) SsoUtil.getPublicKey(publicKeyFilePath, keyType);
        PrivateKey privateKey = (RSAPrivateKey) SsoUtil.getPrivateKey(privateKeyFilePath, keyType);

        String notBefore = SsoUtil.getNotBeforeDateAndTime();
        String notOnOrAfter = SsoUtil.getNotOnOrAfterDateAndTime();

        String responseXmlString = createSamlResponse(username, notBefore, notOnOrAfter, requestId, acsUrl);
        return signResponse(responseXmlString, publicKey, privateKey);
    }
    
    /**
     * Generates a SAML response XML by replacing the specified variable on the SAML response template file. Returns the
     * String format of the XML file.
     */
    public String generateSamlResponseXMLStr4CommonTemplate(String userName, String acsUrl, String email, boolean isEncoded) throws SCException {
        String templatePath = String.format("%s%s", getPropertyAsString("store.rootPath"), getPropertyAsString("excample.sso.store.samlResponseTemplateCommonPath"));

        String notBefore = SsoUtil.getNotBeforeDateAndTime();
        String notOnOrAfter = SsoUtil.getNotOnOrAfterDateAndTime();
        String requestId = SsoUtil.createID();
        BASE64Encoder b64 = new BASE64Encoder();

        if (isEncoded) {
            try {
                userName = b64.encode(userName.getBytes("UTF-8"));
                acsUrl = b64.encode(acsUrl.getBytes("UTF-8"));
                email = b64.encode(email.getBytes("UTF-8"));
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                e.printStackTrace();
            }
        }

        String samlResponse = SsoUtil.readFileContents(templatePath);
        samlResponse = samlResponse.replace("%%RESPONSE_ID%%", SsoUtil.createID());
        samlResponse = samlResponse.replace("%%ISSUE_INSTANT%%", SsoUtil.getDateAndTime());
        samlResponse = samlResponse.replace("%%ASSERTION_ID%%", SequenceUUID.getInstance().getUUID());
        samlResponse = samlResponse.replace("%%USERNAME_STRING%%", userName);
        samlResponse = samlResponse.replace("%%REQUEST_ID%%", requestId);
        samlResponse = samlResponse.replace("%%NOT_ON_OR_AFTER%%", notOnOrAfter);
        samlResponse = samlResponse.replace("%%ACS_URL%%", acsUrl);
        samlResponse = samlResponse.replace("%%NOT_BEFORE%%", notBefore);
        samlResponse = samlResponse.replace("%%AUTHN_INSTANT%%", SsoUtil.getDateAndTime());
        samlResponse = samlResponse.replace("%%EMAIL_STRING%%", email);

        return samlResponse;
    }
    
    /*
     * Signs the SAML response XML with the specified response XML, and embeds with public key. Uses helper class
     * XmlDigitalSigner to digitally sign the XML.
     */
    public String signResponse(String response) throws SCException {
        String publicKeyFilePath = String.format("%s%s", getPropertyAsString("store.rootPath"), getPropertyAsString("excample.sso.store.pubKey"));
        String privateKeyFilePath = String.format("%s%s", getPropertyAsString("store.rootPath"), getPropertyAsString("excample.sso.store.priKey"));
        String keyType = getPropertyAsString(IAppsConstants.COMMON_KEY_TYPE_RSA);
        PublicKey publicKey = (RSAPublicKey) SsoUtil.getPublicKey(publicKeyFilePath, keyType);
        PrivateKey privateKey = (RSAPrivateKey) SsoUtil.getPrivateKey(privateKeyFilePath, keyType);

        return (XmlDigitalSigner.signXML(response, publicKey, privateKey));
    }

    /**
     * Generates a SAML response XML by replacing the specified username on the SAML response template file. Returns the
     * String format of the XML file.
     */
    private String createSamlResponse(String authenticatedUser, String notBefore, String notOnOrAfter,
            String requestId, String acsUrl) throws SCException {

        ConfigProperties conf = ConfigProperties.getInstance();
        String templatePath = String.format("%s%s", conf.getPropertyAsString(IAppsConstants.SAAS_CONFIG,
                "store.rootPath", ""), conf.getPropertyAsString(IAppsConstants.SAAS_CONFIG,
                "google.store.googleSsoTemplatePath", ""));

        String samlResponse = SsoUtil.readFileContents(templatePath);
        samlResponse = samlResponse.replace("%%USERNAME_STRING%%", authenticatedUser);
        samlResponse = samlResponse.replace("%%RESPONSE_ID%%", SsoUtil.createID());
        samlResponse = samlResponse.replace("%%ISSUE_INSTANT%%", SsoUtil.getDateAndTime());
        samlResponse = samlResponse.replace("%%AUTHN_INSTANT%%", SsoUtil.getDateAndTime());
        samlResponse = samlResponse.replace("%%NOT_BEFORE%%", notBefore);
        samlResponse = samlResponse.replace("%%NOT_ON_OR_AFTER%%", notOnOrAfter);
        samlResponse = samlResponse.replace("%%ASSERTION_ID%%", SsoUtil.createID());
        samlResponse = samlResponse.replace("%%REQUEST_ID%%", requestId);
        samlResponse = samlResponse.replace("%%ACS_URL%%", acsUrl);
        return samlResponse;
    }

    /*
     * Signs the SAML response XML with the specified private key, and embeds with public key. Uses helper class
     * XmlDigitalSigner to digitally sign the XML.
     */
    private String signResponse(String response, PublicKey publicKey, PrivateKey privateKey) throws SCException {
        return (XmlDigitalSigner.signXML(response, publicKey, privateKey));
    }

    
    /**
     * This method is used to generate, encode saml response, this response will direct to service provider.
     * @param subjectType
     * @param certFilePath: e.g. C:/saasconnect/SSO/keys/OfficeAppsKeyStore/officeappssso.crt
     * @param privateKeyFilePath: e.g C:/saasconnect/SSO/keys/OfficeAppsKeyStore/officeappssso.pem
     * @param acsUrl : e.g. http://optussmb.qa.steek.com/simplesaml/module.php/saml/sp/saml2-acs.php/default-sp
     * @param issuer the issuer
     * @param loginId
     * @param customAttributes: define custom attributes
     * @return
     */
    public String generateOpenSamlResponse(String subjectType, String certFilePath, String privateKeyFilePath, String acsUrl, String issuer, String loginId, Map<String, String> customAttributes) {
        String responseEncodedAssertionString = null;
        try {
            boolean showSubContent = false;
            // Config
            // String subjectType = "bearer";
            // String certFilePath = "C:/saasconnect/SSO/keys/OfficeAppsKeyStore/officeappssso.crt";
            // String privateKeyFilePath = "C:/saasconnect/SSO/keys/OfficeAppsKeyStore/officeappssso.pem";
            // String issuer = "http://202.40.243.115";

            // Service based Configuration or retrieve from authRequest
            //String recipientACS = "http://optussmb.qa.steek.com/simplesaml/module.php/saml/sp/saml2-acs.php/default-sp";

            // User info and attribute to be included in the saML response
            // String nameID = "fsA001@saas1.chunkit.org";
            // Map<String, String> customAttributes = new HashMap<String, String>();
            // customAttributes.put("emailAddress", "fsA001@saas1.chunkit.org");
            if (log.isDebugEnabled()) {
                log.debug("##########################################");
                log.debug("#Generate Assertion Example");
                log.debug("##########################################");
            }

            SAML openSAML = new SAML(issuer);
            Subject subject = openSAML.createSubject(loginId, NameID.EMAIL, subjectType);
            SubjectConfirmationData subjectConfirmationData = openSAML.create(SubjectConfirmationData.class, SubjectConfirmationData.DEFAULT_ELEMENT_NAME);
            subjectConfirmationData.setRecipient(acsUrl);
            subject.getSubjectConfirmations().get(0).setSubjectConfirmationData(subjectConfirmationData);
            Assertion assertion = null;

            assertion = openSAML.createAttributeAssertion(subject, customAttributes);
            AuthnContextClassRef ref = openSAML.create(AuthnContextClassRef.class, AuthnContextClassRef.DEFAULT_ELEMENT_NAME);
            ref.setAuthnContextClassRef(AuthnContext.XML_DSIG_AUTHN_CTX);
            AuthnContext authnContext = openSAML.create(AuthnContext.class, AuthnContext.DEFAULT_ELEMENT_NAME);
            authnContext.setAuthnContextClassRef(ref);
            AuthnStatement authnStatement = openSAML.create(AuthnStatement.class, AuthnStatement.DEFAULT_ELEMENT_NAME);
            authnStatement.setAuthnContext(authnContext);
            authnStatement.setAuthnInstant(new DateTime());
            assertion.getStatements().add(authnStatement);
            assertion.setIssuer(openSAML.spawnIssuer());

            if (showSubContent) {
                AssertionMarshaller marshaller = new AssertionMarshaller();
                Element plaintextElement = marshaller.marshall(assertion);
                String originalAssertionString = XMLHelper.nodeToString(plaintextElement);
                System.out.println("Assertion String: " + originalAssertionString);
            }
            if (log.isDebugEnabled()) {
                log.debug("##########################################");
                log.debug("#Generate SAML Response");
                log.debug("##########################################");
            }

            Response response = openSAML.createResponse(assertion);
            response.setIssuer(openSAML.spawnIssuer());

            if (showSubContent) {
                ResponseMarshaller responseMarshaller = new ResponseMarshaller();
                Element responsePlaintextElement = responseMarshaller.marshall(response);
                String responseOriginalAssertionString = XMLHelper.nodeToString(responsePlaintextElement);
                log.debug("SAML response String: " + responseOriginalAssertionString);
            }
            if (log.isDebugEnabled()) {
                log.debug("##########################################");
                log.debug("#Sign SAML Response");
                log.debug("##########################################");
            }

            Signature assertionSignature = (Signature) Configuration.getBuilderFactory().getBuilder(Signature.DEFAULT_ELEMENT_NAME)
                    .buildObject(Signature.DEFAULT_ELEMENT_NAME);
            Signature responseSignature = (Signature) Configuration.getBuilderFactory().getBuilder(Signature.DEFAULT_ELEMENT_NAME).buildObject(Signature.DEFAULT_ELEMENT_NAME);
            Credential assertionsigningCredential = getCredentialsFile(certFilePath, privateKeyFilePath);
            Credential responseSigningCredential = getCredentialsFile(certFilePath, privateKeyFilePath);

            assertionSignature.setSigningCredential(assertionsigningCredential);
            responseSignature.setSigningCredential(responseSigningCredential);
            SecurityConfiguration secConfig = Configuration.getGlobalSecurityConfiguration();
            try {
                SecurityHelper.prepareSignatureParams(assertionSignature, assertionsigningCredential, secConfig, null);
                SecurityHelper.prepareSignatureParams(responseSignature, responseSigningCredential, secConfig, null);
            } catch (Exception e) {
                log.error("[SaaSconnect] Error occured when prepareSignatureParams", e);
            }
            response.setSignature(responseSignature);
            assertion.setSignature(assertionSignature);

            try {
                Configuration.getMarshallerFactory().getMarshaller(assertion).marshall(assertion);
            } catch (MarshallingException e) {
                log.error("[SaaSconnect] Error occured when getMarshaller for assertion", e);
            }

            try {
                Signer.signObject(assertionSignature);
            } catch (SignatureException e) {
                log.error("[SaaSconnect] Error occured when signObject for assertion", e);
            }

            try {
                Configuration.getMarshallerFactory().getMarshaller(response).marshall(response);
            } catch (MarshallingException e) {
                log.error("[SaaSconnect] Error occured when getMarshaller.", e);
            }

            try {
                Signer.signObject(responseSignature);
            } catch (SignatureException e) {
                log.error("[SaaSconnect] Error occured when signObject.", e);
            }

            ResponseMarshaller signResponseMarshaller = new ResponseMarshaller();
            Element responseSignedPlaintextElement = signResponseMarshaller.marshall(response);
            String signResponseString = XMLHelper.nodeToString(responseSignedPlaintextElement);

            if (log.isDebugEnabled()) {
                log.debug("Signed SAML response String: " + signResponseString);
                log.debug("##########################################");
                log.debug("#Encoded SAML Response");
                log.debug("##########################################");
            }

            Binary_Converter tempbase = new Binary_Converter("UTF-8");
            responseEncodedAssertionString = tempbase.String_To_BinaryString_EncodeBase64(signResponseString);
            log.debug("Encoded SAML response String: " + responseEncodedAssertionString);

        } catch (Exception e) {
            log.error("[SaaSconnect] Error occured when generateSamlResponse.", e);
        }
        return responseEncodedAssertionString;
    }
    
    public static Credential getCredentialsFile(String certPath, String privateKeyFilepath)
    {   
        Credential signingCredential = null;
        try {
            // Get the builder factory
            PrivateKey privatekey = SecurityHelper.decodePrivateKey(new File(privateKeyFilepath), null);
            X509Certificate certificate = X509Util.decodeCertificate(new File(certPath))
                    .toArray(new X509Certificate[0])[0];
            signingCredential = SecurityHelper.getSimpleCredential(certificate, privatekey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return signingCredential;
    }
 
    /**
     * this is a help method, used to get Integer property from file
     * 
     * @param key
     * @return
     */
    private int getPropertyAsInt(String key) {
        if (log.isInfoEnabled()) {
            log.info("[SaaSConnect] Get Int property from property file. ");
            log.info("[SaaSConnect] Property key : " + key);
        }

        int result = config.getPropertyAsInt(IAppsConstants.SAAS_CONFIG, key, 0);

        if (log.isInfoEnabled()) {
            log.info("[SaaSConnect] Property value : " + result);
        }

        return result;
    }

    /**
     * this is a help method, used to get String property from file
     * 
     * @param key
     * @return
     */
    private String getPropertyAsString(String key) {
        if (log.isInfoEnabled()) {
            log.info("[SaaSConnect] Get String property from property file. ");
            log.info("[SaaSConnect] Property key : " + key);
        }

        String result = config.getPropertyAsString(IAppsConstants.SAAS_CONFIG, key, "");

        if (log.isInfoEnabled()) {
            log.info("[SaaSConnect] Property value : " + result);
        }

        return result;
    }

}
