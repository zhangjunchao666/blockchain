package com.hndfsj.blockchain.newblockchain.common;

import com.hndfsj.blockchain.newblockchain.utils.RSACoder;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2019/12/6
 */
@RestController
public class AsymmetricEncryption {//非对称加密

    @PostMapping("asymmetricEncryption")
    public Object asymmetricEncryption(String data) throws Exception {

        System.out.println("要加密的数据：".concat(data));

        //初始化密钥
        Map<String, Object> keyMap = RSACoder.initKey();
        //公钥
        byte[] publicKey = RSACoder.getPublicKey(keyMap);
        //私钥
        byte[] privateKey = RSACoder.getPrivateKey(keyMap);
        // 公钥
        String pubKey = Base64.encodeBase64String(publicKey);
        // 私钥
        String priKey = Base64.encodeBase64String(privateKey);

        //甲方进行数据的加密
        byte[] code1 = RSACoder.encryptByPrivateKey(data.getBytes(), privateKey);
        System.out.println("加密后的密文：" + Base64.encodeBase64String(code1));
        // 加密后的密文
        String privateText = Base64.encodeBase64String(code1);

        //乙方用公钥进行数据的解密
        byte[] decode1 = RSACoder.decryptByPublicKey(code1, publicKey);
        System.out.println("解密后的数据：" + new String(decode1));
        // "解密后的数据："
        String decodeText = new String(decode1);

        HashMap<String, Object> map = new HashMap<>(16);
        map.put("需要加密的数据：",data);
        map.put("公钥：", pubKey);
        map.put("私钥：", priKey);
        map.put("加密后的密文：", privateText);
        map.put("用公钥解密后的数据：", decodeText);

        return map;
    }






}
