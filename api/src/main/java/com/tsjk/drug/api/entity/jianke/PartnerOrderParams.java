package com.tsjk.drug.api.entity.jianke;

import lombok.Data;

/**
 * 获取合作伙伴订单接口参数
 */
@Data
public class PartnerOrderParams extends BaseParams {

    /*
     * method	    String	是	Api接口名称	jianke.order.getList
     * cid	        String	是	合作伙伴id
     * signMethod	String	是	签名摘要算法，目前只支持md5
     * sign	String	是	签名，签名算法见附件1.签名算法
     * randomStr	String	是	随机字符串，随机函数生成
     * startTime	String	是	开始时间，格式为 yyyy-MM-dd HH:mm:ss
     * count	int	是	默认为10,获取订单条数，最大不超过50
     * */

    private final String method = "jianke.order.getList";

    private String startTime;
    private int count;

    public void setCount(int count) {
        if (count > 0 && count <= 50) {
            this.count = count;
        } else {
            this.count = 10;
        }

    }
}
