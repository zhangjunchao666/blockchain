package com.hndfsj.blockchain.newblockchain.common;

import com.hndfsj.blockchain.newblockchain.bean.Transaction;
import com.hndfsj.blockchain.newblockchain.bean.TransactionInput;
import com.hndfsj.blockchain.newblockchain.bean.TransactionOutput;
import com.hndfsj.blockchain.newblockchain.bean.Wallet;
import com.hndfsj.blockchain.newblockchain.utils.UUIDGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * TODO： 交易
 *
 * @author zhangjunchao
 * @date 2020/1/10
 */
@RestController
public class WalletTransaction {

    @PostMapping("transaction")
    public Object transaction(){

        // 创建一个空的交易集合
        ArrayList<Transaction> txs = new ArrayList<>();
        Transaction tx1 = new Transaction();
        Transaction tx2 = new Transaction();
        txs.add(tx1);
        txs.add(tx2);

        // 2个钱包：wallet1、wallet2
        Wallet wallet1 = Wallet.generateWallet();
        Wallet wallet2 = Wallet.generateWallet();

        // 钱包输入  todo：签名未完成
        assert wallet1 != null;
        TransactionInput txIn = new TransactionInput(UUIDGenerator.UUID32(),10,"未完成",wallet1.getPublickey());
        // 钱包输出
        assert wallet2 != null;
        TransactionOutput txOut = new TransactionOutput(10,wallet2.getHashPubkey());
        // 新建一个交易
        Transaction tx3 = new Transaction(UUIDGenerator.UUID32(), txIn, txOut);
        txs.add(tx3);

        return null;
    }




}
