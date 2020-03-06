package com.hndfsj.blockchain.newblockchain.bean;

/**
 * TODO：交易
 *
 * @author zhangjunchao
 * @date 2020/1/10
 */
public class Transaction {

    /**
     * 交易唯一标识
     */
    private String id;
    /**
     * 交易输入
     */
    private TransactionInput txIn;
    /**
     * 交易输出
     */
    private TransactionOutput txOut;

    public Transaction() {
        super();
    }

    public Transaction(String id, TransactionInput txIn, TransactionOutput txOut) {
        super();
        this.id = id;
        this.txIn = txIn;
        this.txOut = txOut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionInput getTxIn() {
        return txIn;
    }

    public void setTxIn(TransactionInput txIn) {
        this.txIn = txIn;
    }

    public TransactionOutput getTxOut() {
        return txOut;
    }

    public void setTxOut(TransactionOutput txOut) {
        this.txOut = txOut;
    }






}
