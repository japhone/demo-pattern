package com.japhone.demo.pattern.strategy.user.amount;

import com.japhone.demo.model.entity.User;
import com.japhone.demo.model.entity.UserUpDownLevelConfig;
import com.japhone.demo.model.enums.LevelUpDownFlagEnum;
import com.japhone.demo.pattern.strategy.IUpDownStrategy;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * created by japhone on 2020-07-03
 * 消费、销售、结算额度升降级策略
 */
public abstract class AbstractAmountUpDownStrategy implements IUpDownStrategy {

    Logger logger = LoggerFactory.getLogger(AbstractAmountUpDownStrategy.class);

    @Override
    public boolean check(User userBo, UserUpDownLevelConfig config) {
        //升降级条件值
        String conditionValue = config.getConditionValue();

        if (StringUtils.isBlank(conditionValue)) {
            logger.info("升降级条件异常，升降级条件值为空，id:{}", config.getId());
            return false;
        }

        BigDecimal value = getValue(userBo.getId());

        if (config.getUpDownFlag().compareTo(LevelUpDownFlagEnum.UP_FLAG.getCode()) == 0){//升级条件
            if(value.compareTo(BigDecimal.valueOf(Integer.valueOf(conditionValue))) >= 0) {
                return true;
            }else{
                return false;
            }
        }else if(config.getUpDownFlag().compareTo(LevelUpDownFlagEnum.DOWN_FLAG.getCode()) == 0){//降级条件
            if(value.compareTo(BigDecimal.valueOf(Integer.valueOf(conditionValue))) < 0) {
                return true;
            }else{
                return false;
            }
        }
        throw new RuntimeException("未知的升降级标识");
    }

    /**
     * 查询用户额度，由其子类实现
     * @param userId
     * @return
     */
    public abstract BigDecimal getValue(Long userId);

}
