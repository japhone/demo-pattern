package com.japhone.demo.pattern.strategy;

import com.japhone.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * created by japhone on 2020-07-03
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void sayHello(){
        System.out.println(userService.sayHello());
    }

}
