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
  PRIMARY KEY (`id`),
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
  PRIMARY KEY (`id`),
  INDEX `FOUNDCAT` (`cat_ft` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `lost_found_db`.`claim_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lost_found_db`.`claim_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cat_ct` VARCHAR(255) NULL,
  `desc_ct` VARCHAR(45) NULL,
  `location_ct` VARCHAR(255) NULL,
  `date_ct` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `CLAIMCAT` (`cat_ct` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `lost_found_db`.`temp_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lost_found_db`.`temp_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cat` VARCHAR(255) NULL,
  `descc` VARCHAR(45) NULL,
  `location` VARCHAR(255) NULL,
  `date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `TEMPCAT` (`cat` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

-- -----------------------------------------------------
-- Table `lost_found_db`.`contact_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lost_found_db`.`contact_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `email` VARCHAR(45) NULL,
  `contact` VARCHAR(255) NULL,
  `type` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `CONTCAT` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

-- -----------------------------------------------------
-- Table `lost_found_db`.`contact_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lost_found_db`.`user_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(255) NULL,
  `lname` VARCHAR(255) NULL,
  `uemail` VARCHAR(45) NULL,
  `username` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `CONTCAT` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

