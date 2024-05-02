let celda;
let listaCeldas = new Array(9);
let comprobacion = document.getElementById("comprobacion");
let respuesta = "";


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

    // Comprobación grupos

    let bloque = true;
    for (let i = 1; i <= 9; i++) {
        let numeros = [];
        let celdas = document.getElementsByClassName('bloque' + i);
        for (let j = 0; j < celdas.length; j++) {
            let celda = celdas[j];
            if (celda.value == "") {
                let nuevop = document.createElement('p');
                nuevop.innerHTML = 'Una casilla del bloque ' + i + " contiene un espacio en blanco.";
                celda.style.backgroundColor = '#8DF961';
                document.querySelector('footer').appendChild(nuevop);
                bloque = false;

            } else if (isNaN(celda.value) || celda.value == 0) {
                let nuevop = document.createElement('p');
                nuevop.innerHTML = 'Error en el bloque ' + i + '.';
                celda.style.backgroundColor = '#F57757';
                document.querySelector('footer').appendChild(nuevop);
                bloque = false;
            }
        }
    }
}

