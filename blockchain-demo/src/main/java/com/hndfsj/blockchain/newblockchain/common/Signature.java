package com.hndfsj.blockchain.newblockchain.common;

import com.hndfsj.blockchain.newblockchain.bean.Block;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO：数字签名-生成数字签名：每一个区块都必须要有自己的数据签名即hash值。
 *       这个hash值依赖于自身的信息（data）和上一个区块的数字签名（previousHash）
 *
 * @author zhangjunchao
 * @date 2019/12/5
 */
@Controller
public class Signature {

    /**
     * 每一个区块都必须要有自己的数字签名
     */
    @GetMapping("generatorHash")
    @ResponseBody
    public static List<String> generatorHash() {
        // 因为是创世区块，所以没有前一个区块的hash，所以设为0
        Block genesisBlock = new Block("我是创始区块", "0");
        System.out.println("创世区块1-数字签名 : " + genesisBlock.hash);
        String one = "创世区块1-数字签名 : " + genesisBlock.hash;

        Block secondBlock = new Block("我是第二个区块", genesisBlock.hash);
        System.out.println("区块2-数字签名 : " + secondBlock.hash);
        String two = "区块2-数字签名 : " + secondBlock.hash;

        Block thirdBlock = new Block("我是第三个区块", secondBlock.hash);
        System.out.println("区块3-数字签名 : " + thirdBlock.hash);
        String three = "区块3-数字签名 : " + thirdBlock.hash;

        ArrayList<String> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);

        return list;

    }


}
