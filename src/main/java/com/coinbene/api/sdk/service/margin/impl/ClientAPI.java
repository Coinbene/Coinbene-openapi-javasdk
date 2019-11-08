package com.coinbene.api.sdk.service.margin.impl;

import com.coinbene.api.sdk.bean.ServerTime;
import com.coinbene.api.sdk.bean.exchange.param.*;
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
    @GET("/api/margin/v1/account/list")
    Call<ApiResponse> getAccountList();

    /**
     * 获取指定账户
     * @return
     */
    @GET("/api/margin/v1/account/one")
    Call<ApiResponse> getAccountInfo(@Query("symbol") final String symbol);

    /**
     * 获取交易对列表
     * @return
     */
    @GET("/api/margin/v1/tradePair/list")
    Call<ApiResponse> getTradePairList();

    /**
     * 获取交易对信息
     * @return
     */
    @GET("/api/margin/v1/tradePair/one")
    Call<ApiResponse> getTradePairInfo(@Query("symbol") final String symbol);



    @GET("/api/margin/v1/account/max-borrow")
    Call<ApiResponse> maxBorrow(
            @Query("symbol") final String symbol,
            @Query("asset") final String asset
    );

    @POST("/api/margin/v1/account/borrow")
    Call<ApiResponse> borrow(@Body BorrowOrderParam borrowOrderParam);

    @POST("/api/margin/v1/account/repayment")
    Call<ApiResponse> repayment(@Body RepayOrderParam repayOrderParam);



    /**
     * 下单
     * @param param
     * @return
     */
    @POST("/api/margin/v1/order/place")
    Call<ApiResponse> placeOrder(@Body final PlaceOrderParam param);

    /**
     * 指定撤单
     * @param param
     * @return
     */
    @POST("/api/margin/v1/order/cancel")
    Call<ApiResponse> cancelOrder(@Body final OrderInfoParam param);

    /**
     * 批量撤单
     * @param param
     * @return
     */
    @POST("/api/margin/v1/order/batchCancel")
    Call<ApiResponse> batchCancelOrders(@Body final BatchCancelParam param);

    /**
     * 查询单个订单
     * @param orderId
     * @return
     */
    @GET("/api/margin/v1/order/info")
    Call<ApiResponse> getOrderInfo(@Query("orderId") final String orderId);


    /**
     * 查询当前订单列表
     * @param symbol
     * @return
     */
    @GET("/api/margin/v1/order/openOrders")
    Call<ApiResponse> openOrders(@Query("symbol") final String symbol,
                                 @Query("latestOrderId") final String latestOrderId);

    /**
     * 查询历史订单
     * @return
     */
    @GET("/api/margin/v1/order/closedOrders")
    Call<ApiResponse> closedOrders(@Query("symbol") final String symbol,
                                   @Query("latestOrderId") final String latestOrderId);

    /**
     * 获取订单成交明细
     * @param orderId
     * @return
     */
    @GET("/api/margin/v1/order/trade/fills")
    Call<ApiResponse> getFills(@Query("orderId") final String orderId);

    /**
     *
     * @param symbol
     * @param asset
     * @param latestOrderId
     * @return
     */
    @GET("/api/margin/v1/account/unRepayOrderList")
    Call<ApiResponse> unRepayOrderList(@Query("symbol") final String symbol,
                                       @Query("asset") final String asset,
                                       @Query("latestBorrowId") final String latestOrderId);
    /**
     *
     * @param symbol
     * @param asset
     * @param latestOrderId
     * @return
     */
    @GET("/api/margin/v1/account/finishRepayOrderList")
    Call<ApiResponse> finishRepayOrderList(@Query("symbol") final String symbol,
                               @Query("asset") final String asset,
                               @Query("latestBorrowId") final String latestOrderId);
}
