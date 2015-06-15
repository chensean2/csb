package com.saas.common.util;

public class AlgorithmUtil {

	public static void main(String[] arg) {
		System.out.println("#################################################");
		System.out.println("# Testing luhn 10 Algo");
		System.out.println("#################################################");

//		String luhnString = "7992739871";
		String luhnString = "12123100001"; // YYMMDD00000X
		for (int i = 0; i < 10; i++) {
			luhnString = luhn10Generator(luhnString);
			System.out.println(luhnString);
			System.out.println(luhn10Validate(luhnString) ? "True" : "False");
			System.out.println("");
		}
		System.out.println("#################################################");
		System.out.println("# End");
		System.out.println("#################################################");

	}

	/*
	 * Luhn 10 algorithm
	 * 
	 * Reference 
	 * http://en.wikipedia.org/wiki/Luhn_algorithm
	 * http://imei.sms.eu.sk/
	 */
	public static String luhn10Generator(String digit) {
		try {
			int luhnDigit = 0;
			for (int i = 0; i < digit.length(); i++) {
				luhnDigit += Integer.parseInt(digit.substring(i, i + 1));
			}
			Integer[] delta = new Integer[] { 0, 1, 2, 3, 4, -4, -3, -2, -1, 0 };
			for (int i = digit.length() - 1; i >= 0; i -= 2) {
				int deltaIndex = Integer.parseInt(digit.substring(i, i + 1));
				int deltaValue = delta[deltaIndex];
				luhnDigit += deltaValue;
			}
			luhnDigit = luhnDigit * 9 % 10;
			return digit + String.valueOf(luhnDigit);
		} catch (Exception e) {
			return digit;
		}
	}

	public static boolean luhn10Validate(String luhn10) {
		try {
			String LuhnLess = luhn10.substring(0, luhn10.length() - 1);
			if (luhn10Generator(LuhnLess).equalsIgnoreCase(luhn10)) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
}
