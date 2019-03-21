package com.tsjk.drug.api.entity;

import java.util.List;
import lombok.Data;
@Data
public class ProductSync {
    private String cid;
    private String sign;
    private String randomStr;
    private int count;
    private String returnCode;
    private String resultCode;
    private Object returnMsg;
    private Object errorCode;
    private Object errorMsg;
    private List<Product> productList;
}
