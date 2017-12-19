/*
Navicat MySQL Data Transfer

Source Server         : localDB
Source Server Version : 50149
Source Host           : localhost:3306
Source Database       : mioa

Target Server Type    : MYSQL
Target Server Version : 50149
File Encoding         : 65001

Date: 2017-12-19 23:06:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '群组名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `dissolve_time` datetime DEFAULT NULL COMMENT '解散时间',
  `state` tinyint(4) DEFAULT NULL COMMENT '群组状态0正常 1解散'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
