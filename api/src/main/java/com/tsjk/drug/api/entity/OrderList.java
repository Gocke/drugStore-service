package com.tsjk.drug.api.entity;

import lombok.Data;

/**
 * 订单查询返回订单列
 */
@Data
public class OrderList {
    private String cid;
    private String sign;
    private String randomStr;
    private String nextTime;
    private String returnCode;
    private String resultCode;
    private String returnMsg;
    private String code;
    private String message;
    private java.util.List<OrderListBean> orderList;
    @Data
    public static class OrderListBean {
        private String orderNo;
        private String orderStatus;
        private String rxDrugStatus;
        private int money;
        private String orderTime;
        private String shippingNo;
        private String shippingCode;
        private String shippingName;
        private String invoice;
        private java.util.List<OrderProductListBean> orderProductList;
        @Data
        public static class OrderProductListBean {
            private String productCode;
            private String productName;
            private int count;
            private int price;
            private String thumbnailUrl;
            private String packing;
        }
    }
}
