package com.japhone.demo.model.entity;

import java.io.Serializable;

/**
 * created by japhone on 2020-07-31
 */
public class UserUpDownLevelConfig implements Serializable {

    /**主键**/
    private Long id;

    /**源级别编码**/
    private Integer srcLevelCode;

    /**源级别名称**/
    private String srcLevelName;

    /**目标级别编码**/
    private Integer targetLevelCode;

    /**目标级别名称**/
    private String targetLevelName;

    /**条件编码**/
    private Integer conditionCode;

    /**条件名称**/
    private String conditionName;

    /**条件值**/
    private String conditionValue;

    /**描述**/
    private String description;

    /**升降级标识1.升级，2.降级**/
    private Integer upDownFlag;

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

    public Integer getUpDownFlag() {
        return upDownFlag;
    }

    public void setUpDownFlag(Integer upDownFlag) {
        this.upDownFlag = upDownFlag;
    }

    @Override
    public String toString() {
        return "UserUpDownLevelConfig{" +
                "id=" + id +
                ", srcLevelCode=" + srcLevelCode +
                ", srcLevelName='" + srcLevelName + '\'' +
                ", targetLevelCode=" + targetLevelCode +
                ", targetLevelName='" + targetLevelName + '\'' +
                ", conditionCode=" + conditionCode +
                ", conditionName='" + conditionName + '\'' +
                ", conditionValue='" + conditionValue + '\'' +
                ", description='" + description + '\'' +
                ", upDownFlag=" + upDownFlag +
                '}';
    }
}
