package com.csb.common;

public class DaoRunTimeException extends RuntimeException {

	public  Exception getWrappedException(){
		return new Exception();
	}
}
