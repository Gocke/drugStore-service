package com.tsjk.health.drug.web;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author Caine
 * @date 2019/3/2
 * @desc
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UASWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(UASWebApplication.class, args);
    }
}
