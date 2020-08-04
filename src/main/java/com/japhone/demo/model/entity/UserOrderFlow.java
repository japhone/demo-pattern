package com.japhone.demo.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * created by japhone on 2020-08-03
 */
public class UserOrderFlow implements Serializable {

    /**主键**/
    private Long id;

    /**用户ID**/
    private Long userId;

    /**订单编号**/
    private String orderNo;

    /**流水类型1-正向单、2-逆向单、3-结算单**/
    private Integer flowType;

    /**实际支付金额**/
    private BigDecimal amount;

    /**支付时间**/
    private Date paymentTime;

    /**结算单编号**/
    private String settlementNo;

    /**结算时间**/
    private Date settlementTime;

    /**退款单号**/
    private String refundNo;

    /**退款时间**/
    private Date refundTime;

    /**礼包标识0-普通商品、1-礼包、2-大礼包**/
    private Integer packageFlag;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getFlowType() {
        return flowType;
    }

    public void setFlowType(Integer flowType) {
        this.flowType = flowType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getSettlementNo() {
        return settlementNo;
    }

    public void setSettlementNo(String settlementNo) {
        this.settlementNo = settlementNo;
    }

    public Date getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(Date settlementTime) {
        this.settlementTime = settlementTime;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Integer getPackageFlag() {
        return packageFlag;
    }

    public void setPackageFlag(Integer packageFlag) {
        this.packageFlag = packageFlag;
    }

    @Override
    public String toString() {
        return "UserOrderFlow{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderNo='" + orderNo + '\'' +
                ", flowType=" + flowType +
                ", amount=" + amount +
                ", paymentTime=" + paymentTime +
                ", settlementNo='" + settlementNo + '\'' +
                ", settlementTime=" + settlementTime +
                ", refundNo='" + refundNo + '\'' +
                ", refundTime=" + refundTime +
                ", packageFlag=" + packageFlag +
                '}';
    }
}
