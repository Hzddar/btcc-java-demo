package com.xt.api.dto.spot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hzddar
 * 成交信息/trade info
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TradeDTO implements Serializable {
    /**
     * id
     */
    private Long i;

    /**
     * 成交时间(time)
     */
    private Long t;

    /**
     * 成交价(price)
     */
    private String p;
    /**
     * 成交量(quantity)
     */
    private String q;
    /**
     * 成交额(volume)
     */
    private String v;
    /**
     * 方向(buyerMaker),true:buy,false:sell
     */
    private Boolean b;

}
