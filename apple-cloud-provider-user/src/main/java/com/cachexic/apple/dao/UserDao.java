package com.cachexic.apple.dao;

import com.cachexic.apple.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserDao.java
 * @Package com.cachexic.apple.dao
 * @Description: 
 * @date 2017-04-22 19:07:17
 */
public interface UserDao extends JpaRepository<User,Long> {

}