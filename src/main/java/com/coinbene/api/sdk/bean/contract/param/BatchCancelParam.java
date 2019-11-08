package com.coinbene.api.sdk.bean.contract.param;

import java.util.List;

public class BatchCancelParam {
    private List<String> orderIds;

    public List<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<String> orderIds) {
        this.orderIds = orderIds;
    }
}
