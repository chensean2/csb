package com.saas.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Binary_Converter {
	
	private String Characterset = "UTF-8";
	private ReadWriteFile RWfile = new ReadWriteFile();
	private byte[] Byte_Representation;
	
	public Binary_Converter(String CSet)
	{
		if(CSet.equalsIgnoreCase("US-ASCII"))
		{
			Characterset = "US-ASCII";
		}
		else if(CSet.equalsIgnoreCase("ISO-8859-1"))
		{
			Characterset = "ISO-8859-1";
		}
		else if(CSet.equalsIgnoreCase("UTF-8"))
		{
			Characterset = "UTF-8";
		}
		else if(CSet.equalsIgnoreCase("UTF-16BE"))
		{
			Characterset = "UTF-16BE";
		}
		else if(CSet.equalsIgnoreCase("UTF-16LE"))
		{
			Characterset = "UTF-16LE";
		}
		else if(CSet.equalsIgnoreCase("UTF-16"))
		{
			Characterset = "UTF-16";
		}		
	}
	public byte[] BinaryString_To_Byte_DecodeBase64(String BinaryString)
	{
		byte[] decoded;
		
		try 
		{
			decoded = BinaryString.getBytes(Characterset);
			decoded = Base64.decodeBase64(decoded);
			return decoded;
		} 
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		return null;
	}
	public String BinaryString_To_String_DecodeBase64(String BinaryString)
	{
		byte[] decoded;
		
		try 
		{
			decoded = BinaryString.getBytes(Characterset);
			decoded = Base64.decodeBase64(decoded);
			String decodeMe = new String(decoded, Characterset);
			return decodeMe;
		} 
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		return null;
	}
	public boolean BinaryString_To_File_DecodeBase64(String BinaryString, String SaveTofilename)
	{
		byte[] decoded;
		
		try 
		{
			decoded = BinaryString.getBytes(Characterset);
			decoded = Base64.decodeBase64(decoded);
			RWfile.WriteFile(decoded,SaveTofilename);
			return true;
		} 
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public String File_To_BinaryString_EncodeBase64(String filepath)
	{       		
		try 
		{
			Byte_Representation = RWfile.loadFile(filepath);
			byte[] encoded = Base64.encodeBase64(Byte_Representation);
			String printMe = new String(encoded, Characterset);
			return printMe;
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return "";		
	} 
	
	public String Byte_Array_To_BinaryString_EncodeBase64(byte[] whichfilebyte)
	{       		
		try 
		{
			byte[] encoded = Base64.encodeBase64(whichfilebyte);
			String printMe = new String(encoded, Characterset);
			return printMe;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return "";		
	} 
	
	public String String_To_BinaryString_EncodeBase64(String whichfilestring)
	{       		
		try 
		{
			Byte_Representation = whichfilestring.getBytes();
			byte[] encoded = Base64.encodeBase64(Byte_Representation);
			String printMe = new String(encoded, Characterset);
			return printMe;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return "";		
	} 
}
