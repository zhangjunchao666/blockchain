package com.hndfsj.blockchain.newblockchain.utils;

import tk.mybatis.mapper.util.StringUtil;

import java.security.MessageDigest;

/**
 * MD5算法 哈希算法 MD5算法具有以下特点： 1、压缩性：任意长度的数据，算出的MD5值长度都是固定的。 2、容易计算：从原数据计算出MD5值很容易。
 * 3、抗修改性：对原数据进行任何改动，哪怕只修改1个字节，所得到的MD5值都有很大区别。
 * 4、强抗碰撞：已知原数据和其MD5值，想找到一个具有相同MD5值的数据（即伪造数据）是非常困难的。
 * @author zhangjunchao
 */
public class Md5Util {
	private static String generate16md5(String inStr) {
		return digest(inStr, 16);
	}

	public static String generate32md5(String inStr) {
		return digest(inStr, 32);
	}

	private static String digest(String inStr, int rang) {
		MessageDigest md5;
		if (StringUtil.isEmpty(inStr)) {
			return "";
		}

		try {
            // 取得算法
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}

        // 加密
		byte[] md5Bytes = md5.digest(byteArray);

		StringBuilder hexValue = new StringBuilder();

        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        final int i = 32;
		if (rang == i) {
			return hexValue.toString();
		} else {
            // 转换为32位字符串  202cb962ac59075b964b07152d234b70
			return hexValue.toString().substring(8, 24);
		}
	}

	public static void main(String[] args) {
        String s = "666";
        String s1 = generate32md5(s);
        String s2 = generate16md5(s);
        System.out.println("s1：".concat(s1));
        System.out.println("s2：".concat(s2));
    }
}