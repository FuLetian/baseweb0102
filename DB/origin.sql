SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `account` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `domain` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `channel`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `channel` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `u_dt` DATETIME NOT NULL ,
  `c_dt` DATETIME NOT NULL ,
  `idx` INT NOT NULL DEFAULT 0 ,
  `user_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_channel_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_channel_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `menu`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `menu` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `p_id` INT NULL COMMENT '父menu_id' ,
  `u_dt` DATETIME NOT NULL ,
  `c_dt` DATETIME NOT NULL ,
  `idx` INT NOT NULL DEFAULT 0 ,
  `user_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_menu_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_menu_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `brand`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `brand` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `thumbnail` VARCHAR(45) NULL ,
  `type` INT NOT NULL DEFAULT 0 COMMENT '对品牌的分类，比如热门品牌' ,
  `u_dt` DATETIME NOT NULL ,
  `c_dt` DATETIME NOT NULL ,
  `idx` INT NOT NULL DEFAULT 0 ,
  `user_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_brand_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_brand_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '品牌';


-- -----------------------------------------------------
-- Table `article`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `article` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `price` DOUBLE NULL ,
  `discount` DOUBLE NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `remark` TEXT NULL ,
  `u_dt` DATETIME NOT NULL ,
  `idx` INT NOT NULL DEFAULT 0 ,
  `c_dt` DATETIME NOT NULL ,
  `menu_id` INT NOT NULL ,
  `channel_id` INT NOT NULL ,
  `brand_id` INT NOT NULL ,
  `user_id` INT NOT NULL ,
  `sale_count` INT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_article_menu` (`menu_id` ASC) ,
  INDEX `fk_article_channel1` (`channel_id` ASC) ,
  INDEX `fk_article_brand1` (`brand_id` ASC) ,
  INDEX `fk_article_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_article_menu`
    FOREIGN KEY (`menu_id` )
    REFERENCES `menu` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_channel1`
    FOREIGN KEY (`channel_id` )
    REFERENCES `channel` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_brand1`
    FOREIGN KEY (`brand_id` )
    REFERENCES `brand` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '商品表';


-- -----------------------------------------------------
-- Table `consumer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `consumer` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `account` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `thumbnail_path` VARCHAR(100) NULL ,
  `phone_num` VARCHAR(45) NULL ,
  `address` VARCHAR(45) NULL ,
  `email` VARCHAR(45) NULL ,
  `user_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_consumer_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_consumer_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `comment` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `content` VARCHAR(45) NOT NULL ,
  `reply_content` VARCHAR(500) NULL ,
  `grade` INT NULL COMMENT '评分，1-5' ,
  `u_dt` DATETIME NULL ,
  `c_dt` DATETIME NULL ,
  `article_id` INT NOT NULL ,
  `consumer_id` INT NOT NULL ,
  `user_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_comment_article1` (`article_id` ASC) ,
  INDEX `fk_comment_consumer1` (`consumer_id` ASC) ,
  INDEX `fk_comment_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_comment_article1`
    FOREIGN KEY (`article_id` )
    REFERENCES `article` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_consumer1`
    FOREIGN KEY (`consumer_id` )
    REFERENCES `consumer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `resource`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `resource` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `text` VARCHAR(1024) NULL ,
  `idx` INT NULL ,
  `num` INT NULL COMMENT '此字段加上userId确定其唯一性' ,
  `u_dt` DATETIME NULL ,
  `c_dt` DATETIME NULL ,
  `user_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_resource_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_resource_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ball`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ball` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `term` INT(11) NOT NULL ,
  `make_date_time` DATETIME NOT NULL ,
  `day` VARCHAR(5) NULL DEFAULT NULL ,
  `red_one` INT(11) NOT NULL ,
  `red_two` INT(11) NOT NULL ,
  `red_three` INT(11) NOT NULL ,
  `red_four` INT(11) NOT NULL ,
  `red_five` INT(11) NOT NULL ,
  `red_six` INT(11) NOT NULL ,
  `blue` INT(11) NOT NULL ,
  `summation_value` INT(11) NULL DEFAULT NULL ,
  `median_value` INT(11) NULL DEFAULT NULL ,
  `min_value` INT(11) NULL DEFAULT NULL ,
  `max_value` INT(11) NULL DEFAULT NULL ,
  `variance_value` DOUBLE NULL DEFAULT NULL ,
  `e_value` DOUBLE NULL DEFAULT NULL ,
  `average_value` DOUBLE NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 1600
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `passage`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `passage` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `text` VARCHAR(1024) NULL ,
  `type` INT NULL ,
  `num` INT NULL COMMENT 'num+userID定位' ,
  `idx` INT NULL ,
  `u_dt` DATETIME NULL ,
  `c_dt` DATETIME NULL ,
  `user_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_passage_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_passage_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `article_property`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `article_property` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `value` VARCHAR(45) NULL ,
  `u_dt` DATETIME NULL ,
  `c_dt` DATETIME NULL ,
  `idx` INT NULL ,
  `article_id` INT NOT NULL ,
  `type` VARCHAR(45) NULL DEFAULT 0 COMMENT '0-商品详细界面的属性\n1-商品参数属性' ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_article_property_article1` (`article_id` ASC) ,
  CONSTRAINT `fk_article_property_article1`
    FOREIGN KEY (`article_id` )
    REFERENCES `article` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `article_img`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `article_img` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(45) NULL ,
  `path` VARCHAR(100) NULL ,
  `article_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_article_img_article1` (`article_id` ASC) ,
  CONSTRAINT `fk_article_img_article1`
    FOREIGN KEY (`article_id` )
    REFERENCES `article` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'article详细画面多个图片展示源';


-- -----------------------------------------------------
-- Table `t_order`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `t_order` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `count` INT NULL ,
  `run_status` INT NULL COMMENT '状态' ,
  `remark` VARCHAR(45) NULL ,
  `u_dt` DATETIME NULL ,
  `c_dt` DATETIME NULL ,
  `consumer_id` INT NOT NULL ,
  `article_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_order_consumer1` (`consumer_id` ASC) ,
  INDEX `fk_order_article1` (`article_id` ASC) ,
  CONSTRAINT `fk_order_consumer1`
    FOREIGN KEY (`consumer_id` )
    REFERENCES `consumer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_article1`
    FOREIGN KEY (`article_id` )
    REFERENCES `article` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
