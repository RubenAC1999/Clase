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
  `kilometraje` float(8,2) unsigned NOT NULL,
  `precioInicial` float(9,2) unsigned NOT NULL,
  `fechaIngreso` timestamp NOT NULL,
  `Estado` varchar(8) NOT NULL DEFAULT 'En venta',
  `NIFVendedor` char(9) NOT NULL,
  `NIFComprador` char(9) DEFAULT NULL,
  `numPuertas` tinyint(3) unsigned NOT NULL,
  `tipoCombustible` varchar(10) NOT NULL,
  `consumo` float unsigned NOT NULL,
  `descripcion` varchar(255) DEFAULT '',
  PRIMARY KEY (`matricula`),
  KEY `NIFVendedor` (`NIFVendedor`),
  KEY `NIFComprador` (`NIFComprador`),
  CONSTRAINT `Coches_ibfk_1` FOREIGN KEY (`NIFVendedor`) REFERENCES `Particulares` (`NIF`),
  CONSTRAINT `Coches_ibfk_2` FOREIGN KEY (`NIFComprador`) REFERENCES `Particulares` (`NIF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla BigPistonsDB.Coches: ~2 rows (aproximadamente)
INSERT IGNORE INTO `Coches` (`matricula`, `modelo`, `anhoSerie`, `kilometraje`, `precioInicial`, `fechaIngreso`, `Estado`, `NIFVendedor`, `NIFComprador`, `numPuertas`, `tipoCombustible`, `consumo`, `descripcion`) VALUES
	('ABC12345', 'Toyota Corolla', 2024, 60000.00, 27000.00, '2023-12-10 23:00:00', 'En venta', '12345678A', NULL, 5, 'Híbrido', 4.5, ''),
	('ABC12346', 'Peugeot 206', 2005, 117000.00, 3000.00, '2023-12-10 23:00:00', 'Vendido', '12345678A', '12345679A', 3, 'Gasolina', 5, '');

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

-- Volcando estructura para vista BigPistonsDB.HistorialVentas
-- Creando tabla temporal para superar errores de dependencia de VIEW
CREATE TABLE `HistorialVentas` (
	`IDVenta` CHAR(5) NOT NULL COLLATE 'utf8mb4_general_ci',
	`NIFVendedor` CHAR(9) NOT NULL COLLATE 'utf8mb4_general_ci',
	`NIFComprador` CHAR(9) NULL COLLATE 'utf8mb4_general_ci',
	`modelo` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_general_ci',
	`matricula` VARCHAR(8) NOT NULL COLLATE 'utf8mb4_general_ci',
	`precioFinal` FLOAT(9,2) UNSIGNED NOT NULL,
	`fechaVenta` DATETIME NOT NULL
) ENGINE=MyISAM;

-- Volcando estructura para tabla BigPistonsDB.Particulares
CREATE TABLE IF NOT EXISTS `Particulares` (
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `NIF` char(9) NOT NULL,
  `email` varchar(30) NOT NULL,
  `contrasenha` varchar(50) NOT NULL,
  `esAdmin` tinyint(1) NOT NULL,
  `telefono` char(9) NOT NULL,
  PRIMARY KEY (`NIF`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `telefono` (`telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla BigPistonsDB.Particulares: ~3 rows (aproximadamente)
INSERT IGNORE INTO `Particulares` (`nombre`, `apellidos`, `NIF`, `email`, `contrasenha`, `esAdmin`, `telefono`) VALUES
	('usuario1', 'usuario1', '12344567A', 'usuario1@gmail.com', 'abc123.', 0, '111111111'),
	('usuarioGlobal', 'ejemplo', '12345678A', 'usuario@gmail.com', 'abc123', 0, '981821111'),
	('admin', 'ejemplo', '12345679A', 'admin@gmail.com', 'abc123', 1, '981821112');

-- Volcando estructura para tabla BigPistonsDB.Ventas
CREATE TABLE IF NOT EXISTS `Ventas` (
  `IDVenta` char(5) NOT NULL,
  `fechaVenta` datetime NOT NULL,
  `precioFinal` float(9,2) unsigned NOT NULL,
  `matricula` varchar(8) NOT NULL,
  PRIMARY KEY (`IDVenta`),
  KEY `matricula` (`matricula`),
  CONSTRAINT `Ventas_ibfk_1` FOREIGN KEY (`matricula`) REFERENCES `Coches` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla BigPistonsDB.Ventas: ~1 rows (aproximadamente)
INSERT IGNORE INTO `Ventas` (`IDVenta`, `fechaVenta`, `precioFinal`, `matricula`) VALUES
	('12345', '2024-01-03 00:00:00', 2500.00, 'ABC12346');

-- Eliminando tabla temporal y crear estructura final de VIEW
DROP TABLE IF EXISTS `HistorialVentas`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `HistorialVentas` AS select `Ventas`.`IDVenta` AS `IDVenta`,`Coches`.`NIFVendedor` AS `NIFVendedor`,`Coches`.`NIFComprador` AS `NIFComprador`,`Coches`.`modelo` AS `modelo`,`Coches`.`matricula` AS `matricula`,`Ventas`.`precioFinal` AS `precioFinal`,`Ventas`.`fechaVenta` AS `fechaVenta` from (`Ventas` join `Coches` on(`Ventas`.`matricula` = `Coches`.`matricula`));

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
