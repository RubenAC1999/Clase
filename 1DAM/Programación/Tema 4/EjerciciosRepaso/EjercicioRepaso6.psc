Algoritmo EjercicioRepaso6
	Definir numeroAlumnos Como Entero
	Definir nota,notaTeorica,notaPractica Como Real
	Escribir 'Introduce el n�mero de alumnos que hay'
	Leer numeroAlumnos
	Para i<-1 Hasta numeroAlumnos Hacer
		Repetir
			Escribir 'Introduce la nota de la parte te�rica del alumno ',i
			Leer notaTeorica
		Hasta Que notaTeorica>0 Y notaTeorica<=10
		Repetir
			Escribir 'Introduce la nota de la parte pr�ctica del alumno ',i
			Leer notaPractica
		Hasta Que notaPractica>0 Y notaTeorica<=10
		nota <- (notaTeorica*0.6)+(notaPractica*0.4)
		Escribir 'Notas alumno ',i,':'
		Escribir '---------------------------------'
		Escribir 'Nota parte te�rica (60 %): ',notaTeorica
		Escribir 'Nota parte pr�ctica (40 %): ',notaPractica
		Escribir 'Nota total: ',nota
		Escribir '----------------------------------'
	FinPara
FinAlgoritmo
