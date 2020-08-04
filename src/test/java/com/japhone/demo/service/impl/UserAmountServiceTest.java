package com.japhone.demo.service.impl;

import com.japhone.demo.service.UserAmountService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * created by japhone on 2020-07-31
 */
@SpringBootTest
public class UserAmountServiceTest {

    private Logger logger = LoggerFactory.getLogger(UserAmountServiceTest.class);

    @Resource
    private UserAmountService userAmountService;

    @Test
    public void queryByUserId(){

        logger.info("{}", userAmountService.queryByUserId(1l));

    }

}
