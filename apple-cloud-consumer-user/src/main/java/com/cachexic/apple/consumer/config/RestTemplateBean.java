package com.cachexic.apple.consumer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author tangmin
 * @version V1.0
 * @Title: RestTemplateBean.java
 * @Package com.cachexic.apple.consumer.config
 * @Description: 
 * @date 2017-04-22 21:26:23
 */
@Component
@Configuration
public class RestTemplateBean {
    /**
     * 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
      */
    @Autowired
    private RestTemplateBuilder builder;

    /**
     * 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
     * @LoadBalanced 使得restTemplate具有负载均衡能力
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return builder.build();
    }
}
