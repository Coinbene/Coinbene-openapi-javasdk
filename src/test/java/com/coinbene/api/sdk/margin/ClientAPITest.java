package com.coinbene.api.sdk.margin;

import com.coinbene.api.sdk.bean.ServerTime;
import com.coinbene.api.sdk.bean.exchange.param.*;
import com.coinbene.api.sdk.bean.exchange.result.*;
import com.coinbene.api.sdk.bean.margin.result.BorrowOrderDTO;
import com.coinbene.api.sdk.bean.margin.result.MarginTradePairVO;
import com.coinbene.api.sdk.service.margin.ClientAPIService;
import com.coinbene.api.sdk.service.margin.impl.ClientAPIServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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
        final List<MarginAccount> result = this.clientAPIService.getAccountList();
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getAccountInfo() {
        final MarginAccount result = this.clientAPIService.getAccountInfo("BTC/USDT");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getTradePairList() {
        final List<MarginTradePairVO> result = this.clientAPIService.getSymbolConfigList();
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getSymbolConfigInfo() {
        final MarginTradePairVO result = this.clientAPIService.getSymbolConfigrInfo("BTC/USDT");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }


    @Test
    public void getMaxBorrow() {
        final Map result = this.clientAPIService.maxBorrow("BTC/USDT", "BTC");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void borrow() {
        IntStream.range(1,20).forEach(i->{
            final BorrowOrderParam borrowOrderParam =  new BorrowOrderParam();
            borrowOrderParam.setAsset("BTC");
            borrowOrderParam.setSymbol("BTC/USDT");
            borrowOrderParam.setQuantity("0.01");
            final Boolean result = this.clientAPIService.borrow(borrowOrderParam);
            this.toResultString(ClientAPITest.LOG, "result ", result);
        });

    }

    @Test
    public void repayment() {
        final RepayOrderParam repayOrderParam = new RepayOrderParam();
        repayOrderParam.setAsset("BTC");
        repayOrderParam.setSymbol("BTC/USDT");
        repayOrderParam.setOrderId("");
        repayOrderParam.setQuantity("5");
        final Boolean result = this.clientAPIService.repayment(repayOrderParam);
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }


    @Test
    public void placeOrder() {
        final PlaceOrderParam param = new PlaceOrderParam();
        param.setAccountType("margin");
        param.setSymbol("BTC/USDT");
        param.setDirection("sell"); //1买，2卖
        final double price = 18526.000;
        param.setPrice(String.valueOf(price));
        param.setOrderType("limit");
        final String quantity = "0.01";
        param.setQuantity(quantity);
        param.setClientId(System.currentTimeMillis()+"");

        final PlaceOrder result = this.clientAPIService.placeOrder(param);
        this.toResultString(ClientAPITest.LOG, "result ", result);

    }

    @Test
    public void cancelOrder() {
        final OrderInfoParam param = new OrderInfoParam();
        param.setOrderId("1938306197706977280");
        final CancelOrder result = this.clientAPIService.cancelOrder(param);
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    @Ignore
    public void batchCancelOrders() {
        final BatchCancelParam param = new BatchCancelParam();
        final List<String> orderIds = new ArrayList<>();
        orderIds.add("1933916426062737408");
        orderIds.add("1933916426062737408");
        param.setOrderIds(orderIds);

        final List<BatchCancelOrder> result = this.clientAPIService.batchCancelOrders(param);
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void getOrderInfo() {
        final Order result = this.clientAPIService.getOrderInfo("1938306197706977280");
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
        final List<Fill> result = this.clientAPIService.getFills("1938306197706977280");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void unRepayList() {
        final List<BorrowOrderDTO> result = this.clientAPIService.unRepayList("BTC/USDT", "BTC", "10899");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }
    @Test
    public void finishRepayList() {
        final List<BorrowOrderDTO> result = this.clientAPIService.finishRepayList("BTC/USDT", "BTC", "");
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }


}
