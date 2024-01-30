Algoritmo Ejercicio2
	Definir nota1, nota2, nota3 Como Real
	Repetir
		Escribir "Introduzca la primera calificación"
		Leer nota1
		
		Si nota1 < 0 Entonces
			Escribir "Nota incorrecta, inténtelo de nuevo"
		FinSi
		
	Hasta Que nota1 >= 0
	
	Repetir
		Escribir "Introduzca la segunda calificación"
		Leer nota2
		
		Si nota2 < 0 Entonces
			Escribir "Nota incorrecta, inténtelo de nuevo"
		FinSi
		
	Hasta Que nota2 >= 0
	
	Repetir
		Escribir "Introduzca la tercera calificación"
		Leer nota3
		
		Si nota3 < 0 Entonces
			Escribir "Nota incorrecta, inténtelo de nuevo"
		FinSi
		
	Hasta Que nota3 >= 0
	
	notaPromedio = (nota1 + nota2 + nota3) / 3
	
	Escribir "La nota promedio es de: ", notaPromedio
	
	Si notaPromedio < 4 Entonces
		Escribir "El alumno ha suspendido"
		
	SiNo
		Escribir "El alumno ha aprobado"
	FinSi
	
FinAlgoritmo
