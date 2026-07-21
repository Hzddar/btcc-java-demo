package com.xt.api.dto.spot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author evan
 * Ticker price
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TickerPriceDTO implements Serializable {
    /**
     * 交易对(symbol)
     */
    private String s;

    /**
     * 时间(time)
     */
    private Long t;

    /**
     * 价格(price)
     */
    private String p;
}
