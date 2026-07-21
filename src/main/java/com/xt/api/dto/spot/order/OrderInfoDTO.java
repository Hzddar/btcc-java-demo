package com.xt.api.dto.spot.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author evan
 * 订单信息 / Order Info
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoDTO implements Serializable {

    /**
     * 交易对 / Symbol
     * example BTC_USDT
     */
    private String symbol;
    /**
     * 订单号 / Order ID
     * example 6216559590087220004
     */
    private String orderId;
    /**
     * 客户端订单号 / Client Order ID
     * example 16559590087220001
     */
    private String clientOrderId;


    /* order info */

    /**
     * 标的币种 / Base Currency
     */
    private String baseCurrency;
    /**
     * 报价币种 / Quote Currency
     */
    private String quoteCurrency;

    /**
     * 订单方向 / Side
     * allowableValues BUY,SELL
     * example BUY
     */
    private String side;
    /**
     * 订单类型 / Order Type
     * allowableValues LIMIT,MARKET
     * example LIMIT
     */
    private String type;
    /**
     * 有效方式 / Time In Force
     * allowableValues GTC,IOC,FOK,GTX
     * example GTC
     */
    private String timeInForce;

    /**
     * 价格 / Price
     * example 40000
     */
    private String price;
    /**
     * 原始数量 / Original Quantity
     * example 2
     */
    private String origQty;
    /**
     * 原始金额 / Original Quote Quantity
     * example 48000
     */
    private String origQuoteQty;

    /* execute info*/

    /**
     * 已执行数量 / Executed Quantity
     * example 1.2
     */
    private String executedQty;
    /**
     * 待执行数量（若撤单或下单拒绝，该值为0）/ Leaving Quantity (0 if canceled or rejected)
     */
    private String leavingQty;


    /**
     * 成交标的(成交数量) / Trade Base Quantity
     * example 2
     */
    private String tradeBase;
    /**
     * 成交报价(成交金额) / Trade Quote Volume
     * example 48000
     */
    private String tradeQuote;
    /**
     * 成交均价 / Average Price
     * example 42350
     */
    private String avgPrice;
    /**
     * 手续费 / Fee
     */
    private String fee;
    /**
     * 手续费币种 / Fee Currency
     */
    private String feeCurrency;
    /**
     * NFT id
     *
     */
    @Deprecated
    private String nftId;
    /**
     * symbol.Type:nft/normal
     *
     */
    @Deprecated
    private String symbolType;

    /**
     * 抵扣手续费列表 / Deduct Service Fee List
     *
     */
    @Deprecated
    private List<DeductServiceFee> deductServices;


    /**
     * 原币种剩余未抵扣的手续费，包含抵扣金抵扣部分 / Original remaining undeducted fee, including deduction from coupons
     *
     */
    @Deprecated
    private String origRestFee;
    /**
     * 原币种剩余未抵扣的手续费币种 / Original remaining undeducted fee currency
     *
     */
    @Deprecated
    private String origFeeCurrency;

    /**
     * 平台币抵扣费用,如btcc / Platform currency deduction fee, e.g. btcc
     *
     */
    @Deprecated
    private String platFormCurrencyFee;
    /**
     * 平台币 / Platform Currency
     *
     */
    @Deprecated
    private String platFormCurrency;

    /**
     * 抵扣券使用额度 / Coupon Usage Amount
     *
     */
    @Deprecated
    private String couponAmount;
    /**
     * 抵扣券币种 / Coupon Currency
     *
     */
    @Deprecated
    private String couponCurrency;
    /**
     * 抵扣券抵扣掉的(原币种)手续费数量 / Coupon deducted fee (original currency)
     *
     */
    @Deprecated
    private String couponDeductFee;


    /**
     * 关闭的 / Closed
     * allowableValues true,false
     * example true
     *
     */
    @Deprecated
    private Boolean closed;
    /**
     * 订单状态 / Order State
     * allowableValues NEW,PARTIALLY_FILLED,FILLED,CANCELED,REJECTED,EXPIRED
     * example NEW
     */
    private String state;
    /**
     * 订单时间 / Order Time
     * example 1655958915583
     */
    private Long time;
    /**
     * 订单更新时间 / Order Updated Time
     * example 1655958915583
     */
    private Long updatedTime;

    /**
     * 用户IP信息 / IP Address
     * example 54.151.166.240
     */
    private String ip;
}
