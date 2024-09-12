class Carta {
    constructor(src, valor) {
        this.src = src;
        this.valor = valor;
        this.elemento = document.createElement("img");
        this.elemento.setAttribute("src", src);
        this.elemento.setAttribute("valor", valor);
        
        this.girar = function () {
            if (girando || cartasGiradas.includes(this) || cartasEmparejadas.includes(this)) {
                return
            }
            this.setAttribute("src",this.getAttribute("valor"));
            cartasGiradas.push(this);

            if (cartasGiradas.length === 2) {
                comprobacion();
            }
        };
        
        this.elemento.onclick = this.girar;
        
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

function barajar(baraja) {
    let numeros = [];
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

let baraja = barajar(crearBaraja());


// Creación de html
let div = document.createElement("div");
document.body.appendChild(div);

let puntuacion = document.createElement("p");
let puntuacionContador = 100;
puntuacion.textContent = "Puntuacion: " + puntuacionContador;
document.body.appendChild(puntuacion);

let primerasCartas = baraja.slice(0, 8);
let ultimasCartas = baraja.slice(8);
primerasCartas.forEach(mostrar);
div.appendChild(document.createElement("br"));
ultimasCartas.forEach(mostrar);



function mostrar(carta) {
    div.appendChild(carta);
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}



let cartasEmparejadas = [];
let cartasGiradas = [];
let girando = false;

function comprobacion() {
    let dorso = "cartas/dorso.jpg";
        girando = true;
        primerasCartas.forEach(bloquear);
        ultimasCartas.forEach(bloquear);
        setTimeout(function () {
            if (cartasGiradas[0].getAttribute("src") === cartasGiradas[1].getAttribute("src")) {
                cartasGiradas[0].classList.add("carta-emparejada");
                cartasGiradas[1].classList.add("carta-emparejada");
                cartasEmparejadas.push(cartasGiradas[0]);
                cartasEmparejadas.push(cartasGiradas[1]);
            } else {
                cartasGiradas.forEach(function (carta) {
                    let valor = carta.getAttribute("src");
                    carta.setAttribute("valor", valor);
                    carta.setAttribute("src", dorso);
                    
                });
                puntuacionContador -= 5;
                puntuacion.textContent = "Puntuacion: " + puntuacionContador;
            }
            cartasEmparejadas.forEach(bloquear);
            primerasCartas.forEach(desbloquear);
            ultimasCartas.forEach(desbloquear);
            cartasGiradas = [];
            girando = false;
            guardarPuntuacion();
        }, 1500);
    }

    function guardarPuntuacion() {
        if (cartasEmparejadas.length === 16) {
            localStorage.setItem("puntuacion", puntuacionContador);
        }
    }


    function bloquear(carta) {
        carta.removeEventListener("click", carta.girar);
    }
    
    function desbloquear(carta) {
        carta.addEventListener("click", carta.girar);
    }
