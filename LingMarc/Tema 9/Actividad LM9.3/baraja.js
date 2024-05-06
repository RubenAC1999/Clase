cartas = document.createElement("p")
let palos = ["oros", "espadas", "copas", "bastos"];
let string = "";
 


for (let i = 0; i < palos.length; i++) {
    for (let j = 1; j <= 12; j++) {
        string = string.concat(palos(i), j);
        console.log(string);
        cartas.setAttribute("class", palos[i] + j)
    }
}

