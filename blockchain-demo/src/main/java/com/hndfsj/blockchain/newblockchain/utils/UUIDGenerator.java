package com.hndfsj.blockchain.newblockchain.utils;

import java.util.Random;
import java.util.UUID;


/**
 * @author zhangjunchao
 */
public class UUIDGenerator {
    private static Random r = new Random();

	/**
	 * 得到一个随机的32位的UUID值
	 */
	public static String UUID32() {
		// 随即得到一个uuid的String值
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	// 随机生成一个字符
	private static char randomChar() {
        // 可选字符
        String codes = "123456789ABCDEFGHJKMNPQRSTUVWXYZ";
        int index = r.nextInt(codes.length());
		return codes.charAt(index);
	}


    public static void main(String[] args) {
        String s = UUIDGenerator.UUID32();
        System.out.println(s);
    }


}
