package com.coinbene.api.sdk.bean.capital.result;

public class DepositAddressVo {
    private String asset;
    private String chain;
    private String address;
    private String addressTag;
    private String minDepositAmount;
    private String depositConfirmations;
    private String status; // 1可用，0不可用

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressTag() {
        return addressTag;
    }

    public void setAddressTag(String addressTag) {
        this.addressTag = addressTag;
    }

    public String getMinDepositAmount() {
        return minDepositAmount;
    }

    public void setMinDepositAmount(String minDepositAmount) {
        this.minDepositAmount = minDepositAmount;
    }

    public String getDepositConfirmations() {
        return depositConfirmations;
    }

    public void setDepositConfirmations(String depositConfirmations) {
        this.depositConfirmations = depositConfirmations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
