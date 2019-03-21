package com.tsjk.health.drug.core.config;

import com.tsjk.drug.api.entity.*;
import com.tsjk.drug.api.entity.jianke.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class CustomsParamsConfig {
    /**
     * 对接用户数据
     * @return
     */
    @Bean
    public CustomKey getcustomParams(){
        CustomKey customKey = new CustomKey();
        customKey.setCid("tsjk001");
        customKey.setKey("123456");
        customKey.setUrl("http://openapi.tst.jianke.com/openApis/main");
       return customKey;
    }

    /**
     * 订单查询参数
     * @return
     */
    @Bean
    public OrdersParams getordersParams(){
        OrdersParams ordersParams = new OrdersParams();
        return ordersParams;
    }

    /**
     * 订单批量查询参数
     * @return
     */
    @Bean
    public OrdersParams getBatchordersParams(){
        OrdersParams ordersParams = new OrdersParams();
        return ordersParams;
    }

    /**
     * 合作伙伴订单查询参数
     * @return
     */
    @Bean
    public PartnerOrderParams getPartnerordersParams(){
        PartnerOrderParams partnerOrdersParams = new PartnerOrderParams();
        return partnerOrdersParams;
    }

    /**
     * 外部合作伙伴将订单推送给健客
     */
    @Bean
    public OrderexternalParams getOrderexternalParams(){
        OrderexternalParams orderexternalParams = new OrderexternalParams();
        return orderexternalParams;
    }

    /**
     * 传送订单号和外部订单号取消订单（未实现）
     */

    /**
     * 产品编号查询参数
     * @return
     */
    @Bean
    public ProductParams getProductParams(){
        ProductParams productParams = new ProductParams();
        return productParams;
    }

    /**
     * 产品编号批量查询参数
     * @return
     */
    @Bean
    public ProductParams getBatchProductParams(){
        ProductParams productParams = new ProductParams();
        return productParams;
    }

    /**
     * 产品同步参数
     * @return
     */
    @Bean
    public ProductSyncParams getProductSyncParams(){
        ProductSyncParams productSyncParams = new ProductSyncParams();
        return productSyncParams;
    }

    /**
     * 订单物流轨迹参数
     * @return
     */
    @Bean
    public LogisticsParams getLogisticsParams(){
        LogisticsParams logisticsParams = new LogisticsParams();
        return logisticsParams;
    }

}
