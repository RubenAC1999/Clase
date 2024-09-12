const tablero = document.createElement("section");
tablero.setAttribute("class", "tablero");
document.body.appendChild(tablero);




let colores = ["white", "black", "pink", "red", "blue", "green", "lime", "orange", "cyan", "purple", "ivory", "grey", "tomato", "grey", "green"];

const contenedorColores = document.createElement("section");
contenedorColores.setAttribute("class", "contenedorColores");
document.body.appendChild(contenedorColores);
let colorElegido;

let listaColores = document.querySelectorAll(".contenedorColores div");

function cambiarTamanho() {
    for (let i = 0; i < listaColores.length; i++) {
        listaColores[i].setAttribute("class", "color");
    }

    this.setAttribute("class", "elegido");

}

function cambiarColor() {
    colorElegido = this.getAttribute("style");
}

function generarCasillasColores() {
    for (let i = 0; i < 15; i++) {
        let color = document.createElement("div");
        color.setAttribute("class", "color");
        contenedorColores.appendChild(color);
        color.style.backgroundColor = colores[i];
        color.onclick = cambiarTamanho; 
        color.onclick = cambiarColor;   
        
    }
}



generarCasillasColores();

let listaCeldas = document.getElementsByClassName("casilla");

function limpiarCeldas() {
    for (let i = 0; i < listaCeldas.length; i++) {
        listaCeldas[i].style.backgroundColor = "white";
    }
}

const botonLimpiar = document.createElement("button");
document.body.appendChild(botonLimpiar);
botonLimpiar.textContent = "Limpiar celdas";
botonLimpiar.onclick = limpiarCeldas;

function colorear() {
    this.setAttribute("style", colorElegido);
}

function generarCasillas() {
    for (let i = 0; i < 15; i++) {
        let fila = document.createElement("div");
        tablero.appendChild(fila);
        for (let j = 0; j < 15; j++) {
            let casilla = document.createElement("div");
            casilla.setAttribute("class", "casilla");
            fila.appendChild(casilla);
            casilla.onclick = colorear;
        }
    }
}

generarCasillas();

