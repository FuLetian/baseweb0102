/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : basedb

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-01-02 10:14:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for p_channel
-- ----------------------------
DROP TABLE IF EXISTS `p_channel`;
CREATE TABLE `p_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `ind` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of p_channel
-- ----------------------------
INSERT INTO `p_channel` VALUES ('1', 'channel1', '1', '0');
INSERT INTO `p_channel` VALUES ('2', 'channel2', '2', '1');
