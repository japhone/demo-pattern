package com.japhone.demo.service.impl;

import com.japhone.demo.mapper.UserUpDownLevelConfigMapper;
import com.japhone.demo.model.entity.UserUpDownLevelConfig;
import com.japhone.demo.service.UserUpDownLevelConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by japhone on 2020-07-31
 */
@Service
public class UserUpDownLevelConfigServiceImpl implements UserUpDownLevelConfigService {

    @Resource
    private UserUpDownLevelConfigMapper userUpDownLevelConfigMapper;

    @Override
    public List<UserUpDownLevelConfig> list(UserUpDownLevelConfig userUpDownLevelConfig) {
        return userUpDownLevelConfigMapper.list(userUpDownLevelConfig);
    }
}
