let palos = ["oros", "espadas", "copas", "bastos"];
carta = document.createElement("p");
let string = ""; 

for (let i = 0; i < palos.length; i++) {
    for (let j = 1; j <= 12; j++) {
       carta = createElement("p");
       carta.setAttribute("palo", palos[i]);
       carta.document.createTextNode(palos[i] + j);
    }
}


