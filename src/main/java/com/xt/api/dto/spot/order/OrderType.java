package com.xt.api.dto.spot.order;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 *
 */

@Getter
@AllArgsConstructor
public enum OrderType {

    LIMIT(1, false),

    MARKET(2, false),

    ENTRUST_PROFIT(3, true),

    ENTRUST_TRACK(4, true);

    private final int number;


    private final boolean isEntrust;

}
