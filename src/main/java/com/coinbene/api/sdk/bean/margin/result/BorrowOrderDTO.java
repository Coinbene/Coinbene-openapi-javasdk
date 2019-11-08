package com.coinbene.api.sdk.bean.margin.result;

public class BorrowOrderDTO {
    private String borrowId;
    private String symbol;
    private String asset;
    private String borrowQuantity;
    private String interest;
    private String repayQuantity;
    private String repayInterest;

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getBorrowQuantity() {
        return borrowQuantity;
    }

    public void setBorrowQuantity(String borrowQuantity) {
        this.borrowQuantity = borrowQuantity;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getRepayQuantity() {
        return repayQuantity;
    }

    public void setRepayQuantity(String repayQuantity) {
        this.repayQuantity = repayQuantity;
    }

    public String getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(String repayInterest) {
        this.repayInterest = repayInterest;
    }
}
