package com.xt.api.dto.spot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author evan
 * 订单簿Ticker/ Order Book Ticker
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TickerBookDTO implements Serializable {

    /**
     * 交易对(symbol)
     */
    private String s;

    /**
     * 更新时间(time)
     */
    private Long t;

    /**
     * asks price(卖一价)
     */
    private String ap;

    /**
     * asks qty(卖一量)
     */
    private String aq;

    /**
     * bids price(买一价)
     */
    private String bp;

    /**
     * bids qty(买一量)
     */
    private String bq;

}
