package com.coinbene.api.sdk.bean.contract.result;

public class Position {
    private String availableQuantity;
    private String avgPrice;
    private String createTime;
    private String deleveragePercentile;
    private String leverage;
    private String liquidationPrice;
    private String markPrice;
    private String positionMargin;
    private String positionValue;
    private String quantity;
    private String realisedPnl;
    private String roe;
    private String side;
    private String symbol;
    private String unrealisedPnl;
    private String positionId;

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(String availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDeleveragePercentile() {
        return deleveragePercentile;
    }

    public void setDeleveragePercentile(String deleveragePercentile) {
        this.deleveragePercentile = deleveragePercentile;
    }

    public String getLeverage() {
        return leverage;
    }

    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    public String getLiquidationPrice() {
        return liquidationPrice;
    }

    public void setLiquidationPrice(String liquidationPrice) {
        this.liquidationPrice = liquidationPrice;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }

    public String getPositionMargin() {
        return positionMargin;
    }

    public void setPositionMargin(String positionMargin) {
        this.positionMargin = positionMargin;
    }

    public String getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(String positionValue) {
        this.positionValue = positionValue;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRealisedPnl() {
        return realisedPnl;
    }

    public void setRealisedPnl(String realisedPnl) {
        this.realisedPnl = realisedPnl;
    }

    public String getRoe() {
        return roe;
    }

    public void setRoe(String roe) {
        this.roe = roe;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUnrealisedPnl() {
        return unrealisedPnl;
    }

    public void setUnrealisedPnl(String unrealisedPnl) {
        this.unrealisedPnl = unrealisedPnl;
    }
}
