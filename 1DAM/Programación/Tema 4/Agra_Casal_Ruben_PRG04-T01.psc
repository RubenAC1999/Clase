Algoritmo sin_titulo
	Definir x, r Como Real
	Escribir "Introduce un número"
	Leer x
	r =Aleatorio(0,x)
	Repetir
		r=(r+x/r)/2
		Escribir r
	Hasta Que (r^2-x)<0.0000001
FinAlgoritmo
