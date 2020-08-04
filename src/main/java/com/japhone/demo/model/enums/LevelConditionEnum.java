package com.japhone.demo.model.enums;

/**
 * created by japhone on 2020-04-15
 * 升降级条件
 */
public enum LevelConditionEnum {

    /**
     * 消费累计额度
     */
    CONSUMPTION_AMOUNT(2010, "消费累计额度"),
    /**
     * 结算累计额度
     */
    SETTLEMENT_AMOUNT(2020, "结算累计额度"),
    /**
     * 同级以上用户数
     */
    SAME_UP_LEVEL_NUM(2030, "同级以上用户数"),
    /**
     * 销售累计额度
     */
    SALES_AMOUNT(2040, "销售累计额度"),
    /**
     * 根据商品标识
     */
    GOODS_FLAG(2050, "商品标识");

    private Integer code;

    private String description;

    LevelConditionEnum(Integer code, String description) {
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
