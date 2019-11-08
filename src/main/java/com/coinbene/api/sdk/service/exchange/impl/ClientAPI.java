package com.coinbene.api.sdk.service.exchange.impl;

import com.coinbene.api.sdk.bean.ServerTime;
import com.coinbene.api.sdk.bean.exchange.param.BatchCancelParam;
import com.coinbene.api.sdk.bean.exchange.param.OrderInfoParam;
import com.coinbene.api.sdk.bean.exchange.param.PlaceOrderParam;
import com.coinbene.api.sdk.bean.exchange.param.WithdrawParam;
import com.coinbene.api.sdk.bean.exchange.result.ApiResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ClientAPI {

    @GET("/api/exchange/v2/time")
    Call<ServerTime> getServerTime();

    /**
     * 获取账户列表
     * @return
     */
    @GET("/api/exchange/v2/account/list")
    Call<ApiResponse> getAccountList();

    /**
     * 获取指定账户
     * @return
     */
    @GET("/api/exchange/v2/account/one")
    Call<ApiResponse> getAccountInfo(@Query("asset") final String asset);

    /**
     * 获取交易对列表
     * @return
     */
    @GET("/api/exchange/v2/market/tradePair/list")
    Call<ApiResponse> getTradePairList();

    /**
     * 获取交易对信息
     * @return
     */
    @GET("/api/exchange/v2/market/tradePair/one")
    Call<ApiResponse> getTradePairInfo(@Query("symbol") final String symbol);

    /**
     * 获取Ticker列表
     * @return
     */
    @GET("/api/exchange/v2/market/ticker/list")
    Call<ApiResponse> getAllTickers();

    /**
     * 深度
     * @param symbol
     * @return
     */
    @GET("/api/exchange/v2/market/orderBook")
    Call<ApiResponse> orderBook(@Query("symbol") final String symbol,
            @Query("depth") final String depth);

    /**
     * 获取指定Ticker信息
     * @return
     */
    @GET("/api/exchange/v2/market/ticker/one")
    Call<ApiResponse> getTickerInfo(@Query("symbol") final String symbol);

    /**
     * 获取最新成交记录
     * @return
     */
    @GET("/api/exchange/v2/market/trades")
    Call<ApiResponse> getLastTrades(@Query("symbol") final String symbol);

    /**
     * 下单
     * @param param
     * @return
     */
    @POST("/api/exchange/v2/order/place")
    Call<ApiResponse> placeOrder(@Body final PlaceOrderParam param);

    /**
     * 指定撤单
     * @param param
     * @return
     */
    @POST("/api/exchange/v2/order/cancel")
    Call<ApiResponse> cancelOrder(@Body final OrderInfoParam param);

    /**
     * 批量撤单
     * @param param
     * @return
     */
    @POST("/api/exchange/v2/order/batchCancel")
    Call<ApiResponse> batchCancelOrders(@Body final BatchCancelParam param);

    /**
     * 查询单个订单
     * @param orderId
     * @return
     */
    @GET("/api/exchange/v2/order/info")
    Call<ApiResponse> getOrderInfo(@Query("orderId") final String orderId);


    /**
     * 查询当前订单列表
     * @param symbol
     * @return
     */
    @GET("/api/exchange/v2/order/openOrders")
    Call<ApiResponse> openOrders(@Query("symbol") final String symbol,
                                 @Query("latestOrderId") final String latestOrderId);

    /**
     * 查询历史订单
     * @return
     */
    @GET("/api/exchange/v2/order/closedOrders")
    Call<ApiResponse> closedOrders(@Query("symbol") final String symbol,
                                   @Query("latestOrderId") final String latestOrderId);

    /**
     * 获取订单成交明细
     * @param orderId
     * @return
     */
    @GET("/api/exchange/v2/order/trade/fills")
    Call<ApiResponse> getFills(@Query("orderId") final String orderId);

    /**
     *
     * @param param
     * @return
     */
    @POST("/api/exchange/v2/withdraw/apply")
    Call<ApiResponse> withdraw(@Body final WithdrawParam param);
}
