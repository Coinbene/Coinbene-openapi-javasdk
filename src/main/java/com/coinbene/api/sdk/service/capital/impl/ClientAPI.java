package com.coinbene.api.sdk.service.capital.impl;

import com.coinbene.api.sdk.bean.capital.param.TransferParams;
import com.coinbene.api.sdk.bean.capital.param.WithdrawParams;
import com.coinbene.api.sdk.bean.contract.result.ApiResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ClientAPI {

    /**
     * 充值地址
     * @param asset
     * @return
     */
    @GET("/api/capital/v1/deposit/address/list")
    Call<ApiResponse> getDepositAddressList(@Query("asset") final String asset);

    /**
     * 提币申请
     * @param param
     * @return
     */
    @POST("/api/capital/v1/withdraw/apply")
    Call<ApiResponse> withdrawApply(@Body final WithdrawParams param);

    /**
     * 账户划转
     * @param param
     * @return
     */
    @POST("/api/capital/v1/asset/transfer")
    Call<ApiResponse> transfer(@Body final TransferParams param);


}
