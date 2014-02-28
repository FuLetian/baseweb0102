/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : basedb

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-02-28 18:11:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `stars` int(11) DEFAULT NULL COMMENT '评分',
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
  CONSTRAINT `fk_article_brand1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_channel1` FOREIGN KEY (`channel_id`) REFERENCES `channel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COMMENT='商品表';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '13333', '100', null, '12', '2014-02-26 14:00:07', '2014-02-26 14:00:07', '1', '5', '1', '1', '1', null, 'remark', '/baseweb/h/images/upload/1/1393394403283.jpg');
INSERT INTO `article` VALUES ('2', '1', '1', '2', '1', '2014-02-03 17:13:06', '2014-02-03 17:13:06', '1', '4', '1', '1', '1', '1', 'remark', '/baseweb/h/images/upload/1/1393207087946.jpg');
INSERT INTO `article` VALUES ('3', '1', '1', '3', '1', '2014-02-18 13:39:24', '2014-02-18 13:39:24', '1', '5', '1', '1', '1', '1', 'remark', '/baseweb/h/images/upload/1/1393207087946.jpg');
INSERT INTO `article` VALUES ('4', '1', '1', '4', '1', '2014-02-03 16:35:54', '2014-02-03 16:35:54', '1', '6', '1', '1', '1', '1', 'remark', '/baseweb/h/images/upload/1/1393207087946.jpg');
INSERT INTO `article` VALUES ('5', '1', '1', '3', '1', '2014-02-18 13:47:33', '2014-02-18 13:47:33', '1', '5', '1', '1', '1', '1', 'remark', '/baseweb/h/images/upload/1/1393207087946.jpg');
INSERT INTO `article` VALUES ('6', '1', '1', '2', '1', '2014-02-03 17:08:43', '2014-02-03 17:08:43', '1', '3', '1', '1', '1', '1', 'remark', '/baseweb/h/images/upload/1/1393207087946.jpg');
INSERT INTO `article` VALUES ('7', '1', '1', '4', '1', '2014-02-03 17:10:27', '2014-02-03 17:10:27', '1', '4', '1', '1', '1', '1', 'remark', '/baseweb/h/images/upload/1/1393207087946.jpg');
INSERT INTO `article` VALUES ('9', '1', '1', '3', '1', '2014-02-03 17:09:01', '2014-02-03 17:09:01', '1', '5', '1', '1', '1', '1', 'remark', '/baseweb/h/images/upload/1/1393207087946.jpg');
INSERT INTO `article` VALUES ('10', '3', '3', null, '30', '2014-02-24 09:58:13', '2014-02-24 09:58:13', '3', '5', '1', '1', '1', null, 'remark', '/baseweb/h/images/upload/1/1393207087946.jpg');

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
  CONSTRAINT `fk_article_img_article1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1 COMMENT='article详细画面多个图片展示源';

