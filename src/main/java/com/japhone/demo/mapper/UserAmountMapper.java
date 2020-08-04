package com.japhone.demo.mapper;

import com.japhone.demo.model.entity.UserAmount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by japhone on 2020-07-31
 */
public interface UserAmountMapper {

    List<UserAmount> queryByUserId(Long userId);

    UserAmount queryByUserIdAndAmountType(@Param("userId") Long userId, @Param("amountType") Integer amountType);
}
