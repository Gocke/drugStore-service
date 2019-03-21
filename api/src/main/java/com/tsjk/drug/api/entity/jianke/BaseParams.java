package com.tsjk.drug.api.entity.jianke;

import lombok.Data;

/**
 * @author Caine
 * @Date 2019/3/19
 * @DESC 健客商城请求api通用参数
 */
@Data
public class BaseParams {

    /*
    * method	String	是	Api接口名称	jianke.order.get
    * cid	String	是	合作伙伴id
    * signMethod	String	是	签名摘要算法，目前只支持md5
    * sign	String	是	签名，签名算法见附件1.签名算法
    * randomStr	String	是	随机字符串，随机函数生成
    * */

    String cid;
    final String signMethod = "md5";
    String sign;
    String randomStr;

}
