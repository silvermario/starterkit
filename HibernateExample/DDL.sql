-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema organizacja_second
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `organizacja_second` ;

-- -----------------------------------------------------
-- Schema organizacja_second
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `organizacja_second` DEFAULT CHARACTER SET utf8 ;
USE `organizacja_second` ;

-- -----------------------------------------------------
-- Table `organizacja_second`.`dzial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `organizacja_second`.`dzial` ;

CREATE TABLE IF NOT EXISTS `organizacja_second`.`dzial` (
  `id_dzial` INT NOT NULL AUTO_INCREMENT,
  `nazwa_dzialu` VARCHAR(45) NULL,
  PRIMARY KEY (`id_dzial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizacja_second`.`pracownik`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `organizacja_second`.`pracownik` ;

CREATE TABLE IF NOT EXISTS `organizacja_second`.`pracownik` (
  `id_pracownik` INT NOT NULL AUTO_INCREMENT,
  `imie` VARCHAR(45) NOT NULL,
  `nazwisko` VARCHAR(45) NOT NULL,
  `data_urodzenia` DATE NOT NULL,
  `pesel` CHAR(11) NOT NULL,
  `dzial_iddzial` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_pracownik`),
  UNIQUE INDEX `pesel_UNIQUE` (`pesel` ASC),
  INDEX `fk_pracownik_dzial_idx` (`dzial_iddzial` ASC),
  CONSTRAINT `fk_pracownik_dzial`
    FOREIGN KEY (`dzial_iddzial`)
    REFERENCES `organizacja_second`.`dzial` (`id_dzial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizacja_second`.`projekt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `organizacja_second`.`projekt` ;

CREATE TABLE IF NOT EXISTS `organizacja_second`.`projekt` (
  `id_projekt` INT NOT NULL AUTO_INCREMENT,
  `nazwa` VARCHAR(255) NOT NULL,
  `czy_wewnetrzny` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_projekt`),
  UNIQUE INDEX `nazwa_UNIQUE` (`nazwa` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizacja_second`.`pracownik_has_projekt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `organizacja_second`.`pracownik_has_projekt` ;

CREATE TABLE IF NOT EXISTS `organizacja_second`.`pracownik_has_projekt` (
  `id_pracownik_do_projektu` INT NOT NULL AUTO_INCREMENT,
  `pracownik_id_pracownik` INT NOT NULL,
  `projekt_id_projekt` INT NOT NULL,
  `data_rozpoczecia` TIMESTAMP NOT NULL,
  `data_zakonczenia` TIMESTAMP NULL,
  `stawka_dzienna` DECIMAL(10,2) NULL,
  `rola` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pracownik_do_projektu`),
  INDEX `fk_pracownik_has_projekt_projekt1_idx` (`projekt_id_projekt` ASC),
  INDEX `fk_pracownik_has_projekt_pracownik1_idx` (`pracownik_id_pracownik` ASC),
  CONSTRAINT `fk_pracownik_has_projekt_pracownik1`
    FOREIGN KEY (`pracownik_id_pracownik`)
    REFERENCES `organizacja_second`.`pracownik` (`id_pracownik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pracownik_has_projekt_projekt1`
    FOREIGN KEY (`projekt_id_projekt`)
    REFERENCES `organizacja_second`.`projekt` (`id_projekt`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
