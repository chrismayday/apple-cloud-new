package com.cachexic.apple.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserConsumerController.java
 * @Package com.cachexic.apple.consumer.controller
 * @Description: 
 * @date 2017-04-22 21:24:42
 */
@RestController
@RequestMapping("/user")
public class UserConsumerController {

    private final static Logger log = LoggerFactory.getLogger(UserConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("users")
    @HystrixCommand(fallbackMethod = "usersFallback")
    public String users(){
        log.debug("consumer-user:users");
        //return restTemplate.getForObject("http://192.168.2.103:8081/user/users",String.class);
        return restTemplate.getForObject("http://provider-user/user/users",String.class);
    }

    public String usersFallback(){
        return "consumer:usersFallback..........";
    }

    @GetMapping("getUserById/{id}")
    public User getUserById(@PathVariable Long id){
        log.debug("consumer-user:getUserById-->"+id);
       // return restTemplate.getForObject("http://192.168.2.103:8081/user/getUserById/"+id,User.class);
        return restTemplate.getForObject("http://provider-user/user/getUserById/"+id,User.class);
    }

}
