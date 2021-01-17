package com.bank.dto;

import com.bank.models.Wallet;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class WalletDTO {

    private Long walletid;

    @NotBlank(message = "The wallet name can not be empty")
    private String name;

    @NotBlank(message = "The wallet description can not be empty")
    private String description;

    private int amount;

    @NotNull
    private Long userId;

    public WalletDTO(){}

    public Long getWalletid() {
        return walletid;
    }

    public void setWalletid(Long walletid) {
        this.walletid = walletid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
