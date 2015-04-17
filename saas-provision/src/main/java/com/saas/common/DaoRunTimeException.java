package com.saas.common;

public class DaoRunTimeException extends RuntimeException {

	public  Exception getWrappedException(){
		return new Exception();
	}
}
