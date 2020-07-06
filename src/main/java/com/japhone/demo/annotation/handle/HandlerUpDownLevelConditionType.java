package com.japhone.demo.annotation.handle;

import com.japhone.demo.model.enums.LevelConditionEnum;

import java.lang.annotation.*;

/**
 * created by liukai on 2020-06-16
 * 自定义策略类型
 */
@Target(ElementType.TYPE)  //作用在类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited  //子类可以继承此注解
public @interface HandlerUpDownLevelConditionType {

    /**
     * 策略类型
     * @return
     */
    LevelConditionEnum value();

}
