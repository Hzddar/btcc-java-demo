package com.xt.api.dto.spot.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author evan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BatchOrderCreateRespDTO implements Serializable {

    // @Schema(description = "批次号 / Batch ID", example = "batch_123")
    private String batchId;

    // @Schema(description = "成功集合 / Success Items")
    private List<Item> items;


    @Data
    @Builder(toBuilder = true)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        // @Schema(description = "下标,从0开始 / Index, starting from 0", example = "0")
        private Integer index;

        // @Schema(description = "客户端订单号 / Client Order ID", example = "12345")
        private String clientOrderId;

        // @Schema(description = "订单ID / Order ID", example = "6216559590087220004")
        private String orderId;

        // @Schema(description = "是否拒单 / Rejected", example = "true")
        private Boolean rejected;

        // @Schema(description = "拒单原因 / Reject Reason", example = "invalid price precision")
        private String reason;
    }

}
