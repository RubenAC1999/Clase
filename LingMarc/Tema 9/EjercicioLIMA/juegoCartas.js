let palos = ["o", "e", "c", "b"];
let imagenes = new Array(16);
let imagenesRandom = new Array(16);
let numeros = new Array(16);

function getRandomInt(min, max) { 
    return Math.floor(Math.random() * (max - min)) + min; 
}

function mostrarCartas(cartaActual) {
    document.body.appendChild(cartaActual);
}



for (let i = 1; i <= 8; i++) {
 let paloAleatorio = palos[getRandomInt(0, (palos.length - 1))]
 let numCarta = getRandomInt(1, 13);
 let carta = document.createElement("img");
 let cartaCopia = document.createElement("img");
 carta.setAttribute("src", "cartas/" + paloAleatorio + numCarta + ".jpg");
 cartaCopia.setAttribute("src", "cartas/" + paloAleatorio + numCarta + ".jpg");
 imagenes.push(carta);
 imagenes.push(cartaCopia);
}

for (let i = 0; i < 16; i++) {
    let numAleatorio = getRandomInt(0,16);
    if (numeros.includes(numAleatorio) == false) {
            numeros.push(numAleatorio);
            imagenesRandom.push(imagenes[numAleatorio]);
    }
}

imagenes.forEach(mostrarCartas);
imagenesRandom.forEach(mostrarCartas);






