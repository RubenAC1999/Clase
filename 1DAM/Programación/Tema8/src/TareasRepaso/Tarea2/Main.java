package TareasRepaso.Tarea2;

public class Main {
    public static void main(String[] args) {
        ConexionDB conexionDB = new ConexionDB("biblioteca", "usuarioGlobal", "abc123.");
        conexionDB.abrirConexion();

        GestorDB baseDatos = new GestorDB(conexionDB.getConexion());

        int respuesta = GestorDB.iniciarPrograma();

        switch (respuesta) {
            case 1:
                baseDatos.anhadirLibro();
                break;

            case 2:
                baseDatos.anhadirAutor();
                break;

            case 3:
                baseDatos.actualizarAutor();
                break;

            case 4:
                baseDatos.mostrarLibrosYAutores();
                break;
        }


    }
}
