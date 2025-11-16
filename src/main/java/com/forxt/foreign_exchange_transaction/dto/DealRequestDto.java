package com.forxt.foreign_exchange_transaction.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public class DealRequestDto {

    private String dealUniqueid;

    private String fromCurrency;

    private String toCurrency;

    private LocalDateTime dealTimestamp;

    private double amount;

    public String getDealUniqueid() {
        return dealUniqueid;
    }

    public void setDealUniqueid(String dealUniqueid) {
        this.dealUniqueid = dealUniqueid;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public LocalDateTime getDealTimestamp() {
        return dealTimestamp;
    }

    public void setDealTimestamp(LocalDateTime dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
