package com.japhone.demo.pattern.strategy;

import com.japhone.demo.model.entity.User;
import com.japhone.demo.model.entity.UserUpDownLevelConfig;
import com.japhone.demo.model.enums.LevelConditionEnum;
import com.japhone.demo.pattern.strategy.goods.impl.GoodsUpDownStrategy;
import com.japhone.demo.pattern.strategy.user.amount.impl.ConsumeAmountUpDownStrategy;
import com.japhone.demo.pattern.strategy.user.amount.impl.SaleAmountUpDownStrategy;
import com.japhone.demo.pattern.strategy.user.amount.impl.SettlementAmountUpDownStrategy;
import com.japhone.demo.pattern.strategy.user.level.impl.UserLevelUpDownStrategy;
import com.japhone.demo.service.UserService;
import com.japhone.demo.service.UserUpDownLevelConfigService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by japhone on 2020-07-06
 */
@SpringBootTest
public class StrategyTest {

    private Logger logger = LoggerFactory.getLogger(StrategyTest.class);

    @Resource
    private UpDownLevelContext upDownLevelContext;
    @Resource
    private UserService userService;
    @Resource
    private UserUpDownLevelConfigService userUpDownLevelConfigService;
    @Resource
    private ConsumeAmountUpDownStrategy consumeAmountUpDownStrategy;
    @Resource
    private SaleAmountUpDownStrategy saleAmountUpDownStrategy;
    @Resource
    private SettlementAmountUpDownStrategy settlementAmountUpDownStrategy;
    @Resource
    private GoodsUpDownStrategy goodsUpDownStrategy;
    @Resource
    private UserLevelUpDownStrategy userLevelUpDownStrategy;

    @Test
    public void testUp(){
        Long userId = 2l;
        User user = userService.get(userId);

        IUpDownStrategy upDownStrategy;

        UserUpDownLevelConfig userUpDownLevelConfig = new UserUpDownLevelConfig();
        userUpDownLevelConfig.setSrcLevelCode(user.getLevelCode());
        List<UserUpDownLevelConfig> list = userUpDownLevelConfigService.list(userUpDownLevelConfig);
        boolean b = false;
        if(list != null && list.size() > 0){
            for(UserUpDownLevelConfig config : list){
                upDownStrategy = upDownLevelContext.getStrategy(config.getConditionCode());

                logger.info("upDownStrategy: {}", upDownStrategy);

                b = upDownStrategy.check(user, config);
                if(b){
                    logger.info("用户ID:{}，满足升降条件:{}", user.getId(), config);
                    user.setLevelCode(config.getTargetLevelCode());
                    user.setLevelName(config.getTargetLevelName());

                    userService.save(user);
                    break;
                }
            }
        }
        if(b) {
            logger.info("用户:{}，升级后的级别为:{}({})", user.getId(), user.getLevelName(), user.getLevelCode());
        }else{
            logger.info("用户:{}，不满足升级条件", user.getId());
        }
    }

    @Test
    public void test(){
        Long userId = 1l;
        User user = userService.get(userId);

        IUpDownStrategy upDownStrategy;

        UserUpDownLevelConfig userUpDownLevelConfig = new UserUpDownLevelConfig();
        userUpDownLevelConfig.setSrcLevelCode(user.getLevelCode());
        List<UserUpDownLevelConfig> list = userUpDownLevelConfigService.list(userUpDownLevelConfig);
        boolean b = false;
        if(list != null && list.size() > 0){
            for(UserUpDownLevelConfig config : list){

                if(config.getConditionCode().compareTo(LevelConditionEnum.CONSUMPTION_AMOUNT.getCode()) == 0) {
                    upDownStrategy = consumeAmountUpDownStrategy;
                }else if(config.getConditionCode().compareTo(LevelConditionEnum.SALES_AMOUNT.getCode()) == 0) {
                    upDownStrategy = saleAmountUpDownStrategy;
                }else if(config.getConditionCode().compareTo(LevelConditionEnum.SETTLEMENT_AMOUNT.getCode()) == 0) {
                    upDownStrategy = settlementAmountUpDownStrategy;
                }else if(config.getConditionCode().compareTo(LevelConditionEnum.GOODS_FLAG.getCode()) == 0) {
                    upDownStrategy = goodsUpDownStrategy;
                }else if(config.getConditionCode().compareTo(LevelConditionEnum.SAME_UP_LEVEL_NUM.getCode()) == 0) {
                    upDownStrategy = userLevelUpDownStrategy;
                }else{
                    logger.info("没有对应的升降级类型");
                    continue;
                }

                logger.info("upDownStrategy: {}", upDownStrategy);

                b = upDownStrategy.check(user, config);
                if(b){
                    logger.info("用户ID:{}，满足升降条件:{}", user.getId(), config);
                    user.setLevelCode(config.getTargetLevelCode());
                    user.setLevelName(config.getTargetLevelName());

                    userService.save(user);
                    break;
                }
            }
        }
        if(b) {
            logger.info("用户:{}，升级后的级别为:{}({})", user.getId(), user.getLevelName(), user.getLevelCode());
        }else{
            logger.info("用户:{}，不满足升级条件", user.getId());
        }
    }

}
