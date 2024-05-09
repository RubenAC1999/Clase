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


-- Volcando estructura de base de datos para empleados
CREATE DATABASE IF NOT EXISTS `empleados` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `empleados`;

-- Volcando estructura para tabla empleados.deptno
CREATE TABLE IF NOT EXISTS `deptno` (
  `NUMDEP` int(2) NOT NULL,
  `NOMDEP` varchar(14) DEFAULT NULL,
  `LOCALIDAD` varchar(13) DEFAULT NULL,
  `NUMJEFE` int(4) DEFAULT NULL,
  PRIMARY KEY (`NUMDEP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla empleados.deptno: ~4 rows (aproximadamente)
INSERT IGNORE INTO `deptno` (`NUMDEP`, `NOMDEP`, `LOCALIDAD`, `NUMJEFE`) VALUES
	(1, 'CONTABILIDAD', 'SANTIAGO', 7782),
	(2, 'ADMINISTRACION', 'SANTIAGO', 7369),
	(3, 'VENTAS', 'PONTEVEDRA', 7499),
	(4, 'OPERACIONES', 'VILAGARCIA', 7934);

-- Volcando estructura para tabla empleados.emp
CREATE TABLE IF NOT EXISTS `emp` (
  `NUMEMP` int(4) NOT NULL,
  `NOEMP` varchar(10) DEFAULT NULL,
  `PUESTO` varchar(11) DEFAULT NULL,
  `FECCONT` date DEFAULT NULL,
  `SAL` decimal(7,2) DEFAULT NULL,
  `COMISION` decimal(7,2) DEFAULT NULL,
  `NUMDEP` int(2) DEFAULT NULL,
  PRIMARY KEY (`NUMEMP`),
  KEY `NUMDEP` (`NUMDEP`),
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`NUMDEP`) REFERENCES `deptno` (`NUMDEP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla empleados.emp: ~14 rows (aproximadamente)
INSERT IGNORE INTO `emp` (`NUMEMP`, `NOEMP`, `PUESTO`, `FECCONT`, `SAL`, `COMISION`, `NUMDEP`) VALUES
	(7369, 'SMITH', 'CONTABLE', '1980-12-17', 800.00, NULL, 2),
	(7499, 'ALLEN', 'COMERCIAL', '1981-02-20', 1600.00, 300.00, 3),
	(7521, 'WARD', 'COMERCIAL', '1981-02-22', 1250.00, 500.00, 3),
	(7566, 'JONES', 'MANAGER', '1981-04-02', 2975.00, NULL, 2),
	(7654, 'MARTIN', 'COMERCIAL', '1981-09-28', 1250.00, 1400.00, 3),
	(7698, 'BLAKE', 'MANAGER', '1981-05-01', 2850.00, NULL, 3),
	(7782, 'CLARK', 'MANAGER', '1981-06-09', 2450.00, NULL, 1),
	(7788, 'SCOTT', 'ANALISTA', '1982-12-09', 3000.00, NULL, 2),
	(7839, 'KING', 'PRESIDENTE', '1981-11-17', 5000.00, NULL, 1),
	(7844, 'TURNER', 'COMERCIAL', '1981-09-08', 1500.00, 0.00, 3),
	(7876, 'ADAMS', 'CONTABLE', '1983-01-12', 1100.00, NULL, 2),
	(7900, 'JAMES', 'CONTABLE', '1981-12-03', 950.00, NULL, 3),
	(7902, 'FORD', 'ANALISTA', '1981-12-03', 3000.00, NULL, 2),
	(7934, 'MILLER', 'CONTABLE', '1982-01-23', 1300.00, NULL, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
