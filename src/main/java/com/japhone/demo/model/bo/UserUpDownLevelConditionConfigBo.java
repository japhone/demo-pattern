package com.japhone.demo.model.bo;

import java.io.Serializable;

/**
 * created by liukai on 2020-07-03
 * 升降级条件业务类
 */
public class UserUpDownLevelConditionConfigBo implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 源级别编码
     */
    private Integer srcLevelCode;

    /**
     * 源级别名称
     */
    private String srcLevelName;

    /**
     * 目标级别编码
     */
    private Integer targetLevelCode;

    /**
     * 目标级别名称
     */
    private String targetLevelName;

    /**
     * 升降级标识：1-升级、2-降级
     */
    private Integer upDownFlag;

    /**
     * 条件编码
     */
    private Integer conditionCode;

    /**
     * 条件名称
     */
    private String conditionName;

    /**
     * 条件值
     */
    private String conditionValue;

    /**
     * 描述
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSrcLevelCode() {
        return srcLevelCode;
    }

    public void setSrcLevelCode(Integer srcLevelCode) {
        this.srcLevelCode = srcLevelCode;
    }

    public String getSrcLevelName() {
        return srcLevelName;
    }

    public void setSrcLevelName(String srcLevelName) {
        this.srcLevelName = srcLevelName;
    }

    public Integer getTargetLevelCode() {
        return targetLevelCode;
    }

    public void setTargetLevelCode(Integer targetLevelCode) {
        this.targetLevelCode = targetLevelCode;
    }

    public String getTargetLevelName() {
        return targetLevelName;
    }

    public void setTargetLevelName(String targetLevelName) {
        this.targetLevelName = targetLevelName;
    }

    public Integer getUpDownFlag() {
        return upDownFlag;
    }

    public void setUpDownFlag(Integer upDownFlag) {
        this.upDownFlag = upDownFlag;
    }

    public Integer getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(Integer conditionCode) {
        this.conditionCode = conditionCode;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
