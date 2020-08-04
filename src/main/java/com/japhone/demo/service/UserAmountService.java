package com.japhone.demo.service;

import com.japhone.demo.model.entity.UserAmount;

import java.util.List;

/**
 * created by japhone on 2020-07-31
 */
public interface UserAmountService {

    List<UserAmount> queryByUserId(Long userId);

    UserAmount queryByUserIdAndAmountType(Long userId, Integer amountType);

}
