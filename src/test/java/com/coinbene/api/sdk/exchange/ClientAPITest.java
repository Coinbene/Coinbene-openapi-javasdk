package com.coinbene.api.sdk.exchange;

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
import com.coinbene.api.sdk.service.exchange.ClientAPIService;
import com.coinbene.api.sdk.service.exchange.impl.ClientAPIServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientAPITest extends APIBaseTests {

    private static final Logger LOG = LoggerFactory.getLogger(
            ClientAPITest.class);

    private ClientAPIService clientAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.clientAPIService = new ClientAPIServiceImpl(this.config);
    }

    @Test
    public void getServerTime() {
        final ServerTime result = this.clientAPIService.getServerTime();
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getAccountList() {
        final List<Account> result = this.clientAPIService.getAccountList();
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getAccountInfo() {
        final Account result = this.clientAPIService.getAccountInfo("BTC");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void orderBook() {
        IntStream.range(1,2).forEach(i->{
            final OrderBook result = this.clientAPIService.orderBook("BTC/USDT", "5");
            this.toResultString(ClientAPITest.LOG, "result ", result);
        });

    }

    @Test
    public void getTradePairList() {
        final List<TradePair> result = this.clientAPIService.getTradePairList();
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getTradePairInfo() {
        final TradePair result = this.clientAPIService.getTradePairInfo("BTC/USDT");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
//    @Ignore
    public void getAllTickers() {

        final List<Ticker> result = this.clientAPIService.getAllTickers();
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getTickerInfo() {
        final Ticker result = this.clientAPIService.getTickerInfo("BTC/USDT");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getLatest50Trades() {
        final List<String[]> result = this.clientAPIService.getLastTrades("BTC/USDT");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void placeOrder() {
        final PlaceOrderParam param = new PlaceOrderParam();
        param.setSymbol("BTC/USDT");
        param.setDirection("2"); //1买，2卖
        final double price = 7994.13;
        param.setPrice(String.valueOf(price));
        final Integer quantity = 14;
        param.setQuantity(quantity.toString());
//        param.setClientId(System.currentTimeMillis()+"");

        final PlaceOrder result = this.clientAPIService.placeOrder(param);
        this.toResultString(ClientAPITest.LOG, "result ", result);

    }

    @Test
    public void cancelOrder() {
        IntStream.range(1,10).forEach(i -> {
            final OrderInfoParam param = new OrderInfoParam();
            param.setOrderId("1924511943331438592");
            final CancelOrder result = this.clientAPIService.cancelOrder(param);
            this.toResultString(ClientAPITest.LOG, "result ", result);
        });
    }

    @Test
    public void batchCancelOrders() {
        final BatchCancelParam param = new BatchCancelParam();
        final List<String> orderIds = new ArrayList<>();
        orderIds.add("1924511943331438592");
        orderIds.add("1924511943331438592");
        param.setOrderIds(orderIds);

        final List<BatchCancelOrder> result = this.clientAPIService.batchCancelOrders(param);
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getOrderInfo() {
        final Order result = this.clientAPIService.getOrderInfo("1964783171455365120");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void openOrders() {
        final List<Order> result = this.clientAPIService.openOrders("BTC/USDT", "");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void closedOrders() {
        final List<Order> result = this.clientAPIService.closedOrders(null, null);
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getFills() {
        final List<Fill> result = this.clientAPIService.getFills("1946304504492400640");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }


    @Test
    public void coinWithdraw() {
        final WithdrawParam param = new WithdrawParam();
        param.setAsset("USDT");
        param.setAmount("2");
        param.setAddress("");
        param.setChain("");
        param.setTag("");

        final String result = this.clientAPIService.withdraw(param);
        this.toResultString(ClientAPITest.LOG, "result ", result);

    }

}
