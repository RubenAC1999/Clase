Algoritmo Ejercicio2_7
	Definir posicion Como Entero
	Escribir 'Introduce un string: '
	Leer mensaje
	Para i<-0 Hasta Longitud(mensaje) Hacer
		char <- SubCadena(mensaje,i,i)
		Si (char='a') Entonces
			posicion <- 97
		FinSi
		Si (char='b') Entonces
			posicion <- 98
		FinSi
		Si (char='c') Entonces
			posicion <- 99
		FinSi
		Si (char='d') Entonces
			posicion <- 100
		FinSi
		Si (char='A') Entonces
			posicion <- 65
		FinSi
		Si (char='B') Entonces
			posicion <- 66
		FinSi
		Si (char='C') Entonces
			posicion <- 67
		FinSi
		Si (char='D') Entonces
			posicion <- 68
		FinSi
		Si (posicion>=65 Y posicion<=68) Entonces
			posicion <- posicion+32
		SiNo
			Si (posicion>=97 Y posicion<=100) Entonces
				posicion <- posicion-32
			FinSi
		FinSi
		Si (posicion=65) Entonces
			char <- 'A'
		FinSi
		Si (posicion=66) Entonces
			char <- 'B'
		FinSi
		Si (posicion=67) Entonces
			char <- 'C'
		FinSi
		Si (posicion=68) Entonces
			char <- 'D'
		FinSi
		Si (posicion=97) Entonces
			char <- 'a'
		FinSi
		Si (posicion=98) Entonces
			char <- 'b'
		FinSi
		Si (posicion=99) Entonces
			char <- 'c'
		FinSi
		Si (posicion=100) Entonces
			char <- 'd'
		FinSi
		solucion <- solucion+char
	FinPara
	Escribir solucion
FinAlgoritmo
