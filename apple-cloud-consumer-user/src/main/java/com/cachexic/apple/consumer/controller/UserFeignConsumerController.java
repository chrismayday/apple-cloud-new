package com.cachexic.apple.consumer.controller;

import com.cachexic.apple.consumer.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserFeignConsumerController.java
 * @Package com.cachexic.apple.consumer.controller
 * @Description: feign的方式实现
 * @date 2017-04-22 22:48:54
 */
@RestController
@RequestMapping("/feign/user")
public class UserFeignConsumerController {
    private final static Logger log = LoggerFactory.getLogger(UserFeignConsumerController.class);
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("users")
    public List<User> users(){
        log.debug("consumer-feign-user:users()");
        return userFeignClient.users();
    }

    @GetMapping("getUserById/{id}")
    public User getUserById(@PathVariable Long id){
        log.debug("consumer-feign-user:getUserById-->"+id);
        return userFeignClient.getUserById(id);
    }

    @PostMapping(value = "saveUser",consumes = "application/json")
    public User saveUser(@RequestBody User user){
        log.debug("consumer-feign-user:saveUser-->"+user.toString());
        return userFeignClient.saveUser(user);
    }

    @PutMapping(value = "updateUser",consumes = "application/json")
    public User updateUser(@RequestBody User user){
        log.debug("consumer-feign-user:updateUser-->"+user.toString());
        return userFeignClient.updateUser(user);
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        log.debug("consumer-feign-user:deleteUser-->"+id);
        userFeignClient.deleteUser(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAll(){
        log.debug("consumer-feign-user:deleteAll");
        userFeignClient.deleteAll();
    }



}
