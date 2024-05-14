class Carta {
    constructor(src, valor) {
        this.src = src;
        this.valor = valor;
        this.crearElemento = function() {
            this.elemento = document.createElement("img");
            this.elemento.setAttribute("src", this.src);
            this.elemento.setAttribute("valor", this.valor);
            return this.elemento;
        }
    }
}

function crearBaraja() {
    let baraja = [];
    for (let i = 1; i < 7; i++) {
        let carta = new Carta("cartas/dorso.jpg", "cartas/carta" + i + ".jpg");
        baraja.push(carta.crearElemento());
        let cartaCopia = new Carta("cartas/dorso.jpg", "cartas/carta" + i + ".jpg");
        baraja.push(cartaCopia.crearElemento());
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
let cartasGiradas = [];

function darVuelta() {
    if (girando) {
        return;
    }
    
    let dorso = this.getAttribute("src");
    this.setAttribute("src", this.getAttribute("valor"));
    cartasGiradas.push(this);

    if (cartasGiradas.length === 2) {
        girando = true;
        primerasCartas.forEach(bloquear);
        ultimasCartas.forEach(bloquear);

        setTimeout(function () {
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
        }, 1500);
    }
}

    function bloquear() {
        this.removeEventListener("click", darVuelta);
    }

    function agregarEvento(carta) {
        carta.addEventListener("click", darVuelta);
    }


