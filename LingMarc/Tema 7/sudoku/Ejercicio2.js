let letras = "TRWAGMYFPDXBNJZSQVHLCKE"
let resto = 0;
let nif = prompt("Escriba el número NIF");

while (nif != null) {
    if (isNaN(nif) || nif.length != 8) {
        alert("Número inválido, vueva a intentarlo.");
        nif = prompt("Escriba el número NIF");
    }
    else {
        resto = nif % 23;
        alert("Número válido! La letra del DNI es: " + letras.charAt(resto));
        nif = prompt("Escriba el número NIF");
    }
}




