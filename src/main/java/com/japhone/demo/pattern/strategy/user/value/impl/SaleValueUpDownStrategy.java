package com.japhone.demo.pattern.strategy.user.value.impl;

import com.japhone.demo.annotation.handle.HandlerUpDownLevelConditionType;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.pattern.strategy.user.value.AbstractValueUpDownStrategy;
import org.springframework.stereotype.Component;

/**
 * created by liukai on 2020-07-03
 * 销售额度升降级策略
 */
@Component
@HandlerUpDownLevelConditionType(LevelConditionEnum.SALES_VALUE)
public class SaleValueUpDownStrategy extends AbstractValueUpDownStrategy {
    @Override
    public Integer getValue(Long userId) {
        //查询该用户的销售额
        return 20000;
    }
}
