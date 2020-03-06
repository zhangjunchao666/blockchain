package com.hndfsj.blockchain.newblockchain.bean;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2020/1/21
 */
public class TransactionParam {

    /**
     * 发送方钱包地址
     */
    private String sender;
    /**
     * 接收方钱包地址
     */
    private String recipient;
    /**
     * 发送金额
     */
    private int amount;

    // ----------------------------------------


    public TransactionParam() {
    }

    public TransactionParam(String sender, String recipient, int amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
