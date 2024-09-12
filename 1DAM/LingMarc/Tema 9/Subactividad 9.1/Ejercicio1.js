let orden = document.getElementById("orden");
let boton = document.getElementById("boton");
let respuesta = document.getElementById("respuesta");

boton.onclick = comprobar;

function comprobar() {
    if (isNaN(orden.value)) {
        respuesta.innerHTML = orden.value + " no es un número";
    }
    else if (orden.value.trim() === "") {
        respuesta.innerHTML = "El campo está vacío";
    }
    else {
        respuesta.innerHTML = orden.value + " es un número";
    }
}

    