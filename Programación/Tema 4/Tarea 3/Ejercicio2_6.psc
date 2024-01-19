Algoritmo Ejercicio2_6
	Definir contador Como Entero
	Definir char Como Caracter
	contador <- 0
	Escribir 'Introduce un caracter: '
	Leer char
	Repetir
		Escribir 'Introduce un string (<> para finalizar): '
		Leer mensaje
		Para i<-0 Hasta Longitud(mensaje) Hacer
			Si SubCadena(mensaje,i,i)=char Entonces
				contador <- contador+1
			FinSi
		FinPara
	Hasta Que (mensaje='<>')
	Escribir contador
FinAlgoritmo
