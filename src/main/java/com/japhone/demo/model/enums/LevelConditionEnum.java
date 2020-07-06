package com.japhone.demo.model.enums;

/**
 * created by liukai on 2020-04-15
 * 升降级条件
 */
public enum LevelConditionEnum {

    /**
     * 消费累计成长值
     */
    CONSUMPTION_GROWTH_VALUE(2010, "消费累计成长值"),
    /**
     * 结算累计成长值
     */
    SETTLEMENT_GROWTH_VALUE(2020, "结算累计成长值"),
    /**
     * 同级以上用户数
     */
    SAME_UP_LEVEL_NUM(2030, "同级以上用户数"),
    /**
     * 销售累计成长值
     */
    SALES_GROWTH_VALUE(2040, "销售累计成长值"),

    /**
     * 根据商品标识
     */
    GOODS_FLAG(2050, "商品标识");

    private Integer code;

    private String desc;

    LevelConditionEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
