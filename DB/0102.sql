SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `basedb` ;
CREATE SCHEMA IF NOT EXISTS `basedb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `basedb` ;

-- -----------------------------------------------------
-- Table `basedb`.`p_menu`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `basedb`.`p_menu` (
  `menu_id` INT NOT NULL AUTO_INCREMENT COMMENT '				' ,
  `menu_name` VARCHAR(45) NOT NULL ,
  `p_menu_id` INT NULL ,
  `ind` INT NULL COMMENT '次序' ,
  PRIMARY KEY (`menu_id`) ,
  UNIQUE INDEX `menu_id_UNIQUE` (`menu_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`p_category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `basedb`.`p_category` (
  `id_category` INT NOT NULL AUTO_INCREMENT ,
  `category_name` VARCHAR(45) NOT NULL ,
  `category_description` VARCHAR(45) NULL ,
  `category_type` INT NULL COMMENT '最近特卖，最后时限...' ,
  `ind` INT NULL ,
  PRIMARY KEY (`id_category`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`p_passage`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `basedb`.`p_passage` (
  `id_passage` INT NOT NULL AUTO_INCREMENT ,
  `passage_title` VARCHAR(45) NULL ,
  `passage_content` VARCHAR(45) NULL ,
  `type` INT NULL ,
  PRIMARY KEY (`id_passage`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`p_channel`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `basedb`.`p_channel` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `type` INT NULL ,
  `ind` INT NULL DEFAULT 0 ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`p_product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `basedb`.`p_product` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `category_id` INT NOT NULL ,
  `menu_id` INT NOT NULL ,
  `channel_type` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_p_product_p_category1` (`category_id` ASC) ,
  INDEX `fk_p_product_p_menu1` (`menu_id` ASC) ,
  INDEX `fk_p_product_p_channel1` (`channel_type` ASC) ,
  CONSTRAINT `fk_p_product_p_category1`
    FOREIGN KEY (`category_id` )
    REFERENCES `basedb`.`p_category` (`id_category` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_p_product_p_menu1`
    FOREIGN KEY (`menu_id` )
    REFERENCES `basedb`.`p_menu` (`menu_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_p_product_p_channel1`
    FOREIGN KEY (`channel_type` )
    REFERENCES `basedb`.`p_channel` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basedb`.`p_comment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `basedb`.`p_comment` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `content` VARCHAR(45) NULL ,
  `product_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_p_comment_p_product` (`product_id` ASC) ,
  CONSTRAINT `fk_p_comment_p_product`
    FOREIGN KEY (`product_id` )
    REFERENCES `basedb`.`p_product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
