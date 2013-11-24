package com.seeyon.v3x.utils;

import org.apache.commons.lang.StringUtils;



public final class Strings {
	/**
	 * @param str
	 * @return
	 * @description 判断字符串是否为空
	 * @version 1.0
	 * @author xiew
	 * @update 2013-7-24 上午10:13:24
	 */
	public static boolean isBlank(String str){
		return StringUtils.isBlank(str);
	}
	public static boolean isNotBlank(String str){
		return StringUtils.isNotBlank(str);
	}
}
