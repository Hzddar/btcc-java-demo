package com.xt.api.dto.spot;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhouzhuang
 * @create 2023/9/20 16:09
 */
@Data
@Builder
public class SpotPostOrderRequest {

    /**
     * 交易对 /  Symbol
     */
    private String symbol;
    /**
     * 交易方向 /  Side
     * BUY/SELL
     */
    private String side;
    /**
     * 订单类型/Order Type
     * LIMIT-限价,MARKET-市价
     */
    private String type;
    /**
     * GTC, FOK, IOC, GTX
     */
    private String timeInForce;

    /**
     * 业务类型 SPOT-现货, LEVER-杠杆
     * biz type:SPOT or  LEVER
     */
    private String bizType;
    private BigDecimal price;
    private BigDecimal quantity;
    private String quoteQty;
    /**
     * media
     */
    private String media;
    /**
     * media channel
     */
    private String mediaChannel;
}
