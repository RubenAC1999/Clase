Algoritmo Ejercicio2_5
	Definir num,acumulador,numeroMayor,numeroMenor,numeroPasado Como Real
<<<<<<< Updated upstream
=======
	acumulador <- 0
	numeroMayor <- 0
	numeroMenor <- 0
	numeroPasado <- 0
>>>>>>> Stashed changes
	Escribir 'Introduzca un n�mero (00 para finalizar): '
	Leer numString
	num <- ConvertirANumero(numString)
	numeroMayor <- num
	numeroMenor <- num
	Repetir
		Si numString<>'00' Entonces
			acumulador <- acumulador+num
			Si num>=numeroPasado Y num>=numeroMayor Entonces
				numeroMayor <- num
			FinSi
			Si num<numeroPasado Y num<numeroMenor O numeroMenor==0 Entonces
				numeroMenor <- num
			FinSi
			numeroPasado <- num
			Escribir 'Introduce otro n�mero: '
			Leer numString
			num <- ConvertirANumero(numString)
		FinSi
	Hasta Que numString='00'
	Escribir 'La suma de los n�meros es: ',acumulador
	Escribir 'El n�mero mayor es: ',numeroMayor
	Escribir 'El n�mero menor es: ',numeroMenor
FinAlgoritmo
