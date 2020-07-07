package com.japhone.demo.pattern.strategy.user.value.impl;

import com.japhone.demo.annotation.handle.HandlerUpDownLevelConditionType;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.pattern.strategy.user.value.AbstractValueUpDownStrategy;
import org.springframework.stereotype.Component;

/**
 * created by japhone on 2020-07-03
 * 消费额度升降级策略
 */
@Component
@HandlerUpDownLevelConditionType(LevelConditionEnum.CONSUMPTION_VALUE)
public class ConsumeValueUpDownStrategy extends AbstractValueUpDownStrategy {

    @Override
    public Integer getValue(Long userId) {
        /**
         * 自己实现业务逻辑
         * 从数据库中检索当前用户的消费额
         */
        return 10000;
    }
}
