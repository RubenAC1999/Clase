Algoritmo Ejercicio2_8
	Escribir 'Escribe una frase'
	Leer frase
	Para i<-Longitud(frase) Hasta 1 Con Paso -1 Hacer
		char <- SubCadena(frase,i,i)
		fraseInvertida <- fraseInvertida+char
	FinPara
	Si (frase==fraseInvertida) Entonces
		Escribir 'Es un pal�ndromo'
	SiNo
		Escribir 'No es un pal�ndromo'
	FinSi
FinAlgoritmo