-- ----------------------------
-- Records of article_img
-- ----------------------------
INSERT INTO `article_img` VALUES ('4', null, '/basemanage/images/upload/1390486183590.jpg', '2');
INSERT INTO `article_img` VALUES ('5', null, '/basemanage/images/upload/1390486205764.jpg', '2');
INSERT INTO `article_img` VALUES ('6', null, '/basemanage/images/upload/1390486227737.jpg', '2');
INSERT INTO `article_img` VALUES ('7', null, '/basemanage/images/upload/1390486326187.jpg', '9');
INSERT INTO `article_img` VALUES ('12', null, '/basemanage/images/upload/1390542363901.jpg', '10');
INSERT INTO `article_img` VALUES ('13', null, 'http://localhost:8080/basemanage/images/upload/1390544846690.jpg', '1');
INSERT INTO `article_img` VALUES ('14', null, '/basemanage/images/upload/1391416550332.jpg', '4');
INSERT INTO `article_img` VALUES ('15', null, '/baseweb/images/upload/1/1392701951651.jpg', '3');
INSERT INTO `article_img` VALUES ('16', null, '/baseweb/images/upload/1/1392702351360.jpg', '5');
INSERT INTO `article_img` VALUES ('17', null, '/baseweb/h/images/upload/1/1393394349264.jpg', '1');

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
  CONSTRAINT `fk_article_property_article1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of article_property
-- ----------------------------
INSERT INTO `article_property` VALUES ('3', '1', '1', '2014-01-23 22:10:08', '2014-01-23 22:10:08', '1', '2', '0');
INSERT INTO `article_property` VALUES ('4', '2', '2', '2014-01-23 22:10:33', '2014-01-23 22:10:33', '1', '2', '0');
INSERT INTO `article_property` VALUES ('5', '1', '1', '2014-01-24 13:46:22', '2014-01-24 13:46:22', '1', '10', '0');
INSERT INTO `article_property` VALUES ('6', '2', '2', '2014-01-24 13:46:22', '2014-01-24 13:46:22', '2', '10', '1');
INSERT INTO `article_property` VALUES ('7', '1', '1', '2014-01-24 14:26:16', '2014-01-24 14:26:16', '1', '1', '0');
INSERT INTO `article_property` VALUES ('8', '2', '2', '2014-01-24 14:26:35', '2014-01-24 14:26:35', '1', '1', '0');
INSERT INTO `article_property` VALUES ('9', '3', '3', '2014-01-24 14:26:35', '2014-01-24 14:26:35', '2', '1', '1');
INSERT INTO `article_property` VALUES ('10', '4', '4', '2014-02-26 13:58:07', '2014-02-26 13:58:07', '1', '1', '0');
INSERT INTO `article_property` VALUES ('11', '5', '5', '2014-02-26 13:58:37', '2014-02-26 13:58:37', '1', '1', '1');
INSERT INTO `article_property` VALUES ('12', '6', '6', '2014-02-26 13:58:37', '2014-02-26 13:58:37', '2', '1', '1');

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
  CONSTRAINT `fk_brand_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COMMENT='品牌';

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES ('1', 'b1', '/baseweb/h/images/upload/1/1393207739748.jpg', '0', '2014-02-24 10:08:59', '2014-02-24 10:08:59', '0', '1');
INSERT INTO `brand` VALUES ('2', 'b2', '/baseweb/h/images/upload/1/1393207857020.jpg', '0', '2014-02-24 10:10:57', '2014-02-24 10:10:57', '0', '1');
INSERT INTO `brand` VALUES ('3', '33', '/baseweb/h/images/upload/1/1393207865432.jpg', '0', '2014-02-24 10:11:05', '2014-02-24 10:11:05', '2', '1');
INSERT INTO `brand` VALUES ('4', 'b4', '/baseweb/h/images/upload/1/1393207874438.jpg', '0', '2014-02-24 10:11:14', '2014-02-24 10:11:14', '2', '1');
INSERT INTO `brand` VALUES ('5', 'd', '/baseweb/h/images/upload/1/1393207883731.jpg', '0', '2014-02-24 10:11:23', '2014-02-24 10:11:23', '4', '1');
INSERT INTO `brand` VALUES ('6', '3', '/baseweb/h/images/upload/1/1393207893033.jpg', '0', '2014-02-24 10:11:33', '2014-02-24 10:11:33', '4', '1');
INSERT INTO `brand` VALUES ('7', 'dd', '/baseweb/h/images/upload/1/1393207900918.jpg', '0', '2014-02-24 10:11:40', '2014-02-24 10:11:40', '11', '1');
INSERT INTO `brand` VALUES ('8', 'ff', '/baseweb/h/images/upload/1/1393207909250.jpg', '0', '2014-02-24 10:11:49', '2014-02-24 10:11:49', '11', '1');
INSERT INTO `brand` VALUES ('9', '3', '/baseweb/h/images/upload/1/1393207917572.jpg', '0', '2014-02-24 10:11:57', '2014-02-24 10:11:57', '122', '1');

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
  CONSTRAINT `fk_channel_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of channel
-- ----------------------------
INSERT INTO `channel` VALUES ('1', 'c1', '2014-01-23 16:46:54', '2014-01-23 16:46:54', '34', '1');
INSERT INTO `channel` VALUES ('2', 'c2', '2014-01-23 16:47:02', '2014-01-23 16:47:02', '33', '1');
INSERT INTO `channel` VALUES ('3', 'c3-0', '2014-01-25 14:05:08', '2014-01-23 23:16:32', '3', '1');
INSERT INTO `channel` VALUES ('4', 'c4', '2014-01-25 14:04:44', '2014-01-25 14:04:44', '1', '1');

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
  CONSTRAINT `fk_comment_article1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_consumer1` FOREIGN KEY (`consumer_id`) REFERENCES `consumer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', 'content', 'reply', '5', '2014-01-24 14:33:32', '2014-02-05 14:33:59', '1', '1', '1');
