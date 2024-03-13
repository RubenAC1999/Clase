-- MariaDB dump 10.19  Distrib 10.11.6-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: administracion_fincas
-- ------------------------------------------------------
-- Server version	10.11.6-MariaDB-0+deb12u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


CREATE DATABASE IF NOT EXISTS administracion_fincas;
USE administracion_fincas;


--
-- Table structure for table `abogado`
--

DROP TABLE IF EXISTS `abogado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abogado` (
  `dni` char(9) NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `nColegiado` char(9) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abogado`
--

LOCK TABLES `abogado` WRITE;
/*!40000 ALTER TABLE `abogado` DISABLE KEYS */;
INSERT INTO `abogado` VALUES
('12345678A','Antonio Pérez','123456789'),
('12345678B','Marcos Lado','123456788'),
('12345678C','Lucía Fernández','123456787');
/*!40000 ALTER TABLE `abogado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administra`
--

DROP TABLE IF EXISTS `administra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administra` (
  `dniAbogado` char(9) NOT NULL,
  `idComunidad` char(6) NOT NULL,
  `honorariosAnuales` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`dniAbogado`,`idComunidad`),
  KEY `idComunidad` (`idComunidad`),
  CONSTRAINT `administra_ibfk_1` FOREIGN KEY (`dniAbogado`) REFERENCES `abogado` (`dni`),
  CONSTRAINT `administra_ibfk_2` FOREIGN KEY (`idComunidad`) REFERENCES `comunidad` (`idComunidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administra`
--

LOCK TABLES `administra` WRITE;
/*!40000 ALTER TABLE `administra` DISABLE KEYS */;
INSERT INTO `administra` VALUES
('12345678A','123457',24000.00),
('12345678B','123458',18000.00),
('12345678C','123456',20000.00);
/*!40000 ALTER TABLE `administra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banco`
--

DROP TABLE IF EXISTS `banco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banco` (
  `codBanco` char(6) NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `personaContacto` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`codBanco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banco`
--

LOCK TABLES `banco` WRITE;
/*!40000 ALTER TABLE `banco` DISABLE KEYS */;
INSERT INTO `banco` VALUES
('12345A','Banco santander','Rodolfo Suárez'),
('12346B','Banco BBVA','Pedro Pérez'),
('12347C','Banco LaCaixa','Roberto Mato');
/*!40000 ALTER TABLE `banco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companhia`
--

DROP TABLE IF EXISTS `companhia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `companhia` (
  `cifCompanhia` char(9) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `telefono` char(9) NOT NULL,
  `personaContacto` varchar(25) NOT NULL,
  `sector` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  PRIMARY KEY (`cifCompanhia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companhia`
--

LOCK TABLES `companhia` WRITE;
/*!40000 ALTER TABLE `companhia` DISABLE KEYS */;
INSERT INTO `companhia` VALUES
('A12345678','Naturgy','981828282','Andrés Iniesta','Energía','Calle Kalise 11'),
('B12345678','Iberdrola','981623212','Javier Hernández','Energía','Calle Calippo 23'),
('C12345678','Luz del sur','665123596','Miguel Torres','Energía','Calle Francisco Franco 666');
/*!40000 ALTER TABLE `companhia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comunidad`
--

DROP TABLE IF EXISTS `comunidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comunidad` (
  `idComunidad` char(6) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `calle` varchar(30) NOT NULL,
  `cp` mediumint(8) unsigned NOT NULL,
  `poblacion` varchar(15) NOT NULL,
  `codCuenta` char(8) NOT NULL,
  PRIMARY KEY (`idComunidad`),
  KEY `codCuenta` (`codCuenta`),
  CONSTRAINT `comunidad_ibfk_1` FOREIGN KEY (`codCuenta`) REFERENCES `cuentaBancaria` (`codCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comunidad`
--

LOCK TABLES `comunidad` WRITE;
/*!40000 ALTER TABLE `comunidad` DISABLE KEYS */;
INSERT INTO `comunidad` VALUES
('123456','Viviendas El Ruedo','Calle Móstoles 12',12900,'230','11111111'),
('123457','Edificio Mirador','Calle VistaHermosa 13',15200,'92','22222222'),
('123458','Comunidad Montepinar','Avenida Sierra León 2',21000,'112','33333333');
/*!40000 ALTER TABLE `comunidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrata`
--

DROP TABLE IF EXISTS `contrata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrata` (
  `idComunidad` char(6) NOT NULL,
  `cifCompanhia` char(9) NOT NULL,
  PRIMARY KEY (`idComunidad`,`cifCompanhia`),
  KEY `cifCompanhia` (`cifCompanhia`),
  CONSTRAINT `contrata_ibfk_1` FOREIGN KEY (`idComunidad`) REFERENCES `comunidad` (`idComunidad`),
  CONSTRAINT `contrata_ibfk_2` FOREIGN KEY (`cifCompanhia`) REFERENCES `companhia` (`cifCompanhia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrata`
--

LOCK TABLES `contrata` WRITE;
/*!40000 ALTER TABLE `contrata` DISABLE KEYS */;
INSERT INTO `contrata` VALUES
('123456','B12345678'),
('123457','A12345678'),
('123458','C12345678');
/*!40000 ALTER TABLE `contrata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentaBancaria`
--

DROP TABLE IF EXISTS `cuentaBancaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuentaBancaria` (
  `codCuenta` char(8) NOT NULL,
  `saldo` float(10,2) DEFAULT NULL,
  `codBanco` char(6) DEFAULT NULL,
  PRIMARY KEY (`codCuenta`),
  KEY `codBanco` (`codBanco`),
  CONSTRAINT `cuentaBancaria_ibfk_1` FOREIGN KEY (`codBanco`) REFERENCES `banco` (`codBanco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentaBancaria`
--

LOCK TABLES `cuentaBancaria` WRITE;
/*!40000 ALTER TABLE `cuentaBancaria` DISABLE KEYS */;
INSERT INTO `cuentaBancaria` VALUES
('11111111',380000.00,'12346B'),
('22222222',150000.00,'12345A'),
('33333333',230000.00,'12347C');
/*!40000 ALTER TABLE `cuentaBancaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquilino`
--

DROP TABLE IF EXISTS `inquilino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inquilino` (
  `dniInquilino` char(9) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `telefono` char(9) NOT NULL,
  PRIMARY KEY (`dniInquilino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquilino`
--

LOCK TABLES `inquilino` WRITE;
/*!40000 ALTER TABLE `inquilino` DISABLE KEYS */;
INSERT INTO `inquilino` VALUES
('12345678D','Lucas','Prieto Pérez','981825379'),
('12345678G','Pepe','Piñeiro Souto','981825380'),
('12345678H','Isaac','Williams Torrado','981825390');
/*!40000 ALTER TABLE `inquilino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localComercial`
--

DROP TABLE IF EXISTS `localComercial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localComercial` (
  `nPortal` tinyint(4) NOT NULL,
  `planta` varchar(2) NOT NULL,
  `letra` char(1) NOT NULL,
  `tipoComercio` varchar(25) DEFAULT NULL,
  `horario` varchar(15) DEFAULT NULL,
  `idComunidad` char(6) DEFAULT NULL,
  `dniInquilino` char(9) DEFAULT NULL,
  `dniPropietario` char(9) DEFAULT NULL,
  PRIMARY KEY (`nPortal`,`planta`,`letra`),
  KEY `idComunidad` (`idComunidad`),
  KEY `dniInquilino` (`dniInquilino`),
  KEY `dniPropietario` (`dniPropietario`),
  CONSTRAINT `localComercial_ibfk_1` FOREIGN KEY (`idComunidad`) REFERENCES `comunidad` (`idComunidad`),
  CONSTRAINT `localComercial_ibfk_2` FOREIGN KEY (`dniInquilino`) REFERENCES `inquilino` (`dniInquilino`),
  CONSTRAINT `localComercial_ibfk_3` FOREIGN KEY (`dniPropietario`) REFERENCES `propietario` (`dniPropietario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localComercial`
--

LOCK TABLES `localComercial` WRITE;
/*!40000 ALTER TABLE `localComercial` DISABLE KEYS */;
INSERT INTO `localComercial` VALUES
(12,'1','D','Peluquería y Estética','9:00 - 20:00','123458','12345678G','12345678F');
/*!40000 ALTER TABLE `localComercial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oficina`
--

DROP TABLE IF EXISTS `oficina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oficina` (
  `nPortal` tinyint(4) NOT NULL,
  `planta` varchar(2) NOT NULL,
  `letra` char(1) NOT NULL,
  `actividadDestinada` varchar(100) DEFAULT NULL,
  `idComunidad` char(6) DEFAULT NULL,
  `dniInquilino` char(9) DEFAULT NULL,
  `dniPropietario` char(9) DEFAULT NULL,
  PRIMARY KEY (`nPortal`,`planta`,`letra`),
  KEY `idComunidad` (`idComunidad`),
  KEY `dniInquilino` (`dniInquilino`),
  KEY `dniPropietario` (`dniPropietario`),
  CONSTRAINT `oficina_ibfk_1` FOREIGN KEY (`idComunidad`) REFERENCES `comunidad` (`idComunidad`),
  CONSTRAINT `oficina_ibfk_2` FOREIGN KEY (`dniInquilino`) REFERENCES `inquilino` (`dniInquilino`),
  CONSTRAINT `oficina_ibfk_3` FOREIGN KEY (`dniPropietario`) REFERENCES `propietario` (`dniPropietario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oficina`
--

LOCK TABLES `oficina` WRITE;
/*!40000 ALTER TABLE `oficina` DISABLE KEYS */;
INSERT INTO `oficina` VALUES
(2,'2','A','Administración','123456','12345678G','12345678E'),
(4,'1','A','Administración','123458','12345678D','12345678E'),
(10,'3','D','Administración','123458','12345678H','12345678E');
/*!40000 ALTER TABLE `oficina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propietario`
--

DROP TABLE IF EXISTS `propietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `propietario` (
  `dniPropietario` char(9) NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `apellidos` varchar(30) DEFAULT NULL,
  `telefono` char(9) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`dniPropietario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propietario`
--

LOCK TABLES `propietario` WRITE;
/*!40000 ALTER TABLE `propietario` DISABLE KEYS */;
INSERT INTO `propietario` VALUES
('12345678D','Lucas','Prieto Pérez','981825379','Calle Rosaleda 21','Presidente'),
('12345678E','Ricardo','Gómez Casal','981825378','Calle Rosaledo 23','Persona común'),
('12345678F','Manuel','Machado García','981825377','Calle Rosalede 25','Vocal');
/*!40000 ALTER TABLE `propietario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo` (
  `numRecibo` char(9) NOT NULL,
  `fecha` char(10) NOT NULL,
  `importe` float(7,2) DEFAULT NULL,
  `tipoApunte` varchar(15) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `idComunidad` char(6) DEFAULT NULL,
  `codCuenta` char(8) DEFAULT NULL,
  `cifCompanhia` char(9) DEFAULT NULL,
  PRIMARY KEY (`numRecibo`),
  KEY `idComunidad` (`idComunidad`),
  KEY `codCuenta` (`codCuenta`),
  KEY `cifCompanhia` (`cifCompanhia`),
  CONSTRAINT `recibo_ibfk_1` FOREIGN KEY (`idComunidad`) REFERENCES `comunidad` (`idComunidad`),
  CONSTRAINT `recibo_ibfk_2` FOREIGN KEY (`codCuenta`) REFERENCES `cuentaBancaria` (`codCuenta`),
  CONSTRAINT `recibo_ibfk_3` FOREIGN KEY (`cifCompanhia`) REFERENCES `companhia` (`cifCompanhia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo`
--

LOCK TABLES `recibo` WRITE;
/*!40000 ALTER TABLE `recibo` DISABLE KEYS */;
INSERT INTO `recibo` VALUES
('111111111','2023-12-01',150.00,'Ingreso','Cobrado','123456','22222222',NULL),
('222222222','2023-12-01',320.00,'Cobro',NULL,'123458','33333333','C12345678'),
('333333333','2023-12-01',223.00,'Ingreso','No cobrado','123457','11111111',NULL);
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viviendaParticular`
--

DROP TABLE IF EXISTS `viviendaParticular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viviendaParticular` (
  `nPortal` tinyint(4) NOT NULL,
  `planta` varchar(2) NOT NULL,
  `letra` char(1) NOT NULL,
  `nHabitaciones` tinyint(4) DEFAULT NULL,
  `idComunidad` char(6) DEFAULT NULL,
  `dniInquilino` char(9) DEFAULT NULL,
  `dniPropietario` char(9) DEFAULT NULL,
  PRIMARY KEY (`nPortal`,`planta`,`letra`),
  KEY `idComunidad` (`idComunidad`),
  KEY `dniPropietario` (`dniPropietario`),
  KEY `dniInquilino` (`dniInquilino`),
  CONSTRAINT `viviendaParticular_ibfk_1` FOREIGN KEY (`idComunidad`) REFERENCES `comunidad` (`idComunidad`),
  CONSTRAINT `viviendaParticular_ibfk_2` FOREIGN KEY (`dniPropietario`) REFERENCES `propietario` (`dniPropietario`),
  CONSTRAINT `viviendaParticular_ibfk_3` FOREIGN KEY (`dniInquilino`) REFERENCES `inquilino` (`dniInquilino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viviendaParticular`
--

LOCK TABLES `viviendaParticular` WRITE;
/*!40000 ALTER TABLE `viviendaParticular` DISABLE KEYS */;
INSERT INTO `viviendaParticular` VALUES
(13,'1','B',4,'123457','12345678H','12345678D'),
(13,'2','D',3,'123457','12345678D','12345678D'),
(13,'2','I',3,'123457','12345678G','12345678D');
/*!40000 ALTER TABLE `viviendaParticular` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-07 20:18:45
