package com.japhone.demo.service.impl;

import com.japhone.demo.service.UserOrderFlowService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * created by japhone on 2020-08-03
 */
@SpringBootTest
class UserOrderFlowServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(UserOrderFlowServiceImplTest.class);

    @Resource
    private UserOrderFlowService userOrderFlowService;

    @Test
    public void countPackageByUserId(){
        logger.info("{}", userOrderFlowService.countPackageByUserId(1l, 2));
    }

    @Test
    public void countRefundPackageByUserId(){
        logger.info("{}", userOrderFlowService.countRefundPackageByUserId(1l, 2));
    }

}