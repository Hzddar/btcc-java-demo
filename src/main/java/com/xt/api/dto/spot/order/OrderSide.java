package com.xt.api.dto.spot.order;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 *
 */

@Getter
@AllArgsConstructor
public enum OrderSide {
    /**
     * buy
     */
    BUY(1),

    /**
     * sell
     */
    SELL(2);

    private final int number;

}
