/*
Navicat MySQL Data Transfer

Source Server         : localDB
Source Server Version : 50149
Source Host           : localhost:3306
Source Database       : mioa

Target Server Type    : MYSQL
Target Server Version : 50149
File Encoding         : 65001

Date: 2017-12-19 22:58:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_user_menu`;
CREATE TABLE `t_user_menu` (
  `userid` varchar(36) NOT NULL COMMENT '用户ID',
  `menuid` varchar(36) NOT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
