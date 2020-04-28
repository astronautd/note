package com.whc.noteserver.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
	//带秘钥加密
	public static String md5(String text, String key) throws Exception {
		// 加密后的字符串
		String md5str = DigestUtils.md5Hex(text + key);
		System.out.println("MD5加密后的字符串为:" + md5str);
		return md5str;
	}

}