INSERT INTO `comment` VALUES ('2', 'ddd', 'dd', '3', '2014-01-25 15:07:59', '2014-01-25 15:08:04', '1', '1', '1');
INSERT INTO `comment` VALUES ('3', 'ddd', null, '5', '2014-01-31 13:47:20', '2014-01-31 13:47:20', '6', '1', '1');
INSERT INTO `comment` VALUES ('4', 'ddd', null, '4', '2014-01-31 13:15:03', '2014-01-31 13:15:03', '6', '1', '1');
INSERT INTO `comment` VALUES ('5', 'ddd', null, '3', '2014-01-31 13:19:54', '2014-01-31 13:19:54', '6', '1', '1');
INSERT INTO `comment` VALUES ('6', 'ddd', null, '5', '2014-01-31 13:20:10', '2014-01-31 13:20:10', '6', '1', '1');
INSERT INTO `comment` VALUES ('7', 'ddd', null, '4', '2014-01-31 13:21:10', '2014-01-31 13:21:10', '6', '1', '1');
INSERT INTO `comment` VALUES ('8', 'ddd', null, '4', '2014-01-31 13:21:35', '2014-01-31 13:21:35', '6', '1', '1');
INSERT INTO `comment` VALUES ('9', 'ddd', null, '3', '2014-01-31 13:22:18', '2014-01-31 13:22:18', '6', '1', '1');
INSERT INTO `comment` VALUES ('10', 'ddd', null, '3', '2014-01-31 13:43:29', '2014-01-31 13:43:29', '6', '1', '1');

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
  CONSTRAINT `fk_consumer_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of consumer
-- ----------------------------
INSERT INTO `consumer` VALUES ('1', 'consumer1', 'aaa', 'aaa', 'http://localhost:8080/baseweb/h/images/icon-user.jpg', '123', '123', '133', '1');
INSERT INTO `consumer` VALUES ('2', 'bb', 'b', 'bb', 'http://localhost:8080/baseweb/images/icon-user.jpg', null, null, null, '1');
INSERT INTO `consumer` VALUES ('3', '343', '', '', null, '', '', '', '1');
INSERT INTO `consumer` VALUES ('4', '45', 'fuletian', '123', null, '15281060106', 'chengdu', '313376212@qq.com', '1');
INSERT INTO `consumer` VALUES ('5', '66', 'fuletian', '123', null, '15281060106', 'chengdu', '313376212@qq.com', '1');
INSERT INTO `consumer` VALUES ('6', '454', 'fuletian', '123', null, '15281060106', 'chengdu', '313376212@qq.com', '1');
INSERT INTO `consumer` VALUES ('7', '3434', 'letian', '111', null, '15281060106', 'sichuan', '1111@qq.com', '1');
INSERT INTO `consumer` VALUES ('8', '545', '1', '1', 'http://localhost:8080/baseweb/images/upload/1390718066673.jpg', '1', '1', '1', '1');
INSERT INTO `consumer` VALUES ('9', '34', '', '', '', '', '', '', '1');
INSERT INTO `consumer` VALUES ('10', '6', '', '', '', '', '', '', '1');
INSERT INTO `consumer` VALUES ('11', '6', '', '', '', '', '', '', '1');
INSERT INTO `consumer` VALUES ('12', '3', '', '', '', '', '', '', '1');
INSERT INTO `consumer` VALUES ('13', '2', '', '', '', '', '', '', '1');

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
  CONSTRAINT `fk_menu_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', 'm1-1', null, '2014-01-23 16:45:01', '2014-01-23 16:45:05', '0', '1');
