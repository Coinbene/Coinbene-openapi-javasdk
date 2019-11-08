package com.coinbene.api.sdk.service.contract.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coinbene.api.sdk.bean.ServerTime;
import com.coinbene.api.sdk.bean.contract.param.BatchCancelParam;
import com.coinbene.api.sdk.bean.contract.param.OrderInfoParam;
import com.coinbene.api.sdk.bean.contract.param.PlaceOrderParam;
import com.coinbene.api.sdk.bean.contract.result.*;
import com.coinbene.api.sdk.client.APIClient;
import com.coinbene.api.sdk.config.APIConfiguration;
import com.coinbene.api.sdk.service.contract.ClientAPIService;

import java.util.HashMap;
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
    public Account getAccount() {
        final ApiResponse<Account> apiResponse = this.client.executeSync(this.api.getAccount());
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final Account account = JSON.parseObject(jsonObject.get("data").toString(), Account.class);
        return account;
    }

    @Override
    public List<Contract> getContractList() {
        final ApiResponse<Contract> apiResponse = this.client.executeSync(this.api.contractList());
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<Contract> contracts = JSON.parseArray(jsonObject.get("data").toString(), Contract.class);
        return contracts;
    }


    @Override
    public List<Position> positions(String symbol) {
        final ApiResponse<Position> apiResponse = this.client.executeSync(this.api.positions(symbol));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<Position> positions = JSON.parseArray(jsonObject.get("data").toString(), Position.class);
        return positions;
    }

    @Override
    public List<CapitalFee> feeRate(String symbol, String pageNum, String pageSize) {
        final ApiResponse<CapitalFee> apiResponse = this.client.executeSync(this.api.feeRate(symbol, pageNum, pageSize));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<CapitalFee> capitalFees = JSON.parseArray(jsonObject.get("data").toString(), CapitalFee.class);
        return capitalFees;
    }

    @Override
    public OrderBook orderBook(String symbol, String size) {
        final ApiResponse<OrderBook> apiResponse = this.client.executeSync(this.api.orderBook(symbol, size));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }

        final JSONObject jsonObject1 = JSON.parseObject(jsonObject.get("data").toString());
        final String _symbol = jsonObject1.get("symbol").toString();
        final List<String[]> asks = JSON.parseArray(jsonObject1.get("asks").toString(),String[].class);
        final List<String[]> bids = JSON.parseArray(jsonObject1.get("bids").toString(),String[].class);

        final OrderBook orderBook = new OrderBook();
        orderBook.setAsks(asks);
        orderBook.setBids(bids);
        orderBook.setSymbol(_symbol);
        return orderBook;
    }

    @Override
    public String fundingRate(String symbol) {
        final ApiResponse apiResponse = this.client.executeSync(this.api.fundingRate(symbol));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final String fundingRate = JSON.parseObject(jsonObject.get("data").toString(), String.class);
        return fundingRate;
    }

    @Override
    public List<String[]> klines(String symbol, String resolution, String startTime, String endTime) {
        final ApiResponse<List<String[]>> apiResponse = this.client.executeSync(this.api.klines(symbol, resolution, startTime,endTime));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<String[]> klines = JSON.parseArray(jsonObject.get("data").toString(), String[].class);
        return klines;
    }

    @Override
    public Map<String, LastTicker> getLastTicker() {
        final Map<String, LastTicker> resultMap = new HashMap<>();
        final ApiResponse apiResponse = this.client.executeSync(this.api.getLastTicker());
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final Map<String, JSONObject> tickerMap = JSON.parseObject(jsonObject.get("data").toString(), Map.class);
        for (Map.Entry<String, JSONObject> entry : tickerMap.entrySet()) {
            final String key = entry.getKey();
            final LastTicker value = JSON.parseObject(entry.getValue().toString(), LastTicker.class);
            resultMap.put(key, value);
        }
        return resultMap;
    }

    @Override
    public List<String[]> getTrades(String symbol, String limit) {
        final ApiResponse<List<String[]>> apiResponse = this.client.executeSync(this.api.getTrades(symbol, limit));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<String[]> trades = JSON.parseArray(jsonObject.get("data").toString(), String[].class);
        return trades;
    }

    @Override
    public List<Fills> getFills(String symbol, String tradeId, String orderId) {
        final ApiResponse<List<Fills>> apiResponse = this.client.executeSync(this.api.getFills(symbol, tradeId, orderId));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<Fills> fills = JSON.parseArray(jsonObject.get("data").toString(), Fills.class);
        return fills;
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
        final ApiResponse<CancelOrder> apiResponse = this.client.executeSync(this.api.cancelOrder(param));
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
    public List<Order> openOrders(String symbol, String pageNum, String pageSize) {
        final ApiResponse<Order> apiResponse = this.client.executeSync(this.api.openOrders(symbol, pageNum, pageSize));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<Order> openOrders = JSON.parseArray(jsonObject.get("data").toString(), Order.class);
        return openOrders;
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
    public List<Order> closedOrders(String beginTime, String endTime,String symbol, String pageNum, String pageSize) {
        final ApiResponse<Order> apiResponse = this.client.executeSync(this.api.closedOrders(beginTime, endTime, symbol, pageNum, pageSize));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<Order> closedOrders = JSON.parseArray(jsonObject.get("data").toString(), Order.class);
        return closedOrders;
    }

    @Override
    public List<Order> openOrders(String symbol, String latestOrderId) {
        final ApiResponse<Order> apiResponse = this.client.executeSync(this.api.openOrders(symbol, latestOrderId));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<Order> openOrders = JSON.parseArray(jsonObject.get("data").toString(), Order.class);
        return openOrders;
    }

    @Override
    public List<Order> closedOrdersByPage(String symbol, String latestOrderId, String status, String beginTime, String endTime) {
        final ApiResponse<Order> apiResponse = this.client.executeSync(this.api.closedOrdersByPage(symbol, latestOrderId, status, beginTime, endTime));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<Order> closedOrders = JSON.parseArray(jsonObject.get("data").toString(), Order.class);
        return closedOrders;
    }

}
