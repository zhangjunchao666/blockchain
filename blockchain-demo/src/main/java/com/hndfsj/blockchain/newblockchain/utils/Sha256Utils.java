package com.hndfsj.blockchain.newblockchain.utils;

import java.security.MessageDigest;

/**
 * <pre>
 * TODO： 数字签名 - 所有的输入调用此方法后均会生成一个独一无二的hash值（数字签名）
 * </pre>
 *
 * @author zhangjunchao
 * @date 2019/12/5
 */
public class Sha256Utils {

    /**
     * 对字符串应用Sha256并返回结果
     * @param input
     * @return
     */
    public static String generatorSha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // 对我们的应用输入sha256
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            // 包含16进制的散列
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }





}
