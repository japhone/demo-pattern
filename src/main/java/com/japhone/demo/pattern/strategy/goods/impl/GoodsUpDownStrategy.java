package com.japhone.demo.pattern.strategy.goods.impl;

import com.japhone.demo.annotation.handle.HandlerUpDownLevelConditionType;
import com.japhone.demo.model.bo.UserBo;
import com.japhone.demo.model.bo.UserUpDownLevelConditionConfigBo;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.model.enums.LevelUpDownFlagEnum;
import com.japhone.demo.pattern.strategy.goods.IGoodsUpDownStrategy;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * created by liukai on 2020-07-03
 * 特殊商品升降级策略
 */
@Component
@HandlerUpDownLevelConditionType(LevelConditionEnum.GOODS_FLAG)
public class GoodsUpDownStrategy implements IGoodsUpDownStrategy {

    Logger logger = LoggerFactory.getLogger(GoodsUpDownStrategy.class);

    @Override
    public boolean check(UserBo userBo, UserUpDownLevelConditionConfigBo conditionConfig) {
        //升降级条件值
        String conditionValue = conditionConfig.getConditionValue();

        if (StringUtils.isBlank(conditionValue)) {
            logger.info("升降级条件异常，升降级条件值为空，id:{}", conditionConfig.getId());
            return false;
        }

        int num = countPackFlagOrder(userBo.getId(), conditionValue);

        if (conditionConfig.getUpDownFlag().compareTo(LevelUpDownFlagEnum.UP_FLAG.getCode()) == 0) {//升级条件
            if (num > 0) {
                return true;
            } else {
                return false;
            }
        }else if(conditionConfig.getUpDownFlag().compareTo(LevelUpDownFlagEnum.DOWN_FLAG.getCode()) == 0){//降级条件
            if (num > 0) {
                return false;
            } else {
                return true;
            }
        }
        throw new RuntimeException("未知的升降级标识");
    }

    /**
     * 查询用户是否购买了某类特殊商品
     * 特殊商品的标识与升降级条件中的conditionValue相同
     * @param id
     * @param conditionValue
     * @return
     */
    private int countPackFlagOrder(Long id, String conditionValue) {
        return 0;
    }

}
