package com.coinbene.api.sdk.service.usdt.impl;

import com.coinbene.api.sdk.bean.ServerTime;
import com.coinbene.api.sdk.bean.contract.param.BatchCancelParam;
import com.coinbene.api.sdk.bean.contract.param.OrderInfoParam;
import com.coinbene.api.sdk.bean.contract.param.PlaceOrderParam;
import com.coinbene.api.sdk.bean.contract.result.ApiResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ClientAPI {

    @GET("/api/usdt/v2/time")
    Call<ServerTime> getServerTime();

    /**
     * 获取合约账户
     * @return
     */
    @GET("/api/usdt/v2/account/info")
    Call<ApiResponse> getAccount();

    /**
     * 获取合约名称
     * @return
     */
    @GET("/api/usdt/v2/account/contract/list")
    Call<ApiResponse> contractList();

    /**
     * 获取合约持仓信息
     * @return
     */
    @GET("/api/usdt/v2/position/list")
    Call<ApiResponse> positions(@Query("symbol") final String symbol);

    /**
     * 获取合约仓位资金费率
     * @return
     */
    @GET("/api/usdt/v2/position/feeRate")
    Call<ApiResponse> feeRate(@Query("symbol") final String symbol, @Query("pageNum") final String pageNum, @Query("pageSize") final String pageSize);

    /**
     * 深度
     * @param symbol
     * @return
     */
    @GET("/api/usdt/v2/market/orderBook")
    Call<ApiResponse> orderBook(@Query("symbol") final String symbol,
                                @Query("size") final String size);

    @GET("/api/usdt/v2/market/fundingRate")
    Call<ApiResponse> fundingRate(@Query("symbol") final String symbol);

    /**
     * kline
     * @param symbol
     * @return
     */
    @GET("/api/usdt/v2/market/klines")
    Call<ApiResponse> klines(@Query("symbol") final String symbol,
                             @Query("resolution") final String resolution,
                             @Query("startTime") final String startTime,
                             @Query("endTime") final String endTime);

    /**
     * lastticker
     * @return
     */
    @GET("/api/usdt/v2/market/tickers")
    Call<ApiResponse> getLastTicker();

    /**
     * 最新成交
     * @param symbol
     * @return
     */
    @GET("/api/usdt/v2/market/trades")
    Call<ApiResponse> getTrades(@Query("symbol") final String symbol,
                                @Query("limit") final String limit);

    /**
     * 获取订单成交明细
     * @param symbol
     * @param orderId
     * @return
     */
    @GET("/api/usdt/v2/order/fills")
    Call<ApiResponse> getFills(@Query("symbol") final String symbol,
                               @Query("lastTradeId") final String tradeId,
                               @Query("orderId") final String orderId);

    /**
     * 下单
     * @param param
     * @return
     */
    @POST("/api/usdt/v2/order/place")
    Call<ApiResponse> placeOrder(@Body final PlaceOrderParam param);

    /**
     * 撤单
     * @param param
     * @return
     */
    @POST("/api/usdt/v2/order/cancel")
    Call<ApiResponse> cancelOrder(@Body final OrderInfoParam param);

    /**
     * 批量撤单
     * @param param
     * @return
     */
    @POST("/api/usdt/v2/order/batchCancel")
    Call<ApiResponse> batchCancelOrders(@Body final BatchCancelParam param);

    /**
     * 查询订单
     * @param symbol
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GET("/api/usdt/v2/order/openOrders")
    Call<ApiResponse> openOrders(@Query("symbol") final String symbol,
                                 @Query("pageNum") final String pageNum,
                                 @Query("pageSize") final String pageSize);

    /**
     * 查询单个订单
     * @param orderId
     * @return
     */
    @GET("/api/usdt/v2/order/info")
    Call<ApiResponse> getOrderInfo(@Query("orderId") final String orderId);


    /**
     * 查询历史订单
     * @param symbol
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GET("/api/usdt/v2/order/closedOrders")
    Call<ApiResponse> closedOrders(@Query("beginTime") final String beginTime,
                                   @Query("endTime") final String endTime,
                                   @Query("symbol") final String symbol,
                                   @Query("pageNum") final String pageNum,
                                   @Query("pageSize") final String pageSize);


    @GET("/api/usdt/v2/order/openOrdersByPage")
    Call<ApiResponse> openOrders(@Query("symbol") final String symbol,
                                 @Query("latestOrderId") final String latestOrderId);


    @GET("/api/usdt/v2/order/closedOrdersByPage")
    Call<ApiResponse> closedOrdersByPage(@Query("symbol") final String symbol,
                                         @Query("latestOrderId") final String latestOrderId,
                                         @Query("status") final String status,
                                         @Query("beginTime") final String beginTime,
                                         @Query("endTime") final String endTime);



}
