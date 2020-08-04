package com.japhone.demo.pattern.strategy;

import com.japhone.demo.model.entity.User;
import com.japhone.demo.model.entity.UserUpDownLevelConfig;

/**
 * created by japhone on 2020-07-03
 * 升降级策略类
 */
public interface IUpDownStrategy {

    /**
     * 检查是否满足升降级条件
     * @param user 当前用户
     * @param config 升降级条件
     * @return
     */
    boolean check(User user, UserUpDownLevelConfig config);

}
