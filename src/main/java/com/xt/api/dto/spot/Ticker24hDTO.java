package com.xt.api.dto.spot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author evan
 * 24小时Ticker / 24H Ticker
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Ticker24hDTO implements Serializable {

    /**
     * 交易对(symbol)
     */
    private String s;

    /**
     * 更新时间(time)
     */
    private Long t;

    /**
     * 价格变动(change value)
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

}
