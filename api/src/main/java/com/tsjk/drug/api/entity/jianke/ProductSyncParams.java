package com.tsjk.drug.api.entity.jianke;

import lombok.Data;

@Data
public class ProductSyncParams extends BaseParams{

    /*
    * method	String	是	Api接口名称 jianke.product.sync
    * cid	String	是	合作伙伴id
    * signMethod	String	是	签名摘要算法，目前只支持md5
    * sign	String	是	签名，签名算法见附件1.签名算法
    * randomStr	String	是	随机字符串，随机函数生成
    * page	Int	是	页码。取值范围:大于零的整数; 默认值:0
    * size	Int	是	每页条数。取值范围:大于零的整数; 默认值:10;最大值:50
    * */

    private final String method = "jianke.product.sync";
    private int page;
    private int size;

    public void setSize(int size) {
        if (size > 0 && size <= 50) {
            this.size = size;
        } else {
            this.size = 10;
        }
    }

    public void setPage(int page) {
        if (page < 0) {
            this.page = 0;
        } else {
            this.page = page;
        }
    }
}
