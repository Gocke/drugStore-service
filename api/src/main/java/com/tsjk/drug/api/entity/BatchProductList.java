package com.tsjk.drug.api.entity;

import lombok.Data;

import java.util.List;

/**
 * 产品批量查询结果
 */

@Data
public class BatchProductList {
    private String cid;
    private String sign;
    private String randomStr;
    private String nextTime;
    private String returnCode;
    private String resultCode;
    private String returnMsg;
    private String code;
    private String message;
    private List<ProductListBean> productList;

    @Data
    public static class ProductListBean {
        private String productCode;
        private String productName;
        private String mainProductCode;
        private int productStatusType;
        private int channelPrice;
        private String manufacturer;
        private int prescriptionType;
        private int productInventory;
        private String productAttribute;
        private String thumbnailUrl;
        private String productImageUrl;
        private String packing;
        private String introduction;
        private String firstClassName;
        private String secondClassName;
        private String thirdClassName;
        private String approvalNumber;
        private String commonTitle;
        private String brandName;
        private String packingProduct;
        private String barCode;
        private String productmainmaterial;
        private String characters;
        private String dosage;
        private String adverse;
        private String taboo;
        private String precautions;
        private String drugInteractions;
        private String storage;
        private int massDate;

    }
}
