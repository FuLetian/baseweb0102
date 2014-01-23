/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : basedb

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-01-15 14:48:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ball`
-- ----------------------------
DROP TABLE IF EXISTS `ball`;
CREATE TABLE `ball` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `term` int(11) NOT NULL,
  `make_date_time` datetime NOT NULL,
  `day` varchar(5) NOT NULL,
  `red_one` int(11) NOT NULL,
  `red_two` int(11) NOT NULL,
  `red_three` int(11) NOT NULL,
  `red_four` int(11) NOT NULL,
  `red_five` int(11) NOT NULL,
  `red_six` int(11) NOT NULL,
  `blue` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ball
-- ----------------------------
