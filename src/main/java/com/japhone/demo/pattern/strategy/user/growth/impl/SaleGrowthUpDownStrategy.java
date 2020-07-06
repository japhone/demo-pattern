package com.japhone.demo.pattern.strategy.user.growth.impl;

import com.japhone.demo.annotation.handle.HandlerUpDownLevelConditionType;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.pattern.strategy.user.growth.AbstractGrowthUpDownStrategy;
import org.springframework.stereotype.Component;

/**
 * created by liukai on 2020-07-03
 * 销售成长值升降级策略
 */
@Component
@HandlerUpDownLevelConditionType(LevelConditionEnum.SALES_GROWTH_VALUE)
public class SaleGrowthUpDownStrategy extends AbstractGrowthUpDownStrategy {
    @Override
    public Integer getGrowthValue(Long userId) {
        //查询该用户的销售成长值
        return 20000;
    }
}
