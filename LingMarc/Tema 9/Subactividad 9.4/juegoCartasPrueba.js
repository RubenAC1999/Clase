class Carta {
    constructor(src, valor) {
        this.elemento = document.createElement("img");
        -
        this.elemento.setAttribute("src", src);
        this.elemento.setAttribute("valor", valor);
        this.elemento.onclick = function() {
            this.elemento.setAttribute("src", src);
            this.elemento.setAttribute("valor", valor);
            cartasGiradas.push[this.elemento];
        }
    }
}

function crearBaraja() {
    let baraja = [];
    for (let i = 1; i < 7; i++) {
        let carta = new Carta("cartas/dorso.jpg", "cartas/carta" + i + ".jpg");
        baraja.push(carta.elemento);
        let cartaCopia = new Carta("cartas/dorso.jpg", "cartas/carta" + i + ".jpg");
        baraja.push(cartaCopia.elemento);
    }
    return baraja;
}


let baraja = crearBaraja();
baraja.forEach(agregarEvento);


let primerasCartas = baraja.slice(0, 6);
let ultimasCartas = baraja.slice(6);

primerasCartas.forEach(mostrar);
document.body.appendChild(document.createElement("br"));
ultimasCartas.forEach(mostrar);

function mostrar(carta) {
    document.body.appendChild(carta);
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}



let girando = false;

function darVuelta() {
    if (girando) {
        return;
    }
    
    if (baraja.length === 2) {
        girando = true;
        primerasCartas.forEach(bloquear);
        ultimasCartas.forEach(bloquear);

        setTimeout(comprobacion, 1500);
    }
   
}

function comprobacion() {
    if (cartasGiradas[0].getAttribute("src") === cartasGiradas[1].getAttribute("src")) {
        cartasGiradas[0].classList.add("carta-emparejada");
        cartasGiradas[1].classList.add("carta-emparejada");
    } else {
        cartasGiradas.forEach(function (carta) {
            carta.setAttribute("src", dorso);
        });
    }
    cartasGiradas = [];
    primerasCartas.forEach(agregarEvento);
    ultimasCartas.forEach(agregarEvento);
    girando = false;
}

    function bloquear() {
        this.removeEventListener("click", darVuelta);
    }

    function agregarEvento(carta) {
        carta.addEventListener("click", carta.girar);
    }


