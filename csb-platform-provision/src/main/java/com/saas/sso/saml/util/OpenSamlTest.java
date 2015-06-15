package com.saas.sso.saml.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import org.joda.time.DateTime;
import org.opensaml.Configuration;
import org.opensaml.common.SignableSAMLObject;
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
import org.opensaml.security.SAMLSignatureProfileValidator;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.io.Unmarshaller;
import org.opensaml.xml.parse.BasicParserPool;
import org.opensaml.xml.security.SecurityConfiguration;
import org.opensaml.xml.security.SecurityHelper;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.security.x509.X509Util;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.signature.SignatureException;
import org.opensaml.xml.signature.Signer;
import org.opensaml.xml.util.XMLHelper;
import org.opensaml.xml.validation.ValidationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.saas.common.util.Binary_Converter;


public class OpenSamlTest{
    // Reference from 
    // http://www.capcourse.com/Library/OpenSAML/index.html
    public static void main(String[] args) throws Exception {
        try {
            boolean showSubContent = false;
            // Config
            String subjectType = "bearer";
            String certFilePath = "D:/Chun Kit/Documents/Optus Project Nachos/A_Project/workspace/Temp/0 Requirement/F-Secure/SSO/OfficeAppsKeyStore/officeappssso.crt";
            String privateKeyFilePath = "D:/Chun Kit/Documents/Optus Project Nachos/A_Project/workspace/Temp/0 Requirement/F-Secure/SSO/OfficeAppsKeyStore/officeappssso.pem";
            String issuer = "http://202.40.243.115";
            
            // Service based Configuration or retrieve from authRequest
            String recipientACS = "http://optussmb.qa.steek.com/simplesaml/module.php/saml/sp/saml2-acs.php/default-sp";
            
            // User info and attribute to be included in the saML response
            String nameID = "fsA001@saas1.chunkit.org";
            Map<String, String> customAttributes = new HashMap<String, String>();
            customAttributes.put("emailAddress", "fsA001@saas1.chunkit.org");

            System.out.println("##########################################");
            System.out.println("#Generate Assertion Example");
            System.out.println("##########################################");
            
            SAML openSAML = new SAML(issuer);
            Subject subject = openSAML.createSubject(nameID, NameID.EMAIL, subjectType);
            SubjectConfirmationData subjectConfirmationData = openSAML.create(SubjectConfirmationData.class, SubjectConfirmationData.DEFAULT_ELEMENT_NAME);
            subjectConfirmationData.setRecipient(recipientACS);
            subject.getSubjectConfirmations().get(0).setSubjectConfirmationData(subjectConfirmationData);
            Assertion assertion = null;
            
            assertion = openSAML.createAttributeAssertion(subject, customAttributes);
            AuthnContextClassRef ref = openSAML.create(AuthnContextClassRef.class,
                    AuthnContextClassRef.DEFAULT_ELEMENT_NAME);
            ref.setAuthnContextClassRef(AuthnContext.XML_DSIG_AUTHN_CTX);
            AuthnContext authnContext = openSAML.create(AuthnContext.class, AuthnContext.DEFAULT_ELEMENT_NAME);
            authnContext.setAuthnContextClassRef(ref);
            AuthnStatement authnStatement = openSAML.create(AuthnStatement.class, AuthnStatement.DEFAULT_ELEMENT_NAME);
            authnStatement.setAuthnContext(authnContext);
            authnStatement.setAuthnInstant(new DateTime());
            assertion.getStatements().add (authnStatement);
            assertion.setIssuer(openSAML.spawnIssuer());

            if (showSubContent) {
                AssertionMarshaller marshaller = new AssertionMarshaller();
                Element plaintextElement = marshaller.marshall(assertion);
                String originalAssertionString = XMLHelper.nodeToString(plaintextElement);
                System.out.println("Assertion String: " + originalAssertionString);
            }
            
            System.out.println("##########################################");
            System.out.println("#Generate SAML Response");
            System.out.println("##########################################");
            
            Response response = openSAML.createResponse(assertion);
            response.setIssuer(openSAML.spawnIssuer());
            
            if (showSubContent) {
                ResponseMarshaller responseMarshaller = new ResponseMarshaller();
                Element responsePlaintextElement = responseMarshaller.marshall(response);
                String responseOriginalAssertionString = XMLHelper.nodeToString(responsePlaintextElement);
                System.out.println("SAML response String: " + responseOriginalAssertionString);
            }
            
            System.out.println("##########################################");
            System.out.println("#Sign SAML Response");
            System.out.println("##########################################");
            
            Signature assertionSignature = (Signature) Configuration.getBuilderFactory().getBuilder(Signature.DEFAULT_ELEMENT_NAME)
            .buildObject(Signature.DEFAULT_ELEMENT_NAME);
            Signature responseSignature = (Signature) Configuration.getBuilderFactory().getBuilder(Signature.DEFAULT_ELEMENT_NAME)
            .buildObject(Signature.DEFAULT_ELEMENT_NAME);
            Credential assertionsigningCredential = getCredentialsFile(certFilePath,privateKeyFilePath);
            Credential responseSigningCredential = getCredentialsFile(certFilePath,privateKeyFilePath);
            
            assertionSignature.setSigningCredential(assertionsigningCredential);
            responseSignature.setSigningCredential(responseSigningCredential);
            SecurityConfiguration secConfig = Configuration.getGlobalSecurityConfiguration();
            try {
                SecurityHelper.prepareSignatureParams(assertionSignature, assertionsigningCredential, secConfig, null);
                SecurityHelper.prepareSignatureParams(responseSignature, responseSigningCredential, secConfig, null);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (org.opensaml.xml.security.SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setSignature(responseSignature);
            assertion.setSignature(assertionSignature);
            
            try {
                Configuration.getMarshallerFactory().getMarshaller(assertion).marshall(assertion);
            } catch (MarshallingException e) {
                e.printStackTrace();
            }

            try {
                Signer.signObject(assertionSignature);
            } catch (SignatureException e) {
                e.printStackTrace();
            }
            
            try {
                Configuration.getMarshallerFactory().getMarshaller(response).marshall(response);
            } catch (MarshallingException e) {
                e.printStackTrace();
            }

            try {
                Signer.signObject(responseSignature);
            } catch (SignatureException e) {
                e.printStackTrace();
            }
            
            
            ResponseMarshaller signResponseMarshaller = new ResponseMarshaller();
            Element responseSignedPlaintextElement = signResponseMarshaller.marshall(response);
            String signResponseString = XMLHelper.nodeToString(responseSignedPlaintextElement);
            if (showSubContent) {
                System.out.println("Signed SAML response String: " + signResponseString);
            }
            
            System.out.println("##########################################");
            System.out.println("#Encoded SAML Response");
            System.out.println("##########################################");
            
            Binary_Converter tempbase = new Binary_Converter("UTF-8");
            String responseEncodedAssertionString = tempbase.String_To_BinaryString_EncodeBase64(signResponseString);
            System.out.println(responseEncodedAssertionString);
            
            System.out.println("##########################################");
            System.out.println("#Validate SAML Signature");
            System.out.println("##########################################");
            
            String singedResponse  = tempbase.BinaryString_To_String_DecodeBase64(responseEncodedAssertionString);
            InputStream in=new ByteArrayInputStream(singedResponse.getBytes("UTF-8"));  
            BasicParserPool parser = new BasicParserPool();
            parser.setNamespaceAware(true);
            Document doc = parser.parse(in);
            Element samlElement = doc.getDocumentElement();
            Unmarshaller unmarshaller = Configuration.getUnmarshallerFactory().getUnmarshaller(samlElement);
            if (unmarshaller == null) {
                System.out.println("Unable to retrieve unmarshaller by DOM Element");
            }

            SignableSAMLObject signableObj = (SignableSAMLObject) unmarshaller.unmarshall(responseSignedPlaintextElement);
            Signature validateTarget = signableObj.getSignature();
            SAMLSignatureProfileValidator validator = new SAMLSignatureProfileValidator();
            try {
                validator.validate(validateTarget);
                System.out.println("Validate Pass");
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        } catch (MarshallingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
}

