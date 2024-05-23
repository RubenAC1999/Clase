SELECT p.isbn, p.numero_socio, l.titulo, l.autor, l.fecha_prestamo FROM prestamos p INNER JOIN libros l ON p.isbn = l.isbn
