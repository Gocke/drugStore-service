package com.tsjk.health.drug.core.sevice;

import com.tsjk.drug.api.entity.*;
import com.tsjk.drug.api.entity.jianke.*;
import com.alibaba.fastjson.JSONObject;
import com.tsjk.health.drug.core.config.CustomsParamsConfig;
import com.tsjk.health.drug.core.tools.JiankeInf;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.tsjk.drug.api.interfaces.*;

import java.util.List;

@Service
public class JiankeSearchSevice implements JiankeSearchInf {
    @Autowired
    CustomsParamsConfig customParams;
    @Autowired
    JiankeInf tools;

    /**
     * 订单号查询
     *
     * @param orderNo 订单号
     * @return
     */
    @Override
    public OrderList findOrderByno(String orderNo) {
        OrdersParams ordersParams = customParams.getordersParams();
        ordersParams.setOrderNo(orderNo);
        JSONObject jsonObj = (JSONObject) JSONObject.toJSON(ordersParams);
        String result = "";
        try {
            result = tools.runSync(jsonObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        OrderList orderlist = JSONObject.parseObject(result, OrderList.class);
        return orderlist;
    }

    /**
     * 批量订单号查询（订单按分号隔开）
     *
     * @param orderNoStr 订单号
     * @return
     */
    @Override
    public BatchOrderList findBatchOrderByno(String orderNoStr) {
        OrdersParams ordersParams = customParams.getBatchordersParams();
        ordersParams.setOrderNo(orderNoStr);
        JSONObject jsonObj = (JSONObject) JSONObject.toJSON(ordersParams);
        String result = "";
        try {
            result = tools.runSync(jsonObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        BatchOrderList batchOrderlist = JSONObject.parseObject(result, BatchOrderList.class);
        return batchOrderlist;
    }

    /**
     * 抓取属于某个合作伙伴的订单
     *
     * @param startTime 开始时间
     * @param count     返回条目数
     * @return
     */
    @Override
    public PartnerOrderList findPartnerOrder(String startTime, int count) {
        PartnerOrderParams partnerOrderParams = customParams.getPartnerordersParams();
        partnerOrderParams.setStartTime(startTime);
        partnerOrderParams.setCount(count);
        JSONObject jsonObj = (JSONObject) JSONObject.toJSON(partnerOrderParams);
        String result = "";
        try {
            result = tools.runSync(jsonObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        PartnerOrderList partnerOrderList = JSONObject.parseObject(result, PartnerOrderList.class);
        return partnerOrderList;
    }


    /**
     * 产品查询
     *
     * @param productCode 产品编码
     * @return
     */
    @Override
    public ProductList findProduct(String productCode) {
        ProductParams productParams = customParams.getProductParams();
        productParams.setProductCode(productCode);
        JSONObject jsonObj = (JSONObject) JSONObject.toJSON(productParams);
        String result = "";
        try {
            result = tools.runSync(jsonObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ProductList productList = JSONObject.parseObject(result, ProductList.class);
        return productList;
    }

    /**
     * 产品批量查询
     *
     * @param productCodeStr 产品编码（用逗号隔开）
     * @return
     */
    @Override
    public BatchProductList findBatchProduct(String productCodeStr) {
        ProductParams productParams = customParams.getBatchProductParams();
        productParams.setProductCode(productCodeStr);
        JSONObject jsonObj = (JSONObject) JSONObject.toJSON(productParams);
        String result = "";
        try {
            result = tools.runSync(jsonObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        BatchProductList batchProductList = JSONObject.parseObject(result, BatchProductList.class);
        return batchProductList;
    }

    /**
     * 同步产品数据查询
     * @param page 页码
     * @param size 每页显示数量，最大50
     * @return
     */
    @Override
    public ProductSync findSyncProduct(int page,int size) {
        ProductSyncParams productSyncParams = customParams.getProductSyncParams();
        productSyncParams.setPage(page);
        productSyncParams.setSize(size);
        JSONObject jsonObj = (JSONObject) JSONObject.toJSON(productSyncParams);
        String result = "";
        try {
            result = tools.runSync(jsonObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ProductSync productSync = JSONObject.parseObject(result, ProductSync.class);
        return productSync;
    }

    /**
     * 外部合作伙伴将订单推送给健客
     *
     * @param externalOrderNo  外部订单编号
     * @param serialNumber     订单交易号
     * @param invoice          发票抬头
     * @param money            订单金额
     * @param orderTime        下单时间
     * @param accountId        账号id
     * @param consignee        收件人
     * @param telephone        联系电话
     * @param mobilephone      收货人手机
     * @param province         收货省
     * @param city             收货市
     * @param district         收货区
     * @param town             收货乡镇或者街道
     * @param address          收货详细地址
     * @param status           订单状态
     * @param paymentType      支付类型
     * @param transportCosts   运费
     * @param orderProductList 订单产品列表
     * @return
     */
    @Override
    public OrderexternalResult orderPush(String externalOrderNo, String serialNumber, String invoice, int money,
                                         String orderTime, String accountId, String consignee, String telephone,
                                         String mobilephone, String province, String city, String district, String town,
                                         String address, int status, String paymentType, int transportCosts,
                                         List<OrderProduct> orderProductList) {
        OrderexternalParams orderexternalParams = customParams.getOrderexternalParams();
        orderexternalParams.setExternalOrderNo(externalOrderNo);
        orderexternalParams.setSerialNumber(serialNumber);
        orderexternalParams.setInvoice(invoice);
        orderexternalParams.setMoney(money);
        orderexternalParams.setOrderTime(orderTime);
        orderexternalParams.setAccountId(accountId);
        orderexternalParams.setConsignee(consignee);
        orderexternalParams.setTelephone(telephone);
        orderexternalParams.setMobilephone(mobilephone);
        orderexternalParams.setProvince(province);
        orderexternalParams.setCity(city);
        orderexternalParams.setDistrict(district);
        orderexternalParams.setTown(town);
        orderexternalParams.setAddress(address);
        orderexternalParams.setStatus(status);
        orderexternalParams.setPaymentType(paymentType);
        orderexternalParams.setTransportCosts(transportCosts);
        orderexternalParams.setOrderProductList(orderProductList);

        JSONObject jsonObj = (JSONObject) JSONObject.toJSON(orderexternalParams);
        String result = "";
        try {
            result = tools.runSync(jsonObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        OrderexternalResult orderexternalResult = JSONObject.parseObject(result, OrderexternalResult.class);
        return orderexternalResult;
    }

    /**
     * 订单物流轨迹查询
     *
     * @param orderNo 订单号
     * @return
     */
    @Override
    public LogisticsList findLogistics(String orderNo) {
        LogisticsParams logisticsParams = customParams.getLogisticsParams();
        logisticsParams.setOrderNo(orderNo);
        JSONObject jsonObj = (JSONObject) JSONObject.toJSON(logisticsParams);
        String result = "";
        try {
            result = tools.runSync(jsonObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        LogisticsList logisticsList = JSONObject.parseObject(result, LogisticsList.class);
        return logisticsList;
    }

    /**
     * 未支付订单取消
     * @param orderNo	String(50)	是	健客订单号            6619076493371078
     * @param externalOrderNo	String	是	天使健康订单编号  a1b9923c
     * */
    @Override
    public String cancelOrder(String orderNo, String externalOrderNo) {
        CancelOrderParams cancelOrderParams = new CancelOrderParams();
        cancelOrderParams.setExternalOrderNo(externalOrderNo);
        cancelOrderParams.setOrderNo(orderNo);
        JSONObject jsonObj = (JSONObject) JSONObject.toJSON(cancelOrderParams);
        String result = "";
        try {
            result = tools.runSync(jsonObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
