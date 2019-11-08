package com.coinbene.api.sdk.bean.contract.result;

public class Contract {
    private String contractName;
    private String multiplier;
    private String minTradeAmount;
    private String maxTradeAmount;
    private String minPriceChange;
    private String initPrice;
    private String tradePrecision;
    private String costPriceMultiplier;
    private String settleAssetRate;
    private String valuationAssetRate;

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }

    public String getMinTradeAmount() {
        return minTradeAmount;
    }

    public void setMinTradeAmount(String minTradeAmount) {
        this.minTradeAmount = minTradeAmount;
    }

    public String getMaxTradeAmount() {
        return maxTradeAmount;
    }

    public void setMaxTradeAmount(String maxTradeAmount) {
        this.maxTradeAmount = maxTradeAmount;
    }

    public String getMinPriceChange() {
        return minPriceChange;
    }

    public void setMinPriceChange(String minPriceChange) {
        this.minPriceChange = minPriceChange;
    }

    public String getInitPrice() {
        return initPrice;
    }

    public void setInitPrice(String initPrice) {
        this.initPrice = initPrice;
    }

    public String getTradePrecision() {
        return tradePrecision;
    }

    public void setTradePrecision(String tradePrecision) {
        this.tradePrecision = tradePrecision;
    }

    public String getCostPriceMultiplier() {
        return costPriceMultiplier;
    }

    public void setCostPriceMultiplier(String costPriceMultiplier) {
        this.costPriceMultiplier = costPriceMultiplier;
    }

    public String getSettleAssetRate() {
        return settleAssetRate;
    }

    public void setSettleAssetRate(String settleAssetRate) {
        this.settleAssetRate = settleAssetRate;
    }

    public String getValuationAssetRate() {
        return valuationAssetRate;
    }

    public void setValuationAssetRate(String valuationAssetRate) {
        this.valuationAssetRate = valuationAssetRate;
    }
}
