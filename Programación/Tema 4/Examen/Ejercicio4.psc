Algoritmo Ejercicio4
	Definir num, acumulador Como Entero
	Repetir
		Escribir "Introduzca un número entero:"
		Leer num
		
		Si num < 0 Entonces
			Escribir "Numero no válido, inténtelo de nuevo"
		FinSi
		
	Hasta Que num > 0
	
	
	acumulador = 0
	numString = ConvertirATexto(num)
	
	Para i = 0 Hasta Longitud(numString) Con Paso 1 Hacer
		char = Subcadena(numString, i, i)
		digito = ConvertirANumero(char)
		acumulador = acumulador + digito
	Fin Para
	
	Escribir "La suma de los dígitos es de: ",acumulador
	
FinAlgoritmo
