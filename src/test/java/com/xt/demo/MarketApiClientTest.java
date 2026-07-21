package com.xt.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xt.api.dto.spot.*;
import com.xt.api.util.XtHttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketApiClientTest {


    /**
     * 获取服务器时间/Query server time
     */
    @Test
    public void getServerInfo() {
        String uri = "/v4/public/time";
        Map<String, Object> param = new HashMap<>();
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    /**
     * 获取客户端IP/Query client IP
     */
    @Test
    public void getClient() {
        String uri = "/v4/public/client";
        Map<String, Object> param = new HashMap<>();
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    /**
     * 获取交易对信息/Query symbol info
     */
    @Test
    public void getSymbols() {
        String uri = "/v4/public/symbol";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("symbols", "btc_usdt,eth_usdt");
        //param.put("version", "755935d211bf085afe16a381c0aae96a");
        String jsonStr = XtHttpUtil.get(uri, param);
        System.out.println("result====" + jsonStr);
        JSONObject jsonResult;
        if (JSONObject.isValid(jsonStr) && JSONObject.parseObject(jsonStr).getInteger("rc") == 0
                && (jsonResult = JSONObject.parseObject(jsonStr).getJSONObject("result")) != null) {
            System.out.println(System.lineSeparator() + JSONObject.toJSONString(jsonResult, true));
        }
    }

    /**
     * 获取深度数据/Query depth data
     */
    @Test
    public void depth() {
        String uri = "/v4/public/depth";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        //最小查询100条
        param.put("limit", "100");
        String jsonStr = XtHttpUtil.get(uri, param);
        System.out.println("result====" + jsonStr);
        JSONObject jsonResult;
        if (JSONObject.isValid(jsonStr) && JSONObject.parseObject(jsonStr).getInteger("rc") == 0
                && (jsonResult = JSONObject.parseObject(jsonStr).getJSONObject("result")) != null) {
            System.out.println(System.lineSeparator() + JSONObject.toJSONString(jsonResult, true));
        }
    }

    /**
     * 获取k线数据/Query K line data
     */
    @Test
    public void kline() {
        String uri = "/v4/public/kline";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("interval", "1m");
        param.put("startTime", "1");
        param.put("endTime", "1784622978083");
        param.put("limit", "2");
        String jsonStr = XtHttpUtil.get(uri, param);
        System.out.println("result====" + jsonStr);
        JSONArray jsonResult;
        if (JSONObject.isValid(jsonStr) && JSONObject.parseObject(jsonStr).getInteger("rc") == 0
                && (jsonResult = JSONObject.parseObject(jsonStr).getJSONArray("result")) != null) {
            System.out.println(System.lineSeparator() + JSONObject.toJSONString(jsonResult, true));
        }
    }

    /**
     * 查询历史成交列表/Query historical trade list
     */
    @Test
    public void tradeHistory() {
        String uri = "/v4/public/trade/history";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("limit", "200");
        param.put("direction", "NEXT");
        param.put("fromId", "659051865152585984");
        String jsonStr = XtHttpUtil.get(uri, param);
        System.out.println("result====" + jsonStr);
        FlowPage<TradeDTO> result;
        if (JSONObject.isValid(jsonStr) && JSONObject.parseObject(jsonStr).getInteger("rc") == 0
                && (result = JSONObject.parseObject(
                JSONObject.parseObject(jsonStr).getString("result"),
                new TypeReference<FlowPage<TradeDTO>>() {
                }.getType())) != null) {
            System.out.println(result);
            System.out.println(System.lineSeparator() + JSONObject.toJSONString(result, true));
        }
    }

    /**
     * 完整ticker/ Query complete ticker
     */
    @Test
    public void ticker() {
        String uri = "/v4/public/ticker";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("symbols", "btc_usdt,eth_usdt");
        param.put("tags", "spot");
        String jsonStr = XtHttpUtil.get(uri, param);
        System.out.println("result====" + jsonStr);
        List<TickerDTO> result;
        if (JSONObject.isValid(jsonStr) && JSONObject.parseObject(jsonStr).getInteger("rc") == 0
                && (result = JSONObject.parseArray(
                JSONObject.parseObject(jsonStr).getString("result"),
                TickerDTO.class)) != null) {
            System.out.println(result);
            System.out.println(System.lineSeparator() + JSONObject.toJSONString(result, true));
        }
    }


    /**
     * ticker价格 / Query ticker price
     */
    @Test
    public void tickerPrice() {
        String uri = "/v4/public/ticker/price";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("symbols", "btc_usdt,eth_usdt");
        param.put("tags", "spot");
        String jsonStr = XtHttpUtil.get(uri, param);
        System.out.println("result====" + jsonStr);
        List<TickerPriceDTO> result;
        if (JSONObject.isValid(jsonStr) && JSONObject.parseObject(jsonStr).getInteger("rc") == 0
                && (result = JSONObject.parseArray(
                JSONObject.parseObject(jsonStr).getString("result"),
                TickerPriceDTO.class)) != null) {
            System.out.println(result);
            System.out.println(System.lineSeparator() + JSONObject.toJSONString(result, true));
        }
    }



    /**
     * 获取最优挂单ticker / Query best ticker
     */
    @Test
    public void tickerBook() {
        String uri = "/v4/public/ticker/book" ;
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("symbols", "btc_usdt,eth_usdt");
        param.put("tags", "spot");
        String jsonStr = XtHttpUtil.get(uri, param);
        System.out.println("result====" + jsonStr);
        List<TickerBookDTO> result;
        if (JSONObject.isValid(jsonStr) && JSONObject.parseObject(jsonStr).getInteger("rc") == 0
                && (result = JSONObject.parseArray(
                JSONObject.parseObject(jsonStr).getString("result"),
                TickerBookDTO.class)) != null) {
            System.out.println(result);
            System.out.println(System.lineSeparator() + JSONObject.toJSONString(result, true));
        }
    }

    /**
     * 获取最优挂单ticker / Query best ticker
     */
    @Test
    public void ticker24h() {
        String uri = "/v4/public/ticker/24h" ;
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("symbols", "btc_usdt,eth_usdt");
        param.put("tags", "spot");
        String jsonStr = XtHttpUtil.get(uri, param);
        System.out.println("result====" + jsonStr);
        List<Ticker24hDTO> result;
        if (JSONObject.isValid(jsonStr) && JSONObject.parseObject(jsonStr).getInteger("rc") == 0
                && (result = JSONObject.parseArray(
                JSONObject.parseObject(jsonStr).getString("result"),
                Ticker24hDTO.class)) != null) {
            System.out.println(result);
            System.out.println(System.lineSeparator() + JSONObject.toJSONString(result, true));
        }
    }

}
