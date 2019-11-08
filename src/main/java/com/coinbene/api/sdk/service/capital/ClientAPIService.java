package com.coinbene.api.sdk.service.capital;

import com.coinbene.api.sdk.bean.capital.param.TransferParams;
import com.coinbene.api.sdk.bean.capital.param.WithdrawParams;
import com.coinbene.api.sdk.bean.capital.result.DepositAddressVo;
import com.coinbene.api.sdk.bean.capital.result.TransferVo;
import com.coinbene.api.sdk.bean.capital.result.WithdrawVo;
import retrofit2.http.Body;
import retrofit2.http.Query;

import java.util.List;

public interface ClientAPIService {

    WithdrawVo withdrawApply(@Body final WithdrawParams param);

    List<DepositAddressVo> getDepositAddressList(@Query("asset") final String asset);

    TransferVo transfer(@Body final TransferParams param);
}
