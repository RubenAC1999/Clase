let celda;

document.getElementById("button").onclick = function comprobar() {
    for (let i = 1; i <= 9; i++) {
        for (let j = 1; j <= 9; j++) {
            celda = document.getElementById(i + "." + j);

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
    }
}



for (let i = 1; i <= 9; i++) {
    for (let j = 1; j <= 9; j++) {
        let celda = document.getElementById(i + "." + j).onclick = function () {
            sombrear(this);
        }
    }
}


function colorPredeterminado() {
    for (let i = 1; i <= 9; i++) {
        for (let j = 1; j <= 9; j++) {
            celda = document.getElementById(i + "." + j);
            celda.style.backgroundColor = "";

        }
    }
}

    function sombrear(celda) {
        colorPredeterminado();
        let fila = parseInt(celda.id.charAt(0));
        let columna = parseInt(celda.id.charAt(2));

        for (let i = 1; i <= 9; i++) {
            let celdasFila = document.getElementById(fila + "." + i);
            let celdasColumna = document.getElementById(i + "." + columna);
            celda.style.backgroundColor = "#9bdbd4";
            celdasFila.style.backgroundColor = "#c9e8e1";
            celdasColumna.style.backgroundColor = "#c9e8e1";
        }

        /* -- FILAS 1-3 -- */

        if ((fila >= 1) && (fila < 4)) {
            if ((columna >= 1) && (columna < 4)) {
                for (let i = 1; i < 4; i++) {
                    for (let j = 1; j < 4; j++) {
                        let celdaGrupo = document.getElementById(i + "." + j);
                        celdaGrupo.style.backgroundColor = "#c9e8e1";
                    }
                }
            }
            if ((columna >= 4) && (columna < 7)) {
                for (let i = 1; i < 4; i++) {
                    for (let j = 4; j < 7; j++) {
                        let celdaGrupo = document.getElementById(i + "." + j);
                        celdaGrupo.style.backgroundColor = "#c9e8e1";
                    }
                }
            }
            if ((columna >= 7) && (columna < 10)) {
                for (let i = 1; i < 4; i++) {
                    for (let j = 7; j < 10; j++) {
                        let celdaGrupo = document.getElementById(i + "." + j);
                        celdaGrupo.style.backgroundColor = "#c9e8e1";
                    }
                }
            }
        
        }

         /* -- FILAS 4-7 -- */

        if ((fila >= 4) && (fila < 7)) {
            if ((columna >= 1) && (columna < 4)) {
                for (let i = 4; i < 7; i++) {
                    for (let j = 1; j < 4; j++) {
                        let celdaGrupo = document.getElementById(i + "." + j);
                        celdaGrupo.style.backgroundColor = "#c9e8e1";
                    }
                }
            }
            if ((columna >= 4) && (columna < 7)) {
                for (let i = 4; i < 7; i++) {
                    for (let j = 4; j < 7; j++) {
                        let celdaGrupo = document.getElementById(i + "." + j);
                        celdaGrupo.style.backgroundColor = "#c9e8e1";
                    }
                }
            }
            if ((columna >= 7) && (columna < 10)) {
                for (let i = 4; i < 7; i++) {
                    for (let j = 7; j < 10; j++) {
                        let celdaGrupo = document.getElementById(i + "." + j);
                        celdaGrupo.style.backgroundColor = "#c9e8e1";
                    }
                }
            }
        
        }

         /* -- FILAS 7-9 -- */

        if ((fila >= 7) && (fila < 10)) {
            if ((columna >= 1) && (columna < 4)) {
                for (let i = 7; i < 10; i++) {
                    for (let j = 1; j < 4; j++) {
                        let celdaGrupo = document.getElementById(i + "." + j);
                        celdaGrupo.style.backgroundColor = "#c9e8e1";
                    }
                }
            }
            if ((columna >= 4) && (columna < 7)) {
                for (let i = 7; i < 10; i++) {
                    for (let j = 4; j < 7; j++) {
                        let celdaGrupo = document.getElementById(i + "." + j);
                        celdaGrupo.style.backgroundColor = "#c9e8e1";
                    }
                }
            }
            if ((columna >= 7) && (columna < 10)) {
                for (let i = 7; i < 10; i++) {
                    for (let j = 7; j < 10; j++) {
                        let celdaGrupo = document.getElementById(i + "." + j);
                        celdaGrupo.style.backgroundColor = "#c9e8e1";
                    }
                }
            }
        
        }
    }