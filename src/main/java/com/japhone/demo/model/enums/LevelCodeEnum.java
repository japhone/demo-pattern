package com.japhone.demo.model.enums;

/**
 * created by japhone on 2020-07-07
 */
public enum  LevelCodeEnum {

    USER(1010, "会员"),
    VIP(1020, "VIP"),
    SPECIAL(1030, "特约店"),
    GOLD(1040, "金牌店");

    private Integer code;

    private String description;

    LevelCodeEnum(Integer code, String description){
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
