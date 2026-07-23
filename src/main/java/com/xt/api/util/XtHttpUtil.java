package com.xt.api.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.GlobalHeaders;
import cn.hutool.http.HttpRequest;
import org.apache.commons.codec.digest.HmacUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhouzhuang
 * @create 2022/10/28 10:48
 */
public class XtHttpUtil {
    private static final String appKey = "3cdc3f01-26eb-4d34-aa7a-0063b3217eb5";
    private static final String secretKey = "f37f08c8cb63d7240c90f7c7eb373bedc45dd430";
    private static final String encry = "HmacSHA256";
    private static final String contentType = "application/json";
    private static final String baseUrl = "https://sapi.xxx.com";
    private static final String window = "6000";
    private static final String accessToken = "Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxMDc2MjE0NjkwQHFxLmNvbSIsInRva2VuSWQiOjYyNzIxODUxNDI4MzMyMzU4NCwiZGV2aWNlQ29kZSI6IjE3NzkwODk1Mzk0MjcyUEI5Z0hIUk1NRnJBRG9TR0lHIiwiYWNjb3VudExldmVsIjoiMSIsInVzZXJOYW1lIjoiMTA3NjIxNDY5MEBxcS5jb20iLCJ1c2VySWQiOjk3NTYxMTA2MTg4NzcsInZlcnNpb24iOjEzMiwidXNlckNvZGUiOiJmNjc4YTVkNTdhNWRiZjNhM2JmM2Y2MWFhNjIwNmEzZiIsImFjY291bnRJZCI6Ijk3NTYxMTA2MTg4NzciLCJzY29wZSI6ImF1dGgiLCJsYXN0QXV0aFRpbWUiOjE3NzkyNDI1NDY5NjAsInNpZ25UeXBlIjoiVVAiLCJleHAiOjE3ODA1Mzg1NDYsImRldmljZSI6IndlYiJ9.gbh1h39erf23A5FOLHJSp26YZM1HKEqElUB6oWoiUgESgScYlYXJNrZ8m4hYbmFP1oIDuXWR5JzYU14NYEOfqGHOD1pFRd-2E1apYzktPvFunV77-KPkoKFCarBFSfKtlahi8CcmMe1AwyDP9MbMFXQeEEK2BN3UXDQdEu01Yfw";
    static {
        GlobalHeaders.INSTANCE.clearHeaders();
    }

    public static String get(String uri, Map<String, Object> queryMap) {
        return getOrDel(uri, queryMap, "GET");
    }

    public static String delete(String uri, Map<String, Object> queryMap) {
        return getOrDel(uri, queryMap, "DELETE");
    }

    public static String deleteWithBody(String uri, String jsonBody) {
        Long time = System.currentTimeMillis();
        String url = baseUrl + uri;
        String signature = generateSign(time + "", window, "DELETE", uri, null, jsonBody);
        HttpRequest httpRequest = HttpRequest.delete(url);
        config(httpRequest, time + "", signature);
        httpRequest.body(jsonBody);
        System.out.println("request===="+httpRequest.getMethod()+" "+httpRequest);
        return httpRequest.execute().body();
    }

    public static String post(String uri, String jsonBody) {
        Long time = System.currentTimeMillis();
        String url = baseUrl + uri;
        String signature = generateSign(time + "", window, "POST", uri, null, jsonBody);
        HttpRequest httpRequest = HttpRequest.post(url);
        config(httpRequest, time + "", signature);
        if (jsonBody != null) {
            httpRequest.body(jsonBody);
        }
        System.out.println("request====" + httpRequest.getMethod() + " " + httpRequest);
        return httpRequest.execute().body();
    }

    private static String getOrDel(String uri, Map<String, Object> queryMap, String method) {
        Long time = System.currentTimeMillis();
        String url = baseUrl + uri;
        StringBuilder querySb = new StringBuilder();
        String query = null;
        if (!CollectionUtil.isEmpty(queryMap)) {
            TreeMap<String, Object> treeMap = new TreeMap(queryMap);
            for (String key : treeMap.keySet()) {
                querySb.append(key).append("=").append(queryMap.get(key)).append("&");
            }
            String substring = querySb.substring(0, querySb.lastIndexOf("&"));
            url += "?" + substring;
            query = substring;
        }
        String signature = generateSign(time + "", window, method, uri, query, null);
        HttpRequest httpRequest = null;
        if ("GET".equalsIgnoreCase(method)) {
            httpRequest = HttpRequest.get(url);
        } else if ("DELETE".equalsIgnoreCase(method)) {
            httpRequest = HttpRequest.delete(url);
        }
        config(httpRequest, time + "", signature);
        System.out.println("request===="+httpRequest.getMethod()+" "+httpRequest);
        return httpRequest.execute().body();
    }

    private static void config(HttpRequest httpRequest, String time, String sign) {
        httpRequest
                .contentType(contentType)
                .timeout(3000)
                .header("validate-algorithms", encry)
                .header("validate-appkey", appKey)
                .header("validate-recvwindow", window)
                .header("validate-timestamp", time)
                .header("validate-signature", sign)
//                .header("access-token", accessToken);
//                .header("authorization", accessToken);
//                .setHttpProxy("127.0.0.1",7890);
        ;
    }


    private static String generateSign(String timestamp, String window, String method, String uri, String query, String jsonBody) {
        String x = String.format("validate-algorithms=%s&validate-appkey=%s&validate-recvwindow=%s&validate-timestamp=%s", encry, appKey, window, timestamp);
        String y = String.format("#%s#%s", method, uri);
        if (query != null && query.length() > 0) {
            y += "#" + query;
        }
        if (jsonBody != null && jsonBody.length() > 0) {
            y += "#" + jsonBody;
        }
        String origin = x + y;
        System.out.println("origion===" + origin);
        return HmacUtils.hmacSha256Hex(secretKey, origin);
    }


}
