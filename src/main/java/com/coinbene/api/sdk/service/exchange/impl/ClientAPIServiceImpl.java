package com.coinbene.api.sdk.service.exchange.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coinbene.api.sdk.bean.ServerTime;
import com.coinbene.api.sdk.bean.exchange.param.BatchCancelParam;
import com.coinbene.api.sdk.bean.exchange.param.OrderInfoParam;
import com.coinbene.api.sdk.bean.exchange.param.PlaceOrderParam;
import com.coinbene.api.sdk.bean.exchange.param.WithdrawParam;
import com.coinbene.api.sdk.bean.exchange.result.Account;
import com.coinbene.api.sdk.bean.exchange.result.ApiResponse;
import com.coinbene.api.sdk.bean.exchange.result.BatchCancelOrder;
import com.coinbene.api.sdk.bean.exchange.result.CancelOrder;
import com.coinbene.api.sdk.bean.exchange.result.Fill;
import com.coinbene.api.sdk.bean.exchange.result.Order;
import com.coinbene.api.sdk.bean.exchange.result.OrderBook;
import com.coinbene.api.sdk.bean.exchange.result.PlaceOrder;
import com.coinbene.api.sdk.bean.exchange.result.Ticker;
import com.coinbene.api.sdk.bean.exchange.result.TradePair;
import com.coinbene.api.sdk.client.APIClient;
import com.coinbene.api.sdk.config.APIConfiguration;
import com.coinbene.api.sdk.service.exchange.ClientAPIService;
import retrofit2.http.Query;

import java.util.List;

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
    public List<Account> getAccountList() {

        final ApiResponse<Account> apiResponse = this.client.executeSync(this.api.getAccountList());
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<Account> accounts = JSON.parseArray(jsonObject.get("data").toString(), Account.class);
        return accounts;
    }

    @Override
    public Account getAccountInfo(String symbol) {
        final ApiResponse<Account> apiResponse = this.client.executeSync(this.api.getAccountInfo(symbol));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final Account account = JSON.parseObject(jsonObject.get("data").toString(), Account.class);
        return account;
    }

    @Override
    public List<TradePair> getTradePairList() {
        final ApiResponse<List<TradePair>> apiResponse = this.client.executeSync(this.api.getTradePairList());
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<TradePair> tradePairs = JSON.parseArray(jsonObject.get("data").toString(), TradePair.class);
        return tradePairs;
    }

    @Override
    public TradePair getTradePairInfo(String symbol) {
        final ApiResponse<TradePair> apiResponse = this.client.executeSync(this.api.getTradePairInfo(symbol));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final TradePair tradePair = JSON.parseObject(jsonObject.get("data").toString(), TradePair.class);
        return tradePair;
    }

    @Override
    public OrderBook orderBook(String symbol, String depth) {

        final ApiResponse<OrderBook> apiResponse = this.client.executeSync(this.api.orderBook(symbol, depth));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }

        final JSONObject jsonObject1 = JSON.parseObject(jsonObject.get("data").toString());
        if (null == jsonObject1) {
            return null;
        }
        final List<String[]> asks = JSON.parseArray(jsonObject1.get("asks").toString(),String[].class);
        final List<String[]> bids = JSON.parseArray(jsonObject1.get("bids").toString(),String[].class);
        final String timestamp = jsonObject1.get("timestamp").toString();

        final OrderBook orderBook = new OrderBook();
        orderBook.setAsks(asks);
        orderBook.setBids(bids);
        orderBook.setTimestamp(timestamp);
        return orderBook;
    }

    @Override
    public List<Ticker> getAllTickers() {
        final ApiResponse<List<Ticker>> apiResponse = this.client.executeSync(this.api.getAllTickers());
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<Ticker> tickers = JSON.parseArray(jsonObject.get("data").toString(), Ticker.class);
        return tickers;
    }

    @Override
    public Ticker getTickerInfo(String symbol) {
        final ApiResponse<Ticker> apiResponse = this.client.executeSync(this.api.getTickerInfo(symbol));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final Ticker ticker = JSON.parseObject(jsonObject.get("data").toString(), Ticker.class);
        return ticker;
    }

    @Override
    public List<String[]> getLastTrades(String symbol) {
        final ApiResponse<List<String[]>> apiResponse = this.client.executeSync(this.api.getLastTrades(symbol));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final List<String[]> trades = JSON.parseArray(jsonObject.get("data").toString(), String[].class);
        return trades;
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
    public List<Order> openOrders(@Query("symbol") final String symbol,
                                  @Query("latestOrderId") final String latestOrderId) {
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
    public List<Order> closedOrders(@Query("symbol") final String symbol,
                                    @Query("latestOrderId") final String latestOrderId) {

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
    public String withdraw(WithdrawParam param) {
        final ApiResponse<PlaceOrder> apiResponse = this.client.executeSync(this.api.withdraw(param));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);

        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        return jsonObject.get("data").toString();
    }


}
