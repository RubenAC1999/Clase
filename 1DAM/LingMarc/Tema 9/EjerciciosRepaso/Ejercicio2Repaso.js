// Crear el contenedor principal
let contenedor = document.createElement("section");
contenedor.setAttribute("class", "contenedor");
document.body.appendChild(contenedor);

// Crear las filas y casillas dentro del contenedor
for (let i = 0; i <= 20; i++) {
    let fila = document.createElement("div");
    fila.setAttribute("class", "fila");
    contenedor.appendChild(fila);

    for (let j = 0; j <= 20; j++) {
        let casilla = document.createElement("div");
        casilla.setAttribute("class", "casilla");
        casilla.onmouseover = colorearCasilla;
        fila.appendChild(casilla);
    }
}

// Función para cambiar el color de las casillas
let atributoColor;
function colorearCasilla() {
    this.setAttribute("style", atributoColor);
}

// Crear el contenedor de los colores
let listaColores = document.createElement("section");
listaColores.setAttribute("class", "listaColores");
document.body.appendChild(listaColores);

// Crear los botones de colores
let coloresElegidos = ["red", "lime", "orange", "blue", "black"];
function cambiarColor() {
    atributoColor = this.getAttribute("style");
}

// Generar los botones de colores y asignarles un evento de clic
function generarColores() {
    for (let i = 0; i < 5; i++) {
        let color = document.createElement("div");
        color.setAttribute("class", "color");
        listaColores.appendChild(color);
        color.style.backgroundColor = coloresElegidos[i];
        color.onclick = cambiarColor;
    }
}

generarColores();

let operaciones = document.createElement("section");
operaciones.setAttribute("class", "botones");
document.body.appendChild(operaciones);

// Crear el botón para limpiar las casillas
let botonLimpiar = document.createElement("button");
operaciones.appendChild(botonLimpiar);
botonLimpiar.textContent = "Limpiar celdas";
botonLimpiar.onclick = limpiarCeldas;


// Función para limpiar las casillas
function limpiarCeldas() {
    let listaCeldas = document.getElementsByClassName("casilla");
    for (let i = 0; i < listaCeldas.length; i++) {
        listaCeldas[i].style.backgroundColor = "white";
    }
}
let contador = 0;

function generarBotonesCambiar() {
    let listaBotones = document.createElement("div");
    listaBotones.setAttribute("class", "listaBotones");
    document.body.insertBefore(listaBotones, operaciones);
    for (let i = 0; i < 5; i++) {

        let botonCambiar = document.createElement("button");
        listaBotones.appendChild(botonCambiar);
        botonCambiar.textContent = "Modificar";
    }
}

generarBotonesCambiar();




