package com.xt.api.client.spot;

import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.nft.NftDepositRequest;
import com.xt.api.dto.nft.NftWithdrawRequest;
import com.xt.api.dto.spot.NetworthUpdateRequest;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import com.xt.api.dto.spot.SpotUpdateOrderRequest;
import com.xt.api.dto.spot.order.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * @author zhouzhuang
 * @create 2023/9/20 14:28
 */
public interface XtSpotApiService {

    @POST("/v4/order")
    Call<CommonResponse<OrderCreateRespDTO>> postOrder(@Body SpotPostOrderRequest request);

    @POST("/v4/batch-order")
    Call<CommonResponse<BatchOrderCreateRespDTO>> batchOrderPost(@Body BatchOrderCreateReq request);

    @GET("/v4/order/{id}")
    Call<CommonResponse<OrderInfoDTO>> getOrder(@Path("id")Long id);

    @GET("/v4/order")
    Call<CommonResponse<OrderInfoDTO>> queryOrder(@Query("orderId") Long orderId);

    @GET("/v4/batch-order")
    Call<CommonResponse<List<OrderInfoDTO>>> batchOrderGet(@Query("orderIds") String orderIds);

    @DELETE("/v4/order/{id}")
    Call<CommonResponse<OrderCancelRespDTO>> delOrder(@Path("id")Long id);

    @PUT("/v4/order/{id}")
    Call<CommonResponse<Object>> updateOrder(@Path("id")Long id, @Body SpotUpdateOrderRequest request);

    @PUT("/v4/etf/net-worth")
    Call<CommonResponse<Object>> netWorth(@Body NetworthUpdateRequest request);

    @POST("/v4/nft/deposit")
    Call<CommonResponse<Object>> nftDeposit(@Body NftDepositRequest request);

    @POST("/v4/nft/withdraw")
    Call<CommonResponse<Object>> nftWithdraw(@Body NftWithdrawRequest request);

    @GET("/v4/nft/order/history")
    Call<CommonResponse<Object>> nftHistoryOrder(@Query("type") Integer type,
                                         @Query("status") Integer status, @Query("currencyId") String currency,
                                         @Query("startTime") Long startTime, @Query("endTime") Long endTime,
                                         @Query("page") Integer page, @Query("size") Integer size);
}