INSERT INTO `menu` VALUES ('2', 'm1-2', null, '2014-01-23 16:45:13', '2014-01-23 16:45:16', '0', '1');
INSERT INTO `menu` VALUES ('3', '2-1', '2', '2014-01-23 16:45:46', '2014-01-23 16:45:46', '99', '1');
INSERT INTO `menu` VALUES ('4', '1-1', '2', '2014-01-23 16:45:59', '2014-01-23 16:45:59', '22', '1');
INSERT INTO `menu` VALUES ('5', '56', '1', '2014-01-23 23:20:23', '2014-01-23 23:20:23', '23', '1');
INSERT INTO `menu` VALUES ('6', 'm1-2', '1', '2014-01-25 14:05:25', '2014-01-25 14:05:25', '2', '1');
INSERT INTO `menu` VALUES ('7', 'm1-2', '1', '2014-01-25 14:05:51', '2014-01-25 14:05:51', '20', '1');
INSERT INTO `menu` VALUES ('8', 'jj', '1', '2014-02-18 13:21:24', '2014-02-18 13:21:24', '45', '1');

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
  CONSTRAINT `fk_passage_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of passage
-- ----------------------------
INSERT INTO `passage` VALUES ('1', 'ddddd', null, '1', '1', '2014-01-25 13:59:47', '2014-01-25 13:10:41', '1');
INSERT INTO `passage` VALUES ('2', 'cccc', '1', '2', '0', '2014-01-25 14:01:03', '2014-01-25 14:01:03', '1');

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
  CONSTRAINT `fk_resource_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '13', '1', '1', '2014-01-23 23:24:02', '2014-01-23 23:24:05', '1');
