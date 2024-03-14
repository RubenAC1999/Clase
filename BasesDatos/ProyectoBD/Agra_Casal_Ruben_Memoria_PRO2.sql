-- MariaDB dump 10.19  Distrib 10.11.6-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: competicion_deportiva
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


CREATE DATABASE competicion_deportiva;
USE competicion_deportiva;
--
-- Table structure for table `Arbitra`
--

DROP TABLE IF EXISTS `Arbitra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Arbitra` (
  `IDArbitro` char(6) NOT NULL,
  `IDPartido` char(5) NOT NULL,
  PRIMARY KEY (`IDArbitro`,`IDPartido`),
  KEY `IDPartido` (`IDPartido`),
  CONSTRAINT `Arbitra_ibfk_1` FOREIGN KEY (`IDArbitro`) REFERENCES `Arbitros` (`IDArbitro`),
  CONSTRAINT `Arbitra_ibfk_2` FOREIGN KEY (`IDPartido`) REFERENCES `Partidos` (`IDPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Arbitra`
--

LOCK TABLES `Arbitra` WRITE;
/*!40000 ALTER TABLE `Arbitra` DISABLE KEYS */;
INSERT INTO `Arbitra` VALUES
('1234','12345'),
('1235','12345'),
('1236','12345'),
('1236','12346'),
('1237','12346'),
('1238','12345'),
('1238','12346'),
('1239','12345'),
('1239','12346'),
('1240','12345'),
('1241','12346'),
('1242','12346');
/*!40000 ALTER TABLE `Arbitra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Arbitros`
--

DROP TABLE IF EXISTS `Arbitros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Arbitros` (
  `IDArbitro` char(6) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `categoria` varchar(10) NOT NULL,
  `especializacion` varchar(15) DEFAULT 'Asistente',
  PRIMARY KEY (`IDArbitro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Arbitros`
--

LOCK TABLES `Arbitros` WRITE;
/*!40000 ALTER TABLE `Arbitros` DISABLE KEYS */;
INSERT INTO `Arbitros` VALUES
('1234','Miguel','Gutiérrez','Principal','Regional','De Campo'),
('1235','Pablo','Vázquez','Asistente','Regional','VAR'),
('1236','Pepe','Moares','Asistente','Nacional','VAR'),
('1237','Borja','Castillos','Principal','Regional','De campo'),
('1238','José Joaquín','Francés','Linier','Regional','De campo'),
('1239','Agustín','Mayo','Asistente','Regional','VAR'),
('1240','Pedro Manuel','Lobo','De Reserva','Nacional','De campo'),
('1241','Luis','Miralles','De Reserva','Nacional','De campo'),
('1242','Miquel','Calero','Asistente','Regional','VAR');
/*!40000 ALTER TABLE `Arbitros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipos`
--

DROP TABLE IF EXISTS `Equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Equipos` (
  `nombreEquipo` varchar(50) NOT NULL,
  `estadio` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `capacidad` mediumint(8) unsigned NOT NULL,
  `fechaFundacion` smallint(5) unsigned NOT NULL,
  `logo` varchar(20) NOT NULL,
  `nombreGrupo` char(7) NOT NULL,
  PRIMARY KEY (`nombreEquipo`),
  KEY `nombreGrupo` (`nombreGrupo`),
  CONSTRAINT `Equipos_ibfk_1` FOREIGN KEY (`nombreGrupo`) REFERENCES `Grupos` (`nombreGrupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipos`
--

LOCK TABLES `Equipos` WRITE;
/*!40000 ALTER TABLE `Equipos` DISABLE KEYS */;
INSERT INTO `Equipos` VALUES
('CD Castellón','Nuevo Castalla','Calle Castellón 34',15500,1922,'castellon.png','Grupo B'),
('Celta B','Campo Municipal de Barreiro','Avda. Ramón Nieto Vigo',1171,1927,'Celtab.png','Grupo A'),
('Córdoba FC','Nuevo Arcángel','C.José Ramón García Fernández',21822,1954,'cordoba.png','Grupo B'),
('Cultural Leonesa','Reino de León','Av. Del Ingeniero de Saez Miera 13',13346,1923,'culturalleonesa.png','Grupo A'),
('Ponferradina','El Toralín','Calle José Luís Saez nº1',10000,1922,'ponferradina.png','Grupo A'),
('UD Ibiza','Estadio Palladium Can Misses','Calle Ibiza 21',6500,2015,'ibiza.png','Grupo B');
/*!40000 ALTER TABLE `Equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estadísticas_de_Equipos`
--

DROP TABLE IF EXISTS `Estadísticas_de_Equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estadísticas_de_Equipos` (
  `codEstadisticaEquipo` char(4) NOT NULL,
  `partGanados` tinyint(3) unsigned NOT NULL,
  `partEmpatados` tinyint(3) unsigned NOT NULL,
  `partPerdidos` tinyint(3) unsigned NOT NULL,
  `puntos` tinyint(3) unsigned NOT NULL,
  `nombreEquipo` varchar(50) NOT NULL,
  PRIMARY KEY (`codEstadisticaEquipo`),
  KEY `nombreEquipo` (`nombreEquipo`),
  CONSTRAINT `Estadísticas_de_Equipos_ibfk_1` FOREIGN KEY (`nombreEquipo`) REFERENCES `Equipos` (`nombreEquipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estadísticas_de_Equipos`
--

LOCK TABLES `Estadísticas_de_Equipos` WRITE;
/*!40000 ALTER TABLE `Estadísticas_de_Equipos` DISABLE KEYS */;
INSERT INTO `Estadísticas_de_Equipos` VALUES
('1111',10,2,4,32,'Celta B'),
('2222',8,6,2,31,'Ponferradina'),
('3333',9,3,4,31,'Cultural Leonesa'),
('4444',12,1,3,37,'CD Castellón'),
('5555',10,5,1,36,'UD Ibiza'),
('6666',10,2,4,32,'Córdoba FC');
/*!40000 ALTER TABLE `Estadísticas_de_Equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estadísticas_de_Jugadores`
--

DROP TABLE IF EXISTS `Estadísticas_de_Jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estadísticas_de_Jugadores` (
  `IDEstadisticaJugador` char(7) NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'Activo',
  `asistencias` tinyint(3) unsigned NOT NULL DEFAULT 0,
  `goles` tinyint(3) unsigned NOT NULL DEFAULT 0,
  `tarjetasAmarillas` tinyint(3) unsigned NOT NULL DEFAULT 0,
  `tarjetasRojas` tinyint(3) unsigned NOT NULL DEFAULT 0,
  `minutosJugados` smallint(5) unsigned NOT NULL DEFAULT 0,
  `IDJugador` char(5) NOT NULL,
  PRIMARY KEY (`IDEstadisticaJugador`),
  KEY `IDJugador` (`IDJugador`),
  CONSTRAINT `Estadísticas_de_Jugadores_ibfk_1` FOREIGN KEY (`IDJugador`) REFERENCES `Jugadores` (`IDJugador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estadísticas_de_Jugadores`
--

LOCK TABLES `Estadísticas_de_Jugadores` WRITE;
/*!40000 ALTER TABLE `Estadísticas_de_Jugadores` DISABLE KEYS */;
INSERT INTO `Estadísticas_de_Jugadores` VALUES
('1111111','Activo',3,11,3,0,460,'11111'),
('2222222','Activo',2,7,2,0,432,'22222'),
('3333333','Activo',1,1,4,0,400,'33333'),
('4444444','Lesionado',0,0,2,0,237,'44444'),
('5555555','Suspendido',2,1,2,1,392,'55555'),
('6666666','Cedido',0,0,0,0,100,'66666');
/*!40000 ALTER TABLE `Estadísticas_de_Jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estadísticas_de_Partidos`
--

DROP TABLE IF EXISTS `Estadísticas_de_Partidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estadísticas_de_Partidos` (
  `codEstadisticaPartido` char(6) NOT NULL,
  `eventoRel` varchar(15) NOT NULL,
  `minuto` tinyint(3) unsigned NOT NULL,
  `IDPartido` char(5) NOT NULL,
  PRIMARY KEY (`codEstadisticaPartido`),
  KEY `IDPartido` (`IDPartido`),
  CONSTRAINT `Estadísticas_de_Partidos_ibfk_1` FOREIGN KEY (`IDPartido`) REFERENCES `Partidos` (`IDPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estadísticas_de_Partidos`
--

LOCK TABLES `Estadísticas_de_Partidos` WRITE;
/*!40000 ALTER TABLE `Estadísticas_de_Partidos` DISABLE KEYS */;
INSERT INTO `Estadísticas_de_Partidos` VALUES
('123456','Gol',21,'12345'),
('123457','Gol',25,'12345'),
('123458','Gol',45,'12345'),
('123459','Sustitución',51,'12345'),
('123460','T.Amarilla',53,'12345'),
('123461','Gol',62,'12345'),
('123462','Sustitución',65,'12345'),
('123463','Gol',73,'12345'),
('123464','T.Roja',85,'12345'),
('123465','Gol',15,'12346');
/*!40000 ALTER TABLE `Estadísticas_de_Partidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Grupos`
--

DROP TABLE IF EXISTS `Grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Grupos` (
  `nombreGrupo` char(7) NOT NULL,
  PRIMARY KEY (`nombreGrupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Grupos`
--

LOCK TABLES `Grupos` WRITE;
/*!40000 ALTER TABLE `Grupos` DISABLE KEYS */;
INSERT INTO `Grupos` VALUES
('Grupo A'),
('Grupo B');
/*!40000 ALTER TABLE `Grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Juega`
--

DROP TABLE IF EXISTS `Juega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Juega` (
  `nombreEquipo` varchar(50) NOT NULL,
  `IDPartido` char(5) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  PRIMARY KEY (`nombreEquipo`,`IDPartido`),
  KEY `IDPartido` (`IDPartido`),
  CONSTRAINT `Juega_ibfk_1` FOREIGN KEY (`nombreEquipo`) REFERENCES `Equipos` (`nombreEquipo`),
  CONSTRAINT `Juega_ibfk_2` FOREIGN KEY (`IDPartido`) REFERENCES `Partidos` (`IDPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Juega`
--

LOCK TABLES `Juega` WRITE;
/*!40000 ALTER TABLE `Juega` DISABLE KEYS */;
INSERT INTO `Juega` VALUES
('CD Castellón','12347','Visitante'),
('CD Castellón','12349','Local'),
('Celta B','12345','Local'),
('Celta B','12350','Visitante'),
('Celta B','12351','Local'),
('Córdoba FC','12344','Visitante'),
('Cultural Leonesa','12343','Local'),
('Cultural Leonesa','12345','Visitante'),
('Ponferradina','12343','Visitante'),
('Ponferradina','12347','Local'),
('Ponferradina','12349','Visitante'),
('Ponferradina','12350','Local'),
('Ponferradina','12351','Visitante'),
('UD Ibiza','12344','Local');
/*!40000 ALTER TABLE `Juega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jugadores`
--

DROP TABLE IF EXISTS `Jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Jugadores` (
  `IDJugador` char(5) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `posicion` char(3) NOT NULL,
  `dorsal` tinyint(3) unsigned NOT NULL,
  `nombreEquipo` varchar(50) NOT NULL,
  PRIMARY KEY (`IDJugador`),
  KEY `nombreEquipo` (`nombreEquipo`),
  CONSTRAINT `Jugadores_ibfk_1` FOREIGN KEY (`nombreEquipo`) REFERENCES `Equipos` (`nombreEquipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jugadores`
--

LOCK TABLES `Jugadores` WRITE;
/*!40000 ALTER TABLE `Jugadores` DISABLE KEYS */;
INSERT INTO `Jugadores` VALUES
('11111','Jesús de Miguel','Alameda','1996-07-21','DEL',11,'CD Castellón'),
('22222','Antonio','Casas','2000-05-30','DEL',11,'Córdoba FC'),
('33333','Javi','Rueda','2002-05-08','DEF',13,'Celta B'),
('44444','Manuel','Gómez','1999-12-11','MED',6,'UD Ibiza'),
('55555','José Francisco','Rueda','1994-07-27','DEF',3,'Cultural Leonesa'),
('66666','Iago','Sánchez','2000-04-21','POR',1,'Ponferradina');
/*!40000 ALTER TABLE `Jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Nacionalidad`
--

DROP TABLE IF EXISTS `Nacionalidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Nacionalidad` (
  `nacion` varchar(20) NOT NULL,
  `IDJugador` char(5) NOT NULL,
  PRIMARY KEY (`nacion`,`IDJugador`),
  KEY `IDJugador` (`IDJugador`),
  CONSTRAINT `Nacionalidad_ibfk_1` FOREIGN KEY (`IDJugador`) REFERENCES `Jugadores` (`IDJugador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Nacionalidad`
--

LOCK TABLES `Nacionalidad` WRITE;
/*!40000 ALTER TABLE `Nacionalidad` DISABLE KEYS */;
INSERT INTO `Nacionalidad` VALUES
('Chile','44444'),
('España','11111'),
('España','22222'),
('España','33333'),
('España','66666'),
('Portugal','55555');
/*!40000 ALTER TABLE `Nacionalidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Partidos`
--

DROP TABLE IF EXISTS `Partidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Partidos` (
  `IDPartido` char(5) NOT NULL,
  `fecha` date NOT NULL,
  `hora` char(5) NOT NULL,
  `resultado` varchar(15) DEFAULT NULL,
  `tipo` varchar(10) NOT NULL,
  PRIMARY KEY (`IDPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partidos`
--

LOCK TABLES `Partidos` WRITE;
/*!40000 ALTER TABLE `Partidos` DISABLE KEYS */;
INSERT INTO `Partidos` VALUES
('12343','2023-11-30','20:45','0-2','Regular'),
('12344','2023-12-01','17:30','1-1','Regular'),
('12345','2023-12-15','21:00','3-2','Regular'),
('12346','2023-12-15','16:00','1-0','Regular'),
('12347','2023-12-20','17:00','2-1','PlayOff'),
('12348','2023-12-20','12:00','0-1','PlayOff'),
('12349','2023-12-23','20:45','1-3','PlayOff'),
('12350','2024-01-08','21:00','1-0','PlayOff'),
('12351','2024-01-23','21:00','Sin disputar','PlayOff');
/*!40000 ALTER TABLE `Partidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PartidosPlayOff`
--

DROP TABLE IF EXISTS `PartidosPlayOff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PartidosPlayOff` (
  `IDPartido` char(7) NOT NULL,
  `fase` varchar(10) NOT NULL,
  `tipo` varchar(6) NOT NULL,
  PRIMARY KEY (`IDPartido`),
  CONSTRAINT `PartidosPlayOff_ibfk_1` FOREIGN KEY (`IDPartido`) REFERENCES `Partidos` (`IDPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PartidosPlayOff`
--

LOCK TABLES `PartidosPlayOff` WRITE;
/*!40000 ALTER TABLE `PartidosPlayOff` DISABLE KEYS */;
INSERT INTO `PartidosPlayOff` VALUES
('12347','Semifinal','Ida'),
('12349','Semifinal','Vuelta'),
('12350','Final','Ida'),
('12351','Final','Vuelta');
/*!40000 ALTER TABLE `PartidosPlayOff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PartidosRegulares`
--

DROP TABLE IF EXISTS `PartidosRegulares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PartidosRegulares` (
  `IDPartido` char(5) NOT NULL,
  `numJornada` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`IDPartido`),
  CONSTRAINT `PartidosRegulares_ibfk_1` FOREIGN KEY (`IDPartido`) REFERENCES `Partidos` (`IDPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PartidosRegulares`
--

LOCK TABLES `PartidosRegulares` WRITE;
/*!40000 ALTER TABLE `PartidosRegulares` DISABLE KEYS */;
INSERT INTO `PartidosRegulares` VALUES
('12343',37),
('12344',37),
('12345',38),
('12346',38);
/*!40000 ALTER TABLE `PartidosRegulares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `resultados_liga`
--

DROP TABLE IF EXISTS `resultados_liga`;
/*!50001 DROP VIEW IF EXISTS `resultados_liga`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `resultados_liga` AS SELECT
 1 AS `numJornada`,
  1 AS `IDPartido`,
  1 AS `fecha`,
  1 AS `resultado` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `tabla_puntuaciones`
--

DROP TABLE IF EXISTS `tabla_puntuaciones`;
/*!50001 DROP VIEW IF EXISTS `tabla_puntuaciones`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `tabla_puntuaciones` AS SELECT
 1 AS `nombreGrupo`,
  1 AS `nombreEquipo`,
  1 AS `partGanados`,
  1 AS `partEmpatados`,
  1 AS `partPerdidos`,
  1 AS `puntos` */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `resultados_liga`
--

/*!50001 DROP VIEW IF EXISTS `resultados_liga`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `resultados_liga` AS select `PartidosRegulares`.`numJornada` AS `numJornada`,`Partidos`.`IDPartido` AS `IDPartido`,`Partidos`.`fecha` AS `fecha`,`Partidos`.`resultado` AS `resultado` from (`Partidos` join `PartidosRegulares` on(`Partidos`.`IDPartido` = `PartidosRegulares`.`IDPartido`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `tabla_puntuaciones`
--

/*!50001 DROP VIEW IF EXISTS `tabla_puntuaciones`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `tabla_puntuaciones` AS select `Grupos`.`nombreGrupo` AS `nombreGrupo`,`Equipos`.`nombreEquipo` AS `nombreEquipo`,`Estadísticas_de_Equipos`.`partGanados` AS `partGanados`,`Estadísticas_de_Equipos`.`partEmpatados` AS `partEmpatados`,`Estadísticas_de_Equipos`.`partPerdidos` AS `partPerdidos`,`Estadísticas_de_Equipos`.`puntos` AS `puntos` from ((`Grupos` join `Equipos` on(`Grupos`.`nombreGrupo` = `Equipos`.`nombreGrupo`)) join `Estadísticas_de_Equipos` on(`Equipos`.`nombreEquipo` = `Estadísticas_de_Equipos`.`nombreEquipo`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-10 19:58:57
