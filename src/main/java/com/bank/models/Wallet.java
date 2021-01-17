package com.bank.models;

import javax.persistence.*;

@Entity
@Table(name= "wallet", schema = "accountbanking")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "walletid")
    private Long walletid;

    @Column(name = "name", nullable = false, length = 48)
    private String name;

    @Column(name = "description", nullable = false, length = 48)
    private String description;

    @Column(name = "amount", nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
