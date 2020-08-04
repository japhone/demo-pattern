package com.japhone.demo.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * created by japhone on 2020-08-03
 */
public interface UserOrderFlowMapper {
    int countPackageByUserId(@Param("userId") Long userId, @Param("packageFlag")Integer packageFlag);

    int countRefundPackageByUserId(@Param("userId") Long userId, @Param("packageFlag")Integer packageFlag);
}
