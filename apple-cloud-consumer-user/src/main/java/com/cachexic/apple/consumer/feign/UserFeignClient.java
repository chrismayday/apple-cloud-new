package com.cachexic.apple.consumer.feign;

import com.cachexic.apple.consumer.controller.User;
import com.cachexic.apple.consumer.feign.fallback.UserFeignClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserFeignClient.java
 * @Package com.cachexic.apple.consumer.feign
 * @Description:
 * @date 2017-04-22 22:50:37
 */
@FeignClient(name = "provider-user", path = "/user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "users", method = RequestMethod.GET)
    List<User> users();

    @RequestMapping(value = "getUserById/{id}", method = RequestMethod.GET)
    User getUserById(@PathVariable("id") Long id);

    @RequestMapping(value = "saveUser", consumes = "application/json", method = RequestMethod.POST)
    User saveUser(@RequestBody User user);

    @RequestMapping(value = "updateUser", consumes = "application/json", method = RequestMethod.PUT)
    User updateUser(@RequestBody User user);

    @RequestMapping(value = "deleteUser/{id}",method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("id") Long id);

    @RequestMapping(value = "deleteAll",method = RequestMethod.DELETE)
    void deleteAll();

}
