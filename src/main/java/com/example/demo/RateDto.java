package com.example.demo;

/**
 * @author scl.BlueOcean
 * @version 1.0
 * @date 2018年07月30 14:05
 * @description
 */
public class RateDto {
    private String from;
    private String to;
    private Double amount;
    private Double rate;

    public RateDto(String from, String to, Double amount, Double rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.amount = amount*rate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
