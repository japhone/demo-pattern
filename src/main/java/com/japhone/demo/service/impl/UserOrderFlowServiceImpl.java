package com.japhone.demo.service.impl;

import com.japhone.demo.mapper.UserOrderFlowMapper;
import com.japhone.demo.service.UserOrderFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created by japhone on 2020-08-03
 */
@Service
public class UserOrderFlowServiceImpl implements UserOrderFlowService {

    @Resource
    private UserOrderFlowMapper userOrderFlowMapper;

    @Override
    public int countPackageByUserId(Long userId, Integer packageFlag) {
        return userOrderFlowMapper.countPackageByUserId(userId, packageFlag);
    }

    @Override
    public int countRefundPackageByUserId(Long userId, Integer packageFlag) {
        return userOrderFlowMapper.countRefundPackageByUserId(userId, packageFlag);
    }
}
