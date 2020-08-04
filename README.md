# demo-pattern
# 1.描述
    策略模式（Strategy Pattern），通俗的讲，一个问题有多种解法即策略模式。
    策略模式属于行为型模式，一个类的行为或其算法可以在运行时更改。
# 2.应用实例
## 2.1.用户级别
    会员 --> VIP --> 特约店 --> 金牌店
## 2.2.升级规则
    1)会员升VIP：
        消费额满1000 或 购买礼包商品
    2)VIP升特约店
        销售额满5000 或 邀请10个VIP级别的用户
    3)特约店升金牌店
        结算额满10000 或 邀请50个特约店级别的用户
# 3.数据库
## 3.1.用户表

表名：user

| 字段                | 类型    | 描述         | 备注                                      |
| ------------------- | ------- | ------------ | ----------------------------------------- |
| id                  | bigint  | 主键         |                                           |
| name                | varchar | 用户名       |                                           |
| level_code          | int(4)  | 等级编码     | 1001会员、1002VIP、1003特约店、1004金牌店 |
| level_name          | varchar | 等级名称     |                                           |
| user_code           | varchar | 邀请码       |                                           |
| recommend_user_code | varchar | 邀请人邀请码 |                                           |

## 3.2.用户升降级配置表

表名：user_up_down_level_config

| 字段              | 类型       | 描述         | 备注                                         |
| ----------------- | ---------- | ------------ | -------------------------------------------- |
| id                | bigint     | 主键         |                                              |
| src_level_code    | int(4)     | 源级别编码   |                                              |
| src_level_name    | varchar    | 源级别名称   |                                              |
| target_level_code | int(4)     | 目标级别编码 |                                              |
| target_level_name | varchar    | 目标级别名称 |                                              |
| condition_code    | int(4)     | 条件编码     |                                              |
| condition_name    | varchar    | 条件名称     |                                              |
| condition_value   | varchar    | 条件值       | 消费额、销售额、结算额、同级用户数、商品标识 |
| description       | varchar    | 描述         |                                              |
| up_down_flag      | tinyint(1) | 升降级标识   | 1.升级、2.降级                               |

## 3.3.用户额度表

表名：user_amount

| 字段        | 类型          | 描述     | 备注                         |
| ----------- | ------------- | -------- | ---------------------------- |
| id          | bigint        | 主键     |                              |
| user_id     | bigint        | 用户ID   |                              |
| amount_type | tinyint(1)    | 额度类型 | 1.消费额、2.销售额、3.结算额 |
| amount      | decimal(10,2) | 额度     |                              |

## 3.4.订单流水表

表名：user_order_flow

| 字段            | 类型          | 描述             | 备注                         |
| --------------- | ------------- | ---------------- | ---------------------------- |
| id              | bigint        | 主键             |                              |
| user_id         | bigint        | 用户ID           |                              |
| order_no        | varchar       | 订单编号         |                              |
| flow_type       | tinyint(1)    | 流水类型         | 1.正向单、2.逆向单、3.结算单 |
| amount          | decimal(10,2) | 订单实际支付金额 |                              |
| payment_time    | datetime      | 支付时间         |                              |
| settlement_no   | varchar       | 结算单号         |                              |
| settlement_time | datetime      | 结算日期         |                              |
| refund_no       | varchar       | 退款单号         |                              |
| refund_time     | datetime      | 退款时间         |                              |
| package_flag    | tinyint(1)    | 礼包标识         | 0.普通商品、1.礼包、2.大礼包 |

