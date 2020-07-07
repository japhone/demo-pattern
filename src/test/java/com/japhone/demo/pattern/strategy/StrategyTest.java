package com.japhone.demo.pattern.strategy;

import com.japhone.demo.model.bo.UserUpDownLevelConditionConfigBo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * created by liukai on 2020-07-06
 */
@SpringBootTest
public class StrategyTest {

    private Logger logger = LoggerFactory.getLogger(StrategyTest.class);

    @Resource
    private UpDownLevelContext upDownLevelContext;

    List<UserUpDownLevelConditionConfigBo> conditionList = null;

    @Test
    public void test(){
        IUpDownStrategy upDownStrategy;

        if(conditionList != null && conditionList.size() > 0){
            for(UserUpDownLevelConditionConfigBo upDownLevelConditionConfigBo : conditionList){
                upDownStrategy = upDownLevelContext.getStrategy(upDownLevelConditionConfigBo.getConditionCode());

                logger.info("upDownStrategy: {}", upDownStrategy);
            }
        }
    }

    @BeforeEach
    public void init(){
        conditionList = new ArrayList<>();

        UserUpDownLevelConditionConfigBo userUpDownLevelConditionConfigBo = new UserUpDownLevelConditionConfigBo();
        userUpDownLevelConditionConfigBo.setId(1l);
        userUpDownLevelConditionConfigBo.setSrcLevelCode(1001);
        userUpDownLevelConditionConfigBo.setSrcLevelName("会员");
        userUpDownLevelConditionConfigBo.setTargetLevelCode(1002);
        userUpDownLevelConditionConfigBo.setTargetLevelName("VIP");
        userUpDownLevelConditionConfigBo.setConditionCode(2010);
        userUpDownLevelConditionConfigBo.setConditionName("消费累计额度");
        userUpDownLevelConditionConfigBo.setConditionValue("1000");
        userUpDownLevelConditionConfigBo.setDescription("会员升VIP");
        conditionList.add(userUpDownLevelConditionConfigBo);

        userUpDownLevelConditionConfigBo = new UserUpDownLevelConditionConfigBo();
        userUpDownLevelConditionConfigBo.setId(2l);
        userUpDownLevelConditionConfigBo.setSrcLevelCode(1002);
        userUpDownLevelConditionConfigBo.setSrcLevelName("VIP");
        userUpDownLevelConditionConfigBo.setTargetLevelCode(1003);
        userUpDownLevelConditionConfigBo.setTargetLevelName("特约店");
        userUpDownLevelConditionConfigBo.setConditionCode(2040);
        userUpDownLevelConditionConfigBo.setConditionName("销售累计额度");
        userUpDownLevelConditionConfigBo.setConditionValue("5000");
        userUpDownLevelConditionConfigBo.setDescription("VIP升特约店");
        conditionList.add(userUpDownLevelConditionConfigBo);

        userUpDownLevelConditionConfigBo = new UserUpDownLevelConditionConfigBo();
        userUpDownLevelConditionConfigBo.setId(3l);
        userUpDownLevelConditionConfigBo.setSrcLevelCode(1002);
        userUpDownLevelConditionConfigBo.setSrcLevelName("VIP");
        userUpDownLevelConditionConfigBo.setTargetLevelCode(1003);
        userUpDownLevelConditionConfigBo.setTargetLevelName("特约店");
        userUpDownLevelConditionConfigBo.setConditionCode(2030);
        userUpDownLevelConditionConfigBo.setConditionName("同级用户数");
        userUpDownLevelConditionConfigBo.setConditionValue("10");
        userUpDownLevelConditionConfigBo.setDescription("VIP升特约店");
        conditionList.add(userUpDownLevelConditionConfigBo);
    }

}
