package com.coinbene.api.sdk.bean.contract.result;

public class Account {
    private String availableBalance;
    private String frozenBalance;
    private String balance;
    private String marginRatio;
    private String unrealisedPnl;

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(String frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getMarginRatio() {
        return marginRatio;
    }

    public void setMarginRatio(String marginRatio) {
        this.marginRatio = marginRatio;
    }

    public String getUnrealisedPnl() {
        return unrealisedPnl;
    }

    public void setUnrealisedPnl(String unrealisedPnl) {
        this.unrealisedPnl = unrealisedPnl;
    }
}
