package com.xt.api.dto.spot.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author evan
 * 订单创建请求报文/Order creation request
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderCreateReq implements Serializable {

    private String symbol;

    private String clientOrderId;

    //@NotBlank
    //@Schema(description = "买卖方向 / sell or buy", required = true)
    private OrderSide side;

    //@NotBlank
    //@Schema(description = "订单类型 order type", required = true)
    private OrderType type;

    //@NotBlank
    //@Schema(description = "有效方式", required = true)
    private TimeInForce timeInForce;

    //@NotBlank
    //@Schema(description = "业务类型 / biz type,example:spot", required = true)
    private String bizType;

    //@Schema(description = "价格。限价必填; 市价不填 / Price. Required for limit orders; not required for market orders", example = "40000")
    private BigDecimal price;

    //@Schema(description = "数量。限价必填；市价按数量下单时必填 / Quantity. Required for limit orders; required for market orders by quantity", example = "2")
    private BigDecimal quantity;

    //@Schema(description = "金额。限价不填；市价按金额下单时必填 / Quote quantity. Not required for limit orders; required for market orders by amount", example = "80000")
    private BigDecimal quoteQty;

    //@Schema(description = "媒体 / media ", example = "btok")
    private String media;

    //@Schema(description = "媒体渠道 / media channel", example = "12345")
    private String mediaChannel;

    //@Schema(description = "NFT序列化 / NFT id", example = "12345")
    private String nftId;
}
