package com.tsjk.drug.api.entity.jianke;

import lombok.Data;

/**
 * @author Caine
 * @Date 2019/3/19
 * @DESC 取消未支付订单
 */
@Data
public class CancelOrderParams extends BaseParams {

    /*
    * method	String	是	Api接口名称	jianke.order.cancel
    * cid	String	是	合作伙伴id
    * signMethod	String	是	签名摘要算法，目前只支持md5
    * sign	String	是	签名，签名算法见附件1.签名算法
    * randomStr	String	是	随机字符串，随机函数生成
    * orderNo	String(50)	是	订单号	“orderNo”:“”
    * externalOrderNo	String	是	外部订单编号
    * */

    private final String method = "jianke.order.cancel" ;
    private String orderNo;
    private String externalOrderNo;

    @Override
    public String toString() {
        return "CancelOrderParams{" +
                "method='" + method + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", externalOrderNo='" + externalOrderNo + '\'' +
                ", cid='" + cid + '\'' +
                ", signMethod='" + signMethod + '\'' +
                ", sign='" + sign + '\'' +
                ", randomStr='" + randomStr + '\'' +
                '}';
    }
}
