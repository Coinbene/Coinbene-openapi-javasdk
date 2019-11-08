package com.coinbene.api.sdk.bean.contract.result;

public class LastTicker {

    private String lastPrice;
    private String markPrice;
    private String bestAskPrice;
    private String bestBidPrice;
    private String high24h;
    private String low24h;
    private String volume24h;
    private String turnover;
    private String bestAskVolume;
    private String bestBidVolume;
private String timestamp;

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }

    public String getBestAskPrice() {
        return bestAskPrice;
    }

    public void setBestAskPrice(String bestAskPrice) {
        this.bestAskPrice = bestAskPrice;
    }

    public String getBestBidPrice() {
        return bestBidPrice;
    }

    public void setBestBidPrice(String bestBidPrice) {
        this.bestBidPrice = bestBidPrice;
    }

    public String getHigh24h() {
        return high24h;
    }

    public void setHigh24h(String high24h) {
        this.high24h = high24h;
    }

    public String getLow24h() {
        return low24h;
    }

    public void setLow24h(String low24h) {
        this.low24h = low24h;
    }

    public String getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(String volume24h) {
        this.volume24h = volume24h;
    }

    public String getBestAskVolume() {
        return bestAskVolume;
    }

    public void setBestAskVolume(String bestAskVolume) {
        this.bestAskVolume = bestAskVolume;
    }

    public String getBestBidVolume() {
        return bestBidVolume;
    }

    public void setBestBidVolume(String bestBidVolume) {
        this.bestBidVolume = bestBidVolume;
    }
}
