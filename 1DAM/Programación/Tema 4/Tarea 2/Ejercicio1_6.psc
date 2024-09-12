Algoritmo Ejercicio1_6
	Definir comidaDiaria,kilosPorAnimal,numAnimales Como Real
	Escribir 'Introduzca la cantidad de alimento diaria disponible:'
	Leer comidaDiaria
	Escribir 'Introduzca el número de animales que hay en la granja:'
	Leer numAnimales
	Escribir 'Introduzca la cantidad de kilos que necesita consumir cada animal al día:'
	Leer kilosPorAnimal
	excedente <- comidaDiaria-(kilosPorAnimal*numAnimales)
	racion <- comidaDiaria/numAnimales
	Si comidaDiaria<(kilosPorAnimal*numAnimales) Entonces
		Escribir '¡Cantidad insuficiente!'
		Escribir 'La cantidad de ración que se repartirá para cada animal será de: ',racion,' kilos'
		Escribir 'El excedente de la comida de hoy fue de: 0 kilos'
	SiNo
		Escribir '¡Cantidad necesaria suficiente!'
		Escribir 'El excedente de la comida de hoy fue de: ',excedente,' kilos'
	FinSi
FinAlgoritmo
