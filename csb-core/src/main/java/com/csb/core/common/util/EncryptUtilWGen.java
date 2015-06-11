package com.csb.core.common.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptUtilWGen
{
	private static EncryptUtilWGen thisinstance;
    private static Logger _log = LoggerFactory.getLogger(EncryptUtilWGen.class);

    public EncryptUtilWGen()
    {
    	init();
    }
    
    public static EncryptUtilWGen getInstance()
	{
		if(thisinstance == null)
		{
			thisinstance = new EncryptUtilWGen();	
		}
		return thisinstance;
	}
    
    /**
     * Init java security to add BouncyCastle as an RSA provider
     */
    private void init()
    {
        //Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * Generate key which contains a pair of privae and public key using 1024 bytes
     * @return key pair
     * @throws NoSuchAlgorithmException
     */
    public KeyPair generateKey(String KeyType) throws NoSuchAlgorithmException, NoSuchProviderException 
	{        
		if(!KeyType.equalsIgnoreCase("RSA") && !KeyType.equalsIgnoreCase("DSA"))
		{
			return null;
		}
       
		KeyPairGenerator keyGen;
		if(KeyType.equalsIgnoreCase("RSA"))
		{
			keyGen = KeyPairGenerator.getInstance(KeyType);
			
		}
		else
		{
			keyGen = KeyPairGenerator.getInstance(KeyType, "SUN");
			
		}
		keyGen.initialize(1024);  
		KeyPair pair = keyGen.generateKeyPair();   
		return pair;
	}
    
    public boolean saveGeneratedKey(String Prisave, String Pubsave, KeyPair thiset) throws IOException
    {
    	PrivateKey priv = thiset.getPrivate();     
    	PublicKey pub = thiset.getPublic();      
    	byte[] encPriv = priv.getEncoded();    
    	FileOutputStream privfos = new FileOutputStream(Prisave); 
    	privfos.write(encPriv);     
    	privfos.close();     
    	byte[] encPub = pub.getEncoded();    
    	FileOutputStream pubfos = new FileOutputStream(Pubsave);  
    	pubfos.write(encPub);    
    	pubfos.close();
		return true;   
    }
    
    public PublicKey getPublicKey_File(String publicKeyFilepath,String algorithm) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
    {
		InputStream pubKey = null;
		try 
		{
		    URL url = new URL(publicKeyFilepath);
		    pubKey = url.openStream();
		} 
		catch (MalformedURLException e) 
		{
			pubKey = Thread.currentThread().getContextClassLoader().getResourceAsStream(publicKeyFilepath);
//		    pubKey = new FileInputStream(publicKeyFilepath);
		}
		byte[] bytes = new byte[pubKey.available()];
		pubKey.read(bytes);
		pubKey.close();
		X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(bytes);
		KeyFactory factory = KeyFactory.getInstance(algorithm);
		return factory.generatePublic(pubSpec);
    }
    
    public PrivateKey getPrivateKey_File(String privateKeyFilepath,String algorithm) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
    {
		InputStream priKey = null;
		try 
		{
		    URL url = new URL(privateKeyFilepath);
		    priKey = url.openStream();
		} 
		catch (MalformedURLException e) 
		{
//		    priKey = new FileInputStream(privateKeyFilepath);
		    priKey = Thread.currentThread().getContextClassLoader().getResourceAsStream(privateKeyFilepath);
		}
		byte[] bytes = new byte[priKey.available()];
		priKey.read(bytes);
		priKey.close();
		PKCS8EncodedKeySpec priSpec = new PKCS8EncodedKeySpec(bytes);
		KeyFactory factory = KeyFactory.getInstance(algorithm);
		return factory.generatePrivate(priSpec);
    }
    
    /**
     * Encrypt a text using public key.
     * @param text The original unencrypted text
     * @param key The public key
     * @return Encrypted text
     * @throws java.lang.Exception
     */
    public byte[] encrypt(byte[] text, Key key, String keytype) throws Exception
    {
        byte[] cipherText = null;
        try
        {
            //
            // get an RSA cipher object and print the provider
            Cipher cipher = Cipher.getInstance(keytype);
            if (_log.isDebugEnabled())
            {
                _log.debug("\nProvider is: " + cipher.getProvider().getInfo());
                _log.debug("\nStart encryption with public key");
            }

            // encrypt the plaintext using the public key
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipherText = cipher.doFinal(text);
        }
        catch (Exception e)
        {
            _log.error(e.toString(), e);
            throw e;
        }
        return cipherText;
    }

    /**
     * Encrypt a text using public key. The result is enctypted BASE64 encoded text
     * @param text The original unencrypted text
     * @param key The public key
     * @return Encrypted text encoded as BASE64
     * @throws java.lang.Exception
     */
    public String encrypt(String text, Key key, String keytype) throws Exception
    {
        String encryptedText;
        try
        {
            byte[] cipherText = encrypt(text.getBytes("UTF8"),key,keytype);
            encryptedText = encodeBASE64(cipherText);
            _log.debug("Enctypted text is: " + encryptedText);
        }
        catch (Exception e)
        {
            throw e;
        }
        return encryptedText;
    }

    /**
     * Decrypt text using private key
     * @param text The encrypted text
     * @param key The private key
     * @return The unencrypted text
     * @throws java.lang.Exception
     */
    public byte[] decrypt(byte[] text, Key key, String keytype) throws Exception
    {
        byte[] dectyptedText = null;
        try
        {
            // decrypt the text using the private key
            Cipher cipher = Cipher.getInstance(keytype);
            _log.debug("Start decryption");
            cipher.init(Cipher.DECRYPT_MODE, key);
            dectyptedText = cipher.doFinal(text);
        }
        catch (Exception e)
        {
            throw e;
        }
        return dectyptedText;

    }

    /**
     * Decrypt BASE64 encoded text using private key
     * @param text The encrypted text, encoded as BASE64
     * @param key The private key
     * @return The unencrypted text encoded as UTF8
     * @throws java.lang.Exception
     */
    public String decrypt(String text, Key key, String keytype) throws Exception
    {
        String result;
        try
        {
            // decrypt the text using the private key
            byte[] dectyptedText = decrypt(decodeBASE64(text),key,keytype);
            result = new String(dectyptedText, "UTF8");
            _log.debug("Decrypted text is: " + result);
        }
        catch (Exception e)
        {
            throw e;
        }
        return result;

    }

     
    /**
     * Convert a Key to string encoded as BASE64
     * @param key The key (private or public)
     * @return A string representation of the key
     */
    public String getKeyAsString(Key key)
    {
        // Get the bytes of the key
        byte[] keyBytes = key.getEncoded();
        // Convert key to BASE64 encoded string
        BASE64Encoder b64 = new BASE64Encoder();
        return b64.encode(keyBytes);
    }
    /**
     * Convert a PrivateKey to string encoded as BASE64
     * @param key The key (private or public)
     * @return A string representation of the key
     */
    public String getPrivateKeyAsString(PrivateKey key)
    {
        // Get the bytes of the key
        byte[] keyBytes = key.getEncoded();
        // Convert key to BASE64 encoded string
        BASE64Encoder b64 = new BASE64Encoder();
        return b64.encode(keyBytes);
    }
    /**
     * Convert a PrivateKey to string encoded as BASE64
     * @param key The key (private or public)
     * @return A string representation of the key
     */
    public String getPublicKeyAsString(PublicKey key)
    {
        // Get the bytes of the key
        byte[] keyBytes = key.getEncoded();
        // Convert key to BASE64 encoded string
        BASE64Encoder b64 = new BASE64Encoder();
        return b64.encode(keyBytes);
    }

    /**
     * Generates Private Key from BASE64 encoded string
     * @param key BASE64 encoded string which represents the key
     * @return The PrivateKey
     * @throws java.lang.Exception
     */
    public PrivateKey getPrivateKeyFromString(String key, String keytype) throws Exception
    {
        KeyFactory keyFactory = KeyFactory.getInstance(keytype);
        BASE64Decoder b64 = new BASE64Decoder();
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(b64.decodeBuffer(key));
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
        return privateKey;
    }

    /**
     * Generates Public Key from BASE64 encoded string
     * @param key BASE64 encoded string which represents the key
     * @return The PublicKey
     * @throws java.lang.Exception
     */
    public PublicKey getPublicKeyFromString(String key, String keytype) throws Exception
    {
        BASE64Decoder b64 = new BASE64Decoder();
        KeyFactory keyFactory = KeyFactory.getInstance(keytype);
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(b64.decodeBuffer(key));
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
        return publicKey;
    }

    /**
     * Encode bytes array to BASE64 string
     * @param bytes
     * @return Encoded string
     */
    private String encodeBASE64(byte[] bytes)
    {
        BASE64Encoder b64 = new BASE64Encoder();
        return b64.encode(bytes);
    }

    /**
     * Decode BASE64 encoded string to bytes array
     * @param text The string
     * @return Bytes array
     * @throws IOException
     */
    private byte[] decodeBASE64(String text) throws IOException
    {
        BASE64Decoder b64 = new BASE64Decoder();
        return b64.decodeBuffer(text);
    }

    /**
     * Encrypt file using 1024 RSA encryption
     *
     * @param srcFileName Source file name
     * @param destFileName Destination file name
     * @param key The key. For encryption this is the Private Key and for decryption this is the public key
     * @param cipherMode Cipher Mode
     * @throws Exception
     */
    public void encryptFile(String srcFileName, String destFileName, PublicKey key, String keytype) throws Exception
    {
        encryptDecryptFile(srcFileName,destFileName, key, Cipher.ENCRYPT_MODE,keytype);
    }

    /**
     * Decrypt file using 1024 RSA encryption
     *
     * @param srcFileName Source file name
     * @param destFileName Destination file name
     * @param key The key. For encryption this is the Private Key and for decryption this is the public key
     * @param cipherMode Cipher Mode
     * @throws Exception
     */
    public void decryptFile(String srcFileName, String destFileName, PrivateKey key, String keytype) throws Exception
    {
        encryptDecryptFile(srcFileName,destFileName, key, Cipher.DECRYPT_MODE,keytype);
    }

    /**
     * Encrypt and Decrypt files using 1024 RSA encryption
     *
     * @param srcFileName Source file name
     * @param destFileName Destination file name
     * @param key The key. For encryption this is the Private Key and for decryption this is the public key
     * @param cipherMode Cipher Mode
     * @throws Exception
     */
    public void encryptDecryptFile(String srcFileName, String destFileName, Key key, int cipherMode, String keytype) throws Exception
    {
        OutputStream outputWriter = null;
        InputStream inputReader = null;
        try
        {
            Cipher cipher = Cipher.getInstance(keytype);
            //RSA encryption data size limitations are slightly less than the key modulus size,
            //depending on the actual padding scheme used (e.g. with 1024 bit (128 byte) RSA key,
            //the size limit is 117 bytes for PKCS#1 v 1.5 padding. (http://www.jensign.com/JavaScience/dotnet/RSAEncrypt/)
            byte[] buf = cipherMode == Cipher.ENCRYPT_MODE? new byte[100] : new byte[128];
            int bufl;
            // init the Cipher object for Encryption...
            cipher.init(cipherMode, key);

            // start FileIO
            outputWriter = new FileOutputStream(destFileName);
            inputReader = new FileInputStream(srcFileName);
            while ( (bufl = inputReader.read(buf)) != -1)
            {
                byte[] encText = null;
                if (cipherMode == Cipher.ENCRYPT_MODE)
                {
                      encText = encrypt(copyBytes(buf,bufl),(PublicKey)key,keytype);
                }
                else
                {
                    if (_log.isDebugEnabled())
                    {
                        _log.debug("buf = " + new String(buf));
                    }
                    encText = decrypt(copyBytes(buf,bufl),(PrivateKey)key,keytype);
                }
                outputWriter.write(encText);
                if (_log.isDebugEnabled())
                {
                    _log.debug("encText = " + new String(encText));
                }
            }
            outputWriter.flush();

        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            try
            {
                if (outputWriter != null)
                {
                    outputWriter.close();
                }
                if (inputReader != null)
                {
                    inputReader.close();
                }
            }
            catch (Exception e)
            {
                // do nothing...
            } // end of inner try, catch (Exception)...
        }
    }

    public byte[] copyBytes(byte[] arr, int length)
    {
        byte[] newArr = null;
        if (arr.length == length)
        {
            newArr = arr;
        }
        else
        {
            newArr = new byte[length];
            for (int i = 0; i < length; i++)
            {
                newArr[i] = (byte) arr[i];
            }
        }
        return newArr;
    }

    public static void main(String [] args)
	{
    	PrivateKey prikey;
		EncryptUtilWGen crypto;
		String AuthenString;
		String tempkeytype = "RSA";
		String templatePath = "D:/saas/workspace/tools/keys/chunkit.org/Pri.key";
		String encryptedAuthenStr = "iqL8FfO/jGThOPe/wtFMqedt9ApYggj0uhJE9aovRdADNA+tr/x+9MdxPxJY9ZYRpWpQoTus4jSMBpcw1E6ok0E5pYpry7PDcOtqtBlKc/X7i3A6UB3+s6hvxVHrfwRkPZJRjZbGOtJjhaL5mh4gasSR6Bs0qZO0V2vb7x9AJAU=";
		try 
		{
			crypto = EncryptUtilWGen.getInstance();
			prikey = crypto.getPrivateKey_File(templatePath, tempkeytype);
			AuthenString = crypto.decrypt(encryptedAuthenStr, prikey, tempkeytype);
			System.out.println(AuthenString);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			AuthenString = null;
		}
	}
}
