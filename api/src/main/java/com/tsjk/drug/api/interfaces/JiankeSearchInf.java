package com.tsjk.drug.api.interfaces;

import com.tsjk.drug.api.entity.*;

import java.util.List;

public interface JiankeSearchInf {
    /**
     * 订单查询
     *
     * @param orderNo
     * @return
     */
    public OrderList findOrderByno(String orderNo);

    /**
     * 订单批量查询
     *
     * @param orderNoStr
     * @return
     */
    public BatchOrderList findBatchOrderByno(String orderNoStr);

    /**
     * 抓取属于某个合作伙伴的订单
     *
     * @param startTime 开始时间
     * @param count     返回条目数
     * @return
     */
    public PartnerOrderList findPartnerOrder(String startTime, int count);

    /**
     * 外部合作伙伴将订单推送给健客
     *
     * @param externalOrderNo 外部订单编号
     * @param serialNumber    订单交易号
     * @param invoice         发票抬头
     * @param money           订单金额
     * @param orderTime       下单时间
     * @param accountId       账号id
     * @param consignee       收件人
     * @param telephone       联系电话
     * @param mobilephone     收货人手机
     * @param province        收货省
     * @param city            收货市
     * @param district        收货区
     * @param town            收货乡镇或者街道
     * @param address         收货详细地址
     * @param status          订单状态
     * @param paymentType     支付类型
     * @param transportCosts  运费
     * @param orderProductList    订单产品列表
     * @return
     */
    public OrderexternalResult orderPush(String externalOrderNo, String serialNumber,
                                         String invoice, int money, String orderTime, String accountId, String consignee, String telephone,
                                         String mobilephone, String province, String city, String district, String town, String address,
                                         int status, String paymentType, int transportCosts, List<OrderProduct> orderProductList
    );

    /**
     * 传送订单号和外部订单号取消订单（未实现）
     */

    /**
     * 产品查询
     *
     * @param productCode 产品编码
     * @return
     */
    public ProductList findProduct(String productCode);

    /**
     * 产品批量查询
     *
     * @param productCodeStr 产品编码（用逗号隔开）
     * @return
     */
    public BatchProductList findBatchProduct(String productCodeStr);

    /**
     * 同步产品数据查询
     *
     * @param page 页码
     * @param size 每页显示数量，最大50
     * @return
     */
    public ProductSync findSyncProduct(int page, int size);

    /**
     * 订单物流轨迹查询
     *
     * @param orderNo 订单号
     * @return
     */
    public LogisticsList findLogistics(String orderNo);

    /**
     * 未支付订单取消
     * @param orderNo	String(50)	是	健客订单号
     * @param externalOrderNo	String	是	天使健康订单编号
     * */
    public String cancelOrder(String orderNo,String externalOrderNo);

}
