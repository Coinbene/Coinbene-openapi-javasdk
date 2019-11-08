package com.coinbene.api.sdk.service.usdt;

import com.coinbene.api.sdk.bean.ServerTime;
import com.coinbene.api.sdk.bean.contract.param.BatchCancelParam;
import com.coinbene.api.sdk.bean.contract.param.OrderInfoParam;
import com.coinbene.api.sdk.bean.contract.param.PlaceOrderParam;
import com.coinbene.api.sdk.bean.contract.result.*;
import retrofit2.http.Body;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public interface ClientAPIService {

    ServerTime getServerTime();

    Account getAccount();

    List<Contract> getContractList();

    List<Position> positions(@Query("symbol") final String symbol);

    List<CapitalFee> feeRate(@Query("symbol") final String symbol, @Query("pageNum") final String pageNum, @Query("pageSize") final String pageSize);

    OrderBook orderBook(@Query("symbol") final String symbol,
                        @Query("size") final String size);

    String fundingRate(@Query("symbol") final String symbol);

    List<String[]> klines(@Query("symbol") final String symbol,
                          @Query("resolution") final String resolution,
                          @Query("startTime") final String startTime,
                          @Query("endTime") final String endTime);

    Map<String, LastTicker> getLastTicker();

    List<String[]> getTrades(@Query("symbol") final String symbol,
                             @Query("limit") final String limit);

    List<Fills> getFills(@Query("symbol") final String symbol,
                         @Query("lastTradeId") final String tradeId,
                         @Query("orderId") final String orderId);

    PlaceOrder placeOrder(@Body final PlaceOrderParam param);

    CancelOrder cancelOrder(@Body final OrderInfoParam param);

    List<BatchCancelOrder> batchCancelOrders(@Body final BatchCancelParam param);

    List<Order> openOrders(@Query("symbol") final String symbol,
                           @Query("pageNum") final String pageNum,
                           @Query("pageSize") final String pageSize);

    Order getOrderInfo(@Query("orderId") final String orderId);

    List<Order> closedOrders(@Query("beginTime") final String beginTime,
                             @Query("endTime") final String endTime,
                             @Query("symbol") final String symbol,
                             @Query("pageNum") final String pageNum,
                             @Query("pageSize") final String pageSize);

    List<Order> openOrders(@Query("symbol") final String symbol,
                           @Query("latestOrderId") final String latestOrderId);


    List<Order> closedOrdersByPage(@Query("symbol") final String symbol,
                                   @Query("latestOrderId") final String latestOrderId,
                                   @Query("status") final String status,
                                   @Query("beginTime") final String beginTime,
                                   @Query("endTime") final String endTime);


}
