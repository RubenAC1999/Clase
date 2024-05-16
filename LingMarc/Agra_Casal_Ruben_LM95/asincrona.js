
/*Completa el resto de esta función para que cree una tabla, con las cabeceras y los datos del JSON*/
function crearTabla(responseText){
    const datosTabla = JSON.parse(responseText);
    document.createElement("table");
    document.table.appendChild(document.createElement("tr"));

    let titulo = document.createElement("th");
    titulo = document.createTextNode("Título");
    document.tr.appendChild(titulo);

    let ventas = document.createElement("th");
    titulo = document.createTextNode("Ventas");
    document.tr.appendChild(ventas);

    let fechaSalida = document.createElement("th");
    titulo = document.createTextNode("Fecha salida");
    document.tr.appendChild(fechaSalida);


    for(let i = 0; i < datosTabla.titulo.length; i++) {
        let dato = document.createElement("td");
        dato.innerHTML(datosTabla.titulo[i]);
    }
    
}

let boton = document.getElementById("busqueda");

function leerJSON(){
    peticion = new XMLHttpRequest();
    peticion.onreadystatechange = function() {
        if (this.readyState == 4) {
            if (this.status == 200)
                crearTabla(this.responseText);
            else
                document.querySelector('div').innerHTML = "Error al acceder al fichero";
        }
    };
    peticion.open("GET", json.value , true);
    peticion.send();
}
