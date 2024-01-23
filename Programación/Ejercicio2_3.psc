Algoritmo Ejercicio2_3
	Definir num, i Como Real
	Escribir "Introduzca un número"
	Leer num
	Para i <- 2 Hasta num Con Paso 1 Hacer
		division = num / i
		Escribir num, " / ", i
		Mientras num % i == 0 Hacer
			Escribir num, " es un número primo"
		FinMientras
	Fin Para
	
FinAlgoritmo
