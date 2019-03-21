package com.tsjk.drug.api.entity.jianke;

import lombok.Getter;
import lombok.ToString;

/**
 * 产品查询参数
 */
@ToString
public class ProductParams extends BaseParams{

    /*
    * method	String	是	Api接口名称	jianke.product.get
    * cid	String	是	合作伙伴id
    * signMethod	String	是	签名摘要算法，目前只支持md5
    * sign	String	是	签名，签名算法见附件1.签名算法
    * randomStr	String	是	随机字符串，随机函数生成
    * productCode	String	是	产品编号	“productCode”:“
    *
    * method	String	是	Api接口名称	jianke.product.getBatchList
    * productCode	String	是	产品编号，多个用逗号隔开	“productCode”：“1,15”

    *
    * 返回结果
    * returnCode	String	是	通信返回码，SUCCESS
    * returnMsg	String	是	返回信息，如非空，为错误原因。
    * */

    @Getter
    private String method;

    @Getter
    private String productCode;

    public void setProductCode(String productCode) {
        this.productCode = productCode;
        if (productCode.contains(",")){
            this.method = "jianke.product.get";
        }else {
            this.method = "jianke.product.getBatchList";
        }
    }
}
