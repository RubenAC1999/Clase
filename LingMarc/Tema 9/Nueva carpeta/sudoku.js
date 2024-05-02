let celda;
let listaCeldas = new Array(9);
let comprobacion = document.getElementById("comprobacion");

document.getElementById("button").onclick = function comprobar() {

    //Comprobacion filas // 
    for (let i = 1; i <= 9; i++) {
        listaCeldas.fill(0);
        for (let j = 1; j <= 9; j++) {
            celda = document.getElementById(i + "." + j);
            for (let k = 0; k < 9; k++) {
                if (celda.value === "") {
                celda.style.backgroundColor = "#bdf0bb";
                } else if (listaCeldas[k] == celda.value) {
                    celda.style.backgroundColor = "#f0bbbb";
                    comprobacion.innerHTML = celda.id + " se repite";
                    
                } else if (isNaN(celda.value)) {
                    celda.style.backgroundColor = "#f0bbbb";
                }
                else {
                    listaCeldas[k] = celda.value;
                }
            }

        }
    }

    // Comprobación columnas //
    
    for (let i = 1; i <= 9; i++) {
        listaCeldas.fill(0);
        for (let j = 1; j <= 9; j++) {
            celda = document.getElementById(j + "." + i);
            for (let k = 0; k < 9; k++) {
                if (celda.value === "") {
                    celda.style.backgroundColor = "#bdf0bb";
            } else if (listaCeldas[k] == celda.value) {
                    celda.style.backgroundColor = "#f0bbbb";
                    comprobacion.innerHTML = celda.id + " se repite";
                } else {
                    listaCeldas[k] = celda.value;
                }
            }
        }
    }

    // Comprobación grupos // 

    for (let i = 1; i <= 9; i++) {
        let bloque = document.getElementsByClassName("bloque" + i);

        listaCeldas.fill(0);

        
    }
}
