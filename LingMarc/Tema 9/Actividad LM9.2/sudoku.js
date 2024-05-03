let celda;
let listaCeldas = new Array(9);
let comprobacion = document.getElementById("comprobacion");


document.getElementById("button").onclick = function comprobar() {
    
    let respuesta = "";
    comprobacion.innerHTML = "";

    //Comprobacion filas // 
    for (let i = 1; i <= 9; i++) {
        listaCeldas.fill(0);
        for (let j = 1; j <= 9; j++) {
            celda = document.getElementById(i + "." + j);
            if (celda.value === "") {
                celda.style.backgroundColor = "#bdf0bb";
                
            } else if (listaCeldas.includes(celda.value)) {
                celda.style.backgroundColor = "#f0bbbb";
                respuesta += "<p>" + celda.id + " se repite en la fila. </p>";

            } else if (isNaN(celda.value)) {
                celda.style.backgroundColor = "#f0bbbb";
            }
            else {
                listaCeldas.push(celda.value);
            }
        }

    }


// Comprobación columnas //

for (let i = 1; i <= 9; i++) {
    listaCeldas.fill(0);
    for (let j = 1; j <= 9; j++) {
        celda = document.getElementById(j + "." + i);
        if (celda.value === "") {
            celda.style.backgroundColor = "#bdf0bb";
        } else if (listaCeldas.includes(celda.value)) {
            celda.style.backgroundColor = "#f0bbbb";
            respuesta += "<p>" + celda.id + " se repite en la columna. </p>";
        } else if (isNaN(celda.value)) {
            celda.style.backgroundColor = "#f0bbbb";
            
        } else {
            listaCeldas.push(celda.value);
        }
    }
}


// Comprobación grupos

for (let bloque = 1; bloque <= 9; bloque++) {
    listaCeldas.fill(0);
    let celdas = document.getElementsByClassName('bloque' + bloque);
    for (let j = 0; j < celdas.length; j++) {
        let celda = celdas[j];
        if (celda.value === "") {
            respuesta += "<p>" + celda.id + " está vacía. </p>";
        } else if (isNaN(celda.value) || celda.value == 0) {
            celda.style.backgroundColor = "#f0bbbb";
            respuesta += "<p>" + celda.id + " tiene error de formato. </p>";
        } else if (listaCeldas.includes(celda.value)) {
            celda.style.backgroundColor = "#f0bbbb";
            respuesta += "<p>" + celda.id + " se repite en el bloque. </p>";
        } else {
            listaCeldas.push(celda.value);
            celda.style.backgroundColor = "";
        }
    }

}
comprobacion.innerHTML = respuesta;

}

