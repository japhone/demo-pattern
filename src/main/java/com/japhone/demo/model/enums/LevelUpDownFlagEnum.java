package com.japhone.demo.model.enums;

/**
 * created by liukai on 2020-07-03
 */
public enum  LevelUpDownFlagEnum {
    /**
     * 升级
     */
    UP_FLAG(1, "升级"),
    /**
     * 降级
     */
    DOWN_FLAG(2, "降级");

    private Integer code;
    private String description;
    LevelUpDownFlagEnum(int code, String description){
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
}
