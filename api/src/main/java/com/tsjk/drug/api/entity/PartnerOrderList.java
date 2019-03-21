package com.tsjk.drug.api.entity;
import lombok.Data;
import java.util.List;

/**
 * 合作伙伴订单查询结果
 */
@Data
public class PartnerOrderList {

    private String cid;
    private String sign;
    private String randomStr;
    private String nextTime;
    private String returnCode;
    private String resultCode;
    private Object returnMsg;
    private Object errorCode;
    private Object errorMsg;
    private List<OrderListBean> orderList;

    @Data
    public static class OrderListBean {
        private String orderNo;
        private String orderStatus;
        private int money;
        private String orderTime;
        private String shippingNo;
        private String invoice;
        private List<OrderProductListBean> orderProductList;

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
