package com.tsjk.drug.api.entity.jianke;

import com.tsjk.drug.api.entity.OrderProduct;
import lombok.Data;

import java.util.List;

/**
 * 订单推送参数
 */
@Data
public class OrderexternalParams extends BaseParams {

    /*
    * method	String	是	Api接口名称	jianke.order.externalcreate
    * cid	String	是	合作伙伴id
    * signMethod	String	是	签名摘要算法，目前只支持md5
    * sign	String	是	签名，签名算法见附件1.签名算法
    * randomStr	String	是	随机字符串，随机函数生成
    * externalOrderNo	String	是	外部订单编号
    * invoice	String	是	发票抬头	invoice的话根据用户有无填写，没有填写的话 可以传 “”
    * orderNotes	String	否	订单备注
    * money	Int	是	订单金额	单位：分
    * orderTime	String	是	下单时间
    * accountId	String	是	账号id	可传随机字符串
    * consignee	String	是	收件人
    * telephone	String	否	联系电话
    * mobilephone	String	是	收货人手机
    * province	String	是	收货省	例如：广东省
    * city	String	是	收货市	例如：广州市
    * district	String	是	收货区	例如：黄埔区
    * town	String	否	收货乡镇或者街道	例如：科学大道
    * 如果有最好填上，精确地址
    * address	String	是	收货详细地址	xxxx
    * paymentType	String	是	支付类型	1支付宝，2微信，3网银在线，4货到付款
    * transportCosts	Int	是	运费	单位：分
    * status	Int	是	订单状态	1未支付，2已支付
    * serialNumber	String	是	订单交易号
    * 此参数对应的第三方支付的支付成功单号，微信支付的“交易单号”/支付宝的“订单号”/银联支付的“交易流水号”，
    * 当接健客支付，或支付类型为“货到付款”的可不填此字段
    * orderProductList		是	订单产品列表
    *
    * 其中orderProductList为
    * productCode	String	是	产品编号
    * productName	String(100)	是	产品名称
    * amount	int	是	产品数量
    * actualPrice	int	是	单品单价	单位：分
    * packing	String	是	药品规格
    *
    * */

    private final String method = "jianke.order.externalcreate";

    private String externalOrderNo;
    private String serialNumber;
    private String invoice;
    private int money;
    private String orderTime;
    private String accountId;
    private String consignee;
    private String telephone;
    private String mobilephone;
    private String province;
    private String city;
    private String district;
    private String town;
    private String address;
    private int status;
    private String paymentType;
    private int transportCosts;
    private List<OrderProduct> orderProductList;
}
