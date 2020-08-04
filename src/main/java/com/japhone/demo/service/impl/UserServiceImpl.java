package com.japhone.demo.service.impl;

import com.japhone.demo.mapper.UserMapper;
import com.japhone.demo.model.entity.User;
import com.japhone.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created by japhone on 2020-07-03
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public String sayHello() {
        return "hello world !";
    }

    @Override
    public User get(Long id) {
        return userMapper.get(id);
    }

    @Override
    public int countSameLevelNum(String userCode, Integer levelCode) {
        return userMapper.countSameLevelNum(userCode, levelCode);
    }

    @Override
    public void save(User user) {
        if(user.getId() == null) {
            userMapper.insert(user);
        }else{
            userMapper.update(user);
        }
    }
}
