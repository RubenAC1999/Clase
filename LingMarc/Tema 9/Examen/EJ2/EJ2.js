let ticket = document.getElementById("ticket");
let cuadrado = document.getElementById("cuadrado");
let circulo = document.getElementById("circulo");
let triangulo = document.getElementById("triangulo");

let botonAnhadirCuadrado = document.getElementById("botonCuadrado");
let botonAnhadirCirculo = document.getElementById("botonCirculo");
let botonAnhadirTriangulo = document.getElementById("botonTriangulo");

let carrito = document.getElementById("carrito");

let contador = 0;


function anhadirCuadrado() {
   let articulo = cuadrado.childNodes();
   carrito.appendChild(articulo);

}

botonAnhadirCuadrado.onclick = anhadirCuadrado;

function anhadirCirculo() {
    let cuadrado = document.createElement("div")
    carrito.appendChild(cuadrado);

    let svg = document.createElement("svg");
    svg.setAttribute("height", "100");
    svg.setAttribute("width", "300");
    cuadrado.appendChild(svg);
    let figura = document.createElement("rect");
    figura.setAttribute("x", "120");
    figura.setAttribute("y", "20");
    figura.setAttribute("height", "50");
    figura.setAttribute("width", "50");
    figura.setAttribute("style", "fill: blue;");
    svg.appendChild(figura);

    let titulo = document.createElement("p");
    titulo.setAttribute("class", "titulo");
    titulo.textContent = "Circulo";
    cuadrado.appendChild(titulo);
    let precio = document.createElement("p");
    precio.textContent = "precio 15€";
    cuadrado.appendChild(precio);

    let total = document.getElementById("total");
    contador = contador + 15;
    total.textContent = "Total: " + contador + "€";

}

botonAnhadirCirculo.onclick = anhadirCirculo;

function anhadirTriangulo() {
    let cuadrado = document.createElement("div")
    carrito.appendChild(cuadrado);

    let svg = document.createElement("svg");
    svg.setAttribute("height", "100");
    svg.setAttribute("width", "300");
    cuadrado.appendChild(svg);
    let figura = document.createElement("rect");
    figura.setAttribute("x", "120");
    figura.setAttribute("y", "20");
    figura.setAttribute("height", "50");
    figura.setAttribute("width", "50");
    figura.setAttribute("style", "fill: blue;");
    svg.appendChild(figura);

    let titulo = document.createElement("p");
    titulo.setAttribute("class", "titulo");
    titulo.textContent = "Triángulo";
    cuadrado.appendChild(titulo);
    let precio = document.createElement("p");
    precio.textContent = "precio 20€";
    cuadrado.appendChild(precio);

    let total = document.getElementById("total");
    contador = contador + 20;
    total.textContent = "Total: " + contador + "€";

}

botonAnhadirTriangulo.onclick = anhadirTriangulo;