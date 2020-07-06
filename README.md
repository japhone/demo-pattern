# demo-pattern
# 描述
# 应用实例
```mermaid
graph LR
common(普通会员)
vip(VIP)
special(特约店)
gold(金牌店)

common --消费成长值满1000--> vip 
vip --销售成长值满5000--> special 
vip --vip粉丝数满10--> special
special --结算成长值满10000--> gold
special --特约店粉丝数满50-->gold
```