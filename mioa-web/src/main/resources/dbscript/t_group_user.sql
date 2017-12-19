/*
Navicat MySQL Data Transfer

Source Server         : localDB
Source Server Version : 50149
Source Host           : localhost:3306
Source Database       : mioa

Target Server Type    : MYSQL
Target Server Version : 50149
File Encoding         : 65001

Date: 2017-12-19 23:06:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_group_user
-- ----------------------------
DROP TABLE IF EXISTS `t_group_user`;
CREATE TABLE `t_group_user` (
  `groupid` varchar(36) NOT NULL COMMENT '群组ID',
  `userid` varchar(36) NOT NULL COMMENT '用户ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
