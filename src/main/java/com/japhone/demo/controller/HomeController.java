package com.japhone.demo.controller;

import com.japhone.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by japhone on 2020-07-03
 */
@RestController
public class HomeController {

    @Resource
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return userService.sayHello();
    }

}
