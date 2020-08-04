package com.japhone.demo.mapper;

import com.japhone.demo.model.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * created by japhone on 2020-07-31
 */
public interface UserMapper {

    User get(Long id);

    int countSameLevelNum(@Param("userCode") String userCode, @Param("levelCode") Integer levelCode);

    void insert(User user);

    void update(User user);
}
