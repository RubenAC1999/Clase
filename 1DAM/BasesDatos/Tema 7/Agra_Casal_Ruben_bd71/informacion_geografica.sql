-- MariaDB dump 10.19  Distrib 10.11.6-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: informacion_geografica
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


CREATE DATABASE IF NOT EXISTS informacion_geografica;
USE informacion_geografica;

--
-- Table structure for table `accidente_geografico`
--

DROP TABLE IF EXISTS `accidente_geografico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accidente_geografico` (
  `posVertical` mediumint(9) NOT NULL,
  `posHorizontal` mediumint(9) NOT NULL,
  `nombreAccidente` varchar(60) NOT NULL,
  `tipo` varchar(7) NOT NULL,
  PRIMARY KEY (`posVertical`,`posHorizontal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accidente_geografico`
--

LOCK TABLES `accidente_geografico` WRITE;
/*!40000 ALTER TABLE `accidente_geografico` DISABLE KEYS */;
/*!40000 ALTER TABLE `accidente_geografico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contiene`
--

DROP TABLE IF EXISTS `contiene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contiene` (
  `nombrePais` varchar(25) NOT NULL,
  `idLocalidad` char(6) NOT NULL,
  PRIMARY KEY (`nombrePais`,`idLocalidad`),
  KEY `idLocalidad` (`idLocalidad`),
  CONSTRAINT `contiene_ibfk_1` FOREIGN KEY (`nombrePais`) REFERENCES `pais` (`nombrePais`),
  CONSTRAINT `contiene_ibfk_2` FOREIGN KEY (`idLocalidad`) REFERENCES `localidad` (`idLocalidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contiene`
--

LOCK TABLES `contiene` WRITE;
/*!40000 ALTER TABLE `contiene` DISABLE KEYS */;
/*!40000 ALTER TABLE `contiene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lago`
--

DROP TABLE IF EXISTS `lago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lago` (
  `posVertical` mediumint(9) NOT NULL,
  `posHorizontal` mediumint(9) NOT NULL,
  `extension` mediumint(9) NOT NULL,
  PRIMARY KEY (`posVertical`,`posHorizontal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lago`
--

LOCK TABLES `lago` WRITE;
/*!40000 ALTER TABLE `lago` DISABLE KEYS */;
/*!40000 ALTER TABLE `lago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidad`
--

DROP TABLE IF EXISTS `localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidad` (
  `idLocalidad` char(5) NOT NULL,
  `nombreLocalidad` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idLocalidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidad`
--

LOCK TABLES `localidad` WRITE;
/*!40000 ALTER TABLE `localidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `localidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `montaña`
--

DROP TABLE IF EXISTS `montaña`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `montaña` (
  `posVertical` mediumint(9) NOT NULL,
  `posHorizontal` mediumint(9) NOT NULL,
  `altitud` smallint(6) NOT NULL,
  PRIMARY KEY (`posVertical`,`posHorizontal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `montaña`
--

LOCK TABLES `montaña` WRITE;
/*!40000 ALTER TABLE `montaña` DISABLE KEYS */;
/*!40000 ALTER TABLE `montaña` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `nombrePais` varchar(25) NOT NULL,
  `extension` mediumint(8) unsigned NOT NULL,
  `poblacion` varchar(15) NOT NULL,
  PRIMARY KEY (`nombrePais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasa`
--

DROP TABLE IF EXISTS `pasa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasa` (
  `posVertical` mediumint(9) NOT NULL,
  `posHorizontal` mediumint(9) NOT NULL,
  `idLocalidad` char(6) NOT NULL,
  PRIMARY KEY (`posVertical`,`posHorizontal`,`idLocalidad`),
  KEY `idLocalidad` (`idLocalidad`),
  CONSTRAINT `pasa_ibfk_1` FOREIGN KEY (`posVertical`) REFERENCES `accidente_geografico` (`posVertical`),
  CONSTRAINT `pasa_ibfk_2` FOREIGN KEY (`idLocalidad`) REFERENCES `localidad` (`idLocalidad`),
  CONSTRAINT `pasa_ibfk_3` FOREIGN KEY (`posVertical`, `posHorizontal`) REFERENCES `accidente_geografico` (`posVertical`, `posHorizontal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasa`
--

LOCK TABLES `pasa` WRITE;
/*!40000 ALTER TABLE `pasa` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rio`
--

DROP TABLE IF EXISTS `rio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rio` (
  `posVertical` mediumint(9) NOT NULL,
  `posHorizontal` mediumint(9) NOT NULL,
  `longitud` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`posVertical`),
  CONSTRAINT `rio_ibfk_1` FOREIGN KEY (`posVertical`) REFERENCES `accidente_geografico` (`posVertical`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rio`
--

LOCK TABLES `rio` WRITE;
/*!40000 ALTER TABLE `rio` DISABLE KEYS */;
/*!40000 ALTER TABLE `rio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiene`
--

DROP TABLE IF EXISTS `tiene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiene` (
  `posVertical` mediumint(9) NOT NULL,
  `posHorizontal` mediumint(9) NOT NULL,
  `nombrePais` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`posVertical`,`posHorizontal`),
  KEY `nombrePais` (`nombrePais`),
  CONSTRAINT `tiene_ibfk_1` FOREIGN KEY (`posVertical`, `posHorizontal`) REFERENCES `accidente_geografico` (`posVertical`, `posHorizontal`),
  CONSTRAINT `tiene_ibfk_2` FOREIGN KEY (`nombrePais`) REFERENCES `pais` (`nombrePais`),
  CONSTRAINT `tiene_ibfk_3` FOREIGN KEY (`posVertical`, `posHorizontal`) REFERENCES `accidente_geografico` (`posVertical`, `posHorizontal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiene`
--

LOCK TABLES `tiene` WRITE;
/*!40000 ALTER TABLE `tiene` DISABLE KEYS */;
/*!40000 ALTER TABLE `tiene` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-07 20:20:21
