DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;
CREATE TABLE autores (
 id INT AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(100) NOT NULL,
 nacionalidad VARCHAR(50) NOT NULL
);
CREATE TABLE libros (
 id INT AUTO_INCREMENT PRIMARY KEY,
 titulo VARCHAR(200) NOT NULL,
 id_autor INT,
 anio_publicacion YEAR NOT NULL,
 FOREIGN KEY (id_autor) REFERENCES autores(id)
);
-- Inserción de datos de ejemplo para autores
INSERT INTO autores (nombre, nacionalidad) VALUES ('Gabriel Garcia Marquez',
'Colombiano');
INSERT INTO autores (nombre, nacionalidad) VALUES ('Jane Austen', 'Británica');
INSERT INTO autores (nombre, nacionalidad) VALUES ('Mark Twain', 'Estadounidense');
-- Inserción de datos de ejemplo para libros
INSERT INTO libros (titulo, id_autor, anio_publicacion) VALUES ('Cien años de
soledad', 1, 1967);
INSERT INTO libros (titulo, id_autor, anio_publicacion) VALUES ('Orgullo y
prejuicio', 2, 1813);
INSERT INTO libros (titulo, id_autor, anio_publicacion) VALUES ('Las aventuras de Tom
Sawyer', 3, 1876);