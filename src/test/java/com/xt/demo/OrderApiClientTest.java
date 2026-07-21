package com.xt.demo;

import com.alibaba.fastjson.JSON;
import com.xt.api.client.spot.XtSpotApiClient;
import com.xt.api.client.spot.XtSpotApiClientImpl;
import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.nft.NftDepositRequest;
import com.xt.api.dto.nft.NftWithdrawRequest;
import com.xt.api.dto.spot.NetworthUpdateRequest;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import com.xt.api.dto.spot.SpotUpdateOrderRequest;
import com.xt.api.dto.spot.order.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * SPOT Business
 *
 * @author zhouzhuang
 * @create 2023/9/20 16:15
 */
public class OrderApiClientTest {

    XtSpotApiClient xtSpotApiClient = new XtSpotApiClientImpl(null);

    /**
     * 单笔获取 / query single order
     */
    @Test
    public void queryOrder() {
        CommonResponse<OrderInfoDTO> commonResponse = xtSpotApiClient.queryOrder(649847186756400832L);
        System.out.println("result:" + commonResponse);
        System.out.println(System.lineSeparator() + JSON.toJSONString(commonResponse.getResult(), true));
    }


    /**
     * 单笔获取 / query single order
     */
    @Test
    public void getOrder() {
        CommonResponse<OrderInfoDTO> commonResponse = xtSpotApiClient.getOrder(649847186756400832L);
        System.out.println("result:" + commonResponse);
        System.out.println(System.lineSeparator() + JSON.toJSONString(commonResponse.getResult(), true));
    }


    /**
     * post single order
     */
    @Test
    public void orderPost() {
        SpotPostOrderRequest request = SpotPostOrderRequest.builder().symbol("btc_usdt")
                .side("BUY")
                .type("LIMIT")
                .timeInForce("GTC")
                .bizType("SPOT")
                .price(BigDecimal.valueOf(63000L))
                .quantity(BigDecimal.valueOf(0.001))
                .media("btok")
                .mediaChannel("btok123")
                .build();
        CommonResponse<OrderCreateRespDTO> commonResponse = xtSpotApiClient.postOrder(request);
        System.out.println("result:" + commonResponse);
        System.out.println(System.lineSeparator() + JSON.toJSONString(commonResponse.getResult(), true));
    }


    /**
     * 删除单笔订单 / delete single order
     */
    @Test
    public void delOrder() {
        CommonResponse<OrderCancelRespDTO> commonResponse = xtSpotApiClient.delOrder(650169915598632640L);
        System.out.println("result:" + commonResponse);
        System.out.println(System.lineSeparator() + JSON.toJSONString(commonResponse.getResult(), true));
    }


    /**
     * 批量获取订单 / batch query order
     */
    @Test
    public void batchOrderGet() {
        CommonResponse<List<OrderInfoDTO>> commonResponse = xtSpotApiClient.batchOrderGet("649847186756400832");
        System.out.println("result:" + commonResponse);
        System.out.println(System.lineSeparator() + JSON.toJSONString(commonResponse.getResult(), true));
    }

    /**
     * batch post order
     */
    @Test
    public void batchOrderPost() {
        OrderCreateReq orderCreateReq = OrderCreateReq.builder().symbol("btc_usdt")
                .side(OrderSide.BUY)
                .type(OrderType.LIMIT)
                .timeInForce(TimeInForce.GTC)
                .bizType("SPOT")
                .price(BigDecimal.valueOf(63000L))
                .quantity(BigDecimal.valueOf(0.001))
                .media("btok")
                .mediaChannel("btok123")
                .build();
        BatchOrderCreateReq batchOrderCreateReq = new BatchOrderCreateReq("111111111aa", List.of(orderCreateReq));
        CommonResponse<BatchOrderCreateRespDTO> commonResponse = xtSpotApiClient.batchOrderPost(batchOrderCreateReq);
        System.out.println("result:" + commonResponse);
        System.out.println(System.lineSeparator() + JSON.toJSONString(commonResponse.getResult(), true));
    }


    @Test
    public void netWorth() {
        NetworthUpdateRequest request = NetworthUpdateRequest.builder().symbol("btc3l_usdt").netWorth(BigDecimal.valueOf(1.2)).build();
        CommonResponse commonResponse = xtSpotApiClient.netWorth(request);
        System.out.println("result:" + commonResponse);
    }

    @Test
    public void updateOrder() {
        CommonResponse commonResponse = xtSpotApiClient.updateOrder(407309222976613568L, SpotUpdateOrderRequest.builder().quantity("0.002").price("63010").build());
        System.out.println("result:" + commonResponse);
    }

    @Test
    public void nftDeposit() {
        NftDepositRequest nftDepositRequest = NftDepositRequest.builder()
                .currency("BTCsn")
                .serial("123")
                .passcode("123")
                .build();
        CommonResponse commonResponse = xtSpotApiClient.nftDeposit(nftDepositRequest);
        System.out.println("result:" + commonResponse);
    }

    @Test
    public void nftWithdraw() {
        NftWithdrawRequest nftWithdrawRequest = NftWithdrawRequest.builder()
                .currency("BTCsn")
                .serial("123")
                .build();
        CommonResponse commonResponse = xtSpotApiClient.nftWithdraw(nftWithdrawRequest);
        System.out.println("result:" + commonResponse);
    }

    @Test
    public void nftHistoryOrder() {
        CommonResponse commonResponse = xtSpotApiClient.nftHistoryOrder(2, null, null, null, null, 1, 10);
        System.out.println("result:" + commonResponse);
    }
}
