package com.japhone.demo.pattern.strategy.user.growth.impl;

import com.japhone.demo.annotation.handle.HandlerUpDownLevelConditionType;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.pattern.strategy.user.growth.AbstractGrowthUpDownStrategy;
import org.springframework.stereotype.Component;

/**
 * created by liukai on 2020-07-03
 * 消费成长值升降级策略
 */
@Component
@HandlerUpDownLevelConditionType(LevelConditionEnum.CONSUMPTION_GROWTH_VALUE)
public class ConsumeGrowthUpDownStrategy extends AbstractGrowthUpDownStrategy {

    @Override
    public Integer getGrowthValue(Long userId) {
        //查询该用户的消费成长值
        return 10000;
    }
}
