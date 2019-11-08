package com.coinbene.api.sdk.service.exchange;

import com.coinbene.api.sdk.bean.ServerTime;
import com.coinbene.api.sdk.bean.exchange.param.BatchCancelParam;
import com.coinbene.api.sdk.bean.exchange.param.OrderInfoParam;
import com.coinbene.api.sdk.bean.exchange.param.PlaceOrderParam;
import com.coinbene.api.sdk.bean.exchange.param.WithdrawParam;
import com.coinbene.api.sdk.bean.exchange.result.*;
import retrofit2.http.Body;
import retrofit2.http.Query;

import java.util.List;

public interface ClientAPIService {

    ServerTime getServerTime();

    List<Account> getAccountList();

    Account getAccountInfo(@Query("asset") final String asset);

    List<TradePair> getTradePairList();

    TradePair getTradePairInfo(@Query("symbol") final String symbol);

    OrderBook orderBook(@Query("symbol") final String symbol,
            @Query("depth") final String depth);

    List<Ticker> getAllTickers();

    Ticker getTickerInfo(@Query("symbol") final String symbol);

    List<String[]> getLastTrades(@Query("symbol") final String symbol);

    PlaceOrder placeOrder(@Body final PlaceOrderParam param);

    CancelOrder cancelOrder(@Body final OrderInfoParam param);

    List<BatchCancelOrder> batchCancelOrders(@Body final BatchCancelParam param);

    Order getOrderInfo(@Query("orderId") final String orderId);

    List<Order> openOrders(@Query("symbol") final String symbol,
                           @Query("latestOrderId") final String latestOrderId);

    List<Order> closedOrders(@Query("symbol") final String symbol,
                             @Query("latestOrderId") final String latestOrderId);

    List<Fill> getFills(@Query("orderId") final String orderId);

    String withdraw(@Body final WithdrawParam param);

}
