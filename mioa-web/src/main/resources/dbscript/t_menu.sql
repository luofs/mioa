/*
Navicat MySQL Data Transfer

Source Server         : localdb
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : mioa

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-12-29 17:46:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` varchar(36) NOT NULL,
  `parentid` varchar(36) DEFAULT NULL COMMENT '父菜单ID',
  `title` varchar(18) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(16) DEFAULT NULL COMMENT '图标',
  `url` varchar(256) DEFAULT NULL COMMENT '菜单路径',
  `spread` char(1) DEFAULT NULL COMMENT '是否展开（N/Y）',
  `isdel` tinyint(4) DEFAULT '0' COMMENT '是否删除（0正常 1已删除）',
  `domain` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '0', '系统管理', '&#xe75c;', '', '0', '0', 'fs.com');
INSERT INTO `t_menu` VALUES ('10', '0', '权限管理', '&#xe807;', 'html/temp.html', '0', '0', 'fs.com');
INSERT INTO `t_menu` VALUES ('2', '0', '后台首页', '&#xe79c;', 'main.html', '0', '0', 'fs.com');
INSERT INTO `t_menu` VALUES ('3', '0', '我的面板', '&#xe9b6;', null, '1', '0', 'fs.com');
INSERT INTO `t_menu` VALUES ('4', '0', '个人信息', '&#xe689;', 'html/panel/personal.html', '0', '0', 'fs.com');
INSERT INTO `t_menu` VALUES ('5', '0', '修改密码', '&#xe7ce;', 'html/panel/password.html', '0', '0', 'fs.com');
INSERT INTO `t_menu` VALUES ('6', '0', '系统设置', '&#xe64b;', '', '0', '0', 'fs.com');
INSERT INTO `t_menu` VALUES ('7', '0', '用户管理', '&#xe70b;', 'html/systemset/user.html', '0', '0', 'fs.com');
INSERT INTO `t_menu` VALUES ('8', '0', '角色管理', '&#xe6d2;', 'html/temp.html', '0', '0', 'fs.com');
INSERT INTO `t_menu` VALUES ('9', '0', '菜单管理', '&#xe6e2;', 'html/temp.html', '0', '0', 'fs.com');
