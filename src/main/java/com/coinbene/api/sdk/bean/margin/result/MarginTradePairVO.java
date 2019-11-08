package com.coinbene.api.sdk.bean.margin.result;

public class MarginTradePairVO {
    private String symbol;
    private String base;
    private String quote;
    private String leverage;
    private String pricePrecision;
    private String makeFee;
    private String takeFee;
    private String sellDisabled;
    private String minVolume;
    private String volumePrecision;
    private String initialPrice;
    private String baseInterestRate;
    private String quoteInterestRate;
    private String priceChangeScale;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getLeverage() {
        return leverage;
    }

    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    public String getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(String pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public String getMakeFee() {
        return makeFee;
    }

    public void setMakeFee(String makeFee) {
        this.makeFee = makeFee;
    }

    public String getTakeFee() {
        return takeFee;
    }

    public void setTakeFee(String takeFee) {
        this.takeFee = takeFee;
    }

    public String getSellDisabled() {
        return sellDisabled;
    }

    public void setSellDisabled(String sellDisabled) {
        this.sellDisabled = sellDisabled;
    }

    public String getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(String minVolume) {
        this.minVolume = minVolume;
    }

    public String getVolumePrecision() {
        return volumePrecision;
    }

    public void setVolumePrecision(String volumePrecision) {
        this.volumePrecision = volumePrecision;
    }

    public String getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(String initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getBaseInterestRate() {
        return baseInterestRate;
    }

    public void setBaseInterestRate(String baseInterestRate) {
        this.baseInterestRate = baseInterestRate;
    }

    public String getQuoteInterestRate() {
        return quoteInterestRate;
    }

    public void setQuoteInterestRate(String quoteInterestRate) {
        this.quoteInterestRate = quoteInterestRate;
    }

    public String getPriceChangeScale() {
        return priceChangeScale;
    }

    public void setPriceChangeScale(String priceChangeScale) {
        this.priceChangeScale = priceChangeScale;
    }
}
