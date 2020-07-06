package com.japhone.demo.service.impl;

import com.japhone.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * created by liukai on 2020-07-03
 */
@Service
public class UserServiceImpl implements UserService {

    public String sayHello() {
        return "hello world !";
    }
}
