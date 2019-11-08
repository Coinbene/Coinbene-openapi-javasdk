package com.coinbene.api.sdk.bean.exchange.result;

import java.util.List;

public class MarginAccount {
    private String symbol;
    private String riskRate;
    private String forceClosePrice;
    private List<MarginAsset> assetList;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(String riskRate) {
        this.riskRate = riskRate;
    }

    public String getForceClosePrice() {
        return forceClosePrice;
    }

    public void setForceClosePrice(String forceClosePrice) {
        this.forceClosePrice = forceClosePrice;
    }

    public List<MarginAsset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<MarginAsset> assetList) {
        this.assetList = assetList;
    }
}
