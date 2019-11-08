package com.coinbene.api.sdk.enums;

/**
 * Futures Currencies
 *
 */
public enum FuturesCurrenciesEnum {

    BTC(0), ETH(1);
    private int symbol;

    FuturesCurrenciesEnum(int symbol) {
        this.symbol = symbol;
    }

    public int getSymbol() {
        return symbol;
    }
}
