let nif = prompt("Escriba el número NIF");
let acumulador = 0;
let letras = "TRWAGMYFPDXBNJZSQVHLCKE"
let resto = 0;

while ((nif < 0 || isNaN(nif)) && nif.length 8) {
    resto = nif % 23;
    alert("Número válido! La letra del DNI es: " + letras.charAt(resto));
}


