Algoritmo Ejercicio2_3
	Definir num Como Real
	Definir solucionResto Como Logico
	Escribir 'Introduce un número: '
	Leer num
	solucionResto <- verdadero
	Para i<-2 Hasta num-1 Hacer
		resto <- num MOD i
		Si (resto==0) Entonces
			solucionResto <- falso
		FinSi
	FinPara
	
	Si solucionResto=falso Entonces
		Escribir num,' no es número primo'
	SiNo
		Escribir num,' es número primo'
	FinSi
FinAlgoritmo
