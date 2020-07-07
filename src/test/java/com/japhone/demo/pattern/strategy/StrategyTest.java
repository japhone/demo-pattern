package com.japhone.demo.pattern.strategy;

import com.japhone.demo.model.bo.UserBo;
import com.japhone.demo.model.bo.UserUpDownLevelConditionConfigBo;
import com.japhone.demo.model.enums.LevelCodeEnum;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.model.enums.LevelUpDownFlagEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * created by japhone on 2020-07-06
 */
@SpringBootTest
public class StrategyTest {

    private Logger logger = LoggerFactory.getLogger(StrategyTest.class);

    @Resource
    private UpDownLevelContext upDownLevelContext;

    List<UserUpDownLevelConditionConfigBo> conditionList = null;
    UserBo user = null;

    @Test
    public void test(){
        IUpDownStrategy upDownStrategy;

        if(conditionList != null && conditionList.size() > 0){
            for(UserUpDownLevelConditionConfigBo upDownLevelConditionConfigBo : conditionList){
                upDownStrategy = upDownLevelContext.getStrategy(upDownLevelConditionConfigBo.getConditionCode());

                logger.info("upDownStrategy: {}", upDownStrategy);

                boolean b = upDownStrategy.check(user, upDownLevelConditionConfigBo);
                if(b){
                    logger.info("用户ID:{}，满足升降条件", user.getId());
                    break;
                }
            }
        }
    }

    /**
     * 初始化用户信息
     */
    @BeforeEach
    public void initUser(){
        user = new UserBo();
        user.setId(1l);
        user.setLevelCode(LevelCodeEnum.USER.getCode());
    }

    /**
     * 初始化升降级条件
     * conditionList为从数据库中检索出的升降级条件
     */
    @BeforeEach
    public void initUpDownCondition(){
        conditionList = new ArrayList<>();

        UserUpDownLevelConditionConfigBo userUpDownLevelConditionConfigBo = new UserUpDownLevelConditionConfigBo();
        userUpDownLevelConditionConfigBo.setId(1l);
        userUpDownLevelConditionConfigBo.setSrcLevelCode(LevelCodeEnum.USER.getCode());
        userUpDownLevelConditionConfigBo.setSrcLevelName(LevelCodeEnum.USER.getDescription());
        userUpDownLevelConditionConfigBo.setTargetLevelCode(LevelCodeEnum.VIP.getCode());
        userUpDownLevelConditionConfigBo.setTargetLevelName(LevelCodeEnum.VIP.getDescription());
        userUpDownLevelConditionConfigBo.setConditionCode(LevelConditionEnum.CONSUMPTION_VALUE.getCode());
        userUpDownLevelConditionConfigBo.setConditionName(LevelConditionEnum.CONSUMPTION_VALUE.getDescription());
        userUpDownLevelConditionConfigBo.setConditionValue("1000");
        userUpDownLevelConditionConfigBo.setDescription("会员升VIP");
        userUpDownLevelConditionConfigBo.setUpDownFlag(LevelUpDownFlagEnum.UP_FLAG.getCode());
        conditionList.add(userUpDownLevelConditionConfigBo);

        userUpDownLevelConditionConfigBo = new UserUpDownLevelConditionConfigBo();
        userUpDownLevelConditionConfigBo.setId(2l);
        userUpDownLevelConditionConfigBo.setSrcLevelCode(LevelCodeEnum.VIP.getCode());
        userUpDownLevelConditionConfigBo.setSrcLevelName(LevelCodeEnum.VIP.getDescription());
        userUpDownLevelConditionConfigBo.setTargetLevelCode(LevelCodeEnum.SPECIAL.getCode());
        userUpDownLevelConditionConfigBo.setTargetLevelName(LevelCodeEnum.SPECIAL.getDescription());
        userUpDownLevelConditionConfigBo.setConditionCode(LevelConditionEnum.SALES_VALUE.getCode());
        userUpDownLevelConditionConfigBo.setConditionName(LevelConditionEnum.SALES_VALUE.getDescription());
        userUpDownLevelConditionConfigBo.setConditionValue("5000");
        userUpDownLevelConditionConfigBo.setDescription("VIP升特约店");
        userUpDownLevelConditionConfigBo.setUpDownFlag(LevelUpDownFlagEnum.UP_FLAG.getCode());
        conditionList.add(userUpDownLevelConditionConfigBo);

        userUpDownLevelConditionConfigBo = new UserUpDownLevelConditionConfigBo();
        userUpDownLevelConditionConfigBo.setId(3l);
        userUpDownLevelConditionConfigBo.setSrcLevelCode(LevelCodeEnum.VIP.getCode());
        userUpDownLevelConditionConfigBo.setSrcLevelName(LevelCodeEnum.VIP.getDescription());
        userUpDownLevelConditionConfigBo.setTargetLevelCode(LevelCodeEnum.SPECIAL.getCode());
        userUpDownLevelConditionConfigBo.setTargetLevelName(LevelCodeEnum.SPECIAL.getDescription());
        userUpDownLevelConditionConfigBo.setConditionCode(LevelConditionEnum.SAME_UP_LEVEL_NUM.getCode());
        userUpDownLevelConditionConfigBo.setConditionName(LevelConditionEnum.SAME_UP_LEVEL_NUM.getDescription());
        userUpDownLevelConditionConfigBo.setConditionValue("10");
        userUpDownLevelConditionConfigBo.setDescription("VIP升特约店");
        userUpDownLevelConditionConfigBo.setUpDownFlag(LevelUpDownFlagEnum.UP_FLAG.getCode());
        conditionList.add(userUpDownLevelConditionConfigBo);
    }

}
