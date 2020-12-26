package com.bookmanager.util;

/**
 * 字符串工具类
 * @author WenRan
 *
 */
public class StringUtil {
	/**
	 * 判断登陆界面输入的字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null||"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
			
	}
	
	/**
	 * 判断登陆界面输入的字符串是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
			
	}

}
