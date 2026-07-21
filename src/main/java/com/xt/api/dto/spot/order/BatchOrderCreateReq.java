package com.xt.api.dto.spot.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author evan
 * 批量创建订单请求/ Batch create order request
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BatchOrderCreateReq implements Serializable {

    /**
     * 客户端批次号 / Client batch number
     * example: 11111
     */
    private String clientBatchId;

    /**
     * 订单集合 / Order collection
     * max size: 100
     */
    private List<OrderCreateReq> items;
}
