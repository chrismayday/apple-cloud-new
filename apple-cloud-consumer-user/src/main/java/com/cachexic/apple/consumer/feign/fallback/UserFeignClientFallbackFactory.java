package com.cachexic.apple.consumer.feign.fallback;

import com.cachexic.apple.consumer.controller.User;
import com.cachexic.apple.consumer.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import feign.hystrix.FallbackFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserFeignClientFactory.java
 * @Package com.gasq.cloud.consumer.user.feign.fallback
 * @Description: Feign利用fallbackFactory属性，打印fallback异常.(fallback = UserFeignClientFallback.class 的增强版)
 * @date 2017-04-12 18:54:03
 */
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

    private static final Logger logger = LoggerFactory.getLogger(UserFeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        //一进fallback就能拦截到异常
        logger.info("fall back reason was :{}",cause.getMessage());

        return new UserFeignClientWithFallBackFactory() {
            @Override
            public List<User> users() {
                return null;
            }

            @Override
            public User getUserById(@PathVariable Long id) {
                User user = new User();
                user.setName("feign-fallback-factory...............");
                return user;
            }

            @Override
            public User saveUser(@RequestBody User user) {
                return null;
            }

            @Override
            public User updateUser(@RequestBody User user) {
                return null;
            }

            @Override
            public void deleteUser(@PathVariable Long id) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }
}
