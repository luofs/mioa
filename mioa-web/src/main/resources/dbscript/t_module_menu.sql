/*
Navicat MySQL Data Transfer

Source Server         : localDB
Source Server Version : 50149
Source Host           : localhost:3306
Source Database       : mioa

Target Server Type    : MYSQL
Target Server Version : 50149
File Encoding         : 65001

Date: 2017-12-19 22:58:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_module_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_module_menu`;
CREATE TABLE `t_module_menu` (
  `moduleid` varchar(36) DEFAULT NULL COMMENT '模块ID',
  `menuid` varchar(36) DEFAULT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
