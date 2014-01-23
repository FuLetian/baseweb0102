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



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
