let orden;

do {
    orden = prompt("Escribe una orden")

     if ((orden >= 0 || orden <= 0) && orden != "" || (orden >= 0 || orden <= 0) && orden != null) {
        alert(orden + " es un número");

        
        }
        else if (orden.toLowerCase() == "salir" && orden == null) {
            orden == null;
        }
        else {
            alert("ejemplo no es un número");
        }
    
} while (orden.toLowerCase() != "salir");


    