let imagenes = [];
let imagenesRandom = [];
let numeros = []



for (let i = 1; i < 7; i++) {
 let carta = document.createElement("img");
 carta.setAttribute("src", "cartas/dorso.jpg");
 carta.setAttribute("valor", "cartas/carta" + i + ".jpg");
 carta.onclick = function() {
    darVuelta(this);
 }
 
 imagenes.push(carta);

 let cartaCopia = document.createElement("img");
 cartaCopia.setAttribute("src", "cartas/dorso.jpg");
 cartaCopia.setAttribute("valor", "cartas/carta" + i + ".jpg");
 cartaCopia.onclick = function() {
    darVuelta(this);
 }
 
 imagenes.push(cartaCopia);
}

for (let i = 0; i < imagenes.length; i++) {
    let numAleatorio = getRandomInt(0,imagenes.length);
    if (!numeros.includes(numAleatorio)) {
            numeros.push(numAleatorio);
            imagenesRandom.push(imagenes[numAleatorio]);
    }
    else {
        i--;
    }
}

let primerasCartas = imagenesRandom.slice(0,6);
let ultimasCartas = imagenesRandom.slice(6);

primerasCartas.forEach(mostrarCartas);
document.body.appendChild(document.createElement("br"));
ultimasCartas.forEach(mostrarCartas);



function getRandomInt(min, max) { 
    return Math.floor(Math.random() * (max - min)) + min; 
}

function mostrarCartas(cartaActual) {
    document.body.appendChild(cartaActual);
}

function darVuelta(cartaActual) {
    let dorso = cartaActual.getAttribute("src");
    cartaActual.setAttribute("src", cartaActual.getAttribute("valor"));
}





