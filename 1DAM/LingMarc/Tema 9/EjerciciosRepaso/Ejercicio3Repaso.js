let sS = document.getElementById("sS");
let lS = document.getElementById("lS");
let contadorSs = 0;
let contadorLs = 0;
let botonEliminarSs = document.getElementById("eliminar sS");
botonEliminarSs.onclick = eliminarSessionStorage;

let botonEliminarLs = document.getElementById("eliminar lS");
botonEliminarLs.onclick = eliminarLocalStorage;

let botonContar = document.getElementById("contar");
botonContar.onclick = contar;

function contar() {
    contadorSs++;
    contadorLs++;
    sS.textContent = "sessionStorage: " + contadorSs;
    lS.textContent = "localStorage: " + contadorLs;
}

function eliminarSessionStorage() {
    contadorSs = 0;
    sS.textContent = "sessionStorage: " + contadorSs;
}

function eliminarLocalStorage() {
    contadorLs = 0;
    lS.textContent = "localStorage: " + contadorLs;
}