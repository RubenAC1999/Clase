let limite = prompt("Introduce un número del 10 al 99999");
let contador = 0;
let contenedor = document.createElement("div");
document.body.appendChild(contenedor);

let listaNumeros = [];

for (let i = 0; i < limite.valueOf(); i++) {
    if (i > 10 && comprobarPalindromo(i)) {
        listaNumeros.push(i);
        contador++;
    }
}
let contadorElement = document.createElement("p");
contadorElement.textContent = "Se han encontrado " + contador + " palíndromos.";
contenedor.appendChild(contadorElement);

for (let i = 0; i < listaNumeros.length; i++) {
    let numero = document.createElement("p");
    numero.textContent = listaNumeros[i];
    contenedor.appendChild(numero);
}



function comprobarPalindromo(numero) {
    let numPalindromo = "";
    let numeroStr = numero.toString();
    for (let i = 0; i <= numeroStr.length; i++) {
        numPalindromo += numeroStr.charAt(numeroStr.length - i);
    }
    if (numPalindromo === numeroStr) {
        return true;
    } else {
        return false;
    }
}