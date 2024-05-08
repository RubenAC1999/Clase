let palos = ["oros", "espadas", "copas", "bastos"];

for (let i = 0; i < palos.length; i++) {
    for (let j = 1; j <= 12; j++) {
        let carta = document.createElement("img");
        carta.setAttribute("src", "cartas/" + palos[i].charAt(0) + j + ".jpg");
        carta.setAttribute("palo", palos[i]);
        document.body.appendChild(carta); 
    }
    
}


