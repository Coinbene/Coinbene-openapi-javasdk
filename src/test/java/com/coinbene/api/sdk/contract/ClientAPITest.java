package com.coinbene.api.sdk.contract;

import com.coinbene.api.sdk.bean.ServerTime;
import com.coinbene.api.sdk.bean.contract.param.BatchCancelParam;
import com.coinbene.api.sdk.bean.contract.param.OrderInfoParam;
import com.coinbene.api.sdk.bean.contract.param.PlaceOrderParam;
import com.coinbene.api.sdk.bean.contract.result.*;
import com.coinbene.api.sdk.service.contract.ClientAPIService;
import com.coinbene.api.sdk.service.contract.impl.ClientAPIServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientAPITest extends APIBaseTests {

    private static final Logger LOG = LoggerFactory.getLogger(ClientAPITest.class);

    private ClientAPIService clientAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.clientAPIService = new ClientAPIServiceImpl(this.config);
    }

    @Test
    public void getServerTime() {
        IntStream.range(1,20).forEach(i ->{
            final ServerTime result = this.clientAPIService.getServerTime();
            this.toResultString(ClientAPITest.LOG, "result " + i, result);
        });
    }

    @Test
    public void getAccount() {
        IntStream.range(1,2).forEach(i -> {
            final Account result = this.clientAPIService.getAccount();
            this.toResultString(ClientAPITest.LOG, "result " + i, result);
        });
    }

    @Test
    public void getContractList() {
        IntStream.range(1,2).forEach(i -> {
            final List<Contract> result = this.clientAPIService.getContractList();
            this.toResultString(ClientAPITest.LOG, "result " + i, result);
        });
    }

    @Test
    public void getPositionList() {
        IntStream.range(1,20).forEach(i ->{
            final List<Position> result = this.clientAPIService.positions(null);
            this.toResultString(ClientAPITest.LOG, "result " + i, result);
        });
    }

    @Test
    public void getFeeRateList() {
        IntStream.range(1, 2000).forEach(i ->{
            final List<CapitalFee> result = this.clientAPIService.feeRate(null, null, "5");
            this.toResultString(ClientAPITest.LOG, "result " + i, result);
        });
    }

    @Test
    public void orderBook() {
        IntStream.range(1,2).forEach(i->{
            final OrderBook result = this.clientAPIService.orderBook("BTCUSDT", "5");
            this.toResultString(ClientAPITest.LOG, "result "+i, result);
        });
    }

    @Test
    public void fundingRate() {
        IntStream.range(1,20).forEach(i->{
            final String result = this.clientAPIService.fundingRate("BTCUSDT");
            this.toResultString(ClientAPITest.LOG, "result ", result);
        });
    }

    @Test
    public void klines() {
        IntStream.range(0,2).parallel().forEach(i->{
            final List<String[]> result = this.clientAPIService.klines("BTCUSDT","1", "", "");
            this.toResultString(ClientAPITest.LOG, "result: " + i, result);
        });
    }

    @Test
    public void getLastTicker() {
        final Map<String, LastTicker> result = this.clientAPIService.getLastTicker();
        this.toResultString(ClientAPITest.LOG, "result ", result);
//        final LastTicker lastTicker = result.get("EOSUSDT");
//        this.toResultString(ClientAPITest.LOG, "result ", lastTicker);
    }

    @Test
    public void getTrades() {
        final List<String[]> result = this.clientAPIService.getTrades("LTCUSDT", "10");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getFills() {
        final List<Fills> result = this.clientAPIService.getFills("ETHUSDT", "0","587283145557233664");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void placeOrder() {
        IntStream.range(1,2).forEach(i->{
            final PlaceOrderParam param = new PlaceOrderParam();
            param.setSymbol("BTCUSDT");
            param.setDirection("openLong");
            param.setOrderType("limit");
            param.setLeverage("2");
            final double price = 143 + ((int)(Math.random()*100))*0.05;
            param.setOrderPrice(String.valueOf(price));
            final Integer quantity = (int) (Math.random() * 10);
            param.setQuantity(quantity.toString());
            param.setClientId(System.currentTimeMillis()+"");
            param.setMarginMode("fixed");

            final PlaceOrder result = this.clientAPIService.placeOrder(param);
            this.toResultString(ClientAPITest.LOG, "result ", result);
        });
    }

    @Test
    public void cancelOrder() {
        final OrderInfoParam param = new OrderInfoParam();
        param.setOrderId("591283261780099072");
        final CancelOrder result = this.clientAPIService.cancelOrder(param);
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void batchCancelOrders() {
        final BatchCancelParam param = new BatchCancelParam();
        final List<String> orderIds = new ArrayList<>();
        orderIds.add("591283261780099072");
        orderIds.add("578639902896914432");
        param.setOrderIds(orderIds);

        final List<BatchCancelOrder> result = this.clientAPIService.batchCancelOrders(param);
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void openOrders() {
        final List<Order> result = this.clientAPIService.openOrders(null, "1", "50");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getOrderInfo() {
        final Order result = this.clientAPIService.getOrderInfo("580721369818955776");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void closedOrders() {
        final List<Order> result = this.clientAPIService.closedOrders(null, null, "ETHUSDT", "2", "1");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void openOrdersByPage() {
        final List<Order> result = this.clientAPIService.openOrders(null, null);
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void closedOrdersByPage() {
        final long beginTime = System.currentTimeMillis() - 10 * 24 * 60 * 60 * 1000;
        final List<Order> result = this.clientAPIService.closedOrdersByPage("EOSUSDT", null, "canceled",null, null);
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

}
