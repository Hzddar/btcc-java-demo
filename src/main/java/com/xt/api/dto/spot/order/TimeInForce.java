package com.xt.api.dto.spot.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;


@Getter
@AllArgsConstructor
public enum TimeInForce {
    /**
     * 限价挂单直到撤单 / GTC
     */
    GTC(1),
    /**
     * 全部成交或撤销 / FOK
     */
    FOK(2),
    /**
     * 立即成交或撤销 / IOC
     */
    IOC(3),
    /**
     * post_only，只挂单 / GTX
     */
    GTX(4);

    private final int number;


}
