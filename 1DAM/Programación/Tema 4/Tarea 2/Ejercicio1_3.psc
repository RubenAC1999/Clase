Algoritmo Ejercicio1_3
	Definir num1, num2, num3 Como Real
	Escribir "Introduce el primer número"
	Leer num1
	Escribir "Introduce el segundo número"
	Leer num2
	Escribir "Introduce el tercer número"
	Leer num3
	
	Si(num1 > num2) Y (num1 > num3) Entonces
		Escribir num1, " es el número mayor"
	FinSi
		
	Si(num2 > num1) Y (num2 > num3) Entonces
			Escribir num2, " es el número mayor"
	FinSi
		
	Si(num3 > num1) Y (num3 > num2) Entonces
			Escribir num3, " es el número mayor"
	FinSi
	
	Si(num1 = num2) Y (num1 = num3) Entonces
		Escribir "3 iguales"
	FinSi
	
FinAlgoritmo
