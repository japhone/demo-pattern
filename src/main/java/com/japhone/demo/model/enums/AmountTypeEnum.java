package com.japhone.demo.model.enums;

/**
 * created by japhone on 2020-08-03
 */
public enum AmountTypeEnum {

    /**
     * 消费累计额度
     */
    CONSUMPTION(1, "消费累计额度"),
    /**
     * 销售累计额度
     */
    SALES_VALUE(2, "销售累计额度"),
    /**
     * 结算累计额度
     */
    SETTLEMENT_VALUE(3, "结算累计额度");

    private Integer code;

    private String description;

    AmountTypeEnum(Integer code, String description){
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
