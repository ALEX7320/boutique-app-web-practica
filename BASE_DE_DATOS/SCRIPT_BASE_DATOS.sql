-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_boutique_mvc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_boutique_mvc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_boutique_mvc` DEFAULT CHARACTER SET utf8 ;
USE `db_boutique_mvc` ;

-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`roles` (
  `rolid` INT NOT NULL AUTO_INCREMENT,
  `rolname` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`rolid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`users` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `lastname` VARCHAR(100) NULL DEFAULT NULL,
  `dni` CHAR(8) NULL DEFAULT NULL,
  `email` VARCHAR(200) NULL DEFAULT NULL,
  `username` VARCHAR(100) NULL DEFAULT NULL,
  `password` VARCHAR(300) NULL DEFAULT NULL,
  `movil` CHAR(9) NULL DEFAULT NULL,
  `active` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`user_role` (
  `userid` INT NOT NULL,
  `rolid` INT NOT NULL,
  PRIMARY KEY (`userid`, `rolid`),
  CONSTRAINT `fk_users_has_roles_roles1`
    FOREIGN KEY (`rolid`)
    REFERENCES `db_boutique_mvc`.`roles` (`rolid`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_users_has_roles_users`
    FOREIGN KEY (`userid`)
    REFERENCES `db_boutique_mvc`.`users` (`userid`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`marca` (
  `marca_id` INT NOT NULL AUTO_INCREMENT,
  `marca_nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`marca_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`tipoproducto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`tipoproducto` (
  `tipoproducto_id` INT NOT NULL AUTO_INCREMENT,
  `tipoproducto_nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`tipoproducto_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`producto` (
  `producto_id` INT NOT NULL AUTO_INCREMENT,
  `producto_nombre` VARCHAR(45) NULL,
  `producto_descripcion` TEXT NULL,
  `producto_estado` TINYINT NULL,
  `producto_precio` DECIMAL(10,2) NULL,
  `producto_imagen` TEXT NULL,
  `marca_id` INT NOT NULL,
  `tipoproducto_id` INT NOT NULL,
  PRIMARY KEY (`producto_id`, `marca_id`, `tipoproducto_id`),
  CONSTRAINT `fk_producto_marca1`
    FOREIGN KEY (`marca_id`)
    REFERENCES `db_boutique_mvc`.`marca` (`marca_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_tipoproducto1`
    FOREIGN KEY (`tipoproducto_id`)
    REFERENCES `db_boutique_mvc`.`tipoproducto` (`tipoproducto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`salida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`salida` (
  `salida_id` INT NOT NULL AUTO_INCREMENT,
  `salida_cantidad` INT NULL,
  `salida_fecha` DATE NULL,
  `salida_descripcion` TEXT NULL,
  `producto_id` INT NOT NULL,
  PRIMARY KEY (`salida_id`, `producto_id`),
  CONSTRAINT `fk_salida_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `db_boutique_mvc`.`producto` (`producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`ingreso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`ingreso` (
  `ingreso_id` INT NOT NULL AUTO_INCREMENT,
  `ingreso_cantidad` INT NULL,
  `ingreso_fecha` DATE NULL,
  `ingreso_proveedor` VARCHAR(45) NULL,
  `ingreso_descripcion` TEXT NULL,
  `producto_id` INT NOT NULL,
  PRIMARY KEY (`ingreso_id`, `producto_id`),
  CONSTRAINT `fk_ingreso_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `db_boutique_mvc`.`producto` (`producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`tipopago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`tipopago` (
  `tipopago_id` INT NOT NULL AUTO_INCREMENT,
  `tipopago_nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`tipopago_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`cliente` (
  `cliente_id` INT NOT NULL AUTO_INCREMENT,
  `cliente_nombre` VARCHAR(45) NULL,
  `cliente_apellido` VARCHAR(150) NULL,
  `cliente_dni` CHAR(8) NULL,
  `cliente_celular` CHAR(9) NULL,
  `cliente_estado` TINYINT NULL,
  PRIMARY KEY (`cliente_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`comprobante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`comprobante` (
  `comprobante_id` INT NOT NULL AUTO_INCREMENT,
  `comprobante_nombre` VARCHAR(60) NULL,
  PRIMARY KEY (`comprobante_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`venta` (
  `venta_id` INT NOT NULL AUTO_INCREMENT,
  `venta_fecha` DATE NULL,
  `venta_descripcion` TEXT NULL,
  `venta_igv` DECIMAL(10,2) NULL,
  `venta_estado` TINYINT NULL,
  `tipopago_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  `comprobante_id` INT NOT NULL,
  PRIMARY KEY (`venta_id`, `tipopago_id`, `cliente_id`, `comprobante_id`),
  CONSTRAINT `fk_venta_tipopago1`
    FOREIGN KEY (`tipopago_id`)
    REFERENCES `db_boutique_mvc`.`tipopago` (`tipopago_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `db_boutique_mvc`.`cliente` (`cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_comprobante1`
    FOREIGN KEY (`comprobante_id`)
    REFERENCES `db_boutique_mvc`.`comprobante` (`comprobante_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`descuento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`descuento` (
  `descuento_id` INT NOT NULL AUTO_INCREMENT,
  `descuento_nombre` VARCHAR(45) NULL,
  `descuento_procentaje` INT NULL,
  `descuento_disponible` TINYINT NULL,
  PRIMARY KEY (`descuento_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`detalleventa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`detalleventa` (
  `detalleventa_id` INT NOT NULL AUTO_INCREMENT,
  `detalleventa_cantidad` INT NULL,
  `venta_id` INT NOT NULL,
  `producto_id` INT NOT NULL,
  `descuento_id` INT NOT NULL,
  PRIMARY KEY (`detalleventa_id`, `venta_id`, `producto_id`, `descuento_id`),
  CONSTRAINT `fk_venta_has_producto_venta1`
    FOREIGN KEY (`venta_id`)
    REFERENCES `db_boutique_mvc`.`venta` (`venta_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_has_producto_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `db_boutique_mvc`.`producto` (`producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleventa_descuento1`
    FOREIGN KEY (`descuento_id`)
    REFERENCES `db_boutique_mvc`.`descuento` (`descuento_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`estadolaboral`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`estadolaboral` (
  `estadolaboral_id` INT NOT NULL AUTO_INCREMENT,
  `estadolaboral_nombre` VARCHAR(60) NULL,
  PRIMARY KEY (`estadolaboral_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_boutique_mvc`.`horario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_boutique_mvc`.`horario` (
  `horario_id` INT NOT NULL AUTO_INCREMENT,
  `horario_fecha` DATE NULL,
  `horario_hora_inicio` TIME NULL,
  `horario_hora_fin` TIME NULL,
  `horario_detalle` TEXT NULL,
  `estadolaboral_id` INT NOT NULL,
  `userid` INT NOT NULL,
  PRIMARY KEY (`horario_id`, `estadolaboral_id`, `userid`),
  CONSTRAINT `fk_horario_estadolaboral1`
    FOREIGN KEY (`estadolaboral_id`)
    REFERENCES `db_boutique_mvc`.`estadolaboral` (`estadolaboral_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_horario_users1`
    FOREIGN KEY (`userid`)
    REFERENCES `db_boutique_mvc`.`users` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
