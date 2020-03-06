package com.hndfsj.blockchain.newblockchain.bean;

import com.hndfsj.blockchain.newblockchain.utils.Md5Util;
import com.hndfsj.blockchain.newblockchain.utils.RSACoder;
import com.hndfsj.blockchain.newblockchain.utils.Sha256Utils;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.Serializable;
import java.util.Map;

/**
 * TODO：钱包类
 *
 * @author zhangjunchao
 * @date 2020/1/9
 */
public class Wallet implements Serializable {

    /**
     * 公钥
     */
    private String publickey;
    /**
     * 私钥
     */
    private String privatekey;

    private Wallet(String publickey, String privatekey) {
        this.publickey = publickey;
        this.privatekey = privatekey;
    }

    /**
     * 只包含公钥的钱包，用来给其他节点使用，其他节点在转账时需要用到
     */
    public Wallet(String publickey) {
        this.publickey = publickey;
    }

    public Wallet(){

    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }

    // 生成钱包
    public static Wallet generateWallet(){
        try {
            //初始化密钥
            Map<String, Object> initKey = RSACoder.initKey();
            //公钥
            String publicKey = Base64.encodeBase64String(RSACoder.getPublicKey(initKey));
            //私钥
            String privateKey = Base64.encodeBase64String(RSACoder.getPrivateKey(initKey));

            return new Wallet(publicKey, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  获取钱包地址
     */
    public String getAddress(){
        String publickeyHash = hashPubkey(publickey);
        return Md5Util.generate32md5(publickeyHash);
    }

    /**
     *  获取钱包公钥hash
     */
    public String getHashPubkey(){
        return Sha256Utils.generatorSha256(publickey);
    }

    /**
     * 生成钱包公钥hash
     */
    private static String hashPubkey(String publickey) {
        return Sha256Utils.generatorSha256(publickey);
    }


}
