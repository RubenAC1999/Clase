Algoritmo Ejercicio1
	Definir num Como Real
	
	acumulador = 0
	
	Para i = 2 Hasta 100 Con Paso 1 Hacer
		Si i % 2 = 0 Entonces
			acumulador = acumulador + i
		FinSi
	Fin Para
	
	Escribir "La suma de todos los números pares entre 2 y 100 es de: ", acumulador
	
FinAlgoritmo
