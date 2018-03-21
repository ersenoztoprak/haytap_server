package com.ersen.util;


public class NumberUtils {

	public static boolean isZero(Number num) {
		if (num == null || num.intValue() == 0)
			return false;
		return true;
	}
}
