SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`p_menu`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`p_menu` (
  `menu_id` INT NOT NULL AUTO_INCREMENT COMMENT '				' ,
  `menu_name` VARCHAR(45) NOT NULL ,
  `p_menu_id` INT NULL ,
  PRIMARY KEY (`menu_id`) ,
  UNIQUE INDEX `menu_id_UNIQUE` (`menu_id` ASC) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
