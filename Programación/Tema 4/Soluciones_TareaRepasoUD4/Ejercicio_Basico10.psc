Proceso SerieFibonacci
    Definir N, i, terminoActual, terminoAnterior, nuevoTermino Como Entero
    
    Escribir "Ingrese la cantidad de t�rminos a mostrar:"
    Leer N
    
    // Inicializar los dos primeros t�rminos de la serie
    terminoAnterior = 0
    terminoActual = 1
    
    Escribir "Los primeros ", N, " t�rminos de la serie Fibonacci son:"
    
    // Mostrar los primeros N t�rminos de la serie
    Para i = 1 Hasta N Con Paso 1
        Escribir terminoAnterior
        
        // Calcular el siguiente t�rmino
        nuevoTermino = terminoAnterior + terminoActual
        
        // Actualizar los t�rminos para el siguiente ciclo
        terminoAnterior = terminoActual
        terminoActual = nuevoTermino
    FinPara
FinProceso
