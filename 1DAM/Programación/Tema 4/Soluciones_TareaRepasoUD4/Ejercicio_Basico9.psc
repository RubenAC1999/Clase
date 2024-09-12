Proceso Ejercicio_basico_9
	
	// Variables
	Definir num, cifras como numero;
	
	// Pedimos un numero                                                                                       
	Escribir "Dame un numero";
	Leer num;
	
	// Convertimos el numero a absoluto
	num <- abs(num);
	cifras <- 0;
	
	// Convertimos el numero a texto y despues sacamos su longitud
	cifras <- Longitud(ConvertirATexto(num));
	
	// Resultado
	Escribir "El numero de cifras es de ", cifras;
	
FinProceso

