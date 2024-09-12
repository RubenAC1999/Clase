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


-- Volcando estructura de base de datos para competicion_deportiva
CREATE DATABASE IF NOT EXISTS `competicion_deportiva` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `competicion_deportiva`;

-- Volcando estructura para tabla competicion_deportiva.Equipos
CREATE TABLE IF NOT EXISTS `Equipos` (
  `nombreEquipo` varchar(50) NOT NULL,
  `estadio` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `capacidad` mediumint(8) unsigned NOT NULL,
  `fechaFundacion` smallint(5) unsigned NOT NULL,
  `logo` varchar(20) DEFAULT NULL,
  `nombreGrupo` char(7) NOT NULL,
  PRIMARY KEY (`nombreEquipo`),
  KEY `nombreGrupo` (`nombreGrupo`),
  CONSTRAINT `Equipos_ibfk_1` FOREIGN KEY (`nombreGrupo`) REFERENCES `Grupos` (`nombreGrupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla competicion_deportiva.Equipos: ~6 rows (aproximadamente)
INSERT IGNORE INTO `Equipos` (`nombreEquipo`, `estadio`, `direccion`, `capacidad`, `fechaFundacion`, `logo`, `nombreGrupo`) VALUES
	('CD Castellón', 'Nuevo Castalla', 'Calle Castellón 34', 15500, 1922, 'castellon.png', 'Grupo B'),
	('Celta B', 'Campo Municipal de Barreiro', 'Avda. Ramón Nieto Vigo', 1171, 1927, 'Celtab.png', 'Grupo A'),
	('Córdoba FC', 'Nuevo Arcángel', 'C.José Ramón García Fernández', 21822, 1954, 'cordoba.png', 'Grupo B'),
	('Cultural Leonesa', 'Reino de León', 'Av. Del Ingeniero de Saez Miera 13', 13346, 1923, 'culturalleonesa.png', 'Grupo A'),
	('Ponferradina', 'El Toralín', 'Calle José Luís Saez nº1', 10000, 1922, 'ponferradina.png', 'Grupo A'),
	('UD Ibiza', 'Estadio Palladium Can Misses', 'Calle Ibiza 21', 6500, 2015, 'ibiza.png', 'Grupo B');

-- Volcando estructura para tabla competicion_deportiva.Grupos
CREATE TABLE IF NOT EXISTS `Grupos` (
  `nombreGrupo` char(7) NOT NULL,
  PRIMARY KEY (`nombreGrupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla competicion_deportiva.Grupos: ~2 rows (aproximadamente)
INSERT IGNORE INTO `Grupos` (`nombreGrupo`) VALUES
	('Grupo A'),
	('Grupo B');

-- Volcando estructura para tabla competicion_deportiva.Jugadores
CREATE TABLE IF NOT EXISTS `Jugadores` (
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

-- Volcando datos para la tabla competicion_deportiva.Jugadores: ~6 rows (aproximadamente)
INSERT IGNORE INTO `Jugadores` (`IDJugador`, `nombre`, `apellidos`, `fechaNacimiento`, `posicion`, `dorsal`, `nombreEquipo`) VALUES
	('11111', 'Jesús de Miguel', 'Alameda', '1996-07-21', 'DEL', 11, 'CD Castellón'),
	('22222', 'Antonio', 'Casas', '2000-05-30', 'DEL', 11, 'Córdoba FC'),
	('33333', 'Javi', 'Rueda', '2002-05-08', 'DEF', 13, 'Celta B'),
	('44444', 'Manuel', 'Gómez', '1999-12-11', 'MED', 6, 'UD Ibiza'),
	('55555', 'José Francisco', 'Rueda', '1994-07-27', 'DEF', 3, 'Cultural Leonesa'),
	('66666', 'Iago', 'Sánchez', '2000-04-21', 'POR', 1, 'Ponferradina');

-- Volcando estructura para tabla competicion_deportiva.Partidos
CREATE TABLE IF NOT EXISTS `Partidos` (
  `IDPartido` char(5) NOT NULL,
  `fecha` date NOT NULL,
  `hora` char(5) NOT NULL,
  `resultado` varchar(15) DEFAULT 'Sin disputar',
  `tipo` varchar(10) NOT NULL,
  PRIMARY KEY (`IDPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla competicion_deportiva.Partidos: ~8 rows (aproximadamente)
INSERT IGNORE INTO `Partidos` (`IDPartido`, `fecha`, `hora`, `resultado`, `tipo`) VALUES
	('12343', '2023-11-30', '20:45', '0-2', 'Regular'),
	('12344', '2023-12-01', '17:30', '1-1', 'Regular'),
	('12345', '2023-12-15', '21:00', '3-2', 'Regular'),
	('12346', '2023-12-15', '16:00', '1-0', 'Regular'),
	('12347', '2023-12-20', '17:00', '2-1', 'PlayOff'),
	('12348', '2023-12-20', '12:00', '0-1', 'PlayOff'),
	('12349', '2023-12-23', '20:45', '1-3', 'PlayOff'),
	('12350', '2024-01-08', '21:00', '1-0', 'PlayOff');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
