Proceso SerieFibonacci
    Definir N, i, terminoActual, terminoAnterior, nuevoTermino Como Entero
    
    Escribir "Ingrese la cantidad de términos a mostrar:"
    Leer N
    
    // Inicializar los dos primeros términos de la serie
    terminoAnterior = 0
    terminoActual = 1
    
    Escribir "Los primeros ", N, " términos de la serie Fibonacci son:"
    
    // Mostrar los primeros N términos de la serie
    Para i = 1 Hasta N Con Paso 1
        Escribir terminoAnterior
        
        // Calcular el siguiente término
        nuevoTermino = terminoAnterior + terminoActual
        
        // Actualizar los términos para el siguiente ciclo
        terminoAnterior = terminoActual
        terminoActual = nuevoTermino
    FinPara
FinProceso
