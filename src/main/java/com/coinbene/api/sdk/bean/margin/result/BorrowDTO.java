package com.coinbene.api.sdk.bean.margin.result;

public class BorrowDTO {
    private String maxBorrow;
    private String rate;
    private String minBorrow;

    public String getMaxBorrow() {
        return maxBorrow;
    }

    public void setMaxBorrow(String maxBorrow) {
        this.maxBorrow = maxBorrow;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getMinBorrow() {
        return minBorrow;
    }

    public void setMinBorrow(String minBorrow) {
        this.minBorrow = minBorrow;
    }
}
