package com.tsjk.drug.api.entity;

import lombok.Data;

/**
 * 订单推送
 */
@Data
public class OrderexternalResult {
    private String returnCode;
    private String returnMsg;
    private String randomStr;
    private String orderNo;
    private String resultCode;
    private String sign;
    private String cid;
    private String code;
    private String message;
}
