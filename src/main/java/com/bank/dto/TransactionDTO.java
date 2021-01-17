package com.bank.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TransactionDTO {

    private Long id;

    @NotBlank(message = "The task name can not be empty")
    private String description;

    @NotBlank(message = "The task name can not be empty")
    private int amount;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @NotNull
    private Long userId;

    public TransactionDTO() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
