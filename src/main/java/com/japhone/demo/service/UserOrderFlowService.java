package com.japhone.demo.service;

/**
 * created by japhone on 2020-08-03
 */
public interface UserOrderFlowService {

    /**
     * 查询正向单礼包个数
     * @param userId
     * @return
     */
    int countPackageByUserId(Long userId, Integer packageFlag);

    /**
     * 查询逆向单礼包个数
     * @param userId
     * @return
     */
    int countRefundPackageByUserId(Long userId, Integer packageFlag);

}
