package com.japhone.demo.pattern.strategy.user.value.impl;

import com.japhone.demo.annotation.handle.HandlerUpDownLevelConditionType;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.pattern.strategy.user.value.AbstractValueUpDownStrategy;
import org.springframework.stereotype.Component;

/**
 * created by liukai on 2020-07-03
 * 结算额度升降级策略
 */
@Component
@HandlerUpDownLevelConditionType(LevelConditionEnum.SETTLEMENT_VALUE)
public class SettlementValueUpDownStrategy extends AbstractValueUpDownStrategy {
    @Override
    public Integer getValue(Long userId) {
        //查询该用户的结算额度
        return 50000;
    }
}
