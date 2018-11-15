-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema laptopDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `laptopDB` ;

-- -----------------------------------------------------
-- Schema laptopDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `laptopDB` DEFAULT CHARACTER SET utf8 ;
USE `laptopDB` ;

-- -----------------------------------------------------
-- Table `laptopDB`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `laptopDB`.`user` ;

CREATE TABLE IF NOT EXISTS `laptopDB`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `birthDate` DATE NOT NULL,
  `gender` ENUM('MALE', 'FEMALE', 'OTHER') NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(11) NOT NULL,
  `authority` ENUM('ROLE_ADMIN', 'ROLE_USER') NOT NULL,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laptopDB`.`supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `laptopDB`.`supplier` ;

CREATE TABLE IF NOT EXISTS `laptopDB`.`supplier` (
  `supplierId` INT NOT NULL AUTO_INCREMENT,
  `supplierBrand` VARCHAR(20) NOT NULL,
  `supplierDescription` TEXT NOT NULL,
  PRIMARY KEY (`supplierId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laptopDB`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `laptopDB`.`product` ;

CREATE TABLE IF NOT EXISTS `laptopDB`.`product` (
  `productId` VARCHAR(20) NOT NULL,
  `productName` VARCHAR(45) NOT NULL,
  `productDescription` TEXT NOT NULL,
  `supplierId` INT NOT NULL,
  `price` INT NOT NULL,
  `cpu` VARCHAR(45) NOT NULL,
  `vga` VARCHAR(45) NOT NULL,
  `ram` VARCHAR(45) NOT NULL,
  `hardDisk` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`productId`),
  INDEX `supllierId_idx` (`supplierId` ASC) VISIBLE,
  CONSTRAINT `supllierId`
    FOREIGN KEY (`supplierId`)
    REFERENCES `laptopDB`.`supplier` (`supplierId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laptopDB`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `laptopDB`.`order` ;

CREATE TABLE IF NOT EXISTS `laptopDB`.`order` (
  `orderId` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `shipAddress` VARCHAR(45) NOT NULL,
  `totalPrice` INT NOT NULL,
  `orderDate` DATE NOT NULL,
  `shipDate` DATE NOT NULL,
  `status` ENUM('PREPARING', 'SHIPPING', 'FINISH', 'CANCELED') NOT NULL,
  PRIMARY KEY (`orderId`),
  CHECK (`orderDate` <= `shipDate`),
  INDEX `userId_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `userId`
    FOREIGN KEY (`userId`)
    REFERENCES `laptopDB`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laptopDB`.`ordersDetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `laptopDB`.`ordersDetail` ;

CREATE TABLE IF NOT EXISTS `laptopDB`.`ordersDetail` (
  `orderId` INT NOT NULL,
  `productId` VARCHAR(20) NOT NULL,
  `pricePerUnit` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`orderId`, `productId`),
  INDEX `productId_idx` (`productId` ASC) VISIBLE,
  CONSTRAINT `orderId`
    FOREIGN KEY (`orderId`)
    REFERENCES `laptopDB`.`order` (`orderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `productIdOrdersDetail`
    FOREIGN KEY (`productId`)
    REFERENCES `laptopDB`.`product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laptopDB`.`storage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `laptopDB`.`storage` ;

CREATE TABLE IF NOT EXISTS `laptopDB`.`storage` (
  `packageId` INT NOT NULL AUTO_INCREMENT,
  `productId` VARCHAR(20) NOT NULL,
  `importDate` DATE NOT NULL,
  `quantity` INT NOT NULL,
  `importPrice` INT NOT NULL,
  PRIMARY KEY (`packageId`),
  CHECK (`quantity` >= 0),
  INDEX `productId_idx` (`productId` ASC) INVISIBLE,
  CONSTRAINT `productIdStorage`
    FOREIGN KEY (`productId`)
    REFERENCES `laptopDB`.`product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
