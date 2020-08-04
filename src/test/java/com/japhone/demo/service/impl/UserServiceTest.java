package com.japhone.demo.service.impl;

import com.japhone.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * created by japhone on 2020-07-03
 */
@SpringBootTest
public class UserServiceTest {

    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Resource
    private UserService userService;

    @Test
    public void sayHello(){
        System.out.println(userService.sayHello());
    }

    @Test
    public void getUser(){
        logger.info("用户：{}",userService.get(1l));
    }

}
