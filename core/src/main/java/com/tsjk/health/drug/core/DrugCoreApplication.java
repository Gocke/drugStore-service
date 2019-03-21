package com.tsjk.health.drug.core;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Caine
 * @date 2019/3/2
 * @desc
 */
@Configurable
//@EnableEurekaClient
@SpringBootApplication
public class DrugCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(DrugCoreApplication.class);
    }
}
