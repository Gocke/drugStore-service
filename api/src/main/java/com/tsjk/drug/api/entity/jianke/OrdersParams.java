package com.tsjk.drug.api.entity.jianke;

import lombok.Getter;
import lombok.ToString;

/**
 * 订单查询参数
 */
@ToString
public class OrdersParams extends BaseParams {

    /*
    * 单个查询
    * method	String	是	Api接口名称	jianke.order.get
    * cid	String	是	合作伙伴id
    * signMethod	String	是	签名摘要算法，目前只支持md5
    * sign	String	是	签名，签名算法见附件1.签名算法
    * randomStr	String	是	随机字符串，随机函数生成
    * orderNo	String(50)	是	订单号	orderNo:“orderNo”
    * 此处orderNo为推送接口返回的订单号
    *
    * 批量查询
    * method	String	是	Api接口名称	jianke.order.getBatchList
    * orderNo	String	是(50)	用逗号隔开的订单号，最多10个	“orderNo":"orderNo,orderNo”
    * 此处orderNo为推送接口返回的订单号

    *
    * */

    @Getter
    private String method;

    @Getter
    private String orderNo;

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        if (orderNo.contains(",")){
            this.method = "jianke.order.getBatchList";
        }else {
            this.method = "jianke.order.get";
        }
    }
}
