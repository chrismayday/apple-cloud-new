package com.cachexic.apple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author tangmin
 * @version V1.0
 * @Title: DiscoverEurekaApplication.java
 * @Package com.cachexic.apple
 * @Description: eureka服务注册中心
 * @date 2017-04-22 18:44:11
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoverEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoverEurekaApplication.class, args);
    }
}
