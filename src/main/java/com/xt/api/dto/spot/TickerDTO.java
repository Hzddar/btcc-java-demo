package com.xt.api.dto.spot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author evan
 * 24小时Ticker/ 24H Ticker
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TickerDTO implements Serializable {

    /**
     * 交易对(symbol)
     */
    private String s;

    /**
     * 时间戳(time)
     */
    private Long t;

    /**
     * 价格变动值(change value)
     */
    private String cv;

    /**
     * 价格变动百分比(change rate)
     */
    private String cr;

    /**
     * 最早一笔(open)
     */
    private String o;
    /**
     * 最低(low)
     */
    private String l;
    /**
     * 最高(high)
     */
    private String h;

    /**
     * 最后一笔(close)
     */
    private String c;

    /**
     * 成交量(quantity)
     */
    private String q;

    /**
     * 成交额(volume)
     */
    private String v;

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
