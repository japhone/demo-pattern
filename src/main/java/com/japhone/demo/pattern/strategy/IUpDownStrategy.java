package com.japhone.demo.pattern.strategy;

import com.japhone.demo.model.bo.UserBo;
import com.japhone.demo.model.bo.UserUpDownLevelConditionConfigBo;

/**
 * created by liukai on 2020-07-03
 * 升降级策略类
 */
public interface IUpDownStrategy {

    /**
     * 检查是否满足升降级条件
     * @param userBo 当前用户
     * @param conditionConfig 升降级条件
     * @return
     */
    boolean check(UserBo userBo, UserUpDownLevelConditionConfigBo conditionConfig);

}
