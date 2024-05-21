DROP DATABASE IF EXISTS comercio;
CREATE DATABASE comercio;
USE comercio;
CREATE TABLE clientes (
 id INT AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(100) NOT NULL,
 email VARCHAR(100) NOT NULL,
 telefono VARCHAR(15) NOT NULL
);
CREATE TABLE pedidos (
 id INT AUTO_INCREMENT PRIMARY KEY,
 id_cliente INT,
 fecha DATE NOT NULL,
 total DECIMAL(10,2) NOT NULL,
 FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);
-- Inserción de datos de ejemplo para clientes
INSERT INTO clientes (nombre, email, telefono) VALUES ('Carlos Pérez',
'carlos.perez@example.com', '123456789');
INSERT INTO clientes (nombre, email, telefono) VALUES ('María López',
'maria.lopez@example.com', '987654321');
INSERT INTO clientes (nombre, email, telefono) VALUES ('Luis González',
'luis.gonzalez@example.com', '555666777');
-- Inserción de datos de ejemplo para pedidos
INSERT INTO pedidos (id_cliente, fecha, total) VALUES (1, '2024-05-01', 150.75);
INSERT INTO pedidos (id_cliente, fecha, total) VALUES (2, '2024-05-02', 250.00);
INSERT INTO pedidos (id_cliente, fecha, total) VALUES (1, '2024-05-03', 325.50);
INSERT INTO pedidos (id_cliente, fecha, total) VALUES (3, '2024-05-04', 120.00);
