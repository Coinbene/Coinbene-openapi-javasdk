package com.coinbene.api.sdk.bean.exchange.result;

import java.util.List;


public class OrderBook {

    private List<String[]> asks;// 卖方深度
    private List<String[]> bids;// 买方深度
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<String[]> getAsks() {
        return asks;
    }

    public void setAsks(List<String[]> asks) {
        this.asks = asks;
    }

    public List<String[]> getBids() {
        return bids;
    }

    public void setBids(List<String[]> bids) {
        this.bids = bids;
    }
}
