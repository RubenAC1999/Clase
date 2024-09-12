Algoritmo Ejercicio2_6
	Definir contador Como Entero
	Definir char Como Caracter
<<<<<<< Updated upstream
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
=======
	Repetir
		Escribir 'Introduce un caracter: '
		Leer char
	Hasta Que Longitud(char)=1
	Escribir 'Introduce un string (<> para finalizar)'
	Repetir
		Leer mensaje
		Para i<-0 Hasta Longitud(mensaje) Hacer
			Si (Subcadena(mensaje,i,i)=char) Entonces
				contador <- contador+1
			FinSi
		FinPara
	Hasta Que mensaje='<>'
	Escribir 'El caracter ',char,' aparece ',contador,' veces'
>>>>>>> Stashed changes
FinAlgoritmo
