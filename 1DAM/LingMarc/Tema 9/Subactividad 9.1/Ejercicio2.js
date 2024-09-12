let letras = "TRWAGMYFPDXBNJZSQVHLCKE"
let resto = 0;
let input = document.getElementById("numero");
let respuesta = document.getElementById("respuesta");
let boton = document.getElementById("boton");

boton.onclick = comprobar;

function comprobar() {
    if (input.value <= 0 || isNaN(input.value)) {
        respuesta.innerHTML = "Número inválido, vueva a intentarlo.";
    }
    else if (input.value.length != 8) {
        respuesta.innerHTML = "El número debe tener 8 dígitos."
    }
    else {
        resto = input.value % 23;
        respuesta.innerHTML = "Número válido! La letra del DNI es: " + letras.charAt(resto);
    }
}





