package com.japhone.demo.pattern.strategy.user.value;

import com.japhone.demo.model.bo.UserBo;
import com.japhone.demo.model.bo.UserUpDownLevelConditionConfigBo;
import com.japhone.demo.model.enums.LevelUpDownFlagEnum;
import com.japhone.demo.pattern.strategy.IUpDownStrategy;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created by liukai on 2020-07-03
 * 消费、销售、结算额度升降级策略
 */
public abstract class AbstractValueUpDownStrategy implements IUpDownStrategy {

    Logger logger = LoggerFactory.getLogger(AbstractValueUpDownStrategy.class);

    @Override
    public boolean check(UserBo userBo, UserUpDownLevelConditionConfigBo conditionConfig) {
        //升降级条件值
        String conditionValue = conditionConfig.getConditionValue();

        if (StringUtils.isBlank(conditionValue)) {
            logger.info("升降级条件异常，升降级条件值为空，id:{}", conditionConfig.getId());
            return false;
        }

        Integer value = getValue(userBo.getId());

        if (conditionConfig.getUpDownFlag().compareTo(LevelUpDownFlagEnum.UP_FLAG.getCode()) == 0){//升级条件
            if(value.compareTo(Integer.valueOf(conditionValue)) >= 0) {
                return true;
            }else{
                return false;
            }
        }else if(conditionConfig.getUpDownFlag().compareTo(LevelUpDownFlagEnum.DOWN_FLAG.getCode()) == 0){//降级条件
            if(value.compareTo(Integer.valueOf(conditionValue)) < 0) {
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
    public abstract Integer getValue(Long userId);

}
