package com.bank.service;

import com.bank.models.Wallet;

import java.util.List;

public interface WalletService {

    public Wallet findWallet(Long walletid);

    public List<Wallet> findAllWallets();

    public List<Wallet> findUserWallet(Long walletid);

    public Wallet add(Wallet wallet);

    public Wallet update(Wallet wallet);

    public void delete(Long walletid);

    public void transfer(Wallet from, Wallet to);

}
