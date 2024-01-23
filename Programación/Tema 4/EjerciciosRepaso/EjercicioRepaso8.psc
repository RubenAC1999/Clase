Algoritmo EjercicioRepaso8
	Definir letra Como Caracter
	Escribir 'Escribe una frase'
	Leer mensaje
	mensaje <- Minusculas(mensaje)
	Para i<-0 Hasta Longitud(mensaje) Hacer
		letra <- Subcadena(mensaje,i,i)
		Si letra='a' Entonces
			a <- 1
		FinSi
		Si letra='b' Entonces
			b <- 1
		FinSi
		Si letra='c' Entonces
			c <- 1
		FinSi
		Si letra='d' Entonces
			d <- 1
		FinSi
	FinPara
	Si a>0 Y b>0 Y c>0 Y d>0 Entonces
		Escribir 'La frase es un panagrama'
	SiNo
		Escribir 'La fase no es un panagrama'
	FinSi
FinAlgoritmo
