package com.japhone.demo.model.bo;

import java.io.Serializable;

/**
 * created by liukai on 2020-07-03
 */
public class UserBo implements Serializable {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户级别
     */
    private Integer levelCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode) {
        this.levelCode = levelCode;
    }
}
