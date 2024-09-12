Proceso Ejercicio_Basico_8
	
	// Definición de variables
	definir abecedario, frase como cadena;
	definir caracterFrase Como Caracter;
	definir contadores, i, j como numero;
	definir algunVacio Como Logico;
	
	abecedario <- "abcdefghijklmnñopqrstuvwxyz";
	algunVacio <- Falso;
	Dimension contadores[27];
	
	// inicializamos el arreglo
	Para i<-1 Hasta Longitud(abecedario) Con Paso 1 Hacer
		contadores[i] <- 1;
	FinPara
	
	// Pedimos una frase
	Escribir "Escribe una frase: ";
	leer frase;
	frase <- Minusculas(frase);
	
	// Comprobamos si existe cada letra de la frase en el abecedario
	Para i<-1 Hasta Longitud(frase) Con Paso 1 Hacer
		caracterFrase <- Subcadena(frase, i,i);
		Para j<-1 Hasta Longitud(abecedario)  Con Paso 1 Hacer
			Si caracterFrase = Subcadena(abecedario, j,j) Entonces
				contadores[j] <- contadores[j] + 1;
			FinSi
		FinPara
	FinPara
	
	i<-1;
	
	// Comprobamos si hay alguna posicion a cero
	Mientras no algunVacio y i < Longitud(abecedario) Hacer
		Si contadores[i] = 1 Entonces
			algunVacio <- Verdadero;
		FinSi
		i <- i + 1;
	FinMientras
	// Indicamos si es un panagrama o no
	Si algunVacio Entonces
		Escribir "No es un panagrama";
	SiNo
		Escribir "Es un panagrama";
	FinSi
	
FinProceso

