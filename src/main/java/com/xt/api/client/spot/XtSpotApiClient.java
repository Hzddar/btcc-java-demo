package com.xt.api.client.spot;

import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.spot.order.*;
import com.xt.api.dto.nft.NftDepositRequest;
import com.xt.api.dto.nft.NftWithdrawRequest;
import com.xt.api.dto.spot.NetworthUpdateRequest;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import com.xt.api.dto.spot.SpotUpdateOrderRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Query;

import java.util.List;


/**
 * @author zhouzhuang
 * @create 2023/9/20 11:48
 */
public interface XtSpotApiClient {


    CommonResponse<OrderCreateRespDTO> postOrder(SpotPostOrderRequest request);

    CommonResponse<BatchOrderCreateRespDTO> batchOrderPost(BatchOrderCreateReq request);

    CommonResponse<OrderInfoDTO> getOrder(Long id);

    CommonResponse<OrderInfoDTO> queryOrder(Long orderId);

    CommonResponse<OrderCancelRespDTO> delOrder(Long id);

    CommonResponse updateOrder(Long id, SpotUpdateOrderRequest request);

    CommonResponse<List<OrderInfoDTO>> batchOrderGet(String orderIds);

    CommonResponse netWorth(NetworthUpdateRequest request);

    CommonResponse nftDeposit(NftDepositRequest request);

    CommonResponse nftWithdraw(NftWithdrawRequest request);

    CommonResponse nftHistoryOrder(Integer type, Integer status, String currency,
                                         Long startTime, Long endTime,
                                         Integer pageIndex, Integer pageSize);
}
