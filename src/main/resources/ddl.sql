/*
 Navicat MySQL Data Transfer

 Source Server         : 172.16.87.131
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 172.16.87.131:3306
 Source Schema         : demo_pattern

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 04/08/2020 20:50:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '用户名',
  `level_code` int(4) NOT NULL DEFAULT '1001' COMMENT '等级编码(1001会员、1002VIP、1003特约店、1004金牌店)',
  `level_name` varchar(45) NOT NULL DEFAULT '会员' COMMENT '等级名称',
  `user_code` varchar(8) NOT NULL DEFAULT '' COMMENT '邀请码',
  `recommend_user_code` varchar(8) NOT NULL DEFAULT '' COMMENT '邀请人邀请码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '萧峰', 1001, '会员', '10000001', '0');
INSERT INTO `user` VALUES (2, '段誉', 1002, 'VIP', '10000002', '10000001');
INSERT INTO `user` VALUES (3, '郭靖', 1002, 'VIP', '10000003', '10000001');
INSERT INTO `user` VALUES (4, '杨康', 1002, 'VIP', '10000004', '10000001');
COMMIT;

-- ----------------------------
-- Table structure for user_amount
-- ----------------------------
DROP TABLE IF EXISTS `user_amount`;
CREATE TABLE `user_amount` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `amount_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '额度类型：1-消费额、2-销售额、3-结算额',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '额度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_amount
-- ----------------------------
BEGIN;
INSERT INTO `user_amount` VALUES (1, 1, 1, 500.00);
INSERT INTO `user_amount` VALUES (2, 1, 2, 600.00);
INSERT INTO `user_amount` VALUES (3, 1, 3, 100.00);
INSERT INTO `user_amount` VALUES (4, 2, 1, 1300.00);
INSERT INTO `user_amount` VALUES (5, 2, 2, 300.00);
INSERT INTO `user_amount` VALUES (6, 2, 3, 0.00);
COMMIT;

-- ----------------------------
-- Table structure for user_order_flow
-- ----------------------------
DROP TABLE IF EXISTS `user_order_flow`;
CREATE TABLE `user_order_flow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单编号',
  `flow_type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '流水类型1-正向单、2-逆向单、3-结算单',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单实际支付金额',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `settlement_no` varchar(20) NOT NULL DEFAULT '' COMMENT '结算单编号',
  `settlement_time` datetime DEFAULT NULL COMMENT '结算时间',
  `refund_no` varchar(20) NOT NULL DEFAULT '' COMMENT '退款单编号',
  `refund_time` datetime DEFAULT NULL COMMENT '退款时间',
  `package_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '礼包标识0-普通商品、1-礼包、2-大礼包',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_order_flow
-- ----------------------------
BEGIN;
INSERT INTO `user_order_flow` VALUES (1, 1, '202008010001', 1, 100.00, '2020-08-01 09:10:10', '', NULL, '', NULL, 2);
INSERT INTO `user_order_flow` VALUES (2, 1, '202008010002', 1, 100.00, '2020-08-01 10:10:10', '', NULL, '', NULL, 2);
INSERT INTO `user_order_flow` VALUES (3, 1, '202008010003', 1, 200.00, '2020-08-01 11:10:10', '', NULL, '', NULL, 1);
INSERT INTO `user_order_flow` VALUES (4, 1, '202008010002', 2, 100.00, '2020-08-01 12:10:10', '', NULL, '', NULL, 2);
COMMIT;

-- ----------------------------
-- Table structure for user_up_down_level_config
-- ----------------------------
DROP TABLE IF EXISTS `user_up_down_level_config`;
CREATE TABLE `user_up_down_level_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `src_level_code` int(4) NOT NULL DEFAULT '0' COMMENT '源级别编码',
  `src_level_name` varchar(45) NOT NULL DEFAULT '' COMMENT '源级别名称',
  `target_level_code` int(4) NOT NULL DEFAULT '0' COMMENT '目标级别编码',
  `target_level_name` varchar(45) NOT NULL DEFAULT '' COMMENT '目标级别名称',
  `condition_code` int(4) NOT NULL DEFAULT '0' COMMENT '条件编码',
  `condition_name` varchar(45) NOT NULL DEFAULT '' COMMENT '条件名称',
  `condition_value` varchar(45) NOT NULL DEFAULT '' COMMENT '条件值',
  `description` varchar(45) NOT NULL DEFAULT '' COMMENT '描述',
  `up_down_flag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '升降级标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_up_down_level_config
-- ----------------------------
BEGIN;
INSERT INTO `user_up_down_level_config` VALUES (1, 1001, '会员', 1002, 'VIP', 2010, '消费额', '1000', '会员升VIP', 1);
INSERT INTO `user_up_down_level_config` VALUES (2, 1001, '会员', 1002, 'VIP', 2050, '礼包', '2', '会员升VIP', 1);
INSERT INTO `user_up_down_level_config` VALUES (3, 1002, 'VIP', 1003, '特约店', 2040, '销售额', '5000', 'VIP升特约店', 1);
INSERT INTO `user_up_down_level_config` VALUES (4, 1002, 'VIP', 1003, '特约店', 2030, '同级用户数', '3', 'VIP升特约店', 1);
INSERT INTO `user_up_down_level_config` VALUES (5, 1003, '特约店', 1004, '金牌店', 2020, '结算额', '10000', '特约店升金牌店', 1);
INSERT INTO `user_up_down_level_config` VALUES (6, 1003, '特约店', 1004, '金牌店', 2030, '同级用户数', '5', '特约店升金牌店', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
