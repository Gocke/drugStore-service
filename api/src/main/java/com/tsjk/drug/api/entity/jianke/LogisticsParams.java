package com.tsjk.drug.api.entity.jianke;

import lombok.Data;

/**
 * 订单物流轨迹查询参数
 */
@Data
public class LogisticsParams extends BaseParams{
    /*
    * method	String	是	Api接口名称	jianke.logistics.get
    * cid	String	是	合作伙伴id
    * signMethod	String	是	签名摘要算法，目前只支持md5
    * sign	String	是	签名，签名算法见附件1.签名算法
    * randomStr	String	是	随机字符串，随机函数生成
    * orderNo	String(50)	是	单个订单号 	“orderNo”:“”
*/

    private final String method = "jianke.logistics.get";

    private String orderNo;
}
