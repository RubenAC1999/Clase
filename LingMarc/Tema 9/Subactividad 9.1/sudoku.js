let celda;

document.getElementById("button").onclick = function comprobar() {
    for (let i = 1; i <= 9; i++) {
        for(let j = 1; j <= 9; j++) {
            celda = document.getElementById(i + "." + j);

            if(isNaN(celda.value)) {
                celda.style.backgroundColor = "#f0bbbb";
            }
            else if (celda.value > 0) {
                celda.style.backgroundColor = "";
            }
            else {
                celda.style.backgroundColor = "#bdf0bb";
            }
        }       
    }   
}

