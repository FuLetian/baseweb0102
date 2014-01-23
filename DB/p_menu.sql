/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : basedb

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-01-02 14:24:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for p_menu
-- ----------------------------
DROP TABLE IF EXISTS `p_menu`;
CREATE TABLE `p_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '				',
  `menu_name` varchar(45) NOT NULL,
  `p_menu_id` int(11) DEFAULT NULL,
  `ind` int(11) DEFAULT NULL COMMENT '次序',
  PRIMARY KEY (`menu_id`),
  UNIQUE KEY `menu_id_UNIQUE` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of p_menu
-- ----------------------------
INSERT INTO `p_menu` VALUES ('1', 'm1', null, null);
INSERT INTO `p_menu` VALUES ('2', 'm2', null, null);
INSERT INTO `p_menu` VALUES ('3', 'm1-1', '1', null);
INSERT INTO `p_menu` VALUES ('4', 'm1-2', '1', null);
INSERT INTO `p_menu` VALUES ('5', 'm2-1', '2', null);
INSERT INTO `p_menu` VALUES ('6', 'm1-1-1', '3', null);
