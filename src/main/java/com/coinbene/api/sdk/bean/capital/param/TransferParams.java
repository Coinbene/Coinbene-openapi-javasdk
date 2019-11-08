package com.coinbene.api.sdk.bean.capital.param;

public class TransferParams {
    private String amount;
    private String asset;
    private String from;
    private String to;
    private String fromInstrumentId;
    private String toInstrumentId;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFromInstrumentId() {
        return fromInstrumentId;
    }

    public void setFromInstrumentId(String fromInstrumentId) {
        this.fromInstrumentId = fromInstrumentId;
    }

    public String getToInstrumentId() {
        return toInstrumentId;
    }

    public void setToInstrumentId(String toInstrumentId) {
        this.toInstrumentId = toInstrumentId;
    }
}
