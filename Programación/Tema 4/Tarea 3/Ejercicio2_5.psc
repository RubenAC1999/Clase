Algoritmo Ejercicio2_5
	Definir string Como Cadena
	Escribir "Introduzca una lista de n�meros (00 para salir)"
	Hacer
		Leer string
		num = convertirANumero(string)
		num = num + num
	Hasta Que string = "00"
	
	Escribir "La suma de los n�meros introducidos es de: ", num
	
FinAlgoritmo
