Algoritmo Ejercicio3
	Escribir "Introduzca un nombre"
	Leer nombre
	
	Repetir
		Escribir "Introduzca el n�mero de veces que desee que se imprima"
		Leer cantidad
		
		Si cantidad < 0 Entonces 
			Escribir "Cantidad negativa, int�ntelo de nuevo"
		FinSi
	Hasta Que cantidad > 0
	
	
	Para i = 1 Hasta cantidad Con Paso 1 Hacer
		Escribir nombre
	Fin Para
	
FinAlgoritmo
