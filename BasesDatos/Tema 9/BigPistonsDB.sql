-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         10.11.6-MariaDB-0+deb12u1 - Debian 12
-- SO del servidor:              debian-linux-gnu
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para BigPistonsDB
CREATE DATABASE IF NOT EXISTS `BigPistonsDB` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `BigPistonsDB`;

-- Volcando estructura para tabla BigPistonsDB.Coches
CREATE TABLE IF NOT EXISTS `Coches` (
  `matricula` varchar(8) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `anhoSerie` smallint(5) unsigned NOT NULL,
  `kilometraje` float(6,2) unsigned NOT NULL,
  `precioInicial` float(6,2) unsigned NOT NULL,
  `fechaIngreso` datetime NOT NULL,
  `Estado` varchar(8) NOT NULL,
  `NIFVendedor` char(9) NOT NULL,
  `NIFComprador` char(9) DEFAULT NULL,
  PRIMARY KEY (`matricula`),
  KEY `NIFVendedor` (`NIFVendedor`),
  KEY `NIFComprador` (`NIFComprador`),
  CONSTRAINT `Coches_ibfk_1` FOREIGN KEY (`NIFVendedor`) REFERENCES `Particulares` (`NIF`),
  CONSTRAINT `Coches_ibfk_2` FOREIGN KEY (`NIFComprador`) REFERENCES `Particulares` (`NIF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla BigPistonsDB.Coches: ~0 rows (aproximadamente)

-- Volcando estructura para tabla BigPistonsDB.Genera
CREATE TABLE IF NOT EXISTS `Genera` (
  `NIF` char(9) NOT NULL,
  `IDVenta` char(5) NOT NULL,
  `Rol` varchar(10) NOT NULL,
  PRIMARY KEY (`NIF`,`IDVenta`),
  KEY `IDVenta` (`IDVenta`),
  CONSTRAINT `Genera_ibfk_1` FOREIGN KEY (`NIF`) REFERENCES `Particulares` (`NIF`),
  CONSTRAINT `Genera_ibfk_2` FOREIGN KEY (`IDVenta`) REFERENCES `Ventas` (`IDVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla BigPistonsDB.Genera: ~0 rows (aproximadamente)

-- Volcando estructura para tabla BigPistonsDB.Particulares
CREATE TABLE IF NOT EXISTS `Particulares` (
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `NIF` char(9) NOT NULL,
  PRIMARY KEY (`NIF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla BigPistonsDB.Particulares: ~0 rows (aproximadamente)

-- Volcando estructura para tabla BigPistonsDB.Ventas
CREATE TABLE IF NOT EXISTS `Ventas` (
  `IDVenta` char(5) NOT NULL,
  `fechaVenta` datetime NOT NULL,
  `precioFinal` float(6,2) unsigned NOT NULL,
  `matricula` varchar(8) NOT NULL,
  PRIMARY KEY (`IDVenta`),
  KEY `matricula` (`matricula`),
  CONSTRAINT `Ventas_ibfk_1` FOREIGN KEY (`matricula`) REFERENCES `Coches` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla BigPistonsDB.Ventas: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
