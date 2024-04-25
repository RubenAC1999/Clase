let orden = "";

while (orden != "salir") {
    orden = prompt("Escribe una orden")
     if (orden >= 0 || orden <= 0) {
        alert(orden + " es un número");
        }
        else if (orden == "salir") {
            continue;
        }
        else {
            alert("ejemplo no es un número");
        }
    }
    


    