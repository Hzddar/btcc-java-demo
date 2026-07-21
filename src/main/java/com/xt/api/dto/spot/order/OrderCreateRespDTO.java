package com.xt.api.dto.spot.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author evan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderCreateRespDTO implements Serializable {
    /**
     * 订单ID / order id
     * example:6216559590087220004
     */
    private String orderId;

    /**
     * 客户端订单ID / client order id
     * example:6216559590087220004
     */
    private String clientOrderId;
}
