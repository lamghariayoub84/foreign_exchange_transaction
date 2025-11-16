package com.forxt.foreign_exchange_transaction.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table(name = "fx_deals")
public class Fx_deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String dealUniqueId;
    @Column
    private String from_currency;
    @Column
    private String to_currency;
    @Column
    private LocalDateTime deal_timestamp;
    @Column
    private double amount;
    public Fx_deal() {}
    public Fx_deal(String dealUniqueId,String from_currency,String to_currency,LocalDateTime deal_timestamp, double amount) {
        this.dealUniqueId = dealUniqueId;
        this.from_currency = from_currency;
        this.to_currency = to_currency;
        this.amount = amount;
        this.deal_timestamp = deal_timestamp;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDealUniqueId() {
        return dealUniqueId;
    }

    public void setDealUniqueId(String dealUniqueId) {
        this.dealUniqueId = dealUniqueId;
    }

    public LocalDateTime getDeal_timestamp() {
        return deal_timestamp;
    }

    public void setDeal_timestamp(LocalDateTime deal_timestamp) {
        this.deal_timestamp = deal_timestamp;
    }

    public String getFrom_currency() {
        return from_currency;
    }

    public void setFrom_currency(String from_currency) {
        this.from_currency = from_currency;
    }

    public String getTo_currency() {
        return to_currency;
    }

    public void setTo_currency(String to_currency) {
        this.to_currency = to_currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
