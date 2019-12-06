package com.hndfsj.blockchain;

import com.hndfsj.blockchain.newblockchain.utils.RSACoder;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class BlockchainApplicationTests {



    @Test
    public void testEncrypt() throws Exception {
        System.out.println("公钥加密 -- 私钥解密");

        // 加密前
        String inputStr = "abc";
        byte[] data = inputStr.getBytes();

        Map<String, Object> Keymap = RSACoder.initKey();
        byte[] publicKey = RSACoder.getPublicKey(Keymap);
        byte[] privateKey = RSACoder.getPrivateKey(Keymap);

        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);
        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData, privateKey);

        // 解密后
        String outputStr = new String(decodedData);

        System.out.println("加密前：".concat(inputStr));
        System.out.println("解密后：".concat(outputStr));

    }

    @Test
    public void AsymmetricEncryption() throws Exception {
        //初始化密钥
        Map<String, Object> keyMap = RSACoder.initKey();
        //公钥
        byte[] publicKey = RSACoder.getPublicKey(keyMap);
        //私钥
        byte[] privateKey = RSACoder.getPrivateKey(keyMap);

        System.out.println("公钥：/n" + Base64.encodeBase64String(publicKey));br();
        System.out.println("私钥：/n" + Base64.encodeBase64String(privateKey));br();

        System.out.println("================ 密钥对构造完毕,甲方将公钥公布给乙方，开始进行加密数据的传输 =============");
        String str = "河南东方世纪";
        System.out.println("甲方向乙方发送加密数据：河南东方世纪");

        //甲方进行数据的加密
        byte[] code1 = RSACoder.encryptByPrivateKey(str.getBytes(), privateKey);
        System.out.println("加密后的密文：" + Base64.encodeBase64String(code1));br();
        System.out.println("================ 乙方使用甲方提供的公钥对数据进行解密 ================");

        //乙方进行数据的解密
        byte[] decode1 = RSACoder.decryptByPublicKey(code1, publicKey);
        System.out.println("乙方解密后的数据：" + new String(decode1));

        //System.out.println("===========反向进行操作，乙方向甲方发送数据==============/n/n");
        //
        //str = "乙方向甲方发送数据：开始行动";
        //
        //System.out.println("原文:" + str);
        //
        ////乙方使用公钥对数据进行加密
        //byte[] code2 = RSACoder.encryptByPublicKey(str.getBytes(), publicKey);
        //System.out.println("===========乙方使用公钥对数据进行加密==============");
        //System.out.println("加密后的数据：" + Base64.encodeBase64String(code2));
        //
        //System.out.println("=============乙方将数据传送给甲方======================");
        //System.out.println("===========甲方使用私钥对数据进行解密==============");

        //甲方使用私钥对数据进行解密
        //byte[] decode2 = RSACoder.decryptByPrivateKey(code2, privateKey);

        //System.out.println("甲方解密后的数据：" + new String(decode2));
    }













    public void br(){
        System.out.println();
    }


}
