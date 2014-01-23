SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `basedb` ;
CREATE SCHEMA IF NOT EXISTS `basedb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `basedb` ;

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
  PRIMARY KEY (`id`) )
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
  PRIMARY KEY (`id`) )
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
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = '品牌';


-- -----------------------------------------------------
-- Table `basedb`.`article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basedb`.`article` ;

CREATE  TABLE IF NOT EXISTS `basedb`.`article` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `u_dt` DATETIME NOT NULL ,
  `c_dt` DATETIME NOT NULL ,
  `idx` VARCHAR(45) NOT NULL DEFAULT 0 ,
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



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
