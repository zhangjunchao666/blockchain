package com.hndfsj.blockchain.newblockchain.common;

import com.alibaba.fastjson.JSON;
import com.hndfsj.blockchain.newblockchain.bean.Wallet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO：获取钱包（钱包地址、公钥、私钥、钱包公钥hash）
 *
 * @author zhangjunchao
 * @date 2020/1/9
 */
@RestController
public class GetWallteAddres {

    @GetMapping("getWallte")
    public Object getWallteAddres(){
        Wallet wallet = Wallet.generateWallet();
        Object walletStr = JSON.toJSON(wallet);
        System.out.println(walletStr);
        return walletStr;
    }





}
