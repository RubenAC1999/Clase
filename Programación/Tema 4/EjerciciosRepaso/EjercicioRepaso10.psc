Algoritmo EjercicioRepaso10
	Definir num1,num2 Como Entero
	numFibonacci <- 0
	num1 <- 0
	num2 <- 1
	Escribir 'Escribe un número como límite para la sucesion'
	Leer num
	Para i<-0 Hasta num Hacer
		Escribir numFibonacci
		numFibonacci <- num1+num2
		num1 <- num2
		num2 <- numFibonacci
	FinPara
FinAlgoritmo
