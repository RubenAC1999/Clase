let celda;

for (let i = 1; i <= 9; i++) {
    for (let j = 1; j <= 9; j++) {
        let celda = document.getElementById(i + "." + j).onblur = function() {
            comprobar(this);
        }
    }
}

function comprobar(celda) {
    if (isNaN(celda.value)) {
        celda.style.backgroundColor = "#f0bbbb";
    }
    else if (celda.value > 0) {
        celda.style.backgroundColor = "";
    }
    else {
        celda.style.backgroundColor = "#bdf0bb";
    }
}





