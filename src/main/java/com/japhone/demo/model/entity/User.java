package com.japhone.demo.model.entity;

import java.io.Serializable;

/**
 * created by japhone on 2020-07-31
 */
public class User implements Serializable {

    /**主键**/
    private Long id;

    /**用户名**/
    private String name;

    /**级别编码**/
    private Integer levelCode;

    /**级别名称**/
    private String levelName;

    /**用户邀请码**/
    private String userCode;

    /**邀请人邀请码**/
    private String recommendUserCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRecommendUserCode() {
        return recommendUserCode;
    }

    public void setRecommendUserCode(String recommendUserCode) {
        this.recommendUserCode = recommendUserCode;
    }

    @Override
    public String toString() {
        return "id:" + id + ", name:" + name + ", levelCode:"+levelCode + ", levelName:"+levelName + ", userCode:" + userCode + ", recommendUserCode:"+recommendUserCode;
    }
}
