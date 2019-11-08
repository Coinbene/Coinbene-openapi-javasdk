package com.coinbene.api.sdk.service.margin;

import com.coinbene.api.sdk.bean.ServerTime;
import com.coinbene.api.sdk.bean.exchange.param.*;
import com.coinbene.api.sdk.bean.exchange.result.*;
import com.coinbene.api.sdk.bean.margin.result.BorrowDTO;
import com.coinbene.api.sdk.bean.margin.result.BorrowOrderDTO;
import com.coinbene.api.sdk.bean.margin.result.MarginTradePairVO;
import retrofit2.http.Body;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public interface ClientAPIService {

    ServerTime getServerTime();

    List<MarginAccount> getAccountList();

    MarginAccount getAccountInfo(@Query("symbol") final String symbol);

    List<MarginTradePairVO> getSymbolConfigList();

    MarginTradePairVO getSymbolConfigrInfo(@Query("symbol") final String symbol);

    PlaceOrder placeOrder(@Body final PlaceOrderParam param);

    CancelOrder cancelOrder(@Body final OrderInfoParam param);

    List<BatchCancelOrder> batchCancelOrders(@Body final BatchCancelParam param);

    Order getOrderInfo(@Query("orderId") final String orderId);

    List<Order> openOrders(@Query("symbol") final String symbol,
                           @Query("latestOrderId") final String latestOrderId);

    List<Order> closedOrders(@Query("symbol") final String symbol,
                             @Query("latestOrderId") final String latestOrderId);

    List<Fill> getFills(@Query("orderId") final String orderId);

    Map maxBorrow(@Query("symbol") final String symbol,
                  @Query("asset") final String asset);

    Boolean borrow(@Body final BorrowOrderParam borrowOrderParam);

    Boolean repayment(@Body final RepayOrderParam repayOrderParam);

    List<BorrowOrderDTO> unRepayList(@Query("symbol") final String symbol,
                                     @Query("asset") final String asset,
                                     @Query("lastBorrowId") final String lastBorrowId);

    List<BorrowOrderDTO> finishRepayList(@Query("symbol") final String symbol,
                                         @Query("asset") final String asset,
                                         @Query("lastBorrowId") final String lastBorrowId);
}
