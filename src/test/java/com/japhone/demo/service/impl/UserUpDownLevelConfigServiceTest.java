package com.japhone.demo.service.impl;

import com.japhone.demo.service.UserUpDownLevelConfigService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * created by japhone on 2020-07-31
 */
@SpringBootTest
public class UserUpDownLevelConfigServiceTest {

    private Logger logger = LoggerFactory.getLogger(UserUpDownLevelConfigServiceTest.class);

    @Resource
    private UserUpDownLevelConfigService userUpDownLevelConfigService;

    @Test
    public void list(){
        logger.info("{}", userUpDownLevelConfigService.list(null));
    }

}
