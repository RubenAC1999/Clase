Algoritmo Ejercicio4
	Definir num, acumulador Como Entero
	Repetir
		Escribir "Introduzca un n�mero entero:"
		Leer num
		
		Si num < 0 Entonces
			Escribir "Numero no v�lido, int�ntelo de nuevo"
		FinSi
		
	Hasta Que num > 0
	
	
	acumulador = 0
	numString = ConvertirATexto(num)
	
	Para i = 0 Hasta Longitud(numString) Con Paso 1 Hacer
		char = Subcadena(numString, i, i)
		digito = ConvertirANumero(char)
		acumulador = acumulador + digito
	Fin Para
	
	Escribir "La suma de los d�gitos es de: ",acumulador
	
FinAlgoritmo
