package com.japhone.demo.pattern.strategy.user.level.impl;

import com.japhone.demo.annotation.handle.HandlerUpDownLevelConditionType;
import com.japhone.demo.model.entity.User;
import com.japhone.demo.model.entity.UserUpDownLevelConfig;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.model.enums.LevelUpDownFlagEnum;
import com.japhone.demo.pattern.strategy.user.level.IUserLevelUpDownStrategy;
import com.japhone.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * created by japhone on 2020-07-03
 * 用户同级别粉丝数升降级策略
 */
@Component
@HandlerUpDownLevelConditionType(LevelConditionEnum.SAME_UP_LEVEL_NUM)
public class UserLevelUpDownStrategy implements IUserLevelUpDownStrategy {

    Logger logger = LoggerFactory.getLogger(UserLevelUpDownStrategy.class);

    @Resource
    private UserService userService;

    @Override
    public boolean check(User user, UserUpDownLevelConfig config) {

        //升级条件值
        String conditionValue = config.getConditionValue();
        if(StringUtils.isBlank(conditionValue)) {
            logger.info("升降级异常，升降级条件值为空，id:{}", config.getId());
            return false;
        }

        /**
         * 检查与当前用户同级别的邀请用户个数
         */
        int num = getRecommendUser(user.getUserCode(), user.getLevelCode());
        if (config.getUpDownFlag().compareTo(LevelUpDownFlagEnum.UP_FLAG.getCode()) == 0){//升级条件
            if(num < Integer.valueOf(conditionValue).intValue()) {
                return false;
            }else {
                return true;
            }
        }else if(config.getUpDownFlag().compareTo(LevelUpDownFlagEnum.DOWN_FLAG.getCode()) == 0){//降级条件
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
     * @param userCode 当前用户邀请码
     * @param levelCode 当前用户级别编码
     * @return
     */
    private int getRecommendUser(String userCode, Integer levelCode) {
        /**
         * num 业务实现查询当前用户同级别的邀请用户的个数
         */
        return userService.countSameLevelNum(userCode, levelCode);
    }
}
