package com.coinbene.api.sdk.bean;

/**
 * Time of the server running REST API.
 */
public class ServerTime {
    private String iso;
    private String epoch;

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }
}
