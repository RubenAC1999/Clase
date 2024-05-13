class Carta {
    constructor(src, valor) {
        this.src = src;
        this.valor = valor;
    }
}

function crearBaraja() {
    let baraja = [];
    for (let i = 1; i < 7; i++) {
        let carta = new Carta("cartas/dorso.jpg", "cartas/carta" + i + ".jpg");

        carta = document.createElement("img");
        carta.setAttribute("src", carta.src);
        carta.setAttribute("alt", carta.valor);
        baraja.push(carta);

        let cartaCopia = new Carta("cartas/dorso.jpg", "cartas/carta" + i + ".jpg");
        cartaCopia = document.createElement("img");
        cartaCopia.setAttribute("src", cartaCopia.src);
        cartaCopia.setAttribute("alt", cartaCopia.valor);
        baraja.push(cartaCopia);
    }
    return baraja;
}

crearBaraja().forEach(mostrar);
let numeros = [];

function barajar(baraja) {
    let cartasBarajadas = [];
    for (let i = 0; i < baraja.length; i++) {
        let numAleatorio = getRandomInt(0, baraja.length);
        if (!numeros.includes(numAleatorio)) {
            numeros.push(numAleatorio);
            cartasBarajadas.push(baraja[numAleatorio]);
        }
        else {
            i--;
        }
    }
    return cartasBarajadas;
}


function mostrar(carta) {
    document.body.appendChild(carta);
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}



