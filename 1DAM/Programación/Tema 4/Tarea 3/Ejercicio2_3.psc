Algoritmo Ejercicio2_3
	Definir num Como Real
	Definir solucionResto Como Logico
	Escribir 'Introduce un n�mero: '
	Leer num
	solucionResto <- verdadero
	Para i<-2 Hasta num-1 Hacer
		resto <- num MOD i
		Si (resto==0) Entonces
			solucionResto <- falso
		FinSi
	FinPara
	
	Si solucionResto=falso Entonces
		Escribir num,' no es n�mero primo'
	SiNo
		Escribir num,' es n�mero primo'
	FinSi
FinAlgoritmo
