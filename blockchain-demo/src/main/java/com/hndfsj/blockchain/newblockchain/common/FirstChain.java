package com.hndfsj.blockchain.newblockchain.common;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.hndfsj.blockchain.newblockchain.bean.Block;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO：第一个链
 *
 * @author zhangjunchao
 * @date 2019/12/5
 */
@RestController
public class FirstChain {

    // 链
    public static ArrayList<Block> blockchain = new ArrayList<>();

    // 挖矿困难度  比特币：10个0 ，0代表挖矿困难度
    private static int difficulty = 4;


    // 创世区块
    @GetMapping("blockchain")
    public Object blockchain(){
        // 将我们的块添加到链中
        blockchain.add(new Block("我是1号创世区块", "0"));
        System.out.println("试着生成1号创世区块");
        blockchain.get(0).creationBlock(difficulty);

        if (isChainValid()){
            String isChainValid = "创世区块生成成功!" ;

            String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
            System.out.println(blockchainJson);

            HashMap<String, Object> map = new HashMap<>(16);
            map.put("success", isChainValid);
            map.put("blockchainJson", blockchainJson);

            return map;

        }else {
            String isChainValid = "创世区块生成失败!" ;
            ArrayList<String> list = new ArrayList<>();
            list.add(isChainValid);
            return list;
        }

    }

    // 挖矿添加新的区块
    @PostMapping("addBlockchain")
    public Object addBlockchain(){

        blockchain.add(new Block("我是第".concat(String.valueOf(blockchain.size()+1)).concat("号区块"), blockchain.get(blockchain.size() - 1).hash));
        System.out.println("试着开采" + String.valueOf(blockchain.size()) + "号区块");
        blockchain.get(blockchain.size()-1).mineBlock(difficulty);

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);

        if (isChainValid()){

            String isChainValid = "挖矿成功!" ;

            ArrayList<String> list = new ArrayList<>();
            list.add(isChainValid);
            list.add(blockchainJson);

            return list;

        }else {
            String isChainValid = "挖矿失败!" ;
            ArrayList<String> errorList = new ArrayList<>();
            errorList.add(isChainValid);
            return errorList;
        }
    }

    /**
     * 检查区块是否有效的：任何区块链中区块的一丝一毫改变都会导致这个函数返回false，也就证明了区块链无效了。
     * @return
     */
    @GetMapping("isChainValid")
    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        // 通过区块链来检查哈希值
        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            // 比较注册哈希和计算哈希
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("当前散列不相等");
                return false;
            }
            // 比较以前的散列和注册的以前的散列
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("以前的散列不相等");
                return false;
            }
            // 检查哈希是否已解决
            if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("这个街区还没有被开采");
                return false;
            }
        }
        return true;
    }


    // 清空区块链
    @GetMapping("cleanBlock")
    public String cleanBlock(){
        blockchain.clear();
        System.out.println("清除区块链成功！");
        return "清除区块链成功！";
    }




}















