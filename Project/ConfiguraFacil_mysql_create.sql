SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP SCHEMA IF EXISTS `ConfiguraFacil`;

-- -----------------------------------------------------
-- Schema ConfiguraFacil
-- -----------------------------------------------------
CREATE SCHEMA `ConfiguraFacil` DEFAULT CHARACTER SET utf8 ;
USE `ConfiguraFacil` ;

CREATE TABLE IF NOT EXISTS `Configuracao` (
	`Id` varchar(5) NOT NULL,
	`Preco` double NOT NULL,
	PRIMARY KEY (`Id`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `ComponenteConfiguracao` (
	`IdComponente` varchar(5) NOT NULL,
	`IdConfiguracao` varchar(5) NOT NULL,
    PRIMARY KEY (`IdComponente`,`IdConfiguracao`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Componente` (
	`ID` varchar(5) NOT NULL,
    `TIPO` varchar(15) NOT NULL,
	`Nome` varchar(45) NOT NULL,
	`Descricao` varchar(350) NOT NULL,
	`Preco` double NOT NULL,
	`Quantidade` int NOT NULL,
	PRIMARY KEY (`ID`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Pacote` (
	`Id` varchar(45) NOT NULL,
	`preco` double NOT NULL,
	PRIMARY KEY (`Id`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Empregado` (
	`UserName` varchar(45) NOT NULL,
	`Password` varchar(45) NOT NULL,
	PRIMARY KEY (`UserName`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `ComponentePacote` (
	`IdComponente` varchar(5) NOT NULL,
	`IdPacote` varchar(20) NOT NULL,
    PRIMARY KEY (`IdComponente`,`IdPacote`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `ComponenteNecessidade` (
	`IdComponente` varchar(5) NOT NULL,
    `IdNecessidade` varchar(5) NOT NULL,
    PRIMARY KEY (`IdComponente`,`IdNecessidade`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `ComponenteIncompatibilidade` (
	`IdComponente` varchar(5) NOT NULL,
    `IdIncompatibilidade` varchar(5) NOT NULL,
    PRIMARY KEY (`IdComponente`,`IdIncompatibilidade`)
)
ENGINE = InnoDB;

ALTER TABLE `ComponenteNecessidade` ADD CONSTRAINT `ComponenteNecessidade_fk0` FOREIGN KEY (`IdComponente`) REFERENCES `Componente`(`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `ComponenteNecessidade` ADD CONSTRAINT `ComponenteNecessidade_fk1` FOREIGN KEY (`IdNecessidade`) REFERENCES `Componente`(`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `ComponenteIncompatibilidade` ADD CONSTRAINT `ComponenteIncompatibilidade_fk0` FOREIGN KEY (`IdComponente`) REFERENCES `Componente`(`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `ComponenteIncompatibilidade` ADD CONSTRAINT `ComponenteIncompatabilidade_fk1` FOREIGN KEY (`IdIncompatibilidade`) REFERENCES `Componente`(`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `ComponenteConfiguracao` ADD CONSTRAINT `ComponenteConfiguracao_fk0` FOREIGN KEY (`IdComponente`) REFERENCES `Componente`(`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `ComponenteConfiguracao` ADD CONSTRAINT `ComponenteConfiguracao_fk1` FOREIGN KEY (`IdConfiguracao`) REFERENCES `Configuracao`(`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `ComponentePacote` ADD CONSTRAINT `ComponentePacote_fk0` FOREIGN KEY (`IdComponente`) REFERENCES `Componente`(`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `ComponentePacote` ADD CONSTRAINT `ComponentePacote_fk1` FOREIGN KEY (`IdPacote`) REFERENCES `Pacote`(`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;