package com.cachexic.apple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author tangmin
 * @version V1.0
 * @Title: HystrixTurbineApplication.java
 * @Package com.cachexic.apple
 * @Description: 
 * @date 2017-04-22 23:59:58
 */
@SpringBootApplication
@EnableTurbine
public class HystrixTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }
}
