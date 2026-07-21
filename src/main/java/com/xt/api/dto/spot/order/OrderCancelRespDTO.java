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
public class OrderCancelRespDTO implements Serializable {
    private String orderId;
    private String cancelId;
    private String clientCancelId;
}
