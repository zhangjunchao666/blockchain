package com.hndfsj.blockchain.newblockchain.bean;

import com.hndfsj.blockchain.newblockchain.utils.Sha256Utils;

/**
 * @author zhangjunchao
 * @date 2019/12/5
 */
public class Block {

    /**
     *  hash：保存数字签名
     */
    public String hash;
    /**
     *  前一个区块的hash
     */
    public String previousHash;
    /**
     *  区块数据
     */
    private String data;
    /**
     * 生成区块的时间戳
     */
    private long timeStamp;
    /**
     * 工作量证明，计算正确hash值的次数
     */
    public int nonce;



    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        this.hash = calculateHash();
    }

    // 计算区块的hash - 计算的hash值应该包括区块中所有不希望被恶意篡改的数据，包括previousHash，data和timeStamp和nonce
    public String calculateHash() {
        return Sha256Utils.generatorSha256(previousHash .concat(Long.toString(timeStamp)).concat(Integer.toString(nonce)).concat(data));
    }

    // 挖矿：一般的计算机，是挖不出矿的（默认10个0），需要有专门的矿机，或者用矿石（分布式计算）
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
            System.out.println("正在挖矿，挖矿次数为：".concat(Integer.toString(nonce)));
        }
    }

    public void creationBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
            System.out.println("正在生成创世区块，生成次数为：".concat(Integer.toString(nonce)));
        }
    }




}
