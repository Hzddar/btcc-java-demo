package com.xt.api.dto.spot.order;

import lombok.Builder;
import lombok.Data;

/**
 * @author colin
 * @Description: 抵扣手续费实体
 */
@Data
@Builder(toBuilder = true)
public class DeductServiceFee {
    /**
     * 手续费/ fee
     */
    private String fee;
    /**
     * 手续费币种 / fee Currency
     */
    private String feeCurrency;
}
