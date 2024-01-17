Algoritmo Ejercicio2_2
	Definir i,j Como Entero
	Escribir '************************'
	Escribir '* TABLA DE MULTIPLICAR *'
	Escribir '************************'
	Para i<-0 Hasta 10 Hacer
		Escribir '------------------'
		Escribir 'TABLA DEL ',i
		Escribir '------------------'
		Para j<-0 Hasta 10 Hacer
			multiplicacion <- i*j
			Escribir i,' x ',j,' = ',multiplicacion
		FinPara
	FinPara
FinAlgoritmo
