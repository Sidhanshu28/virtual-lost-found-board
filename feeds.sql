CREATE SCHEMA IF NOT EXISTS `lost_found_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `lost_found_db` ;

-- -----------------------------------------------------
-- Table `lost_found_db`.`lost_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lost_found_db`.`lost_table` (
  `lost_id` INT NOT NULL AUTO_INCREMENT,
  `cat_lt` VARCHAR(255) NULL,
  `desc_lt` VARCHAR(45) NULL,
  `location_lt` VARCHAR(255) NULL,
  `date_lt` DATETIME NULL,
  `prize_lt` VARCHAR(45) NULL,
  PRIMARY KEY (`lost_id`),
  INDEX `LOSTCAT` (`cat_lt` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `lost_found_db`.`found_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lost_found_db`.`found_table` (
  `found_id` INT NOT NULL AUTO_INCREMENT,
  `cat_ft` VARCHAR(255) NULL,
  `desc_ft` VARCHAR(45) NULL,
  `location_ft` VARCHAR(255) NULL,
  `date_ft` DATETIME NULL,
  PRIMARY KEY (`found_id`),
  INDEX `FOUNDCAT` (`cat_ft` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

