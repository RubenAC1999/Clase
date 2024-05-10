let imagenes = [];
let imagenesRandom = [];
let numeros = []


for (let i = 1; i < 7; i++) {
 let carta = document.createElement("img");
 carta.setAttribute("src", "cartas/carta" + i + ".jpg");
 imagenes.push(carta);

 let cartaCopia = document.createElement("img");
 cartaCopia.setAttribute("src", "cartas/carta" + i + ".jpg");
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

imagenesRandom.forEach(mostrarCartas);


function getRandomInt(min, max) { 
    return Math.floor(Math.random() * (max - min)) + min; 
}

function mostrarCartas(cartaActual) {
    document.body.appendChild(cartaActual);
}



