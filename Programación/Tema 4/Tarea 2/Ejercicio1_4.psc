Algoritmo Ejercicio1_4
	Definir a,b,c Como Real
	Escribir 'Escribe el coeficiente de a'
	Leer a
	Escribir 'Escribe el coeficiente de b'
	Leer b
	Escribir 'Escribe el coeficiente de c'
	Leer c
	discriminante <- Raiz((b*b)-4*a*c)
	Si (a==0) Y (b==0) Entonces
		Escribir 'a y b no pueden ser 0 simult�neamente'
	SiNo
		Si (a==0) Entonces
			solucion <- -c/b
			Escribir '�nica soluci�n: ',solucion1
		FinSi
		Si (discriminante<0) Entonces
			Escribir 'La ecuaci�n no tiene soluciones reales'
		FinSi
		Si (discriminante==0) Entonces
			solucion <- -b/(2*a)
			Escribir '�nica soluci�n: ',solucion
		FinSi
		Si (a<>0) Y (b<>0) Y (discriminante>0) Entonces
			solucion1 <- (-b+discriminante)/(2*a)
			solucion2 <- (-b-discriminante)/(2*a)
			Escribir 'Las soluciones de esta ecuaci�n son: ',solucion1,' y ',solucion2
		FinSi
	FinSi
FinAlgoritmo
