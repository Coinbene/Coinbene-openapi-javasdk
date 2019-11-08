package com.coinbene.api.sdk.service.margin.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coinbene.api.sdk.bean.ServerTime;
import com.coinbene.api.sdk.bean.exchange.param.*;
import com.coinbene.api.sdk.bean.exchange.result.*;
import com.coinbene.api.sdk.bean.margin.result.BorrowOrderDTO;
import com.coinbene.api.sdk.bean.margin.result.MarginTradePairVO;
import com.coinbene.api.sdk.client.APIClient;
import com.coinbene.api.sdk.config.APIConfiguration;
import com.coinbene.api.sdk.service.margin.ClientAPIService;

import java.util.List;
import java.util.Map;

public class ClientAPIServiceImpl implements ClientAPIService {

    private final APIClient client;
    private final ClientAPI api;

    public ClientAPIServiceImpl(final APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = this.client.createService(ClientAPI.class);
    }


    @Override
    public ServerTime getServerTime() {
        return this.client.executeSync(this.api.getServerTime());
    }

    @Override
    public List<MarginAccount> getAccountList() {
        final ApiResponse<MarginAccount> apiResponse = this.client.executeSync(this.api.getAccountList());
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<MarginAccount> accounts = JSON.parseArray(jsonObject.get("data").toString(), MarginAccount.class);

        return accounts;
    }

    @Override
    public MarginAccount getAccountInfo(String symbol) {
        final ApiResponse<MarginAccount> apiResponse = this.client.executeSync(this.api.getAccountInfo(symbol));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final MarginAccount account = JSON.parseObject(jsonObject.get("data").toString(), MarginAccount.class);
        return account;
    }

    @Override
    public List<MarginTradePairVO> getSymbolConfigList() {
        final ApiResponse<List<MarginTradePairVO>> apiResponse = this.client.executeSync(this.api.getTradePairList());
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<MarginTradePairVO> list = JSON.parseArray(jsonObject.get("data").toString(), MarginTradePairVO.class);
        return list;
    }

    @Override
    public MarginTradePairVO getSymbolConfigrInfo(String symbol) {
        final ApiResponse<MarginTradePairVO> response = this.client.executeSync(this.api.getTradePairInfo(symbol));
        final String jsonStr = JSON.toJSONString(response);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final MarginTradePairVO vo = JSON.parseObject(jsonObject.get("data").toString(), MarginTradePairVO.class);
        return vo;
    }

    @Override
    public PlaceOrder placeOrder(PlaceOrderParam param) {
        final ApiResponse<PlaceOrder> apiResponse = this.client.executeSync(this.api.placeOrder(param));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);

        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final PlaceOrder placeOrder = JSON.parseObject(jsonObject.get("data").toString(), PlaceOrder.class);
        return placeOrder;
    }

    @Override
    public CancelOrder cancelOrder(OrderInfoParam param) {
        final ApiResponse<PlaceOrder> apiResponse = this.client.executeSync(this.api.cancelOrder(param));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);

        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final String orderId = jsonObject.get("data").toString();
        final CancelOrder cancelOrder = new CancelOrder();
        cancelOrder.setOrderId(orderId);
        return cancelOrder;
    }

    @Override
    public List<BatchCancelOrder> batchCancelOrders(BatchCancelParam param) {
        final ApiResponse<BatchCancelOrder> apiResponse = this.client.executeSync(this.api.batchCancelOrders(param));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<BatchCancelOrder> batchCancelOrders = JSON.parseArray(jsonObject.get("data").toString(), BatchCancelOrder.class);
        return batchCancelOrders;
    }

    @Override
    public Order getOrderInfo(String orderId) {
        final ApiResponse<Order> apiResponse = this.client.executeSync(this.api.getOrderInfo(orderId));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final Order order = JSON.parseObject(jsonObject.get("data").toString(), Order.class);
        return order;
    }

    @Override
    public List<Order> openOrders(String symbol, String latestOrderId) {
        final ApiResponse<List<Order>> apiResponse = this.client.executeSync(this.api.openOrders(symbol, latestOrderId));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<Order> openOrders = JSON.parseArray(jsonObject.get("data").toString(), Order.class);
        return openOrders;
    }

    @Override
    public List<Order> closedOrders(String symbol, String latestOrderId) {
        final ApiResponse<List<Order>> apiResponse = this.client.executeSync(this.api.closedOrders(symbol, latestOrderId));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<Order> closedOrders = JSON.parseArray(jsonObject.get("data").toString(), Order.class);
        return closedOrders;
    }

    @Override
    public List<Fill> getFills(String orderId) {
        final ApiResponse<List<Fill>> apiResponse = this.client.executeSync(this.api.getFills(orderId));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }

        final List<Fill> fills = JSON.parseArray(jsonObject.get("data").toString(), Fill.class);
        return fills;
    }

    @Override
    public Map maxBorrow(String symbol, String asset) {
        final ApiResponse<Map> apiResponse = this.client.executeSync(this.api.maxBorrow(symbol, asset));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }

        return JSON.parseObject(jsonStr, Map.class);
    }

    @Override
    public Boolean borrow(BorrowOrderParam borrowOrderParam) {
        final ApiResponse<String> apiResponse = this.client.executeSync(this.api.borrow(borrowOrderParam));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }

        return (Boolean) jsonObject.get("data");
    }

    @Override
    public Boolean repayment(RepayOrderParam repayOrderParam) {
        final ApiResponse<Boolean> apiResponse = this.client.executeSync(this.api.repayment(repayOrderParam));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }

        return (Boolean) jsonObject.get("data");
    }

    @Override
    public List<BorrowOrderDTO> unRepayList(String symbol, String asset, String lastBorrowId) {
        final ApiResponse<List<BorrowOrderDTO>> apiResponse = this.client.executeSync(this.api.unRepayOrderList(symbol, asset, lastBorrowId));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }

        final List<BorrowOrderDTO> orders = JSON.parseArray(jsonObject.get("data").toString(), BorrowOrderDTO.class);
        return orders;
    }

    @Override
    public List<BorrowOrderDTO> finishRepayList(String symbol, String asset, String lastBorrowId) {
        final ApiResponse<List<BorrowOrderDTO>> apiResponse = this.client.executeSync(this.api.finishRepayOrderList(symbol, asset, lastBorrowId));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }

        final List<BorrowOrderDTO> orders = JSON.parseArray(jsonObject.get("data").toString(), BorrowOrderDTO.class);
        return orders;
    }


}
