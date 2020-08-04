package com.japhone.demo.service.impl;

import com.japhone.demo.mapper.UserAmountMapper;
import com.japhone.demo.model.entity.UserAmount;
import com.japhone.demo.service.UserAmountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by japhone on 2020-07-31
 */
@Service
public class UserAmountServiceImpl implements UserAmountService {

    @Resource
    private UserAmountMapper userAmountMapper;

    @Override
    public List<UserAmount> queryByUserId(Long userId) {
        return userAmountMapper.queryByUserId(userId);
    }

    @Override
    public UserAmount queryByUserIdAndAmountType(Long userId, Integer amountType) {
        return userAmountMapper.queryByUserIdAndAmountType(userId, amountType);
    }
}
