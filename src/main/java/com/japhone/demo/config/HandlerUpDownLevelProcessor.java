package com.japhone.demo.config;

import com.japhone.demo.annotation.handle.HandlerUpDownLevelConditionType;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.pattern.strategy.IUpDownStrategy;
import com.japhone.demo.pattern.strategy.UpDownLevelContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * created by japhone on 2020-06-16
 * 根据升降级条件类型，初始化HandlerUpDownLevelContext
 * 建立升降级条件类型与策略类的对应关系
 */
@Component
public class HandlerUpDownLevelProcessor implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        /**获取所有策略类**/
        Map<String, Object> upDownConditionStrategyMap = applicationContext.getBeansWithAnnotation(HandlerUpDownLevelConditionType.class);

        upDownConditionStrategyMap.forEach((k, v) -> {
            Class<IUpDownStrategy> upDownConditionStrategyClass = (Class<IUpDownStrategy>) v.getClass();
            LevelConditionEnum type = upDownConditionStrategyClass.getAnnotation(HandlerUpDownLevelConditionType.class).value();

            /**将class加入map中, type作为key**/
            UpDownLevelContext.upDownConditionStrategyMap.put(type.getCode(), upDownConditionStrategyClass);
        });
    }
}
