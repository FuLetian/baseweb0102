SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `basedb` ;
CREATE SCHEMA IF NOT EXISTS `basedb` DEFAULT CHARACTER SET latin1 ;
USE `basedb` ;

-- -----------------------------------------------------
-- Table `basedb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`user` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `account` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`channel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`channel` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`channel` (
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
    REFERENCES `basedb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`menu` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`menu` (
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
    REFERENCES `basedb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`brand`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`brand` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`brand` (
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
    REFERENCES `basedb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '品牌';


-- -----------------------------------------------------
-- Table `basedb`.`article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`article` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`article` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `price` DOUBLE NULL ,
  `discount` DOUBLE NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `u_dt` DATETIME NOT NULL ,
  `c_dt` DATETIME NOT NULL ,
  `idx` INT NOT NULL DEFAULT 0 ,
  `menu_id` INT NOT NULL ,
  `channel_id` INT NOT NULL ,
  `brand_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_article_menu` (`menu_id` ASC) ,
  INDEX `fk_article_channel1` (`channel_id` ASC) ,
  INDEX `fk_article_brand1` (`brand_id` ASC) ,
  CONSTRAINT `fk_article_menu`
    FOREIGN KEY (`menu_id` )
    REFERENCES `basedb`.`menu` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_channel1`
    FOREIGN KEY (`channel_id` )
    REFERENCES `basedb`.`channel` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_brand1`
    FOREIGN KEY (`brand_id` )
    REFERENCES `basedb`.`brand` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '商品表';


-- -----------------------------------------------------
-- Table `basedb`.`consumer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`consumer` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`consumer` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `account` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `thumbnail_path` VARCHAR(100) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`comment` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`comment` (
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
    REFERENCES `basedb`.`article` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_consumer1`
    FOREIGN KEY (`consumer_id` )
    REFERENCES `basedb`.`consumer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `basedb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`resource`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`resource` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`resource` (
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
    REFERENCES `basedb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`ball`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`ball` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`ball` (
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
-- Table `basedb`.`passage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`passage` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`passage` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `text` VARCHAR(1024) NULL ,
  `type` INT NULL ,
  `idx` INT NULL ,
  `u_dt` DATETIME NULL ,
  `c_dt` DATETIME NULL ,
  `user_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_passage_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_passage_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `basedb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`article_property`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`article_property` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`article_property` (
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
    REFERENCES `basedb`.`article` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`article_img`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`article_img` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`article_img` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(45) NULL ,
  `path` VARCHAR(100) NULL ,
  `article_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_article_img_article1` (`article_id` ASC) ,
  CONSTRAINT `fk_article_img_article1`
    FOREIGN KEY (`article_id` )
    REFERENCES `basedb`.`article` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'article详细画面多个图片展示源';



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
