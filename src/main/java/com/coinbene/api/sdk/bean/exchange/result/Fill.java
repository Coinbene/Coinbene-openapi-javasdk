package com.coinbene.api.sdk.bean.exchange.result;

public class Fill {
    private String price; // 成交价钱
    private String quantity; //成交量
    private String amount; //成交额
    private String fee; //手续费
    private String direction; //主动成交方向 1:买 2:卖
    private String tradeTime; //成交时间
    private String feeByConi;//Coni折扣手续费

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getFeeByConi() {
        return feeByConi;
    }

    public void setFeeByConi(String feeByConi) {
        this.feeByConi = feeByConi;
    }
}
