-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.11.6-MariaDB-0+deb12u1 - Debian 12
-- SO del servidor:              debian-linux-gnu
-- HeidiSQL Versión:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para gestion_plazas
CREATE DATABASE IF NOT EXISTS `gestion_plazas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `gestion_plazas`;

-- Volcando estructura para tabla gestion_plazas.garajes
CREATE TABLE IF NOT EXISTS `garajes` (
  `id` int(10) unsigned NOT NULL,
  `tamanho` varchar(6) NOT NULL,
  `precio` smallint(5) unsigned NOT NULL,
  `disponibleAlquiler` tinyint(1) NOT NULL,
  `horarioUso` varchar(6) NOT NULL,
  `modoAcceso` varchar(20) NOT NULL,
  `fotoGaraje` varchar(500) NOT NULL,
  `id_metodoPago` int(10) unsigned NOT NULL,
  `fechaPublicacion` date NOT NULL,
  `duracionAlquilerMinimo` varchar(10) NOT NULL,
  `duracionAlquilerMaximo` varchar(10) NOT NULL,
  `condicionesEspeciales` varchar(200) NOT NULL,
  `tipoPlaza` varchar(20) NOT NULL,
  `alturaMaxima` varchar(6) NOT NULL,
  `anchuraMaxima` varchar(6) NOT NULL,
  `numeroPlaza` smallint(5) unsigned NOT NULL,
  `id_parking` int(10) unsigned NOT NULL,
  `id_propietario` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_metodoPago` (`id_metodoPago`),
  KEY `id_parking` (`id_parking`),
  KEY `id_propietario` (`id_propietario`),
  CONSTRAINT `garajes_ibfk_1` FOREIGN KEY (`id_metodoPago`) REFERENCES `metodosPago` (`id`),
  CONSTRAINT `garajes_ibfk_2` FOREIGN KEY (`id_parking`) REFERENCES `parkings` (`id`),
  CONSTRAINT `garajes_ibfk_3` FOREIGN KEY (`id_propietario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.garajes: ~4 rows (aproximadamente)
INSERT INTO `garajes` (`id`, `tamanho`, `precio`, `disponibleAlquiler`, `horarioUso`, `modoAcceso`, `fotoGaraje`, `id_metodoPago`, `fechaPublicacion`, `duracionAlquilerMinimo`, `duracionAlquilerMaximo`, `condicionesEspeciales`, `tipoPlaza`, `alturaMaxima`, `anchuraMaxima`, `numeroPlaza`, `id_parking`, `id_propietario`) VALUES
	(1, '12 m^2', 50, 1, '24/7', 'Control remoto', 'https://example.com/garaje1.jpg', 1, '2024-01-01', '1 mes', '12 meses', 'No se permiten camiones', 'Cubierta', '2.1 m', '2.5 m', 12, 1, 2),
	(2, '12 m^2', 50, 1, '24/7', 'Control remoto', 'https://example.com/garaje2.jpg', 2, '2024-01-01', '1 mes', '12 meses', 'No se permiten camiones', 'Cubierta', '2.1 m', '2.5 m', 14, 1, 3),
	(3, '10 m^2', 45, 1, '7-22', 'Llave física', 'https://example.com/garaje3.jpg', 1, '2024-02-15', '15 días', '6 meses', 'Solo motos y coches pequeños', 'Descubierta', '2.0 m', '2.2 m', 5, 2, 4),
	(4, '15 m^2', 70, 0, '24/7', 'Aplicación móvil', 'https://example.com/garaje4.jpg', 3, '2024-03-01', '1 mes', '12 meses', 'No disponible para vehículos comerciales', 'Cubierta', '2.5 m', '3.0 m', 22, 3, 5),
	(5, '8 m^2', 35, 1, '8-20', 'Tarjeta magnética', 'https://example.com/garaje5.jpg', 2, '2024-04-10', '1 semana', '3 meses', 'Prohibido almacenar materiales inflamables', 'Cubierta', '1.8 m', '2.0 m', 7, 4, 6);

-- Volcando estructura para tabla gestion_plazas.historialAlquileres
CREATE TABLE IF NOT EXISTS `historialAlquileres` (
  `id` int(10) unsigned NOT NULL,
  `usuario` varchar(60) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `id_usuario` int(10) unsigned NOT NULL,
  `id_garaje` int(10) unsigned NOT NULL,
  `id_metodoPago` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_garaje` (`id_garaje`),
  KEY `id_metodoPago` (`id_metodoPago`),
  CONSTRAINT `historialAlquileres_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `historialAlquileres_ibfk_2` FOREIGN KEY (`id_garaje`) REFERENCES `garajes` (`id`),
  CONSTRAINT `historialAlquileres_ibfk_3` FOREIGN KEY (`id_metodoPago`) REFERENCES `metodosPago` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.historialAlquileres: ~4 rows (aproximadamente)
INSERT INTO `historialAlquileres` (`id`, `usuario`, `fechaInicio`, `fechaFin`, `id_usuario`, `id_garaje`, `id_metodoPago`) VALUES
	(1, 'Juan Pérez', '2024-01-10', '2024-02-10', 2, 1, 2),
	(2, 'Manuel Sanz', '2023-11-01', '2023-11-30', 3, 3, 1),
	(3, 'Ana García', '2024-03-15', '2024-04-15', 5, 2, 2),
	(4, 'Juan Pérez', '2024-01-10', '2024-02-10', 2, 2, 2),
	(5, 'Ramón Duarte', '2023-07-01', '2023-08-01', 4, 4, 3);

-- Volcando estructura para tabla gestion_plazas.metodosPago
CREATE TABLE IF NOT EXISTS `metodosPago` (
  `id` int(10) unsigned NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.metodosPago: ~4 rows (aproximadamente)
INSERT INTO `metodosPago` (`id`, `nombre`) VALUES
	(1, 'Transferencia bancaria'),
	(2, 'Tarjeta de crédito'),
	(3, 'Bizum a número 666555444'),
	(4, 'PayPal a cuenta paypal@example.com'),
	(5, 'Efectivo en punto de encuentro');

-- Volcando estructura para tabla gestion_plazas.parkings
CREATE TABLE IF NOT EXISTS `parkings` (
  `id` int(10) unsigned NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `ciudad` varchar(60) NOT NULL,
  `provincia` varchar(60) NOT NULL,
  `latitud` float NOT NULL,
  `longitud` float NOT NULL,
  `distanciaCentroCiudad` varchar(6) NOT NULL,
  `metodoPagoDefault_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `metodoPagoDefault_id` (`metodoPagoDefault_id`),
  CONSTRAINT `parkings_ibfk_1` FOREIGN KEY (`metodoPagoDefault_id`) REFERENCES `metodosPago` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.parkings: ~4 rows (aproximadamente)
INSERT INTO `parkings` (`id`, `nombre`, `direccion`, `ciudad`, `provincia`, `latitud`, `longitud`, `distanciaCentroCiudad`, `metodoPagoDefault_id`) VALUES
	(1, 'Parking Central', 'Calle Mayor, 12', 'Madrid', 'Madrid', 40.4168, 3.70379, '2 km', 1),
	(2, 'Parking Norte', 'Avenida de la Paz, 34', 'Barcelona', 'Barcelona', 41.3851, 2.1734, '3 km', 2),
	(3, 'Parking Sur', 'Calle de Alcalá, 56', 'Sevilla', 'Sevilla', 37.3886, -5.98233, '1,5 km', 1),
	(4, 'Parking Estación', 'Plaza del Sol, 10', 'Valencia', 'Valencia', 39.4699, -0.376288, '0.8 km', 3),
	(5, 'Parking Universitario', 'Camino Real, s/n', 'Granada', 'Granada', 37.1773, -3.59856, '4 km', 2);

-- Volcando estructura para tabla gestion_plazas.userCategorias
CREATE TABLE IF NOT EXISTS `userCategorias` (
  `id` int(10) unsigned NOT NULL,
  `nombre_categoria` varchar(20) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.userCategorias: ~4 rows (aproximadamente)
INSERT INTO `userCategorias` (`id`, `nombre_categoria`, `descripcion`) VALUES
	(100, 'Propietario', 'Usuario que posee y alquila plazas\nde garaje.'),
	(200, 'Arrendatario', 'Usuario que alquila plazas de garaje'),
	(300, 'Administrador', 'Usuario con permisos para gestionar y supervisar el sistema.'),
	(400, 'Visitante', 'Usuario con acceso limitado para explorar plazas de garaje.'),
	(500, 'Invitado', 'Usuario temporal sin posibilidad de realizar transacciones.');

-- Volcando estructura para tabla gestion_plazas.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(10) unsigned NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `contacto` varchar(100) NOT NULL,
  `telefono` char(9) NOT NULL,
  `id_categoria` int(10) unsigned NOT NULL,
  `fechaRegistro` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `userCategorias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestion_plazas.usuario: ~5 rows (aproximadamente)
INSERT INTO `usuario` (`id`, `nombre`, `contacto`, `telefono`, `id_categoria`, `fechaRegistro`) VALUES
	(2, 'Juan Pérez', 'juanperez@example.com', '600123456', 100, '2023-05-10'),
	(3, 'Manuel Sanz', 'sanz@example.com', '633456432', 100, '2023-05-11'),
	(4, 'Ramón Duarte', 'ramonduarte@example.com', '600654321', 200, '2022-08-22'),
	(5, 'Ana García', 'anagarcia@example.com', '611987654', 100, '2023-06-15'),
	(6, 'Laura Torres', 'lauratorres@example.com', '622345678', 200, '2023-07-01');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
