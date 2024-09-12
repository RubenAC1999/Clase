-- MariaDB dump 10.19  Distrib 10.11.6-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: parques_naturales
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


CREATE DATABASE IF NOT EXISTS parques_naturales;
USE parques_naturales;


--
-- Table structure for table `alojamiento`
--

DROP TABLE IF EXISTS `alojamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alojamiento` (
  `IDAlojamiento` char(5) NOT NULL,
  `categoria` varchar(10) NOT NULL,
  `capacidad` smallint(5) unsigned NOT NULL,
  `IDParque` char(6) NOT NULL,
  PRIMARY KEY (`IDAlojamiento`),
  KEY `IDParque` (`IDParque`),
  CONSTRAINT `alojamiento_ibfk_1` FOREIGN KEY (`IDParque`) REFERENCES `parqueNatural` (`IDParque`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alojamiento`
--

LOCK TABLES `alojamiento` WRITE;
/*!40000 ALTER TABLE `alojamiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `alojamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal` (
  `denCientifica` varchar(50) NOT NULL,
  `numIndividuos` smallint(5) unsigned NOT NULL,
  `denVulgar` varchar(50) NOT NULL,
  `periodoCelo` varchar(10) NOT NULL,
  `tipoAlimentacion` varchar(10) NOT NULL,
  PRIMARY KEY (`denCientifica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `IDArea` char(7) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `extension` float NOT NULL,
  PRIMARY KEY (`IDArea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asiste`
--

DROP TABLE IF EXISTS `asiste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asiste` (
  `IDExcursion` char(4) NOT NULL,
  `DNI` char(9) NOT NULL,
  PRIMARY KEY (`IDExcursion`,`DNI`),
  KEY `DNI` (`DNI`),
  CONSTRAINT `asiste_ibfk_1` FOREIGN KEY (`IDExcursion`) REFERENCES `excursion` (`IDExcursion`),
  CONSTRAINT `asiste_ibfk_2` FOREIGN KEY (`DNI`) REFERENCES `visitante` (`DNIVisitante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asiste`
--

LOCK TABLES `asiste` WRITE;
/*!40000 ALTER TABLE `asiste` DISABLE KEYS */;
/*!40000 ALTER TABLE `asiste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compone`
--

DROP TABLE IF EXISTS `compone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compone` (
  `IDParque` char(6) NOT NULL,
  `IDArea` char(7) NOT NULL,
  PRIMARY KEY (`IDParque`,`IDArea`),
  KEY `IDArea` (`IDArea`),
  CONSTRAINT `compone_ibfk_1` FOREIGN KEY (`IDParque`) REFERENCES `parqueNatural` (`IDParque`),
  CONSTRAINT `compone_ibfk_2` FOREIGN KEY (`IDArea`) REFERENCES `area` (`IDArea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compone`
--

LOCK TABLES `compone` WRITE;
/*!40000 ALTER TABLE `compone` DISABLE KEYS */;
/*!40000 ALTER TABLE `compone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comunidadAutonoma`
--

DROP TABLE IF EXISTS `comunidadAutonoma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comunidadAutonoma` (
  `nombreCA` varchar(25) NOT NULL,
  `nºParques` tinyint(3) unsigned DEFAULT NULL,
  `superficieTotal` float unsigned NOT NULL,
  PRIMARY KEY (`nombreCA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comunidadAutonoma`
--

LOCK TABLES `comunidadAutonoma` WRITE;
/*!40000 ALTER TABLE `comunidadAutonoma` DISABLE KEYS */;
/*!40000 ALTER TABLE `comunidadAutonoma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `esta`
--

DROP TABLE IF EXISTS `esta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `esta` (
  `IDParque` char(6) NOT NULL,
  `nombreCA` varchar(25) NOT NULL,
  PRIMARY KEY (`IDParque`,`nombreCA`),
  KEY `nombreCA` (`nombreCA`),
  CONSTRAINT `esta_ibfk_1` FOREIGN KEY (`IDParque`) REFERENCES `parqueNatural` (`IDParque`),
  CONSTRAINT `esta_ibfk_2` FOREIGN KEY (`nombreCA`) REFERENCES `comunidadAutonoma` (`nombreCA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `esta`
--

LOCK TABLES `esta` WRITE;
/*!40000 ALTER TABLE `esta` DISABLE KEYS */;
/*!40000 ALTER TABLE `esta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `excursion`
--

DROP TABLE IF EXISTS `excursion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `excursion` (
  `IDExcursion` char(4) NOT NULL,
  `aPie` tinyint(1) NOT NULL,
  `vehiculo` tinyint(1) NOT NULL,
  `IDAlojamiento` char(5) NOT NULL,
  PRIMARY KEY (`IDExcursion`),
  KEY `IDAlojamiento` (`IDAlojamiento`),
  CONSTRAINT `excursion_ibfk_1` FOREIGN KEY (`IDAlojamiento`) REFERENCES `alojamiento` (`IDAlojamiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excursion`
--

LOCK TABLES `excursion` WRITE;
/*!40000 ALTER TABLE `excursion` DISABLE KEYS */;
/*!40000 ALTER TABLE `excursion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organismo`
--

DROP TABLE IF EXISTS `organismo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organismo` (
  `IDOrganismo` char(5) NOT NULL,
  `nombreCA` varchar(50) NOT NULL,
  PRIMARY KEY (`IDOrganismo`),
  KEY `nombreCA` (`nombreCA`),
  CONSTRAINT `organismo_ibfk_1` FOREIGN KEY (`nombreCA`) REFERENCES `comunidadAutonoma` (`nombreCA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organismo`
--

LOCK TABLES `organismo` WRITE;
/*!40000 ALTER TABLE `organismo` DISABLE KEYS */;
/*!40000 ALTER TABLE `organismo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parqueNatural`
--

DROP TABLE IF EXISTS `parqueNatural`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parqueNatural` (
  `IDParque` char(6) NOT NULL,
  `fechaDeclaracion` date NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`IDParque`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parqueNatural`
--

LOCK TABLES `parqueNatural` WRITE;
/*!40000 ALTER TABLE `parqueNatural` DISABLE KEYS */;
/*!40000 ALTER TABLE `parqueNatural` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal` (
  `DNI` char(9) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telDomicilio` char(9) NOT NULL,
  `telMovil` char(9) NOT NULL,
  `nEntrada` tinyint(3) unsigned NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `especialidad` varchar(15) NOT NULL,
  `NºSS` char(12) NOT NULL,
  `IDOrganismo` char(5) NOT NULL,
  `IDArea` char(7) NOT NULL,
  PRIMARY KEY (`DNI`),
  UNIQUE KEY `NºSS` (`NºSS`),
  KEY `IDOrganismo` (`IDOrganismo`),
  KEY `IDArea` (`IDArea`),
  CONSTRAINT `personal_ibfk_1` FOREIGN KEY (`IDOrganismo`) REFERENCES `organismo` (`IDOrganismo`),
  CONSTRAINT `personal_ibfk_2` FOREIGN KEY (`IDArea`) REFERENCES `area` (`IDArea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyecto` (
  `codProyecto` char(4) NOT NULL,
  `presupuesto` float NOT NULL,
  `periodoRealizacion` varchar(10) NOT NULL,
  `DNI` char(9) NOT NULL,
  `denCientifica` varchar(50) NOT NULL,
  PRIMARY KEY (`codProyecto`),
  KEY `DNI` (`DNI`),
  KEY `denCientifica` (`denCientifica`),
  CONSTRAINT `proyecto_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `personal` (`DNI`),
  CONSTRAINT `proyecto_ibfk_2` FOREIGN KEY (`denCientifica`) REFERENCES `animal` (`denCientifica`),
  CONSTRAINT `proyecto_ibfk_3` FOREIGN KEY (`denCientifica`) REFERENCES `vegetal` (`denCientifica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `realiza`
--

DROP TABLE IF EXISTS `realiza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `realiza` (
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `IDAlojamiento` char(5) NOT NULL,
  `IDExcursion` char(4) NOT NULL,
  PRIMARY KEY (`IDAlojamiento`,`IDExcursion`),
  KEY `IDExcursion` (`IDExcursion`),
  CONSTRAINT `realiza_ibfk_1` FOREIGN KEY (`IDAlojamiento`) REFERENCES `alojamiento` (`IDAlojamiento`),
  CONSTRAINT `realiza_ibfk_2` FOREIGN KEY (`IDExcursion`) REFERENCES `excursion` (`IDExcursion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `realiza`
--

LOCK TABLES `realiza` WRITE;
/*!40000 ALTER TABLE `realiza` DISABLE KEYS */;
/*!40000 ALTER TABLE `realiza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reside`
--

DROP TABLE IF EXISTS `reside`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reside` (
  `IDArea` char(7) NOT NULL,
  `denCientifica` varchar(50) NOT NULL,
  PRIMARY KEY (`IDArea`,`denCientifica`),
  KEY `denCientifica` (`denCientifica`),
  CONSTRAINT `reside_ibfk_1` FOREIGN KEY (`IDArea`) REFERENCES `area` (`IDArea`),
  CONSTRAINT `reside_ibfk_2` FOREIGN KEY (`denCientifica`) REFERENCES `animal` (`denCientifica`),
  CONSTRAINT `reside_ibfk_3` FOREIGN KEY (`denCientifica`) REFERENCES `vegetal` (`denCientifica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reside`
--

LOCK TABLES `reside` WRITE;
/*!40000 ALTER TABLE `reside` DISABLE KEYS */;
/*!40000 ALTER TABLE `reside` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seAlimentaDe`
--

DROP TABLE IF EXISTS `seAlimentaDe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seAlimentaDe` (
  `denCientifica` varchar(50) NOT NULL,
  `denCientificaAlimento` varchar(50) NOT NULL,
  PRIMARY KEY (`denCientifica`,`denCientificaAlimento`),
  KEY `denCientificaAlimento` (`denCientificaAlimento`),
  CONSTRAINT `seAlimentaDe_ibfk_1` FOREIGN KEY (`denCientifica`) REFERENCES `animal` (`denCientifica`),
  CONSTRAINT `seAlimentaDe_ibfk_2` FOREIGN KEY (`denCientifica`) REFERENCES `vegetal` (`denCientifica`),
  CONSTRAINT `seAlimentaDe_ibfk_3` FOREIGN KEY (`denCientificaAlimento`) REFERENCES `vegetal` (`denCientifica`),
  CONSTRAINT `seAlimentaDe_ibfk_4` FOREIGN KEY (`denCientificaAlimento`) REFERENCES `animal` (`denCientifica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seAlimentaDe`
--

LOCK TABLES `seAlimentaDe` WRITE;
/*!40000 ALTER TABLE `seAlimentaDe` DISABLE KEYS */;
/*!40000 ALTER TABLE `seAlimentaDe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titulacion`
--

DROP TABLE IF EXISTS `titulacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `titulacion` (
  `DNI` char(9) NOT NULL,
  `titulacion` varchar(15) NOT NULL,
  PRIMARY KEY (`DNI`,`titulacion`),
  CONSTRAINT `titulacion_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `personal` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titulacion`
--

LOCK TABLES `titulacion` WRITE;
/*!40000 ALTER TABLE `titulacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `titulacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabaja`
--

DROP TABLE IF EXISTS `trabaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabaja` (
  `DNI` char(9) NOT NULL,
  `codProyecto` char(4) NOT NULL,
  KEY `DNI` (`DNI`),
  KEY `codProyecto` (`codProyecto`),
  CONSTRAINT `trabaja_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `personal` (`DNI`),
  CONSTRAINT `trabaja_ibfk_2` FOREIGN KEY (`codProyecto`) REFERENCES `proyecto` (`codProyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabaja`
--

LOCK TABLES `trabaja` WRITE;
/*!40000 ALTER TABLE `trabaja` DISABLE KEYS */;
/*!40000 ALTER TABLE `trabaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vegetal`
--

DROP TABLE IF EXISTS `vegetal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vegetal` (
  `denCientifica` varchar(50) NOT NULL,
  `numIndividuos` smallint(5) unsigned NOT NULL,
  `denVulgar` varchar(50) NOT NULL,
  `floracion` varchar(10) NOT NULL,
  `periodoProd` varchar(10) NOT NULL,
  PRIMARY KEY (`denCientifica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vegetal`
--

LOCK TABLES `vegetal` WRITE;
/*!40000 ALTER TABLE `vegetal` DISABLE KEYS */;
/*!40000 ALTER TABLE `vegetal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `matricula` char(7) NOT NULL,
  `tipoVehiculo` varchar(15) NOT NULL,
  `DNI` char(9) NOT NULL,
  PRIMARY KEY (`matricula`),
  KEY `DNI` (`DNI`),
  CONSTRAINT `vehiculo_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `personal` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visita`
--

DROP TABLE IF EXISTS `visita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visita` (
  `IDParque` char(6) NOT NULL,
  `DNIVisitante` char(9) NOT NULL,
  PRIMARY KEY (`IDParque`,`DNIVisitante`),
  KEY `DNIVisitante` (`DNIVisitante`),
  CONSTRAINT `visita_ibfk_1` FOREIGN KEY (`IDParque`) REFERENCES `parqueNatural` (`IDParque`),
  CONSTRAINT `visita_ibfk_2` FOREIGN KEY (`DNIVisitante`) REFERENCES `visitante` (`DNIVisitante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visita`
--

LOCK TABLES `visita` WRITE;
/*!40000 ALTER TABLE `visita` DISABLE KEYS */;
/*!40000 ALTER TABLE `visita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitante`
--

DROP TABLE IF EXISTS `visitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visitante` (
  `DNIVisitante` char(9) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `profesion` varchar(10) NOT NULL,
  `IDAlojamiento` char(5) NOT NULL,
  PRIMARY KEY (`DNIVisitante`),
  KEY `IDAlojamiento` (`IDAlojamiento`),
  CONSTRAINT `visitante_ibfk_1` FOREIGN KEY (`IDAlojamiento`) REFERENCES `alojamiento` (`IDAlojamiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitante`
--

LOCK TABLES `visitante` WRITE;
/*!40000 ALTER TABLE `visitante` DISABLE KEYS */;
/*!40000 ALTER TABLE `visitante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-07 20:23:02
