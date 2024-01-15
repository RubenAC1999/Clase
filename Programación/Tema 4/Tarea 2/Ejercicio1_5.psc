Algoritmo Ejercicio1_5
	Repetir
		Escribir 'Introduzca tu dni'
		Leer dni
		Si Longitud(dni)<>8 Entonces
			Escribir '¡DNI incorrecto! Inténtelo de nuevo'
		FinSi
	Hasta Que Longitud(dni)==8
	resto <- ConvertirANumero(dni) MOD 23
	Segun resto  Hacer
		0:
			Escribir 'La letra es T'
		1:
			Escribir 'La letra es R'
		2:
			Escribir 'La letra es W'
		3:
			Escribir 'La letra es A'
		4:
			Escribir 'La letra es G'
		5:
			Escribir 'La letra es M'
		6:
			Escribir 'La letra es Y'
		7:
			Escribir 'La letra es F'
		8:
			Escribir 'La letra es P'
		9:
			Escribir 'La letra es D'
		10:
			Escribir 'La letra es X'
		11:
			Escribir 'La letra es B'
		12:
			Escribir 'La letra es N'
		13:
			Escribir 'La letra es J'
		14:
			Escribir 'La letra es Z'
		15:
			Escribir 'La letra es S'
		16:
			Escribir 'La letra es Q'
		17:
			Escribir 'La letra es V'
		18:
			Escribir 'La letra es H'
		19:
			Escribir 'La letra es L'
		20:
			Escribir 'La letra es C'
		21:
			Escribir 'La letra es K'
		22:
			Escribir 'La letra es E'
	FinSegun
FinAlgoritmo
