package com.japhone.demo.pattern.strategy.user.level.impl;

import com.japhone.demo.annotation.handle.HandlerUpDownLevelConditionType;
import com.japhone.demo.model.bo.UserBo;
import com.japhone.demo.model.bo.UserUpDownLevelConditionConfigBo;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.model.enums.LevelUpDownFlagEnum;
import com.japhone.demo.pattern.strategy.user.level.IUserLevelUpDownStrategy;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * created by japhone on 2020-07-03
 * 用户同级别粉丝数升降级策略
 */
@Component
@HandlerUpDownLevelConditionType(LevelConditionEnum.SAME_UP_LEVEL_NUM)
public class UserLevelUpDownStrategy implements IUserLevelUpDownStrategy {

    Logger logger = LoggerFactory.getLogger(UserLevelUpDownStrategy.class);

    @Override
    public boolean check(UserBo userBo, UserUpDownLevelConditionConfigBo conditionConfig) {

        //升级条件值
        String conditionValue = conditionConfig.getConditionValue();
        if(StringUtils.isBlank(conditionValue)) {
            logger.info("升降级异常，升降级条件值为空，id:{}", conditionConfig.getId());
            return false;
        }

        /**
         * 检查与当前用户同级别的邀请用户个数
         */
        int num = getRecommendUser(userBo.getId(), userBo.getLevelCode());
        if (conditionConfig.getUpDownFlag().compareTo(LevelUpDownFlagEnum.UP_FLAG.getCode()) == 0){//升级条件
            if(num < Integer.valueOf(conditionValue).intValue()) {
                return false;
            }else {
                return true;
            }
        }else if(conditionConfig.getUpDownFlag().compareTo(LevelUpDownFlagEnum.DOWN_FLAG.getCode()) == 0){//降级条件
            if(num < Integer.valueOf(conditionValue).intValue()) {
                return true;
            }else {
                return false;
            }
        }
        throw new RuntimeException("未知的升降级标识");
    }

    /**
     * 检查与当前用户同级别的邀请用户个数
     * @param userId 当前用户ID
     * @param levelCode 当前用户级别编码
     * @return
     */
    private int getRecommendUser(Long userId, Integer levelCode) {
        /**
         * num 业务实现查询当前用户同级别的邀请用户的个数
         */
        int num = 10;
        return num;
    }
}
