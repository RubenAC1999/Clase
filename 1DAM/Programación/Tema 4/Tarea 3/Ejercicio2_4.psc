Algoritmo Ejercicio2_4
	Definir num Como Real
	Definir solucionResto Como Logico
	Escribir 'Introduce un número: '
	Leer num
	Para i<-2 Hasta num-1 Hacer
		solucionResto <- verdadero
		Para j<-1 Hasta i-1 Hacer
			resto <- i MOD j
			Si (j<>1 Y resto==0) Entonces
				solucionResto <- falso
			FinSi
		FinPara
		Si solucionResto=verdadero Entonces
			Escribir i
		FinSi
	FinPara
FinAlgoritmo