INSERT INTO `resource` VALUES ('2', '22222', null, '2', '2014-01-24 02:02:34', '2014-01-24 02:02:34', '1');
INSERT INTO `resource` VALUES ('3', 'sxxxxxx', null, '3', '2014-01-24 02:02:44', '2014-01-24 02:02:44', '1');

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
  CONSTRAINT `fk_order_article1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_consumer1` FOREIGN KEY (`consumer_id`) REFERENCES `consumer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '3', '3', null, null, null, null, null, '2014-01-27 16:54:26', '2014-01-27 16:54:26', '1', '1');
INSERT INTO `t_order` VALUES ('3', '3', '1', null, null, null, null, null, '2014-01-27 17:00:34', '2014-01-27 17:00:34', '1', '1');
INSERT INTO `t_order` VALUES ('4', '3', '3', null, null, null, null, null, '2014-01-27 17:01:48', '2014-01-27 17:01:48', '1', '1');
INSERT INTO `t_order` VALUES ('7', '0', '3', null, null, null, null, null, '2014-01-30 00:09:56', '2014-01-30 00:09:56', '1', '6');
INSERT INTO `t_order` VALUES ('11', null, '0', null, null, null, null, null, '2014-02-24 15:09:12', '2014-02-24 15:09:12', '1', '3');
INSERT INTO `t_order` VALUES ('12', null, '0', null, null, null, null, null, '2014-02-24 15:09:20', '2014-02-24 15:09:20', '1', '3');
INSERT INTO `t_order` VALUES ('13', null, '0', null, null, null, null, null, '2014-02-24 15:09:27', '2014-02-24 15:09:27', '1', '3');
INSERT INTO `t_order` VALUES ('14', null, '0', null, null, null, null, null, '2014-02-24 15:09:50', '2014-02-24 15:09:50', '1', '3');
INSERT INTO `t_order` VALUES ('15', null, '0', null, null, null, null, null, '2014-02-24 15:10:46', '2014-02-24 15:10:46', '1', '1');
INSERT INTO `t_order` VALUES ('17', null, '4', null, null, null, null, null, '2014-02-24 15:30:19', '2014-02-24 15:30:19', '1', '5');
INSERT INTO `t_order` VALUES ('18', null, '4', null, null, null, null, null, '2014-02-24 15:31:09', '2014-02-24 15:31:09', null, '6');
INSERT INTO `t_order` VALUES ('19', '1', '0', 'consumer1', '133', '123', '123', 'vv', '2014-02-28 10:51:31', '2014-02-28 10:51:31', '1', '1');
INSERT INTO `t_order` VALUES ('20', '1', '0', 'consumer1', '133@qq.com', '123', '123', 'vv', '2014-02-28 10:51:38', '2014-02-28 10:51:38', '1', '1');
INSERT INTO `t_order` VALUES ('21', '1', '0', 'consumer1', '133@qq.com', '123', '123', 'vv', '2014-02-28 10:51:38', '2014-02-28 10:51:38', '1', '1');
INSERT INTO `t_order` VALUES ('22', '1', '0', 'consumer1', '133', '123', '123', '', '2014-02-28 10:53:05', '2014-02-28 10:53:05', '1', '1');
INSERT INTO `t_order` VALUES ('23', '1', '0', 'consumer1e', '133@qq.com', '123', '123', 'c', '2014-02-28 10:53:38', '2014-02-28 10:53:38', '1', '1');
INSERT INTO `t_order` VALUES ('24', '1', '0', 'consumer1e', '133@qq.com', '123', '123', 'c', '2014-02-28 10:53:39', '2014-02-28 10:53:39', '1', '1');
INSERT INTO `t_order` VALUES ('25', '1', '0', 'consumer1', '133', '123', '123', '', '2014-02-28 10:55:16', '2014-02-28 10:55:16', '1', '1');
INSERT INTO `t_order` VALUES ('26', '1', '0', 'consumer1', '133', '123', '123', '', '2014-02-28 10:55:19', '2014-02-28 10:55:19', '1', '1');
INSERT INTO `t_order` VALUES ('27', '2', '0', 'consumer1', '133', '123', '123', '', '2014-02-28 11:01:41', '2014-02-28 11:01:41', '1', '1');
INSERT INTO `t_order` VALUES ('28', '2', '0', 'consumer1', '133', '123', '123', '46', '2014-02-28 11:01:53', '2014-02-28 11:01:53', '1', '1');
INSERT INTO `t_order` VALUES ('29', '2', '0', 'consumer1', '133', '123', '123', '', '2014-02-28 11:02:51', '2014-02-28 11:02:51', '1', '1');
INSERT INTO `t_order` VALUES ('30', '6', '0', 'consumer1', '133', '123', '123', '', '2014-02-28 11:04:40', '2014-02-28 11:04:40', '1', '1');
INSERT INTO `t_order` VALUES ('31', '2', '0', 'consumer1', '133', '123', '123', '', '2014-02-28 11:21:33', '2014-02-28 11:21:33', '1', '1');
INSERT INTO `t_order` VALUES ('32', '2', '0', 'consumer1', '133', '123', '123', '', '2014-02-28 13:41:52', '2014-02-28 13:41:52', '1', '3');
INSERT INTO `t_order` VALUES ('33', '1', '0', 'consumer1', '133', '123', '123', 'å¥½å®¶ä¼?', '2014-02-28 13:42:51', '2014-02-28 13:42:51', '1', '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `domain` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'a', 'a', 'http://localhost:8080/baseweb/');
