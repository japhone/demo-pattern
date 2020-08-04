package com.japhone.demo.pattern.strategy.user.amount.impl;

import com.japhone.demo.annotation.handle.HandlerUpDownLevelConditionType;
import com.japhone.demo.model.entity.UserAmount;
import com.japhone.demo.model.enums.AmountTypeEnum;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.pattern.strategy.user.amount.AbstractAmountUpDownStrategy;
import com.japhone.demo.service.UserAmountService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * created by japhone on 2020-07-03
 * 结算额度升降级策略
 */
@Component
@HandlerUpDownLevelConditionType(LevelConditionEnum.SETTLEMENT_AMOUNT)
public class SettlementAmountUpDownStrategy extends AbstractAmountUpDownStrategy {
    @Resource
    private UserAmountService userAmountService;

    @Override
    public BigDecimal getValue(Long userId) {
        /**
         * 自己实现业务逻辑
         * 从数据库中检索当前用户的消费额
         */
        UserAmount userAmount = userAmountService.queryByUserIdAndAmountType(userId, AmountTypeEnum.SETTLEMENT_VALUE.getCode());

        if(userAmount == null) return BigDecimal.ZERO;
        return userAmount.getAmount();
    }
}
