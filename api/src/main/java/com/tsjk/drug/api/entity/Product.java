package com.tsjk.drug.api.entity;
import lombok.Data;

/**
 * 产品类
 */
@Data
public class Product {
    private String productCode;
    private String productName;
    private String mainProductCode;
    private int productStatusType;
    private int marketPrice;
    private int ourPrice;
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
