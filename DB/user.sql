/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : baseweb

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-03-12 16:15:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `site_name` varchar(32) DEFAULT NULL COMMENT '网站名字',
  `logo_path` varchar(100) DEFAULT NULL COMMENT '网站logo',
  `domain` varchar(45) DEFAULT NULL,
  `qq_num` bigint(32) DEFAULT NULL,
  `phone_num` bigint(32) DEFAULT NULL,
  `home_address` varchar(32) DEFAULT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  `site_address` varchar(45) DEFAULT NULL COMMENT '基本信息',
  `basic_info` varchar(1024) DEFAULT NULL,
  `service_info` varchar(1024) DEFAULT NULL COMMENT '服务理念',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'fuletian', null, '1', '/baseweb/h/images/upload/1/1394518492272.jpg', null, '2364596482', '15281060106', '您的地址', '您的邮箱地址', 'a', '您的基本资料', '您的宣传语');
