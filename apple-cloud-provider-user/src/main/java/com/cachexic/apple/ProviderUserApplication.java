package com.cachexic.apple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tangmin
 * @version V1.0
 * @Title: ProviderUser.java
 * @Package com.cachexic.apple
 * @Description:
 * @date 2017-04-22 19:04:23
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication.class, args);
    }
}
