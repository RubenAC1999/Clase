Algoritmo EjercicioRepaso11
	Definir num,contador Como Entero
	contador <- 0
	Escribir 'Escribe un número'
	Leer num
	Escribir 'Lista de divisores de ',num
	Escribir '---------------------------'
	Para i<-1 Hasta num Hacer
		solucion <- num MOD i
		Si solucion=0 Entonces
			Escribir i
			contador <- contador+1
		FinSi
	FinPara
	Escribir num,' tiene ',contador,' divisores'
FinAlgoritmo
