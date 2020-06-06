package com.whc.noteserver.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;

public class TestMD5 {

	public static void main(String[] args) {
		String content = readFileByBytes("D:\\Users\\Desktop\\123.txt");
		try {
			System.out.println(md52(content));
			// 公开密文：133524c54a3c940ffb9a827650f88672

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String readFileByBytes(String fileName) {
		StringBuffer sb = new StringBuffer();
		try {
			File file = new File(fileName);
			InputStream in = null;

			if (file.isFile() && file.exists()) { // 判断文件是否存在
				// System.out.println("以字节为单位读取文件内容，一次读多个字节：");
				// 一次读多个字节
				byte[] tempbytes = new byte[1024];
				int byteread = 0;
				in = new FileInputStream(file);
				// 读入多个字节到字节数组中，byteread为一次读入的字节数
				while ((byteread = in.read(tempbytes)) != -1) {
					// System.out.write(tempbytes, 0, byteread);
					String str = new String(tempbytes, 0, byteread);
					sb.append(str);
				}
			}

		} catch (Exception e) {

		} finally {
			return sb.toString();
		}

	}

	// 带秘钥加密
	public static String md5(String text, String key) throws Exception {
		// 加密后的字符串
		String md5str = DigestUtils.md5Hex(text + key);
		System.out.println("MD5加密后的字符串为:" + md5str);
		return md5str;
	}

	// 不带秘钥加密
	public static String md52(String text) throws Exception {
		// 加密后的字符串
		String md5str = DigestUtils.md5Hex(text);
		// System.out.println("MD52加密后的字符串为:" + md5str + "\t长度：" + md5str.length());
		return md5str;
	}

	/**
	 * MD5验证方法
	 * 
	 * @param text明文
	 * @param key密钥
	 * @param md5密文
	 */
	// 根据传入的密钥进行验证
	public static boolean verify(String text, String key, String md5) throws Exception {
		String md5str = md5(text, key);
		if (md5str.equalsIgnoreCase(md5)) {
			System.out.println("MD5验证通过");
			return true;
		}
		return false;
	}

}
