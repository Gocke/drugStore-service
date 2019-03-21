package com.tsjk.drug.api.entity;

import lombok.Data;

@Data
public class OrderProduct {
    private String productCode;
    private String productName;
    private int amount;
    private int actualPrice;
    private String packing;
}
