/*
Navicat MySQL Data Transfer

Source Server         : localDB
Source Server Version : 50149
Source Host           : localhost:3306
Source Database       : mioa

Target Server Type    : MYSQL
Target Server Version : 50149
File Encoding         : 65001

Date: 2017-12-19 22:57:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '模块名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
