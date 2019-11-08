package com.coinbene.api.sdk.capital;

import com.coinbene.api.sdk.bean.capital.param.TransferParams;
import com.coinbene.api.sdk.bean.capital.param.WithdrawParams;
import com.coinbene.api.sdk.bean.capital.result.DepositAddressVo;
import com.coinbene.api.sdk.bean.capital.result.TransferVo;
import com.coinbene.api.sdk.bean.capital.result.WithdrawVo;
import com.coinbene.api.sdk.service.capital.ClientAPIService;
import com.coinbene.api.sdk.service.capital.impl.ClientAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
    public void getDepositAddressList() {
        final String asset = null;
        final List<DepositAddressVo> result = this.clientAPIService.getDepositAddressList(asset);
        this.toResultString(ClientAPITest.LOG, "result ", result);
    }

    @Test
    public void withdrawApply() {
        final WithdrawParams param = new WithdrawParams();
        param.setAddress("rHyS9xSwQUBqm5KjwprUXDWxZcwEMZYQMJ");
        param.setAmount("1");
        param.setAsset("BTC");
        param.setChain("");
        param.setTag("10000737");

        final WithdrawVo result = this.clientAPIService.withdrawApply(param);
        this.toResultString(ClientAPITest.LOG, "result ", result);

    }

    @Test
    public void transfer() {
        final TransferParams param = new TransferParams();
        param.setAmount("1");
        param.setAsset("BTC");
        param.setFrom("spot");
        param.setTo("margin");
        param.setFromInstrumentId("");
        param.setToInstrumentId("BTC/USDT");

        final TransferVo result = this.clientAPIService.transfer(param);
        this.toResultString(ClientAPITest.LOG, "result ", result);

    }

}
