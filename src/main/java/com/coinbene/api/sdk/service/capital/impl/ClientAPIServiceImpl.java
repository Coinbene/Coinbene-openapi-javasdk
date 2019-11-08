package com.coinbene.api.sdk.service.capital.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coinbene.api.sdk.bean.capital.param.TransferParams;
import com.coinbene.api.sdk.bean.capital.param.WithdrawParams;
import com.coinbene.api.sdk.bean.capital.result.DepositAddressVo;
import com.coinbene.api.sdk.bean.capital.result.TransferVo;
import com.coinbene.api.sdk.bean.capital.result.WithdrawVo;
import com.coinbene.api.sdk.bean.contract.result.ApiResponse;
import com.coinbene.api.sdk.bean.contract.result.PlaceOrder;
import com.coinbene.api.sdk.client.APIClient;
import com.coinbene.api.sdk.config.APIConfiguration;
import com.coinbene.api.sdk.service.capital.ClientAPIService;

import java.util.List;

public class ClientAPIServiceImpl implements ClientAPIService {

    private final APIClient client;
    private final ClientAPI api;

    public ClientAPIServiceImpl(final APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = this.client.createService(ClientAPI.class);
    }

    @Override
    public List<DepositAddressVo> getDepositAddressList(final String asset) {
        final ApiResponse<PlaceOrder> apiResponse = this.client.executeSync(this.api.getDepositAddressList(asset));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }

        final List<DepositAddressVo> list = JSON.parseArray(jsonObject.get("data").toString(), DepositAddressVo.class);
        return list;
    }

    @Override
    public TransferVo transfer(TransferParams param) {
        final ApiResponse<TransferVo> apiResponse = this.client.executeSync(this.api.transfer(param));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);

        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final TransferVo result = JSON.parseObject(jsonObject.get("data").toString(), TransferVo.class);
        return result;
    }

    @Override
    public WithdrawVo withdrawApply(final WithdrawParams param) {
        final ApiResponse<String> apiResponse = this.client.executeSync(this.api.withdrawApply(param));
        final String jsonStr = JSON.toJSONString(apiResponse);
        final JSONObject jsonObject = JSON.parseObject(jsonStr);

        if ((Integer) jsonObject.get("code") != 200) {
            return null;
        }
        final WithdrawVo result = JSON.parseObject(jsonObject.get("data").toString(), WithdrawVo.class);
        return result;
    }
}
