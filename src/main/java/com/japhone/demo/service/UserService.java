package com.japhone.demo.service;

import com.japhone.demo.model.entity.User;

/**
 * created by japhone on 2020-07-03
 */
public interface UserService {

    String sayHello();

    User get(Long id);

    /**
     * 查询同级以上邀请用户数
     * @param userCode  用户邀请码
     * @param levelCode 用户等级
     * @return
     */
    int countSameLevelNum(String userCode, Integer levelCode);

    void save(User user);
}
