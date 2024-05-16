class Carta {
    constructor(src, valor) {
        this.src = src;
        this.valor = valor;

        this.elemento = document.createElement("img");
        this.elemento.setAttribute("src", this.src);
        this.elemento.setAttribute("valor", this.valor);

        this.girar = function(img) {
            let dorso = img.getAttribute("src");
            let valor = img.getAttribute("valor");
            img.setAttribute("src", valor);
            img.setAttribute("valor", dorso);
        }

    }
}

function crearBaraja() {
    let baraja = [];
    for (let i = 1; i < 9; i++) {
        let carta = new Carta("cartas/dorso.jpg", "cartas/carta" + i + ".jpg");
        baraja.push(carta.elemento);
        let cartaCopia = new Carta("cartas/dorso.jpg", "cartas/carta" + i + ".jpg");
        baraja.push(cartaCopia.elemento);
    }
    return baraja;
}


let baraja = crearBaraja();


let primerasCartas = baraja.slice(0, 8);
let ultimasCartas = baraja.slice(8);

primerasCartas.forEach(mostrar);
document.body.appendChild(document.createElement("br"));
ultimasCartas.forEach(mostrar);

function mostrar(carta) {
    document.body.appendChild(carta);
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}



