package com.bookmanager.util;

/**
 * �ַ���������
 * @author WenRan
 *
 */
public class StringUtil {
	/**
	 * �жϵ�½����������ַ����Ƿ�Ϊ��
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
	 * �жϵ�½����������ַ����Ƿ�Ϊ��
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
