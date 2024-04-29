let listaCeldas = new Array();

for (let i = 1; i <= 9; i++) {
    for (let j = 1; j <= 9; j++) {
        let celda = document.getElementById(i + "." + j);
        listaCeldas.push(celda);
    }
}

for (let i = 0; i < listaCeldas.length; i++) {
    listaCeldas[i].onblur = comprobacion;
}

function comprobacion() {
    for (let i = 0; i < listaCeldas.length; i++) {
        if (isNaN(listaCeldas[i].value)) {
            listaCeldas[i].style.backgroundColor = "#f0bbbb";
        }
        else if (listaCeldas[i].value > 0) {
            listaCeldas[i].style.backgroundColor = "";
        }
        else {
            listaCeldas[i].style.backgroundColor = "#bdf0bb";
        }
    }

}



