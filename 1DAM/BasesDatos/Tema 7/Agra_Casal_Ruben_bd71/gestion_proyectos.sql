-- MariaDB dump 10.19  Distrib 10.11.6-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: gestion_proyectos
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


CREATE DATABASE IF NOT EXISTS gestion_proyectos;
USE gestion_proyectos;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `dni` char(8) NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `anhoExp` tinyint(3) unsigned DEFAULT NULL,
  `horasPrevistas` mediumint(8) unsigned DEFAULT NULL,
  `tipo` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `esta`
--

DROP TABLE IF EXISTS `esta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `esta` (
  `dni` char(8) NOT NULL,
  `codProyecto` char(7) NOT NULL,
  `horasPrevistas` mediumint(9) DEFAULT NULL,
  PRIMARY KEY (`dni`,`codProyecto`),
  KEY `codProyecto` (`codProyecto`),
  CONSTRAINT `esta_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `empleado` (`dni`),
  CONSTRAINT `esta_ibfk_2` FOREIGN KEY (`codProyecto`) REFERENCES `proyecto` (`codProyecto`)
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
-- Table structure for table `fase`
--

DROP TABLE IF EXISTS `fase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fase` (
  `codFase` char(8) NOT NULL,
  `nombre` varchar(15) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `codProyecto` char(7) DEFAULT NULL,
  PRIMARY KEY (`codFase`),
  KEY `codProyecto` (`codProyecto`),
  CONSTRAINT `fase_ibfk_1` FOREIGN KEY (`codProyecto`) REFERENCES `proyecto` (`codProyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase`
--

LOCK TABLES `fase` WRITE;
/*!40000 ALTER TABLE `fase` DISABLE KEYS */;
/*!40000 ALTER TABLE `fase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gasto`
--

DROP TABLE IF EXISTS `gasto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gasto` (
  `idGasto` char(10) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `importe` float(7,2) NOT NULL,
  `tipoGasto` varchar(25) NOT NULL,
  `codProyecto` char(7) DEFAULT NULL,
  PRIMARY KEY (`idGasto`),
  KEY `codProyecto` (`codProyecto`),
  CONSTRAINT `gasto_ibfk_1` FOREIGN KEY (`codProyecto`) REFERENCES `proyecto` (`codProyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gasto`
--

LOCK TABLES `gasto` WRITE;
/*!40000 ALTER TABLE `gasto` DISABLE KEYS */;
/*!40000 ALTER TABLE `gasto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genera`
--

DROP TABLE IF EXISTS `genera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genera` (
  `codFase` char(8) NOT NULL,
  `codProducto` char(7) NOT NULL,
  PRIMARY KEY (`codFase`,`codProducto`),
  KEY `codProducto` (`codProducto`),
  CONSTRAINT `genera_ibfk_1` FOREIGN KEY (`codFase`) REFERENCES `fase` (`codFase`),
  CONSTRAINT `genera_ibfk_2` FOREIGN KEY (`codProducto`) REFERENCES `producto` (`codProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genera`
--

LOCK TABLES `genera` WRITE;
/*!40000 ALTER TABLE `genera` DISABLE KEYS */;
/*!40000 ALTER TABLE `genera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lenguajes`
--

DROP TABLE IF EXISTS `lenguajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lenguajes` (
  `dni` char(8) NOT NULL,
  `lenguajeProg` varchar(100) NOT NULL,
  PRIMARY KEY (`dni`,`lenguajeProg`),
  CONSTRAINT `lenguajes_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `empleado` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lenguajes`
--

LOCK TABLES `lenguajes` WRITE;
/*!40000 ALTER TABLE `lenguajes` DISABLE KEYS */;
/*!40000 ALTER TABLE `lenguajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lidera`
--

DROP TABLE IF EXISTS `lidera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lidera` (
  `dni` char(8) NOT NULL,
  `codProyecto` char(7) NOT NULL,
  `horasPrevistas` mediumint(9) DEFAULT NULL,
  PRIMARY KEY (`dni`,`codProyecto`),
  KEY `codProyecto` (`codProyecto`),
  CONSTRAINT `lidera_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `empleado` (`dni`),
  CONSTRAINT `lidera_ibfk_2` FOREIGN KEY (`codProyecto`) REFERENCES `proyecto` (`codProyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lidera`
--

LOCK TABLES `lidera` WRITE;
/*!40000 ALTER TABLE `lidera` DISABLE KEYS */;
/*!40000 ALTER TABLE `lidera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `codProducto` char(7) NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `tipo` varchar(10) DEFAULT NULL,
  `version` varchar(3) DEFAULT NULL,
  `dni` char(8) DEFAULT NULL,
  PRIMARY KEY (`codProducto`),
  KEY `dni` (`dni`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `empleado` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyecto` (
  `codProyecto` char(7) NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `cliente` varchar(25) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `presupuesto` float(8,2) DEFAULT NULL,
  `nºhoras` mediumint(9) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  PRIMARY KEY (`codProyecto`)
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
-- Table structure for table `proyectosRelacionados`
--

DROP TABLE IF EXISTS `proyectosRelacionados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyectosRelacionados` (
  `codProyecto` char(7) NOT NULL,
  `proyectoRelacionado` varchar(30) NOT NULL,
  PRIMARY KEY (`codProyecto`,`proyectoRelacionado`),
  CONSTRAINT `proyectosRelacionados_ibfk_1` FOREIGN KEY (`codProyecto`) REFERENCES `proyecto` (`codProyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectosRelacionados`
--

LOCK TABLES `proyectosRelacionados` WRITE;
/*!40000 ALTER TABLE `proyectosRelacionados` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyectosRelacionados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titulacion`
--

DROP TABLE IF EXISTS `titulacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `titulacion` (
  `dni` char(8) NOT NULL,
  `titulacion` varchar(150) NOT NULL,
  PRIMARY KEY (`dni`,`titulacion`),
  CONSTRAINT `titulacion_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `empleado` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titulacion`
--

LOCK TABLES `titulacion` WRITE;
/*!40000 ALTER TABLE `titulacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `titulacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-07 20:16:45
