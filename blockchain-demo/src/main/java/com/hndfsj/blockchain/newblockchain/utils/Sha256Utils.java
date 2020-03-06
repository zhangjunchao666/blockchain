package com.hndfsj.blockchain.newblockchain.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * TODO： 数字签名 - 所有的输入调用此方法后均会生成一个独一无二的hash值（数字签名）
 *
 * @author zhangjunchao
 * @date 2019/12/5
 */
public class Sha256Utils {

    /**
     * 对字符串应用Sha256并返回结果
     */
    public static String generatorSha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // 对我们的应用输入sha256
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            // 包含16进制的散列
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
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
