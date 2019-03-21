package com.tsjk.drug.api.entity;

import lombok.Data;
/**
 * 订单物流轨迹查询结果
 */

import java.util.List;
@Data
public class LogisticsList {
    private String cid;
    private String sign;
    private String randomStr;
    private int orderStatus;
    private String shippingName;
    private String shippingCode;
    private String shippingNo;
    private String returnCode;
    private String resultCode;
    private Object returnMsg;
    private Object errorCode;
    private Object errorMsg;
    private List<MapListBean> mapList;

    @Data
    public static class MapListBean {
        private long time;
        private String operator;
        private String description;
    }
}
