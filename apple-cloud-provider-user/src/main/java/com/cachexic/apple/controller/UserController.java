package com.cachexic.apple.controller;

import com.cachexic.apple.dao.UserDao;
import com.cachexic.apple.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserController.java
 * @Package com.cachexic.apple.controller
 * @Description: 
 * @date 2017-04-22 19:12:56
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    @GetMapping("users")
    public List<User> users(){
        log.debug("provider-user:users()");
        return userDao.findAll();
    }

    @GetMapping("getUserById/{id}")
    public User getUserById(@PathVariable Long id){
        log.debug("provider-user:getUserById-->"+id);
        return userDao.findOne(id);
    }

    @PostMapping(value = "saveUser",consumes = "application/json")
    public User saveUser(@RequestBody User user){
        log.debug("provider-user:saveUser-->"+user.toString());
        return userDao.save(user);
    }

    @PutMapping(value = "updateUser",consumes = "application/json")
    public User updateUser(@RequestBody User user){
        log.debug("provider-user:updateUser-->"+user.toString());
        return userDao.save(user);
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        log.debug("provider-user:deleteUser-->"+id);
        userDao.delete(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAll(){
        log.debug("provider-user:deleteAll");
        userDao.deleteAll();
    }

}
