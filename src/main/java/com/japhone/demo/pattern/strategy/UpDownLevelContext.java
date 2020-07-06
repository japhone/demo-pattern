package com.japhone.demo.pattern.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * created by liukai on 2020-06-16
 * 根据升降级类型，返回相应的策略
 */
@Component
public class UpDownLevelContext {

    @Autowired
    private ApplicationContext applicationContext;

    public static Map<Integer, Class<IUpDownStrategy>> upDownConditionStrategyMap = new HashMap<>();

    public IUpDownStrategy getStrategy(Integer type){
        Class<IUpDownStrategy> strategyClass = upDownConditionStrategyMap.get(type);

        if(strategyClass == null) {
            throw new IllegalArgumentException("没有对应的升降级类型");
        }

        return applicationContext.getBean(strategyClass);
    }

}
