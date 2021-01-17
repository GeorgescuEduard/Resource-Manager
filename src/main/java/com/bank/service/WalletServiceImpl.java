package com.bank.service;

import com.bank.exception.RecordNotFoundException;
import com.bank.models.Wallet;
import com.bank.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("walletService")
public class WalletServiceImpl implements WalletService {

    private static final Logger logger = LoggerFactory.getLogger(WalletServiceImpl.class);

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet findWallet(Long walletid) {
        Wallet wallet = walletRepository.findById(walletid).orElse(null);
        return wallet;
    }

    @Override
    public List<Wallet> findAllWallets() {
        return walletRepository.findAll();
    }

    @Override
    public List<Wallet> findUserWallet(Long walletid) {
        return walletRepository.findByWalletid(walletid);
    }

    @Override
    @Transactional
    public Wallet add(Wallet wallet) {
        walletRepository.save(wallet);
        return wallet;
    }

    @Override
    @Transactional
    public Wallet update(Wallet wallet) {
        Wallet existingWallet = walletRepository.findById(wallet.getWalletid()).orElse(null);
        if (existingWallet == null){
            String errorMessage = "Wallet with id " + wallet.getWalletid() + " not found";
            logger.error(errorMessage);
            throw new RecordNotFoundException(errorMessage);
        }
        return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public void transfer(Wallet from, Wallet to) {
        Wallet existingWallet = walletRepository.findById(from.getWalletid()).orElse(null);
        if (existingWallet == null){
            String errorMessage = "Wallet with id " + from.getWalletid() + " not found";
            logger.error(errorMessage);
            throw new RecordNotFoundException(errorMessage);
        }
        walletRepository.save(from);
    }

    @Override
    @Transactional
    public void delete(Long walletid) {

        Wallet wallet = walletRepository.findById(walletid).orElse(null);
        logger.debug("Delete wallet with id: " + walletid);
        if(wallet != null){
            walletRepository.deleteById(walletid);
        } else {
            String errorMessage = "Task with id " + walletid + " not found";
            logger.error(errorMessage);
            throw new RecordNotFoundException(errorMessage);
        }
    }
}
