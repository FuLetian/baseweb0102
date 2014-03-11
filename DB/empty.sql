/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : baseweb

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-03-11 15:20:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `access_log`
-- ----------------------------
DROP TABLE IF EXISTS `access_log`;
CREATE TABLE `access_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(30) DEFAULT NULL,
  `lunch_dt` datetime DEFAULT NULL,
  `consumer_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of access_log
-- ----------------------------
INSERT INTO `access_log` VALUES ('58', '0:0:0:0:0:0:0:1', '2014-03-11 15:09:37', null, '1');
INSERT INTO `access_log` VALUES ('59', '0:0:0:0:0:0:0:1', '2014-03-11 15:14:01', null, '1');

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `stars` int(11) DEFAULT NULL COMMENT '评分',
  `clip_count` int(11) NOT NULL DEFAULT '0' COMMENT '赞数',
  `name` varchar(45) NOT NULL,
  `u_dt` datetime NOT NULL,
  `c_dt` datetime NOT NULL,
  `idx` int(11) NOT NULL DEFAULT '0',
  `menu_id` int(11) NOT NULL,
  `channel_id` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `sale_count` int(11) DEFAULT NULL,
  `remark` text,
  `homepage_img` varchar(45) DEFAULT NULL COMMENT '首页图片，矩形',
  PRIMARY KEY (`id`),
  KEY `fk_article_menu` (`menu_id`),
  KEY `fk_article_channel1` (`channel_id`),
  KEY `fk_article_brand1` (`brand_id`),
  KEY `fk_article_user1` (`user_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`channel_id`) REFERENCES `channel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `article_ibfk_3` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `article_ibfk_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for `article_img`
-- ----------------------------
DROP TABLE IF EXISTS `article_img`;
CREATE TABLE `article_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `article_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_article_img_article1` (`article_id`),
  CONSTRAINT `article_img_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='article详细画面多个图片展示源';

-- ----------------------------
-- Records of article_img
-- ----------------------------

-- ----------------------------
-- Table structure for `article_property`
-- ----------------------------
DROP TABLE IF EXISTS `article_property`;
CREATE TABLE `article_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  `u_dt` datetime DEFAULT NULL,
  `c_dt` datetime DEFAULT NULL,
  `idx` int(11) DEFAULT NULL,
  `article_id` int(11) NOT NULL,
  `type` varchar(45) DEFAULT '0' COMMENT '0-商品详细界面的属性\n1-商品参数属性',
  PRIMARY KEY (`id`),
  KEY `fk_article_property_article1` (`article_id`),
  CONSTRAINT `article_property_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_property
-- ----------------------------

-- ----------------------------
-- Table structure for `ball`
-- ----------------------------
DROP TABLE IF EXISTS `ball`;
CREATE TABLE `ball` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `term` int(11) NOT NULL,
  `make_date_time` datetime NOT NULL,
  `day` varchar(5) DEFAULT NULL,
  `red_one` int(11) NOT NULL,
  `red_two` int(11) NOT NULL,
  `red_three` int(11) NOT NULL,
  `red_four` int(11) NOT NULL,
  `red_five` int(11) NOT NULL,
  `red_six` int(11) NOT NULL,
  `blue` int(11) NOT NULL,
  `summation_value` int(11) DEFAULT NULL,
  `median_value` int(11) DEFAULT NULL,
  `min_value` int(11) DEFAULT NULL,
  `max_value` int(11) DEFAULT NULL,
  `variance_value` double DEFAULT NULL,
  `e_value` double DEFAULT NULL,
  `average_value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ball
-- ----------------------------

-- ----------------------------
-- Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `thumbnail` varchar(45) DEFAULT NULL,
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '对品牌的分类，比如热门品牌',
  `u_dt` datetime NOT NULL,
  `c_dt` datetime NOT NULL,
  `idx` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_brand_user1` (`user_id`),
  CONSTRAINT `brand_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='品牌';

-- ----------------------------
-- Records of brand
-- ----------------------------

-- ----------------------------
-- Table structure for `channel`
-- ----------------------------
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `u_dt` datetime NOT NULL,
  `c_dt` datetime NOT NULL,
  `idx` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_channel_user1` (`user_id`),
  CONSTRAINT `channel_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(45) NOT NULL,
  `reply_content` varchar(500) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL COMMENT '评分，1-5',
  `u_dt` datetime DEFAULT NULL,
  `c_dt` datetime DEFAULT NULL,
  `article_id` int(11) NOT NULL,
  `consumer_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_article1` (`article_id`),
  KEY `fk_comment_consumer1` (`consumer_id`),
  KEY `fk_comment_user1` (`user_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`consumer_id`) REFERENCES `consumer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `consumer`
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `thumbnail_path` varchar(100) DEFAULT NULL,
  `phone_num` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_consumer_user1` (`user_id`),
  CONSTRAINT `consumer_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consumer
-- ----------------------------

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `p_id` int(11) DEFAULT NULL COMMENT '父menu_id',
  `u_dt` datetime NOT NULL,
  `c_dt` datetime NOT NULL,
  `idx` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_menu_user1` (`user_id`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for `passage`
-- ----------------------------
DROP TABLE IF EXISTS `passage`;
CREATE TABLE `passage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(1024) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL COMMENT 'num+userID定位',
  `idx` int(11) DEFAULT NULL,
  `u_dt` datetime DEFAULT NULL,
  `c_dt` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_passage_user1` (`user_id`),
  CONSTRAINT `passage_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of passage
-- ----------------------------

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(1024) DEFAULT NULL,
  `idx` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL COMMENT '此字段加上userId确定其唯一性',
  `u_dt` datetime DEFAULT NULL,
  `c_dt` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_resource_user1` (`user_id`),
  CONSTRAINT `resource_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `run_status` int(11) DEFAULT NULL COMMENT '状态,0-刚下单,1-正在处理订单，2-正在配送，3-交易成功,4-收藏商品',
  `tour_name` varchar(45) DEFAULT NULL COMMENT '游客下单名字',
  `tour_email` varchar(45) DEFAULT NULL COMMENT '游客下单邮件',
  `tour_phone` varchar(45) DEFAULT NULL COMMENT '游客下单电话',
  `tour_address` varchar(45) DEFAULT NULL COMMENT '游客下单地址',
  `remark` varchar(45) DEFAULT NULL,
  `u_dt` datetime DEFAULT NULL,
  `c_dt` datetime DEFAULT NULL,
  `consumer_id` int(11) DEFAULT NULL,
  `article_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_consumer1` (`consumer_id`),
  KEY `fk_order_article1` (`article_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`consumer_id`) REFERENCES `consumer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

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
