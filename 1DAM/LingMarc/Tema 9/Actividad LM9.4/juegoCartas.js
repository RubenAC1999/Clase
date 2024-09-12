let imagenes = [];
let imagenesRandom = [];
let numeros = [];

//Creación de cartas
for (let i = 1; i < 7; i++) {
    let carta = document.createElement("img");
    carta.setAttribute("src", "cartas/dorso.jpg");
    carta.setAttribute("valor", "cartas/carta" + i + ".jpg");
    carta.onclick = function () {
        darVuelta(carta);
    }

    imagenes.push(carta);

    let cartaCopia = document.createElement("img");
    cartaCopia.setAttribute("src", "cartas/dorso.jpg");
    cartaCopia.setAttribute("valor", "cartas/carta" + i + ".jpg");
    cartaCopia.onclick = function () {
        darVuelta(cartaCopia);
    }

    imagenes.push(cartaCopia);
}

// Barajar cartas
for (let i = 0; i < imagenes.length; i++) {
    let numAleatorio = getRandomInt(0, imagenes.length);
    if (!numeros.includes(numAleatorio)) {
        numeros.push(numAleatorio);
        imagenesRandom.push(imagenes[numAleatorio]);
    }
    else {
        i--;
    }
}

// Muestra
let primerasCartas = imagenesRandom.slice(0, 6);
let ultimasCartas = imagenesRandom.slice(6);

primerasCartas.forEach(mostrarCartas);
document.body.appendChild(document.createElement("br"));
ultimasCartas.forEach(mostrarCartas);


function mostrarCartas(cartaActual) {
    document.body.appendChild(cartaActual);
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}

// Dar vuelta y comprobación

let girando = false;
let cartasGiradas = [];

function darVuelta(cartaActual) {
    if (girando) {
        return;
    }

    let dorso = cartaActual.getAttribute("src");
    cartaActual.setAttribute("src", cartaActual.getAttribute("valor"));
    cartasGiradas.push(cartaActual);

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
            primerasCartas.forEach(desbloquear);
            ultimasCartas.forEach(desbloquear);

            girando = false;
        }, 1500);
    }
}

    function bloquear() {
        this.removeEventListener("click", darVuelta);
    }

    function desbloquear() {
        this.addEventListener("click", darVuelta);
    }






