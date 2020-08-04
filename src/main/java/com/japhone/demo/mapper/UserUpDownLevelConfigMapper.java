package com.japhone.demo.mapper;

import com.japhone.demo.model.entity.UserUpDownLevelConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by japhone on 2020-07-31
 */
public interface UserUpDownLevelConfigMapper {

    List<UserUpDownLevelConfig> list(@Param("userUpDownLevelConfig")UserUpDownLevelConfig userUpDownLevelConfig);

}
