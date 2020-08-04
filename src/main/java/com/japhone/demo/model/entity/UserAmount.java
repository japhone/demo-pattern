package com.japhone.demo.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * created by japhone on 2020-07-31
 */
public class UserAmount implements Serializable {

    /**主键**/
    private Long id;

    /**用户ID**/
    private Long userId;

    /**额度类型：1-消费额、2-销售额、3-结算额**/
    private Integer amountType;

    /**额度**/
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAmountType() {
        return amountType;
    }

    public void setAmountType(Integer amountType) {
        this.amountType = amountType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "UserAmount{" +
                "id=" + id +
                ", userId=" + userId +
                ", amountType=" + amountType +
                ", amount=" + amount +
                '}';
    }
}
