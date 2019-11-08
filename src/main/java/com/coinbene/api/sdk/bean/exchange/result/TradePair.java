package com.coinbene.api.sdk.bean.exchange.result;

public class TradePair {
    private String symbol;
    private String baseAsset;
    private String quoteAsset;
    private String pricePrecision;
    private String amountPrecision;
    private String takerFeeRate;
    private String makerFeeRate;
    private String minAmount;
    private String priceFluctuation;
    private String site;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public String getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(String pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public String getAmountPrecision() {
        return amountPrecision;
    }

    public void setAmountPrecision(String amountPrecision) {
        this.amountPrecision = amountPrecision;
    }

    public String getTakerFeeRate() {
        return takerFeeRate;
    }

    public void setTakerFeeRate(String takerFeeRate) {
        this.takerFeeRate = takerFeeRate;
    }

    public String getMakerFeeRate() {
        return makerFeeRate;
    }

    public void setMakerFeeRate(String makerFeeRate) {
        this.makerFeeRate = makerFeeRate;
    }

    public String getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(String minAmount) {
        this.minAmount = minAmount;
    }

    public String getPriceFluctuation() {
        return priceFluctuation;
    }

    public void setPriceFluctuation(String priceFluctuation) {
        this.priceFluctuation = priceFluctuation;
    }
}
